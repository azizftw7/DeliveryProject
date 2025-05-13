package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

/**
 * Servlet implementation class ScanQRCodeServlet
 */
@WebServlet("/ScanQRCodeServlet")
public class ScanQRCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScanQRCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String qrCode = request.getParameter("code");

        if (qrCode != null && !qrCode.isEmpty()) {
                        ProductDAO productDAO = new ProductDAO();

           
            Product product = productDAO.getProductByQRCode(qrCode);

            if (product != null && !"bought".equals(product.getStatus())) {
                
                productDAO.updateProductStatusToBought(product);
                request.setAttribute("product", product);
                request.getRequestDispatcher("/WEB-INF/bill.jsp").forward(request, response);
            } else {
                
                response.sendRedirect("error.jsp");
            }
        } else {
          
            response.sendRedirect("error.jsp");
        }
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
