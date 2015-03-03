package model;

public class Queen implements PieceInterface{

	private String type;
	private String color;

	public Queen(String color, String type) {
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
		
		//up and right 
		if((end-start) % 9 == 0)
		{	
			for(int i=start+9; i<end; i+= 9)
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
		//up and left 
		if((end-start) % 7 == 0)
		{
			for(int i=start+7; i<end; i+= 7)
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
		//down and left
		if((start-end) % 9 == 0)
		{
			for(int i=start-9; i>end; i-= 9)
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
		//down and right
		if((start-end) % 7 == 0)
		{
			for(int i=start-7; i>end; i-= 7)
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
