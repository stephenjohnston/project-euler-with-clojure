(def single-digits ["one" "two" "three" "four" "five" "six" "seven" "eight" "nine"])
(def teens ["ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"])
(def doubles ["twenty" "thirty" "fourty" "fifty" "sixty" "seventy" "eighty" "ninety"])

(defn char->int [ch]
  (Character/digit ch 10))

(defn to-num-seq [num]
  (->> num
       (str)
       (seq)
       (map char->int)))

(defn num-list-to-words [l]

)
