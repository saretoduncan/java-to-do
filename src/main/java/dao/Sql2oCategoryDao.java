//package dao;
//
//
//import models.Category;
//import models.Task;
//import org.sql2o.Connection;
//import org.sql2o.Sql2o;
//import org.sql2o.Sql2oException;
//
//import java.util.List;
//
//public  class  Sql2oCategoryDao implements CategoryDao {
//    private final Sql2o sql2o;
//    public Sql2oCategoryDao(Sql2o sql2o){
//        this.sql2o=sql2o;
//    }
//    @Override
//    public void add(Category category){
//        String sql = "INSERT INTO categories (name) VALUES (:name)";
//        try(Connection connection=sql2o.open()){
//            int id= (int)connection.createQuery(sql,true)
//                    .bind(category)
//                    .executeUpdate()
//                    .getKey();
//            category.setId(id);
//        } catch (Sql2oException err){
//            System.out.println("error:: " + err);
//        }
//    }
//    @Override
//    public List<Category> getAll(){
//        try(Connection connection= sql2o.open()){
//            return connection.createQuery("SELECT * FROM categories")
//                    .executeAndFetch(Category.class);
//        }
//    }
//    @Override
//    public Category findById(int id){
//        String sql= "SELECT * FROM categories WHERE id= :id";
//        try(Connection connection=sql2o.open()){
//            return connection.createQuery(sql)
//                    .addParameter("id",id)
//                    .executeAndFetchFirst(Category.class);
//        }
//    }
//    @Override
//    public void update(int id, String newName){
//        String sql= "UPDATE categories SET name = :name WHERE  id = :id";
//        try(Connection connection= sql2o.open()){
//             connection.createQuery(sql)
//                     .addParameter("name",newName)
//                     .addParameter("id",id)
//                     .executeUpdate();
//        } catch (Sql2oException ex){
//            System.out.println("error :::" + ex);
//        }
//    }
//    @Override
//    public void deletedById(int id){
//        String sql= "DELETE FROM categories WHERE id = :id";
//        try(Connection connection= sql2o.open()){
//            connection.createQuery(sql)
//                    .addParameter("id",id)
//                    .executeUpdate();
//
//        } catch (Sql2oException err){
//            System.out.println("error" + err);
//        }
//    }
//    @Override
//    public  void clearAllCategories(){
//        try(Connection connection = sql2o.open()){
//            connection.createQuery("DELETE * FROM categories")
//                    .executeUpdate();
//        }catch (Sql2oException err){
//            System.out.println("error:::" + err);
//        }
//    }
//    @Override
//    public  List<Task> getAllTaskByCategory(int categoryId){
//        try(Connection connection= sql2o.open()){
//           return connection.createQuery("SELECT * FROM tasks WHERE categoryId=:categoryId")
//                    .addParameter("categoryId", categoryId)
//                    .executeAndFetch(Task.class);
//        }
//    }
//
//
//}
