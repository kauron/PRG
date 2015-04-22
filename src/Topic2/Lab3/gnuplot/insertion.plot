set yrange [-1000:]
set xlabel "Size"
set ylabel "Microseconds"
set key left
set grid
plot "insertion.out" using 1:2 title "Best case" with lines
replot "" using 1:3 title "Worst case" with lines
replot "" using 1:4 title "Average case" with lines
#set term pdf colour enhanced solid
#set output "insertion.pdf"
#replot

f(x) = a * x + b
fit f(x) "insertion.out" using 1:2 via a, b
replot f(x) title "Best fit" with lines

g(x) = c * x * x + d * x + e
fit g(x) "insertion.out" using 1:3 via c, d, e
replot g(x) title "Worst fit" with lines

h(x) = t * x * x + u * x + v
fit h(x) "insertion.out" using 1:4 via t, u, v
replot h(x) title "Average fit" with lines

set term pdf colour enhanced solid
set output "insertion.pdf"
replot

pause -1 "Press ENTER to continue..."