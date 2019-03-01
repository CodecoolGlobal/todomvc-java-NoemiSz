package com.codecool.todo;//import static spark.Spark.*;

import com.codecool.todo.model.Status;
import com.codecool.todo.repository.TodoRepository;
import com.codecool.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BasicTodoList{


    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(BasicTodoList.class, args);
    }

    @Bean
    public CommandLineRunner init(){
        return args -> {
            Todo firstTodo = Todo.builder()
                    .title("first TODO item")
                    .build();
            todoRepository.save(firstTodo);
            Todo secondTodo = Todo.builder()
                    .title("second TODO item")
                    .build();
            todoRepository.save(secondTodo);
            Todo thirdTodo = Todo.builder()
                    .title("third TODO item")
                    .status(Status.COMPLETE)
                    .build();
            todoRepository.save(thirdTodo);
        };
    }
}



//public class com.codecool.todo.BasicTodoList {
//
//    private static final String SUCCESS = "{\"success\":true}";
//
//    public static void main(String[] args) {
//
//        addSampleData();
//
//        exception(Exception.class, (e, req, res) -> e.printStackTrace()); // print all exceptions
//        staticFiles.location("/public");
//        port(9999);
//
//        // Add new
//        post("/addTodo", (req, res) -> {
//            Todo newTodo = Todo.create(req.queryParams("todo-title"));
//            TodoDao.add(newTodo);
//            return SUCCESS;
//        });
//
//        // List by id
//        post("/list", (req, resp) -> {
//            List<Todo> daos = TodoDao.ofStatus(req.queryParams("status"));
//            JSONArray arr = new JSONArray();
//            for (Todo dao : daos) {
//                JSONObject jo = new JSONObject();
//                jo.put("id", dao.getId());
//                jo.put("title", dao.getTitle());
//                jo.put("completed", dao.isComplete());
//                arr.put(jo);
//            }
//            return arr.toString(2);
//        });
//
//        // Remove all completed
//        delete("/todos/completed", (req, res) -> {
//            TodoDao.removeCompleted();
//            return SUCCESS;
//        });
//
//        // Toggle all status
//        put("/todos/toggle_all", (req, res) -> {
//            String complete = req.queryParams("toggle-all");
//            TodoDao.toggleAll(complete.equals("true"));
//            return SUCCESS;
//        });
//
//        // Remove by id
//        delete("/todos/:id", (req, res) -> {
//            TodoDao.remove(req.params("id"));
//            return SUCCESS;
//        });
//
//        // Update by id
//        put("/todos/:id", (req, res) -> {
//            TodoDao.update(req.params("id"), req.queryParams("todo-title"));
//            return SUCCESS;
//        });
//
//        // Find by id
//        get("/todos/:id", (req, res) -> TodoDao.find(req.params("id")).getTitle());
//
//        // Toggle status by id
//        put("/todos/:id/toggle_status", (req, res) -> {
//            boolean completed = req.queryParams("status").equals("true");
//            TodoDao.toggleStatus(req.params("id"), completed);
//            return SUCCESS;
//        });
//    }
//
//}
