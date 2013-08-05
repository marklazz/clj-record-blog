(ns clj-record-blog.views.session.form
  (:use [compojure.core]
        [clj-record-blog.views.layouts.application]
        [hiccup.def]
        [hiccup.page]
        [hiccup.form]
        [hiccup.core]))

(defhtml login-form [params] (
  form-to [:POST "/session"]
          "User name: "
          [:input {:name "name", :type "text", :value (:name params)}]
          [:br]
          "Password: "
          [:input {:name "password", :type "password", :value (:password params)}]
          [:br]
          [:input {:type "submit" :value "Log in"}]
  )
)

(defhtml errors-for-session [params]
  [:div { :class "validation-errors" }
     "Username and/or password are invalid. Please enter the data again."
  ]
)

(defhtml login-form-and-errors [params require_validation]
  [:div
    (if (= require_validation true) (errors-for-session params) "")
    (login-form params)
  ]
)

(defn render [params require_validation]
  (layout {:main (login-form-and-errors params require_validation) :sidebar (default-sidebar)})
)
