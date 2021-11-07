package Task;

import org.junit.jupiter.api.Test;
import task.Task;
import task.TaskDeadline;
import task.TaskEvents;
import task.TaskToDo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    ArrayList<Task> testTaskList = new ArrayList<>();
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter DATE_TIME_FORMATTER_EVENT_END_TIME = DateTimeFormatter.ofPattern("HHmm");

    @Test
    public void addNewTaskTest(){
        testTaskList.add(new TaskToDo("project"));
        testTaskList.add(new TaskDeadline("quiz", LocalDateTime.parse("2021-11-22 1400", DATE_TIME_FORMATTER)));
        testTaskList.add(new TaskEvents("meeting", LocalDateTime.parse("2021-08-22 2300", DATE_TIME_FORMATTER),
                LocalTime.parse("0100", DATE_TIME_FORMATTER_EVENT_END_TIME)));

        assertEquals("project", testTaskList.get(0).getTaskDescription());
        assertEquals("quiz", testTaskList.get(1).getTaskDescription());
        assertEquals("meeting", testTaskList.get(2).getTaskDescription());

        assertEquals("T", testTaskList.get(0).getTaskType());
        assertEquals("D", testTaskList.get(1).getTaskType());
        assertEquals("E", testTaskList.get(2).getTaskType());

    }

    @Test
    public void setTaskDoneTest(){
        Task a = new TaskToDo("project");
        assertEquals("0", a.getDone());
        a.setTaskDone();
        assertEquals("1", a.getDone());

        Task b = new TaskDeadline("quiz", LocalDateTime.parse("2021-11-22 1400", DATE_TIME_FORMATTER));
        assertEquals("0", b.getDone());
        b.setTaskDone();
        assertEquals("1", b.getDone());

        Task c = new TaskEvents("meeting", LocalDateTime.parse("2021-08-22 2300", DATE_TIME_FORMATTER),
                LocalTime.parse("0100", DATE_TIME_FORMATTER_EVENT_END_TIME));
        assertEquals("0", c.getDone());
        c.setTaskDone();
        assertEquals("1", c.getDone());

    }
}
