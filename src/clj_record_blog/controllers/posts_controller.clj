(ns clj-record-blog.controllers.posts-controller
  (:use [compojure.core]
        [hiccup.core]
        [clj-haml])
  (:require [clj-record-blog.views.posts.index :as index]
            [clj-record-blog.views.posts.create :as create]
            [clj-record-blog.views.posts.new :as new_page]))

(defn index [] (index/render))
