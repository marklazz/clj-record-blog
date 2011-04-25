(ns clj-record-blog.controllers.comments-controller
  (:use [compojure.core]
        [hiccup.core])
  (:require [clj-record-blog.models.comment :as comment_model]
            [clj-record-blog.views.comments :as comments]
            [clj-record.validation :as validation]
            ))

(defn create [params]
 (let [comment_attrs (select-keys params comment_model/attributes)]
  (
    if (validation/valid? (comment_model/validate params))
      ;; send comment info
      (let [comment (comment_model/create comment_attrs)]
        (comments/saved comment_attrs))
      ;; send with validation errors
      (comments/not-saved comment_attrs))
 )
)
