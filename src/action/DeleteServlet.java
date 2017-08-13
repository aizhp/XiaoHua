package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import service.UserService;

public class DeleteServlet extends HttpServlet {
	protected void service(HttpServletRequest arg0,HttpServletResponse arg1)
		throws ServletException,IOException{
		arg1.setContentType("text/html");
		arg0.setCharacterEncoding("GBK");
		arg1.setCharacterEncoding("GBK");
		
		String name = arg0.getParameter(uname);
		UserService service=new UserService();
		service.deleteUser(name);
		try {
			arg0.getRequestDispatcher("/query").forward(arg0, arg1);
		} catch (Exception e) {
			// TODO: handle exception
			arg0.getRequestDispatcher("/login.html").forward(arg0, arg1);
		}
	}
}
