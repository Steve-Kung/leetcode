package twopoint;

import java.util.Arrays;

/*
给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
说明:

初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
示例:

输入:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

输出: [1,2,2,3,5,6]
 */
public class P88合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0){
            for (int i = 0; i< nums2.length; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        int i = m - 1;
        int j = n - 1;
        int k = nums1.length - 1;
        while (j >= 0 && i >= 0){
            if (nums2[j] >= nums1[i]){
                nums1[k] = nums2[j];
                j--;
                k--;
            } else if (nums2[j] < nums1[i]){
                nums1[k] = nums1[i];
                i--;
                k--;
            }
        }
        if (j != -1){
            for (int z = 0; z<= j; z++){
                nums1[z] = nums2[z];
            }
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{2,0};
        new P88合并两个有序数组().merge(num1, 1, new int[]{1}, 1);
        for (int num : num1) {
            System.out.println(num);
        }

    }
}
