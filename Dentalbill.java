package Dental;

import java.text.NumberFormat;

/**
 * DentalBill.java
 * an invice class to calculate and display the dental bill
 * @author Natnael Tezera
 * 
 */
public class Dentalbill 
{
        //class constants
    final static double CLEANING = 35.0,
                        CAVITY = 150.0,
                        XRAY = 85.00,
                        FLOURIDE = 50.0,
                        ROOT = 750.00;
   double total = 0.0; //grand total for the fill
   StringBuffer display = new StringBuffer();
   private String patientName;
   private boolean cleaning;
   private boolean cavity;
   private boolean xray;
   private boolean flouride;
   private boolean rootCanal;
   private boolean other;
   private double amount;   
   
   //default construtor
   public Dentalbill()
   {
        patientName = "";
        cleaning = false;
        cavity = false;
        xray  = false;
        flouride = false;
        rootCanal  = false;
        other  = false;
        amount = 0.0;
   }
   //overloaded constructor
     public Dentalbill(String name, boolean clean, boolean cav, boolean xr,
             boolean fluor, boolean root, boolean other, double otherAmount)
   {
        patientName = name;
        cleaning = clean;
        cavity = cav;
        xray  = xr;
        flouride = fluor;
        rootCanal  = root;
        this.other  = other;
        amount = otherAmount;
   }
   /**
    * calculate the total bill 
    * return type is double 
    * other important javadocs go here
    * pre-post condition
    * parameters
    */
     
     public double calculateBill()
     {
         total = 0;
         if (cleaning)
             total += CLEANING;
          if (cavity)
             total += CAVITY;
          if (xray)
              total += XRAY;
          if (flouride)
              total += FLOURIDE;
          if (rootCanal)
              total += ROOT;
          if (other)
              total += amount;
          return total;
          
     }
     /**
      * an example of accssor method --- not needed (just for show)
      * 
      */
     public double getAmount()
     {
         return amount;
         
     }
     
     /**
      * an example of mutator
      * 
      */
     public void setAmount(double value)
     {
         amount = value;
     }
     
     /**
      * display the bill with all services provided
      * @param: none
      * @return: the bill as StringBuilder
      */
     public StringBuffer displayBill()
     {         
         NumberFormat dollars =  NumberFormat.getCurrencyInstance();
         display.append(padSpaces("Patient", patientName + '\n'));
         display.append('\n');
         
         if(cleaning) 
             display.append(padSpaces("cleaning", dollars.format(CLEANING)+'\n'));
         
         if(cavity) 
             display.append(padSpaces("cavity", dollars.format(CAVITY)+'\n'));
         
         
         if(xray) 
             display.append(padSpaces("X-ray", dollars.format(XRAY)+'\n'));
         
         if(flouride) 
             display.append(padSpaces("Flouride", dollars.format(FLOURIDE)+'\n'));
         
          if(rootCanal) 
             display.append(padSpaces("RootCanal" , dollars.format(ROOT)+'\n'));
        
         if(other) 
             display.append(padSpaces("Other", dollars.format(amount)+'\n'));
         display.append("------------------------------------" + '\n');
         
         display.append(padSpaces("Total", dollars.format(calculateBill())));
         return display;
     }
// davadocs here
     private StringBuffer padSpaces(String first, String second)
     {
         final int MAX_SPACES = 35;    //width of output taxtarea
         StringBuffer line = new StringBuffer(first);
         
         //find number of spaces needed to pad the string for tight justification
         int numSpaces = MAX_SPACES - first.length() - second.length();
         for (int i = 0; i < numSpaces; i++)
             line.append(" ");
         line.append(second);
         return line;
     }
  }
