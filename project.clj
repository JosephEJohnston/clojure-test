(defproject clojure-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/data.json "2.4.0"]]

  ; Place our "AbstractJavaClass.java" and "gen-clojure.clj" files under
  ; the src/com/gentest directory
  :source-paths ["src"]
  :java-source-paths ["src"]

  ; :aot is a list of clojure namespaces to compile
  :aot [com.gentest.gen-clojure]

  ; This is the java class "lein run" should execute.
  :main com.gentest.ConcreteClojureClass

  :repl-options {:init-ns clojure-test.core})
