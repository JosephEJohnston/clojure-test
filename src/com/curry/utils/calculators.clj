(ns com.curry.utils.calculators
  (:gen-class))
(load "calc/fcf")
(load "calc/dcf")

(defn present-value [data]
  (println "calculating present value..."))

; 找不到路径是因为没有 classes 文件夹
; (compile 'com.curry.utils.calculators)


