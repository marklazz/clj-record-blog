(ns clj-record-blog.config.db
  (:use [clojure.contrib.sql]))

(def *user-name* "admin")
(def *password* "admin")

(def *db-host* "localhost")
(def *db-port* 3306)
(def *db-name* "clj-record-blog")
(def *db-user* "root")
(def *db-password* "root")

(def db {:classname "com.mysql.jdbc.Driver" ; must be in classpath
           :subprotocol "mysql"
           :subname (str "//" *db-host* ":" *db-port* "/" *db-name*)
           ; Any additional keys are passed to the driver
           ; as driver-specific properties.
           :user *db-user*
           :password *db-password*})
