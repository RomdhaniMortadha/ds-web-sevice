package com.example.demo.service;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import de.tekup.soap.models.whitetest.Adress;
import de.tekup.soap.models.whitetest.Exam;
import de.tekup.soap.models.whitetest.ObjectFactory;
import de.tekup.soap.models.whitetest.Student;
import de.tekup.soap.models.whitetest.StudentRequest;
import de.tekup.soap.models.whitetest.WhiteTestResponse;
import java.util.GregorianCalendar;
import java.util.Iterator;

@Service
public class DsEligebiltyService {
	List <Student> student=new ArrayList<>();
	List <Exam> Exams=new ArrayList<>();
	List <Adress>address=new ArrayList<>();
	public WhiteTestResponse checkEligebilty(StudentRequest StudentRequest) {
	
		WhiteTestResponse response=new ObjectFactory().createWhiteTestResponse();
		
		Student student1=new Student();
        Adress adress1=new Adress();
        Student student2=new Student();
        Adress adress2=new Adress();
		
		adress1.setCity("ariana");
		adress1.setStreet("soghra");
		adress1.setPostcode("3180");
		
		adress2.setCity("gabes");
		adress2.setStreet("chenini");
		adress2.setPostcode("6041");
		
		
		
		student1.setName("selmi khaled");
		student1.setId(1);
		student1.setAddress(adress1);
		
		student2.setName("Malek Abdelkader");
		student2.setId(2);
		student2.setAddress(adress2);
		
		Exam exam1=new Exam();
		Exam exam2=new Exam();

		
		exam1.setCode("1");
		exam1.setName("redhat");
		
		exam2.setCode("2");
		exam2.setName("OCA JAVA");
		
		
	student.add(student1);
	student.add(student2);

	Exams.add(exam1);
	Exams.add(exam2);
	address.add(adress1);
	address.add(adress2);

	
	Date curent_date=new Date();
	
	System.out.println(curent_date);
		XMLGregorianCalendar gd=null;
		
		GregorianCalendar gcalendar=new GregorianCalendar();
		
		gcalendar.setTime(curent_date);
		
	for	 (Student st:student)
		 {
			 for(Exam ex:Exams)
			 {
				 if(st.getId()==StudentRequest.getStudentId()&&ex.getCode().equals(StudentRequest.getExamCode())) {
					 try {
						 gd=DatatypeFactory.newInstance().newXMLGregorianCalendar(gcalendar);
					 }
					 catch (Exception e) {
						 e.printStackTrace();
					 }
					 response.setDate(gd);
					 response.setStudent(st);
					 response.setExam(ex);
					 response.setBadRequest("all is fine!");

				 }
				 else {
					 response.setBadRequest("bad request");
				 }
			 }
			 
		 }
		return response;
	}

}
