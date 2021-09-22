(ns com.gentest.main
  (:import (com.gentest ConcreteClojureClass)))

(comment
  "在 clojure 中编译抽象类的实现类，再使用，需要：
    1. 先编译抽象类，并放在对应文件夹中（root/target/classes 或 root/classes 文件夹）
    2. 再编译具体类，同上
    3. 使用")

(defn -main []
  (let [g (new ConcreteClojureClass "READY")]
    (println (.getCurrentStatus g))
    (println (.getSecret g))
    (println (.stateValue g)))
  (let [g (new ConcreteClojureClass "READY" "SET")]
    (println (.stateValue g))
    (.start (Thread. g))
    (Thread/sleep 1000)
    (println (.stateValue g))))
