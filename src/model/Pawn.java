package model;

public class Pawn implements PieceInterface {
	
	private String type;
	private String color;
	private boolean is_first_move = true;

	public Pawn(String color, String type) {
			this.color = color;
			this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public boolean isWhite() {
		return color.equals("white");
	}
	
	public boolean getIsFirstMove()
	{
		return is_first_move;
	}

	@Override
	public boolean isValidPieceMove(Board board, Integer[] location) {
		Integer start = location[0];
		Integer end = location[1];

		
		
		//white 
		if(color.equals("w"))
		{
			//capture piece diagonally
			if((board.getPieceAt(start+7) != null) || (board.getPieceAt(start+9) != null))
			{
				if(end == start+7 || end == start+9)
				{
					board.removePiece(end);
					board.movePiece(start, end);
					is_first_move = false;
					return true;
				}			
			}
		
			//moving one square up
			if(end == start+8)
			{
				if(board.getPieceAt(end) == null)
				{
					board.movePiece(start, end);
					is_first_move = false;
					
					//reached end of board
					if(end <= 64 || end >= 57)
						//queen for now TODO: ask for other pieces
						board.replacePiece("w", "Q", end);
					
					return true;
				}	
			}
			
			//moving 2 squares up
			if(is_first_move)
			{
				if(board.getPieceAt(end) == null && board.getPieceAt(start+8) == null)
				{
					board.movePiece(start, end);
					is_first_move = false;
					return true;
				}
			}
		}
		
		//black 
		if(color.equals("b"))
		{
			//capture piece diagonally
			if((board.getPieceAt(start-7) != null) || (board.getPieceAt(start-9) != null))
			{
				if(end == start-7 || end == start-9)
				{
					board.removePiece(end);
					board.movePiece(start, end);
					is_first_move = false;
					return true;
				}			
			}
		
			//moving one square down
			if(end == start-8)
			{
				if(board.getPieceAt(end) == null)
				{
					board.movePiece(start, end);
					is_first_move = false;
					
					//reached end of board
					if(end <= 64 || end >= 57)
						//queen for now TODO: ask for other pieces
						board.replacePiece("b", "Q", end);
					
					return true;
				}	
			}
			
			//moving 2 squares down
			if(is_first_move)
			{
				if(board.getPieceAt(end) == null && board.getPieceAt(start-8) == null)
				{
					board.movePiece(start, end);
					is_first_move = false;
					return true;
				}
			}
		}

		return false;
	}
}
