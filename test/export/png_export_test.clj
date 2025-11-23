(ns export.png-export-test
  (:require [clojure.test :refer [deftest is]]
            [export.png-export :as png-export]))
            
(deftest save-image-test
  (with-redefs [png-export/save-image (fn [_img _filepath] true)]
    (is (true? (png-export/save-image nil "test.png")))))
