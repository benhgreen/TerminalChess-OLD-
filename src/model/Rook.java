package model;

public class Rook implements PieceInterface{

	private String type;
	private String color;

	public Rook(String color, String type) {
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
		
		//forwards
		if((end-start) % 8 == 0)
		{
			for(int i=start+8; i<end; i+=8)
			{
				if(board.getPieceAt(i) != null)
					return false;
			}
			
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//backwards
		if((start-end) % 8 == 0)
		{
			for(int i=start-8; i>end; i-=8)
			{
				if(board.getPieceAt(i) != null)
					return false;
			}
			
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//left
		if((start-end) < 8)
		{
			for(int i=start-1; i>end; i--)
			{
				if(board.getPieceAt(i) != null)
					return false;
			}
			
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}
		//right
		if((end-start) < 8)
		{
			for(int i=start+1; i<end; i++)
			{
				if(board.getPieceAt(i) != null)
					return false;
			}
			
			//capture
			if(board.getPieceAt(end) != null)
				board.removePiece(end);
			
			board.movePiece(start, end);
			return true;
		}

		return false;
	}

}
