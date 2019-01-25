(defproject banksystem "0.0.1-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [io.pedestal/pedestal.service "0.5.5"]
                 [io.pedestal/pedestal.jetty "0.5.5"]
                 [com.walmartlabs/lacinia "0.31.0"]
                 [com.walmartlabs/lacinia-pedestal "0.11.0"]
                 [ch.qos.logback/logback-classic "1.2.3" :exclusions [org.slf4j/slf4j-api]]
                 [cheshire "5.8.1"]
                 [org.slf4j/jul-to-slf4j "1.7.25"]
                 [org.slf4j/jcl-over-slf4j "1.7.25"]
                 [org.slf4j/log4j-over-slf4j "1.7.25"]]
  :plugins [[com.jakemccrary/lein-test-refresh "0.22.0"]
            [lein-cljfmt "0.6.3"]
            [lein-ancient "0.6.15"]]
  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "banksystem.core/run-dev"]}
                   :dependencies [[io.pedestal/pedestal.service-tools "0.5.5"]]}
             :uberjar {:aot [banksystem.core]}}
  :main ^{:skip-aot true} banksystem.core
  :test-refresh {:growl false
                 :notify-on-success false
                 :quiet true
                 :changes-only true
                 :stack-trace-depth nil
                 :run-once false
                 :watch-dirs ["src" "test"]
                 :refresh-dirs ["src" "test"]})
