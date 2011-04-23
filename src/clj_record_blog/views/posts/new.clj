(ns clj-record-blog.views.posts.new
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [clj-record-blog.views.posts.form]
        [hiccup.core]
        [hiccup.form-helpers]))

(defn render [] (
  layout {
          :main (post-form {} false)
          :sidebar (default-sidebar)
         }
  )
)
