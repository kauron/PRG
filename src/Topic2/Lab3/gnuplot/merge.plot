set xlabel "Size"
set ylabel "Microseconds"
set key left
set grid
plot "merge.out" using 1:2 title "Average case" with lines

f(x) = a * x * log(b * x) + c
fit f(x) "merge.out" using 1:2 via a, b, c
replot f(x) title "Average fit" with lines

set term pdf colour enhanced solid
set output "merge.pdf"
replot

pause -1 "Press ENTER to continue..."