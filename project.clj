(defproject clj-record-blog "1.0.0-SNAPSHOT"
  :description "blog's example using clj-record"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/java.jdbc "0.3.0-alpha4"]
                 [mysql/mysql-connector-java "5.1.25"]
                 [compojure "1.1.5"]
                 [hiccup "1.0.4"]
                 [clj-json "0.5.3"]
                 [clj-record "1.1.4"]]
  :plugins [[lein-ring "0.7.1"]]
  :resources-path "resources"
  :ring {:handler clj-record-blog.core/app})
