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
System.out.println("ѡ����Ч��");
}
choice = menu();
}
System.out.println("bye����ӭ�´μ���ʹ��!");

}
public static int menu(){
Scanner scan = new Scanner(System.in);
int choose;

System.out.println("===��ӭ����WTUѡ��ϵͳ===");
System.out.println("1.�����γ�");
System.out.println("2.ѧ��ѡ��");
System.out.println("3.��ӡ����");
System.out.println("4.��ѡ�γ�");
System.out.println("5.�˳�ϵͳ");
System.out.print("��ѡ��(1-4):");
choose = scan.nextInt();

return choose;

}
public static void Create(){
Scanner scan = new Scanner(System.in);

if(enroll != null) {
System.out.println("ѡ���Ѵ������Ƿ��´�����(y/n):");
String s = scan.next();
if(s.equals("n"))
return;
}
System.out.print("������γ̴���:");
String id = scan.next();
System.out.print("������γ�����:");
String name = scan.next();
System.out.print("������ѧ�꣺");
int year = scan.nextInt();
System.out.print("������ѧ�ڣ�");
int semester = scan.nextInt();
Subject subj = new Subject(id, name);
System.out.print("���������������");
int max = scan.nextInt();
enroll = new Enroll(year, semester, subj, max);
System.out.println("ѡ�δ����ɹ�����Ϣ���£�");
System.out.println(subj.toString());
System.out.println("ѧ�꣺" + year + ",ѧ��:" + semester + ",���������" + max);
}
public static void add(){
if(enroll == null){
System.out.println("���ȴ���ѡ����ִ�иù��ܣ�");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("������ѧ��:");
String id = scan.next();
if(enroll.indexOf(id) != -1){
System.out.println("ѧ�ţ�" + id + "�Ѵ��ڣ�������ѡ��");
return;
}
System.out.println("����������:");
String name = scan.next();
Student stu = new Student(id, name);
if(enroll.add(stu))
System.out.println("ף���㣬ѡ�γɹ������������Ͽ�!");
else
System.out.println("�ܱ�Ǹ��ѡ��ʧ�ܣ�");
}
public static void print(){
if(enroll == null){
System.out.println("���ȴ���ѡ����ִ�иù��ܣ�");
return;
}
System.out.println(enroll.toString());
}
public static void drop(){
if(enroll == null){
System.out.println("���ȴ���ѡ����ִ�иù��ܣ�");
return;
}
Scanner scan = new Scanner(System.in);
System.out.println("������Ҫ�˿ε�ѧ���Ĵ���:");
String id = scan.next();
if(enroll.indexOf(id) == -1){
System.out.println("�˿�ʧ�ܣ���ѧ��δѡ���ſΣ�");
return;
}
System.out.println("������Ҫ�˿ε�ѧ��������:");
String name = scan.next();
Student stu = new Student(id, name);
enroll.drop(stu);
System.out.println("�˿γɹ�");
}

}