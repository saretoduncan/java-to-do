package dao;

import models.Task;
import org.sql2o.*;
import org.junit.*;

import java.lang.reflect.Executable;

import static org.junit.Assert.*;
public class Sql2oTaskDaoTest {
    private static Sql2oTaskDao taskDao; //ignore me for now. We'll create this soon.
    private static Connection conn; //must be sql2o class conn
    @BeforeClass
    public static void setUp() throws Exception{
        String connectionString = "jdbc:postgresql://localhost:5432/todolist_test";
        Sql2o sql2o = new Sql2o(connectionString, "softwaredev", "k1pk0sg31");
        taskDao = new Sql2oTaskDao(sql2o); //ignore me for now
        conn = sql2o.open(); //keep connection open through entire test so it does not get erased
    }
    @After
    public  void teardown(){
        System.out.println("clearing database");
        taskDao.clearAllTasks();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }
    @Test
    public void addingCourseSetsId() throws Exception {
        Task task = new Task ("mow the lawn");
        int originalTaskId = task.getId();
        taskDao.add(task);
        assertNotEquals(originalTaskId,task.getId());
    }
    @Test
    public void existingTasksCanBeFoundById() throws Exception {
        Task task =new Task("mow the lawn");
        taskDao.add(task);
        Task foundTask= taskDao.findById(task.getId());
        assertEquals(task, foundTask);
    }

    @Test
    public void addedTasksAreReturnedFromgetAll() throws Exception {
        Task task = new Task ("mow the lawn");
        taskDao.add(task);
        assertEquals(1, taskDao.getAll().size());
    }

    @Test
    public void noTasksReturnsEmptyList() throws Exception {
        assertEquals(0, taskDao.getAll().size());
    }
    @Test
    public void updateChangesTaskContent() throws Exception {
        String initialDescription = "mow the lawn";
        Task task = new Task(initialDescription);
        taskDao.add(task);
        taskDao.update(task.getId(),"brush the cat");
        Task updatedTask= taskDao.findById(task.getId());
        assertNotEquals(initialDescription, updatedTask);

    }
    @Test
    public void deleteByIdDeletesCorrectTask() throws Exception{
        Task task = new Task("mow the lawn");
        taskDao.add(task);
        taskDao.deleteById(task.getId());
        assertEquals(0, taskDao.getAll().size());
    }
    @Test
    public void clearAllClearAll() throws Exception{
        Task task = new Task("mow the lawn");
        Task otherTasks = new Task("brush the cat");
        taskDao.add(task);
        taskDao.add(otherTasks);
        int daoSize= taskDao.getAll().size();
        taskDao.clearAllTasks();
        assertTrue(daoSize>0&& daoSize>taskDao.getAll().size());
    }
}
