(ns clj-record-blog.views.posts.new
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.core]
        [hiccup.form-helpers])
  (:require
        [clj-record-blog.views.posts.form :as form]))

(defn render [] (
  layout {
          :main (form/render {} false)
          :sidebar (default-sidebar)
         }
  )
)
