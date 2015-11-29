import java.util.*;
import java.util.List;

public class GoodWordOnBoardFinder implements IWordOnBoardFinder {

	public boolean findHelper(String word, int num, int r, int c,
			BoggleBoard board, ArrayList<BoardCell> list) {
		if (num >= word.length())
			return true;
		if (board.getFace(r, c).charAt(0) != word.charAt(num))
			return false;
		if (list.contains(new BoardCell(r, c)))
			return false;
		if (board.getFace(r, c).toLowerCase().equals("qu") && num + 2 < word.length()) {
				if (word.substring(num, num + 2).toLowerCase().equals("qu")) {
			num++;
		}
				else
					return false;
		}

		list.add(new BoardCell(r, c));
		int[] xdelta = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] ydelta = { 0, 1, -1, 1, -1, 0, 1, -1 };
		for (int k = 0; k < xdelta.length; k++) {
			int x = r + xdelta[k];
			int y = c + ydelta[k];
			if (x >= 0 && x < board.size() && y >= 0 && y < board.size()) {
				if (findHelper(word, num + 1, x, y, board, list)) {
					return true;
				}
			}
		}
		list.remove(new BoardCell(r, c));
		return false;
	}

	public List<BoardCell> cellsForWord(BoggleBoard board, String word) {
		ArrayList<BoardCell> list = new ArrayList<BoardCell>();
		for (int r = 0; r < board.size(); r++) {
			for (int c = 0; c < board.size(); c++) {
				if (findHelper(word, 0, r, c, board, list)) {
					return list;
				}
			}
		}
		list.clear();
		return list;

	}

}