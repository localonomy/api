(ns api.handler
  (:require [api.response :refer :all]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [environ.core :refer [env]]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :as middleware]
            [ring.middleware.json :as middleware.json]))

(defroutes app-routes
  (context "/api" [] (defroutes api-routes
    (context "/countries" [] (defroutes countries-routes
      (GET "/" [] (get-countries)))))
    (context "/dishes" [] (defroutes dishes-routes
      (GET "/" [] (get-dishes-names))
      (GET "/:country" [country] (get-dishes country))))
    (context "/dish" [] (defroutes dish-routes
      (GET "/:id" [id] (get-dish id)))))

  (route/resources "/")

  (route/not-found "Not Found"))

(def app
  (-> app-routes 
    (middleware.json/wrap-json-response)
    (middleware/wrap-defaults middleware/api-defaults)))

(defn -main [& [port]]
  (let [port (Integer. (or port (:env port) 3000))]
    (jetty/run-jetty app {:port port :join? false})))
