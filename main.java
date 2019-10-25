import java.util.Scanner;

public class main {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("# for students to put info for: ");
        int count = input.nextInt();

        Student s[] = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Student " + i+1 + ":");
            s[i] = new Student(count);
            s[i].getInfo();
        }
        System.out.println("Students Details, Department of ILT");
        for (int i = 0; i < count; i++) {
            s[i].displayInfo();
        }
        System.out.println("Number of Students: " + s[0].getCount());
    }
}
