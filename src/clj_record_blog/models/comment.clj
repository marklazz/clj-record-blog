(ns clj-record-blog.models.comment
  (:require [clj-record-blog.models.post])
  (:use [clj-record-blog.config.db]))

(def attributes [ :title :body ])

(clj-record.core/init-model
  (:associations
      (belongs-to post)))


