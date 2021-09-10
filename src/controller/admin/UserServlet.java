package controller.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.UserDAO;
import entity.User;
import utils.HelperUtils;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet({
	"/admin/users",
	"/admin/users/edit",
	"/admin/users/update",
	"/admin/users/delete",
})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UserDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        this.dao = new UserDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("edit")) {
			this.edit(request, response);
		} else if (uri.contains("create")) {
			//
		} else if (uri.contains("delete")) {
			this.delete(request, response);
		} else {
			this.index(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		if (uri.contains("update")) {
			this.update(request, response);
		} else {
			// 404
			//this.index(request, response);
		}
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		User entity = new User();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dao.update(entity);
		response.sendRedirect(request.getContextPath()+"/admin/users");
	}


	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("listUser", this.dao.getAll());
		request.getRequestDispatcher("/views/admin/users/index.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String str = request.getParameter("id");
		if(!HelperUtils.checkNumber(str)) {
			response.sendRedirect(request.getContextPath()+"/admin/users");
		}
		int id = Integer.parseInt(str);
		this.dao.remove(id);
		response.sendRedirect(request.getContextPath()+"/users");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String str = request.getParameter("id");
		if(!HelperUtils.checkNumber(str)) {
			response.sendRedirect(request.getContextPath()+"/admin/users");
		}
		int id = Integer.parseInt(str);
		User entity = this.dao.findById(id);
		request.setAttribute("user", entity);
		request.getRequestDispatcher("/views/admin/users/edit.jsp").forward(request, response);
	}

}
