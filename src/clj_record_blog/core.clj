(ns clj-record-blog.core
  (:use [clj-record.boot]
        [compojure.core]
        [hiccup.core])
  (:require [compojure.route :as route]
            [clj-record-blog.models.post :as post]
            [clj-record-blog.models.comment :as comment]
            [clj-record-blog.controllers.posts-controller :as posts_controller]
            [clj-record-blog.controllers.comments-controller :as comments_controller]
            [compojure.handler :as handler]))

;(GET "/user/:id" [id]
;  (str "<h1>Hello user " id "</h1>"))

(defroutes main-routes
;  (GET "/login/:user"
        ;[(session-assoc :loggedin (:user params))
          ;(html [:html [:body [:p "You are now logged in as " (:user params)]]])])
  (GET "/" [] (posts_controller/index))
;  (GET "/posts/new" [] (posts_controller/new))
  ;(GET "/posts/:id" [id] (posts_controller/show id))
  ;(DELETE "/posts/:id" [id] (posts_controller/destroy id))
  ;(POST "/posts" [] (posts_controller/create))
  ;(GET "/posts/:id/comments" [id] (comments_controller/index id))
  ;(GET "/posts/:post_id/comments/:id" [post_id id] (comments_controller/show post_id id))
  ;(POST "/posts/:post_id/comments" [post_id] (comments_controller/create post_id))
  ;(DELETE "/posts/:post_id/comments/:id" [post_id id] (comments_controller/destroy post_id id))
  (route/resources "/")
  (route/not-found "<h1>Page not found</h1>"))

;(decorate main-routes
          ;(with-session {:type :memory, :expires 600}))

(def app
  (handler/site main-routes))
