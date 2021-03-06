(ns clj-record-blog.controllers.posts-controller
  (:use [compojure.core]
        [hiccup.core]
        [ring.util.response])
  (:require [clj-record-blog.views.posts.index :as index]
            [clj-record-blog.models.post :as post_model]
            [clj-record.validation :as validation]
            [clj-record-blog.views.posts.create :as create]
            [clj-record-blog.views.posts.edit :as edit]
            [clj-record-blog.views.posts.show :as show]
            [clj-record-blog.views.posts.new :as new_page]))

(defn index [] (index/render))

(defn new [] (new_page/render))

(defn show [id]
  (let [post (post_model/get-record id)]
       (show/render post))
)

(defn edit [params]
 (edit/render params))

(defn create [params]
 (if (validation/valid? (post_model/validate params))
    ;; show new post
    (let [post (post_model/create (select-keys params post_model/attributes))]
      (redirect (str "/posts/" (:id post))))
    ;; render post with validation errors
    (edit params))
)
