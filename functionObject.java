import io.*;

public class functionObject
{
    private UniEvent[] diary = new UniEvent[2];
    private int index = 0;
    public functionObject()
    {

    }

    public void add()
    {
        int option = 0;
        String unit = new String();
        String hall = new String();
        int room = 0;

        if (index == 2)
        {
            System.out.println("The diary is full, you can not add any new events");
            option = 3;
        }
        while (option != 3 && index < 2)
        {
            System.out.println("1: Add lecture");
            System.out.println("2: Add tutorial");
            System.out.println("3: Exit");
            option = ConsoleInput.readInt("Select an option");


            switch(option)
            {
                case 1:
                    unit = ConsoleInput.readLine("Which unit?");
                    hall = ConsoleInput.readLine("Which lecture hall?");
                    diary[index] = new LectureEvent(unit, hall);
                    index ++;
                    break;
                case 2:
                    unit = ConsoleInput.readLine("Which unit?");
                    room = ConsoleInput.readInt("What is the room number?");
                    diary[index] = new TuteEvent(unit, room);
                    index ++;
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Incorrect option input, please try again");
                    break;
            }

        }
               
    }

    public void listEvents()
    {
        int i;

        for(i=0; i<index; i++)
            System.out.println(diary[i].toString());
    }

    public void printAlerts()
    {
        int i;

        for(i=0; i<index; i++)
            diary[i].printAlert();
    }

}


