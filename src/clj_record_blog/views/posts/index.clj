(ns clj-record-blog.views.posts.index
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.core]))

(defhtml posts-header []
  [:div [:h1 "Post"]])

(defhtml posts-list []
  [:div [:ul [:li "Un post"]]])

(defn render [] (layout {:header (posts-header) :main (posts-list) :sidebar (default-sidebar) :footer (default-footer)}))
