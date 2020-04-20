import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addProd")
public class AddCartServlet extends HttpServlet{

	public void doMethod(HttpServletRequest request, HttpServletResponse response)
	{
		String pName = request.getParameter("pName");
		int pQty =Integer.parseInt(request.getParameter("pQty"));
		ArrayList<Product> productsInCart;
		if(request.getSession().getAttribute("cart")==null)
		{
			productsInCart= new ArrayList<Product>();
			request.getSession().setAttribute("cart", productsInCart);
		}
		Object products = request.getSession().getAttribute("cart");
		productsInCart= (ArrayList<Product>) products;
		
		Product prod = new Product(pName, pQty);
		System.out.println("*** Before Add Product***");
		
		for(Product p : productsInCart)
		{
			System.out.println(p.toString());
		}
		
		System.out.println("*** After Add Product***");
		
		Product prod1;
		boolean isExistingProd = false;
		for(Product p : productsInCart)
		{
			if (p.name.equalsIgnoreCase(pName.toLowerCase()) )
			{
				isExistingProd = true;
				int index = productsInCart.indexOf(p);
				productsInCart.remove(p);
				prod1 = new Product(pName, p.quantity + pQty);
				productsInCart.add(index, prod1);
				break;
			}
			
		}
		if(!isExistingProd)
		{
			prod1 = new Product(pName,  pQty);
			productsInCart.add(prod1);
		}
		for(Product p : productsInCart)
		{
			System.out.println(p.toString());
		}
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	{
		doMethod(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	{
		doMethod(request, response);
	}
}
