# Array

|               题目               |                             思路                             |
| :------------------------------: | :----------------------------------------------------------: |
|        二维数组中的查找04        |                  从矩阵左下角的元素开始遍历                  |
|        数组中重复的数字03        |                           使用set                            |
|       旋转数组的最小数字11       |                            二分法                            |
| 调整数组顺序使奇数位于偶数前面21 |                            双指针                            |
|         顺时针打印矩阵29         |  使用四个变量存储边界值，每次边界值发生改变后就判断是否越界  |
|  数组中出现次数超过一半的数字39  | 当vote=0时将当前数设置为x，后续的数都是和x比较，和x相等则vote+1，否则vote-1 |
|          最小的k个数40           | 使用快排时注意在循环体中交换完哨兵位置的元素后，跳出循环需要交换基准数和左哨兵位置的元素 |
|         数组中的逆序对51         | 采用归并排序的思想：在将左右两个子数组比较合并时，根据两个子数组都是有序这一特点，如果左指针指向元素大于右指针指向元素，则右指针指向元素小于左指针指向元素及其后续元素 |



# BinaryTree

|            题目            |                             思路                             |
| :------------------------: | :----------------------------------------------------------: |
|        重建二叉树07        |               先找根节点位置,再确定左子树大小                |
|        树的子结构26        |        找根节点相同一个递归，再找子树结构相同一个递归        |
|       二叉树的镜像27       |                      相对于交换两个数字                      |
|       对称的二叉树28       | dfs(left.left, right.right) && dfs(left.right, right.left);  |
|   从上到下打印二叉树Ⅰ32    |             使用List存储结果，再输出到int数组中              |
|   从上到下打印二叉树II32   |   在while循环中使用temp列表并利用for循环存储每一层的节点值   |
|  从上到下打印二叉树III32   | 判断result存储的列表数为奇数还是偶数,然后使用Collections.reverse |
| 二叉搜索树的后序遍历序列33 | 以当前区间最后一个节点为根节点,找到该区间第一个大于根节点值的节点位置，该位置左侧为左子树，右侧继续判断是否都大于根节点的值(即判断遍历的下标是否到区间最后一位) |
| 二叉树中和为某一值的路径34 | 使用回溯法，在最后记得在curSum中减去添加的节点值，并且从列表中移除 |
|   二叉搜索树与双向链表36   | 先构建除了首尾节点的双向关系(在进行中序遍历的同时进行),完成后再单独构建首尾节点的双向关系 |
|       序列化二叉树37       | 序列化的层次遍历不需要对左右孩子判空；反序列化在遍历序列化形成的字符串的时候使用一个下标记录当前遍历字符串的位置即可 |



# DFSBFS

|        题目        |                           思路                            |
| :----------------: | :-------------------------------------------------------: |
| 机器人的运动范围13 | 边界判断+是否遍历过当前位置,且visited数组使用后不需要重置 |
|   矩阵中的路径12   |      将遍历过的位置置为其他字符,并且在使用后需要重置      |



# DP

|         题目         |                             思路                             |
| :------------------: | :----------------------------------------------------------: |
|    斐波那契数列10    |                      自低向上,注意取余                       |
|   正则表达式匹配19   |                    从匹配串的末尾开始匹配                    |
|   青蛙跳台阶问题10   |                      自低向上,注意取余                       |
| 连续子数组的最大和42 | 比较以nums[i]作为原连续子数组的结尾(dp[i-1]+nums[i])和将其作为新数组的结尾(nums[i])时的值，并将较大的值作为dp[i]的值。最后的结果是所有dp[i]的值中最大的值 |
| 把数字翻译成字符串46 | 考虑能否将$x_{i-1}x_i$进行整体翻译：如果可以则可以选择整体翻译或者单独翻译$x_i$；不行的话只能选择单独翻译。能否整体翻译的标准为是否在[10,25]范围内 |
|   礼物的最大价值47   | 注意第一行和第一列的值需要累加，转移方程为$dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];$ |



# Greedy

|         题目         |                             思路                             |
| :------------------: | :----------------------------------------------------------: |
|     剪绳子II 14      |              循环取余,保证每次运算都在int范围内              |
|      剪绳子Ⅰ14       |      当所有绳段长度相等时，乘积最大；最优的绳段长度为3       |
| 把数组排成最小的数45 | 将int数组转为String数组，根据排序条件x+y<y+x进行排序：如果满足，则x排在y前面；否则y排在x后面 |



# LinkedList

|            题目            |                             思路                             |
| :------------------------: | :----------------------------------------------------------: |
|     从尾到头打印链表06     |                       单链表的后续遍历                       |
|      删除链表的节点18      |                   pre=head；cur=head.next;                   |
|   链表中倒数第k个节点22    |        快指针先移动k个位置,然后慢指针和快指针一起移动        |
|         反转链表24         | 使用一个pre=null和cur=head迭代；递归则以原head作为最后一个节点进行处理 |
|    合并两个排序的链表25    |          需要dummy指针和move指针,最终返回dummy.next          |
|      复杂链表的复制35      | 使用HashMap时将原链表和新链表分别用key和value存储；拼接拆分即将新节点拼在原节点后形成一个链表，再修改新节点的random，最后拆分成两个链表 |
| 两个链表的第一个公共节点52 | 指针A和B同时遍历，指针A遍历完链表A就遍历链表B，指针B遍历完链表B就遍历链表A |



# StackQueue

|        题目        |                             思路                             |
| :----------------: | :----------------------------------------------------------: |
| 用两个栈实现队列09 | 将s1视为队列,删除操作时将s1中元素导入s2，最后再把s2的元素导回s1 |
| 包含min函数的栈30  |              使用辅助栈且将该栈构建为单调递减栈              |
| 栈的压入弹出序列31 | 将push栈元素依次加入辅助栈，并且每次将辅助栈和pop栈元素的栈顶间比较 |
| 数据流中的中位数41 | 使用一个大根堆和小根堆，分别保存数组中一半较小的元素和一半较大的元素，最后根据两个堆的大小关系取(两个堆/2.0)顶或(小根堆的堆顶) |



# String

|           题目           |                             思路                             |
| :----------------------: | :----------------------------------------------------------: |
|        替换空格05        |                      使用StringBuilder                       |
|    表示数值的字符串20    |              为不同字符设置标记位，然后逐个遍历              |
|      字符串的排列38      |     采用set对重复元素进行判重，将同一树层的节点进行交换      |
| 第一个只出现一次的字符50 | 使用有序Hash表LinkedHashMap存储，key为字符，value为是否出现过(出现过置为false) |



# SlideWindow

|             题目             |                             思路                             |
| :--------------------------: | :----------------------------------------------------------: |
| 最长不含重复字符的子字符串48 | 使用map统计各字符最后一次出现的索引位置,将该索引位置作为下一次遇到相同元素时左窗口需要移到到的位置 |



# other

|           题目           |                             思路                             |
| :----------------------: | :----------------------------------------------------------: |
|    二进制中1的个数15     |            n&=n-1:将n的二进制的最右边的数字1变为0            |
|  打印从1到最大的n位数17  |       大数的表示用String类型；先确定每个整数的首位数字       |
|     数值的整数次方16     |             使用long类型和double类型；将幂次二分             |
| 数字序列中某一位的数字44 | ①找第n位数对应的位数 ② 找n在当前位数的集合中的第几个数字(除法) ③ 确定所求数位在num的哪一数位(取余) |
|          丑数49          | 丑数只包含因子 2, 3, 5，且丑数=某较小丑数×某因子；第$n+1$个丑数为$x_{n+1} = min(x_a*2,x_b*3,x_c*5)$ |

