(ns euler.common)

(defn fib-lazy-aux
  "compute a fibonaci sequence lazily"
  [a b]
  (cons a (lazy-seq (fib-lazy-aux b (+ a b)))))

(defn fib-lazy 
  "compute a fibonaci sequence lazily"
  []
  (fib-lazy-aux (bigint 1) (bigint 1)))

(defn divisible? [n x]
  (= (rem n x) 0))

(defn prime? [n]
  (if (= n 2) 
    true
    (let [sqrt-of-n (Math/sqrt n)]
      (not-any? #(divisible? n %) (range 2 (inc sqrt-of-n))))))

(defn prime-factors [n]
  (let [sqrt-of-n (Math/sqrt n)]
    (for [x (range 1 sqrt-of-n) 
          :when (and (divisible? n x) (prime? x))]
      x)))

(defn gcd [a b] 
  (if (zero? a) 
    b
    (recur (mod b a) a)))

(defn lcm [a b] 
  (/ (* a b) (gcd a b))) 

(defn square [n] (* n n))

(defn next-prime [n]
  (->> 
   (iterate inc (inc n)) 
   (drop-while #(not (prime? %)))
   (first)))

(defn lazy-primes
  [n]
  (let [next-prime-num (next-prime n)]
    (cons next-prime-num (lazy-seq (lazy-primes next-prime-num)))))

(defn char->int [ch]
  (Character/digit ch 10))

(defn sum-of-n [n]
  (/  (* (+ n 1) n) 2))

(defn divisors-count [n]
  (* 2 (count (filter #(zero? (rem n %))
                      (range 1 (inc (Math/sqrt n)))))))

(defn factorial [n]
  (reduce * (range 1M (inc (bigint n)))))

(defn power-of-ten [n]
  (reduce * (take n (repeat 10M))))

(defn proper-divisors [n]
  (butlast (sort (distinct (flatten (for [x (range 1 (inc (Math/sqrt n))) 
                                          :when (and (divisible? n x))]
                                      [x (/ n x)]))))))

(defn sum [l]
  (reduce + l))

(defn is-amicable? [n]
  (let [dn (sum (proper-divisors n))]
    (and (not (= n dn)) (= n (sum (proper-divisors dn))))))

(defn abundant-number? [n]
  (> (reduce + (proper-divisors n)) n))

(defn permutations [n r]
  (/ (factorial n) (factorial (- n r))))

