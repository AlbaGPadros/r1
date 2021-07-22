package com.jobs.persistence;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;

public class EmployeeRepository{
	private static List<AbsStaffMember> members=new ArrayList<>();
	public EmployeeRepository(){

	}
	
	//Getter de la llista membres, que llista cada persona vinculada a l'emp (AbsStaffMember) i la seva info)
	public List<AbsStaffMember> getAllMembers(){
		return members;
		
	}

	
	public void addMember(AbsStaffMember member) throws Exception{
		if(member==null) throw new Exception();
		members.add(member);
	}
	
}
