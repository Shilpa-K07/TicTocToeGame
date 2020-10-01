import java.util.Scanner;

public class TicTacToeGame
{
	char[] boardArray=new char[10];
	String computerChoice = null;

	/* UC 1 */
	public void createBoard()
	{
		for(int index = 1;index < boardArray.length; index++)
		{
			boardArray[index] = (char)0;
		}
	}
	
	/* UC 2 */
	public String readPlayerInput()
	{
		Scanner scannerObject = new Scanner(System.in);
		System.out.println("Enter character X or O ");
		String userInput = scannerObject.next();
		if(userInput.equalsIgnoreCase("X"))	
		{
			computerChoice = "O";
		}
		else if(userInput.equalsIgnoreCase("O"))
		{
			computerChoice="X";
		}
		return computerChoice;
	}

	/* UC 3 */
	public void showBoard()
	{
		int rowCount=0;
		for(int index = 1; index < boardArray.length; index++)
		{
			if(rowCount == 3)
			{
				System.out.println();
				rowCount=0;
			}
			System.out.print("|_"+boardArray[index]+"|");
				rowCount++;
		}
	}
	
	/* UC 4 */
	public void checkLocationAndMove()
	{
		Scanner scannerObject = new Scanner(System.in);
		System.out.println("\nPlease enter location ");
		int location =  scannerObject.nextInt();
		if( location > 0 && location < 10)
		{
			if( boardArray[location] == (char)0 )
			{
				System.out.println("Position is free");
				makeMove(location);
			}
		}
		else
			System.out.println("Please check the location");
	}

	/* UC 5 */
	public void makeMove(int location)
	{
		System.out.println("Moving to Location: "+location);
		boardArray[location] = computerChoice.charAt(0);
		showBoard();
   	}

	public static void main(String[] args)
	{
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		ticTacToeGame.createBoard();
		String computerChoice = ticTacToeGame.readPlayerInput();
		System.out.println("Computer choice is:" +computerChoice);
		ticTacToeGame.showBoard();
		ticTacToeGame.checkLocationAndMove();
	}
}
