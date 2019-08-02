(ns euler.problem7
   (:require [euler.common :refer [lazy-primes]]))

;; Problem 7 
;;
(defn problem7
  []
  (nth (lazy-primes 1) 10000))

