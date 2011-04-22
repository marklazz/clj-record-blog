(ns clj-record-blog.views.posts.show
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.core]
        [hiccup.page-helpers]))

(defhtml show-post [post]
  [:div { :class "post-saved"}
     [:div {:class "title"} (:title post)]
     [:br]
     [:div {:class "body"} (:body post)]
     [:br]
     (link-to "/" "All posts")
  ]
)

(defn render [post] (
  layout {
          :main (show-post post)
          :sidebar (default-sidebar)
          :footer (default-footer)
         }
  )
)
