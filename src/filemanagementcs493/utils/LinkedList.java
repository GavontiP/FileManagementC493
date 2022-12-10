package filemanagementcs493.utils;
// Java program to implement

// a Singly Linked List

import filemanagementcs493.application.ObjectInterface;
import filemanagementcs493.state;

public class LinkedList<source> {

	Node head; // head of list
	public int size = 0;

	public int getSize() {
		return this.size;
	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	// Linked list Node.
	public class Node {

		source data;
		Node next;

		// Constructor
		Node(source d) {
			data = d;
			next = null;
		}
	}

	// Method to insert a new node
	public LinkedList insert(LinkedList list, source item) {
		// Create a new node with given data
		Node new_node = new Node(item);
		new_node.next = null;

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		} else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}
		size++;
		return list;
	}

	// Method to print the LinkedList.
	public void printList(LinkedList list) {
		Node currNode = list.head;

		if (currNode == null)
			System.out.println("LinkedList is empty.");
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");

			// Go to next node
			currNode = currNode.next;
			System.out.println();
		}

	}

	// Method to delete a node in the LinkedList by POSITION
	public LinkedList deleteAtPosition(LinkedList list, int index) {
		// Store head node
		Node currNode = list.head, prev = null;

		//
		// CASE 1:
		// If index is 0, then head node itself is to be
		// deleted

		if (index == 0 && currNode != null) {
			list.head = currNode.next; // Changed head

			// Display the message
			System.out.println(
					index + " position element deleted");

			// Return the updated List
			return list;
		}

		//
		// CASE 2:
		// If the index is greater than 0 but less than the
		// size of LinkedList
		//
		// The counter
		int counter = 0;

		// Count for the index to be deleted,
		// keep track of the previous node
		// as it is needed to change currNode.next
		while (currNode != null) {

			if (counter == index) {
				// Since the currNode is the required
				// position Unlink currNode from linked list
				prev.next = currNode.next;

				// Display the message
				System.out.println(
						index + " position element deleted");
				break;
			} else {
				// If current position is not the index
				// continue to next node
				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}

		// If the position element was found, it should be
		// at currNode Therefore the currNode shall not be
		// null
		//
		// CASE 3: The index is greater than the size of the
		// LinkedList
		//
		// In this case, the currNode should be null
		if (currNode == null) {
			// Display the message
			System.out.println(
					index + " position element not found");
		}
		size--;
		// return the List
		return list;
	}

	// Method to find a node in the LinkedList by POSITION
	public source findAtPosition(LinkedList list, int index) {
		source returnValue = null;
		// Store head node
		Node currNode = list.head, prev = null;

		//
		// CASE 1:
		// If index is 0, then head node itself is what we want

		if (index == 0 && currNode != null) {
			returnValue = (source) list.head.data;
			// // Display the message
			// System.out.println(
			// index + " position element found");

			// Return the updated List
			return returnValue;
		}

		//
		// CASE 2:
		// If the index is greater than 0 but less than the
		// size of LinkedList
		//
		// The counter
		int counter = 0;

		// Count for the index to be deleted,
		// keep track of the previous node
		// as it is needed to change currNode.next
		while (currNode != null) {

			if (counter == index) {
				// Since the currNode is the required
				// position Unlink currNode from linked list
				returnValue = prev.next.data;
				//
				// // Display the message
				// System.out.println(
				// index + " position element found");
				return returnValue;
			} else {
				// If current position is not the index
				// continue to next node
				prev = currNode;
				currNode = currNode.next;
				counter++;
			}
		}

		// If the position element was found, it should be
		// at currNode Therefore the currNode shall not be
		// null
		//
		// CASE 3: The index is greater than the size of the
		// LinkedList
		//
		// In this case, the currNode should be null
		if (currNode == null) {
			// Display the message
			// System.out.println(
			// index + " position element not found");

		}

		// return the List
		return returnValue;
	}

}
