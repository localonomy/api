(ns api.response
  (:require [api.data :refer :all]
            [ring.util.response :as response]))

(defn get-hello []
  (response/response hello))
