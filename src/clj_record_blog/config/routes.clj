(ns clj-record-blog.config.routes
  (:use [compojure.core]
        [ring.util.response]
        )
  (:require [clj-record-blog.middleware :as mdw]
            [compojure.route :as route]
            [clj-record-blog.controllers.posts-controller :as posts_controller]
            [clj-record-blog.controllers.comments-controller :as comments_controller]
            [clj-record-blog.controllers.session-controller :as session_controller]
 ))

(defn defs [request]
  (binding [mdw/*request* request
            mdw/*session* (:session request)
            mdw/*params* (:params request)
            mdw/*cookies* (:cookies request)
            mdw/*flash* (:flash request)]
  (routing request
    (GET "/" [] (redirect "/posts"))
    (GET "/posts/new" [] (posts_controller/new))
    (GET "/posts/edit" { params :params } (posts_controller/edit params))
    (GET "/posts/:id" [id] (posts_controller/show id))
    (POST "/posts" {params :params} (posts_controller/create params))
    (GET "/posts" [] (posts_controller/index))
    ;(DELETE "/posts/:id" [id] (posts_controller/destroy id))
    (POST "/posts/:post_id/comments" { params :params } (comments_controller/create params))
    ;(DELETE "/posts/:post_id/comments/:id" [post_id id] (comments_controller/destroy post_id id))
    (GET "/session/new" [] (session_controller/new))
    (POST "/session" { params :params } (session_controller/create params))
    (DELETE "/session" { session :session } (session_controller/destroy session))
    (route/resources "/")
    (route/not-found "<h1>Page not found</h1>")
 ))
)
