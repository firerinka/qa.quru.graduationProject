package pages.components;

import com.codeborne.selenide.SelenideElement;
import elements.Button;
import elements.Element;
import elements.Input;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class TaskEditor extends Element {

    Input title = new Input("taskTitle", $(".richtextinput .notranslate"));
    Input description = new Input("taskDescription", $(".task_editor__description_field"));
    Button submit = new Button("submitTaskButton", $("[data-testid=task-editor-submit-button]"));

    public TaskEditor(String name, SelenideElement selector) {
        super(name, selector);
    }

    @Step("Вводим название задачи '{value}'")
    public TaskEditor setTitle(String value) {
        title.setInputValue(value);
        return this;
    }

    @Step("Вводим описание задачи '{value}'")
    public TaskEditor setDescription(String value) {
        description.setInputValue(value);
        return this;
    }

    @Step("Нажимаем на кнопку {submit.name}")
    public TaskEditor submitTask() {
        submit.click();
        return this;
    }
}
