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
#include <vector>

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int longestLength = 0;

        std::vector<int> letterSeenToIdx(256,-1); // ascii to index
        int i = 0;

        // use i and j to mark longest substring currently seen
        for(int j = 0; j < s.size(); ++j)
        {
        	i = max(i, letterSeenToIdx[s[j]] + 1); // update i if letter already seen in current substring
        	letterSeenToIdx[s[j]] = j; // update last seen

        	longestLength = max(j-i+1, longestLength);
        }
        return longestLength;
    }
};




int main()
{
	std::string str("iwefoweobb");
	Solution s;
	cout << "Longest substring for " << str << " is " << s.lengthOfLongestSubstring(str) << std::endl;
	return 0;
}
