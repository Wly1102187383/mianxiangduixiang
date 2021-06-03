package mianxiangduixiang;


import java.util.Arrays;

public class Enroll {
private int year;
private int semester;
private Subject subj;
private Student stus[];
private int count;
public Enroll(int year, int semester, Subject subj, int max) {
super();
this.year = year;
this.semester = semester;
this.subj = subj;
this.stus = new Student[max];
}
public boolean add(Student stu){
if(stu == null)
return false;
if(count >= stus.length)
return false;
stus[count++] = stu;
return true;
}
public Student get(int index){
return stus[index];
}
public int indexOf(String id){
for(int i = 0; i < this.count; i++)
if(stus[i].getId().equals(id))
return i;
return -1;
}
public int size(){
return this.count;
}
@Override
public String toString() {
String info = "";
info = "ѧ��:" + this.year + ",ѧ��:" + this.semester + "\n";
info += this.subj.toString() + "\n\n";
info += "���\tѧ��\t����\n\n";
info += "======================\n\n";
for(int i = 0; i < count; i++)
info += (i + 1) + "\t" + stus[i].toString() + "\n\n";
info += "ѡ��������" + count + "\n";

return info;
}

public void drop(Student stu){
for(int i = indexOf(stu.getId()); i < this.count - 1; i++)
stus[i] = stus[i + 1];
count--;
}



}