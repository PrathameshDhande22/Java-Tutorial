package memento;

// Creating the simple text editor with undo and redo that supports the "Memento Pattern".

import java.util.ArrayDeque;
import java.util.Deque;

// Memento State
class MementoState {
    private String text;
    private int cursorPosition;

    public MementoState(String text, int cursorPosition) {
        this.text = text;
        this.cursorPosition = cursorPosition;
    }

    public int getCursorPosition() {
        return cursorPosition;
    }

    public String getText() {
        return text;
    }
}

// These is the Originator where the client is depend on which will save the MementoState
class Editor {
    private StringBuilder content;
    private int cursorPosition;

    public Editor() {
        this.content = new StringBuilder();
        this.cursorPosition = 0;
    }

    public void write(String text) {
        this.content.append(text);
        this.cursorPosition = content.length();
    }

    public void print() {
        System.out.println(String.format("Content = %s , Cursor = %d", this.content.toString(), this.cursorPosition));
    }

    // Save the snapshot
    public MementoState save() {
        return new MementoState(
                this.content.toString(), cursorPosition
        );
    }

    // restore the snapshot
    public void restore(MementoState state) {
        this.content = new StringBuilder(state.getText());
        this.cursorPosition = state.getCursorPosition();
    }

}

// Caretaker of the history
class EditorHistory {
    private final Deque<MementoState> undoStack = new ArrayDeque<>();
    private final Deque<MementoState> redoStack = new ArrayDeque<>();

    public void save(Editor editor) {
        undoStack.push(editor.save());
        redoStack.clear();
    }

    public void undo(Editor editor) {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }
        MementoState lastundoState = undoStack.pop();
        redoStack.push(editor.save());
        editor.restore(lastundoState);
    }

    public void redo(Editor editor) {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }
        MementoState lastredoState = redoStack.pop();
        undoStack.push(editor.save());
        editor.restore(lastredoState);
    }
}


public class MementoPattern {
    // Client code
    public static void main(String[] args) {
        Editor editor = new Editor();
        EditorHistory history = new EditorHistory();

        editor.write("Hello");
        history.save(editor);

        editor.print();

        editor.write(" Java");
        history.save(editor);

        editor.print();

        editor.write(" SpringBoot");
        history.save(editor);

        editor.print();

        // Undo the Springboot
        history.undo(editor);
        editor.print();

        history.undo(editor);
        editor.print();

        history.redo(editor);
        editor.print();

        history.undo(editor);
        editor.print();
    }
}
