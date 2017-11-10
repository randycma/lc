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

using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int longestLength = 0;
        std::unordered_set<int> lettersSeen;

        for(string::iterator it = s.begin(); it != s.end(); ++it)
        {
        	lettersSeen.clear();
        	// find longest substring without repeating character for this index
        	int len = 0;
        	string::iterator it2 = it;
        	while(it2 != s.end() && lettersSeen.find(*it2) == lettersSeen.end())
        	{
        		lettersSeen.insert(*it2);
        		++len;
        		++it2;
        	}
        	if(len > longestLength)
        	{
        		longestLength = len;
        	}
        }
        return longestLength;
    }
};



int main()
{
	std::string str("kvaemuioeapmaut");
	Solution s;
	cout << "Longest substring for " << str << " is " << s.lengthOfLongestSubstring(str) << std::endl;
	return 0;
}
