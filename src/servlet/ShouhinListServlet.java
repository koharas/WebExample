package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shouhin;
import model.ShouhinDAO;

/**
 * Servlet implementation class ShouhinListServlet
 */
@WebServlet("/slist")
public class ShouhinListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShouhinListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShouhinDAO dao = new ShouhinDAO();
		ArrayList<Shouhin> slist = dao.findAll();

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>商品</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		out.println("<tr><th>商品ID</th><th>商品名</th><th>単価</th></tr>");

		for( Shouhin s : slist) {
			out.println("<tr>");
			out.println("<td>" + s.getSid() + "</td>");
			out.println("<td>" + s.getSname() + "</td>");
			out.println("<td>" + s.getTanka() + "円</td>");
			out.println("</tr>");
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
