(ns euler.problem14)

;; Problem 14
(defn transform [n]
  (if (odd? n)
    (+ 1 (* 3 n))
    (/ n 2)))

(defn build-chain [n]
  (loop [num n
         rslt []]
    (if (= num 1)
      (conj rslt num)
      (recur (transform num) (conj rslt num)))))

(defn longer-list [a b]
  (let [an (count a)
        bn (count b)]
    (if (> an bn) 
      a
      b)))

(defn problem-14 []
  (->> 
   (range 1 1000000)
   (map build-chain)
   (reduce longer-list)
   (first)))
