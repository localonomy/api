(ns api.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [cheshire.core :as json]
            [ring.middleware.defaults :as middleware]
            [ring.middleware.json :as middleware.json]
            [ring.util.response :as response]))

(def hello 
  (json/decode-stream
    (io/reader "resources/data/hello.json") true))

(defn get-hello []
  (response/response hello))

(defroutes app-routes
  (GET "/" [] (get-hello))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> app-routes 
    (middleware.json/wrap-json-response)
    (middleware/wrap-defaults middleware/api-defaults)))
