(ns roman-numerals.core)

(defn arabic->roman-1-9
  [x [one five ten]]
  (cond
    (= x 4) (str one five)
    (= x 9) (str one ten)
    (< x 4) (apply str (repeat x one))
    (> x 4) (str five (apply str (repeat (- x 5) one)))))

(defn arabic->roman
  [x]
  (if (< x 4000)
    (apply str (map (fn [[n & digits]] (arabic->roman-1-9 (quot (rem x (* n 10)) n) digits))
                    [[1000 "M" nil nil]
                     [100 "C" "D" "M"]
                     [10 "X" "L" "C"]
                     [1 "I" "V" "X"]]))
    nil))