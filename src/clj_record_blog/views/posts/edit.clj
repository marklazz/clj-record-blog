(ns clj-record-blog.views.posts.edit
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.core]
        [hiccup.form-helpers])
  (:require
        [clj-record-blog.views.posts.form :as form]))

(defn render [params]
 (layout {
          :main (form/render params true)
          :sidebar (default-sidebar)
         }
  )
)
