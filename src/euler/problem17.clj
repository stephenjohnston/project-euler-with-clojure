(ns euler.problem17)

;; Problem 17
(defn single-digit-to-word [n]
   (condp = n
      0 "zero"
      1 "one"
      2 "two"
      3 "three"
      4 "four"
      5 "five"
      6 "six"
      7 "seven"
      8 "eight"
      9 "nine"))

(defn teen-to-word [n]
  (cond 
   (= n 10) "ten"
   (= n 11) "eleven"
   (= n 12) "twelve"
   (= n 13) "thirteen"
   (= n 15) "fifteen"
   (= n 18) "eighteen"
   (> n 13) (str (single-digit-to-word (rem n 10)) "teen")))

(defn double-digit-to-word [n]
  (let [single-digit (rem n 10)
        prefix        (cond 
                       (< n 30) "twenty"
                       (< n 40) "thirty"
                       (< n 50) "forty"
                       (< n 60) "fifty"
                       (< n 70) "sixty"
                       (< n 80) "seventy"
                       (< n 90) "eighty"
                       (< n 100) "ninety")]
    (if (= single-digit 0) 
      prefix
      (str prefix "-" (single-digit-to-word single-digit)))))


(defn number-to-word [n]
  (cond
   (< n 10) (single-digit-to-word n)
   (< n 20) (teen-to-word n)
   (< n 100) (double-digit-to-word n)
   (< n 1000) (triple-digit-to-word n)
   (= n 1000) "one thousand"))


(defn triple-digit-to-word [n]
  (let [first-digit (quot n 100)
        remaining (rem n 100)
        first-part (str (single-digit-to-word first-digit) " hundred")]
    (if (= remaining 0)
      first-part
      (str first-part " and " (number-to-word remaining)))))

(defn problem-17 []
  (reduce +  (map count (flatten  (map #(clojure.string/split % #"[ \-]") (flatten (map number-to-word (range 1 1001))))))))

