(ns clj-record-blog.models.comment
  (:require [clj-record-blog.models.post]
            [clj-record.validation.built-ins :as v])
  (:use [clj-record-blog.config.db]))

(def attributes [ :name :body :email :post_id ])

(clj-record.core/init-model
 (:validation
    (:body "is empty" #(not (empty? %)))
    (:email "is empty" #(not (empty? %)))
    (:email "is not valid" v/email?)
 )
 (:associations
      (belongs-to post)))


