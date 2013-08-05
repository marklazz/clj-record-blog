(ns clj-record-blog.db.migrate
  (:use [clj-record-blog.config.db])
  (:require [clojure.java.jdbc :as jdbc]))

(defn create-blog-with-db
  "Setup my database" [db-spec]
  (jdbc/with-connection db-spec
    (jdbc/create-table
     :posts
     [:id :integer "PRIMARY KEY" "AUTO_INCREMENT"]
     [:title "varchar(255)"]
     [:body :text]
     [:updated :timestamp "DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"])
    (jdbc/create-table
     :comments
     [:id :integer "PRIMARY KEY" "AUTO_INCREMENT"]
     [:name "varchar(255)"]
     [:email "varchar(255)"]
     [:body :text]
     [:post_id :integer])))

(defn drop-blog-with-db
  "Drop all tables" [db-spec]
  (jdbc/with-connection db-spec
    (try
     (do
       (jdbc/drop-table :posts)
       (jdbc/drop-table :comments))
     (catch Exception _))))

(defn create-blog [] (create-blog-with-db db))
