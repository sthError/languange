import org.junit.Test;

public class ArrayPractice {

    private static int[] nums = {5, 2, 8, 1, 3};

    @Test
    public void t1() {
        int i = removeDuplicates(nums);
        System.out.println("i = " + i);
    }

    public int removeDuplicates(int[] nums) {

        int a = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[a]) {
                a++;
                nums[a] = nums[j];
            }
        }
        return a + 1;
    }

}
