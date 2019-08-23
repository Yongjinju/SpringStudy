package com.encore.domain;

public class MissionVO
{
	String name;
	int age;
	String job;
	
	
	public MissionVO()
	{
		// TODO Auto-generated constructor stub
	}
	
	public MissionVO(String name, int age, String job)
	{
		super();
		this.name = name;
		this.age = age;
		this.job = job;
	}


	@Override
	public String toString()
	{
		return "MissionVO [name=" + name + ", age=" + age + ", job=" + job + "]";
	}
	
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getJob()
	{
		return job;
	}
	public void setJob(String job)
	{
		this.job = job;
	}
	
	
	
}
