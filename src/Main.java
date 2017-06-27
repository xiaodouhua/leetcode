import java.awt.print.Printable;

public class Main {

    public static  void main(String[] args) {
        Solution solution =new Solution();
        int [] num={1,1,2,3,3,4};
        System.out.println(solution.removeDuplicates(num));

        int [] num2={3,1,2,3,3,4};
        System.out.println(solution.removeElement(num2,3));
    }

}
