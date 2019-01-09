(ns twjoi.server-test
  (:require [clojure.test :refer :all]
            [twjoi.core :refer :all]
            [twjoi.util :as util]))

(deftest GQL-endpoint-queries
  (testing "routes with no optional args"
    (is (= {:data
            {:routes [{:voo "NR1234"}
                      {:voo "RX1423"}
                      {:voo "ET3142"}
                      {:voo "FL9876"}
                      {:voo "JK7890"}]}}
           (util/q "{routes(destino:\"MIA\",origem:\"POA\"){voo}}")))))
