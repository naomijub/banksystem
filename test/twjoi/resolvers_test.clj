(ns twjoi.resolvers-test
  (:require [clojure.test :refer :all]
            [twjoi.resolvers :refer :all]))

(deftest resolvers-map-test
  (let [map (resolver-map)]
    (testing "resolver-map contains correct keys"
      (is (contains? map :query/routes-origin->destination)))
    (testing "returned functions for resolvers are correct"
      (is (= (partial routes-origin->destination) (:query/routes-origin->destination map))))))
