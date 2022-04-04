(ns roman-numerals.core
  (:require [clojure.set :as set]
            [clojure.string :refer [index-of]]))


;; first solution

(defn arabic->roman-1-9
  [x [one five ten]]
  (cond
    (= x 4) (str one five)
    (= x 9) (str one ten)
    (< x 4) (apply str (repeat x one))
    (> x 4) (str five (apply str (repeat (- x 5) one)))))

(defn arabic->roman-first
  [x]
  (if (< x 4000)
    (apply str (map (fn [[n & digits]] (arabic->roman-1-9 (quot (rem x (* n 10)) n) digits))
                    [[1000 "M" nil nil]
                     [100 "C" "D" "M"]
                     [10 "X" "L" "C"]
                     [1 "I" "V" "X"]]))
    nil))
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


;;
;; SOLUTION using table
;;
(def map-roman->arabic {"I" 1
                        "IV" 4
                        "V" 5
                        "IX" 9
                        "X" 10
                        "XL" 40
                        "L" 50
                        "XC" 90
                        "C" 100
                        "CD" 400
                        "D" 500
                        "CM" 900
                        "M" 1000})

(def map-arabic->roman (set/map-invert map-roman->arabic))

;;
;; both functions have the same logic operating on different domains: strings and numbers
;;
(defn roman->arabic
  [number]
  (if (empty? number) 0
      (let [largest (last (filter #(= 0 (index-of number %))
                                  (sort (vals map-arabic->roman))))]
        (+ (map-roman->arabic largest) (roman->arabic (subs number (count largest)))))))

(defn arabic->roman
  [number]
  (if (zero? number) ""
      (let [largest (last (filter #(>= number %)
                                  (sort (vals map-roman->arabic))))]
        (str (map-arabic->roman largest) (arabic->roman (- number largest))))))

