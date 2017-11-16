(ns mx-mitsumi-adapter.core
  (:require [mx-mitsumi-adapter.thing :refer [render-things!]]
  (:gen-class)))


(defn -main
  "render all of the parts and sub parts"
  [& args]
  (render-things!))

