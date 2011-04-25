(ns clj-record-blog.controllers.session-controller
  (:use [compojure.core]
        [hiccup.core]
        [clojure.contrib.core]
        [ring.util.response])
  (:require
        [clj-record-blog.middleware :as mdw]
        [clj-record-blog.views.session.form :as form])
)

(defn new []
  (form/render {} false)
)

(defn create [params]
  (if
    (and
      (= "admin" (:name params))
      (= "admin" (:password params)))
        (-> (redirect "/posts")
            (assoc-in [:session :name] (:name params)))
        (form/render params true))
)

(defn destroy [session]
  (-> (redirect "/posts")
      (assoc-in [:session :name] nil))
)
