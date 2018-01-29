/*
 * MinCostClimingStairs.cpp
 *
 *  Created on: Jan 23, 2018
 *      Author: Randy Ma
 */

#include <vector>
#include <algorithm>
#include <stdio.h>

using namespace std;



class Solution {
public:
    int minCostClimbingStairs(vector<int>& cost)
    {
    	if(cost.empty())
    		return 0;
    	vector<int> minCostForSteps(cost.size()+1);
    	std::fill(minCostForSteps.begin(), minCostForSteps.end(), -1);
    	minCostForSteps[0] = 0;
    	minCostForSteps[1] = 0;
    	return getMinCostAtStep(cost, minCostForSteps, cost.size());
    }

    int getMinCostAtStep(vector<int>&cost, vector<int> & minCostForSteps, int step)
    {
    	if(step < 0)
    		return 0;
    	if(minCostForSteps[step] != -1)
    	{
    		return minCostForSteps[step];
    	}

    	int minCostAtStep = min(getMinCostAtStep(cost, minCostForSteps, step-1) + cost[step-1],
    			getMinCostAtStep(cost, minCostForSteps, step-2) + cost[step-2]);
    	minCostForSteps[step] = minCostAtStep;
    	return minCostAtStep;
    }
};

int main()
{
	Solution s;
	vector<int> input {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
	printf("Output: %d\n", s.minCostClimbingStairs(input));
}
