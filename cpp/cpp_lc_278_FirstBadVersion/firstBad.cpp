/*
 * firstBad.cpp
 *
 *  Created on: Jan 16, 2018
 *      Author: Randy Ma
 */

#include <vector>
#include <iostream>

static std::vector<int> arr{0,1,1};
bool isBadVersion(int version)
{
	return arr[version-1];
}

class Solution {
public:
    int firstBadVersion(int n) {
        // Binary search
        int begin = 1;
        int end = n;

        while(begin < end)
        {
            int middle = begin + (end-begin) / 2;
            if(isBadVersion(middle))
            {
                // First bad version is to the left
                end = middle;
            }
            else
            {
                // first bad version is to the right
                begin = middle + 1;
            }
        }
        return begin;
    }
};


int main()
{
	Solution s;
	std::cout << s.firstBadVersion(3) << std::endl;
}
