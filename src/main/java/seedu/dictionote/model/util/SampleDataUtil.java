package seedu.dictionote.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.dictionote.model.ContactsList;
import seedu.dictionote.model.DefinitionBook;
import seedu.dictionote.model.Dictionary;
import seedu.dictionote.model.NoteBook;
import seedu.dictionote.model.ReadOnlyContactsList;
import seedu.dictionote.model.ReadOnlyDefinitionBook;
import seedu.dictionote.model.ReadOnlyDictionary;
import seedu.dictionote.model.ReadOnlyNoteBook;
import seedu.dictionote.model.contact.Address;
import seedu.dictionote.model.contact.Contact;
import seedu.dictionote.model.contact.Email;
import seedu.dictionote.model.contact.Name;
import seedu.dictionote.model.contact.Phone;
import seedu.dictionote.model.dictionary.Content;
import seedu.dictionote.model.dictionary.Definition;
import seedu.dictionote.model.note.Note;
import seedu.dictionote.model.tag.Tag;

/**
 * Contains utility methods for populating the contacts list with sample data.
 */
public class SampleDataUtil {
    public static Contact[] getSampleContacts() {
        return new Contact[] {
            new Contact(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Contact(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Contact(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours"))
        };
    }

    public static ReadOnlyContactsList getSampleContactsList() {
        ContactsList sampleAb = new ContactsList();
        for (Contact sampleContact : getSampleContacts()) {
            sampleAb.addContact(sampleContact);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    public static Note[] getSampleNotes() {
        return new Note[] {
            new Note("This is a sample note.", getTagSet()),
            new Note("This is a sample note with one tag.", getTagSet("Important")),
            new Note("This is a sample note with multiple tags.", getTagSet("Important", "Interesting"))
        };
    }

    public static ReadOnlyNoteBook getSampleNoteBook() {
        NoteBook sampleNb = new NoteBook();
        for (Note sampleNote : getSampleNotes()) {
            sampleNb.addNote(sampleNote);
        }
        return sampleNb;
    }

    public static Content[] getSampleContent() {
        return new Content[] {
            new Content("Week 1", "OOP programming.",
                    "Object-Oriented Programming (OOP) is a programming paradigm."),
            new Content("Week #", "Some Topic", "some content")
        };
    }

    public static ReadOnlyDictionary getSampleDictionary() {
        Dictionary sampleCt = new Dictionary();
        for (Content sampleContent : getSampleContent()) {
            sampleCt.addContent(sampleContent);
        }
        return sampleCt;
    }

    public static Definition[] getSampleDefinition() {
        return new Definition[] {
            new Definition("Object-Oriented Programming (OOP)", "a programming paradigm."),
            new Definition("term", "Some Definition")
        };
    }

    public static ReadOnlyDefinitionBook getSampleDefinitionBook() {
        DefinitionBook sampleDb = new DefinitionBook();
        for (Definition sampleDefinition : getSampleDefinition()) {
            sampleDb.addDefinition(sampleDefinition);
        }
        return sampleDb;
    }
}
