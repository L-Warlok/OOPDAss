public class TuteEvent extends UniEvent 
{

    private int room;

    public TuteEvent() // default constructor included for completeness
    {
        super();
        room = 1;
    }

    // constructor used to build TuteEvent objects, used in the program
    public TuteEvent(String inUnit, int inRoom)
    {
        super(inUnit);
        if (checkRoom(inRoom))
            room = inRoom;
        else
        {
            System.out.println("Room number out of bounds, default set to 1");
            room = 1;
        }
    }

    public void printAlert() // definition of the printAlert method for the TuteEvent class
    {
        System.out.println("You have a tutorial in " + room + " for: " + super.getUnit() + " in " + super.getRemaining());
    }

    public String toString() // definition of the toString method for the TuteEvent class
    {
        String retVal = new String();

        retVal = super.dateToString() + " : " + super.getUnit() + " : " + room;
        

        return retVal;
    }
    
    private boolean checkRoom(int inRoom)
    {
        boolean retVal = false;
        if (inRoom>=1 && inRoom<=400)
            retVal = true;
        return retVal;
    }

}

