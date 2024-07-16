import java.util.*;
class PanNo{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		  System.out.print("Enter first name: ");
        	String fName = sc.next();
        	System.out.print("Enter last name: ");
        	String lName = sc.next();
        	System.out.print("Enter category (Individual/Company/HUF/AOP/BOI): ");
        	String category = sc.next();
        	String panNo = generatePAN(fName, lName, category);
        	System.out.println("PAN card number is " + panNo);
	}
	public static String generatePAN(String fName, String lName, String category){
		String threeLetter = getRandomLetters(3);
		char fourthLetter = getCategoryLetter(category);
		char fifthLetter = lName.charAt(0);
		String fourNo = getRandomNumbers();
		char lastLetter = getRandomLetters(1).charAt(0);
		return threeLetter + fourthLetter + fifthLetter + fourNo + lastLetter;
	}
 	 public static char getCategoryLetter(String category) {
        	switch (category.toLowerCase()) {
           	case "individual":
                	return 'P';
            	case "company":
                	return 'C';
            	case "huf":
                	return 'H';
            	case "aop":
                	return 'A';
            	case "boi":
                	return 'B';
            	default:
                	  throw new IllegalArgumentException("Invalid category. Valid categories are Individual, Company, HUF, AOP, BOI.");
        }
    }
	public static String getRandomLetters(int length){
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<length;i++){
			int index = random.nextInt(letters.length());
			sb.append(letters.charAt(index));
		}
		return sb.toString();	
	}
	public static String getRandomNumbers(){
		Random random = new Random();
		int randomNo = 1000+random.nextInt(9999);
		return String.valueOf(randomNo);
	}
}