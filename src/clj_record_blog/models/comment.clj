(ns clj-record-blog.models.comment
  (:require [clj-record-blog.models.post])
  (:use [clj-record-blog.config.db]))

(clj-record.core/init-model
  (:associations
      (belongs-to post)))


