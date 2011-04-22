(ns clj-record-blog.views.posts.edit
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [clj-record-blog.views.posts.form]
        [hiccup.core]
        [hiccup.form-helpers]))

(defn render [params]
 (layout {
          :main (post-form params "true")
          :sidebar (default-sidebar)
          :footer (default-footer)
         }
  )
)
