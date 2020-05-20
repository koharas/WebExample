package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import model.MemberDAO;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/mupdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String midStr = request.getParameter("mid");
		int mid = Integer.parseInt(midStr);

		MemberDAO dao = new MemberDAO();
		Member m = dao.findByMid(mid);

		request.setAttribute("member", m);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/mupdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if( action.equals("update") ) {
			String midStr = request.getParameter("mid");
			int mid = Integer.parseInt(midStr);
			String name = request.getParameter("name");
			String adr = request.getParameter("adr");

			MemberDAO dao = new MemberDAO();
			Member m = new Member(mid, name,adr);
			dao.update(m);
		}else if( action.equals("del") ) {
			String midStr = request.getParameter("mid");
			int mid = Integer.parseInt(midStr);

			MemberDAO dao = new MemberDAO();
			dao.delete(mid);
		}
		response.sendRedirect("mlist");
	}

}
