/*
Challenge was to identify if the table given was a viable sudoku solution
however the rules for this sudoku solution were that each cell had to have
a common divisor with the every number in its row and every number in its
column.
*/

import java.util.*;

class SneakySudoku {

	// verifies that each cell has a common divisor with every cell in its row and column
	public static boolean isViableSudoku(List<List<Integer>> array){
		int start = 0;
		int cdx = array.get(0).get(0);
		int cdy = cdx;
		for (int i = 0; i < array.size(); i++){
			List<Integer> list = array.get(i);
			for (int j = start; j < array.size(); j++){
				int tmpx = getCD(cdx, list.get(j));
				if (tmpx == -1){
					return false;
				} else {
					cdx = tmpx;
				}
				int tmpy = getCD(cdy, array.get(j).get(start));
				if (tmpy == -1){
					return false;
				} else {
					cdy = tmpy;
				}
			}
			start++;
		}
		return true;
	}
	
	// gets the common divisor that is greater than 1
	public static int getCD(int cd, int target){
		if (target % cd == 0){
			return cd;
		}
		int i = 2;
		while (i < cd){
			if (cd % i == 0 && target % i == 0){
				return i;
			}
			i++;
		}
		return -1;
	}

	// prints the table
	public static void printTable(List<List<Integer>> table){
		for (List<Integer> row : table){
			for (int cell : row){
				System.out.print(cell + " ");
			}
			System.out.print("\n");
		}
	}

	public static void main(String[] args){
		List<List<Integer>> myList = new ArrayList<List<Integer>>();
		List<Integer> one = Arrays.asList(99,99,99,99,99,99);
		List<Integer> two = Arrays.asList(66,66,66,66,66,66);
		List<Integer> three = Arrays.asList(33,33,33,33,33,33);
		List<Integer> four = Arrays.asList(99,99,99,99,99,99);
                List<Integer> five = Arrays.asList(66,66,66,66,66,66);
                List<Integer> six = Arrays.asList(33,33,33,33,33,33);

		myList.add(one);
		myList.add(two);
		myList.add(three);
		myList.add(four);
		myList.add(five);
		myList.add(six);
		
		printTable(myList);
		System.out.println(isViableSudoku(myList));

		List<List<Integer>> secondList = new ArrayList<List<Integer>>();
                List<Integer> seven = Arrays.asList(50,50,50,50,50,50);
                List<Integer> eight = Arrays.asList(50,50,50,25,25,25);
                List<Integer> nine = Arrays.asList(22,50,50,50,50,50);
                List<Integer> ten = Arrays.asList(50,50,50,50,50,50);
                List<Integer> eleven = Arrays.asList(50,50,50,50,50,50);
                List<Integer> twelve = Arrays.asList(13,50,50,50,50,50);

		secondList.add(seven);
                secondList.add(eight);
                secondList.add(nine);
                secondList.add(ten);
                secondList.add(eleven);
                secondList.add(twelve);

		printTable(secondList);
		System.out.println(isViableSudoku(secondList));

		return;
	}
}


/*
[
  [99,99,99,99,99,99],
  [66,66,66,66,66,66],
  [33,33,33,33,33,33],
  [99,99,99,99,99,99],
  [66,66,66,66,66,66],
  [33,33,33,33,33,33],
]
returns true

[
  [50,50,50,50,50,50],
  [50,50,50,25,25,25],
  [22,50,50,50,50,50],
  [50,50,50,50,50,50],
  [50,50,50,50,50,50],
  [13,50,50,50,50,50]
]
returns false


*/
