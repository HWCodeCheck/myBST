public class TreeNode
{
  private Comparable value;
  private TreeNode left;
  private TreeNode right;

  // Constructors:

  public TreeNode(Comparable initValue)
  {
    value = initValue;
    left = null;
    right = null;
  }

  public TreeNode(Comparable initValue, TreeNode initLeft, TreeNode initRight)
  {
    value = initValue;
    left = initLeft;
    right = initRight;
  }

  // Methods:

  public Comparable getValue() { return value; }
  public TreeNode getLeft() { return left; }
  public TreeNode getRight() { return right; }
  public void setValue(Comparable treeNode) { value = treeNode; }
  public void setLeft(TreeNode theNewLeft) { left = theNewLeft; }
  public void setRight(TreeNode theNewRight) { right = theNewRight; }
}
