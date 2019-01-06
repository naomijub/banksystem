(ns twjoi.util
  (:require [twjoi.schema :as schema]
            [com.walmartlabs.lacinia :as lacinia]))

(def schema-util (schema/load-schema))

(defn q [query-string]
  (lacinia/execute schema-util query-string nil nil))
