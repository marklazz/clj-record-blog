(ns clj-record-blog.views.posts.index
  (:use [compojure.core]
        [clj-record-blog.models.post :as post]
        [clj-record-blog.views.layouts.application]
        [clj-record-blog.helpers.application]
        [hiccup.page-helpers]
        [hiccup.core]))

(defhtml posts-list []
  [:div [:ul
            (for [post_instance (post/find-records ["1=1"])]
                   [:li
                      (link-to (str "/posts/" (:id post_instance)) (:title post_instance))
                   ]
            )
         ]])

(defn new-post-sidebar []
  (if (logged-in)
    [:ul
      [:li (link-to "/posts/new" "New post") ]
     ]
    "")
)

(defn render [] (layout {:main (posts-list) :sidebar (new-post-sidebar)}))
