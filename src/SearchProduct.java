

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchProduct
 */
@WebServlet("/SearchProduct")
public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "No data found";
		String prodName = request.getParameter("prodname");
		Float sum = 0f;
		String[] prodNames = null;
		Scanner scanner = null;
		List<Product> prodList = new ArrayList<>();
		Map<Integer, Float> priceList = new HashMap<Integer, Float>();
		List<Integer> shopIdss = new ArrayList<Integer>();
		Map<Integer,Boolean> containsProd = new HashMap<Integer, Boolean>();
		Boolean flag =false;
		try {
			// read csv data file 
			String csvFile = "/data.csv";
			int i=0;
	        scanner = new Scanner(new File(csvFile));
	        while (scanner.hasNext()) {
	        	Product prd = new Product();
	        	// read csv data file line by line
	            List<String> line = CSVUtils.parseLine(scanner.nextLine());
	            System.out.println("Data [id= " + line.get(0) + ", code= " + line.get(1) + " , name=" + line.get(2) + "]");
	            prd.setShopId(Integer.parseInt(line.get(0)));
	            prd.setPrice(Float.parseFloat(line.get(1)));
	            prd.setProdName(line.get(2));
	            prodList.add(prd);
	            if(!shopIdss.contains(Integer.parseInt(line.get(0))))
	            	shopIdss.add(Integer.parseInt(line.get(0)));
				i++;
	        }
	        // close reader
	        scanner.close();
	        
			if (prodName.contains(",")) {
				prodNames = prodName.split(",");
			}else{
				prodNames =new String[]{prodName};
			}
			
			// calculate price for products
			for(int id :shopIdss){
				sum=0f;
				for (String s : prodNames) {
					System.out.println("s..."+s);
					for(Product p:prodList){
						if(id==p.getShopId()){
							if(p.getProdName().contains(s)){
								sum = sum + p.getPrice();
								priceList.put(p.getShopId(), sum);
								containsProd.put(p.getShopId(), true);
							}else{
								containsProd.put(p.getShopId(), false);
							}
						}
						
					}
				}
			}
			// get min price
			Entry<Integer, Float> min = null;
			for (Entry<Integer, Float> entry : priceList.entrySet()) {
				System.out.println("val.."+entry.getValue());
				if (min == null || min.getValue() > entry.getValue()) {
					min = entry;
				}
			}
			result = min.getKey() + "," + min.getValue();
			
			if(containsProd.containsKey(min.getKey())){
				System.out.println("min.getKey()...."+min.getKey());
				flag = containsProd.get(min.getKey());
				System.out.println("flg...."+flag);
				if(!flag)
					result = "none";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//display output
		PrintWriter out = response.getWriter();
		out.println("<h1>" + result + "</h1>");
	}

}
