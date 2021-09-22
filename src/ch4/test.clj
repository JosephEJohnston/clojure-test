;(ns ch4.test)

(def user-1 {:login "rob", :referrer "mint.com", :salary 100000,
             :rating :rating/bronze})
(def user-2 {:login "gordon", :referrer "mint.com", :salary 80000,
             :rating :rating/silver})
(def user-3 {:login "kyle", :referrer "google.com", :salary 90000,
             :rating :rating/gold})
(def user-4 {:login "celeste", :referrer "yahoo.com", :salary 70000,
             :rating :rating/platinum})

(defn fee-category [user]
  [(:referrer user) (:rating user)])

(defn fee-amount [percentage user]
  (with-precision 16 :rounding HALF_EVEN
     (* 0.01M percentage (:salary user))))

(defmulti profit-based-affiliate-fee fee-category)

(defmethod profit-based-affiliate-fee ["mint.com" :rating/bronze]
  [user] (fee-amount 0.03M user))
(defmethod profit-based-affiliate-fee ["mint.com" :rating/silver]
  [user] (fee-amount 0.04M user))
(defmethod profit-based-affiliate-fee ["mint.com" :rating/gold]
  [user] (fee-amount 0.05M user))
(defmethod profit-based-affiliate-fee ["mint.com" :rating/platinum]
  [user] (fee-amount 0.05M user))

(defmethod profit-based-affiliate-fee ["google.com" :rating/platinum]
  [user] (fee-amount 0.05M user))
(defmethod profit-based-affiliate-fee ["google.com" :rating/gold]
  [user] (fee-amount 0.03M user))
(defmethod profit-based-affiliate-fee :default
  [user] (fee-amount 0.02M user))


(derive :rating/bronze :rating/basic)
(derive :rating/silver :rating/basic)
(derive :rating/gold :rating/premier)
(derive :rating/platinum :rating/premier)
(derive :rating/basic :rating/ANY)
(derive :rating/premier :rating/ANY)

(isa? :rating/gold :rating/premier)
(isa? :rating/gold :rating/ANY)
(isa? :rating/ANY :rating/premier)
(isa? :rating/gold :rating/gold)

(parents :rating/premier)

(ancestors :rating/gold)

(descendants :rating/ANY)

(defmulti greet-user :rating)

(defmethod greet-user :rating/basic [user]
  (str "Hello " (:login user) \.))

(defmethod greet-user :rating/premier [user]
  (str "Welcome, ", (:login user), ", valued affiliate member!"))

(map greet-user [user-1 user-2 user-3 user-4])

(remove-method profit-based-affiliate-fee ["mint.com" :rating/gold])
(remove-method profit-based-affiliate-fee ["mint.com" :rating/platinum])
(remove-method profit-based-affiliate-fee ["google.com" :rating/gold])
(remove-method profit-based-affiliate-fee ["google.com" :rating/platinum])

(defmethod profit-based-affiliate-fee ["mint.com" :rating/premier]
  [user] (fee-amount 0.05M user))

(defmethod profit-based-affiliate-fee ["google.com" :rating/premier]
  [user] (fee-amount 0.03M user))

(map profit-based-affiliate-fee [user-1 user-2 user-3 user-4])

(defmulti size-up (fn [observer observed]
                    [(:rating observer) (:rating observed)]))

(defmethod size-up [:rating/platinum :rating/ANY] [_ observed]
  (str (:login observed) " seems scrawny."))

(defmethod size-up [:rating/ANY :rating/platinum] [_ observed]
  (str (:login observed) " shimmers with an unearthly light."))

; 报错
;(size-up {:rating :rating/platinum} user-4)

(prefer-method size-up [:rating/ANY :rating/platinum]
               [:rating/platinum :rating/ANY])

(size-up {:rating :rating/platinum} user-4)

(prefers size-up)

