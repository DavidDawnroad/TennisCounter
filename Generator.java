package com.test.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.security.SecureRandom;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Generator {
	
	public static void main(String[] args) {
		
				
		try {
			
			String path = ".\\dat\\dummy3.txt";//**개인별 경로 설정 확인하기
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			Random rnd = new Random ();
			SecureRandom secureRandom = new SecureRandom();
			
			String[] names1 = {"노박","카를로스","다닐","야닉","안드레이","스테파노","알렉산더","홀게르","후베르트","테일러","벤","우고","니콜라스","캐머런","이가","코코","온스","아리나","엘레나","캐를로인","페트라","마리아","라파엘","레일라"};
		    String[] names2 = {"조코비치","알키라스","메드베데프","시너","루블레프","치치파스","즈베레프","루네","후르카츠","프리츠","쉘튼","움베르","제리","노리","시비옹테크","고프","자베르","사발렌카","리바키나","가르시아","크비토바","사카리","나달","페르난데스"};
			
		    LocalDate today = LocalDate.now(); // 오늘 날짜
		    LocalDate endDate = today.withYear(2024); // 2024년, 당일까지 날짜 설정
            LocalDate startDate = LocalDate.of(2000, 1, 1); //2000년대 기록부터 불러오기
            long daysBetween = startDate.until(today, ChronoUnit.DAYS); 
		    
		    
			for(int i=1; i<=500; i++) {
				
				String line = "";
				
				line += ",";
				
				
					long randomDaysToAdd = (long)rnd.nextInt((int)(daysBetween + 1)); // 0부터 daysBetween까지 랜덤 추가
	                LocalDate randomDate = startDate.plusDays(randomDaysToAdd);
	                while (randomDate.getDayOfWeek() != DayOfWeek.MONDAY) { 
                    randomDate = randomDate.plusDays(1);
				    }
				    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
				    line += randomDate.format(formatter) + ",";
				
			
				    int year = randomDate.getYear(); //년 > 랜덤조합
				    int month = randomDate.getMonthValue();//월 >랜덤조합
					
				
					line += names1[rnd.nextInt(names1.length)]//이름 랜덤으로 조합하는 기능
							+ names2[rnd.nextInt(names2.length)]
					        + ",";
				  
					StringBuilder binaryString = new StringBuilder();//binaryString은 0과 1로 이루어진 10자리 문자열을 효율적으로 생성하기 위해 사용되는 StringBuilder 객체.
	                for (int n = 0; n < 10; n++) {
	                	binaryString.append(secureRandom.nextInt(2));//0~1까지 조합하여 10자리수를 생성.
	                }
	                line += binaryString.toString();
	                
				   System.out.println(line);
				   writer.write(line + "\r\n");
				}
				
				 writer.close();
				
				 
			} catch (Exception e) {
				System.out.println("Study.main");
				e.printStackTrace();
			}
				
		}//main
	}//class


