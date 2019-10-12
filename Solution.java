
/*
 *
 */
public class Solution {
	
	/*
	 * Queue node.
	 */
	static class Node {
		
		// **** members ****
		int 	data;
		Node	next;
		
		// **** constructor ****
		public Node(int data) {
			this.data 	= data;
			next 		= null;
		}
	}
	
	
	/*
	 * Circular queue.
	 */
	static class CircularQ {
		
		// **** members ****
		Node head;
		Node tail;
		
		// **** constructor ****
		public CircularQ() {
			head 	= null;
			tail 	= null;
		}
		
		// **** enqueue ****
		public int enqueue(int data) {
						
			// **** allocate node for data ****
			Node node = new Node(data);
			
			// **** check for an empty circular queue ****
			if ((head	== null) &&
				(tail  	== null)) {
				head 		= node;
//				tail 		= node;
//				tail.next	= head;
			}
			
			// **** circular queue NOT empty ****
			else {
				tail.next 	= node;
//				tail 		= node;
//				tail.next 	= head;
			}
			
			// **** ****
			tail 		= node;
			tail.next	= head;

			// **** ****
			return node.data;
		}

		// **** display ****
		public String display() {
			
			
			// **** check if circular queue is empty ****
			if (head == null)
				return "";
			
			// **** ****
			StringBuilder sb = new StringBuilder();
			
			// **** traverse the circular queue ****
			Node p = head;
			do {
				
				// **** append the data to the string ****
				if (p.next != head)
					sb.append(p.data + ", ");
				else
					sb.append(p.data);
				
				// **** move to the next element in the circular queue ****
				p = p.next;
			} while (p != head);
			
			// **** return string with data ****
			return sb.toString();
		}

		// **** peek ****
		public String peek() {

			// **** check if circular queue is empty ****
			if (head == null)
				return "";
			else
				return String.valueOf(head.data);
		}
		
		// **** dequeue ****
		public String dequeue() {
			
			// **** check if queue is empty ****
			if (head == null)
				return "";
			
			// **** ****
			Node h = head;
			
			// **** check if queue has more than one node ****
			if (head != tail) {
				head = head.next;
				tail.next = head;
			}
			
			// **** ****
			else {
				head = null;
				tail = null;
			}
			
			// **** ****
			return String.valueOf(h.data);
		}
		
		// **** isempty ****
		public Boolean isempty() {
			return head == null;
		}
	}

	
	/*
	 * Test scaffolding.
	 */
	public static void main(String[] args) {

		// **** instantiate a circular queue ****
		CircularQ cq = new CircularQ();
		
		// **** enqueue ****
		System.out.println("main <<< enqueue: " + cq.enqueue(1));
		System.out.println("main <<< enqueue: " + cq.enqueue(2));
		System.out.println("main <<< enqueue: " + cq.enqueue(3));
		System.out.println("main <<< enqueue: " + cq.enqueue(4));
		System.out.println();
		
		// **** peek and dequeue elements from the circular queue ****
		for (int i = 0; i < 5; i++) {
		
			// **** display the circular queue ****
			System.out.println("main <<< display: " + cq.display());
	
			// **** check if circular queue is empty ****
			System.out.println("main <<< isempty: " + cq.isempty());
			
			// **** peek head of queue ****
			System.out.println("main <<<    peek: " + cq.peek());
			
			// **** dequeue head of queue ****
			System.out.println("main <<< dequeue: " + cq.dequeue());
			
			// ???? ????
			System.out.println();
		}
	}

}
