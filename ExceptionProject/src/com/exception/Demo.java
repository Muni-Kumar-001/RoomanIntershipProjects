package com.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.*;
import java.time.format.DateTimeFormatter;

class GreaterMarks extends RuntimeException {
    public GreaterMarks(String message) {
        super("GreaterMarksException");
    }
}

public class Demo {
    Student s1 = new Student(101, "A", 101);

    void result() throws FileNotFoundException {
    	if (s1.getMarks() > 100) {
            try {
                throw new GreaterMarks("Marks exceed 100");
            } catch (GreaterMarks e) {
            	try (FileInputStream fis = new FileInputStream("exceptionInfo.txt")) {
                    int byteRead;
                    StringBuilder content = new StringBuilder();
                    while ((byteRead = fis.read()) != -1) {
                        content.append((char) byteRead);
                    }
                    try (FileOutputStream fos = new FileOutputStream("exceptionInfo.txt")) {
                    	LocalDateTime d = LocalDateTime.now();
                        DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd-MM-yyyy      |     HH:mm:ss");
                        String formattedDate = d.format(dt);
                        String tExc = "|       "+e.getMessage()+"       |    "+formattedDate+"    |\r\n"
                        		+ "+-----------------------------------+--------------------+-----------------+\r\n";
                        byte[] exc = content.append(tExc).toString().getBytes();
                        fos.write(exc);
                    }
                    System.out.println(content.toString());
                } catch (IOException ioException) {
                    System.out.println("Error reading from file: " + ioException.getMessage());
                }
            }
    	}
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        try {
            d.result();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
