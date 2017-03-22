// Implements a BST with TreeNode nodes

import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
// Normally, TreeNode and MyTreeSet would be "generic" (type-specific)
// classes and hold Comparable objects, but this is beyond the scope of
// the Java Methods book. Without @SuppressWarnings, this class would give
// three "Unchecked cast" warnings.

public class MyBST
{
	private TreeNode root;  // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST()
	{
		root = null;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(Object value)
	{
		return contains(root, value);
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(Comparable value)
	{
		if (contains(value))
			return false;
		root = add(root, value);
		return true;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(Comparable value)
	{
		if (!contains(value))
			return false;
		root = remove(root, value);
		return true;
	}

	// Returns a string representation of this BST.
	public String toString()
	{
		String str = toString(root);
		if (str.endsWith(", "))
			str = str.substring(0, str.length() - 2);
		return "[" + str + "]";
	}

	//*************** Private helper methods: *********************

	// Returns true if the BST rooted at node contains value;
	// otherwise returns false (recursive version).

	private boolean contains(TreeNode node, Object value)
	{
		if (node == null)
			return false;
		else
		{
			int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
			if (diff == 0)
				return true;
			else if (diff < 0)
				return contains(node.getLeft(), value);
			else // if (diff > 0)
				return contains(node.getRight(), value);
		}
	}

	/*
  // Iterative version:
  private boolean contains(TreeNode node, Object value)
  {
    while (node != null)
    {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff == 0)
        return true;
      else if (diff < 0)
        node = node.getLeft();
      else // if (diff > 0)
        node = node.getRight();
    }
    return false;
  }
	 */

	// Adds value to the BST rooted at node. Returns the
	// root of the new tree.
	// Precondition: the tree rooted at node does not contain value.
	private TreeNode add(TreeNode node, Comparable value)
	{
		if(node == null)
			node = new TreeNode(value);
		else if(node.getValue().compareTo(value)>0)
			node.setLeft(add(node.getLeft(), value));
		else
			node.setRight(add(node.getRight(), value));
		return node;
	}

	// Removes value from the BST rooted at node.
	// Returns the root of the new tree.
	// Precondition: the tree rooted at node contains value.
	private TreeNode remove(TreeNode node, Comparable value) {
		if(value.equals(node.getValue())) {
			return removeRoot(node);
		}
		else if(node.getValue().compareTo(value)>0)
			node.setLeft(remove(node.getLeft(), value));
		else
			node.setRight(remove(node.getRight(), value));
		return node;
	}

	// Removes the root of the BST rooted at root
	// replacing it with the smallest node from the right subtree.
	// Returns the root of the new tree.
	private TreeNode removeRoot(TreeNode root) {
		TreeNode traverse = root;
		if(traverse.getRight()!=null) {
			TreeNode last = null;
			traverse = traverse.getRight();
			while(traverse.getLeft()!=null) {
				last = traverse;
				traverse = traverse.getLeft();
			}
			root.setValue(traverse.getValue());
			if(last==null)
				root.setRight(traverse.getRight());
			else
				last.setLeft(traverse.getLeft());
			return root;
		} else if(root.getLeft()!=null) {
			return root.getLeft();
		} else {
			return null;
		}
	}
	
//	public boolean isBinaryTree(TreeNode root) {
//		boolean ok = true;
//		if(root.getLeft()!=null)
//			if(node.getValue().compareTo(value)<0)
//				ok = false;
//			
//		return ok;
//	}

	// Returns a string representation of the tree rooted at node.
	private String toString(TreeNode node)
	{
		if (node == null)
			return "";
		else
			return toString(node.getLeft()) + node.getValue() + ", " +
			toString(node.getRight());
	}

}
