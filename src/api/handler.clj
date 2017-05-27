(ns api.handler
  (:require [api.response :refer :all]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :as middleware]
            [ring.middleware.json :as middleware.json]))

(defroutes app-routes
  (context "/api" [] (defroutes api-routes
    (context "/hello" [] (defroutes hello-routes
      (GET "/" [] (get-hello))))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> app-routes 
    (middleware.json/wrap-json-response)
    (middleware/wrap-defaults middleware/api-defaults)))
