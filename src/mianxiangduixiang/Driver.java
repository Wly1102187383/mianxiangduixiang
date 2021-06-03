package mianxiangduixiang;


import java.util.Scanner;

public class Driver {

private static Enroll enroll;
public static void main(String[] args) {
// TODO Auto-generated method stub
int choice;

choice = menu();
while(choice != 5){
switch(choice){
case 1:
Create();
break;
case 2:
add();
break;
case 3:
print();
break;
case 4:
drop();
break;
default:
System.out.println("选课无效！");
}
choice = menu();
}
System.out.println("bye，欢迎下次继续使用!");

}
public static int menu(){
Scanner scan = new Scanner(System.in);
int choose;

System.out.println("===欢迎访问WTU选课系统===");
System.out.println("1.创建课程");
System.out.println("2.学生选课");
System.out.println("3.打印名单");
System.out.println("4.退选课程");
System.out.println("5.退出系统");
System.out.print("请选择(1-4):");
choose = scan.nextInt();

return choose;

}
public static void Create(){
Scanner scan = new Scanner(System.in);

if(enroll != null) {
System.out.println("选课已创建，是否创新创建？(y/n):");
String s = scan.next();
if(s.equals("n"))
return;
}
System.out.print("请输入课程代码:");
String id = scan.next();
System.out.print("请输入课程名称:");
String name = scan.next();
System.out.print("请输入学年：");
int year = scan.nextInt();
System.out.print("请输入学期：");
int semester = scan.nextInt();
Subject subj = new Subject(id, name);
System.out.print("请输入最大人数：");
int max = scan.nextInt();
enroll = new Enroll(year, semester, subj, max);
System.out.println("选课创建成功！信息如下：");
System.out.println(subj.toString());
System.out.println("学年：" + year + ",学期:" + semester + ",最大人数：" + max);
}
public static void add(){
if(enroll == null){
System.out.println("请先创建选课再执行该功能！");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("请输入学号:");
String id = scan.next();
if(enroll.indexOf(id) != -1){
System.out.println("学号：" + id + "已存在！不能再选！");
return;
}
System.out.println("请输入姓名:");
String name = scan.next();
Student stu = new Student(id, name);
if(enroll.add(stu))
System.out.println("祝贺你，选课成功，请坚持认真上课!");
else
System.out.println("很抱歉，选课失败！");
}
public static void print(){
if(enroll == null){
System.out.println("请先创建选课再执行该功能！");
return;
}
System.out.println(enroll.toString());
}
public static void drop(){
if(enroll == null){
System.out.println("请先创建选课再执行该功能！");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("请输入要退课的学生的代码:");
String id = scan.next();
if(enroll.indexOf(id) == -1){
System.out.println("退课失败，该学生未选这门课！");
return;
}
System.out.println("请输入要退课的学生的名字:");
String name = scan.next();
Student stu = new Student(id, name);
enroll.drop(stu);
System.out.println("退课成功");
}

}