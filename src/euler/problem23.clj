(ns euler.problem23
  (:require [euler.common :refer [abundant-number?])

;; problem-23

(defn all-ab-sums-set [ab-numbers]
  (set (for [x ab-numbers y ab-numbers] (+ x y))))

(defn all-sums-of-two-abundant-numbers-not-abundant [n ab-numbers]
  (let [ab-sum-set (all-ab-sums-set ab-numbers)]
    (filter #(not (contains? ab-sum-set %)) (range 1 (inc n)))))

(def ab-numbers (filter abundant-number? (range 1 28123)))


(defn problem23 []
  (reduce + (all-sums-of-two-abundant-numbers-not-abundant 28123 ab-numbers)))
