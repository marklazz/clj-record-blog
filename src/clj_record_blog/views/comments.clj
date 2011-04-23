(ns clj-record-blog.views.comments
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [clj-record-blog.helpers.application]
        [hiccup.core]
        [hiccup.page-helpers]
        [hiccup.form-helpers])
  (:require [clj-record-blog.models.comment :as comment_model]
            [clj-record-blog.models.post :as post_model]
            [clj-record.validation :as validation])
)

(defn errors-for-comment [params]
  (let [validation-result (comment_model/validate params)]
   (error-messages-for validation-result))
)

(defhtml form [params require_validation]
  [:div#comment-form
    (form-to [:POST (str "/posts/" (:post_id params) "/comments") ]
              (hidden-field :post_id (:post_id params))
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
              [:input { :type "submit" :id "submit-comment-button" :value "Save" } ]
    )
  ]
)

(defhtml show-comment [comment]
  [:div.comment
    [:div.title (str (:title comment) "(" (:email comment) ")") ]
    [:div.content (:body comment) ]
    [:br]
  ]
)

(def show-comment-form "$('#comment-form').show();")

(defn update-comments-list [comment_attrs]
  (let [html (escape-js (show-comment comment_attrs))]
    (str "$('.comments-list .comment:last').after('" html "');")
  )
)

(def update-view-handlers "updateViewHandlers();")

(def show-add-comment-link "$('.add-comment-link').show();")

(defn saved [comment_attrs]
  (let [form-html (form comment_attrs false)]
    (str "$('#comment-form-container').html('" form-html "');" (update-comments-list comment_attrs) update-view-handlers show-add-comment-link))
)

(defn not-saved [comment_attrs]
  (let [form-html (form comment_attrs true)]
    (str "$('#comment-form-container').html('" form-html "');" show-comment-form update-view-handlers))
)

(defn comments-list [post_id]
  (let [ post (post_model/get-record post_id)]
    (post_model/find-comments post)
  )
)

(defhtml list-for-post [post]
  (let [comments (comments-list (:id post))
        comments-count (count comments)]
    [:div.comments-list
      [:br]
      [:h3 "List of comments"]
      (if (empty? comments)
        [:div.comment.hide]
        (for [comment comments]
          (show-comment comment)
        )
      )
    ])
)
