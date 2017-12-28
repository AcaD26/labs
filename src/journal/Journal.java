package journal;

import task.Task;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 *
 * @author Dmitrii
 */

@XmlRootElement(name = "journal")
public class Journal {
    @XmlElementRef
    private List<Task> tasks;

    public Journal() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> getTaskList() {
        return tasks;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void deleteTask(Task task) {
        this.tasks.remove(task);
    }

    public Task getTask(int index) {
        return getTaskList().get(index);
    }

    public int getSize() {
        return this.tasks.size();
    }

    public void deleteAllTask(Journal journal) {
        for (int i = 0; i < journal.getSize(); i++) {
            tasks.remove(i);
        }
    }
}