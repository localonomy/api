(ns api.handler-test
  (:require [clojure.test :refer :all]
            [ring.mock.request :as mock]
            [api.handler :refer :all]))

(deftest test-app-handler
  (testing "api route"
    (testing "countries"
      (let [response (app (mock/request :get "/api/countries"))]
        (is (= (:status response) 200))))
    (testing "dishes"
      (let [response (app (mock/request :get "/api/dishes"))]
        (is (= (:status response) 200)))
      (let [response (app (mock/request :get "/api/dishes/be"))]
        (is (= (:status response) 200))))
    (testing "dish"
      (let [response (app (mock/request :get "/api/dish/be01"))]
        (is (= (:status response) 200)))))
    (testing "filters"
      (let [response (app (mock/request :get "/api/filters"))]
        (is (= (:status response) 200))))

  (testing "resources route"
    (let [response (app (mock/request :get "/img/dish/a-gei.jpg"))]
      (is (= (:status response) 200)))
    (let [response (app (mock/request :get "/img/flag/be.png"))]
      (is (= (:status response) 200)))
    (let [response (app (mock/request :get "/img/ingredient/agave.png"))]
      (is (= (:status response) 200)))
    (let [response (app (mock/request :get "/img/filter/spicy.png"))]
      (is (= (:status response) 200))))

  (testing "not-found route"
    (let [response (app (mock/request :get "/invalid"))]
      (is (= (:status response) 404)))))
