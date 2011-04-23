(ns clj-record-blog.models.comment
  (:require [clj-record-blog.models.post])
  (:use [clj-record-blog.config.db]))

(def attributes [ :name :body :email :post_id ])

(clj-record.core/init-model
 (:validation
    (:body "is empty" #(not (empty? %)))
    (:email "is empty" #(not (empty? %))))
  (:associations
      (belongs-to post)))


