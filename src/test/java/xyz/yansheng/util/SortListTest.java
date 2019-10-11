package xyz.yansheng.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

/**
 * @author yansheng
 * @date 2019/10/11
 */
public class SortListTest {
    @Test
    public void testSortList() {

        User user1 = new User(1, "1111");
        User user2 = new User(2, "2222");
        User user3 = new User(3, "3333");
        User user4 = new User(4, "4444");

        List<User> users = new ArrayList<User>();
        users.add(user4);
        users.add(user1);
        users.add(user3);
        users.add(user2);

        System.out.println("排序前：");
        // jdk1.5:foreach遍历
        for (User user : users) {
            System.out.println(user.toString());
        }

        // 方法1.（java之前）用集合工具类Collections进行排序
        Collections.sort(users, new Comparator<User>() {

            @Override
            public int compare(User o1, User o2) {

                int id1 = o1.getId();
                int id2 = o2.getId();

                // 第一个数比较小，返回负数
                if (id1 < id2) {
                    return -1;
                } else {
                    return 1;
                }
            }

        });

        System.out.println("排序后：");
        // jdk1.8:forEach + Lambda表达式遍历
        users.forEach((User user) -> System.out.println(user.toString()));

        // 方法2.1（java8）用lambda排序
        users.sort((User o1, User o2) -> o1.getId() < o2.getId() ? -1 : 1);
        System.out.println("排序后：");
        users.forEach((User user) -> System.out.println(user.toString()));

        // 方法2.2（java8）用lambda+ “jdk8新特性之双冒号 :: ”排序
        users.sort(Comparator.comparingInt(User::getId));

        System.out.println("排序后：");
        users.forEach((User user) -> System.out.println(user.toString()));

    }

}

class User {
    private int id;
    private String username;

    /**
     * @param id
     * @param username
     */
    public User(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + "]";
    }

}