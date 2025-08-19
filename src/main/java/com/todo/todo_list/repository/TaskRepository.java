package com.todo.todo_list.repository;

import com.todo.todo_list.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
