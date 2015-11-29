import java.util.*;

public class BoardFirstAutoPlayer extends AbstractAutoPlayer {

	public void possibleWord(StringBuilder word, int r, int c, BoggleBoard board, ArrayList<BoardCell> used, ILexicon lex, int min) {
		if (used.contains(new BoardCell(r, c))) return;
		if (r < 0 || r >= board.size()|| c < 0 || c >= board.size()) {
			return;}
		used.add(new BoardCell(r, c));
		word.append(board.getFace(r, c));
		if (lex.wordStatus(word).equals(LexStatus.WORD) && word.length() >= min) {
			add(word.toString());
		}
		if (!lex.wordStatus(word).equals(LexStatus.NOT_WORD)) {
			int[] xdelta = {-1, -1, -1, 0, 0, 1, 1, 1};
			int[] ydelta = {0, 1, -1, 1, -1, 0, 1, -1};
			for (int k = 0; k < xdelta.length; k ++) {
				possibleWord(word, r + xdelta[k], c + ydelta[k], board, used, lex, min);
			}
		}
		word.setLength(word.length() - board.getFace(r, c).length());
		used.remove(new BoardCell(r,c));
		return;
	}


@Override 
public void findAllValidWords(BoggleBoard board, ILexicon lex, int minLength) {
	// TODO: you write this code
	clear();
	for (int r = 0; r < board.size(); r++) {
		for (int c = 0; c < board.size(); c++) {
			ArrayList<BoardCell> used = new ArrayList<BoardCell>();
			StringBuilder word = new StringBuilder();
			possibleWord(word, r, c, board, used, lex, minLength);
		}
	}

}


}
