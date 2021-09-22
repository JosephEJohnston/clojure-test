(ns clj-in-act.ch3.reader
  (:import (java.util UUID)))

(defn guid [four-letters-four-digits]
  (UUID/fromString
    (str four-letters-four-digits "-1000-413f-8a7a-f11c6a9c4036")))

;; 要导入 namespace
