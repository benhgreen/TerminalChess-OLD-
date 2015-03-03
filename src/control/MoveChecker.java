/**
 * 
 */
package control;

import java.util.StringTokenizer;

import model.Board;
import model.Pawn;
import model.PieceInterface;

/**
 * @author Ben Green & Kate Sussman
 *
 */
public class MoveChecker {
	
	//Board board = new Board();

	public static boolean isValidMove(Board board, String move) {
		
		//parse move into numbers
		Integer[]parsed_move = parseMove(move);
		if (parsed_move == null) {
			return false;
		}
		
		//verify that a piece exists on the specified space that belongs to the player
		PieceInterface piece = board.getPieceAt(parsed_move[0]);
		
		//check that the piece exists
		if (piece == null) {
			return false;
		
		//check that the piece belongs to the current player
		} else if (!piece.getColor().equals(board.getWhoseTurn())) {
			return false;
		}
		
		//analyze move further with helper method
		if (!isValidPieceMove(board, parsed_move)) {
			return false;
		
		//make sure move doesn't violate check rules
		}else if (obeysCheck(board, parsed_move)) {
			return false;
		}
		
		return false;
		
	}
	
	/**Do piece-specific analyzation on move
	 * @param board Board to use
	 * @param parsed_move Parsed move from parseMove method
	 * @return True if move is valid, False if it ain't
	 */
	private static boolean isValidPieceMove(Board board, Integer[] parsed_move) {
		//TODO finish this
		//analyze piece type
		PieceInterface piece = board.getPieceAt(parsed_move[0]);
		
		switch (piece.getType()) {
		
		//handle pawns
		case ("p"):

		//handle rooks
		case ("R"):
		
		//handle knights
		case ("N"):
		
		//handle bishops
		case ("B"):
		
		//handle queens
		case ("Q"):
		
		//handle king
		case ("K"):
			
		}
		
		return false;
	}

	/**Checks that move doesn't bring the player's kind into check (or doesn't get the
	 * player's king out of check)
	 * @param board Board to use
	 * @param parsed_move Move parsed with ParseMove
	 * @return True if the move obeys rules of check
	 */
	private static boolean obeysCheck(Board board, Integer[] parsed_move) {
		// TODO Auto-generated method stub
		return false;
	}

	/**Parses 'move' parameter into numbers representing current and destination squares
	 * @param move Move formatted like 'e2 e4'
	 * @return Integer array of size 2 with Integer representations of the move. For
	 * example, 'e2 e4' would become [13, 29]. Null is returned if the one or both of the
	 * squares given are nonsensical, or if something else is wrong with the input.
	 */
	public static Integer[] parseMove(String move) {
		
		//initialize return array
		Integer[] parsed_moves = new Integer[2];
		
		//parse move into tokens
		StringTokenizer tokz = new StringTokenizer(move);
		
		//check that only two arguments exist - current location and destination
		if (tokz.countTokens() != 2) {
			return null;
		}
		
		//iterate through tokens and parse each one into return array
		for (int x = 0; x < 2; x++) {
			String token = tokz.nextToken().toLowerCase();
			
			//check each location for length
			if (token.length() != 2) {
				System.err.println("Invalid number of moves");
				return null;
			
			//check that first char is a letter and second char is a number
			} else if (!Character.isLetter(token.charAt(0)) || (!Character.isDigit(token.charAt(1)))) {
				System.err.println("Invalid char types in moves");
				return null;
			
			//check that letter is between a-h and number is between 1-8
			} else if ((Character.getNumericValue(token.charAt(0))) > 17 || ((Character.getNumericValue(token.charAt(1)) > 8))) {

				System.err.println("Invalid move range");
				return null;
			}
			
			//put parsed location into return array
			parsed_moves[x] = (Character.getNumericValue(token.charAt(0))-9) + (Character.getNumericValue(token.charAt(1)-1) * 8);
			System.out.println(parsed_moves[x]);
		}
		
		return parsed_moves;
	}

}
