package nyc.angus.algo;

import java.util.Stack;

/**
 * Utilities for lists.
 */
public class Lists {

	public static boolean isListPalindrome(final Node head) {
		if (head == null || head.data == null) {
			return true;
		}

		// 1. Determine half-way point in list, add first half to stack.
		final Stack<String> reversedHalf = new Stack<String>();

		Node singlePointer = head;
		Node doublePointer = head;

		boolean odd = false;

		while (doublePointer.next != null) {
			reversedHalf.add(singlePointer.data);
			singlePointer = singlePointer.next;

			doublePointer = doublePointer.next.next;

			if (doublePointer == null) { // End of list, singlePointer is at start.
				break;
			} else if (doublePointer.next == null) {
				odd = true;
				break;
			}
		}

		if (odd) {
			singlePointer = singlePointer.next;
		}

		// 2. Iterate through the rest of the list to check for a palindrome.

		while (singlePointer != null) {
			if (!singlePointer.data.equals(reversedHalf.pop())) {
				return false;
			}
			singlePointer = singlePointer.next;
		}

		return true;
	}

	public class Node {
		public Node next;
		public String data;

		public Node(final String data) {
			this.next = null;
			this.data = data;
		}
	}
}
