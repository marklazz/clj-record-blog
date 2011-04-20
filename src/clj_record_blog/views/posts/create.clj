(ns clj-record-blog.views.posts.create
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.core]))

(defn render [] (layout {:main (default-main) :sidebar (default-sidebar) :footer (default-footer)}))
