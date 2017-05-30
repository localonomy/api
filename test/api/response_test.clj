(ns api.response-test
  (:require [clojure.test :refer :all]
            [api.data :as data]
            [api.response :refer :all]))

(deftest test-app-response
  (testing "get-countries"
    (let [countries (:body (get-countries))]
      (is (= (count countries) (count data/countries)))
      (is (contains? (first countries) :id))
      (is (contains? (first countries) :code))
      (is (contains? (first countries) :name))))

  (testing "get-dishes-names"
    (let [dishes-names (:body (get-dishes-names))]
      (is (> (count dishes-names) (count data/countries)))
      (is (contains? (first dishes-names) :id))
      (is (contains? (first dishes-names) :name))))

  (testing "get-dishes"
    (let [dishes (:body (get-dishes "be"))]
      (is (= (count dishes) (count (:be data/dishes))))
      (is (contains? (first dishes) :id))
      (is (contains? (first dishes) :name))
      (is (contains? (first dishes) :ingredients))
      (is (contains? (first dishes) :contains))))

  (testing "get-dish"
    (let [dish (:body (get-dish "be01"))]
      (is (contains? dish :id))
      (is (contains? dish :name))
      (is (contains? dish :picture))
      (is (contains? dish :description))
      (is (contains? dish :ingredients))
      (is (contains? dish :contains)))))
