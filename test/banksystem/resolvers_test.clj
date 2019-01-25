(ns banksystem.resolvers-test
  (:require [clojure.test :refer :all]
            [banksystem.resolvers :refer :all]))


(deftest resolvers-map-test
  (let [map (resolver-map)]
    (testing "resolver-map contains correct keys"
      (is (contains? map :query/savings)))
    (testing "returned functions for resolvers are correct"
      (is (= (partial savings) (:query/savings map))))))
