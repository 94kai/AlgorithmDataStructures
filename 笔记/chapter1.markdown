
# 第一章 引论

## 1.1 本书讨论的内容

### 1.1.1 一个N个数的数组，求第k大（代码实现的是第k小，本质是一样的）的数


[点击查看代码](https://github.com/3440395/DataStructures/blob/master/code/DataStructures/app/src/main/java/com/xk/chapter1/No1_1_1.java)


#### 两种思路
* 最容易想到的：数组排序，return第k个元素

* 我没想到的，比第一种速度快：把前k个元素排序，放到新的数组中，后面的元素遍历，然后插入到新数组中合适的位置，注意，新数组的长度是不变的，所以溢出来的是要顶掉的

*代码中展示了书中提到的两种实现思路，在第七章中将会讲解一个更好的算法，对于前面代码中的两种算法需要几天才可以计算完成的工作量，只需要几秒，想想都很兴奋呢。。。*

### 1.1.2 输入一个元素为字符的二维数组以及N个单词（字典），输出数组中横竖斜几个方向的字母组合起来的出现在字典中的单词
> 有序三元组：有三个元素组成的组合，元素顺序不同，代表不同的组合，比如（1，2，3）和（3，2，1）

如表格所示，输入字典 this that two fat one three ok,最后的解将会是 this that two fat

|  |  |  |  |
|:-:|:-:|:-:|:-:|
| t | h | i | s |
| w | a | t | s |
| o | a | h | g |
| f | g | d | t |

#### 两种思路
* 有序三元组（x,y,方向）

* 有序四元组（x,y,方向，最大单词的长度） 该方法过滤掉了第一种方法中词汇超过最大单词长度的情况，节省了效率

[点击查看代码](https://github.com/3440395/DataStructures/blob/master/code/DataStructures/app/src/main/java/com/xk/chapter1/No1_1_2.java)