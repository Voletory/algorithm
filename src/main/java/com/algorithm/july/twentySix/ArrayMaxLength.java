package com.algorithm.july.twentySix;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 * <p>
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 * 示例 2:
 * <p>
 * 输入: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArrayMaxLength {
    int[][] source;

    public int longestIncreasingPath(int[][] matrix) {
        int maxLength = 0;
        // DFS 搜索所有节点
        source = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLength = Math.max(maxLength, maxLength(i, j));
            }
        }
        return maxLength;
    }

    public int maxLength(int i, int j) {
        int maxLength = 0;
        // 遍历上下左右
        if (i > 0 && source[i - 1][j] > source[i][j]) {
            int up = maxLength(i - 1, j);
            maxLength = Math.max(up, maxLength);
        }
        if (i < source.length - 1 && source[i + 1][j] > source[i][j]) {
            int down = maxLength(i + 1, j);
            maxLength = Math.max(down, maxLength);
        }
        if (j > 0 && source[i][j - 1] > source[i][j]) {
            int left = maxLength(i, j - 1);
            maxLength = Math.max(left, maxLength);
        }
        if (j < source[0].length - 1 && source[i][j + 1] > source[i][j]) {
            int right = maxLength(i, j + 1);
            maxLength = Math.max(right, maxLength);
        }
        return maxLength + 1;
    }

}
