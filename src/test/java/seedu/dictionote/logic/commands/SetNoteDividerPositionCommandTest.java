package seedu.dictionote.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.dictionote.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.dictionote.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.dictionote.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.dictionote.logic.commands.SetNoteDividerPositionCommand.MESSAGE_SET_DIVIDER_SUCCESS;
import static seedu.dictionote.testutil.TypicalContacts.getTypicalContactsList;
import static seedu.dictionote.testutil.TypicalContent.getTypicalDictionary;
import static seedu.dictionote.testutil.TypicalDefinition.getTypicalDefinitionBook;
import static seedu.dictionote.testutil.TypicalNotes.getTypicalNoteBook;
import static seedu.dictionote.testutil.TypicalUiActions.VALID_UI_POSITION;

import org.junit.jupiter.api.Test;

import seedu.dictionote.logic.commands.enums.UiAction;
import seedu.dictionote.logic.commands.enums.UiActionOption;
import seedu.dictionote.model.Model;
import seedu.dictionote.model.ModelManager;
import seedu.dictionote.model.UserPrefs;


public class SetNoteDividerPositionCommandTest {
    private Model model = new ModelManager(getTypicalContactsList(), new UserPrefs(),
        getTypicalNoteBook(), getTypicalDictionary(), getTypicalDefinitionBook());
    private Model expectedModel = new ModelManager(getTypicalContactsList(), new UserPrefs(),
        getTypicalNoteBook(), getTypicalDictionary(), getTypicalDefinitionBook());

    @Test
    public void execute_setDividerPosition_success() {
        for (int i = 0; i < VALID_UI_POSITION.length; i++) {
            CommandResult expectedCommandResult = new CommandResult(
                MESSAGE_SET_DIVIDER_SUCCESS + VALID_UI_POSITION[i], UiAction.OPEN,
                UiActionOption.NOTE);
            expectedModel.getGuiSettings().setNoteSplitRatio(
                VALID_UI_POSITION[i] / SetDividerPositionCommand.NORMALIZE_RATIO);

            assertCommandSuccess(new SetNoteDividerPositionCommand(VALID_UI_POSITION[i]), model,
                expectedCommandResult, expectedModel);
            assertEquals(model.getGuiSettings().getNoteSplitRatio(),
                VALID_UI_POSITION[i] / SetDividerPositionCommand.NORMALIZE_RATIO);
        }
    }

    @Test
    public void execute_setDividerPosition_invalid() {
        int[] invalidPosition = {Integer.MIN_VALUE, -1, 0 , 10, 11, Integer.MAX_VALUE};

        for (int i = 0; i < invalidPosition.length; i++) {
            assertCommandFailure(new SetNoteDividerPositionCommand(invalidPosition[i]), model,
                String.format(MESSAGE_INVALID_COMMAND_FORMAT, SetNoteDividerPositionCommand.MESSAGE_USAGE));
        }
    }

    @Test
    public void equal() {
        SetNoteDividerPositionCommand command1 = new SetNoteDividerPositionCommand(1);
        SetNoteDividerPositionCommand command2 = new SetNoteDividerPositionCommand(1);
        SetNoteDividerPositionCommand command3 = new SetNoteDividerPositionCommand(2);

        // same object -> returns true
        assertTrue(command1.equals(command1));

        // same values -> returns true
        assertTrue(command1.equals(command2));

        // different values -> returns false
        assertFalse(command1.equals(command3));

        // different types -> returns false
        assertFalse(command1.equals(1));

        // null -> returns false
        assertFalse(command1.equals(null));
    }
}
