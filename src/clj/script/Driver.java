package clj.script;

import clojure.lang.RT;
import clojure.lang.Var;

import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {
        // classpath 找不到是一个非常恼人的问题，其目前在 \target\classes
        RT.loadResourceScript("clj/script/clojure_script.clj");
//        RT.loadResourceScript("clj/script/clojure_script.clj");
        Var report = RT.var("clj.script.clojure_script", "print-report");
        Long result = (Long) report.invoke("Siva");
        System.out.println("Result: " + result);
    }
}
