(ns clj-record-blog.views.posts.show
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [clj-record-blog.views.comments :as comments]
        [hiccup.core]
        [hiccup.page-helpers]))

(defhtml show-post [post]
  [:div { :class "post-saved"}
     [:div {:class "title"} (:title post)]
     [:br]
     [:div {:class "body"} (:body post)]
     (comments/list-for-post post)
     [:a { :href "#" :class "add-comment-link" } "Add comment" ]
     [:div#comment-form-container
       (comments/form { :post_id (:id post) } false)
     ]
  ]
)

(defn render [post] (
  layout {
          :main (show-post post)
          :sidebar (default-sidebar)
         }
  )
)
