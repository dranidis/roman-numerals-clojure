(ns roman-numerals.core)

(defn n-symbols 
  [n s]
  (apply str (map (fn [_] s) (range n))))

(defn roman
  [x]
 (n-symbols x "I"))
