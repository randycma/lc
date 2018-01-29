/*
 * searchForARange.cpp
 *
 *  Created on: Jan 16, 2018
 *      Author: Randy Ma
 */

#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

class Solution {
public:
	int binarySearchLeft(int begin, int end, vector<int>& nums, int target)
	{
		if(begin == end)
		{
			if(nums[begin] == target)
				return begin;
			else
				return -1;
		}

		int middle = (begin + end) / 2;
		if(nums[middle] >= target)
		{
			return binarySearchLeft(begin, middle, nums, target);
		}
		else
		{
			return binarySearchLeft(middle+1, end, nums, target);
		}
	}

	int binarySearchRight(int begin, int end, vector<int>& nums, int target)
	{
		if(begin == end)
		{
			if(nums[begin] == target)
				return begin;
			else
				return -1;
		}

		int middle = (begin + end) / 2 + 1;
		if(nums[middle] <= target)
		{
			return binarySearchRight(middle, end, nums, target);
		}
		else
		{
			return binarySearchRight(begin, middle-1, nums, target);
		}
	}

    vector<int> searchRange(vector<int>& nums, int target) {
    	vector<int> result;
    	if(nums.size() > 0) {
    		result.push_back(binarySearchLeft(0, nums.size()-1, nums, target));
    		result.push_back(binarySearchRight(0, nums.size()-1, nums, target));
    	}
    	else
    	{
    		return {-1,-1};
    	}
    	return result;
    }
};

int main()
{
	vector<int> arr { 5,7,7,8,8,10 };
	Solution s;
	vector<int> result = s.searchRange(arr, 8);

	cout << result[0] << " " << result[1] << "\n";

	return 0;
}
