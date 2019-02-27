package com.codecool.todo.controller;

import com.codecool.todo.model.Todo;
import com.codecool.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@RestController
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;


//    @RequestMapping("/")
//    public String welcome(Model com.codecool.todo.model) {
//        EntityDatabase entityDatabase = new EntityDatabase();
//        com.codecool.todo.model.addAttribute("planets",PlanetCreator.planetMap);
//        return "welcome";
//    }
//
//    @GetMapping("/")
//    public List<Todo> todoList(){
//        return todoRepository.findAll();
//    }
//    public String todoList(Model model) {
//        model.addAttribute("list", todoRepository.findAll());
//        return "index";
//    }
//
//    @RequestMapping("/planet")
//    public String getForm(Model com.codecool.todo.model){
//        return "planet";
//    }
//
//    @PostMapping("/<planet_name>")
//    public String getSize(@RequestParam(name="size", required=false) String name, Model com.codecool.todo.model) {
//        com.codecool.todo.model.addAttribute("name", name);
//        return "<planet name>";
//    }

}
