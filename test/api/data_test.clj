(ns api.data-test
  (:require [clojure.test :refer :all]
            [api.data :refer :all]))

(def mock-countries
  '({:id "be", :code "be", :name "Belgium"}
    {:id "cl", :code "cl", :name "Chile"}
    {:id "cn", :code "cn", :name "China"}
    {:id "do", :code "do", :name "Dominican Republic"}
    {:id "fr", :code "fr", :name "France"}
    {:id "hu", :code "hu", :name "Hungary"}
    {:id "in", :code "in", :name "India"}
    {:id "it", :code "it", :name "Italy"}
    {:id "jp", :code "jp", :name "Japan"}
    {:id "mx", :code "mx", :name "Mexico"}
    {:id "sg", :code "sg", :name "Singapore"}
    {:id "kr", :code "kr", :name "South Korea"}
    {:id "es", :code "es", :name "Spain"}
    {:id "tw", :code "tw", :name "Taiwan"}
    {:id "th", :code "th", :name "Thailand"}
    {:id "us", :code "us", :name "United States"}))

(def mock-filters
  '("meat",
    "pork",
    "seafood",
    "dairy",
    "egg",
    "alcohol",
    "gluten",
    "nuts",
    "spicy"))

(deftest test-app-data
  (testing "countries"
    (is (= mock-countries countries)))

  (testing "dishes"
    (doseq [country mock-countries]
      (is (contains? dishes (keyword(:id country))))))

  (testing "filters"
    (is (= mock-filters filters))))
