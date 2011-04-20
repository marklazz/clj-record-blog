(defproject clj-record-blog "1.0.0-SNAPSHOT"
  :description "blog's example using clj-record"
  :dependencies [[org.clojure/clojure "1.2.0"]
                 [vimclojure/server "2.2.0"]
                 [org.clojure/clojure-contrib "1.2.0"]
                 [compojure "0.6.2"]
                 [hiccup "0.3.4"]
                 [clj-haml "0.2.1-SNAPSHOT"]
                 [mysql/mysql-connector-java "5.1.13"]]
  :dev-dependencies [[lein-ring "0.4.0"]]
  :resources-path "static"
  :ring {:handler clj-record-blog.core/app})
