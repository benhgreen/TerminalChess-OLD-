/**
 * 
 */
package model;

import java.util.HashMap;

/**
 * @author Ben Green & Kate Sussman
 *
 */
public class Board implements BoardInterface {
	
	/**HashMap of the 64 squares in the chessboard, keys numbered 1-64
	 * 
	 */
	private HashMap<Integer, PieceInterface> squares;
	private String status;
	private String whose_turn;
	
	/**Constructor for board, initializes with a fresh set of pieces
	 * 
	 */
	public Board() {
		
		//initialize squares
		squares = new HashMap<Integer, PieceInterface>();
		
		//add white pawns
		for(Integer x = 9; x < 17; x++) {
			this.addPiece("w", "p", x);
		}
		
		//add black pawns
		for(Integer x = 49; x < 57; x++) {
			addPiece("b", "p", x);
		}
		
		//add other white pieces
		addPiece("w", "R", 1);
		addPiece("w", "R", 8);
		addPiece("w", "N", 2);
		addPiece("w", "N", 7);
		addPiece("w", "B", 3);
		addPiece("w", "B", 6);
		addPiece("w", "Q", 4);
		addPiece("w", "K", 5);
		
		//add other black pieces
		addPiece("b", "R", 57);
		addPiece("b", "R", 64);
		addPiece("b", "N", 58);
		addPiece("b", "N", 63);
		addPiece("b", "B", 59);
		addPiece("b", "B", 62);
		addPiece("b", "Q", 60);
		addPiece("b", "K", 61);
		
		//set status
		status = "progressing";
		
		//set white to go next
		whose_turn = "White";
	}

	@Override
	public void addPiece(String color, String type, Integer location) {
		switch (type) {
		
		//handle pawns
		case ("p"):
			squares.put(location, new Pawn(color, type));
		//handle rooks
		case ("R"):
			squares.put(location, new Rook(color, type));
		//handle knights
		case ("N"):
			squares.put(location, new Knight(color, type));
		//handle bishops
		case ("B"):
			squares.put(location, new Bishop(color, type));
		//handle queens
		case ("Q"):
			squares.put(location, new Queen(color, type));
		//handle king
		case ("K"):
			
		}
	}

	@Override
	public void removePiece(Integer location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void movePiece(Integer start_location, Integer end_location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PieceInterface getPieceAt(Integer location) {
		return squares.get(location);
	}


	@Override
	public void switchPlayer() {
		if (whose_turn.equals("White")) {
			whose_turn = "Black";
		} else {
			whose_turn = "White";
		}
		
	}
	
	@Override
	public String getStatus() {
		return status;
	}
	
	@Override
	public String getWhoseTurn() {
		return whose_turn;
	}

	

}
