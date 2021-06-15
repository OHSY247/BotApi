package github.botapi.util.js;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author straycamel
 * @date 2021/5/31
 */
public class JsHandler {
    public static void handler() {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            engine.eval(new FileReader("/Users/straycamel/alibaba-inc/idea-workspace/BotApi/util/src/main/java/github/botapi/util/js/script.js"));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Invocable invocable = (Invocable) engine;

        Object result = null;
        try {
            result = invocable.invokeFunction("fun1", "Peter Parker");
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        System.out.println(result.getClass());

// Hi there from Javascript, Peter Parker
// greetings from javascript
// class java.lang.String
    }
}
