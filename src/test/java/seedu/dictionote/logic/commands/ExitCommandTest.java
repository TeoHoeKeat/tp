package seedu.dictionote.logic.commands;

import static seedu.dictionote.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.dictionote.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.dictionote.logic.commands.ExitCommand.MESSAGE_EXIT_ACKNOWLEDGEMENT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.dictionote.commons.core.Messages;
import seedu.dictionote.logic.commands.enums.UiAction;
import seedu.dictionote.model.Model;
import seedu.dictionote.model.ModelManager;
import seedu.dictionote.testutil.TypicalNoteContentConfig;

public class ExitCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @BeforeEach
    public void init() {
        model.setNoteContentConfig(TypicalNoteContentConfig.getTypicalNoteContentConfigWithNote());
        expectedModel.setNoteContentConfig(TypicalNoteContentConfig.getTypicalNoteContentConfigWithNote());
    }

    @Test
    public void execute_onEditMode_fail() {
        Model editModeModel = new ModelManager();
        editModeModel.setNoteContentConfig(TypicalNoteContentConfig.getTypicalNoteContentConfigEditMode());
        assertCommandFailure(new ExitCommand(), editModeModel,
            Messages.MESSAGE_COMMAND_DISABLE_ON_EDIT_MODE);
    }

    @Test
    public void execute_exit_success() {
        CommandResult expectedCommandResult = new CommandResult(MESSAGE_EXIT_ACKNOWLEDGEMENT, UiAction.EXIT);
        assertCommandSuccess(new ExitCommand(), model, expectedCommandResult, expectedModel);
    }
}
