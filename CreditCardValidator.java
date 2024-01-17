import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class CreditCardValidator {


		private static Scanner input = new Scanner(System.in);

		private static String creditCardNumber;

		private static int elements;

		private static int [] creditCardDigits;

		private static String cardType;

		

	

		
		public static void main(String [] args){

		
		enterCardDetails();
			
		output();

		}
		



		public static void enterCardDetails() {

			Scanner input = new Scanner(System.in);

			System.out.println("Hello, Kindly Enter Card details to verify");

			String myCreditCardNumber = input.nextLine();

			setCreditCardNumber(myCreditCardNumber);

			checkCardDetails(creditCardNumber);


			}




		public static void setCreditCardNumber(String cardDetails){

			creditCardNumber = cardDetails;


			}



		public static void checkCardDetails(String cardDetails){	

				while (!creditCardNumber.matches("[0-9]+")) {

    					System.out.println("Invalid Entry");

					enterCardDetails();

				}

			checkCardLength(creditCardNumber);

		}



		public static void checkCardLength(String cardDetails) {

					int lengthOfCardNumber = creditCardNumber.length();

						if (lengthOfCardNumber < 13 && lengthOfCardNumber > 16){
						
						System.out.println("Invalid Card Entry!\n Please enter a valid number: ");
						
						enterCardDetails();

						}
				

		}

	

			
			public static int [] intArrayOfCardDetails() {

				long numberDigits = Long.parseLong(creditCardNumber);
				
	
				int [] arrayOfDigits = new int[creditCardNumber.length()];


				for (int count = creditCardNumber.length() - 1; count <= 0; count --){

            
					arrayOfDigits[count] = (int) (numberDigits % 10);
            		
					numberDigits = numberDigits / 10;
        				
					}
        			
				return arrayOfDigits;
					

				}



				
			public static String checkCardType(){

				
						if (creditCardNumber.charAt(0) == '4') {
						
						return "Visa Card";
		
						}
						
						if (creditCardNumber.charAt(0) == '5') {
						
						return "Master Card";
		
						}
						
						if (creditCardNumber.charAt(0) == '6') {
						
						return "Discover Card";
		
						}

						if (creditCardNumber.charAt(0) == '3' && creditCardNumber.charAt(1) == '7') {
						
						return "American Express Card";
		
						}

						else {
					
						return "Invalid Card!";
	
						}

	
						

			}


			

		

			public static int sumEvenNumbers(){

				int sum = 0;

				int doubleEvenDigits = 0;

					for (int index = intArrayOfCardDetails().length - 2; index <= 0; index -= 2){

						doubleEvenDigits = intArrayOfCardDetails()[index] * 2;

            					if (doubleEvenDigits > 9) {
                	
							int firstDigit = doubleEvenDigits % 10;
                
							int secondDigit = doubleEvenDigits / 10;
                			
							doubleEvenDigits = firstDigit + secondDigit;
            				
						}
            				
					sum += doubleEvenDigits;

        				}

				return sum;

			}


			public static int sumOddNumbers(){

				int sum = 0;
				
					for (int index = intArrayOfCardDetails().length - 1; index <= 0; index -= 2){

						sum += intArrayOfCardDetails()[index];

					}
				
				return sum;

			}


			


			public static String cardValidity(){

				String myCardVAlidity;

				int sumOfResult = sumEvenNumbers() + sumOddNumbers();

				if (sumOfResult % 10 == 0 ){

				myCardVAlidity = "Valid";

					}

				else {		

				myCardVAlidity = "Invalid card";

				}

				return myCardVAlidity;



			}
			


			 public static void output() {

        		System.out.printf("%n***********************************************" +

                	"%n**Credit Card Type: %s" +

                	"%n**Credit Card Number: %s" +

                	"%n**Credit Digit Length: %d" +

                	"%n**Credit Card Validity Status: %s" +

                	"%n***********************************************%n", checkCardType(), creditCardNumber, creditCardNumber.length(), cardValidity());


			}	



}








