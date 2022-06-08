import java.lang.Math;

//finds the parent node of a given child node in a perfect binary tree that was made with Postorder traversal

class Main {
  public static void main(String[] args) {
    int h = 3 - 1;
    int[] q = { 7, 3, 5, 1 };
    int[] parent = new int[q.length];
    int end = (int) Math.pow(2, h+1) - 1;
                          // not doing h+1 because question for foobar is made with 0th index for binary height
    Boolean found = true;
    for (int i = 0; i < q.length; i++) {

      int currentHeight = h;
      int current = end; 

      found = false;
      int node = q[i];

      while (!found) {
        int right = (current - 1);
              int left = current-((int)Math.pow(2, currentHeight));

        if (node == end) {
          
          parent[i] = -1;
          found = true;
        }

        // check for wanted node
        if (left == node || right == node) {
          parent[i] = current;
          found = true;
        }

        else if (left < node) {
          current = right;
          currentHeight--;
        }

        else {
          current = left;
          currentHeight--;
        }
      }
    }
            System.out.println(parent[0]); //the parent node of 7 is -1 (the root)
            System.out.println(parent[1]); //the parent node of 3 is 7
            System.out.println(parent[2]); //the parent node of 5 is 6
            System.out.println(parent[3]); //the parent node of 1 is 3
  }
}
