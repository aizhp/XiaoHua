<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="game.Game" %>
<%
		Game game=(Game)session.getAttribute("game");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>猜字数字游戏</title>
    
	

  </head>
<script type="text/javascript">
	function vaildate(guessform){
	if(guessform.guessNum.value.lenght==0){
		alert("请输入你要猜的数！");
		guessform.guessNum.select();
		return false;
	}
	if(isNaN(guessform.guessNum.value)){
	alert("请输入数字！");
	guessform.guessNum.select();
	return false;
	
	}
	return true;
	}


</script>  
  <body onload="document.forms[0].usernumber.select()">
    <h3 align="center">猜数字游戏</h3>
    <hr>
    <% 
    	if(!game.isSuccess()){
    %>
    
    请输入1-100的数字。
    
    <form action="/XiaoHua/gameServlet" method="post" onsubmit="return vaildate(this)">
    	<table width="50%" align="center" border="1">
    	 	<tr align="center">
    	 		<td align="center">请输入数字：</td>
    	 		<td><input type="text" name="usernumber"></td>
    		</tr>
    		<tr align="center" valign="center">
    			<td colspan="2" align="center">
    				<input type="submit" value="确定">
    				<input type="reset" value="重置">
    			</td>
    		</tr>
    	</table>
    </form>
    <% 
    	} 
    %>
    
    <%
    	if(game.getMessage()!=null){
    
     %>
    <h3 align="center"><font color="red"><%=game.getMessage() %></font></h3>
    <%
    	}
     %>
    
    <p>
    	第<%=game.getTimes() %>次。
    	
    	<%
    		if(game.isSuccess()){
    	 %>
    	 <a href="/XiaoHua/gameServlet">再玩一次</a>
    	 <% 
    	 	}
    	 %>
    	 
    	 
    	 
  </body>
</html>
