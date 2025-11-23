(ns import.png-import
  (:require [clojure.java.io :as io])
  (:import [java.awt Color]
           [javax.imageio ImageIO]))

(defn import-image 
  [filepath]
  (ImageIO/read (io/file filepath)))

(defn get-red-brightness 
  [img x y] 
  (let [rgb (.getRGB img x y)
        color (Color. rgb)]
    (.getRed color)))