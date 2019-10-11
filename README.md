# Generate LeetCode  Problemset List(GLPL)

## 说明

为 [LeetCode的问题集](https://leetcode-cn.com/problemset/all/) 生成目录导航列表。

形式为：

```
- [ ] 0001.两数之和(Two Sum) ：[题目描述](https://leetcode-cn.com/problems/two-sum/)，[解答](https://leetcode-cn.com/problems/two-sum/solution/)
- [ ] 0002.两数相加(Add Two Numbers) ：[题目描述](https://leetcode-cn.com/problems/add-two-numbers)，[解答](https://leetcode-cn.com/problems/add-two-numbers/solution/)
```

因为暂时只找到英文版的json数据，故现有格式为：

```
- [ ] 0001.Two Sum：[Description](https://leetcode.com/problems/two-sum/description/)，[Solution](https://leetcode.com/problems/two-sum/solution/)
- [ ] 0002.Add Two Numbers：[Description](https://leetcode.com/problems/add-two-numbers/description/)，[Solution](https://leetcode.com/problems/add-two-numbers/solution/)
```

markdown表现为：

- [ ] 0001.Two Sum：[Description](https://leetcode.com/problems/two-sum/description/)，[Solution](https://leetcode.com/problems/two-sum/solution/)
- [ ] 0002.Add Two Numbers：[Description](https://leetcode.com/problems/add-two-numbers/description/)，[Solution](https://leetcode.com/problems/add-two-numbers/solution/)

## 问题

~~LeetCode  的网页大部分内容为后期js动态加载，所以需要爬取动态的网页，暂时还未学到，只能先放着了。~~

找到了对应的json文件，网址为：<https://leetcode.com/api/problems/all/>，解析该json数据可得到需要的数据，唯一可惜的就是好像只有英文版、没有中文版。

已将该json文件下载到本仓库，并进行了格式化：[leetcode-api.json](https://github.com/yansheng836/GLPL/blob/master/leetcode-api.json)。

另外，可参考我的一个Python项目：[spider-test-2leetcode问题集目录](<https://github.com/yansheng836/spider-test#2leetcode问题集目录>)。

## 生成文件

- [LeetCode问题集目录.md](<https://github.com/yansheng836/GLPL/blob/master/LeetCode问题集目录.md>)
- [LeetCode问题集目录-简单.md](<https://github.com/yansheng836/GLPL/blob/master/LeetCode问题集目录-简单.md>)
- [LeetCode问题集目录-中等.md](<https://github.com/yansheng836/GLPL/blob/master/LeetCode问题集目录-中等.md>)
- [LeetCode问题集目录-困难.md](<https://github.com/yansheng836/GLPL/blob/master/LeetCode问题集目录-困难.md>)

## 使用

### 简单使用

下载最新的发布包：[![GitHub release (latest by date including pre-releases)](https://img.shields.io/github/v/release/yansheng836/GLPL?include_prereleases)](https://github.com/yansheng836/GLPL/releases)

用cmd运行命令：(“*"表示对应版本)

```bash
java -jar GLPL-*-SNAPSHOT.jar

# 下面为输出内容
正在爬取数据，请稍候……
写数据到：./LeetCode问题集目录.md 成功！共有 1220 条数据。
写数据到：./LeetCode问题集目录-简单.md 成功！共有 352 条数据。
写数据到：./LeetCode问题集目录-中等.md 成功！共有 616 条数据。
写数据到：./LeetCode问题集目录-困难.md 成功！共有 252 条数据。
```

可在当前目录生成 **LeetCode的问题集生成目录导航列表** 文件，当然你也可以添加一些说明。

### 开发

1. git clone <https://github.com/yansheng836/GLPL.git>
2. 以Maven形式导入IDE。
3. 运行`/GLPL/src/main/java/xyz/yansheng/main`下面的`Main`主程序。
4. 或者按需开发自己的程序。

## License

This work is licensed under a [MIT](https://github.com/yansheng836/GLPL/blob/master/LICENSE.txt).

## 声明

- 本项目仅用于学习交流使用，**禁止**进行商业目的的开发、发布、运营等。数据所有权归 [https://leetcode-cn.com](https://leetcode-cn.com/) 所有。
