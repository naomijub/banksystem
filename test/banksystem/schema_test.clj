(ns banksystem.schema-test
  (:require [clojure.edn :as edn]
            [clojure.test :refer :all]
            [banksystem.schema :refer [schema-parser]]))

(deftest schema-parser-test
  (testing "schema parser converts slurped Map to EDN format"
    (is (= {:pikachu "pikachu"} (schema-parser "test_schema.edn")))))
