import java.util.*;
import java.util.regex.Pattern;

public class SimpleBot {

    final String[] COMMON_PHRASES = {
            "Нет ничего ценнее слов, сказанных к месту и ко времени.",
            "Порой молчание может сказать больше, нежели уйма слов.",
            "Перед тем как писать/говорить всегда лучше подумать.",
            "Вежливая и грамотная речь всегда говорит о величии души.",
            "Приятно когда текст без орфографических ошибок.",
            "Многословие есть признак неупорядоченного умаю.",
            "Слова могут ранить, но могут и исцелять.",
            "Записывая слова, мы удваиваем их силу.",
            "Кто ясно мыслит, тот ясно излагает.",
            "Боюсь, Вы что-то не договариваете."};

    final String[] ELUSIVE_ANSWERS = {
            "Вопрос не простой, прошу тайм-аут на раздумья.",
            "Не уверен, что располагаю такой информацией.",
            "Может лучше поговорим о чем-то другом?",
            "Простите, но это очень личный вопрос.",
            "Не уверен, что Вам понравится ответ.",
            "Поверьте, я сам хотел бы это знать.",
            "Вы действителбно хотите это знать?",
            "Уверен, Вы уже догадались сами.",
            "Зачем Вам такая информация?",
            "Давайте сохраним интригу?"};

    final Map<String, String> PATTERNS_FOR_BOT = new HashMap<>() {{
        //прветствие
        put("хай", "hello");
        put("привет", "hello");
        put("здорово", "hello");
        put("здравствуй", "hello");

        //кто ты?
        put("кто\\s.*ты", "who");
        put("ты\\s.*кто", "who");

        //имя?
        put("как\\s.*зовут", "name");
        put("как\\s.*имя", "name");
        put("есть\\s.*имя", "name");
        put("какое\\s.*имя", "name");

        // как дела?
        put("как\\s.*дела", "howareyou");
        put("как\\s.*жизнь", "howareyou");

        // что делаешь?
        put("зачем\\s.*тут", "whatareyoudoing");
        put("зачем\\s.*здесь", "whatareyoudoing");
        put("что\\s.*делаешь", "whatareyoudoing");
        put("чем\\s.*занимаешься", "whatareyoudoing");

        // что нравится?
        put("что\\s.*нравится", "whatdoyoulike");
        put("что\\s.*любишь", "whatdoyoulike");

        //чувства
        put("кажется", "iamfeelling");
        put("чувствую", "iamfeelling");
        put("испытываю", "iamfeelling");

        // да(согласие)
        put("^да", "yes");
        put("согласен", "yes");

        //сколько время?
        put("который\\s.*час", "whattime");
        put("сколько\\s.*время", "whattime");

        //пока
        put("прощай", "bye");
        put("увидимся", "bye");
        put("до\\s.*свидания", "bye");
    }};

    final Map<String, String> ANSWERS_BY_PATTERNS = new HashMap<>() {{
        put("hello", "Здравствуйте, рад Вас видеть.");
        put("who", "Я обычный чат.");
        put("name", "Зовите меня Ботик.");
        put("howareyou", "Спасибо, что интересуетесь. Уменя все хорошо.");
        put("whatareyoudoing", "Я пробую общаться с людьми.");
        put("whatdoyoulike", "Мне нравится думать, что я не просто программа.");
        put("iamfeelling", "Как давно это началось? Расскажите об этом подробнее.");
        put("yes", "Согласие есть продукт при полном непротивлении сторон.");
        put("bye", "До свидания! Надеюсь, еще увидимся.");
    }};
    Pattern pattern;
    Random random;
    Date date;

    SimpleBot() {
        random = new Random();
        date = new Date();
    }

    String sayInReturn(String msg, boolean ai) {
        String say = (msg.trim().endsWith("?")) ? ELUSIVE_ANSWERS[random.nextInt(ELUSIVE_ANSWERS.length)] :
                COMMON_PHRASES[random.nextInt(COMMON_PHRASES.length)];
        if (ai) {
            String message = String.join(" ", msg.toLowerCase().split("[ (,!.)?]+"));
            for (Map.Entry<String, String> o : PATTERNS_FOR_BOT.entrySet()) {
                pattern = Pattern.compile(o.getKey());
                if (pattern.matcher(message).find())
                    if (o.getValue().equals("whattime")) return date.toString();
                    else return ANSWERS_BY_PATTERNS.get(o.getValue());
            }
        }
        return say;
    }
}
