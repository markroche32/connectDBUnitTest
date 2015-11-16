package connectPostgresql;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Products")
public class Products {

	int productID;
	int brandID;
	String name;
	String description;
	
	
	public int getProductID() {
		return productID;
	}
	
	@XmlAttribute
	public void setProductID(int productID) {
		this.productID = productID;
	}
	
	public int getBrandID() {
		return brandID;
	}
	
	
	@XmlElement
	public void setBrandID(int brandID) {
		this.brandID = brandID;
	}
	
	public String getName() {
		return name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

}