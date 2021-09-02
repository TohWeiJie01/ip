package duke.ui;

import java.util.ArrayList;
import java.util.Scanner;

import duke.task.Task;
import duke.tasklist.TaskList;

/**
 * The Ui class encapsulates the user interactions Duke will provide to the user.
 */
public class Ui {

    // The lines that Duke will print
    /** The Duke chatbot's logo. */
    private final String LOGO = " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
    /** The line break between each interaction. */
    private final String LINE_BREAK = "-------------------------------------------------------------------";
    /** The standard welcome message Duke will print as it starts. */
    private final String WELCOME_MESSAGE = "Hello I'm\n" + LOGO + "How may I help you today boss?\n";
    /** The standard goodbye message Duke will print as it closes. */
    private final String GOODBYE_MESSAGE = "Okay then! I hope to see you again soon boss!";
    /** The standard delete message Duke will print as it adds a task. */
    private final String ADD_MESSAGE = "Got it boss! I've added this task:";
    /** The standard delete message Duke will print as it deletes a task. */
    private final String DELETE_MESSAGE = "Noted boss. I've removed this task:";
    /** The standard delete message Duke will print as it marks a task as done. */
    private final String DONE_MESSAGE = "Nice one boss! I've marked this task as done:";
    /** The standard error message Duke will print if an unrecognised command is inputted. */
    private final String UNRECOGNISED_MESSAGE = "☹ I'm sorry boss! I'm not quite sure what you need me to do!";
    /** The standard list message Duke will print as it lists all the task. */
    private final String LIST_MESSAGE = "Here are the tasks in your list:";
    /** The standard find message Duke will print as it finds all the matching tasks. */
    private final String FIND_MESSAGE = "Here are the matching tasks in your list:";


    /** The scanner utilised to read inputs from the user. */
    private Scanner scan;

    /**
     * Constructor to initialise the Ui.
     */
    public Ui() {
        this.scan = new Scanner(System.in);
    }

    /**
     * Reads the inputs from the user.
     *
     * @return The input given by the user.
     */
    public String readCommand() {
        return scan.nextLine();
    }

    /**
     * Prints the full welcome message when Duke starts.
     */
    public String greetWelcome() {
        String output = LINE_BREAK + "\n" + WELCOME_MESSAGE + "\n" + LINE_BREAK + "\n";
        System.out.println(output);
        return output;
    }

    /**
     * Prints the full goodbye message when Duke closes.
     */
    public String greetGoodbye() {
        System.out.println(GOODBYE_MESSAGE);
        return GOODBYE_MESSAGE;
    }

    /**
     * Prints the divider between interactions between Duke and the user.
     */
    public void showLine() {
        System.out.println(LINE_BREAK);
    }

    /**
     * Prints the full added task message when a task is added successfully.
     *
     * @param task The added task.
     * @param taskList The tasklist the task is added to.
     */
    public String showTaskAdded(Task task, TaskList taskList) {
        String output = ADD_MESSAGE + "\n";
        output += "  " + task + "\n" + taskList.toString() + "\n";
        System.out.println(output);
        return output;
    }

    /**
     * Prints the full deleted task message when a task is deleted successfully.
     *
     * @param task The deleted task.
     * @param taskList The tasklist the task is deleted from.
     */
    public String showTaskDeleted(Task task, TaskList taskList) {
        String output = DELETE_MESSAGE + "\n";
        output += "  " + task.toString() + "\n";
        output += taskList.toString() + "\n";
        System.out.println(output);
        return output;
    }

    /**
     * Prints the full done task message when a task is indicated to be done.
     *
     * @param task The done task.
     */
    public String showTaskDone(Task task) {
        String output = DONE_MESSAGE + "\n";
        output += "  " + task.toString() + "\n";
        System.out.println(output);
        return output;
    }

    /**
     * Prints the full list task message.
     *
     * @param taskList The tasklist to be printed.
     */
    public String showList(TaskList taskList) {
        String output = LIST_MESSAGE + "\n";
        int currPosition = taskList.getNextSpaceToStore();
        ArrayList<Task> allTasks = taskList.getAllTasks();
        for (int i = 0; i < currPosition; i++) {
            int currTask = i + 1;
            output += currTask + "." + allTasks.get(i).toString() + "\n";
        }
        System.out.println(output);
        return output;
    }

    /**
     * Prints the full list of tasks that matches the description.
     *
     * @param taskList The tasklist to be searched in.
     * @param description The keyword to be searched.
     */
    public String showFind(TaskList taskList, String description) {
        int findPosition = 1;
        int currPosition = taskList.getNextSpaceToStore();
        String output = FIND_MESSAGE + "\n";
        for (int i = 0; i < currPosition; i++) {
            String foundTask = taskList.getAllTasks().get(i).toString();
            if (foundTask.contains(description)) {
                output += findPosition + "." + foundTask + "\n";
                findPosition++;
            }
        }
        System.out.println(output);
        return output;
    }

    /**
     * Prints the full unrecognised input message.
     */
    public String showUnrecognised() {
        System.out.println(UNRECOGNISED_MESSAGE);
        return UNRECOGNISED_MESSAGE;
    }

    /**
     * Prints the error message should an error come up during an interaction.
     *
     * @param errorMessage
     */
    public String showError(String errorMessage) {
        System.out.println(errorMessage);
        return errorMessage;
    }
}