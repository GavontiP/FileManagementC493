package filemanagementcs493.utils;
// Java program to implement
// a Singly Linked List

import java.util.ArrayList;
import filemanagementcs493.application.Filess;
public class LinkedList {

	Node head; // head of list
        public static int size = 0;

    public static int getSize() {
        return size;
    }

	// Linked list Node.
	// Node is a static nested class
	// so main() can access it
	public static class Node {

		String data;
		Node next;

		// Constructor
		Node(String d)
		{
			data = d;
			next = null;
		}
	}

	// Method to insert a new node
	public static LinkedList insert(LinkedList list,
									Object item)
	{
		// Create a new node with given data
		Node new_node = new Node(item.toString());
		new_node.next = null;
//                System.out.println(item.toString());

		// If the Linked List is empty,
		// then make the new node as head
		if (list.head == null) {
			list.head = new_node;
		}
		else {
			// Else traverse till the last node
			// and insert the new_node there
			Node last = list.head;
			while (last.next != null) {
				last = last.next;
			}

			// Insert the new_node at last node
			last.next = new_node;
		}

		// Return the list by head
//                System.out.println("inserted: " + item.toString());
                size++;
		return list;
	}

	// Method to print the LinkedList.
	public static void printList(LinkedList list)
	{
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");

			// Go to next node
			currNode = currNode.next;
                        System.out.println();
		}

	}
        
        // Method to print the LinkedList.
	public static ArrayList putInArr(LinkedList list)
	{
            ArrayList<Object> t = new ArrayList<>();
            int counter = 0;
		Node currNode = list.head;

		System.out.print("LinkedList: ");

		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			t.add(currNode.data);

			// Go to next node
			currNode = currNode.next;
                        System.out.println();
                        counter++;
		}
                return t;
	}

	// Method to delete a node in the LinkedList by POSITION
	public static LinkedList
	deleteAtPosition(LinkedList list, int index)
	{
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
			}
			else {
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
        
        // Method to delete a node in the LinkedList by POSITION
	public static String
	findAtPosition(LinkedList list, int index)
	{
            String returnValue = ""; 
		// Store head node
		Node currNode = list.head, prev = null;

		//
		// CASE 1:
		// If index is 0, then head node itself is what we want

		if (index == 0 && currNode != null) {
			returnValue = list.head.data;

			// Display the message
			System.out.println(
				index + " position element found");

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

				// Display the message
				System.out.println(
					 index + " position element found");
				break;
			}
			else {
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

		// return the List
		return returnValue;
	}

//	// **************MAIN METHOD**************
//
//	// method to create a Singly linked list with n nodes
//	public static void main(String[] args)
//	{
//		/* Start with the empty list. */
//		LinkedList list = new LinkedList();
//
//		//
//		// ******INSERTION******
//		//
//
//		// Insert the values
//		list = insert(list, 1);
//		list = insert(list, 2);
//		list = insert(list, 3);
//		list = insert(list, 4);
//		list = insert(list, 5);
//		list = insert(list, 6);
//		list = insert(list, 7);
//		list = insert(list, 8);
//
//		// Print the LinkedList
//		printList(list);
//
//		//
//		// ******DELETION AT POSITION******
//		//
//
//		// Delete node at position 0
//		// In this case the key is ***at head***
//		deleteAtPosition(list, 0);
//
//		// Print the LinkedList
//		printList(list);
//
//		// Delete node at position 2
//		// In this case the key is present ***in the
//		// middle***
//		deleteAtPosition(list, 2);
//
//		// Print the LinkedList
//		printList(list);
//
//		// Delete node at position 10
//		// In this case the key is ***not present***
//		deleteAtPosition(list, 10);
//
//		// Print the LinkedList
//		printList(list);
//	}
}
