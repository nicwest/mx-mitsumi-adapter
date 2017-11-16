(ns mx-mitsumi-adapter.thing
  (:require [mx-mitsumi-adapter.utils :refer [render!]]
            [scad-clj.model :refer [cylinder cube rotate translate union 
                                    difference with-fn]]))

(def base-diameter 5.8)
(def base-radius (/ base-diameter 2))
(def base-height 4.0)
(def base-cruciform-height 3.5)
(def base-cruciform-thickness 1.50)
(def base-cruciform-width 4.05)
(def top-cruciform-height 4.0)
(def top-cruciform-thickness 1.4)
(def top-cruciform-width 5.0)

(defn cruciform
  [height thickness width]
  (let [block (cube thickness width height)]
    (union 
      block
      (->> block
          (rotate (/ Math/PI 2) [0 0 1])))))

(def base-cruciform
  (->> (cruciform (+ base-cruciform-height 1.0) 
                  base-cruciform-thickness 
                  base-cruciform-width)
       (translate [0 0 (- (/ (+ base-cruciform-height 1.0) 2.0) 1.0)])))

(def base-cylinder
  (->> (with-fn 90 (cylinder base-radius base-height))
         (translate [0 0 (/ base-height 2.0)])))

(def base
  (difference
    base-cylinder
    base-cruciform))

(def top
  (->> (cruciform (+ top-cruciform-height 0.5)
                  top-cruciform-thickness
                  top-cruciform-width)
       (translate [0 0 (/ top-cruciform-height 2.0)])))

(def adapter
  (union
    base
    (->> top
         (translate [0 0 base-height]))))

(defn render-things!
  []
  (render! "base-cruciform" base-cruciform)
  (render! "base-cylinder" base-cylinder)
  (render! "base" base)
  (render! "top" top)
  (render! "adapter" adapter))

(render-things!)
