(ns com.gentest.gen-clojure
  (:import (com.gentest AbstractJavaClass))
  (:gen-class
    :name com.gentest.ConcreteClojureClass
    :extends com.gentest.AbstractJavaClass
    :constructors {[String] [String]
                   [String String] [String String]}
    :implements [Runnable]
    :init initialize
    :state localState
    :methods [[stateValue [] String]]))

(defn -initialize
  ([s1]
   (println "Init value:" s1)
   [[s1 "default"] (ref s1)])
  ([s1 s2]
   (println "Init values:" s1 "," s2)
   [[s1 s2] (ref s2)]))

(defn -getCurrentStatus [this]
  "getCurrentStatus from - com.gentest.ConcreteClojureClass")

(defn -stateValue [this]
  @(.localState this))

(defn -run [this]
  (println "In run!")
  (println "I'm a" (class this))
  (dosync (ref-set (.localState this) "GO")))


