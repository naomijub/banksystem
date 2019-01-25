(ns banksystem.resolvers
  (:require [cheshire.core :as json]
            [clojure.java.io :as io]))

(def data (atom {:d3bbb532-0548-4fd1-856c-01a9701b0749 
                  {:id "12345" :name "Julia" :amount 5000.0}
                 :ded6809d-1840-4194-88cc-37c6d342e13e
                  {:id "54321" :name "Naomi" :amount 10000.0}}))

(defn savings [context {id :id} _]
  (get @data (keyword id)))

(defn resolver-map []
  {:query/savings (partial savings)})
