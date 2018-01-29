/*
 * DegreeOfAnArray.cpp
 *
 *  Created on: Jan 23, 2018
 *      Author: Randy Ma
 */


#include <vector>
#include <list>
#include <unordered_map>
#include <algorithm>
#include <stdio.h>

using namespace std;

// nums.length will be between 1 and 50,000.
// nums[i] will be an integer between 0 and 49,999.
class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
    	// vector<list<int> > occurences(50000); // stores LL of all occurences of the number, in order
    	unordered_map<int, list<int> > occurences;

    	for(size_t i = 0; i < nums.size(); ++i)
    	{
    		occurences[nums[i]].push_back(i);
    	}

    	int max_degree_so_far = 0;
    	int shortestSubArray = 50000;
    	for(auto it = occurences.begin(); it != occurences.end(); ++it)
    	{
    		int frequency = it->second.size();
    		if(frequency > 0)
    		{
				if(frequency > max_degree_so_far)
				{
					// new degree
					max_degree_so_far = frequency;
					shortestSubArray = it->second.back() - it->second.front();
				}
				else if(frequency == max_degree_so_far)
				{
					shortestSubArray = min(shortestSubArray, it->second.back() - it->second.front());
				}
    		}
    	}
    	printf("Degree: %d, Shortest: %d\n", max_degree_so_far, shortestSubArray);
    	return shortestSubArray + 1;
    }
};

int main()
{
	Solution s;
	vector<int> input {1,2,2,3,1,4,2};
	printf("Output: %d\n", s.findShortestSubArray(input));
}
