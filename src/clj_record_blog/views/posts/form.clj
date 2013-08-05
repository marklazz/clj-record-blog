(ns clj-record-blog.views.posts.form
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [clj-record-blog.helpers.application]
        [hiccup.def]
        [hiccup.form]
        [hiccup.core]
        [hiccup.form])
  (:require [clj-record-blog.models.post :as post_model]
            [clj-record.validation :as validation])
)

(defn errors-for-post [params]
  (let [validation-result (post_model/validate params)]
   (error-messages-for validation-result))
)

(defhtml render [params require_validation] (
    form-to [:POST "/posts" ]
            [:h3 "Create a new post"]
            [:br]
            (if (= require_validation true) (errors-for-post params) "")
            [:div "Title"]
            (text-field :title (:title params))
            [:div "Content"]
            (text-area :body (:body params))
            [:br]
            (submit-button "Save")
  )
)
