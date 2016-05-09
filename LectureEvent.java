public class LectureEvent extends UniEvent 
{

    private String hall;

    public LectureEvent() // default constructor included for completeness
    {
        super();
        hall = new String("AAAA");
    }

    // constructor used to build LectureEvent objects, used in the program
    public LectureEvent(String inUnit, String inHall)
    {
        super(inUnit);
        hall = new String(inHall);
    }

    public void printAlert() // definition of the printAlert method for the LectureEvent class
    {
        System.out.println("You have a lecture in " + hall + " for: " + super.getUnit() + " in " + super.getRemaining());
    }

    public String toString() // definition of the toString method for the LectureEvent class
    {
        String retVal = new String();

        retVal = super.dateToString() + " : " + super.getUnit() + " : " + hall;
        

        return retVal;
    }

}

