package com.algorithm.july.twentyOne;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 <li>二叉搜索树</li>
 * 示例：
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * 解释：
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class DefinitionNodeSolution {

    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> treeNodes = generateTree(1, n);
        return treeNodes;
    }

    /**
     * 递归方法(类似于动态规划)
     */
    private List<TreeNode> generateTree(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftNodes = generateTree(start, i - 1);
            List<TreeNode> rightNodes = generateTree(i + 1, end);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    allTrees.add(new TreeNode(i,leftNode,rightNode));
                }
            }
        }
        return allTrees;
    }
}
