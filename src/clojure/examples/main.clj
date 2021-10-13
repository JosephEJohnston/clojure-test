(ns clojure.examples.main
  (:gen-class))
(require '[clojure.java.io :as io])

(defn hello-world []
  (println "Hello World"))
(hello-world)

(println (+ 1 2))

(println (str "Hello" "World"))

(defn Example []
  (println (str "Hello World"))
  (println (+ 1 2)))

(Example)

(println *ns*)

(defn Example []
  (.exists (io/file "Example.txt")))
(println (true?(Example)))

;(println (+ 1 2 3))
;(println [+ 1 2 3])
;
;(println (+ 1 2 3 4 5))
;(println (+ 1, 2, 3, 4, 5))

(println 2r1111)
(println 2r1111)
(println 2r1111)
(println 2r1111)