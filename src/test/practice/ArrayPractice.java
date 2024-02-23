import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ArrayPractice {

    private static int[] nums = {5, 2, 8, 1, 3};

    @Test
    public void 遍历() {
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums = " + nums[i]);
        }
    }

    @Test
    public void 排序() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        log.info("sort==>:{}", JSONUtil.toJsonStr(nums));
    }

    @Test
    public void 插入排序() {
        int[] nums = {5, 2, 8, 1, 3};
        int j;
        // 默认第一个是排好的
        for (int i = 1; i < nums.length; i++) {
            int sort = nums[i];
            for (j = i - 1; j >= 0 && sort < nums[j]; j--) {
                nums[j] = sort;
            }
            nums[i] = nums[j];
        }
        for (int num : nums) {
            System.out.println("num = " + num);
        }
    }


    @Test
    public void 增() {
        int[] arr = new int[nums.length + 1];

        int target = 2;
        int value = 29;

        if (target > nums.length) {
            throw new RuntimeException("超长");
        }

        System.arraycopy(nums, 0, arr, 0, target);
        log.info("arr1===>:{}", JSONUtil.toJsonStr(arr));

        arr[target] = value;
        System.arraycopy(nums, target, arr, target + 1, nums.length - target);
        log.info("arr2===>:{}", JSONUtil.toJsonStr(arr));
    }

    @Test
    public void 删() {
        int[] arr = new int[nums.length - 1];

        int target = 2;

        if (target > nums.length) {
            throw new RuntimeException("超长");
        }

        System.arraycopy(nums, 0, arr, 0, target);
        log.info("arr1===>:{}", JSONUtil.toJsonStr(arr));

        System.arraycopy(nums, target + 1, arr, target, arr.length - target);
        log.info("arr2===>:{}", JSONUtil.toJsonStr(arr));
    }
}
