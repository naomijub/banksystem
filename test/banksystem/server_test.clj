(ns banksystem.server-test
  (:require [clojure.test :refer :all]
            [cheshire.core :as json]
            [banksystem.core :refer :all]
            [banksystem.util :as util]))

(deftest GQL-endpoint-queries
  (testing "routes with no optional args"
    (is (= "{\"data\":{\"savings\":{\"name\":\"Teste1\",\"amount\":5000.0}}}"
           (json/generate-string (util/q "{savings(uuid:\"d3bbb532-0548-4fd1-856c-01a9701b0749\"){name, amount}}"))))
    (is (= {:data {:savings {:name "Teste1" :amount 5000.0}}}
           (util/q "{savings(uuid:\"d3bbb532-0548-4fd1-856c-01a9701b0749\"){name, amount}}")))))
