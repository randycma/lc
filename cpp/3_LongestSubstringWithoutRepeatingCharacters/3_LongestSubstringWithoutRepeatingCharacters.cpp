/*
 * 3_LongestSubstringWithoutRepeatingCharacters.cpp
 *
 *  Created on: Nov 9, 2017
 *      Author: randy
 */



/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*/

#include <string>
#include <iostream>
#include <unordered_set>
#include <unordered_map>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int longestLength = 0;

        std::unordered_map<int,int> letterSeenToIdx;
        int i = 0;
        int j = 0;

        for(; j < s.size(); ++j)
        {
        	if(letterSeenToIdx.find(s[j]) != letterSeenToIdx.end())
        	{
        		// letter already seen, check to see if it's before or after i
        		if(letterSeenToIdx[s[j]] >= i)
        		{
        			i = letterSeenToIdx[s[j]] + 1;
        		}
        	}

        	letterSeenToIdx[s[j]] = j;

        	if( (j-i + 1) > longestLength)
        	{
        		longestLength = j-i + 1;
        	}
        }
        return longestLength;
    }
};




int main()
{
	std::string str("abca");
	Solution s;
	cout << "Longest substring for " << str << " is " << s.lengthOfLongestSubstring(str) << std::endl;
	return 0;
}
