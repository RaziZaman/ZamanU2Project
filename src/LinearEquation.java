public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100) / 100.0;
    }
    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }
    public double slope() {
        if (x2 - x1 == 0) {
            return 0;
        }
        double xDif = x2 - x1;
        double yDif = y2 - y1;
        return roundedToHundredth((yDif) / (xDif));
    }
    public double yIntercept() {
        double a1 = x1;
        double b2 = y1;
        if (a1 > 0) {
            while (a1 != 0) {
                a1 --;
                b2 -= slope();
            }
        } else if (a1 < 0) {
            while (a1 != 0) {
                a1 ++;
                b2 += slope();
            }
        }
        return roundedToHundredth(b2);
    }
    public String equation() {
        double xDif = roundedToHundredth(x2 - x1);
        double yDif = roundedToHundredth(y2 - y1);
        if (slope() == 0) {
            return "y = " + yIntercept();
        } else if (slope() == 1 || slope() == -1) {
            if (yIntercept() == 0 && slope() == 1) {
                return "y = x";
            } else if (slope() == -1 && yIntercept() == 0) {
                return "y = -x";
            } else if (slope() == 1) {
                if (yIntercept() < 0) {
                    return "y = x - " + (yIntercept() * -1);
                }
                return "y = x + " + yIntercept();
            } else if (slope() == -1) {
                if (yIntercept() < 0) {
                    return "y = -x - " + (yIntercept() * -1);
                }
                return "y = -x + " + yIntercept();
            }
            return "y = " + "x + " + yIntercept();
        } else if (slope() % 1 == 0) {
            if (yIntercept() == 0) {
                return "y = " + slope() + "x";
            }
            return "y = " + slope() + "x + " + yIntercept();
        } else {
            if ((xDif < 0 && yDif < 0) || (xDif < 0)) {
                xDif *= -1;
                yDif *= -1;
            }
            if (yIntercept() == 0) {
                return "y = " + (yDif) + "/" + (xDif) + "x";
            } else if (yIntercept() < 0) {
                return "y = " + (yDif) + "/" + (xDif) + "x - " + (yIntercept() * -1);
            }
            return "y = " + (yDif) + "/" + (xDif) + "x + " + yIntercept();
        }
    }
    public String coordinateForX(double x) {
        double y = roundedToHundredth(slope() * x + yIntercept());
        x = roundedToHundredth(x);
        int yNew = 0;
        int xNew = 0;
        if (y % 1 == 0) {
            yNew = (int) (y);
        }
        if (x % 1 == 0) {
            xNew = (int) x;
        }
        y -= y % 1;
        x -= x % 1;
        if (xNew == (int) x && yNew == (int) y) {
            return "(" + xNew + ", " + yNew + ")";
        } else if (xNew == (int) x && yNew != (int) y) {
            return "(" + xNew + ", " + y + ")";
        } else if (xNew != (int) x && yNew == (int) y) {
            return "(" + x + ", " + yNew + ")";
        }
        return "(" + x + ", " + y + ")";
    }
    public String lineInfo() {
        if (x2 - x1 == 0) {
            if (x2 == 0) {
                return "The two points are: " + coordinateForX(x1) + " and " + coordinateForX(x2) + " \nThe equation of this line between these points is: x = " + x2 + "\nThe slope of this line is undefined\nThere are infinite y-intercepts.\nThe distance between these points is " + distance();
            }
            return "The two points are: " + coordinateForX(x1) + " and " + coordinateForX(x2) + " \nThe equation of this line between these points is: x = " + x2 + "\nThe slope of this line is undefined\nThere is no y-intercept.\nThe distance between these points is " + distance();
        }
        return "The two points are: " + coordinateForX(x1) + " and " + coordinateForX(x2) + " \nThe equation of this line between these points is: " + equation() + "\nThe slope of this line is: " + slope() + "\nThe y-intercept of this line is: " + yIntercept() + "\nThe distance between these points is " + distance();
    }
}
