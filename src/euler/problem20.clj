(ns euler.problem20 
  (:use [euler.common :only [factorial]]))

;; problem-20

(defn problem20 [] 
  (reduce + (map char->int (seq (str (factorial n))))))

