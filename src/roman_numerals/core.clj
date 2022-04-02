(ns roman-numerals.core)

(defn n-symbols 
  [n s]
  (apply str (map (fn [_] s) (range n))))

(defn roman
  [x]
  (case x
   4 "IV"
   5 "V"
   (n-symbols x "I")))
