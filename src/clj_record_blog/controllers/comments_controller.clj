(ns clj-record-blog.controllers.comments-controller
  (:use [compojure.core]
        [hiccup.core]
        [clj-haml])
  (:require [clj-json.core :as json]
            [clj-record-blog.models.comment :as comment_model]
            [clj-record.validation :as validation]
            ))

(defn create [params]
 (if (validation/valid? (comment_model/validate params))
    ;; send comment info
    (let [comment (comment_model/create (select-keys params comment_model/attributes ))]
      (json/generate-string { :status "ok" :name (:name comment) :body (:body comment) })
    ;; send with validation errors
    (json/generate-string { :status "error" :name (:name comment) :body (:body comment) })))
)
