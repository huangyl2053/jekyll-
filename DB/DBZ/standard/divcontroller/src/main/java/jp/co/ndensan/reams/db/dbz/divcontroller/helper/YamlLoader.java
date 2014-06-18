/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.core._ControlDataHolder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;
import jp.co.ndensan.reams.uz.uza.ui.servlets._IServletControlData;
import org.yaml.snakeyaml.Yaml;

/*
 * Yamlファイルをロードします。
 *
 * @author N3327 三浦 凌
 */
public final class YamlLoader {

    /**
     * DBA用のYamlLoaderです。
     */
    @Deprecated
    public static final YamlLoader FOR_DBA;
    /**
     * DBB用のYamlLoaderです。
     */
    @Deprecated
    public static final YamlLoader FOR_DBB;
    /**
     * DBC用のYamlLoaderです。
     */
    @Deprecated
    public static final YamlLoader FOR_DBC;
    /**
     * DBD用のYamlLoaderです。
     */
    @Deprecated
    public static final YamlLoader FOR_DBD;
    /**
     * DBE用のYamlLoaderです。
     */
    @Deprecated
    public static final YamlLoader FOR_DBE;
    /**
     * DBU用のYamlLoaderです。
     */
    @Deprecated
    public static final YamlLoader FOR_DBU;
    /**
     * DBZ用のYamlLoaderです。
     */
    @Deprecated
    public static final YamlLoader FOR_DBZ;
    /**
     * DBA用のYamlLoaderです。
     */
    public static final YamlLoader DBA;
    /**
     * DBB用のYamlLoaderです。
     */
    public static final YamlLoader DBB;
    /**
     * DBC用のYamlLoaderです。
     */
    public static final YamlLoader DBC;
    /**
     * DBD用のYamlLoaderです。
     */
    public static final YamlLoader DBD;
    /**
     * DBE用のYamlLoaderです。
     */
    public static final YamlLoader DBE;
    /**
     * DBU用のYamlLoaderです。
     */
    public static final YamlLoader DBU;
    /**
     * DBZ用のYamlLoaderです。
     */
    public static final YamlLoader DBZ;

    static {
        FOR_DBA = new YamlLoader(rootPathFor(new RString("dba")));
        FOR_DBB = new YamlLoader(rootPathFor(new RString("dbb")));
        FOR_DBC = new YamlLoader(rootPathFor(new RString("dbc")));
        FOR_DBD = new YamlLoader(rootPathFor(new RString("dbd")));
        FOR_DBE = new YamlLoader(rootPathFor(new RString("dbe")));
        FOR_DBU = new YamlLoader(rootPathFor(new RString("dbu")));
        FOR_DBZ = new YamlLoader(rootPathFor(new RString("dbz")));
    }

    static {
        DBA = new YamlLoader(composeRootPath("dba"));
        DBB = new YamlLoader(composeRootPath("dbb"));
        DBC = new YamlLoader(composeRootPath("dbc"));
        DBD = new YamlLoader(composeRootPath("dbd"));
        DBE = new YamlLoader(composeRootPath("dbe"));
        DBU = new YamlLoader(composeRootPath("dbu"));
        DBZ = new YamlLoader(composeRootPath("dbz"));
    }

    private static RString rootPathFor(RString projectName) {
        return new RString("db/" + projectName + "/demodata/");
    }

    private static RString composeRootPath(String projectName) {
        return new RString("demodata/demodata/db/" + projectName + "/");
    }
    private final RString rootPath;

    private YamlLoader(RString rootPath) {
        this.rootPath = rootPath;
    }

    /**
     * YAMLファイルを読み込みます。<br />
     * デモ用のデータ読み込みに使用するクラスです。<br />
     * このメソッドで読み込むYAMLはハッシュのリスト形式で記述されている必要があります。<br />
     * ファイルははWEB-INF/demodata/以下に配置される必要があります。<br />
     *
     * @param fileName Yamlファイル名
     * @return Yamlをパースしたリスト
     */
    public List<HashMap> loadAsList(RString fileName) {
        return toList(load(fileName));
    }

    /**
     * YAMLファイルを読み込みます。<br />
     * デモ用のデータ読み込みに使用するクラスです。<br />
     * このメソッドで読み込むYAMLはハッシュ形式で記述されている必要があります。<br />
     * ハッシュの中身は任意の型が許されます。使う側で適宜型変換を行う必要があります。
     * ファイルはWEB-INF/demodata/以下に配置される必要があります。<br />
     *
     * @param fileName Yamlファイル名
     * @return Yamlをパースしたリスト
     */
    public Map loadAsMap(RString fileName) {
        return toHashMap(load(fileName));
    }

    private Object load(RString fileName) {
        InputStream input = null;
        String urlHeader = ((_IServletControlData) _ControlDataHolder.getControlData()).getUrlHeader();
        try {
            URL url = new URL(urlHeader.concat(rootPath.toString()).concat(fileName.toString()));
            input = url.openStream();
        } catch (FileNotFoundException ex) {
            throw new SystemException("yamlが見つかりません。:" + fileName.toString(), ex);
        } catch (MalformedURLException ex) {
            throw new SystemException("urlが不適切です。: " + ex.getLocalizedMessage(), ex);
        } catch (IOException ex) {
            throw new SystemException("yamlがloadできません。:" + fileName.toString(), ex);
        }
        Yaml yaml = new Yaml();
        return yaml.load(input);
    }

    private List toList(Object target) {
        return (List) target;
    }

    private HashMap toHashMap(Object target) {
        return (HashMap) target;
    }
}
