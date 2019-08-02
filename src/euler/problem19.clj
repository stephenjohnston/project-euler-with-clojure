(ns euler.problem19)

;; Problem 19
(defn is-leap-year?
  "A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400."
  [year]
  (or (and (divisible? year 4) (not (divisible? year 100))) (divisible? year 400)))

(defn max-date-in-month [month year]
  (condp = month
      1 31
      2 (if (is-leap-year? year) 29 28)
      3 31
      4 30
      5 31
      6 30
      7 31
      8 31
      9 30
     10 31
     11 30
     12 31))

(defn date-less-than [d1 d2]
  (if (< (:year d1) (:year d2))
    true
    (if (= (:year d1 (:year d2)))
      (if (< (:month d1) (:month d2))
        true
        (if (= (:month d1) (:month d2))
          (if (< (:day d1) (:day d2))
            true
            false)
          false))
      false)))

(defn incr-year [date]
  (assoc date :year (inc (:year date))))

(defn incr-month [{:keys [month year] :as date}]
  (let [next-month (inc month)]
    (if (> next-month 12)
      (incr-year (assoc date :month 1))
      (assoc date :month next-month))))

(defn incr-day [{:keys [day month year dow] :as date}]
  (let [max-days-in-month (max-date-in-month month year)
        next-day (inc day)
        next-dow (rem (inc dow) 7)]
    (if (> next-day max-days-in-month)
      (incr-month (assoc (assoc date :day 1) :dow next-dow))
      (assoc (assoc date :day next-day) :dow next-dow))))

(defn day-seq []
  (let [start {:dow 1 :day 1 :month 1 :year 1900}]
    (iterate incr-day start)))

(defn problem19)
(->> (day-seq)
     (drop-while #(date-less-than % {:day 1 :month 1 :year 1901})) 
     (take-while #(date-less-than % {:day 1 :month 1 :year 2001}))
     (filter #(and (= (:dow %) 0) (= (:day %) 1)))
     (count))

