package fbExercises;

import java.util.ArrayList;

/**
 * 
 * 
 * You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1) 
You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.

Example :

Input : [(0, 0), (1, 1), (1, 2)]
Output : 2
It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).

This question is intentionally left slightly vague. Clarify the question by trying out a few cases in the “See Expected Output” section.
 * @author mrincodi
 * 2016-11-17
 * Comment: Ok, this was easy.
 *
 */
public class Reach {

	// X and Y co-ordinates of the points in order.
	// Each point is represented by (X.get(i), Y.get(i))
	public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		if (X.size() <= 1 ) return 0;
		int result = 0;

		for ( int pos = 1; pos < X.size() ; pos++){
			int maxDiff = Math.max ( Math.abs(X.get(pos)-X.get(pos-1)),
					Math.abs(Y.get(pos)-Y.get(pos-1)));
			result += maxDiff;
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
