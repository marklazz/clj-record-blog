(ns clj-record-blog.views.posts.show
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.core]
        [hiccup.page-helpers]))

;(defmulti url type)
;(defmethod url :tag [tag] 
  ;(str "/tag/" (tag :id))) 
;(defmethod url :category [cat] 
  ;(str "/category/" (cat :id))) 
;(defmethod url :post [post] 
  ;(str "/post/" (post :id))) 
;(defmethod url :default [x] 
  ;(die "Don't know how to make a url out of a " (type x)))

(defhtml show-post [post]
  [:div { :class "post-saved"}
     [:div {:class "title"} (:title post)]
     [:br]
     [:div {:class "body"} (:body post)]
  ]
)

(defn render [post] (
  layout {
          :main (show-post post)
          :sidebar (default-sidebar)
         }
  )
)
