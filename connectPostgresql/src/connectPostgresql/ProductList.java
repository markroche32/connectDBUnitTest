package connectPostgresql;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ProductList")
@XmlAccessorType(XmlAccessType.FIELD) 
public class ProductList {

	@XmlElement(name = "Products")
	private ArrayList<Products> prod = null;

	public ArrayList<Products> getProd() {

		return prod;
	}

	public void setProd(ArrayList<Products> prod) {

		this.prod = prod;
	}

}
