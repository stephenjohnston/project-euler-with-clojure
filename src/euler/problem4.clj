(ns euler.problem4)

;; Problem 4
;; A palindromic number reads the same both ways. The largest 
;; palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
;; Find the largest palindrome made from the product of two 3-digit numbers."
;;
(defn problem4 []
  (let [m (for [x (range 100 1000)
                y (range 100 1000)]
            (* x y))]
    (apply max (filter #(= (seq (str %)) (reverse (str %))) m))))

