import People.*;

import CustomExceptions.*;


import java.util.Collection;

import javax.swing.text.html.HTMLDocument.Iterator;

import Collections.*;
import Collections.Book;
import Collections.Newspaper;
import Collections.Journal;
import Collections.DVD;
import java.util.*;

public class Unit_Tests {


    public static void main(String[] args) {

        char[] h=new char[]{'P','o','t','a','t','o'};
        

        String r=new String("Potato");
        LibraryCollection.load();
   
        // create objects and make sure they throw the correct execptions at over and under 6 alphaNumeric characters
        try{
        Book B=new Book(r.toCharArray(), SectionCode.SCIENCES);
        Journal J=new Journal(r.toCharArray(), SectionCode.LAW);
        DVD D=new DVD(r.toCharArray(), SectionCode.ARTS);
        Newspaper N=new Newspaper(r.toCharArray(), SectionCode.NEWSPAPER);
        System.out.printf("Save returned %b",LibraryCollection.save());
        
       // h=J.getISSN();

    
       // System.out.printf("ISSN is %s\n",java.lang.Object.toString(h));


        System.out.println("\n*****Testing Book B*****\n");
        System.out.printf("Class is %s\n",B.getClass());
        System.out.printf("Section is %s\n",B.getSection());
        System.out.printf("ISBN is %s\n",new String(B.getISBN()));
        System.out.printf("isCheckedOut is %s\n",B.isCheckedOut());
        System.out.println("\nChecking out Book B\n");
        B.checkOut();
        System.out.printf("Class is %s\n",B.getClass());
        System.out.printf("Section is %s\n",B.getSection());
        System.out.printf("ISBN is %s\n",new String(B.getISBN()));
        System.out.printf("isCheckedOut is %s\n",B.isCheckedOut());
        
        System.out.println("\nChecking out Book B again\n");
        B.checkOut();
        System.out.printf("Class is %s\n",B.getClass());
        System.out.printf("Section is %s\n",B.getSection());
        System.out.printf("ISBN is %s\n",new String(B.getISBN()));
        System.out.printf("isCheckedOut is %s\n",B.isCheckedOut());

        System.out.println("\nReturning Book B\n");
        B.returnToCollection();
        System.out.printf("Class is %s\n",B.getClass());
        System.out.printf("Section is %s\n",B.getSection());
        System.out.printf("ISBN is %s\n",new String(B.getISBN()));
        System.out.printf("isCheckedOut is %s\n",B.isCheckedOut());

        System.out.println("\nReturning Book B again\n");
        B.returnToCollection();
        System.out.printf("Class is %s\n",B.getClass());
        System.out.printf("Section is %s\n",B.getSection());
        System.out.printf("ISBN is %s\n",new String(B.getISBN()));
        System.out.printf("isCheckedOut is %s\n",B.isCheckedOut());
        

        //Testing Journal
        System.out.println("\n*****Testing Journal J*****\n");
        System.out.printf("Class is %s\n",J.getClass());
        System.out.printf("Section is %s\n",J.getSection());
        System.out.printf("ISSN is %s\n",new String(J.getISSN()));
        System.out.printf("isCheckedOut is %s\n",J.isCheckedOut());

        System.out.println("\nChecking out Journal J\n");
        J.checkOut();
        System.out.printf("Class is %s\n",J.getClass());
        System.out.printf("Section is %s\n",J.getSection());
        System.out.printf("ISSN is %s\n",new String(J.getISSN()));
        System.out.printf("isCheckedOut is %s\n",J.isCheckedOut());
        
        System.out.println("\nChecking out Journal J again\n");
        J.checkOut();
        System.out.printf("Class is %s\n",J.getClass());
        System.out.printf("Section is %s\n",J.getSection());
        System.out.printf("ISSN is %s\n",new String(J.getISSN()));
        System.out.printf("isCheckedOut is %s\n",J.isCheckedOut());

        System.out.println("\nReturning Journal J\n");
        J.returnToCollection();
        System.out.printf("Class is %s\n",J.getClass());
        System.out.printf("Section is %s\n",J.getSection());
        System.out.printf("ISSN is %s\n",new String(J.getISSN()));
        System.out.printf("isCheckedOut is %s\n",J.isCheckedOut());

        System.out.println("\nReturning Journal J again\n");
        J.returnToCollection();
        System.out.printf("Class is %s\n",J.getClass());
        System.out.printf("Section is %s\n",J.getSection());
        System.out.printf("ISSN is %s\n",new String(J.getISSN()));
        System.out.printf("isCheckedOut is %s\n",J.isCheckedOut());

        //Testing Newspaper
        System.out.println("\n*****Testing Newspaper N*****\n");
        System.out.printf("Class is %s\n",N.getClass());
        System.out.printf("Section is %s\n",N.getSection());
        System.out.printf("ISSN is %s\n",new String(N.getISSN()));
        System.out.printf("isCheckedOut is %s\n",N.isCheckedOut());

        System.out.println("\nChecking out Newspaper N\n");
        N.checkOut();
        System.out.printf("Class is %s\n",N.getClass());
        System.out.printf("Section is %s\n",N.getSection());
        System.out.printf("ISSN is %s\n",new String(N.getISSN()));
        System.out.printf("isCheckedOut is %s\n",N.isCheckedOut());
        
        System.out.println("\nChecking out Newspaper N again\n");
        N.checkOut();
        System.out.printf("Class is %s\n",N.getClass());
        System.out.printf("Section is %s\n",N.getSection());
        System.out.printf("ISSN is %s\n",new String(N.getISSN()));
        System.out.printf("isCheckedOut is %s\n",N.isCheckedOut());

        System.out.println("\nReturning Newspaper N\n");
        N.returnToCollection();
        System.out.printf("Class is %s\n",N.getClass());
        System.out.printf("Section is %s\n",N.getSection());
        System.out.printf("ISSN is %s\n",new String(N.getISSN()));
        System.out.printf("isCheckedOut is %s\n",N.isCheckedOut());

        System.out.println("\nReturning Newspaper N again\n");
        N.returnToCollection();
        System.out.printf("Class is %s\n",N.getClass());
        System.out.printf("Section is %s\n",N.getSection());
        System.out.printf("ISSN is %s\n",new String(N.getISSN()));
        System.out.printf("isCheckedOut is %s\n",N.isCheckedOut());


         //Testing DVD
         System.out.println("\n*****Testing DVD D*****\n");
         System.out.printf("Class is %s\n",D.getClass());
         System.out.printf("Section is %s\n",D.getSection());
         System.out.printf("DOI is %s\n",new String(D.getDOI()));
         System.out.printf("isCheckedOut is %s\n",D.isCheckedOut());
 
         System.out.println("\nChecking out DVD D\n");
         D.checkOut();
         System.out.printf("Class is %s\n",D.getClass());
         System.out.printf("Section is %s\n",D.getSection());
         System.out.printf("DOI is %s\n",new String(D.getDOI()));
         System.out.printf("isCheckedOut is %s\n",D.isCheckedOut());
         
         System.out.println("\nChecking out DVD D again\n");
         D.checkOut();
         System.out.printf("Class is %s\n",D.getClass());
         System.out.printf("Section is %s\n",D.getSection());
         System.out.printf("DOI is %s\n",new String(D.getDOI()));
         System.out.printf("isCheckedOut is %s\n",D.isCheckedOut());
 
         System.out.println("\nReturning DVD D\n");
         D.returnToCollection();
         System.out.printf("Class is %s\n",D.getClass());
         System.out.printf("Section is %s\n",D.getSection());
         System.out.printf("DOI is %s\n",new String(D.getDOI()));
         System.out.printf("isCheckedOut is %s\n",D.isCheckedOut());
 
         System.out.println("\nReturning DVD D again\n");
         D.returnToCollection();
         System.out.printf("Class is %s\n",D.getClass());
         System.out.printf("Section is %s\n",D.getSection());
         System.out.printf("DOI is %s\n",new String(D.getDOI()));
         System.out.printf("isCheckedOut is %s\n",D.isCheckedOut());
 




        System.out.printf("Collection size = %s\n\n",LibraryCollection.getCollectionSize());
        }
         catch (InvalidIdentifierSizeException e) {
        
        }

        //test assosiated methods of LibraryCollections

     
        
    
        // Returns the numeric representation of the section 
        System.out.println("\nit is what it is");


        return;
    }        
}                 

    