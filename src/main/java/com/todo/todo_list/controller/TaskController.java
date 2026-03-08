package com.todo.todo_list.controller;

import com.todo.todo_list.services.AISuggestionsService;
import org.springframework.ui.Model;
import com.todo.todo_list.models.Task;
import com.todo.todo_list.services.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final AISuggestionsService aISuggestionsService;

    public TaskController(TaskService taskService, AISuggestionsService aISuggestionsService) {
        this.taskService = taskService;
        this.aISuggestionsService = aISuggestionsService;
    }

    @GetMapping
    public String getTasks(Model model) {
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        return "tasks";
    }

    @PostMapping
    public String createTasks(@RequestParam String title) {
        taskService.createTask(title);
        return "redirect:/";
    }

    @GetMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }

    @GetMapping("/{id}/generate-suggestion")
    @ResponseBody
    public String generateSuggestion(@PathVariable Long id) { //getting id from url
        Task task = taskService.getTaskById(id)
                .orElseThrow(() -> new RuntimeException("Task with the following id not found: " + id));
        return aISuggestionsService.generateSuggestion(task.getTitle());
    }

}
