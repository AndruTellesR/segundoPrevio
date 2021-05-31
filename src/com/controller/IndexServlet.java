package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.*;
import com.entity.*;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CandidatoDao dao;

	public IndexServlet() {
	}

	////////////////////////////////////////////////
	/// Method
	////////////////////////////////////////////////
	public void init() throws ServletException {
		dao = new CandidatoDao();
	}

	////////////////////////////////////////////////
	/// Method - Override
	////////////////////////////////////////////////
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/new":
				showViewForm(request, response);
				break;
			case "/insert":
				insert(request, response);
				break;
			case "/delete":
				delete(request, response);
				break;
			case "/edit":
				showEdit(request, response);
				break;
			case "/update":
				update(request, response);
				break;
				
			case "/list":
				list(request, response);
				break;
			default:
				showViewForm(request, response);
				break;
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	////////////////////////////////////////////////
	/// Method
	////////////////////////////////////////////////
	private void list(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		String eleccion = request.getParameter("eleccion");
		if (dao == null) {
			init();
		}
		System.out.println(eleccion);

		List<Candidato> list = (eleccion != null) ? dao.list(eleccion) : dao.list();
		request.setAttribute("listCandidato", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidatoList.jsp");
		dispatcher.forward(request, response);
	}

	private void showViewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EleccionDao eDao = new EleccionDao();
		List<Eleccion> list = eDao.list();
		request.setAttribute("listEleccion", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		System.out.println("ssss");
		String id = request.getParameter("id");
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String eleccion = request.getParameter("eleccion");
		String numero = request.getParameter("numero");
		
		System.out.println(id);
		System.out.println(documento);
		System.out.println(nombre);
		System.out.println(apellido);
		System.out.println(eleccion);
		System.out.println(numero);

		Candidato c = new Candidato(Integer.parseInt(id), documento, nombre, apellido, Integer.parseInt(eleccion),
				Integer.parseInt(numero));
		if (dao == null) {
			init();
		}
		dao.insert(c);
		System.out.println("Insert");
		response.sendRedirect("list");
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String id = request.getParameter("id");
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String eleccion = request.getParameter("eleccion");
		String numero = request.getParameter("numero");
		Candidato c = new Candidato(Integer.parseInt(id), documento, nombre, apellido, Integer.parseInt(eleccion),
				Integer.parseInt(numero));
		if (dao == null) {
			this.init();
		}
		dao.update(c);
		response.sendRedirect("list");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		String id = request.getParameter("id");
		if (dao == null) {
			this.init();
		}
		dao.delete(Integer.parseInt(id));
		response.sendRedirect("list");
	}

	private void showEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String id = request.getParameter("id");
		if (dao == null) {
			this.init();
		}
		Candidato c =  dao.find(id);
		EleccionDao eDao = new EleccionDao();
		List<Eleccion> list = eDao.list();
		request.setAttribute("listEleccion", list);
		request.setAttribute("candidato", c);
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
	}

}
