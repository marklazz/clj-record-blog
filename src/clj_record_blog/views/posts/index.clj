(ns clj-record-blog.views.posts.index
  (:use [compojure.core]
        [clj-record-blog.models.post :as post]
        [clj-record-blog.views.layouts.application]
        [hiccup.page-helpers]
        [hiccup.core]))

(defhtml posts-list []
  [:div [:ul
            (for [x (post/find-records ["1=1"])]
                   [:li (:title x)])
         ]])

(defn new-post-sidebar []
  [:ul
   [:li (link-to "/posts/new" "New post")]])

(defn render [] (layout {:main (posts-list) :sidebar (new-post-sidebar)}))
