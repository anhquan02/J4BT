package controller.admin;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.DanhMucDAO;
import dao.SanPhamDAO;
import entity.DanhMuc;
import entity.SanPham;
import utils.HelperUtils;

/**
 * Servlet implementation class SanPhamServlet
 */
@WebServlet({
	"/admin/sanpham",
	"/admin/sanpham/edit",
	"/admin/sanpham/update",
	"/admin/sanpham/delete",
	"/admin/sanpham/store",
	"/admin/sanpham/create"
})
public class SanPhamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private SanPhamDAO dao;
    private DanhMucDAO dmDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SanPhamServlet() {
        super();
        this.dao = new SanPhamDAO();
        this.dmDAO = new DanhMucDAO();
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
			this.create(request,response);
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
		String uri = request.getRequestURI();
		if (uri.contains("update")) {
			this.update(request, response);
		}else if(uri.contains("store")) {
			this.store(request,response);
		} else {
			// 404
//			this.index(request, response);
		}
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		request.setAttribute("listDM", this.dmDAO.getAll());
		request.getRequestDispatcher("/views/admin/sanpham/create.jsp").forward(request, response);
	}
	
	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		SanPham entity = new  SanPham();
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			int dmID = Integer.parseInt(request.getParameter("danhMucId"));
			DanhMuc dm = this.dmDAO.findById(dmID);
			entity.setDanhMuc(dm);
			entity.setNgayNhap(new Date());
			entity.setIsActived(false);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dao.create(entity);
		
		response.sendRedirect(request.getContextPath()+"/admin/sanpham");
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String str = request.getParameter("id");
		if(!HelperUtils.checkNumber(str)) {
			response.sendRedirect(request.getContextPath()+"/admin/sanpham");
		}
		int id = Integer.parseInt(str);
		SanPham entity = this.dao.findById(id);
		try {
			BeanUtils.populate(entity, request.getParameterMap());
			int dmID = Integer.parseInt(request.getParameter("danhMucId"));
			DanhMuc dm = this.dmDAO.findById(dmID);
			entity.setDanhMuc(dm);
		} catch (IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
		}
		this.dao.update(entity);
		response.sendRedirect(request.getContextPath()+"/admin/sanpham");
	}


	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("listSP", this.dao.getAll());
		request.getRequestDispatcher("/views/admin/sanpham/index.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String str = request.getParameter("id");
		if(!HelperUtils.checkNumber(str)) {
			response.sendRedirect(request.getContextPath()+"/admin/sanpham");
		}
		int id = Integer.parseInt(str);
		this.dao.remove(id);
		response.sendRedirect(request.getContextPath()+"/admin/sanpham");
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		String str = request.getParameter("id");
		if(!HelperUtils.checkNumber(str)) {
			response.sendRedirect(request.getContextPath()+"/admin/sanpham");
		}
		int id = Integer.parseInt(str);
		SanPham entity = this.dao.findById(id);
		request.setAttribute("item", entity);
		request.setAttribute("listDM", this.dmDAO.getAll());
		request.getRequestDispatcher("/views/admin/sanpham/edit.jsp").forward(request, response);
	}

}
