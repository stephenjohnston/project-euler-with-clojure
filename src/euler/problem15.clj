(ns euler.problem15)

;; problem-15

;; returns a new grid and a stack
(defn get-next [row] 
  (let [outer-list-part (list (inc (first row)))] ; first element of the row, add 1, and make it a list.
    (concat 
     outer-list-part 
     (map #(reduce + %) (partition 2 1 row)) ; Sum every pair in row.
     outer-list-part)))
; outer-list-part surrounds the computed values to make the next row.

(defn get-possible-solutions [grid-size] 
  (->> (iterate get-next '(2))
       (filter #(odd? (count %))) ; only concerned with lists that have odd number of ints
       (take grid-size)
       (last)
       (apply max))) ; find the max value in the last row.

