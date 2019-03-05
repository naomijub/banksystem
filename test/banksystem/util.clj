(ns banksystem.util
  (:require [banksystem.schema :as schema]
            [com.walmartlabs.lacinia :as lacinia]))

(def data (atom {:d3bbb532-0548-4fd1-856c-01a9701b0749
                 {:id "12345" :name "Teste1" :amount 5000.0}
                 :ded6809d-1840-4194-88cc-37c6d342e13e
                 {:id "54321" :name "Teste2" :amount 10000.0}}))

(def schema-util (schema/load-schema data))

(defn q [query-string]
  (lacinia/execute schema-util query-string nil nil))

(defn get-message [query]
  (-> query
    (get :errors)
    (first)
    (get :message)))
