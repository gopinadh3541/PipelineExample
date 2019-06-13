package com.capgemini.ui;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import com.capgemini.bean.BankBean;*/

/**
 * Servlet implementation class BankApplication
 */
public class BankApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		/*BankBean bean=new BankBean();*/
		
		
		String number = request.getParameter("accnumber");
		String bank = request.getParameter("name");
		String amount = request.getParameter("amount");
		String function=request.getParameter("function");

		System.out.println(function);
		
		if(bank==null && function==null)
		{
			add(number,amount);
		}
		else if(function==null)
		{
			transfer(number,amount,bank);
		}
		else
		{
			long s=withdraw(amount);
			System.out.println(s);
		}
	}

	public long withdraw(String amount) {
		
		Long amt=Long.valueOf(amount);
		long bal=100000-amt;
		System.out.println(bal);
		
	
		return bal;
		
	}

	private void transfer(String number, String amount, String bank) {
		
		
	}

	private void add(String number, String amount) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");

		if (uname.equals(pwd) && uname != "") {
			
			/*System.out.println("Password is: "+pwd);
			byte[] encrypt =Base64.getEncoder().encode(pwd.getBytes());
			System.out.println("Encrypted text is: "+ new String(encrypt));
			
			byte[] decrypt=Base64.getDecoder().decode(encrypt);
			System.out.println("Decrypted text is: "+ new String(decrypt));
			*/
			
			
			response.sendRedirect("menu.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("key", "Please Enter Correct Username or Password");
			response.sendRedirect("index.jsp");
		}

	}

}
