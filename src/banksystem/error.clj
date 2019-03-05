(ns banksystem.error
  (:require [com.walmartlabs.lacinia.resolve :refer [with-error]]))

(defn map-error [db value]
  (cond
    (and (number? value) (neg? value)) (with-error nil {:message "Valor deve ser maior que 0"})
    (and (keyword? value) (not (contains? @db value))) (with-error nil {:message "Id inexistente"})
    :else nil))

(defn generate-error [db amount id]
  (let [amount-error (map-error db amount)
        id-error (map-error db id)]
    (if (nil? amount-error)
      id-error
      amount-error)))
