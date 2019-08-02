(ns euler.problem3
    (:use [euler.common :only [prime-factors]]))

;; Problem 3
;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn problem3 []
  (apply max (prime-factors 600851475143)))

