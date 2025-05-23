package seedu.address.testutil;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.NextLesson;
import seedu.address.model.person.PayStatus;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.subject.Subject;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class PersonBuilder {

    public static final String DEFAULT_NAME = "Amy Bee";
    public static final String DEFAULT_PHONE = "85355255";
    public static final String DEFAULT_EMAIL = "amy@gmail.com";
    public static final String DEFAULT_ADDRESS = "123, Jurong West Ave 6, #08-111";
    public static final String DEFAULT_NEXT_LESSON = "15/06/2025 1900-2100";
    public static final String DEFAULT_PAYSTATUS = "";

    private Name name;
    private Phone phone;
    private Email email;
    private Address address;
    private NextLesson nextLesson;
    private PayStatus payStatus;
    private Set<Subject> subjects;

    /**
     * Creates a {@code PersonBuilder} with the default details.
     */
    public PersonBuilder() {
        name = new Name(DEFAULT_NAME);
        phone = new Phone(DEFAULT_PHONE);
        email = new Email(DEFAULT_EMAIL);
        address = new Address(DEFAULT_ADDRESS);
        nextLesson = new NextLesson(DEFAULT_NEXT_LESSON);
        payStatus = new PayStatus(DEFAULT_PAYSTATUS);
        subjects = new HashSet<>();
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public PersonBuilder(Person personToCopy) {
        name = personToCopy.getName();
        phone = personToCopy.getPhone();
        email = personToCopy.getEmail();
        address = personToCopy.getAddress();
        nextLesson = personToCopy.getNextLesson();
        payStatus = personToCopy.getPayStatus();
        subjects = new HashSet<>(personToCopy.getSubjects());
    }

    /**
     * Sets the {@code Name} of the {@code Person} that we are building.
     */
    public PersonBuilder withName(String name) {
        this.name = new Name(name);
        return this;
    }

    /**
     * Parses the {@code subjects} into a {@code Set<Subject>} and set it to the {@code Person} that we are building.
     */
    public PersonBuilder withSubjects(String ... subjects) {
        this.subjects = SampleDataUtil.getSubjectSet(subjects);
        return this;
    }

    /**
     * Sets the {@code Address} of the {@code Person} that we are building.
     */
    public PersonBuilder withAddress(String address) {
        this.address = new Address(address);
        return this;
    }

    /**
     * Sets the {@code Phone} of the {@code Person} that we are building.
     */
    public PersonBuilder withPhone(String phone) {
        this.phone = new Phone(phone);
        return this;
    }

    /**
     * Sets the {@code Email} of the {@code Person} that we are building.
     */
    public PersonBuilder withEmail(String email) {
        this.email = new Email(email);
        return this;
    }

    /**
     * Sets the {@code NextLesson} of the {@code Person} that we are building
     * using String.
     */
    public PersonBuilder withNextLesson(String nextLesson) {
        if (nextLesson == null || nextLesson.isEmpty()) {
            this.nextLesson = new NextLesson();
        } else {
            this.nextLesson = new NextLesson(nextLesson);
        }
        return this;
    }

    /**
     * Sets the {@code NextLesson} of the {@code Person} that we are building
     * using LocalDate and LocalTime.
     */
    public PersonBuilder withNextLesson(
            LocalDate date, LocalTime startTime, LocalTime endTime) {
        if (nextLesson == null || nextLesson.isEmpty()) {
            this.nextLesson = new NextLesson();
        } else {
            this.nextLesson = new NextLesson(date, startTime, endTime);
        }
        return this;
    }

    /**
     * Sets the {@code PayStatus} of the {@code Person} that we are building.
     */
    public PersonBuilder withPayStatus(String payStatus) {
        this.payStatus = new PayStatus(payStatus);
        return this;
    }

    public Person build() {
        return new Person(name, phone, email, address, nextLesson, payStatus, subjects);
    }

}
