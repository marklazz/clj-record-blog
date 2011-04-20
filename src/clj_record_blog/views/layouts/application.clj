(ns clj-record-blog.views.layouts.application
  (:use [compojure.core]
        [hiccup.core]))

(defhtml my-meta [] [:meta {:http-equiv "Content-type" :content "text/html;charset=UTF-8"}])

(defn default-main [] [:div "Main!"])

(defn default-sidebar []
  [:div
   [:h3 "Default sidebar"]])

(defn default-footer []
  [:h3 "Made by Marcelo Giorgi."])

(defhtml layout [yield]
    [:html [:head
                [:title "Sample Blog"]
                ;(my-meta)
                [:link {:href "/style.css" :rel "stylesheet" :type "text/css"}]
            ]
            [:body
                [:div#header (:header yield)]
                [:div#main (:main yield)]
                [:div#sidebar (:sidebar yield)]
                [:div#footer (:footer yield)]
            ]
  ]
)
