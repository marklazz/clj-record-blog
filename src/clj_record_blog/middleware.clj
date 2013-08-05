(ns clj-record-blog.middleware)

(defn- log [msg & vals]
  (let [line (apply format msg vals)]
    (locking System/out (println line))))

(defn wrap-request-logging [handler]
  (fn [{:keys [request-method uri] :as req}]
    (let [resp (handler req)]
      (log "Processing %s %s" request-method uri)
      resp)))

; define this bindings as an alternative to pass this vars through all routes (see http://zef.me/2650/on-language-design-magic-variables-in-compojure)
; and http://groups.google.com/group/compojure/browse_thread/thread/60497deb42ecfb8e
(def ^:dynamic *request* nil)
(def ^:dynamic *cookies* nil)
(def ^:dynamic *session* nil)
(def ^:dynamic *flash* nil)
(def ^:dynamic *params* nil)


