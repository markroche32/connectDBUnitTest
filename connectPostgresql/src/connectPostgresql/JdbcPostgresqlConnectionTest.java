package connectPostgresql;

import static org.junit.Assert.*;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JdbcPostgresqlConnectionTest {

	@BeforeClass
	public static void setUp() throws Exception {
		
		JdbcPostgresqlConnection.main(null);
	}

	
	@Test
	public void testProductList() throws JAXBException {
		
		assertEquals(2, JdbcPostgresqlConnection.getList().size());
		
	}
	
	
	@Test
	public void testProductListNames() throws JAXBException {
		
		assertEquals(1, JdbcPostgresqlConnection.getList().get(0).productID);
		assertEquals("Toyota Carolla", JdbcPostgresqlConnection.getList().get(0).name);
		
		assertEquals(2, JdbcPostgresqlConnection.getList().get(1).productID);
		assertEquals("Toyota Avensis", JdbcPostgresqlConnection.getList().get(1).name);
		
	}
	

}
