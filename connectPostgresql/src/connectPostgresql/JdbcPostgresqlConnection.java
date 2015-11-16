package connectPostgresql;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class JdbcPostgresqlConnection {
	
	private static Connection conn = null;
	private static ArrayList<Products> list = new ArrayList<Products>();
	
	public static void main(String[] args) throws JAXBException {
    
        try {
            String dbURL3 = "jdbc:postgresql://localhost:5432/Cars";
            Properties parameters = new Properties();
            parameters.put("user", "postgres");
            parameters.put("password", "pass");
 
            conn = DriverManager.getConnection(dbURL3, parameters);
            if (conn != null) {
            	
                System.out.println("Connected to database");
                doWork();
               
        		for(Products p : list){
        			
        			System.out.println("productID = " + p.productID + " brandID = " + p.brandID);
        		}
        		
        		
        		printDataXML();
            }
 
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


	private static void doWork() throws SQLException {
		
    	String sql = "SELECT * FROM Products";
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            
            while (rs.next()) {
            	
                list.add(processRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
		} finally {
			
			conn.close();
		}
		
	}

	private static Products processRow(ResultSet rs) throws SQLException  {

		Products product = new Products();
		product.setProductID(rs.getInt("productID"));
		product.setBrandID(rs.getInt("brandID"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		
		return product;

	}
	
	
	private static void printDataXML() throws JAXBException {
		
		ProductList prods = new ProductList();
		prods.setProd(list);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(ProductList.class);
	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	 
	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	     
	    //Marshal the employees list in console
	    jaxbMarshaller.marshal(prods, System.out);
	     
	    //Marshal the employees list in file
	    jaxbMarshaller.marshal(prods, new File("c:/Users/mark1983/Desktop/employees.xml"));

	}
	
	  
	public static ArrayList<Products> getList() {
			
		return list;
		
	}

		
	public static void setList(ArrayList<Products> list) {
			
		JdbcPostgresqlConnection.list = list;
		
	}

}
