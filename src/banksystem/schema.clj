(ns banksystem.schema
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [com.walmartlabs.lacinia.util :as util]
            [com.walmartlabs.lacinia.schema :as schema]
            [banksystem.resolvers :refer [resolver-map]]))

(defn schema-parser [edn]
  (-> (io/resource edn)
      (slurp)
      (edn/read-string)))

(defn load-schema []
  (-> (schema-parser "schema.edn")
      (util/attach-resolvers (resolver-map))
      (schema/compile)))
