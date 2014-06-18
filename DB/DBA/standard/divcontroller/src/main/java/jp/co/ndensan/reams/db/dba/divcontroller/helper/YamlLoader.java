/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.helper;

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

/**
 * テストデータを生成します。後日yamlに置き換えを予定しています。
 *
 * @author n8178 城間篤人
 */
public final class YamlLoader {

    private static final RString ROOT_PATH = new RString("db/");

    /**
     * インスタンス化防止のためのプライベートコンストラクタです。
     */
    private YamlLoader() {
    }

    /**
     * 引数に渡したURLからYamlファイルをロードして、その内容をList型で返します。
     *
     * @param fileName ファイルの位置情報
     * @return List化したYamlファイル
     */
    public static List<HashMap> loadAsList(RString fileName) {
        return toList(load(fileName));
    }

    /**
     * 引数に渡したURLからYamlファイルをロードして、その内容をMap型で返します。
     *
     * @param fileName ファイルの位置情報
     * @return Map化したYamlファイル
     */
    public static Map loadAsMap(RString fileName) {
        return toHashMap(load(fileName));
    }

    private static Object load(RString fileName) {
        InputStream input = null;
        RString urlHeader = new RString(((_IServletControlData) _ControlDataHolder.getControlData()).getUrlHeader());
        try {
            URL url = new URL(urlHeader.toString().concat(ROOT_PATH.toString()).concat(fileName.toString()));
            input = url.openStream();
        } catch (FileNotFoundException e) {
            throw new SystemException("fileが見つかりません :" + fileName.toString(), e);
        } catch (MalformedURLException e) {
            throw new SystemException("urlが見つかりません :" + e.getLocalizedMessage(), e);
        } catch (IOException e) {
            throw new SystemException("yamlがloadできません :" + fileName.toString(), e);
        }

        Yaml yaml = new Yaml();
        return yaml.load(input);
    }

    private static List toList(Object target) {
        return (List) target;
    }

    private static HashMap toHashMap(Object target) {
        return (HashMap) target;
    }
}
