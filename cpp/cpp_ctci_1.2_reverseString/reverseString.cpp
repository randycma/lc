/*
 * reverseString.cpp
 *
 *  Created on: Nov 10, 2017
 *      Author: randy
 */

#include <iostream>
#include <string>
#include <cstring>

void reverseString(char * s)
{
	int len = strlen(s);
	for(int i = 0; i < len / 2; ++i)
	{
//		char c = s[i];
//		s[i] = s[len - i - 1];
//		s[len - i - 1] = c;

		// alternatively
		s[i] ^= s[len - i - 1];
		s[len - i - 1] ^= s[i];
		s[i] ^= s[len - i - 1];
	}
}


int main()
{
	std::string s("helloworld");

	char cs[1000];
	strcpy(cs, s.c_str());
	std::cout << cs << std::endl;
	reverseString(cs);
	std::cout << cs << std::endl;
}
