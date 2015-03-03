package model;

public class King implements PieceInterface {

	private String type;
	private String color;
	private boolean hasBeenMoved = false;

	public King(String color, String type) {
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
	public boolean isValidPieceMove(Board board, Integer[] location) {
		int start = location[0];
		int end = location[1];
		
		//right
		if(end == start+1)
		{
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			hasBeenMoved = true;
			return true;
			
		}
		//left
		if(end == start-1)
		{
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			hasBeenMoved = true;
			return true;
		}
		//up
		if(end == start+8)
		{
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			hasBeenMoved = true;
			return true;
		}
		//down
		if(end == start-8)
		{
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			hasBeenMoved = true;
			return true;
		}
		//up and right
		if(end == start+9)
		{
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			hasBeenMoved = true;
			return true;
		}
		//up and left
		if(end == start+7)
		{
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			hasBeenMoved = true;
			return true;
		}
		//down and right
		if(end == start-7)
		{
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			hasBeenMoved = true;
			return true;
		}
		//up and left
		if(end == start-9)
		{
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			hasBeenMoved = true;
			return true;
		}
		
		
		return false;
	}

}
