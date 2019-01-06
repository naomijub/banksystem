(ns twjoi.resolvers
  (:require [cheshire.core :as json]))


(def data (as-> "./resources/stub.json" $
            (slurp $)
            (json/parse-string $ true)))

(defn routes-origin->destination [context
                                  {origin :origem
                                   destination :destino}
                                  _]
  (:rotas data))

(defn resolver-map []
  {:query/routes-origin->destination (partial routes-origin->destination)})
