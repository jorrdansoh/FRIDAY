package friday.model.grades;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a Student's list of grades for their assessments and examinations.
 */
public class GradesList {

    // Names of assessments and exams
    public static final String[] EXAMS = {"RA1", "Mid-Term", "RA2", "Practical", "Finals"};

    public final Map<String, Grade> gradesMap;

    /**
     * Constructs an {@code GradesList} with all grades set to 0 by default.
     */
    public GradesList() {
        this.gradesMap = new HashMap<>();
        initialiseGrades(gradesMap);
    }

    /**
     * Creates and adds the Grades for the associated exams in the gradesMap
     *
     * @param gradesMap
     */
    public void initialiseGrades(Map<String, Grade> gradesMap) {
        for (String exam : EXAMS) {
            gradesMap.putIfAbsent(exam, new Grade(exam, "0"));
        }
    }

    /**
     * Replaces the Grade in the gradesList with the given new Grade
     *
     * @param gradesList
     * @param newGrade
     */
    public static void editGrade(GradesList gradesList, Grade newGrade) {
        String key = newGrade.examName;
        gradesList.gradesMap.put(key, newGrade);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(gradesMap.get("RA1"))
                .append(gradesMap.get("RA2"))
                .append(gradesMap.get("Mid-Term"))
                .append(gradesMap.get("Practical"))
                .append(gradesMap.get("Finals"));
        return builder.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof GradesList // instanceof handles nulls
                && gradesMap.equals(((GradesList) other).gradesMap)); // state check
    }

    @Override
    public int hashCode() {
        return gradesMap.hashCode();
    }
}
