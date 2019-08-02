(ns euler.problem6
   (:require [euler.common :refer [square]]))

;; Problem 6
;;
;; Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
;;
(defn problem6
  []
  (let [sum-of-squares (->> (range 1 101)
                            (map square)
                            (reduce +))
        square-of-sum (->> (range 1 101)
                           (reduce +)
                           (square))]
    (- square-of-sum sum-of-squares)))

