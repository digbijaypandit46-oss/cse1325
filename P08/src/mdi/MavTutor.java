package mdi;

import menu.Menu;
import menu.MenuItem;
import java.util.ArrayList;
import java.util.List;
import menu.*;
import people.*;
import session.*;

public class MavTutor {
  private Menu menu;
  private List view;
  private ArrayList<Course> courses;
  private ArrayList<Student> students;
  private ArrayList<Tutor> tutors;
  private ArrayList<Session> sessions;

  public MavTutor() {
    this.courses = new ArrayList<>();
    this.students = new ArrayList<>();
    this.tutors = new ArrayList<>();
    this.sessions = new ArrayList<>();
    this.view = courses;
    initializeMenu();
  }

  private void initializeMenu() {
    menu = new Menu();
    
    // Create pre and post objects for the menu layout
    String clearScreen = "\n".repeat(80);
    String title = "MavTutor Main Menu";
    title += '\n' + "=".repeat(title.length()) + '\n';
    
    Object pre = new Object[] {clearScreen, title};
    Object post = new Object[] {"\nSelection? "};
    
    menu = new Menu(pre, post);
    
    menu.addMenuItem(new MenuItem("Create Course", this::newCourse));
    menu.addMenuItem(new MenuItem("Create Tutor", this::newTutor));
    menu.addMenuItem(new MenuItem("Create Student", this::newStudent));
    menu.addMenuItem(new MenuItem("Create Session", this::newSession));
    menu.addMenuItem(new MenuItem("View Courses", () -> selectView(courses)));
    menu.addMenuItem(new MenuItem("View Students", () -> selectView(students)));
    menu.addMenuItem(new MenuItem("View Tutors", () -> selectView(tutors)));
    menu.addMenuItem(new MenuItem("View Sessions", () -> selectView(sessions)));
    menu.addMenuItem(new MenuItem("Exit", this::quit));
  }

  public static void main(String[] args) {
    MavTutor mavTutor = new MavTutor();
    mavTutor.menu.run();
  }

  @Override
  public String toString() {
    return "MavTutor{courses=" + courses.size() + 
            ", students=" + students.size() + 
            ", tutors=" + tutors.size() + 
            ", sessions=" + sessions.size() + "}";
  }

  public void quit() {
    menu.result = null;
  }

  public void selectView(List list) {
    this.view = list;
    if (list == courses) {
        menu.result.append("Courses View:\n" + Menu.listToString("", courses, null));
    } else if (list == students) {
        menu.result.append("Students View:\n" + Menu.listToString("", students, null));
    } else if (list == tutors) {
        menu.result.append("Tutors View:\n" + Menu.listToString("", tutors, null));
    } else if (list == sessions) {
        menu.result.append("Sessions View:\n" + Menu.listToString("", sessions, null));
    }
  }

  public void newCourse() {
    try {
        String dept = Menu.getString("Enter department name:");
        int number = Menu.getInt("Enter course number:");
        
        Course course = new Course(dept, number);
        if (!courses.contains(course)) {
            courses.add(course);
            menu.result.append("Course created successfully: " + course);
        } else {
            menu.result.append("Course already exists: " + course);
        }
    } catch (Exception e) {
        menu.result.append("Error creating course: " + e.getMessage());
    }
  }

  public void newTutor() {
    try {
      if (courses.isEmpty()) {
        menu.result.append("Error: No courses available. Please create a course first.");
        return;
      }
      
      String name = Menu.getString("Enter tutor name:");
      String email = Menu.getString("Enter tutor email:");
      String bio = Menu.getString("Enter tutor bio:");
      String ssn = Menu.getString("Enter tutor SSN:");
      
      Integer courseIndex = Menu.selectItemFromList("Select a course for this tutor:", courses);
      if (courseIndex == null) {
        menu.result.append("Course selection cancelled.");
        return;
      }
      
      Course course = courses.get(courseIndex);
      Tutor tutor = new Tutor(name, email, bio, ssn, course);
      tutors.add(tutor);
      menu.result.append("Tutor created successfully: " + tutor);
    } catch (Exception e) {
      menu.result.append("Error creating tutor: " + e.getMessage());
    }
  }

  public void newStudent() {
      try {
          String name = Menu.getString("Enter student name:");
          String email = Menu.getString("Enter student email:");
          
          Student student = new Student(name, email);
          
          while (true) {
              Integer courseIndex = Menu.selectItemFromList("Select a course for this student (cancel to finish):", courses);
              if (courseIndex == null) break;
              Course course = courses.get(courseIndex);
              student.addCourse(course);
          }
          
          students.add(student);
          menu.result.append("Student created successfully: " + student);
      } catch (Exception e) {
          menu.result.append("Error creating student: " + e.getMessage());
      }
  }

  public void newSession() {
      try {
          if (courses.isEmpty() || tutors.isEmpty() || students.isEmpty()) {
              menu.result.append("Error: Need at least one course, tutor, and student to create a session.");
              return;
          }
          
          Integer courseIndex = Menu.selectItemFromList("Select a course for this session:", courses);
          if (courseIndex == null) {
              menu.result.append("Course selection cancelled.");
              return;
          }
          Course course = courses.get(courseIndex);
          
          Integer tutorIndex = Menu.selectItemFromList("Select a tutor for this session:", tutors);
          if (tutorIndex == null) {
              menu.result.append("Tutor selection cancelled.");
              return;
          }
          Tutor tutor = tutors.get(tutorIndex);
          
          Session session = new Session(course, tutor);
          
          String date = Menu.getString("Enter session date (MM/DD/YYYY):");
          String time = Menu.getString("Enter session start time (HH:MM):");
          int duration = Menu.getInt("Enter session duration in minutes:");
          
          session.setSchedule(date, time, duration);
          
          while (true) {
              Integer studentIndex = Menu.selectItemFromList("Select a student for this session (cancel to finish):", students);
              if (studentIndex == null) break;
              Student student = students.get(studentIndex);
              session.addStudent(student);
          }
          
          sessions.add(session);
          menu.result.append("Session created successfully: " + session);
      } catch (Exception e) {
          menu.result.append("Error creating session: " + e.getMessage());
      }
  }

  public ArrayList<Course> getCourses() { return courses; }
  public ArrayList<Student> getStudents() { return students; }
  public ArrayList<Tutor> getTutors() { return tutors; }
  public ArrayList<Session> getSessions() { return sessions; }
  public Menu getMenu() { return menu; }
  public List getView() { return view; }
}