package com.ajie.tmp.test2;

/**
 * @author niezhenjie
 * 
 */
public class StudentInfo {
	/** 学生姓名 */
	private String name;
	/** A课程成绩 */
	private float scoreA;
	/** B课程成绩 */
	private float scoreB;
	/** C课程成绩 */
	private float scoreC;

	
	public StudentInfo(String name, float scoreA, float scoreB, float scoreC) {
		if(scoreA > 100 || scoreB > 100 || scoreC >100){
			System.out.println("抱歉，录入【"+name+"】分数有误");
			return;
		}
		this.name = name;
		this.scoreA = scoreA;
		this.scoreB = scoreB;
		this.scoreC = scoreC;
	}

	public float sumScore(){
		return scoreA + scoreB + scoreC;
	}
	
	public void check(){
		//先判断是否能被重点大学录取
		College college = new ExcellentCollege();
		if(college.isCanEnter(this)){
			System.out.println(this.name +" 恭喜您，您可以报重点大学");
			return;
		}
		college = new College();
		if(college.isCanEnter(this)){
			System.out.println(this.name+" 恭喜您，您可以报普通大学");
			return;
		}
		System.out.println(this.name+ " 抱歉，您的分数低于普通大学的分数线，继续努力！");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getScoreA() {
		return scoreA;
	}

	public void setScoreA(float scoreA) {
		this.scoreA = scoreA;
	}

	public float getScoreB() {
		return scoreB;
	}

	public void setScoreB(float scoreB) {
		this.scoreB = scoreB;
	}

	public float getScoreC() {
		return scoreC;
	}

	public void setScoreC(float scoreC) {
		this.scoreC = scoreC;
	}
	
	public static void main(String[] args) {
		StudentInfo si = new StudentInfo("张三" , 60,60,59);
		StudentInfo si2 = new StudentInfo("李四" , 60,60,60);
		StudentInfo si3 = new StudentInfo("王五" , 50,80,80);
		StudentInfo si4 = new StudentInfo("王五" , 60,80,80);
		StudentInfo si5 = new StudentInfo("王五" , 160,80,80);
		si.check();
		si2.check();
		si3.check();
		si4.check();
	}

}
