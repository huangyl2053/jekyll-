/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigKeysKanendo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

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
        this.configs = createMap();
    }

    private Map<ConfigKeysKanendo, RString> createMap() {
        Map<ConfigKeysKanendo, RString> map = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysKanendo target : ConfigKeysKanendo.values()) {
            map.put(target, BusinessConfig.get(target, nowDate));
        }
        return Collections.unmodifiableMap(map);
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
     * 過年度期情報_月の期をリストで返します。
     *
     * @return 過年度期情報_月の期
     */
    public List<RString> get月の期() {
        List<RString> list = new ArrayList<>();
        list.add(get月の期1());
        list.add(get月の期2());
        list.add(get月の期3());
        list.add(get月の期4());
        list.add(get月の期5());
        list.add(get月の期6());
        list.add(get月の期7());
        list.add(get月の期8());
        list.add(get月の期9());
        list.add(get月の期10());
        list.add(get月の期11());
        list.add(get月の期12());
        return list;
    }
}
