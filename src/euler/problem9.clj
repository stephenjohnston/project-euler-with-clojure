(ns euler.problem9
  (:require [euler.common :refer [square]]))

;; Problem 9

(defn problem9
  []
  (for [a (range 1 500)
        b (range 1 500)
        c (range 1 500)
        :when (and  (> b a) 
                    (> c b)
                    (= (+ a b c) 1000)
                    (= (square c) (+ (square a) (square b))))]

    (* a b c)))
