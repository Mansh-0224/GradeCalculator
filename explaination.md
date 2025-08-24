## **1️⃣ Libraries / Packages Used**

```java
import java.util.Scanner;
```

* **`java.util.Scanner`**:
  This is a built-in Java class used to **read user input** from the console.

  * `nextInt()` → reads an integer.
  * `nextDouble()` → reads a double (decimal number).
  * `nextLine()` → reads a whole line (string).
* No other external libraries are used in this code.

---

## **2️⃣ Class Declaration**

```java
public class GradeCalculator {
```

* `public class GradeCalculator` defines the class.
* In Java, **all code must be inside a class**.
* `public` means it can be accessed from anywhere.

---

## **3️⃣ Function: `getLetterGrade`**

```java
public static String getLetterGrade(double percentage) {
    if (percentage >= 90) return "A+";
    else if (percentage >= 85) return "A";
    ...
    else return "F";
}
```

* **Purpose:** Convert a numeric percentage into a **letter grade**.
* **Input:** `percentage` (like 87.5)
* **Output:** Letter grade (like `"A"`)
* **Logic:** Uses **if-else statements** to map ranges of percentages to grades.

Example:

| Percentage | Grade |
| ---------- | ----- |
| 92         | A+    |
| 87         | A     |
| 78         | B     |
| 52         | E+    |
| 35         | F     |

---

## **4️⃣ Function: `getGPA`**

```java
public static double getGPA(double percentage) {
    if (percentage >= 90) return 4.0;
    else if (percentage >= 85) return 3.7;
    ...
    else return 0.0;
}
```

* **Purpose:** Convert a numeric percentage into a **GPA (Grade Point Average)** on a **4.0 scale**.
* **Input:** `percentage`
* **Output:** `double` (GPA value)
* **Logic:** Similar to `getLetterGrade`, but returns numbers instead of letters.

Example:

| Percentage | GPA |
| ---------- | --- |
| 92         | 4.0 |
| 87         | 3.7 |
| 78         | 3.0 |
| 52         | 1.3 |
| 35         | 0.0 |

---

## **5️⃣ Main Function**

```java
public static void main(String[] args) {
```

* **Purpose:** This is the **entry point** of any Java program.
* `String[] args` is used to pass **command-line arguments**, but here it’s not used.

---

### **6️⃣ Inside main()**

#### **6a. Scanner for input**

```java
try (Scanner sc = new Scanner(System.in)) {
```

* Creates a **Scanner object** to read input from the user.
* `try-with-resources` ensures **scanner is closed automatically** at the end.

---

#### **6b. Weight distribution**

```java
double midtermWeight = 0.30;
double assignmentWeight = 0.20;
double classPerfWeight = 0.10;
double finalExamWeight = 0.40;
```

* Defines **weight for each assessment component**.
* Example: Midterm is 30% of final grade, Final Exam is 40%.

---

#### **6c. Number of subjects**

```java
System.out.print("Enter number of subjects: ");
int n = sc.nextInt();
sc.nextLine(); // consume newline
```

* Reads **number of subjects** from the user.
* `sc.nextLine()` is used to **consume the leftover newline** after `nextInt()`.

---

#### **6d. Initialize totals**

```java
double totalPercentage = 0;
double totalGPA = 0;
```

* Keeps **sum of all percentages** and **sum of all GPAs** to calculate averages later.

---

#### **6e. Loop through each subject**

```java
for (int subj = 1; subj <= n; subj++) {
```

* Loops from 1 to `n` (number of subjects).
* For each subject, the program will **take marks input** and calculate grades.

---

#### **6f. Input marks for each component**

```java
System.out.print("Enter name of Subject " + subj + ": ");
String subjectName = sc.nextLine();

System.out.print("Enter Midterm Marks (obtained / total): ");
double midObt = sc.nextDouble();
double midTotal = sc.nextDouble();

...
sc.nextLine(); // consume newline for next subject
```

* Reads **subject name** and marks for:

  * Midterm
  * Assignment
  * Class Performance
  * Final Exam
* Both **obtained marks** and **total marks** are inputted (e.g., 80/100).
* `nextLine()` after `nextDouble()` consumes the leftover newline.

---

#### **6g. Calculate percentage for each component**

```java
double midPerc = (midObt / midTotal) * 100;
double assignPerc = (assignObt / assignTotal) * 100;
double cpPerc = (cpObt / cpTotal) * 100;
double finalPerc = (finalObt / finalTotal) * 100;
```

* Converts obtained marks into **percentage**.
* Example: `80/100 = 0.8 → 80%`

---

#### **6h. Calculate weighted total percentage**

```java
double percentage = (midPerc * midtermWeight) +
                    (assignPerc * assignmentWeight) +
                    (cpPerc * classPerfWeight) +
                    (finalPerc * finalExamWeight);
```

* **Weighted average formula**:

$$
\text{percentage} = (\text{midterm}% \times 0.3) + (\text{assignment}% \times 0.2) + ...
$$

---

#### **6i. Get grade and GPA**

```java
String grade = getLetterGrade(percentage);
double gpa = getGPA(percentage);
```

* Calls **helper functions** to convert percentage → letter grade & GPA.

---

#### **6j. Print subject result**

```java
System.out.println("\nResult for " + subjectName + ":");
System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
System.out.println("Letter Grade: " + grade);
System.out.println("GPA: " + gpa);
```

* Prints nicely formatted **results per subject**.
* `String.format("%.2f", percentage)` → **rounds to 2 decimal places**.

---

#### **6k. Add to totals**

```java
totalPercentage += percentage;
totalGPA += gpa;
```

* Keeps track of **overall percentage and GPA**.

---

### **7️⃣ Calculate overall results**

```java
double avgPercentage = totalPercentage / n;
double avgGPA = totalGPA / n;

System.out.println("\n===== Overall Result =====");
System.out.println("Average Percentage: " + String.format("%.2f", avgPercentage) + "%");
System.out.println("Average GPA: " + String.format("%.2f", avgGPA));
System.out.println("Overall Letter Grade: " + getLetterGrade(avgPercentage));
```

* Calculates **average percentage** and **average GPA** across all subjects.
* Prints **overall letter grade** based on average percentage.

---

## ✅ **Summary / Flow**

1. User inputs number of subjects.
2. Loop through each subject:

   * Input marks
   * Calculate weighted percentage
   * Convert to letter grade & GPA
   * Print subject result
3. Calculate overall average and print final results.

**Example Output:**

```
Enter number of subjects: 2

Enter name of Subject 1: Math
Enter Midterm Marks (obtained / total): 80 100
Enter Assignment Marks (obtained / total): 18 20
Enter Class Performance Marks (obtained / total): 9 10
Enter Final Exam Marks (obtained / total): 85 100

Result for Math:
Percentage: 82.70%
Letter Grade: B+
GPA: 3.3

Enter name of Subject 2: Science
...
===== Overall Result =====
Average Percentage: 79.50%
Average GPA: 3.1
Overall Letter Grade: B
```

---

## **8️⃣ Key Points**

* Uses **Scanner** for input.
* Uses **helper functions** to modularize code (`getLetterGrade`, `getGPA`).
* Uses **weighted average formula** to calculate percentages.
* Prints **subject-wise and overall results**.
* Fully **console-based**, no GUI.

---
