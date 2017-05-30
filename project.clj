(defproject api "0.1.0"
  :description "API for the Localonomy app"
  :url "https://github.com/localonomy"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [cheshire "5.7.1"]
                 [compojure "1.5.1" :exclusions [[ring/ring-core]]]
                 [environ "1.1.0"]
                 [ring/ring-defaults "0.2.1" :exclusions [[ring/ring-core]]]
                 [ring/ring-jetty-adapter "1.6.1"]
                 [ring/ring-json "0.4.0"]]
  :plugins [[lein-ring "0.9.7"]
            [environ/environ.lein "0.3.1"]]
  :hooks [environ.leiningen.hooks]
  :ring {:handler api.handler/app}
  :uberjar-name "api-standalone.jar"
  :profiles {
    :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                         [ring/ring-mock "0.3.0"]]}
    :production {:env {:production true}}
    :uberjar {:aot :all}
  }
)
