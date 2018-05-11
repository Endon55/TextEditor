package com.cosenza.window;

import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiConsumer;

public class CustomObject
{
        // example fields: use your own in implementation
    private final boolean useRedText;
    private final boolean includeCaretHand ;


    private final int rotation;
    private final String backgroundStyleClass;

    public CustomObject(boolean redText, boolean caretHand, int rotation, String backgroundStyleClass)
    {
        useRedText = redText;
        includeCaretHand = caretHand;
        this.rotation = rotation;
        this.backgroundStyleClass = backgroundStyleClass;
    }
    public int getRotation()
    {
        return rotation;
    }

    public boolean getRedText()
    {
        return useRedText;
    }
    public boolean getCaretHand()
    {
        return includeCaretHand;
    }
    public String getBackgroundStyleClass()
    {
        return backgroundStyleClass;
    }

    BiConsumer<Text, CustomObject> applyStyle = (Text text, CustomObject style) ->
    {
        // apply a style class first
        text.getStyleClass().add(style.getBackgroundStyleClass());
        // selectively apply css that overrides style class
        String cssStyle = "";
        if (style.getRedText())
        {
            cssStyle = "-fx-font-color: red;";
        }
        cssStyle = cssStyle + "-fx-rotation: " + style.getRotation() + ";";
        text.setStyle(cssStyle);
    };



    private int calculateListSize()
        {
                int size = useRedText ? 1 : 0;
                size += includeCaretHand ? 1 : 0;
                return size;
        }

        Collection<String> toList()
        {
                List<String> list = new ArrayList(calculateListSize());
                if (getRedText())
                {
                        list.add("red-text");
                }
                if (getCaretHand())
                {
                        list.add("text-with-caret");
                }
                return list;
        }
}

