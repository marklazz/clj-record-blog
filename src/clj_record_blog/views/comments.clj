(ns clj-record-blog.views.comments
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.core]
        [hiccup.page-helpers]
        [hiccup.form-helpers])
  (:require [clj-record-blog.models.comment :as comment_model]
            [clj-record.validation :as validation])
)

(defn errors-for-comment [params]
  (let [validation-result (comment_model/validate params)]
  (if (empty? validation-result)
    ""
    [:div { :class "validation-errors" }
     "Please fix the following errors before proceed:"
     [:br]
     [:ul
        (for [ x comment_model/attributes ]
          (if (nil? (validation/messages-for validation-result x))
            ""
            [:li (str (name x) " " (first (validation/messages-for validation-result x))) ]
          )
        )
     ]]
  ))
)

(defhtml form [params require_validation]
  [:div#comment-form
    (form-to [:POST "/comments" ]
              [:h3 "Create a comment"]
              [:br]
              (if (= require_validation true) (errors-for-comment params) "")
              [:div "Author"]
              (text-field :name (:name params))
              [:div "E-mail"]
              (text-field :email (:email params))
              [:div "Content"]
              (text-area :body (:body params))
              [:br]
              (submit-button "Save")
    )
  ]
)

(defhtml list-for-post [post]
  [:div.comments-list
    [:br]
    [:h3 "List of comments"]
    [:br]
    "TODO"
  ])
