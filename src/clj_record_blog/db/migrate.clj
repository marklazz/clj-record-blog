(ns clj-record-blog.db.migrate
  (:use [clojure.contrib.sql]
        [clj-record-blog.config.db]))

(defn create-blog-with-db
  "Setup my database" [db]
  (with-connection db
    (create-table
     :posts
     [:id :integer "PRIMARY KEY" "AUTO_INCREMENT"]
     [:title "varchar(255)"]
     [:body :text]
     [:updated :timestamp "DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"])
    (create-table
     :comments
     [:id :integer "PRIMARY KEY" "AUTO_INCREMENT"]
     [:name "varchar(255)"]
     [:email "varchar(255)"]
     [:body :text]
     [:post_id :integer])))

(defn drop-blog-with-db
  "Drop all tables" [db]
  (with-connection db
    (try
     (do
       (drop-table :posts)
       (drop-table :comments))
     (catch Exception _))))

(defn create-blog [] (create-blog-with-db db))
