// package com.cheng.hb_game;

// import static com.mongodb.client.model.Filters.eq;

// import org.bson.Document;
// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.mongodb.client.MongoClient;
// import com.mongodb.client.MongoClients;
// import com.mongodb.client.MongoCollection;
// import com.mongodb.client.MongoDatabase;

// @SpringBootApplication
// public class HbGameApplication {

// public static void main(String[] args) {
// // Replace the placeholder with your MongoDB deployment's connection string
// String uri =
// "mongodb+srv://jiangcheng:7SQe1Z55PYZupa1K@hbgame.enlckr0.mongodb.net/?retryWrites=true&w=majority&appName=hbgame";

// try (MongoClient mongoClient = MongoClients.create(uri)) {
// MongoDatabase database = mongoClient.getDatabase("sample_mflix");
// MongoCollection<Document> collection = database.getCollection("movies");

// Document doc = collection.find(eq("title", "Back to the Future")).first();
// if (doc != null) {
// System.out.println(doc.toJson());
// } else {
// System.out.println("No matching documents found.");
// }
// }
// SpringApplication.run(HbGameApplication.class, args);
// }

// }
