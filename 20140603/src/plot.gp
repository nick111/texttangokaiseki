set style fill solid border lc rgb "black"
set xtics rotate by -90
set term pdf font "Arial"
set title 'Noun, Verb and Adjective'
set title font 'Arial,30'
set output "out.pdf"
plot "allOut.txt" using 0:2:xtic(1) with boxes lw 2 lc rgb "light-cyan" notitle


set title 'Noun'
plot "nounOut.txt" using 0:2:xtic(1) with boxes lw 2 lc rgb "light-cyan" notitle

set title 'Verb'
plot "verbOut.txt" using 0:2:xtic(1) with boxes lw 2 lc rgb "light-cyan" notitle

set title 'Adjective'
plot "adjectiveOut.txt" using 0:2:xtic(1) with boxes lw 2 lc rgb "light-cyan" notitle
