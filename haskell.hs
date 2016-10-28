sqrt_n n 1 = 0.5*(n/2+2)
sqrt_n n prib = 0.5*((sqrt_n n (prib-1))+n/(sqrt_n n (prib-1)))
main = print $ sqrt_n 27 5

sum_digits n
        |n<10 = n
        |otherwise = (n `mod` 10)+(sum_digits (n `div` 10))
main = print $ sum_digits 10015

count_digits n
        |n<10 = 1
        |otherwise = 1+(count_digits (n `div` 10))
main = print $ count_digits 10015