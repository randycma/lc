/*
 * nthdigit.cpp
 *
 *  Created on: Jan 28, 2018
 *      Author: Randy Ma
 */


#include <stdio.h>

class Solution {
	unsigned int tenPow[10] = { 1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000 };

public:
    inline int numbersThatHaveNdigits(int n)
    {
        // return 9 * int_pow(10, n-1);
    	return 9 * tenPow[n-1];
    }

    int findNthDigit(int n) {
    	int numDigits = 1;
    	int numbersWithNDigits = numbersThatHaveNdigits(numDigits);

        while(n > numbersWithNDigits * numDigits && numDigits <= 8)
        {
            n -= numbersWithNDigits * numDigits;
            ++numDigits;
            numbersWithNDigits = numbersThatHaveNdigits(numDigits);
        }

        // int number = int_pow(10,numDigits-1) + (n-1) / numDigits;
        int number = tenPow[numDigits-1] + (n-1) / numDigits;
        int digitInNumber = numDigits - (n + (numDigits-1)) % numDigits - 1;
        return (number / tenPow[digitInNumber]) % 10;
    }
};

int main()
{

	Solution s;
//	for(int i=1; i <= 200; ++i)
//	{
//		printf("%d - %d\n", i, s.findNthDigit(i));
//	}

	int n = 1000000000;
	// int n = 1234567;
	int ans = s.findNthDigit(n);
	printf("%d - %d\n", n, ans);

	return 0;
}
