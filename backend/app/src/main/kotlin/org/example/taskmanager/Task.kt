import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "tasks")
data class Task(
    @Id val id: String? = null,
    var title: String,
    var description: String
)