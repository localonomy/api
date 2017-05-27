(ns api.data
  (:require [clojure.java.io :as io]
            [cheshire.core :as json]))

(def hello 
  (merge
    (json/decode-stream
      (io/reader "resources/data/hello.json") true)
    (json/decode-stream
      (io/reader "resources/data/bye.json") true)
    (json/decode-stream
      (io/reader "resources/data/world.json") true)))
