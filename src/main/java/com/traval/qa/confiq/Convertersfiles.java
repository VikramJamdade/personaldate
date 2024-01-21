package com.traval.qa.confiq;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.traval.qa.base.TestBaseGD;
import com.traval.qa.pages.SearchHotels;

import java.time.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Convertersfiles extends SearchHotels
{
	Convertersfiles ca= new Convertersfiles();
	String inputString = "Wed, Jan 17th - Thu, Jan 18th";

    // Split the input string by the hyphen ("-")
    String[] parts = inputString.split(" - ");

    // Parse the start date using a formatter
    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("EEE, MMM d 'th'");
    LocalDate startDate = LocalDate.parse(parts[0], inputFormatter);

    // Parse the end date using the same formatter
    LocalDate endDate = LocalDate.parse(parts[1], inputFormatter);

    // Format the dates into the desired output format
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String formattedStartDate = startDate.format(outputFormatter);
    String formattedEndDate = endDate.format(outputFormatter);

    // Print the formatted date range
    String Check_IN = formattedStartDate;
    String Check_Out =formattedEndDate;
    



}
