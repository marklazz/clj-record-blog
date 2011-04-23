(ns clj-record-blog.views.layouts.application
  (:use [compojure.core]
        [hiccup.page-helpers]
        [hiccup.core]))

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
                    (link-to "/" "Home")
                    (if (= "/" "/") ; obtain the request here to determine relative path
                      " - You are here"
                      ""
                    )
                  ]
                  [:div.middle
                    (:main yield)
;                    [:h2 "Template dummy text"]
                      ;"Just to fill out empty space in the template I decided to write this and to add one of my previous templates
                      ;here. There are direct links to view one of my previous templates live and live link to download it also ;) 
                      ;Anyway hope you like both this one and previous one. You can see all of my templates at"
                    ;]
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

;                [:div#header (:header yield)]
                ;[:div#main (:main yield)]
                ;[:div#sidebar (:sidebar yield)]
                ;[:div#footer (:footer yield)]

