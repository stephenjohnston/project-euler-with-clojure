(ns euler.problem20 
  (:require [euler.common :refer [factorial]]))

;; problem-20

(defn problem20 [] 
  (reduce + (map char->int (seq (str (factorial n))))))

