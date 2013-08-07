(ns clj-record-blog.core
  (:use [clj-record.boot]
        [hiccup.core]
        [ring.util.response]
        [ring.middleware.session]
        )
  (:require [clj-record-blog.config.routes :as app_routes]
            [clj-json.core :as json]
            [clj-record-blog.models.post :as post]
            [clj-record-blog.models.comment :as comment]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as jetty]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(def app (handler/site app_routes/defs))
