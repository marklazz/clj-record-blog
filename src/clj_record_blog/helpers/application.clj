(ns clj-record-blog.helpers.application
  (:use [compojure.core]
        [hiccup.def]
        [hiccup.core])
  (:require
    [clj-record-blog.middleware :as mdw]
    [clj-record.validation :as validation]))

(defn escape-js
  "Change special characters for js."
  [text]
  (.. #^String text
    (replace "'" "\""))
)

(defhtml error-messages-for [validation-result]
 (if (empty? validation-result)
    ""
    [:div { :class "validation-errors" }
     "Please fix the following errors before proceed:"
     [:br]
     [:ul
        (for [ x (keys validation-result) ]
          [:li (str (name x) " " (first (validation/messages-for validation-result x))) ]
        )
     ]]
  )
)

(defn logged-in []
  (not (nil? (:name mdw/*session*)))
)
