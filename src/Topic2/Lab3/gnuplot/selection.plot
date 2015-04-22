set yrange [-1000:]
set xlabel "Size"
set ylabel "Microseconds"
set key left
set grid
plot "selection.out" using 1:2 title "Average case" with lines

f(x) = a * x * x + b * x + c
fit f(x) "selection.out" using 1:2 via a, b, c
replot f(x) title "Average fit" with lines

set term pdf colour enhanced solid
set output "selection.pdf"
replot

pause -1 "Press ENTER to continue..."