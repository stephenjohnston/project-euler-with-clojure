(ns euler.problem1)

;; Problem 1
;; Find the sum of all the multiples of 3 or 5 below 1000
(defn problem1 []
   (->>
     (range 1 1000)
     (filter #(or (= (rem % 5) 0) (= (rem % 3) 0)))
     (reduce +)))

