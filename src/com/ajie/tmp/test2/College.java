package com.ajie.tmp.test2;

/**
 * @author niezhenjie
 * 
 */
public class College {
	String name;
	/** 分数线 */
	float score;

	public College() {
		name = "普通大学";
		score = 180;
	}
	
	


	public String getName() {
		return name;
	}

	/**
	 * 是否可以进入改学校
	 * 
	 * @param s
	 */
	public boolean isCanEnter(StudentInfo s) {
		float sumScore = s.sumScore();
		return sumScore >= this.score;
	}

}
