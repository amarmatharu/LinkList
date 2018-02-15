package com.amar.linklist;

import java.util.HashMap;
import java.util.Map;

/* Custom Link list class with various operations
 * 
 * 
 * 
 * 
 */
public class CustomLinkList {

	private Link head;

	public CustomLinkList() {
		this.head = null;
	}

	public void insertAtFront(int data) {

		Link node = new Link(data);
		if (null == head) {
			head = node;
			return;
		}
		node.next = head;
		head = node;

	}

	public void insert(Link node) {

		System.out.println("inserting:" + node.data);
		if (null == head) {
			head = node;
			return;
		}
		Link curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = node;
	}

	public void insertAtEnd(int data) {

		Link node = new Link(data);
		if (null == head) {
			head = node;
			return;
		}
		Link current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = node;

	}

	public void insertAtIndex() {

	}

	public boolean deleteAtFront() {

		if (null == head) {
			return false;
		}

		Link current = head.next;
		head = current;

		return true;

	}

	public boolean deleteAtEnd() {

		if (null == head) {
			return false;
		}
		Link current = head;
		Link previous = current;
		while (current.next != null) {
			previous = current;
			current = current.next;
		}
		if (current == head) {
			head = head.next;

		} else {
			previous.next = current.next;
		}
		return true;
	}

	public boolean delete(int key) {

		System.out.println("Deleting: " + key);
		if (null == head) {
			return false;
		}
		Link current = head;
		Link previous = current;
		while (current.data != key) {

			if (current.next == null) {
				System.out.println("Key not present in the List");
				return false;
			}
			previous = current;
			current = current.next;
		}
		if (current == head) {
			head = head.next;
		} else {
			previous.next = current.next;
		}

		return true;

	}

	/* 
	 * 
	 * 
	 * 
	 * 
	 */
	public boolean reverseList() {

		if (null == head) {
			return false;
		}
		Link current = head;
		Link nextNode = null;

		while (current.next != null) {
			// if there is only one entry

			// store the location of the next node
			nextNode = current.next;

			// change the pointer of the current node next's next node
			current.next = nextNode.next;

			// make nextNode point to head
			nextNode.next = head;

			head = nextNode;

		}

		return true;

	}

	/*
	 * The non-empty linked lists representing two non-negative integers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 * 
	 * You may assume the two numbers do not contain any leading zero, except
	 * the number 0 itself.
	 * 
	 * Example
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342
	 * + 465 = 807.
	 * 
	 * 
	 */
	public CustomLinkList addTwoNumbers(CustomLinkList l1, CustomLinkList l2) {

		CustomLinkList output = new CustomLinkList();

		int carry = 0;
		Link firstList = l1.head;
		Link secondList = l2.head;

		while (firstList != null || secondList != null) {
			int firstNumber = firstList == null ? 0 : firstList.data;
			int secondNumber = secondList == null ? 0 : secondList.data;
			int sum = firstNumber + secondNumber + carry;
			carry = sum / 10;
			output.insertAtEnd(sum % 10);
			firstList = firstList != null ? firstList.next : null;
			secondList = secondList != null ? secondList.next : null;

		}
		if (carry > 0) {
			output.insertAtEnd(carry);
		}

		return output;
	}

	public Link getIntersectionNode(CustomLinkList headA, CustomLinkList headB) {

		{
			Map<Integer, Link> map = new HashMap<Integer, Link>();
			Link currentA = headA.head;
			Link currentB = headB.head;

			while (currentA != null || currentB != null) {

				if (!map.containsKey(currentA.hashCode())) {
					map.put(currentA.hashCode(), currentA);
				} else {
					return map.get(currentA.hashCode());
				}

				if (!map.containsKey(currentB.hashCode())) {
					map.put(currentB.hashCode(), currentB);
				} else {
					return map.get(currentB.hashCode());
				}

				currentA = currentA != null ? currentA.next : null;
				currentB = currentB != null ? currentB.next : null;

			}

			return null;

		}

	}

	public void display() {
		Link current = head;
		System.out.println("*****DISPLAY STARTED******");
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
		System.out.println("*****DISPLAY END******");
	}

	public void display(CustomLinkList ls) {
		Link current = ls.head;
		System.out.println("*****DISPLAY STARTED******");
		while (current != null) {
			System.out.println(current.getData());
			current = current.getNext();
		}
		System.out.println("*****DISPLAY END******");
	}

}
