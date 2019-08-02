(ns euler.problem7
   (:use [euler.common :only [lazy-primes]]))

;; Problem 7 
;;
(defn problem7
  []
  (nth (lazy-primes 1) 10000))

