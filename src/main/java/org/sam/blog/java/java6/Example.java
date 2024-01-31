package org.sam.blog.java.java6;

public class Example {
    public static void main(String[] args) {
        // 基本類型比較
        int a = 10;
        int b = 10;
        System.out.println(a == b); // true

        // 物件的比較
        Student student1 = new Student();
        Student student2 = new Student();
        System.out.println(student1 == student2); // false

        // 字串的比較
        String s1 = "hello world"; // 先在 String Pool 中尋找有沒有存在「hello world」的字串，發現沒有則建立一個
        String s2 = "hello world"; // 先在 String Pool 中尋找有沒有存在「hello world」的字串，發現已存在，直接引用
        String s3 = new String("hello world"); // 使用 new 創建的字串不會在 String Pool 裡面，而是在 heap 區裡面
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
        System.out.println(s1 == s3); // false
        System.out.println(s1.equals(s2)); // true
        System.out.println(s1.equals(s3)); // true

        // 不同型別的比較
        int x = 10;
        long y = 10;
        double z = 10;
        System.out.println(x == y); // true，int 會被提升為 long
        System.out.println(y == z); // true，long 會被提升為 double
        System.out.println(x == z); // true，int 會被提升為 double

        // Integer 的比較
        // 直接從記憶體中取出來，不會另外建立物件
        Integer i1 = 127;
        Integer i2 = 127;
        System.out.println(i1 == i2); // true

        // 超出範圍，建立新的 Integer 物件
        Integer i3 = 128;
        Integer i4 = 128;
        System.out.println(i3 == i4); // false
    }
}