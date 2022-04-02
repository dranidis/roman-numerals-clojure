(ns roman-numerals.core)

(defn n-symbols
  [n s]
  (apply str (map (fn [_] s) (range n))))

(defn arabic->roman-1-9
  [x [one five ten]]
  (cond
    (< x 4) (n-symbols x one)
    (= x 4) (str one five)
    (= x 9) (str one ten)
    (> x 4) (str five (n-symbols (- x 5) one))))

(defn arabic->roman
  [x]
  (if (< x 4000)
    (str (arabic->roman-1-9 (quot x 1000) ["M" nil nil])
         (arabic->roman-1-9 (quot (rem x 1000) 100) ["C" "D" "M"])
         (arabic->roman-1-9 (quot (rem x 100) 10) ["X" "L" "C"])
         (arabic->roman-1-9 (quot (rem x 10) 1) ["I" "V" "X"]))
  nil))


