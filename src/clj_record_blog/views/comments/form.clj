(ns clj-record-blog.views.comments.form
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.core])
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

(defhtml render [params require_validation]
    form-to [:POST "/comments" ]
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
)
