(ns clj-record-blog.db.util
  (:use [clj-record-blog.config.db])
  (:require [clojure.java.jdbc :as jdbc]))

(defn ask-sql
  "Returns a seq of maps with the contents of an sql command."
  [db query]
  (jdbc/with-connection db
    (jdbc/with-query-results rs [query]
      (doall (map identity rs)))))

(defn SELECT
  "A generic select function."
  ([db what place]
     (ask-sql db (str "select " what " from " place)))
  ([db what place where]
     (ask-sql db (str "select " what " from " place " where " where))))

(defn INSERT
  "A generic insert function."
  [db table map]
  (jdbc/with-connection db
    (jdbc/insert-values table
                   (keys map)
                   (vals map))))
(defn UPDATE
  "A generic update function -- based on id."
  [db table id a-map]
  (jdbc/with-connection db
    (jdbc/update-values table ["id=?" id] a-map)))

(defn REMOVE
  "A generic delete function -- based on id."
  [db table id]
  (jdbc/with-connection db
    (jdbc/delete-rows table ["id=?" id])))

(defn all-posts
  "Retreive all posts"
  []
  (sort-by :id  > (SELECT db "*" "posts")))

(defn get-post
  "Get a post by id."
  [id]
  (first (SELECT db "*" "posts" (str "id=" id))))

(defn all-titles
  "Retreive all titles."
  []
  (map #(% :title) (all-posts)))

(defn get-comments-post
  "Get comments by post_id"
  [id]
  (SELECT db "*" "comments" (str "post_id=" id)))
