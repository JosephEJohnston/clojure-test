(ns ch5.test
  (:import (java.io FileFilter)))
(import 'java.awt.event.MouseAdapter)

(proxy [MouseAdapter] []
  (mousePressed [event]
    (println "Hey!")))

(reify FileFilter
  (accept [this f]
    (.isDirectory f)))
