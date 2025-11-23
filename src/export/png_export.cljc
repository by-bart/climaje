(ns export.png-export
  (:require [clojure.java.io :as io])
  (:import [javax.imageio ImageIO]
           [java.awt.image BufferedImage]
           [java.awt Color]))



(defn save-image [img filepath] 
  (ImageIO/write img "png" (io/file filepath)))

(comment
  
  #_(defn create-1px-image [red green blue]
    (let [img (BufferedImage. 1 1 BufferedImage/TYPE_INT_RGB)]
      (.setRGB img 0 0 (.getRGB (Color. red green blue)))
      img))
  
  #_(let [img (create-1px-image 200 50 50)]
    (save-image img "red-pixel.png"))
  )