(ns clj-record-blog.views.comments.create
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.core]))

(defn render [] (layout {:main (default-main) :sidebar (default-sidebar) :footer (default-footer)}))
