(ns banksystem.server-test
  (:require [clojure.test :refer :all]
            [cheshire.core :as json]
            [banksystem.core :refer :all]
            [banksystem.util :as util]))

(deftest GQL-endpoint-queries
  (testing "savings route"
    (is (= {:data {:savings {:name "Teste1" :amount 5000.0}}}
           (util/q "{savings(uuid:\"d3bbb532-0548-4fd1-856c-01a9701b0749\"){name, amount}}"))))
  (testing "accounts route"
    (is (= {:data
            {:accounts [{:uuid "d3bbb532-0548-4fd1-856c-01a9701b0749"}
                        {:uuid "ded6809d-1840-4194-88cc-37c6d342e13e"}]}}
           (util/q "{accounts{uuid}}")))))

(deftest GQL-endpoint-mutations
  (testing "deposit"
    (is (= {:data
            {:deposit
             {:amount 5100.0 :name "Teste1"}}}
          (util/q "mutation {deposit(uuid: \"d3bbb532-0548-4fd1-856c-01a9701b0749\", amount: 100){amount,name}}")))))
