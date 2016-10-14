(ns app.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn get-collatz-seq [x]
    (loop [n x result []]
        (if (= n 0)
            nil
            (if (= n 1)
                (conj result n)
                (if (even? n)
                    (recur (/ n 2) (conj result n))
                    (recur (+ (* n 3) 1) (conj result n))
                )
            )
        )
    )
)

(defn max-collatz-seq-num [x]
    (loop [n x result [0 0]]
        (if (= n 0)
            result
            (if (> (last result) (get-collatz-num-count n))
                (recur (dec n) result)
                (recur (dec n) [n (get-collatz-num-count n)])
            )
        )
    )
)
