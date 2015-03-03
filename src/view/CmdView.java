/**
 * 
 */
package view;

import java.util.Scanner;

import control.BoardPrinter;
import control.MoveChecker;
import model.Board;

/**
 * @author Ben Green & Kate Sussman
 *
 */
public class CmdView {

	public static void main(String[] args) {
		
		//initialize scanner & move holder
		Scanner input = new Scanner(System.in);
		String move = "";
		
		//initialize board
		Board board = new Board();
		
		while (board.getStatus().equals("progressing")) {
			
			//print board
			BoardPrinter.printBoard(board);
			
			//query move
			System.out.print(board.getWhoseTurn() + "'s move: ");
			move = input.nextLine();
			
			//check move validity
			while (!MoveChecker.isValidMove(board, move)) {
				System.out.print("\nIllegal Move, try again: ");
				move = input.nextLine();
			}
			
			
		
		}

	}

}
