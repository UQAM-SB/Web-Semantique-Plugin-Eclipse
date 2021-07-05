package ca.uqam.tool.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.IValueVariable;
import org.eclipse.core.variables.VariablesPlugin;
import org.osgi.framework.Bundle;


@SuppressWarnings("restriction")
public class SystemVar {
    public static final String WIN32 = Platform.OS_WIN32;
    public static final String LINUX = Platform.OS_LINUX;
    public static final String MACOSX = Platform.OS_MACOSX;


//    private static  ILog logger=Activator.getDefault().getLog();

    private static IStringVariableManager manager;

    public static void init() throws IOException {
        System.setProperty("sun.jnu.encoding", "UTF-8");
        System.setProperty("file.encoding", "UTF-8");
        manager = VariablesPlugin.getDefault().getStringVariableManager();
    }

    public static void setValueVariable(String key, String value) {
        if (manager == null) manager = VariablesPlugin.getDefault().getStringVariableManager();
        IValueVariable[] vars = new IValueVariable[1];
        vars[0] = manager.getValueVariable(key);
        if (vars[0]!= null)   manager.removeVariables(vars);
        IValueVariable variable = manager.newValueVariable(key, "", false, value);
        try {
            manager.addVariables(new IValueVariable[] { variable });
        } catch (CoreException e1) {
        }

    }

    public static void addSystemVariable(String key, String value)  throws ReflectiveOperationException {
            Map<String, String> env = System.getenv();
            Field field = env.getClass().getDeclaredField("m");
            field.setAccessible(true);
            ((Map<String, String>) field.get(env)).put(key, value);
        System.setProperty(key, value);
    }
    public static void dumpVariables() {
        IValueVariable[] vars = manager.getValueVariables();
        for (IValueVariable valueVariable : vars) {
            System.out.println(valueVariable.getName() + " " + valueVariable.getValue());
        }
    }

    public static void dumpSystemProp() {
        Properties p = System.getProperties();
        Enumeration keys = p.keys();
  //      logger.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "----------------------------------------------\n DUMP VAR"));
  //      if (p==null)  logger.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "----------------------------------------------\n System Properties is empty!"));

        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = (String) p.get(key);
            System.out.println(key + ": " + value);
   //         logger.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, key + ": " + value));
        }
    //    logger.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "END DUMP VAR----------------------------------------------"));
    //    logger.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "START ENVIRONNEMENT VAR----------------------------------------------"));
        Map<String, String> envs = System.getenv();
        Set<String> allkeys = envs.keySet();
        for (String aKey : allkeys) {
            System.out.println(aKey + ":" + envs.get(aKey));
        }
      //  logger.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, "END DUMP ENVIRONNEMENT VAR----------------------------------------------"));

    }

    public static String getOS() {
        return Platform.getOS();
    }
    public static String getJavaHome() {
        return System.getProperty("java.home");
    }
    public static String removeFileSuffixToURI(String url){
        return StringUtils.removeStart(StringUtils.removeEnd(url,"/"),"file:");
    }
    public static String getEclipseHomeVar() {
        String homeVar = removeFileSuffixToURI(System.getProperty("eclipse.home.location"))+"/";
 //       logger.log(new Status(IStatus.INFO, Activator.PLUGIN_ID, " eclipse Home Var = "+homeVar));
        return homeVar;

    }

    public static void setVariablesForBundle(String pluginId, String homeVar, String homeSysVar)  {
        Bundle bundle = Platform.getBundle(pluginId);
        URL pluginURL;
        try {
            System.err.println("setVariablesForBundle pluginId "  + pluginId + " : "+ bundle.getLocation());
            pluginURL = Platform.resolve(bundle.getEntry(File.separator+"tools"+File.separator));
            URL fileURL = FileLocator.toFileURL(pluginURL);
            String home_value = fileURL.toURI().getRawPath();
            SystemVar.setValueVariable(homeVar, home_value);
            SystemVar.addSystemVariable(homeSysVar, home_value);
        } catch (NullPointerException | IOException | URISyntaxException | ReflectiveOperationException e) {
        	System.err.println( "setVariablesForBundle: pluginId"+ "(" +pluginId+ ") homeVar(" + homeVar + ") homeSysVar(" +homeSysVar+")");
            e.printStackTrace(System.err);
        }
    }


}
