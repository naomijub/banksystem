(ns banksystem.core
  (:gen-class)
  (:require [com.walmartlabs.lacinia.pedestal :as service]
            [io.pedestal.http :as server]
            [io.pedestal.http.route :as route]
            [banksystem.schema :as schema]
            [banksystem.resolvers :as resolver]))

(defn build-service []
  (merge
   (service/service-map
    (schema/load-schema resolver/data)
    {:graphiql true})
   {::server/host "0.0.0.0"}))

(defn start-service [service]
  (server/start
   (server/create-server service)))

(defn -main [& args]
  (println "\nCreating your server..."
           (start-service (build-service))))
