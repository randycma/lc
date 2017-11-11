/*
 * 2_AddTwoNumbers.cpp
 *
 *  Created on: Nov 9, 2017
 *      Author: randy
 */

/*
 You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 */

#include <string>
#include <iostream>

using namespace std;

struct ListNode
{
	int val;
	ListNode *next;
	ListNode(int x) :
			val(x), next(NULL)
	{
	}
};

ListNode *addValAndCreateNewNode(ListNode *cur, int val, bool createNext) {
    cur->val = val;
    if(createNext)
    	cur->next = new ListNode(0);
    return cur->next;
}

class Solution
{
public:
	ListNode* addTwoNumbers(ListNode* l1, ListNode* l2)
	{
		ListNode* result = new ListNode(0); // dummy head
		ListNode* curr = result;
		int carry = 0;
		while (l1 || l2)
		{
			int a = l1 ? l1->val : 0;
			int b = l2 ? l2->val : 0;
			int sum = carry + a + b;

			carry = sum / 10;

			curr->next = new ListNode(sum % 10);
			curr = curr->next;

			if (l1)
				l1 = l1->next;
			if (l2)
				l2 = l2->next;
		}

		if(carry > 0)
		{
			curr->next = new ListNode(carry);
		}

		return result->next; // first node is dummy
	}
};

void printLinkedList(ListNode* li)
{
	while(li)
	{
		std::cout << li->val << " ";
		li = li->next;
	}
	std::cout << std::endl;
}

int main()
{
	int t, n;
	Solution s;
	cin >> n;

	ListNode *a = new ListNode(0), *b = new ListNode(0);
	ListNode *pa = a, *pb = b;
	while (n--)
	{
		cin >> t;
		pa = addValAndCreateNewNode(pa, t, n);
	}

	cin >> n;
	while (n--)
	{
		cin >> t;
		pb = addValAndCreateNewNode(pb, t, n);
	}
	pb = NULL;

	printLinkedList(a);
	printLinkedList(b);

	ListNode* result = s.addTwoNumbers(a, b);    // use gdb to debug

	printLinkedList(result);


    return 0;
}
