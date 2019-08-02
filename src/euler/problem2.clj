(ns euler.problem2
  (:use [euler.common :only [fib-lazy]]))

;;
;; Problem 2
;; By considering the terms in the Fibonacci sequence whose values 
;; do not exceed four million, find the sum of the even-valued terms."
;;
(defn problem2 []
  (->>
    (take-while #(< % 4000000) (fib-lazy))
    (filter even?)
    (reduce +)))
