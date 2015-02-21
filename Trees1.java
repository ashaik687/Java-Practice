
public class Trees1 {
    public static TrNode root=null;
	public TrNode insertInTree(TrNode node,int dat){
		
		if(node==null){
		TrNode t = new TrNode();
		//node=t;
		t.setData(dat);
			return t;	
		}
		if(dat>node.data){
			node.right=insertInTree(node.right,dat);
		}
		if(dat<=node.data){
			node.left=insertInTree(node.left,dat);
		}
		return node;
	}
	public void inorder(TrNode node)
	{
		if(node==null)
			return;
		inorder(node.left);
		System.out.println(node.data);
		inorder(node.right);	
	}
	public void preorder(TrNode node)
	{
		if(node==null)
			return;
		System.out.println(node.data);
		preorder(node.left);
		preorder(node.right);	
	}
	public void postorder(TrNode node)
	{
		if(node==null)
			return;
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.data);
	}
	
	public static int maxHeight(TrNode node){
		if(node.left==null && node.right==null){
			return 1;
		}
		if(node.left!=null && node.right!=null){
		return 1+Math.max(maxHeight(node.left),maxHeight(node.right));}
		if(node.left!=null){
			return 1+maxHeight(node.left);
		}
		if(node.right!=null){
			return 1+maxHeight(node.right);
		}
		return 0;
	}
	public static boolean findNode(TrNode node,int data){
		if(node.data==data)
			return true;
		if(node.left!=null && node.right!=null){
		return findNode(node.right,data)||findNode(node.left,data);	
		}
		if(node.left!=null){
			return findNode(node.left,data);
		}
		if(node.right!=null){
			return findNode(node.right,data);
		}
		return false;
	}
	public static TrNode search(TrNode node,int data){
		if(node.data==data){
			return node;
		}
		if(data>node.data)
		return search(node.right,data);
		if(data<=node.data)
		return search(node.left,data);
		return null;
	}
	public static void deleteNode(TrNode node,int data){
		TrNode delNode =Trees1.search(root, data);
	}
	public static int minValue(TrNode node){
		if(node==null){
           return -1;
		}
		if(node.left==null && node.right==null){
			return node.data;
		}
		int left=minValue(node.left);
		int right=minValue(node.right);
		
		return left<right?left:right;	
	}
	public static int depth2(TrNode node){
	    if(node == null)
	        return 0;
	    int left = depth2(node.left);
	    int right = depth2(node.right);
	     
	    int x = left > right ? left+1 : right+1;
	    return x;
	}
	
	public static void main(String[] args){
		
	   TrNode t=new TrNode();
		root=t;
		t.data=200;
		Trees1 tree = new Trees1();
		tree.insertInTree(root, 100);
		tree.insertInTree(root, 300);
		tree.insertInTree(root, 50);
		tree.insertInTree(root, 60);
		tree.insertInTree(root, 500);
		tree.insertInTree(root, 400);
        
		//tree.postorder(root);
		System.out.println(minValue(root));
		//System.out.println(findNode(root,100));
		//System.out.println(findNode(root,60));
		//System.out.println(findNode(root,500));
		//System.out.println(findNode(root,400));
		//System.out.println(findNode(root,700));
	}
}
