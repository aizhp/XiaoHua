package game;

import java.awt.AWTError;
import java.io.Serializable;
import java.util.Random;

public class Game implements Serializable {
	private int usernumber;//储存输入的数
	private int answer;//被猜的数
	private boolean success;//
	private int times;//记录猜的次数
	private String message;//猜数反馈消息
	
	public void reset(){
		answer=getAnswer();//生成随机数保存
		message=null;
		times=0;
		success=false;
	}

	private int getAnswer() {
		// TODO Auto-generated method stub
		int answer=new Random().nextInt();//生成随机数
		answer = Math.abs(answer)%100+1;//生成数 1-100
		return answer;
	}
	
	public void guess(){
		times++;
		if(usernumber==answer){
			success=true;
			message="恭喜你，猜对了。";
		}else if(usernumber<answer){
			message="对不起，数字小了。";
		}
		else //if(usernumber>answer)
		{
			message="对不起，数字大了。";
			
		}
	}
	
	
	public String getMessage(){
		return message;
	}
	public int getTimes(){
		return times;
	}
	public boolean isSuccess(){
		return success;
	}
	
	public void setUsernumber(int usernumber){
		this.usernumber=usernumber;
	}
}
