 class Node
{
	public int data;
	public Node next;
}


public class GlobalMembers
{

	public static Node getNode(int data)
	{
		// allocate space
		Node temp = new Node();

		// put in data
		temp.data = data;
		temp.next = null;
		return temp;
	}

	// function to merge two sorted linked list
	// in a sorted manner
	public static Node sortedMerge(Node a, Node b)
	{
		Node result = null;

		/* Base cases */
		if (a == null)
		{
			return (b);
		}
		else if (b == null)
		{
			return (a);
		}

		/* Pick either a or b, and recur */
		if (a.data <= b.data)
		{
			result = a;
			result.next = sortedMerge(a.next, b);
		}
		else
		{
			result = b;
			result.next = sortedMerge(a, b.next);
		}
		return (result);
	}

	/* The function removes duplicates from a sorted list */
	public static void removeDuplicates(Node head)
	{
		/* Pointer to traverse the linked list */
		Node current = head;

		/* Pointer to store the next pointer of a node to be deleted*/
		Node next_next;

		/* do nothing if the list is empty */
		if (current == null)
		{
			return;
		}

		/* Traverse the list till last node */
		while (current.next != null)
		{

			/* Compare current node with next node */
			if (current.data == current.next.data)
			{

				/* The sequence of steps is important*/
				next_next = current.next.next;
				current.next = null;
				current.next = next_next;
			}
			else // This is tricky: only advance if no deletion
			{
				current = current.next;
			}
		}
	}

	// function to merge two sorted linked list
	// without duplicates
	public static Node sortedMergeWithoutDuplicates(Node head1, Node head2)
	{
		// merge two linked list in sorted manner
		Node head = sortedMerge(head1, head2);

		// remove duplicates from the list 'head'
		removeDuplicates(head);

		return head;
	}

	// function to print the linked list
	public static void printList(Node head)
	{
		while (head != null)
		{
			System.out.print(head.data);
			System.out.print(" ");
			head = head.next;
		}
	}

	// Driver program to test above
	public static void main(String[] args)
	{
		// head1: 1->1->4->5->7
		Node head1 = getNode(1);
		head1.next = getNode(2);
		head1.next.next = getNode(4);

		// head2: 2->4->7->9
		Node head2 = getNode(3);
		head2.next = getNode(4);
		head2.next.next = getNode(5);

		Node head3;

		head3 = sortedMergeWithoutDuplicates(head1, head2);

		printList(head3);}}
