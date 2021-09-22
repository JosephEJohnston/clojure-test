(ns clojure-test.core)

(defn run-report [user]
  (println "Running report for" user))

(defn dispatch-reporting-jobs [all-users]
  (doseq [user all-users]
    (run-report user)))

(defn non-zero-expenses [expenses]
  (let [non-zero? (fn [e] (not (zero? e)))]
    (filter non-zero? expenses)))

(defn non-zero-expenses [expenses]
  (remove zero? expenses))

(defn factorial [n]
  (let [numbers (range 1 (+ n 1))]
    (reduce * numbers)))

(defn factorial-steps [n]
  (let [numbers (range 1 (+ n 1))]
    (reductions * numbers)))

(def chessboard-labels
  (for [alpha "abcdefgh"
        num (range 1 9)]
    (str alpha num)))

;; 不是函数，不能加括号
;(println chessboard-labels)

(defn prime? [x]
  (let [divisors (range 2 (inc (int (Math/sqrt x))))
        remainders (map (fn [d] (rem x d)) divisors)]
    (not (some zero? remainders))))

(defn primes-less-than [n]
  (for [x (range 2 (inc n))
        :when (prime? x)]
    x))

(defn pairs-for-primes [n]
  (let [z (range 2 (inc n))]
    (for [x z, y z, :when (prime? (+ x y))]
      (list x y))))

(defn final-amount [principle rate time-periods]
  (* (Math/pow (+ 1 (/ rate 100)) time-periods) principle))

(defn final-amount-> [principle rate time-periods]
  (-> rate
      (/ 100)
      (+ 1)
      (Math/pow time-periods)
      (* principle)))

(defn factorial [n]
  (reduce * (range 1 (+ 1 n))))

(defn factorial->> [n]
  (->> n
       (+ 1)
       (range 1)
       (reduce *)))

(def users
  [{:username "kyle"
    :firstname "Kyle"
    :lastname "Smith"
    :balance 175.00M
    :member-since "2009-04-16"}
   {:username "zak"
    :firstname "Zackary"
    :lastname "Jones"
    :balance 12.95M
    :member-since "2009-02-01"}
   {:username "rob"
    :firstname "Robert"
    :lastname "Jones"
    :balance 98.50M
    :member-since "2009-03-30"}])

(defn sorter-using [ordering-fn]
  (fn [collection]
    (sort-by ordering-fn collection)))

(defn lastname-firstname [user]
  [(user :lastname) (user :firstname)])

(defn balance [user] (user :balance))

(defn username [user] (user :username))

(def poorest-first (sorter-using balance))

(def alphabetically (sorter-using username))

(def last-then-firstname (sorter-using lastname-firstname))

(comment
  (def ^:dynamic *eval-me* 10)
  (defn print-the-var [label]
    (println label *eval-me*))
  (print-the-var "A:")
  (binding [*eval-me* 20]
    (print-the-var "B:")
    (binding [*eval-me* 30]
      (print-the-var "C:"))
    (print-the-var "D:"))
  (print-the-var "E:")
  )

(defn ^:dynamic twice [x]
  (println "original function")
  (* 2 x))

(defn call-twice [y]
  (twice y))

(defn with-log [function-to-call log-statement]
  (fn [& args]
    (println log-statement)
    (apply function-to-call args)))

(call-twice 10)

(binding [twice (with-log twice "Calling the twice function")]
  (call-twice 20))

(call-twice 30)

