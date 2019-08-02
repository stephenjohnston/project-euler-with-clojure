(ns euler.problem24)

;; problem-24

(defn perm-set [xs]
  (case (count xs)
    0 '()
    1 (list (seq xs))
    (for [x xs, y (perm-set (disj xs x))]
      (cons x y))))

(defn problem24 []
  (nth (sort (map #(apply str %) (perm-set #{0 1 2 3 4 5 6 7 8 9}))) 999999))

