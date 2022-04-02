(ns roman-numerals.core)

(defn n-symbols 
  [n s]
  (apply str (map (fn [_] s) (range n))))

(defn roman-unit
  [x [one five ten]]
  (cond
    (= (rem x 5) 4) (str one (nth [five ten] (quot x 5)))
    (< x 4) (n-symbols x one)
    (> x 4) (str (nth ["" five ten] (quot x 5))
                 (roman-unit (- x (* (quot x 5) 5)) [one five ten]))))
(defn roman
  [x]
  (let [tens (quot x 10)
        units (rem x 10)]
    (str (roman-unit tens ["X" "L" "C"]) (roman-unit units ["I" "V" "X"]))))


(rem 14 5)
(rem 10 5)

(quot 0 5)
(quot 5 5)
(quot 10 5)

(quot 20 10)
(rem 20 10)