(ns euler.problem22)

;; problem-22

(defn to-order-num [ch]
  (- (int ch) 64))

(defn obtain-score [word]
  (->> word
       (seq)
       (map to-order-num)
       (reduce +)))

(defn problem22 []
  (let [content (slurp "/Users/stephen/Downloads/names.txt")
        quoted-names   (clojure.string/split content #",")
        names          (sort (map #(clojure.string/replace % #"\"" "") quoted-names))
        scores         (map obtain-score (map clojure.string/trim names))]
    (->> (map (fn [x y] [x y]) scores (map inc (range)))
         (map #(* (first %) (second %)))
         (reduce +))))
