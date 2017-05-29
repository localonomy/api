(ns api.data
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]))

(def dishes
  (merge
    (json/decode-stream
      (io/reader "resources/data/dishes/be.json") true)
    (json/decode-stream
      (io/reader "resources/data/dishes/cl.json") true)))

(def countries
  (json/decode-stream
    (io/reader "resources/data/countries.json") true))
