package org.example.taskmanager

import org.springframework.data.mongodb.repository.MongoRepository

interface TaskRepository : MongoRepository<Task, String>