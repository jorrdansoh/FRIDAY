package friday.testutil;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import friday.model.student.Consultation;
import friday.model.student.MasteryCheck;
import friday.model.student.Name;
import friday.model.student.Remark;
import friday.model.student.Student;
import friday.model.student.TelegramHandle;
import friday.model.tag.Tag;
import friday.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_TELEGRAMHANDLE = "amy123";
    public static final LocalDate DEFAULT_CONSULTATION = LocalDate.of(2022, 9, 1);
    public static final LocalDate DEFAULT_MASTERYCHECK = LocalDate.of(2022, 11, 22);
    public static final String DEFAULT_REMARK = "She loves CS1101S";

    private Name name;
    private TelegramHandle telegramHandle;
    private Consultation consultation;
    private MasteryCheck masteryCheck;
    private Remark remark;
    private Set<Tag> tags;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        telegramHandle = new TelegramHandle(DEFAULT_TELEGRAMHANDLE);
        consultation = new Consultation(DEFAULT_CONSULTATION);
        masteryCheck = new MasteryCheck(DEFAULT_MASTERYCHECK);
        remark = new Remark(DEFAULT_REMARK);
        tags = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Student studentToCopy) {
        name = studentToCopy.getName();
        telegramHandle = studentToCopy.getTelegramHandle();
        consultation = studentToCopy.getConsultation();
        masteryCheck = studentToCopy.getMasteryCheck();
        remark = studentToCopy.getRemark();
        tags = new HashSet<>(studentToCopy.getTags());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code tags} into a {@code Set<Tag>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withTags(String ... tags) {
        this.tags = SampleDataUtil.getTagSet(tags);
        return this;
    }

    /**
     * Sets the {@code MasteryCheck} of the {@code Person} that we are building.
     */
    public PersonBuilder withMasteryCheck(LocalDate desiredDate) {
        this.masteryCheck = new MasteryCheck(desiredDate);
        return this;
    }

    /**
     * Sets the {@code TelegramHandle} of the {@code Person} that we are building.
     */
    public PersonBuilder withTelegramHandle(String handle) {
        this.telegramHandle = new TelegramHandle(handle);
        return this;
    }

    /**
     * Sets the {@code Consultation} of the {@code Person} that we are building.
     */
    public PersonBuilder withConsultation(LocalDate desiredDate) {
        this.consultation = new Consultation(desiredDate);
        return this;
    }

    /**
     * Sets the {@code Remark} of the {@code Person} that we are building.
     */
    public PersonBuilder withRemark(String remark) {
        this.remark = new Remark(remark);
        return this;
    }

    public Student build() {
        return new Student(name, telegramHandle, consultation, masteryCheck, remark, tags);
    }

}