(ns euler.problem25
  (:require [euler.common :refer [fib-lazy]]))

;; problem-25

(defn problem25 []
  (count (str (last (take 4782 (fib-lazy))))))
