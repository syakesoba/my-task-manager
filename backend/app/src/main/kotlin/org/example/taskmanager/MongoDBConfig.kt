import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate

@Configuration
class MongoDBConfig {
    @Bean
    fun mongoClient(): MongoClient {
        return MongoClients.create(System.getenv("SPRING_DATA_MONGODB_URI") ?: "mongodb://localhost:27017/taskDB")
    }

    @Bean
    fun mongoTemplate(): MongoTemplate {
        return MongoTemplate(mongoClient(), "taskDB")
    }
}