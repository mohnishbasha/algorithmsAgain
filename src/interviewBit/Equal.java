package interviewBit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array A of integers, find the index of values that satisfy A + B = C + D, where A,B,C & D are integers values in the array

Note:

1) Return the indices `A1 B1 C1 D1`, so that 
  A[A1] + A[B1] = A[C1] + A[D1]
  A1 < B1, C1 < D1
  A1 < C1, B1 != D1, B1 != C1 

2) If there are more than one solutions, 
   then return the tuple of values which are lexicographical smallest. 

Assume we have two solutions
S1 : A1 B1 C1 D1 ( these are values of indices int the array )  
S2 : A2 B2 C2 D2

S1 is lexicographically smaller than S2 iff
  A1 < A2 OR
  A1 = A2 AND B1 < B2 OR
  A1 = A2 AND B1 = B2 AND C1 < C2 OR 
  A1 = A2 AND B1 = B2 AND C1 = C2 AND D1 < D2
Example:

Input: [3, 4, 7, 1, 2, 9, 8]
Output: [0, 2, 3, 5] (O index)
If no solution is possible, return an empty list.

 * @author mrincodi
 * Comment: This works and all, but it would have been even better
 * if I didn't have to look for the lexicographical best at the end.
 */
public class Equal {



	public ArrayList<Integer> equal(ArrayList<Integer> a) {
		HashMap <Integer, ArrayList <Integer> > h = new HashMap <Integer, ArrayList <Integer> > ();

		ArrayList<Integer>result = new  ArrayList<Integer> ();
		ArrayList<ArrayList<Integer>>results = new  ArrayList<ArrayList<Integer>> ();

		for ( int i = 0; i < a.size(); i++ ){

			for ( int j = i+1; j < a.size(); j++ ){
				int sum = a.get(i) + a.get(j);
				if (h.containsKey (sum)){
					//Another couple already has these values!
					// So we found a solution.

					int x = h.get(sum).get(0);
					int y = h.get(sum).get(1);

					//Not too fast! What if the numbers are repeated?
					if (x != i && x != j && y != i && y != j){
						result.add (x);
						result.add (y);
						result.add (i);
						result.add (j);

						results.add(result);
						result=new  ArrayList<Integer> ();
					}
				}
				else {
					ArrayList<Integer> positions = new ArrayList<Integer> ();
					positions.addAll (Arrays.asList (i,j));
					h.put (sum, positions);
				}
			}
		}

		//Now, let's find the best one lexicographically.
		//Let's get the first value.
		result=results.get(0);
		for (int i = 1; i < results.size(); i++){
			ArrayList<Integer> aResult=results.get(i);

			int x = aResult.get(0);
			int y = aResult.get(1);
			int z = aResult.get(2);
			int w = aResult.get(3);

			int oldX = result.get(0);
			int oldY = result.get(1);
			int oldZ = result.get(2);
			int oldW = result.get(3);            

			if ((x<oldX)||
					( (x==oldX) && (y < oldY) )||
					( (x==oldX) && (y == oldY) && (z < oldZ) )||
					( (x==oldX) && (y == oldY) && (z == oldZ) && (w < oldW) ) ){
				result=aResult;
			}
		}

		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
