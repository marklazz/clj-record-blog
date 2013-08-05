(ns clj-record-blog.config.db)

(def ^:dynamic *user-name* "admin")
(def ^:dynamic *password* "admin")

(def ^:dynamic *db-host* "localhost")
(def ^:dynamic *db-port* 3306)
(def ^:dynamic *db-name* "clj-record-blog")
(def ^:dynamic *db-user* "root")
(def ^:dynamic *db-password* "root")

(def db {:classname "com.mysql.jdbc.Driver" ; must be in classpath
           :subprotocol "mysql"
           :subname (str "//" *db-host* ":" *db-port* "/" *db-name*)
           ; Any additional keys are passed to the driver
           ; as driver-specific properties.
           :user *db-user*
           :password *db-password*})
