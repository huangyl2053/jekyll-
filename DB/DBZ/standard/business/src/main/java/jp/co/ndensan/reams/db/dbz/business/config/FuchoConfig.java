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
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ConfigKeysFucho;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.util.config.IBusinessConfig;

/**
 * 普通徴収のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class FuchoConfig {

    private final Map<ConfigKeysFucho, RString> configs;

    /**
     * コンストラクタです。
     */
    public FuchoConfig() {
        this.configs = createMap(BusinessConfigFactory.createInstance());
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    public FuchoConfig(IBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysFucho, RString> createMap(IBusinessConfig businessConfig) {
        Map<ConfigKeysFucho, RString> map = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysFucho target : ConfigKeysFucho.values()) {
            map.put(target, businessConfig.get(target, nowDate));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 指定したキーに対応する値をコンフィグから取得して返します。
     *
     * @param key キー
     * @return 値
     */
    public RString get(ConfigKeysFucho key) {
        return configs.get(key);
    }

    /**
     * 普徴期情報_月の期1を返します。
     *
     * @return 普徴期情報_月の期1
     */
    public RString get月の期1() {
        return get(ConfigKeysFucho.普徴期情報_月の期1);
    }

    /**
     * 普徴期情報_月の期2を返します。
     *
     * @return 普徴期情報_月の期2
     */
    public RString get月の期2() {
        return get(ConfigKeysFucho.普徴期情報_月の期2);
    }

    /**
     * 普徴期情報_月の期3を返します。
     *
     * @return 普徴期情報_月の期3
     */
    public RString get月の期3() {
        return get(ConfigKeysFucho.普徴期情報_月の期3);
    }

    /**
     * 普徴期情報_月の期4を返します。
     *
     * @return 普徴期情報_月の期4
     */
    public RString get月の期4() {
        return get(ConfigKeysFucho.普徴期情報_月の期4);
    }

    /**
     * 普徴期情報_月の期5を返します。
     *
     * @return 普徴期情報_月の期5
     */
    public RString get月の期5() {
        return get(ConfigKeysFucho.普徴期情報_月の期5);
    }

    /**
     * 普徴期情報_月の期6を返します。
     *
     * @return 普徴期情報_月の期6
     */
    public RString get月の期6() {
        return get(ConfigKeysFucho.普徴期情報_月の期6);
    }

    /**
     * 普徴期情報_月の期7を返します。
     *
     * @return 普徴期情報_月の期7
     */
    public RString get月の期7() {
        return get(ConfigKeysFucho.普徴期情報_月の期7);
    }

    /**
     * 普徴期情報_月の期8を返します。
     *
     * @return 普徴期情報_月の期8
     */
    public RString get月の期8() {
        return get(ConfigKeysFucho.普徴期情報_月の期8);
    }

    /**
     * 普徴期情報_月の期9を返します。
     *
     * @return 普徴期情報_月の期9
     */
    public RString get月の期9() {
        return get(ConfigKeysFucho.普徴期情報_月の期9);
    }

    /**
     * 普徴期情報_月の期10を返します。
     *
     * @return 普徴期情報_月の期10
     */
    public RString get月の期10() {
        return get(ConfigKeysFucho.普徴期情報_月の期10);
    }

    /**
     * 普徴期情報_月の期11を返します。
     *
     * @return 普徴期情報_月の期11
     */
    public RString get月の期11() {
        return get(ConfigKeysFucho.普徴期情報_月の期11);
    }

    /**
     * 普徴期情報_月の期12を返します。
     *
     * @return 普徴期情報_月の期12
     */
    public RString get月の期12() {
        return get(ConfigKeysFucho.普徴期情報_月の期12);
    }

    /**
     * 普徴期情報_月の期13を返します。
     *
     * @return 普徴期情報_月の期13
     */
    public RString get月の期13() {
        return get(ConfigKeysFucho.普徴期情報_月の期13);
    }

    /**
     * 普徴期情報_月の期14を返します。
     *
     * @return 普徴期情報_月の期14
     */
    public RString get月の期14() {
        return get(ConfigKeysFucho.普徴期情報_月の期14);
    }

    /**
     * 普徴期情報_月の期をリストで返します。
     *
     * @return 普徴期情報_月の期
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
        list.add(get月の期13());
        list.add(get月の期14());
        return list;
    }
}
