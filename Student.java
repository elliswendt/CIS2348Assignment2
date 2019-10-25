import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    Scanner input = new Scanner(System.in);
    private String firstName;
    private String lastName;
    private String psID;
    private String standing;
    private String emailID;
    private String addLine1;
    private String city;
    private String state;
    private String zip;
    static int count;

    public Student(int c){
        count = c;
    }

    public int getCount(){
        return count;
    }

    public void getInfo(){
        System.out.println("Enter first name: ");
        firstName = getFirstName();
        System.out.println("Enter last name: ");
        lastName = getLastName();
        System.out.println("Enter your psID: ");
        psID = getPsID();
        System.out.println("Enter class standing: ");
        standing = getStanding();
        System.out.println("Enter email address: ");
        emailID = getEmailID();
        System.out.println("Enter the 1st line of your address: ");
        addLine1 = getAddLine1();
        System.out.println("Enter the city: ");
        city = getCity();
        System.out.println("Enter the state: ");
        state = getState();
        System.out.println("Enter zip code: ");
        zip = getZIP();

    }
    public void displayInfo(){
        System.out.println("Name: " + firstName + " " + lastName + "\tpsID: " + psID + "\tStanding: " + standing +
                "\tEmail: " + emailID + "\tAddress: " + addLine1 + ", " + city + ", " + state + ", " + zip);
    }
    public String getFirstName(){
        String name = input.nextLine();
        for(int i = 0; i<name.length(); i++) {
            char c = name.charAt(i);
            if (!(Character.isLetter(c))) {
                System.out.println("Error: non-letter input, enter name again: ");
                firstName = getFirstName();
            }
        }
        return name;
    }
    public String getLastName(){
        String name = input.nextLine();
        for(int i = 0; i<name.length(); i++) {
            char c = name.charAt(i);
            if (!(Character.isLetter(c))) {
                System.out.println("Error: non-letter input, enter name again: ");
                lastName = getLastName();
            }
        }
        return name;
    }
    public String getPsID(){
        String n = input.nextLine();
        if (n.length() > 7){
            System.out.println("Error: ID entered too long, enter ID again: ");
            psID = getPsID();
        }
        for(int i = 0; i < n.length(); i++){
            char c = n.charAt(i);
            if(!(Character.isDigit(c))){
                System.out.println("Error: non-digit input, enter ID again: ");
                psID = getPsID();
            }
        }
        return n;
    }
    public String getStanding(){
        String s = input.nextLine();
        s = s.toLowerCase();
        if (s.equals("freshman"))
            return s;
        else  if (s.equals("sophomore"))
            return s;
        else if (s.equals("junior"))
            return s;
        else if (s.equals("senior"))
            return s;
        else {
            System.out.println("Error: incorrect input, enter freshman, sophomore, junior, or senior: ");
            standing = getStanding();
        }
        return s;
    }
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }
    public String getEmailID(){
        String e = input.nextLine();
        if (isValid(e) == false)
        {
            System.out.println("Error: invalid email format: ");
            emailID = getEmailID();
        }
        return e;
    }
    public String getAddLine1(){
        int i = 0;
        String a = input.nextLine();
        char c = a.charAt(i);
        while ((c != ' ')&&(i < a.length())){
            if(!(Character.isDigit(c)))
            {
                System.out.println("Error, address line 1 contains non-number character in house number. Enter address line again.");
                addLine1 = getAddLine1();
            }
            i++;
        }
        return a;
    }
    public String getCity(){
        String c = input.nextLine();
        for(int i = 0; i<c.length(); i++) {
            char ch = c.charAt(i);
            if (!(Character.isLetter(ch))) {
                System.out.println("Error: non-letter input, enter city again: ");
                city = getCity();
            }
        }
        return c;
    }
    public String getState(){
        String s = input.nextLine();
        if (!(s.length()==2)){
            System.out.println("Error: State code invalid, enter 2 letter code: ");
            state = getState();
        }
        s = s.toUpperCase();
        if (!(s.equals("AK"))&&!(s.equals("AL"))&&!(s.equals("AR"))
                &&!(s.equals("AZ"))&&!(s.equals("CA"))&&!(s.equals("CO"))&&!(s.equals("CT"))&&!(s.equals("DC"))&&!(s.equals("DE"))
                &&!(s.equals("FL"))&&!(s.equals("GA"))&&!(s.equals("HI"))
                &&!(s.equals("ID"))&&!(s.equals("IL"))&&!(s.equals("IN"))
                &&!(s.equals("IA"))&&!(s.equals("KS"))&&!(s.equals("KY"))
                &&!(s.equals("LA"))&&!(s.equals("ME"))&&!(s.equals("MD"))
                &&!(s.equals("MA"))&&!(s.equals("MI"))&&!(s.equals("MN"))
                &&!(s.equals("MS"))&&!(s.equals("MO"))&&!(s.equals("MT"))
                &&!(s.equals("NE"))&&!(s.equals("NV"))&&!(s.equals("NH"))
                &&!(s.equals("NJ"))&&!(s.equals("NM"))&&!(s.equals("NY"))
                &&!(s.equals("NC"))&&!(s.equals("ND"))&&!(s.equals("OH"))
                &&!(s.equals("OK"))&&!(s.equals("OR"))&&!(s.equals("PA"))
                &&!(s.equals("RI"))&&!(s.equals("SC"))&&!(s.equals("SD"))
                &&!(s.equals("TN"))&&!(s.equals("TX"))&&!(s.equals("UT"))&&!(s.equals("VT"))&&!(s.equals("VA"))
                &&!(s.equals("WA"))&&!(s.equals("WV"))&&!(s.equals("WI"))
            )
        {
            System.out.println("Error: State code invalid, enter correct code");
            state = getState();
        }
        return s;
    }
    public String getZIP(){
        String z = input.nextLine();
        if (!(z.length() == 9)){
            System.out.println("Error: ZIP code not 9 digits long, enter correct ZIP: ");
            zip = getZIP();
        }
        for(int i = 0; i < z.length(); i++){
            char c = z.charAt(i);
            if(!(Character.isDigit(c))){
                System.out.println("Error: non-digit input, enter ZIP again: ");
                zip = getZIP();
            }
        }
        return z;
    }
}
