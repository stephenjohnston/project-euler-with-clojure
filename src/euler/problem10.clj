(ns euler.problem10
  (:use [euler.common :only [lazy-primes]]))

;; Problem 10

(defn problem-10
  "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
Find the sum of all the primes below two million."
  []
  (->> 
   (lazy-primes 1)
   (take-while #(< % 2000000))
   (reduce +)))
