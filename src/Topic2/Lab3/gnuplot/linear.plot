set xrange [:1100000]
set yrange [-0.2:0.5]
set xtics 200000
set ytics 0.05
set xlabel "Size"
set ylabel "Microseconds"
set key left
set grid
plot "linear.out" using 1:2 title "Best case" with lines, -6.63785e-32 * x + 3.27358e-26 title "Best fit"
replot "" using 1:3 title "Worst case" with lines, 2.2e-007 * x + 0.008 title "Worst fit"
replot "" using 1:4 title "Average case" with lines, 1.15758e-007 * x + -0.000666667
set term pdf colour enhanced solid
set output "linear.pdf"
replot

#f(x) = a * x + b
#fit f(x) "linear.out" using 1:2 via a, b

#g(x) = c * x + d
#fit g(x) "linear.out" using 1:3 via c, d

#h(x) = e * x + f
#fit h(x) "linear.out" using 1:4 via e, f

pause -1 "Press ENTER to continue..."