import org.springframework.web.bind.annotation.*
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/tasks")
class TaskController(private val taskService: TaskService) {

    @GetMapping
    fun getTasks() = ResponseEntity.ok(taskService.getTasks())

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: String) =
        taskService.getTaskById(id)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @PostMapping
    fun createTask(@RequestBody task: Task) = ResponseEntity.ok(taskService.createTask(task))

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: String, @RequestBody task: Task) =
        taskService.updateTask(id, task)?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: String): ResponseEntity<Void> {
        taskService.deleteTask(id)
        return ResponseEntity.noContent().build()
    }
}