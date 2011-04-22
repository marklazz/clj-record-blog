(ns clj-record-blog.models.post
  (:require [clj-record.boot]
            [clj-record-blog.models.comment])
  (:use [clj-record-blog.config.db]))

(clj-record.core/init-model
 (:validation
    (:title "is empty" #(not (empty? %)))
    (:body "is empty" #(not (empty? %))))
  (:associations
      (has-many comments)))

;(clj-record-blog.models.post/tabe-name)
;(clj-record-blog.models.post/create {:title "Mi titulo" :body "Warning!"})
