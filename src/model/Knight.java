package model;

public class Knight implements PieceInterface{

	private String type;
	private String color;

	public Knight(String color, String type) {
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

	@Override
	public boolean isValidMove(Board board, int[] location) {
		int start = location[0];
		int end = location[1];
		
		//up 2 right 1
		if(end-start == 17)
		{
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//up 2 left 1
		if(end-start == 15)
		{
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//up 1 left 2
		if(end-start == 6)
		{
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//up 1 right 2
		if(end-start == 10)
		{
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//down 2 right 1
		if(start-end == 15)
		{
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//down 2 left 1
		if(start-end == 17)
		{
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//down 1 left 2
		if(start-end == 10)
		{
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//down 1 right 2
		if(start-end == 6)
		{
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		
		return false;
	}

}
