(ns euler.problem18)

;; Problem 18

(def triangle-str 
  "75
95 64
17 47 82
18 35 87 10
20 04 82 47 65
19 01 23 75 03 34
88 02 77 73 07 63 67
99 65 04 28 06 16 70 92
41 41 26 56 83 40 80 70 33
41 48 72 33 47 32 37 16 94 29
53 71 44 65 25 43 91 52 97 51 14
70 11 33 28 77 73 17 78 39 68 17 57
91 71 52 38 17 14 91 43 58 50 27 29 48
63 66 04 68 89 53 67 30 73 16 69 87 40 31
04 62 98 27 23 09 70 98 73 93 38 53 60 04 23")

(defn str->int [s]
  (Integer/parseInt s))

(defn str->2dvector [s]
  (let [lines  (clojure.string/split-lines s) 
        nums   (map #(map str->int (clojure.string/split % #" ")) lines)]
    nums))

(defn max-row-pairs [last-row next-row]
  (let [pairs (partition 2 1 last-row)]
    (map (fn [v1 [p1 p2]] (max (+ v1 p1) (+ v1 p2))) next-row pairs)))

;; work from bottom row towards the top.
;; for each row, compare it to the row above.
;; For each number in the row above, add it to pair below it.
;; Take the max of that pair to produce the new row.
;; repeat until done.
(defn problem-18 [s]
  (->> (str->2dvector s)
       (reverse)
       (reduce max-row-pairs)))

;; problem-67
(defn get-triangle [filename] 
  (slurp filename))

(str->2dvector (get-triangle "/Users/stephen/Downloads/triangle.txt"))

