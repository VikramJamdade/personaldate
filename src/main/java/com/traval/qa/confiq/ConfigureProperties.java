package com.traval.qa.confiq;

import java.util.Random;

import com.github.javafaker.Faker;
import com.traval.qa.base.TestBaseGD;

public class ConfigureProperties extends TestBaseGD 
{
	
 public static String URL= "https://godo.staging-1.app.travel.win/";

 public static String Location="Paris, France";
 
 
 static Random random = new Random();

// to enter fake name we have use javafaker maven
 
 
 
 static Faker faker = new Faker();
public static String firstName1 = faker.name().firstName();

 
 
 public static String LastName1 = faker.name().lastName();
 
 public static String Phone_Number1  = "7418562820";
 
 public static String EmailID1  = "Jonson@yopmail.com";
 
 public static String Credit_Card_Number1= "4111 1111 1111 1110";
 
 public static String Month1= "05";
 public static String Year1= "30";
 
 public static String Security_Code1= "111";
 public static String  Address_11= "Alaska city,New Alaska";
 public static String  Address_22= "Near Vision gardon,New Alaska";
 
 public static String City1 ="Alaska";
 
 public static String Postal_Code1="25252";

//public static CharSequence firstName1;
 
 
}
