(ns twjoi.core
  (:gen-class)
  (:require [com.walmartlabs.lacinia.pedestal :as service]
            [io.pedestal.http :as server]
            [io.pedestal.http.route :as route]
            [twjoi.schema :as schema]))

(defn build-service []
  (service/service-map
   (schema/load-schema)
   {:graphiql true}))

(defn start-service [service]
  (server/start
   (server/create-server service)))

(defn -main [& args]
  (println "\nCreating your server..."
           (start-service (build-service))))
