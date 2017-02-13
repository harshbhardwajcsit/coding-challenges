/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parentofgivenchild;

/**
 *
 * @author samsung
 */
public class ParentOFgivenChild {

    public static void main(String[] args) {
    new ParentOFgivenChild().run();
  }
//node class
  static class Node {
    Node left;

    Node right;

    int value;

    public Node(int value) {
      this.value = value;
    }
  }



  //run

  public void run() {
    // build the simple tree from chapter 11.
    Node root = new Node(8);
    //System.out.println("Binary Tree Example");
    //System.out.println("Building tree with root value " + root.value);
    insert(root, 6);
    insert(root, 10);
    insert(root, 7);
    insert(root, 5);
    insert(root, 4);
    insert(root, 8);
    insert(root, 9);
    insert(root, 12);
//    System.out.println("Traversing tree in order");

    findParent(null, root);
   // printInOrder(root);

    
/*


     System.out.println("After mirror image");
     mirror_image(root);
     printInOrder(root);

*/

  }

  public void insert(Node node, int value) {
    if (value < node.value) {
      if (node.left != null) {
        insert(node.left, value);
      } else {
          /*
        System.out.println("  Inserted " + value + " to left of "
            + node.value);*/
        node.left = new Node(value);
      }
    } else if (value > node.value) {
      if (node.right != null) {
        insert(node.right, value);
      } else {
          /*
        System.out.println("  Inserted " + value + " to right of "
            + node.value);  */
        node.right = new Node(value);
      }
    }
  }

  public int search(Node node,int value){

     if(node.value==value)
       return node.value;
     if (node.value >value){
        return search(node.left, value);}
     else{
    return search(node.right, value);}
  }

  public void printInOrder(Node node) {
    if (node != null) {
      printInOrder(node.left);
      System.out.println(  node.value);
      printInOrder(node.right);
    }
  }
//using references of parent and child and call recursily for left and right subtree
  void findParent(Node parent,Node child){

  if(child==null){}
  else{
   if(child.value==7){System.out.print(parent.value);}
   else{

   findParent(child, child.left);
   findParent(child, child.right);
   }


  }









  }


}
