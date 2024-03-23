package project;

public class sinhvien_uit {
	private String id;
	private String name;
	private String Class;
	private String faculty;
	private String major;
	
	
	public sinhvien_uit(String id, String name, String Class,String faculty, String major) {
		this.id = id;
		this.name = name;
		this.Class = Class;
		this.faculty = faculty;
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "Student{ID: " + id + ", Name: " + name +", Class: " + Class + ", Faculty: " + faculty + ", Major: " + major +"}";  
	}
}
