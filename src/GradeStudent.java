import java.util.Scanner;
public class GradeStudent {
    public static void main(String[] args) {
        //gọi hàm chào mừng
        begin();
        System.out.println();
        // gọi hàm tính điểm giữa kì
        double[] aMid = midTerm();
        System.out.println();
        // gọi hàm tính điểm cuối kì
        double[] aFinal = finalTerm((int) aMid[0]);
        System.out.println();
        //gọi hàm tính điểm homework
        double hwScore = homework((int) aMid[0], (int) aFinal[0]);
        System.out.println();
        //gọi hàm báo cáo
        report(aMid[1], aFinal[1], hwScore);
    }

    //Hàm hiển thị thông điệp chào mừng
    public static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
    }

    // Hàm nhập và tính toán điểm thi giữa kì
    public static double[] midTerm() {
        Scanner scan = new Scanner(System.in);
        int mw;
        int scoreEarned;
        int yon;
        int shift =0;
        int sumEarnAndShift;
        double wScore;
        System.out.println("Midterm:");
        // Nếu trọng số bé hơn 0 hoặc lớn hơn 100, nhập lại.
        do {
            System.out.print("Weight (0-100) ? ");
            mw = scan.nextInt();
        } while ( mw <0 || mw >100);
        // Nếu điểm giữa kì của sinh viên lớn hơn điểm tối đa, nhập lại.
        do {
            System.out.print("Score earned? ");
            scoreEarned = scan.nextInt();
        } while (scoreEarned > 100);
        // Nếu không chọn yes hoặc no, nhập lại.
        do {
            System.out.print("Were scores shifted (1=yes, 2=no) ? ");
            yon = scan.nextInt();
        } while(yon != 1 && yon !=2);
          // Nếu có được tăng điểm, nhập vào số điểm được tăng.
        if (yon ==1) {
            System.out.print("Shift amount? ");
            shift = scan.nextInt();
        }
        // tính tổng điểm giữa kì = điểm thi + điểm được tăng.
        sumEarnAndShift = scoreEarned + shift;
        // Tổng điểm không được vượt quá điểm tối đa là 100.
        if (sumEarnAndShift > 100) {
            sumEarnAndShift = 100;
        }
        System.out.println("Total points = " + sumEarnAndShift +" / 100");
        // Tính điểm giữa kì theo trọng số
        wScore = (double) sumEarnAndShift * mw / 100;
        wScore = (double) Math.round(wScore *10) /10;
        System.out.println("Shift amount = " + wScore + " / " + mw);
        // trả về trọng số và điểm theo trọng số.
        return new double[] {mw, wScore};
    }

// Hàm nhập và tính toán điểm thi cuối kì
    public static double[] finalTerm(int mw) {
        Scanner scan = new Scanner(System.in);
        int fw;
        int scoreEarned;
        int yon;
        int shift =0;
        int sumEarnAndShift;
        double wScore;
        System.out.println("Finalterm:");
        // Nếu tổng trọng số giữa kì và cuối kì lớn hơn 100, nhập lại.
        do {
            System.out.print("Weight (0-100) ? ");
            fw = scan.nextInt();
        } while ( mw + fw  > 100);
        //Nếu điểm cuối kì của sinh viên lớn hơn điểm tối đa, nhập lại.
        do {
            System.out.print("Score earned? ");
            scoreEarned = scan.nextInt();
        } while (scoreEarned > 100);
        // Nếu không chọn yes hoặc no, nhập lại.
        do {
            System.out.print("Were scores shifted (1=yes, 2=no) ? ");
            yon = scan.nextInt();
        } while(yon != 1 && yon !=2);
        // Nếu được tăng điểm, nhập vào số điểm được tăng.
        if (yon ==1) {
            System.out.print("Shift amount? ");
            shift = scan.nextInt();
        }
        // Tổng điểm bằng điểm thi + điểm được tăng.
        sumEarnAndShift = scoreEarned + shift;
        // Nếu Tổng điểm lớn hơn điểm tối đa, tổng điểm = điểm tối đa.
        if (sumEarnAndShift > 100) {
            sumEarnAndShift = 100;
        }
        System.out.println("Total points = " + sumEarnAndShift +" / 100");
        // Tính điểm theo trọng số.
        wScore = (double) sumEarnAndShift * fw / 100;
        wScore = (double) Math.round(wScore *10) /10;
        System.out.println("Shift amount = " + wScore + " / " + fw);
        // trả về trọng số và điểm tính theo trọng số.
        return new double[] {fw, wScore};
    }

// Hàm nhập và tính toán điểm bài tập về nhà
    public static double homework(int mw, int fw) {
        Scanner scan = new Scanner(System.in);
        int hw;
        int numOfAsm;
        int asmEarned;
        int maxAsm;
        int sumAsmEarned = 0;
        int sumMaxAsm = 0;
        int sections;
        int sectionPoints;
        int totalEarned;
        int totalMax;
        double wScore;
        System.out.println("Homework:");
        // Nếu tổng trọng số của các phần không phải 100, nhập lại.
        do {
            System.out.print("Weight (0-100) ? ");
            hw = scan.nextInt();
        } while (mw + fw + hw  != 100);
        System.out.print("Number of assignments? ");
        numOfAsm = scan.nextInt();
        // Nhập vào điểm asm của sinh viên và điểm asm tối đa từng bài
        //Nếu điểm của sinh viên lớn hơn điểm tối đa, nhập lại.
        for (int i=1;i<=numOfAsm;i++) {
            // Nếu điểm asm của sinh viên lớn hơn điểm asm tối đa, nhập lại.
           do {
               System.out.print("Assignments " + i + " score and max? ");
               asmEarned = scan.nextInt();
               maxAsm = scan.nextInt();
           } while (asmEarned > maxAsm);
           // tính tổng các điểm asm của sinh viên.
            sumAsmEarned += asmEarned;
            // tính tổng các điểm tối đa của asm.
            sumMaxAsm += maxAsm;
        }
        // Tổng điểm tối đa của các asm không được vượt quá 150.
        if (sumMaxAsm > 150) {
            sumMaxAsm = 150;
        }
        //tổng điểm asm của sinh viên không được vượt quá tổng điểm tối đa của asm.
        if (sumAsmEarned > sumMaxAsm) {
            sumAsmEarned = sumMaxAsm;
        }

        System.out.print("How many sections did you attend? ");
        sections = scan.nextInt();
        sectionPoints = sections * 5;
        // điểm chuyên cần không được vượt quá 30.
        if (sectionPoints > 30) {
            sectionPoints = 30;
        }
        //tổng điểm homework = tổng điểm asm + điểm chuyên cần.
        totalEarned = sumAsmEarned + sectionPoints;
        totalMax = sumMaxAsm + 30;
        System.out.println("Section points = " + sectionPoints + " / 30");
        System.out.println("Total points = " + totalEarned + " / " + totalMax);
        // tính điểm homework theo trọng số
        wScore = (double) totalEarned * hw /totalMax;
        wScore = (double) Math.round(wScore * 10) /10;
        System.out.println("Weighted score = " + wScore + " / " + hw);

        return wScore;
    }

    // Hàm tính toán hiển thị GPA, thông báo nhận xét tương ứng
    public static void report(double mScore, double fScore, double hwScore) {
        double grade;
        double minGPA;
        grade = mScore + fScore + hwScore;
        System.out.println("Overall percentage = " + grade);
        if (grade>=85) {
            minGPA = 3.0;
        } else if(grade >= 75) {
            minGPA = 2.0;
        } else if (grade >= 65) {
            minGPA = 1.0;
        } else {
            minGPA = 0.0;
        }

        System.out.println("Your grade will be at least: " + minGPA);
        System.out.println("<< Your custom grade message here >>");
    }
}
