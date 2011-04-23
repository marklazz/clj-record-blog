(ns clj-record-blog.controllers.comments-controller
  (:use [compojure.core]
        [hiccup.core]
        [clj-haml])
  (:require [clj-record-blog.models.comment :as comment_model]
            [clj-record.validation :as validation]
            ))

(defn create [params]
 (let [comment_attrs (select-keys params comment_model/attributes)]
  (
    if (validation/valid? (comment_model/validate params))
      ;; send comment info
      (let [comment (comment_model/create comment_attrs)]
        (merge comment_attrs { :status "ok" }))
      ;; send with validation errors
      (merge comment_attrs { :status "error" }))
 )
)
