package controller.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.DanhMucDAO;
import entity.DanhMuc;
import utils.HelperUtils;

/**
 * Servlet implementation class DanhMucServlet
 */
@WebServlet({
	"/admin/danhmuc",
	"/admin/danhmuc/edit",
	"/admin/danhmuc/update",
	"/admin/danhmuc/delete",
	"/admin/danhmuc/store"
})
public class DanhMucServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DanhMucDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhMucServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.dao = new DanhMucDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("edit")) {
			this.edit(request, response);
		}else if (uri.contains("delete")) {
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
		}else if(uri.contains("store")){
			this.store(request,response);
		} else {
			// 404
			//this.index(request, response);
		}
	}
	
	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		DanhMuc entity = new DanhMuc();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dao.create(entity);
		response.sendRedirect(request.getContextPath()+"/admin/danhmuc");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		DanhMuc entity = new DanhMuc();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dao.update(entity);
		response.sendRedirect(request.getContextPath()+"/admin/danhmuc");
	}


	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("list", this.dao.getAll());
		request.getRequestDispatcher("/views/admin/danhmuc/index.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String str = request.getParameter("id");
		if(!HelperUtils.checkNumber(str)) {
			response.sendRedirect(request.getContextPath()+"/admin/danhmuc");
		}
		int id = Integer.parseInt(str);
		this.dao.remove(id);
		response.sendRedirect(request.getContextPath()+"/admin/danhmuc");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String str = request.getParameter("id");
		if(!HelperUtils.checkNumber(str)) {
			response.sendRedirect(request.getContextPath()+"/admin/danhmuc");
		}
		int id = Integer.parseInt(str);
		DanhMuc entity = this.dao.findById(id);
		request.setAttribute("danhmuc", entity);
		request.getRequestDispatcher("/views/admin/danhmuc/edit.jsp").forward(request, response);
	}
}
