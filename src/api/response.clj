(ns api.response
  (:require [api.data :refer :all]
            [ring.util.response :as response]))

(defn get-countries []
  (response/response
    (->> countries
      (sort-by :name))))

(defn get-dishes-names []
  (response/response
    (->> dishes
      vals
      flatten
      (map #(select-keys % [
        :id
        :name
      ]))
      (sort-by :name))))

(defn get-dishes [country]
  (response/response
    (->> dishes
      ((keyword country))
      (map #(select-keys % [
        :id
        :name
        :localName
        :ingredients
        :contains
      ]))
      (sort-by :name))))

(defn get-dish [id]
  (response/response 
    (->> dishes
      vals
      flatten
      (filter #(= (compare (% :id) id) 0))
      first)))

(defn get-filters []
  (response/response filters))
