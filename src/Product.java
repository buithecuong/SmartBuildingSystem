
public class Product {
	String name;
	int quantity;
	
	public Product(String name, int quantity) {
		super();
		this.name = name;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", quantity=" + quantity + "]";
	}
	
	

}
