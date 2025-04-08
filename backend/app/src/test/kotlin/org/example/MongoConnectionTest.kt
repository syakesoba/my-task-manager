package com.example.mongodb

import com.mongodb.client.MongoClients
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class MongoConnectionTest {
    @Test
    fun testMongoConnection() {
        val client = MongoClients.create("mongodb://admin:password@mongodb:27017")
        val database = client.getDatabase("task_management")
        assertNotNull(database, "MongoDBへの接続に失敗しました")
        println("MongoDBに接続成功: ${database.name}")
    }
}