(ns clj-record-blog.views.posts.index
  (:use [compojure.core]
        [clj-record-blog.models.post :as post]
        [clj-record-blog.views.layouts.application]
        [hiccup.core]))

(defhtml posts-header []
  [:div#header-title [:h1 "Post lists"]])

(defhtml posts-list []
  [:div [:ul
            (for [x (post/find-records ["1=1"])]
                   [:li (:title x)])
         ]])

(defn new-post-sidebar []
  [:div
   [:a { :href "/posts/new" } "New Post"]])

(defn render [] (layout {:header (posts-header) :main (posts-list) :sidebar (new-post-sidebar) :footer (default-footer)}))
