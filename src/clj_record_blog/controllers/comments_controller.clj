(ns clj-record-blog.controllers.comments-controller
  (:use [compojure.core]
        [hiccup.core]
        [clj-haml])
  (:require [clj-record-blog.views.comments.index :as index]
            [clj-record-blog.views.comments.create :as create]
            [clj-record-blog.views.comments.new :as new_page]))

