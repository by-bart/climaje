(ns manipulation.manipulation-test
  (:require [clojure.test :refer [deftest is]])
  (:import  (java.awt.image BufferedImage)
            (java.awt Color)
            (java.io ByteArrayOutputStream ByteArrayInputStream)
            (javax.imageio ImageIO)))

(defn create-1px-image [red green blue]
  (let [img (BufferedImage. 1 1 BufferedImage/TYPE_INT_RGB)]
    (.setRGB img 0 0 (.getRGB (Color. red green blue)))
    img))

(defn image->bytes [img format]
  (let [baos (ByteArrayOutputStream.)]
    (ImageIO/write img format baos)
    (.toByteArray baos)))

(deftest brightness-test
  (let [img (create-1px-image 200 50 50)
        bytes (image->bytes img "png")
        read-img (ImageIO/read (ByteArrayInputStream. bytes))
        rgb (.getRGB read-img 0 0)
        color (Color. rgb)
        red (.getRed color)
        blue (.getBlue color)]
    (is (= 200 red))
    (is (= 50 blue))))