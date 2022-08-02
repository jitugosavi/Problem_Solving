/**
	Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.

	The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

	Maximum sub-array is defined in terms of the sum of the elements in the sub-array.

	Find and return the required subarray.

	NOTE:

    	1. If there is a tie, then compare with segment's length and return segment which has maximum length.
    	2. If there is still a tie, then return the segment with minimum starting index.

    Input Format:

		The first and the only argument of input contains an integer array A, of length N.

	Output Format:

		Return an array of integers, that is a subarray of A that satisfies the given conditions.

	Constraints:

		1 <= N <= 1e5
		-INT_MAX < A[i] <= INT_MAX
**/

public int[] maxSubArrayOfNonNegativeNumbers(int[] A) {
	ArrayList<Integer> list = new ArrayList<>();
	ArrayList<Integer> copy = new ArrayList<>();

	int maxSum = 0;
	int tempSum = 0;

	for (int i = 0; i < A.length; i++) {
		if (A[i] > 0) {
			copy.add(A[i]);
			tempSum += A[i];
		} else {
			copy.clear();
			tempSum = 0;
		}

		if ((tempSum > maxSum) || (tempSum == maxSum && (list.size() < copy.size()))) {
			maxSum = tempSum;
			list.clear();
			list.addAll(copy);
		}
	}

	int[] arr = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
        arr[i] = list.get(i);
    }

    return arr;
}
