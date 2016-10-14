(defn triangle-num [n] (/ (* n (+ n 1)) 2))

(defn first-divisor [x]
    (loop [n 2]
        (if (zero? (mod x n))
            n
            (recur (inc n)))))

(defn prime-divisors [n]
    (loop [x n a []]
        (let [divisor (first-divisor x)]
            (if (= divisor x)
                (conj a x)
                (recur (/ x divisor) (conj a divisor))))))

(defn get-powers [prime-divisors-list]
    (loop [l prime-divisors-list result []]
        (if (empty? l)
            result
            (recur (drop-while #(= (first l) %) l) (conj result (count (take-while #(= (first l) %) l)))))))

(defn get-divisors [n]
    (reduce * (map #(inc %) (get-powers (prime-divisors (triangle-num n))))))

(defn get-highly-divisible-triangular-number [n]
    (loop [x 2]
        (if (>= (get-divisors x) n)
            (triangle-num x)
            (recur (inc x)))))

(get-highly-divisible-triangular-number 500)

;(defn triangle-num [x] (map #(reduce + (range 1 (inc %))) (range 1 x)))
;(defn smaller-than-n [n] (range 1 n))
;(defn divisors1 [n] (map #(if (= (mod n %) 0) %)(smaller-than-n n)))
;(defn divisors [n] (sort (conj (filter #(not (nil? %)) (divisors1 n)) n)))
;(defn num-of-divisors [n] (count (divisors n)))

;(map #(count (divisors %)) (range 100))
;(filter (fn [n] (not (nil? n))) (map #(if (> (count (divisors %)) 500) %) (range 4000000)))
;(loop [n 1]
;    (if (>= (num-of-divisors n) 10)
;    n
    ; (recur (inc n))))

; (loop [x 10 a []]
;     (if (= (first-divisor x) x)
;     (conj a x)
;     (recur (/ x (first-divisor x)) (conj a (first-divisor x)))))
