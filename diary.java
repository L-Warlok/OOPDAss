import io.*;

public class diary
{
    public static void main( String[] args)
    {
        int option = 0;
        functionObject functions = new functionObject();

        do
        {
            System.out.println("1: Add diary event");
            System.out.println("2: List diary events");
            System.out.println("3: Print diary alerts");
            System.out.println("4: Exit");
            option = ConsoleInput.readInt("Select an option");
            switch(option)
            {
                case 1:
                    functions.add();
                    break;
                case 2:
                    functions.listEvents();
                    break;
                case 3:
                    functions.printAlerts();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Incorrect option selected, try again");
                    break;
            }
        }while (option != 4);
        System.out.println("Thanks for playing");

    }
}

