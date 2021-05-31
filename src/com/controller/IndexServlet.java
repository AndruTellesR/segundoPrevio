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

import com.dao.CandidatoDao;
import com.entity.Candidato;

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
			default:
				list(request, response);
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
		if (dao == null) {
			init();
		}
		List<Candidato> list = dao.list();
		request.setAttribute("listCandidato", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidatoList.jsp");
		dispatcher.forward(request, response);
	}

	private void showViewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request, response);
	}

	private void insert(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

	}

	private void showEdit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

	}

}
