(ns clj-record-blog.views.layouts.application
  (:use [compojure.core]
        [hiccup.form-helpers]
        [hiccup.page-helpers]
        [clj-record-blog.helpers.application]
        [hiccup.core])
  (:require [clj-record-blog.middleware :as mdw]))

(defhtml my-meta [] [:meta {:http-equiv "Content-type" :content "text/html;charset=UTF-8"}])

(def web-app-title "Sample compojure web app (with clj-record)")

(defhtml default-header []
  [:div
    [:h1
      (link-to "/" web-app-title)
    ]
    [:h2 "By Marcelo Giorgi"]
   ]
)

(defn default-main [] [:div "Main!"])

(defn default-sidebar []
  [:ul
   [:li (link-to "/" "Home")]])

(defn default-footer []
  [:div#footer
   "Design by "
   (link-to "http://www.minimalistic-design.net" "Minimalistic Design")
   ]
)

(defn layout [yield]
    (html5  [:head
                [:title web-app-title]
                (my-meta)
                (include-css "/style.css" "/application.css")
                (include-js "https://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js")
                (include-js "/library.js")
                (include-js "/jquery.form.js")
            ]
            [:body
              [:div#wrap
                [:div#top]
                [:div#content
                  [:div.header (default-header)]
                  [:div.breadcrumbs
                    (if (logged-in)
                      [:div#logout-form-container
                        [:div#logout-form (form-to [:DELETE "/session"]) ]
                        [:a { :href "/session" :method "_delete" :id "logout-link" } "Logout" ]
                      ]
                      (link-to "/session/new" "Login")
                    )
                  ]
                  [:div.middle
                    (:main yield)
                  ]
                  [:div.right
                    [:h2 "Navigation"]
                      (:sidebar yield)
                    ]
                  ]
                  [:div#clear]
                 [:div#bottom]
                ]
                (default-footer)
            ]
  )
)
