(ns banksystem.resolvers-test
  (:require [clojure.test :refer :all]
            [banksystem.resolvers :refer :all]
            [banksystem.util :as utils]))

(deftest resolvers-map-test
  (let [map (resolver-map [])]
    (testing "resolver-map contains correct keys"
      (is (contains? map :query/savings)))))
