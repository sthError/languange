import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SuanFa {

    @Test
    public void t() {
        Solution solution = new Solution();
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = solution.threeSum(numbers);
        System.out.println("lists = " + lists);
    }
}

class Solution {

//    public List<List<Integer>> threeSum(int[] nums) {
//        List<List<Integer>> resp = new ArrayList<>();
//        Arrays.sort(nums);
//        int len = nums.length;
//        for (int i = 0; i < len - 2; ++i) {
//            int a = nums[i];
//            if (i > 0 && a == nums[i + 1]) {
//                continue;
//            }
//            if (a + nums[i + 1] + nums[i + 2] > 0) {
//                break;
//            }
//            if (a + nums[len - 1] + nums[len - 2] < 0) {
//                continue;
//            }
//
//            int j = i + 1, k = len - 1;
//            while (j < k) {
//                int sum = a + nums[j] + nums[k];
//                if (sum < 0) {
//                    ++j;
//                } else if (sum > 0) {
//                    --k;
//                } else {
//                    List<Integer> list = new ArrayList<>();
//                    list.add(a);
//                    list.add(nums[j]);
//                    list.add(nums[k]);
//                    resp.add(list);
//
//                    for (++j; j < k && nums[j] == nums[j - 1]; ++j) ; // 跳过重复数字
//                    for (--k; k > j && nums[k] == nums[k + 1]; --k) ; // 跳过重复数字
//                }
//            }
//        }
//        return resp;
//    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; ++i) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) continue; // 跳过重复数字
            if (x + nums[i + 1] + nums[i + 2] > 0) break; // 优化一
            if (x + nums[n - 2] + nums[n - 1] < 0) continue; // 优化二
            int j = i + 1, k = n - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0) --k;
                else if (s < 0) ++j;
                else {
                    ans.add(Arrays.asList(x, nums[j], nums[k]));
                    for (++j; j < k && nums[j] == nums[j - 1]; ++j); // 跳过重复数字
                    for (--k; k > j && nums[k] == nums[k + 1]; --k); // 跳过重复数字
                }
            }
        }
        return ans;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}