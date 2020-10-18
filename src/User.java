import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;

public class User {
    private String firstName;
    private String lastName;
    private String country;
    private int age;
    private ArrayList<Block> goalBlocks;
    private Block[][] schedule;
    private String notesToSelf;
    private CalendarFrame parent;

    User(String firstName, String lastName, String country, int age, String notesToSelf, ArrayList<Block> goals, CalendarFrame parent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
        this.notesToSelf = notesToSelf;
        this.goalBlocks =goals;
        this.schedule = new Block[7][24];
        this.parent = parent;
    }

    User(String firstName, String lastName, int age, CalendarFrame parent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = "";
        this.age = age;
        this.notesToSelf = "";
        this.goalBlocks = new ArrayList<>();
        this.parent = parent;
    }


    public void addGoal(Block goal) {
        if (addToSchedule(parent.getTime(),goal) == 1) {
            goalBlocks.add(goal);
        }
    }

    public int createSchedule(ArrayList<Block> goalList) {
        Block[][] newSchedule = new Block[7][24];
        if (goalList != null) {
            for (int k = 0; k < goalList.size(); k++) {
                if (addToSchedule(newSchedule, goalList.get(k)) == -1) {
                    return -1;
                }
            }
        }
        schedule = newSchedule;
        return 1;
    }

    public void removeGoal(Block goal) {
        if(goalBlocks.size() == 0) {
            return;
        } else {
            boolean removed = false;
            for (int i = 0; i < schedule.length; i++) {
                for (int j = 0; j < schedule[i].length; j++) {
                    if (schedule[i][j] != null && schedule[i][j].equals(goal)) {
                        schedule[i][j] = null;
                        removed = true;
                    }
                }
            }
            if(removed) {
                goalBlocks.remove(goalBlocks.indexOf(goal));
            }
        }
    }

    private int addToSchedule(Block[][] userSchedule, Block goal) {
        // If student is busy
        for (int i = 0; i < goal.getTime().length; i++) {
            for (int j = 0; j < goal.getTime()[i].length; j++) {
                if (goal.getTime()[i][j] == null) {
                    if (parent.getTime()[i][j] != null) {
                        return -1;
                    }
                }
            }
        }
        // Assign the course to student
        for (int i = 0; i < userSchedule.length; i++) {
            for (int j = 0; j < userSchedule[i].length; j++) {
                if (goal.getTime()[i][j] != null) {
                    parent.getTime()[i][j] = goal;
                }
            }
        }
        return 1;
    }











    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Block> getGoalBlocks() {
        return goalBlocks;
    }

    public void setGoalBlocks(ArrayList<Block> goalBlocks) {
        this.goalBlocks = goalBlocks;
    }

    public Block[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(Block[][] schedule) {
        this.schedule = schedule;
    }

    public String getNotesToSelf() {
        return notesToSelf;
    }

    public void setNotesToSelf(String notesToSelf) {
        this.notesToSelf = notesToSelf;
    }

}
