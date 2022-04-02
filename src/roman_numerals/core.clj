(ns roman-numerals.core)

(defn n-symbols 
  [n s]
  (apply str (map (fn [_] s) (range n))))

(defn roman
  [x]
  (cond 
   (= (rem x 5) 4) (str "I" (nth ["V" "X"] (quot x 5)))
   (> x 4) (str "V" (roman (- x 5)))
   (< x 4) (n-symbols x "I")))


