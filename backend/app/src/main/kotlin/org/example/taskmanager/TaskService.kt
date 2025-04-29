package org.example.taskmanager

import org.springframework.stereotype.Service

@Service
class TaskService(private val repository: TaskRepository) {
    fun getTasks(): List<Task> = repository.findAll()
    fun getTaskById(id: String): Task? = repository.findById(id).orElse(null)
    fun createTask(task: Task): Task = repository.save(task)
    fun updateTask(id: String, updatedTask: Task): Task? {
        val task = repository.findById(id).orElse(null) ?: return null
        task.title = updatedTask.title
        task.description = updatedTask.description
        return repository.save(task)
    }
    fun deleteTask(id: String) = repository.deleteById(id)
}