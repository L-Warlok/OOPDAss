import java.util.*;
import io.*;

public abstract class UniEvent
{
    private Calendar date;
    private String unit;

    public UniEvent() // default constructor, included for purpose of completeness
    {
        date = new GregorianCalendar();
        unit = new String("AAAA");
    }

    public UniEvent(String inUnit) // constructor used to initialise all UniEvent objects
    {
        unit = new String(inUnit);
        date = new GregorianCalendar();
        date.setLenient(false); // ensure logical date behaviour and allow out of bounds error checking
        setDate(); // initialise date values using setDate method
        System.out.println("Date input accepted");
    }

    public void setDate() // set the event date and ensure the values are legal
    {
            int year = 0;
            int month = 0;
            int day = 0;
            int hour = 0;
            int min = 0;

            year = ConsoleInput.readInt("What year is your event in?"); // read input date values
            month = ConsoleInput.readInt("What month is your event in?");
            day = ConsoleInput.readInt("What date is your event on?");
            hour = ConsoleInput.readInt("What hour does your event start?");
            min = ConsoleInput.readInt("What minute does your event start?");

        try // catch any instances of bad input values
        {
            date.clear();
            date.set(Calendar.YEAR, year);
            date.set(Calendar.MONTH, month);
            date.set(Calendar.DATE, day);
            date.set(Calendar.HOUR_OF_DAY, hour);
            date.set(Calendar.MINUTE, min);
            date.getTime();
        }
        catch (Exception e) // catch any errors thrown by getTime, the errors are only thrown when the object is accessed, not when it is modified
        {
            System.err.println("Error in date input: " + e.getMessage()); // print the exception error
            setDate(); // call the set error again and prompt for new date values
        }
    }

/*    public String diagyes()
    {
        return "this is very bad";
    }*/

    public String getUnit() // accessor for unit string
    {
        return unit;
    }
    public String dateToString() // return the date value as a string in the form "dd-mm-yyyy at hh:mm"
    {
        String retVal;
        int year = 0;
        int month = 0;
        int day = 0;
        int hour = 0;
        int min = 0;
        
        year = date.get(Calendar.YEAR);
        month = date.get(Calendar.MONTH);
        day = date.get(Calendar.DATE);
        hour = date.get(Calendar.HOUR_OF_DAY);
        min = date.get(Calendar.MINUTE);
        if ( min < 10 ) // this logic is to ensure that the time is printed correctly for minute values <10 ie 5:03 not 5:3
            retVal = new String(day + "-" + month + "-"  + year + " at " + hour + ":0" + min);
        else
            retVal = new String(day + "-" + month + "-"  + year + " at " + hour + ":" + min);

        return retVal;
    }
    
    public String getRemaining() // return a string containing the days, hours and minutes remaining until the UniEvent
    {
        GregorianCalendar current = new GregorianCalendar();
        long currentMillis = 0;
        long dateMillis = 0;
        long diff = 0;
        long temp = 0;
        long mins = 0;
        long hours = 0;
        long days = 0;
        String retVal = new String("X days, Y hours and Z minutes");

        currentMillis = current.getTimeInMillis();
        dateMillis = date.getTimeInMillis();
        diff = dateMillis - currentMillis;

        temp = diff / 60000;
        temp /= 60;
        days = temp / 24;
        retVal = retVal.replaceFirst("X", String.valueOf(days));

        temp = (diff - days * 24 * 60 * 60000) / 60000;
        hours = temp / 60;
        retVal = retVal.replaceFirst("Y", String.valueOf(hours));

        mins = (diff - (days * 24 * 60 * 60000 + hours * 60 * 60000)) / 60000;
        retVal = retVal.replaceFirst("Z", String.valueOf(mins));
        return retVal;
    }

    public abstract void printAlert();
    public abstract String toString();


}

