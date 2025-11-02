package mdi;

import menu.Menu;
import menu.MenuItem;

import session.Course;
import session.Session;
import people.Person;
import people.Student;
import people.Tutor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MavTutor {

    // construct and run the menu

    public MavTutor() {
        this.dirty = false;
        String clearScreen = "\n".repeat(80);    // Scroll all text off display
        
        // BONUS: Splash Screen
        try(Scanner in = new Scanner(new File("mdi/logo.txt"))) {
            while(in.hasNextLine()) logo.add(in.nextLine());
        } catch(IOException e) {
            logo.clear();
            logo.add("Welcome to MavTutor!");   // The title of the menu
            logo.add("=".repeat(logo.get(0).length()));
        }
        
        System.out.print(clearScreen);
        try {
            for(int i=0; i<27; ++i) {
                System.out.println((i<logo.size()) ? logo.get(i) : "");
                Thread.sleep(100);
            }
        } catch(Exception e) {
        }

        // Declare the menu
        menu = new Menu(
            new Object[] {clearScreen, logo},        // pre
            new Object[] {this, "\nSelection?"},     // post: 'this' invokes toString()
            new MenuItem("Quit",          () -> quit()),      // lambda
            new MenuItem("View Courses",  () -> selectView(courses)),
            new MenuItem("New Course",    this::newCourse),   // method reference
            new MenuItem("View Students", () -> selectView(students)),
            new MenuItem("New Student",   this::newStudent),
            new MenuItem("View Tutors",   () -> selectView(tutors)),
            new MenuItem("New Tutor",     this::newTutor),
            new MenuItem("View Sessions", () -> selectView(sessions)),
            new MenuItem("New Session",   this::newSession),
            new MenuItem("newz", () -> newz()),
            new MenuItem("save", () -> saveAs()),
            new MenuItem("saveAs", () -> save()),
            new MenuItem("open", () -> open())
        );
        // Main loop via the menu package, exit when menu.result == null
        menu.run();
    }
    public static void main(String[] args) {
        new MavTutor(); // The constructor starts the main loop1
    }
    
    // toString returns the view of the data to display below menu.result
    // See the 2nd term of the Menu constructor - "this" is this toString() reference
    
    @Override
    public String toString() {
        if(view == courses)  
            return Menu.listToString("Courses\n=======\n\n", courses, '•');
        if(view == students) 
            return Menu.listToString("Students\n========\n\n", students, '•');
        if(view == tutors)   
            return Menu.listToString("Tutors\n======\n\n", tutors, '•');
        if(view == sessions) 
            return Menu.listToString("Sessions\n========\n\n", sessions, '•');
        return "";
    }
    
    private void quit() {
        if (!safeToDiscardData()) {
            return;
        }
        menu.result = null; // Signals menu to exit the main loop
    }
    private void selectView(List list) {
        view = list; // Specifies which data to display via toString() below
    }
    private void newCourse() { // Create a course and add to courses List
        try {
            Course course = new Course(Menu.getString("Enter dept: "),
                                       Menu.getInt("Enter course number: "));
            if(course.equals(shazam)) {shazam(); return;}
            if(courses.indexOf(course) == -1) { // No duplicate courses
                courses.add(course);
                menu.result.append("Added " + course);
                setDirty(true);
            } else {
                menu.result.append("Course " + course + " is already defined!");
            }
        } catch(Exception e) {
            menu.result.append("Error adding Course: " + e.getMessage());
        }
        selectView(courses); // After adding a course, show it
    }
    private void newTutor() { // Create a tutor and add to tutors List
        try {
            if(courses.isEmpty()) {
                menu.result.append("Please define a course first!");
                return;
            }
            String name  = Menu.getString("Enter name: ");
            String email = Menu.getString("Enter email: ");
            Integer ssn  = Menu.getInt("Enter SSN: ");
            String bio   = Menu.getString("Enter biography: ");
            Integer index = Menu.selectItemFromList(
                "Select course of expertise: ", courses);
            Tutor tutor = new Tutor(name, email, ssn, bio, courses.get(index));
            tutors.add(tutor);
            menu.result.append("Added tutor " + tutor);
            setDirty(true);
        } catch(Exception e) {
            menu.result.append("Error adding Tutor: " + e.getMessage());
        }
        selectView(tutors);
    }
    private void newStudent() { // Create a student and add to students List
        try {
            if(courses.isEmpty()) {
                menu.result.append("Please define a course first!");
                return;
            }
            Student student = new Student(Menu.getString("Enter name: "),
                                          Menu.getString("Enter email: "));
            Integer index = null;
            int coursesAdded = 0;
            do {
                index = Menu.selectItemFromList("Select course of interest: ",
                                               courses);
                if(index != null) student.addCourse(courses.get(index));
            // Exit when no course OR ALL courses were added
            } while(index != null && courses.size() > ++coursesAdded);
            students.add(student);
            menu.result.append("Added student " + student);
            setDirty(true);
        } catch(Exception e) {
            menu.result.append("Error adding Student: " + e.getMessage());
        }
        selectView(students);
    }
    private void newSession() { // Create a session and add to sessions List
        try {
            if(courses.isEmpty()) {
                menu.result.append("Please define a course first!");
                return;
            }
            if(tutors.isEmpty()) {
                menu.result.append("Please define a tutor first!");
                return;
            }
            if(students.isEmpty()) {
                menu.result.append("Please define a student first!");
                return;
            }
            Integer i1 = Menu.selectItemFromList("Select course: ", courses);
            if(i1 == null) return;
            Course course = courses.get(i1);
            
            Integer i2 = Menu.selectItemFromList("Select tutor: ", tutors);
            if(i2 == null) return;
            Tutor tutor = tutors.get(i2);
            
            if(!tutor.getCourse().equals(course)) {
                menu.result.append("Error adding Session: " + tutor + " lacks expertise in " + course);
                return;
            }
            
            Session session = new Session(course, tutor);
            
            session.setSchedule(Menu.getString("Enter date (YYYY-MM-DD): "),
                                Menu.getString("Enter starting time (HH:mm): "),
                                Menu.getInt("Enter duration in minutes: "));

            Integer index = null;
            int studentsAdded = 0;
            do {
                index = Menu.selectItemFromList("Select student to add: ",
                                                students);
                if(index != null) session.addStudent(students.get(index));
            // Exit when no student OR ALL students were added
            } while(index != null && students.size() > ++studentsAdded);

            sessions.add(session);
            menu.result.append("Added " + session);
            setDirty(true);
            
        } catch(Exception e) {
            menu.result.append("Error adding Session: " + e.getMessage());
        }
        selectView(sessions);
    }

    // Easter egg (secret command) to load test data
    private final Course shazam = new Course("SZM", 9999); 
    private void shazam() {
        courses.add(new Course("CSE", 1310));
        courses.add(new Course("CSE", 1320));
        courses.add(new Course("CSE", 1325));
        courses.add(new Course("CSE", 1326));
        
        Student s1 = new Student("Suzy Q", "sq123@uta.edu");
        s1.addCourse(courses.get(0));
        students.add(s1);
        
        Student s2 = new Student("Alam Nguyen", "an345@uta.edu");
        s2.addCourse(courses.get(0));
        students.add(s2);
        
        Student s3 = new Student("Chi Vu", "cv876@uta.edu");
        s3.addCourse(courses.get(2));
        students.add(s3);
        
        tutors.add(new Tutor("Sam Smart", "ss987@uta.edu", 123456789, "Smart!", courses.get(0)));
        tutors.add(new Tutor("Suzuki Rin", "sr636@uta.edu", 123456789, "Suzuki!", courses.get(0)));
        
        menu.result.append("### S H A Z A M ! ###");    
        setDirty(true);  
    }

        private void newz() {
        if (!safeToDiscardData()) {
            return;
        }
        courses.clear();
        students.clear();
        tutors.clear();
        sessions.clear();
        file = null;
        setDirty(false);
        System.out.println("All data cleared.");
    }

    private void saveAs() {
        file = null;
        save();
    }

    private void save() {
        if (file == null) {
            file = Menu.selectFile();
            if (file == null) {
                menu.result.append("Save cancelled.");
                return;
            }
        }
        try (PrintStream out = new PrintStream(file)) {
            out.println(courses.size());
            for (Course course : courses) {
                course.save(out);
            }
            
            out.println(students.size());
            for (Student student : students) {
                student.save(out);
            }
            
            out.println(tutors.size());
            for (Tutor tutor : tutors) {
                tutor.save(out);
            }
            
            out.println(sessions.size());
            for (Session session : sessions) {
                session.save(out);
            }
            
            setDirty(false);
            System.out.println("Data saved successfully to " + file.getName());
            
        } catch (FileNotFoundException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private void open() {
        if (!safeToDiscardData()) {
            return;
        }
        
        File openFile = Menu.selectFile();
        if (openFile == null) {
            System.out.println("Open cancelled.");
            return;
        }
        
        try (Scanner in = new Scanner(new FileInputStream(openFile))) {
            courses.clear();
            students.clear();
            tutors.clear();
            sessions.clear();
            
            int courseCount = in.nextInt();
            in.nextLine(); 
            for (int i = 0; i < courseCount; i++) {
                courses.add(new Course(in));
            }
            
            int studentCount = in.nextInt();
            in.nextLine(); 
            for (int i = 0; i < studentCount; i++) {
                students.add(new Student(in));
            }
            
            int tutorCount = in.nextInt();
            in.nextLine(); 
            for (int i = 0; i < tutorCount; i++) {
                tutors.add(new Tutor(in));
            }
            
            int sessionCount = in.nextInt();
            in.nextLine(); 
            for (int i = 0; i < sessionCount; i++) {
                sessions.add(new Session(in));
            }
            
            file = openFile;
            setDirty(false);
            System.out.println("Data loaded successfully from " + file.getName());
            
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file: " + e.getMessage());
            newz();
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
            newz();
        }
    }

    // Bonus functionality methods
    private void setDirty(boolean value) {
        this.dirty = value;
    }

    private boolean safeToDiscardData() {
        if (!dirty) {
            return true;
        }
        
        while (true) {
            System.out.println("You have unsaved data. What would you like to do?");
            System.out.println("(S)ave data");
            System.out.println("(D)iscard data");
            System.out.println("(A)bort operation");
            
            String choice = System.console().readLine("Enter your choice: ").toUpperCase();
            
            switch (choice) {
                case "S":
                    save();
                    return !dirty; 
                    
                case "D":
                    setDirty(false);
                    return true;
                    
                case "A":
                    return false;
                    
                default:
                    System.out.println("Invalid choice. Please enter S, D, or A.");
            }
        }
    }
    // Our data fields
    
    private List<Course>  courses  = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Tutor>   tutors   = new ArrayList<>();
    private List<Session> sessions = new ArrayList<>();
    private File file = null;
    private boolean dirty;
    // Utility fields
    
    private Menu menu;
    private List view = courses; // List to view via toString()
    
    private List<String> logo = new ArrayList<>();
}
