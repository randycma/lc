/*
 * maximumBinaryTree.cpp
 *
 *  Created on: Jan 16, 2018
 *      Author: Randy Ma
 */

#ifndef NULL
#define NULL   ((void *) 0)
#endif

#include <vector>
#include <map>
#include <limits.h>

using namespace std;

struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:

	std::pair<int,int> getMax(vector<int>&nums, int left, int right)
	{
		// return max and index;
		int maxValue = INT_MIN;
		int index = -1;
		for(int i = left; i <= right; ++i)
		{
			if(nums[i] > maxValue)
			{
				maxValue = nums[i];
				index = i;
			}
		}
		return std::make_pair(maxValue, index);
	}

	void helper(TreeNode* &root, vector<int>& nums, int left, int right)
	{
		if(left > right)
			return;
		auto maxPair = getMax(nums, left, right);
		root = new TreeNode(maxPair.first);

		helper(root->left, nums, left, maxPair.second - 1);
		helper(root->right, nums, maxPair.second + 1, right);
	}

    TreeNode* constructMaximumBinaryTree(vector<int>& nums) {
    	TreeNode* root = NULL;
    	helper(root, nums, 0, nums.size()-1);
    	return root;
    }
};



int main()
{
	vector<int> nums { 3,2,1,6,0,5 };

	Solution s;
	s.constructMaximumBinaryTree(nums);
}
