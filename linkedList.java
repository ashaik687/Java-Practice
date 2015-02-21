import java.util.*;
public class linkedList {	
	public static node head1 = null;
	public static node head2 = null;
	public static node tmp=null;
	public static node headFinal = null;
	public static int carry = 0;
	public static node current;
	public static void insertInList(int x,int listNO){   // Insert a node into linked list		
		node n = new node(x);
		n.next= tmp;
		tmp = n;	
	if(listNO == 1){
		head1 = tmp;		
	}
	else if(listNO == 2){
		head2 = tmp;
	}
	else{
		headFinal = tmp;
	}
	}
	public static node insertExistingList(node head1,int g){  // Insert into an already present list and head is passed as a pointer
		node n = new node(g);
		n.next = head1;
		return n;
	}
	public void displayList(node g){    // show the complete linked list
		System.out.println("Printing now"+ g);
		//node curr = g;
		while(g != null){ 
		System.out.println(g.x);
		g = g.next;	
	}
		//
		//System.out.println(g.x);
	}
	public void deleteNode(int i,node head1){  // Delete a node in linkedlist
		while(head1.next.x != 7){
			head1= head1.next;
		} 
	head1.next = head1.next.next;
	}
	public node reverseList(node head2){   // Reverse a Linked List
		node prev = null;
		node curr = head2;
		node next = null;
		while(curr!= null){
		next = curr.next;
		curr.next = prev;
		prev= curr;
		curr = next;
		}	
		head1 = prev;
		return prev;
	}
	public void swapPairs(node head3){    //Swap the pairs of nodes in linked list
		node x,y,z = null;
		int i =0;
		while (head3.next.next != null){
			
		x = head3;
		y = head3.next;
		z = head3.next.next;
		head3.next.next = x;
		head3.next= z.next;
		if(i==0){ 
		head1 =y;
		i++;
		}
		head3 = z;
		}
		z.next.next = head3;
		head3.next = null;
	}
	public void alternateNodes(node head4,node head5){   // Adding nodes from alternate nodes into a new linked list     
		while (head4 != null || head5 !=null){
			linkedList.insertInList(head4.x,3);
			linkedList.insertInList(head5.x,3);
			head4 = head4.next;
			head5 = head5.next;
		}		
	}
	public static node appendZeroes(node head4,node head5){  //Compare length of two linked lists and append zeroes to shorter to equal lenghts of both.
		int count1 =0;
		int count2 =0;
		while(head4 != null){
			head4= head4.next;
			count1++;
		}
		while(head5 != null){
			head5= head5.next;
			count2++;
		}
		if(count1>count2){
			for(int i=0;i<count1-count2;i++){
			head2=linkedList.insertExistingList(head2, 0);
			return head2;
			}	
		}
		else if (count2>count1){
			for(int i=0;i<count2-count1;i++){
				head1=linkedList.insertExistingList(head1, 0);
				}
			return head1;	
		}
		return null;			
	}
	public void segregate(node head4){   //Segregate even and odd nodes in a Linked List
		node z1=head4;
		node prev=head4;
		head4=head4.next;
		while(head4 != null){
		if(head4.x%2!=0){
			prev=head4;
			head4 = head4.next;
		//return;
		}	
		else{
			node z2 = head4;
			head4=head4.next;
			prev.next = z2.next;
			z2.next=z1.next;
			z1.next =z2;
			z1=z2;
		}
		}		
	} 
	public void mergeListToAnother(node head4,node head5){  //Merge a linked list into another linked list at alternate positions
		while (head4 != null && head5 !=null){
			node x,y = null;
			x = head4.next;
			head4.next = head5;
			y=head5.next;
			head5.next = x;
			head4 = x;
			head5 = y;
		}
		head2 = null;
	}
	public void deleteAfterXXNodes(node head4){    //Delete N nodes after M nodes of a linked list     Question is at
	try{									//http://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/
	while(head4 != null){
		node tmp1 = null;		
		for(int i=0; i<3 && head4 != null;i++ ){
		tmp1 = head4;
		head4 = head4.next;	
		} 		
		if(head4 != null){
		for(int i=0;i<2 && head4 != null;i++){
			head4 = head4.next;
		}
		}
		tmp1.next = head4;
	}
	
	
	}catch(NullPointerException e)
    {
        System.out.print("NullPointerException caught");
    }}
	public node adding(node head1,node head2,int cary){     // Adding data from two linked list and forming an another linked list
		if(head1 == null){
			return null;
		}
		node n = new node(0);
		n.next= adding(head1.next,head2.next,carry);
		int z = head1.x+head2.x+carry;
		int sum = z % 10;
		carry = z/10;
		//carry = carry*10;
		n.x = sum;
		return headFinal = n;
	}
	public node makeFirsteventoHead(node head4){   // Find the first even node and make it the head of the linked list
		node curr = head4;
		node prev = null;
		while(curr.x%2==1){
			prev = curr;
			curr=curr.next;
		}
	prev.next=curr.next;
	curr.next=current;
	//head1=curr;
		return curr;	
	}
	public void reverseAlternateKnodes(node head4){
		try
		{
		while(head4 != null){
			node inter = null;
			node inter2 =null;
			node prev1 =null;
			node curr=null;
			for(int i=0;(i<3 && head4!=null);i++){
				inter=head4;// inter has pointer of the intermediate node which has the address of where we left to reverse.
				head4=head4.next;
				inter2=head4;
			}			
			for(int i=0;(i<3 && head4!=null);i++){
									//prev1 has pointers of the node after reversing in each iteration
				curr = head4;
				node next = null;
				next = curr.next;
				curr.next = prev1;
				prev1= curr;
				curr = next;
				head4=next;
			}
			if(inter!=null && inter2!= null)
			{	
			inter.next=prev1;
			inter2.next=curr;
			}
			}
	}catch(NullPointerException e)
    {
        System.out.print("NullPointerException caught");
    }
	}
	public boolean palindrome(node head4){
		node curr1=head4;
		node curr2=head4;
		int length=0;
		while(curr2.next!=null){
		curr1=curr1.next;
		length++;
		curr2=curr2.next.next;
		if(curr2==null){
			//length = 2*length +1;
			curr2.next=null;
		}
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	linkedList link = new linkedList();
		int i;
	for(i =0;i<10;i++ ){
		Scanner user_input = new Scanner(System.in);
		System.out.println("Enter the next number in link list1");
		String f = user_input.next();
		int foo = Integer.parseInt(f);
		linkedList.insertInList(foo,1);		
	}
	tmp = null;
	for(i =0;i<0;i++ ){
		Scanner user_input = new Scanner(System.in);
		System.out.println("Enter the next number in link list2");
		String f = user_input.next();
		int foo = Integer.parseInt(f);
		linkedList.insertInList(foo,2);		
	}
	tmp = null;
	//link.reverseList(head);
	//link.deleteNode(7, head);
	
    //link.swapPairs(head);
	//link.alternateNodes(head1, head2);
	//link.mergeListToAnother(head1, head2);
	//link.deleteAfterXXNodes(head1);
	//linkedList.appendZeroes(head1, head2);
	//link.adding(head1, head2, carry);headFinal=linkedList.insertExistingList(headFinal,carry);
	
	//link.displayList(head1);
	//link.displayList(head2);

	/*current=head1; 
	if (current.x%2==1){
		node curr = current;
		node prev = null;
		while(curr.x%2==1){
			prev = curr;
			curr=curr.next;
		}
	prev.next=curr.next;
	curr.next=head1;
	head1=curr;
	} */

/*	current=head1;     Code for segregating the even and nodes 
	if (current.x%2==1){
	head1= link.makeFirsteventoHead(current);
	link.segregate(head1);
	}
	else{
		link.segregate(head1);
	}*/
	
	link.reverseAlternateKnodes(head1);
	
	link.displayList(head1);
	}
}
	
