package interviewQ;


class OddEvenThreads implements Runnable {
    private int max;

    public OddEvenThreads(int max, Printer print, boolean isEvenNumber) {
        this.max = max;
        this.print = print;
        this.isEvenNumber = isEvenNumber;
    }

    private Printer print;
    private boolean isEvenNumber;

    // standard constructors

    @Override
    public void run() {
        int number = isEvenNumber ? 2 : 1;
        while (number <= max) {
            if (isEvenNumber) {
                print.printOdd(number);
            } else {
                print.printEven(number);
            }
            number += 2;
        }
    }
}

