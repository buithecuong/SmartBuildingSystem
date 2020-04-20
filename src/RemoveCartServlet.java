import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/removeProd")
public class RemoveCartServlet extends HttpServlet {
	public void doMethod(HttpServletRequest request, HttpServletResponse response)
	{
		String pName = request.getParameter("pName");
		int pQty =Integer.parseInt(request.getParameter("pQty"));
		if(request.getSession().getAttribute("cart")==null)
		{
			ArrayList<Product> productsInCart= new ArrayList<Product>();
			request.getSession().setAttribute("cart", productsInCart);
		}
		Object products = request.getSession().getAttribute("cart");
		ArrayList<Product> productsInCart= (ArrayList<Product>) products;
		System.out.println("*** Before Remove Product***");
		for(Product p : productsInCart)
		{
			System.out.println(p.toString());
		}
				
		System.out.println("*** After Remove Product***");
		
		for(Product p : productsInCart)
		{
			if (p.name.equalsIgnoreCase(pName.toLowerCase()) )
			{

				int index = productsInCart.indexOf(p);
				productsInCart.remove(p);
				if( p.quantity > pQty)
				{
					Product prod1 = new Product(pName, p.quantity - pQty);
					productsInCart.add(index, prod1);
				}
				break;
			}
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
