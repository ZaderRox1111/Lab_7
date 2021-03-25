package package_7;

public class InvestmentCalculator 
{
   // finance constants
   private static final int NUM_COMPOUNDS_PER_YEAR = 1;
   private static final int RULE_OF_72_FACTOR = 72;
    
   // default constructor default values
   private static final double DEFAULT_RATE = 0.05;
   private static final double DEFAULT_PRINCIPLE = 100000;
   private static final int    DEFAULT_YEARS = 30;
    
   // set table characters
   private static final char PIPE = '|';
   private static final String PIPE_SPACE = "| ";
   private static final String SPACE_PIPE = " |";
   private static final char THICK_LINE = '=';
   private static final char THIN_LINE = '-';

   // set table widths
   private static final int TABLE_WIDTH = 60;
   private static final int LEFT_COLUMN_WIDTH = 40;
   private static final int RIGHT_COLUMN_WIDTH = 17;

   // precision
   private static final int PRECISION = 3;
   
   // two endlines
   private static final int TWO_ENDLINES = 2;

   // member variables
   private double principle;
   private double rate;
   private int    years;

   
   /**
    * Default constructor
    */
   public InvestmentCalculator()
   {
        this.principle = DEFAULT_PRINCIPLE;
        this.rate      = DEFAULT_RATE;
        this.years     = DEFAULT_YEARS;
    }
   
   
   /**
    * Initialization Constructor
    * 
    * @param principle Initial investment
    * @param rate Rate of return
    * @param years Number of years compounded
    */
   public InvestmentCalculator(double principle, double rate, int years)
   {
        this.principle = principle;
        this.rate = rate / 100.0;
        this.years = years;
    }

   
   /**
    * Copy constructor
    * 
    * @param copied Object to copy from
    */
   public InvestmentCalculator(InvestmentCalculator copied)
   {
        this.principle = copied.principle;
        this.rate      = copied.rate;
        this.years     = copied.years;
   }

   
   /**
    * Computes number of years in which the principle doubles by compounding interest
    * 
    * @return Returns number of years
    */
   public double computeDoublingPeriod()
   {
       double doublingPeriod;
       
       doublingPeriod = RULE_OF_72_FACTOR / rate / 100.0;
       return doublingPeriod;
    }

   
   /**
    * Computes Computes the overall total, after the principle has compounded for the given number of years at the given rate of return
    * 
    * @return Returns the overall total
    */
   public double computeTotal() 
   {
       double rateUnit, parenthesized, totalInterest, total;
       
       rateUnit = rate / NUM_COMPOUNDS_PER_YEAR;
       parenthesized = 1 + rateUnit;
       totalInterest = Math.pow(parenthesized, years * NUM_COMPOUNDS_PER_YEAR);

       total = principle * totalInterest;
       
       return total;

    }

   /**
    * Displays the results in table format
    */
   public void displayResult() 
   {
      Console_IO_Class conIO = new Console_IO_Class();
      
      double total, doublingPeriod;
      
      total = computeTotal();
      doublingPeriod = computeDoublingPeriod();
      
      // display result
       //Will display the table containing the results
        //Method: printString, printChars, printChar, printEndline
      conIO.printChar(PIPE);
      conIO.printChars(TABLE_WIDTH -2, THICK_LINE);
      conIO.printChar(PIPE);
      conIO.printEndline();
      
      conIO.printString(PIPE_SPACE);
      conIO.printString("Principle", LEFT_COLUMN_WIDTH -2, "LEFT");
      conIO.printString(SPACE_PIPE);
      conIO.printDouble(principle, PRECISION, RIGHT_COLUMN_WIDTH -1, "RIGHT");
      conIO.printString(SPACE_PIPE);
      conIO.printEndline();
     
      conIO.printChar(PIPE);
      conIO.printChars(TABLE_WIDTH -2, THICK_LINE);
      conIO.printChar(PIPE);
      conIO.printEndline();
      
      conIO.printString(PIPE_SPACE);
      conIO.printString("Principle + Compounded Interest", LEFT_COLUMN_WIDTH -2, "LEFT");
      conIO.printString(SPACE_PIPE);
      conIO.printDouble(total, PRECISION, RIGHT_COLUMN_WIDTH -1, "RIGHT");
      conIO.printString(SPACE_PIPE);
      conIO.printEndline();
      
      conIO.printChar(PIPE);
      conIO.printChars(LEFT_COLUMN_WIDTH, THIN_LINE);
      conIO.printChar(PIPE);
      conIO.printChars(RIGHT_COLUMN_WIDTH, THIN_LINE);
      conIO.printChar(PIPE);
      conIO.printEndline();
     
      conIO.printString(PIPE_SPACE);
      conIO.printString("Approximate Doubling Period", LEFT_COLUMN_WIDTH -2, "LEFT");
      conIO.printString(SPACE_PIPE);
      conIO.printDouble(doublingPeriod, PRECISION, RIGHT_COLUMN_WIDTH -1, "RIGHT");
      conIO.printString(SPACE_PIPE);
      conIO.printEndline();
     
      conIO.printChar(PIPE);
      conIO.printChars(TABLE_WIDTH -2, THICK_LINE);
      conIO.printChar(PIPE);
      conIO.printEndlines(TWO_ENDLINES);
    }

}