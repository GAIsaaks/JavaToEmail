package com.kvtrades.sendMessage.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kvtrades.sendMessage.web.SendEmail;

@WebServlet("/")
public class SendMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private String userEmail;
	private String msgSubject;
	private String msgBody;
	private String appEmail = "gmefam@gmail.com";
	private String appPassword = "gmefamgr2";
	//private String msgSubject;
       
    public SendMessageController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getServletPath();
		
		switch (uri) {
			case "/":
				loadIndex(request, response);
			break;
			case "/sendMessage":
				sendMessage(request, response);
			break;
			
			default:
				loadIndex(request, response);
			break;
		}
		
	}

	private void loadIndex(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispacter = request.getRequestDispatcher("index.jsp");
		dispacter.forward(request, response);
	}

	public void sendMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("fname");
		String email = req.getParameter("email");
		String subject = req.getParameter("subject");
		String msg = req.getParameter("msg");
		SendEmail sendMail = new SendEmail(username, email, subject, msg);
		if (sendMail.sendMail() == true) {
			RequestDispatcher dispacter = req.getRequestDispatcher("index.jsp?msg=success");
			dispacter.forward(req, res);
		}
		RequestDispatcher dispacter = req.getRequestDispatcher("index.jsp?msg=error");
		dispacter.forward(req, res);		
	}
}
