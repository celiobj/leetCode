
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

https://leetcode.com/problems/two-sum/description/

*/
package problems;

import java.util.Arrays;

/**
 *
 * @author celio.junior
 */
public class twoSum {

    public int[] twoSum(int[] nums, int target) {
        int numeroUm = 0;
        int numeroDois = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        numeroUm = j;
                        numeroDois = i;
                    }
                }
            }
        }
        int[] retorno = {numeroUm, numeroDois};
        return retorno;
    }

    public static void main(String[] ars) {
        twoSum ts = new twoSum();

//        int[] param = {1, 2, 3, 4, 5, 6, 7, 8};
//        int target = 10;
//        int[] param = {2,7,11,15};
//        int target = 9;
//        int[] param = {3,2,4};
//        int target = 6;
        int[] param = {3, 3};
        int target = 6;

        System.out.println(Arrays.toString(ts.twoSum(param, target)));
    }

}
