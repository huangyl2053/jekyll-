/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.config;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.ConfigKeysKanendo;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過年度のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class KanendoConfig {

    private final Map<ConfigKeysKanendo, RString> configs;

    /**
     * コンストラクタです。
     */
    public KanendoConfig() {
        IUrBusinessConfig businessConfig = UrBusinessConfigFactory.createInstance();
        configs = new HashMap<>();
        for (ConfigKeysKanendo target : ConfigKeysKanendo.values()) {
            this.configs.put(target, businessConfig.get(target, RDate.getNowDate()));
        }
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param configs 過年度のコンフィグ情報を格納したMap
     */
    public KanendoConfig(Map<ConfigKeysKanendo, RString> configs) {
        this.configs = configs;
    }

    /**
     * 指定したキーに対応する値をコンフィグから取得して返します。
     *
     * @param key キー
     * @return 値
     */
    public RString get(ConfigKeysKanendo key) {
        return configs.get(key);
    }

    /**
     * 過年度期情報_月の期1を返します。
     *
     * @return 過年度期情報_月の期1
     */
    public RString get月の期1() {
        return get(ConfigKeysKanendo.過年度期情報_月の期1);
    }

    /**
     * 過年度期情報_月の期2を返します。
     *
     * @return 過年度期情報_月の期2
     */
    public RString get月の期2() {
        return get(ConfigKeysKanendo.過年度期情報_月の期2);
    }

    /**
     * 過年度期情報_月の期3を返します。
     *
     * @return 過年度期情報_月の期3
     */
    public RString get月の期3() {
        return get(ConfigKeysKanendo.過年度期情報_月の期3);
    }

    /**
     * 過年度期情報_月の期4を返します。
     *
     * @return 過年度期情報_月の期4
     */
    public RString get月の期4() {
        return get(ConfigKeysKanendo.過年度期情報_月の期4);
    }

    /**
     * 過年度期情報_月の期5を返します。
     *
     * @return 過年度期情報_月の期5
     */
    public RString get月の期5() {
        return get(ConfigKeysKanendo.過年度期情報_月の期5);
    }

    /**
     * 過年度期情報_月の期6を返します。
     *
     * @return 過年度期情報_月の期6
     */
    public RString get月の期6() {
        return get(ConfigKeysKanendo.過年度期情報_月の期6);
    }

    /**
     * 過年度期情報_月の期7を返します。
     *
     * @return 過年度期情報_月の期7
     */
    public RString get月の期7() {
        return get(ConfigKeysKanendo.過年度期情報_月の期7);
    }

    /**
     * 過年度期情報_月の期8を返します。
     *
     * @return 過年度期情報_月の期8
     */
    public RString get月の期8() {
        return get(ConfigKeysKanendo.過年度期情報_月の期8);
    }

    /**
     * 過年度期情報_月の期9を返します。
     *
     * @return 過年度期情報_月の期9
     */
    public RString get月の期9() {
        return get(ConfigKeysKanendo.過年度期情報_月の期9);
    }

    /**
     * 過年度期情報_月の期10を返します。
     *
     * @return 過年度期情報_月の期10
     */
    public RString get月の期10() {
        return get(ConfigKeysKanendo.過年度期情報_月の期10);
    }

    /**
     * 過年度期情報_月の期11を返します。
     *
     * @return 過年度期情報_月の期11
     */
    public RString get月の期11() {
        return get(ConfigKeysKanendo.過年度期情報_月の期11);
    }

    /**
     * 過年度期情報_月の期12を返します。
     *
     * @return 過年度期情報_月の期12
     */
    public RString get月の期12() {
        return get(ConfigKeysKanendo.過年度期情報_月の期12);
    }

    /**
     * 過年度期情報_月の期を配列で返します。
     *
     * @return 過年度期情報_月の期
     */
    public RString[] get月の期() {
        RString[] 月の期 = {
            get月の期1(),
            get月の期2(),
            get月の期3(),
            get月の期4(),
            get月の期5(),
            get月の期6(),
            get月の期7(),
            get月の期8(),
            get月の期9(),
            get月の期10(),
            get月の期11(),
            get月の期12()
        };
        return 月の期;
    }
}
