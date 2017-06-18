import java.util.Random;

public class Class {
	public String cs(String str1){
		Random ran = new Random();
		  int random = ran.nextInt(5)+1;
		  String str = null;
		  if(str1.contains("weather")){
			  if(random == 1)
				  str = "today is sunny!! :-)";
			  else if(random == 2)
				  str = "today is cloudy!! :-(";
			  else if(random == 3)
				  str = "today is wet!! :-<";
			  else if(random == 4)
				  str = "what a scorcher!! -_-";
			  else if(random == 5)
				  str = "It's freezing out there!! :-)";
		  }
		  else if(str1.contains("home") || str1.contains("house")){
			  if(random == 1)
				  str = "go home!!!"  ;				  
			  else if(random == 2)
				  str = "no!! working!!";
			  else if(random == 3)
				  str = "you can't go home 六六六六六";
			  else if(random == 4){				
				  str = "餵";
			  }
			  else if(random == 5)
				  str = "your house is crumble";
		  }
		  else if(str1.contains("money")){
			  if(random == 1)
				  str = "give me money!!!";	
			  else if(random == 2)
				  str = "Money is the coins or bank notes that you use to buy things, or the sum that you have in a bank account. ";
			  else if(random == 3)
				  str = "Monetary means relating to money, especially the total amount of money in a country.";
			  else if(random == 4)
				  str = "絲";
			  else if(random == 5)
				  str = "no money";
		  }			  
		  else if(str1.contains("hungry")){
			  if(random == 1)
				  str = "me too!";
			  else if(random == 2)
				  str = "When you are hungry, you want some food because you have not eaten for some time and have an uncomfortable or painful feeling in your stomach.";
			  else
				  str = "i'm not hungry";
		  }
		  else{
			  str = str1.toUpperCase();
		  }
		return str;
	}
}

