(ns clj-record-blog.models.post
  (:require [clj-record.boot]
            [clj-record-blog.models.comment])
  (:use [clj-record-blog.config.db]))

(def attributes [ :title :body ])

(clj-record.core/init-model
 (:validation
    (:title "is empty" #(not (empty? %)))
    (:body "is empty" #(not (empty? %))))
  (:associations
      (has-many comments)))
