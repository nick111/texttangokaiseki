JAVAC = javac
PRONAME = Main
PROGRAM = Main.class
SRCS = Main.java
DAT_ALL = allOut.txt
DAT_NOUN = nounOut.txt
DAT_VERB = verbOut.txt
DAT_ADJECTIVE = adjectiveOut.txt
TEXT_FILE = yomu.txt
OUT_TEXT = out.txt
PDF_ALL = out.pdf

all: compile mec test graph

compile: $(SRCS)
	$(JAVAC) $(SRCS)

mec: $(TEXT_FILE)
	mecab < $(TEXT_FILE) >> $(OUT_TEXT)

test: $(PROGRAM) $(OUT_TEXT)
	java $(PRONAME)

graph: plot.gp $(DAT_ALL) $(DAT_NOUN) $(DAT_VERB) $(DAT_ADJECTIVE)
	gnuplot < plot.gp

.PHONY: clean
clean:
	$(RM) $(PROGRAM) $(DAT_ALL) $(DAT_NOUN) $(DAT_VERB) $(DAT_ADJECTIVE) $(OUT_TEXT) $(PDF_ALL)