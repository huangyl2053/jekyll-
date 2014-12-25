/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.config;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.ConfigKeysTokucho;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class TokuchoConfig {

    private final Map<ConfigKeysTokucho, RString> configs;

    /**
     * コンストラクタです。
     */
    public TokuchoConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    public TokuchoConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysTokucho, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysTokucho, RString> map = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysTokucho target : ConfigKeysTokucho.values()) {
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
    public RString get(ConfigKeysTokucho key) {
        return configs.get(key);
    }

    /**
     * 特徴期情報_月の期1を返します。
     *
     * @return 特徴期情報_月の期1
     */
    public RString get月の期1() {
        return get(ConfigKeysTokucho.特徴期情報_月の期1);
    }

    /**
     * 特徴期情報_月の期2を返します。
     *
     * @return 特徴期情報_月の期2
     */
    public RString get月の期2() {
        return get(ConfigKeysTokucho.特徴期情報_月の期2);
    }

    /**
     * 特徴期情報_月の期3を返します。
     *
     * @return 特徴期情報_月の期3
     */
    public RString get月の期3() {
        return get(ConfigKeysTokucho.特徴期情報_月の期3);
    }

    /**
     * 特徴期情報_月の期4を返します。
     *
     * @return 特徴期情報_月の期4
     */
    public RString get月の期4() {
        return get(ConfigKeysTokucho.特徴期情報_月の期4);
    }

    /**
     * 特徴期情報_月の期5を返します。
     *
     * @return 特徴期情報_月の期5
     */
    public RString get月の期5() {
        return get(ConfigKeysTokucho.特徴期情報_月の期5);
    }

    /**
     * 特徴期情報_月の期6を返します。
     *
     * @return 特徴期情報_月の期6
     */
    public RString get月の期6() {
        return get(ConfigKeysTokucho.特徴期情報_月の期6);
    }

    /**
     * 特徴期情報_月の期7を返します。
     *
     * @return 特徴期情報_月の期7
     */
    public RString get月の期7() {
        return get(ConfigKeysTokucho.特徴期情報_月の期7);
    }

    /**
     * 特徴期情報_月の期8を返します。
     *
     * @return 特徴期情報_月の期8
     */
    public RString get月の期8() {
        return get(ConfigKeysTokucho.特徴期情報_月の期8);
    }

    /**
     * 特徴期情報_月の期9を返します。
     *
     * @return 特徴期情報_月の期9
     */
    public RString get月の期9() {
        return get(ConfigKeysTokucho.特徴期情報_月の期9);
    }

    /**
     * 特徴期情報_月の期10を返します。
     *
     * @return 特徴期情報_月の期10
     */
    public RString get月の期10() {
        return get(ConfigKeysTokucho.特徴期情報_月の期10);
    }

    /**
     * 特徴期情報_月の期11を返します。
     *
     * @return 特徴期情報_月の期11
     */
    public RString get月の期11() {
        return get(ConfigKeysTokucho.特徴期情報_月の期11);
    }

    /**
     * 特徴期情報_月の期12を返します。
     *
     * @return 特徴期情報_月の期12
     */
    public RString get月の期12() {
        return get(ConfigKeysTokucho.特徴期情報_月の期12);
    }

    /**
     * 特徴期情報_月の期をリストで返します。
     *
     * @return 特徴期情報_月の期
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
