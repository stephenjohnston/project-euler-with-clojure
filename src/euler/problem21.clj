(ns euler.problem21
  (:use [euler.common :only [is-amicable?]]))

;; problem-21
(defn problem-20 []
  (->> (range 1 10000)
       (filter is-amicable?)
       (sum)))

