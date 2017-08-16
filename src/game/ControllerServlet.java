package game;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerServlet extends HttpServlet {
		public ControllerServlet(){
			super();
		}
		public void destroy(){
			super.destroy();
		}
		
		public void init() throws ServletException{
				
		}
		
		
		public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			
			doPost(request, response);			
		}
		
		
		public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
			String usernumber=request.getParameter("usernumber");
			HttpSession session = request.getSession();
			Game game = new Game();
			if(usernumber==null){
				
				game.reset();
				session.setAttribute("game", game);
			}else{
				game=(Game)session.getAttribute("game");
				game.setUsernumber(Integer.parseInt(usernumber));
				game.guess();
				
				
			}
			response.sendRedirect("/XiaoHua/game.jsp");
		}
}
