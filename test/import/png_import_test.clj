(ns import.png-import-test
  (:require [clojure.test :refer [deftest is]]
            [import.png-import :as png-import]))

(deftest get-red-brightness-test
  (let [img (png-import/import-image "test/test-files/red-pixel.png")]
    (is (= 200 (png-import/get-red-brightness img 0 0)))))
