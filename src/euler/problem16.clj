(ns euler.problem16
   (:require [euler.common :refer [char->int]]))

;; problem-16
(defn problem-16 []
  (->>
   (repeat (bigint 2))
   (take 1000)
   (reduce *)
   (str)
   (map char->int)
   (reduce +)))
