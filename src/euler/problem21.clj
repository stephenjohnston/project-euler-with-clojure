(ns euler.problem21
  (:require [euler.common :refer [is-amicable?]]))

;; problem-21
(defn problem-20 []
  (->> (range 1 10000)
       (filter is-amicable?)
       (sum)))

