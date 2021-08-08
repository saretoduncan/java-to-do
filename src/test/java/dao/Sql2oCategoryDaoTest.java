//package dao;
//
//import junit.framework.TestCase;
//import models.Category;
//import models.Task;
//import org.junit.After;
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//
//import static org.junit.Assert.assertNotEquals;
//
//
//public class Sql2oCategoryDaoTest extends TestCase {
//    private Sql2oCategoryDao CategoryDao;
//    private Connection connection;
//
//    @Before
//    public void setUp() throws Exception{
//        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
//        Sql2o sql2o = new Sql2o(connectionString, "", "");
//        CategoryDao = new Sql2oCategoryDao(sql2o); //ignore me for now
//        connection = sql2o.open(); //keep connection open through entire test so it does not get erased
//    }
//    @After
//    public void tearDown() throws Exception{
//        connection.close();
//    }
//
//
//    public void testaddingCategorySetsId() {
//        Category category = setUpNewCategory();
//        int originalCategoryId = category.getId();
//        CategoryDao.add(category);
//        assertNotEquals(originalCategoryId, category.getId());
//    }
//
//
//
//
//
//    public void testexistingCategoriesCanBeFoundById() throws Exception {
//        Category category = setUpNewCategory();
//        CategoryDao.add(category);
//        Category foundCategory = CategoryDao.findById(category.getId());
//        assertEquals(category, foundCategory);
//    }
//    public void testaddedCategoriesAreReturnedFromGetAll() throws Exception {
//        Category category = setUpNewCategory();
//        CategoryDao.add(category);
//        assertEquals(1, CategoryDao.getAll().size());
//    }
//
//    public void testnoCategoriesReturnsEmptyList() throws Exception {
//        assertEquals(0, CategoryDao.getAll().size());
//    }
//    public Category setUpNewCategory(){
//        return new Category("House Chores");
//    }
//    public void testupdateChangesCategoryContent() throws Exception {
//        String initialDescription = "Yardwork";
//        Category category = new Category (initialDescription);
//        CategoryDao.add(category);
//        CategoryDao.update(category.getId(),"Cleaning");
//        Category updatedCategory = CategoryDao.findById(category.getId());
//        assertNotEquals(initialDescription, updatedCategory.getName());
//    }
//    public void testdeleteByIdDeletesCorrectCategory() throws Exception {
//        Category category = setUpNewCategory();
//        CategoryDao.add(category);
//        CategoryDao.deletedById(category.getId());
//        assertEquals(0, CategoryDao.getAll().size());
//    }
//    public void testclearAllClearsAllCategories() throws Exception {
//        Category category = setUpNewCategory();
//        Category otherCategory = new Category("Cleaning");
//        CategoryDao.add(category);
//        CategoryDao.add(otherCategory);
//        int daoSize = CategoryDao.getAll().size();
//        CategoryDao.clearAllCategories();
//        assertTrue(daoSize > 0 && daoSize > CategoryDao.getAll().size());
//    }
////    public void getAllTasksByCategoryReturnsTasksCorrectly() throws Exception {
////        Category category = setUpNewCategory();
////        CategoryDao.add(category);
////        int categoryId = category.getId();
////        Task newTask = new Task("mow the lawn", categoryId);
////        Task otherTask = new Task("pull weeds", categoryId);
////        Task thirdTask = new Task("trim hedge", categoryId);
////        taskDao.add(newTask);
////        taskDao.add(otherTask); //we are not adding task 3 so we can test things precisely.
////        assertEquals(2, categoryDao.getAllTasksByCategory(categoryId).size());
////        assertTrue(categoryDao.getAllTasksByCategory(categoryId).contains(newTask));
////        assertTrue(categoryDao.getAllTasksByCategory(categoryId).contains(otherTask));
////        assertFalse(categoryDao.getAllTasksByCategory(categoryId).contains(thirdTask)); //things are accurate!
////    }
//}