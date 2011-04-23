(ns clj-record-blog.core
  (:use [clj-record.boot]
        [clj-record-blog.middleware :as mdw]
        [compojure.core]
        [hiccup.core])
  (:require [compojure.route :as route]
            [clj-json.core :as json]
            [clj-record-blog.models.post :as post]
            [clj-record-blog.models.comment :as comment]
            [clj-record-blog.controllers.posts-controller :as posts_controller]
            [clj-record-blog.controllers.comments-controller :as comments_controller]
            [compojure.handler :as handler]))

; define this bindings as an alternative to pass this vars through all routes (see http://zef.me/2650/on-language-design-magic-variables-in-compojure)
; and http://groups.google.com/group/compojure/browse_thread/thread/60497deb42ecfb8e
(def *query* nil)
(def *request* nil)
(def *cookies* nil)
(def *session* nil)
(def *flash* nil)
(def *params* nil)

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes main-routes
  ;  (GET "/login/:user"
          ;[(session-assoc :loggedin (:user params))
            ;(html [:html [:body [:p "You are now logged in as " (:user params)]]])])
    (GET "/" [] (posts_controller/index))
    (GET "/posts/new" [] (posts_controller/new))
    (GET "/posts/edit" { params :params } (posts_controller/edit params))
    (GET "/posts/:id" [id] (posts_controller/show id))
    (POST "/posts" {params :params} (posts_controller/create params))
    ;(DELETE "/posts/:id" [id] (posts_controller/destroy id))
    (POST "/posts/:post_id/comments" { params :params } (json-response (comments_controller/create params)))
    ;(DELETE "/posts/:post_id/comments/:id" [post_id id] (comments_controller/destroy post_id id))
    (route/resources "/")
    (route/not-found "<h1>Page not found</h1>")
)

(defn wrap-global-vars [handler]
  (fn [request]
    (binding [*request* request]
      handler request)))

;(decorate main-routes
          ;(with-session {:type :memory, :expires 600}))
;(def app
  ;(handler/site wrap-global-vars))

(def app
  (handler/site main-routes))
;(def app
;     (-> wrap-global-vars
;       main-routes))
;(def app
;     (-> main-routes
;         mdw/wrap-request-logging))
;(defn hello-world [request] 
    ;{:status  200 
     ;:headers {} 
     ;:body    "Hello World"}) 
;(run-server {:port 8080} 
    ;"/*" (servlet hello-world))

