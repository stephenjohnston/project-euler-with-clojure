(ns euler.problem12)

;; problem 12
(defn sum-of-n [n]
  (/  (* (+ n 1) n) 2))

(defn divisors-count [n]
  (* 2 (count (filter #(zero? (rem n %))
                      (range 1 (inc (Math/sqrt n)))))))

(defn problem-12
  "What is the value of the first triangle number to have over 
five hundred divisors?"
  []
  (->> (range)
       (map sum-of-n)
       (filter #(> (divisors-count %) 500))
       (first)))
