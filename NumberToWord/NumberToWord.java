package in.securtime.shared.util.commons;

import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class NumberToWord {

  public static final String[] units = { "", "One", "Two", "Three", "Four",
      "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
      "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
      "Eighteen", "Nineteen" };

  public static final String[] tens = {
      "", 		// 0
      "",		// 1
      "Twenty", 	// 2
      "Thirty", 	// 3
      "Forty", 	// 4
      "Fifty", 	// 5
      "Sixty", 	// 6
      "Seventy",	// 7
      "Eighty", 	// 8
      "Ninety" 	// 9
  };

  public static String convert(final Long number) {
    if (number<0) {
      return "Minus" + convert(-number);
    }else if(number<10) {
      return units[number.intValue()];
    } else if(number<20) {
      return units[number.intValue()];
    } else if(number < 100) {
      return tens[number.intValue()/10] + ((number/10)!=0?" ": "") + convert(number%10);
    } else if(number<1000) {
      return convert(number/100) + " Hundred" + ((number%100)!=0?" AND ": "") + convert(number%100);
    }else if(number<100000) {
      return convert(number/1000) + " Thousand" + ((number%1000)!=0?" ": "") + convert(number%1000);
    }
    else if(number<10000000) {
      return convert(number/100000) + " Lakh" + ((number%100000)!=0?" ": "") + convert(number%100000);
    }
    else /*(number<1000000)*/ {
      return convert(number/10000000) + " Crore" + ((number%10000000)!=0?" ": "") + convert(number%10000000);
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter the number to be converted: ");
    System.out.println(StringUtils.upperCase(convert(Long.parseLong(in.next()))));
  }

}
