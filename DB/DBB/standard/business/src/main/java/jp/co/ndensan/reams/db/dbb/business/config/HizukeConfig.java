/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.config;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.ConfigKeysHizuke;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 日付のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class HizukeConfig {

    private final Map<ConfigKeysHizuke, RString> configs;

    /**
     * コンストラクタです。
     */
    public HizukeConfig() {
        IUrBusinessConfig businessConfig = UrBusinessConfigFactory.createInstance();
        configs = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHizuke target : ConfigKeysHizuke.values()) {
            this.configs.put(target, businessConfig.get(target, nowDate));
        }
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param configs 日付のコンフィグ情報を格納したMap
     */
    public HizukeConfig(Map<ConfigKeysHizuke, RString> configs) {
        this.configs = configs;
    }

    /**
     * 指定したキーに対応する値をコンフィグから取得して返します。
     *
     * @param key キー
     * @return 値
     */
    public RString get(ConfigKeysHizuke key) {
        return configs.get(key);
    }

    /**
     * 日付関連_月別テーブル1を返します。
     *
     * @return 日付関連_月別テーブル1
     */
    public RString get月別テーブル1() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル1);
    }

    /**
     * 日付関連_月別テーブル2を返します。
     *
     * @return 日付関連_月別テーブル2
     */
    public RString get月別テーブル2() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル2);
    }

    /**
     * 日付関連_月別テーブル3を返します。
     *
     * @return 日付関連_月別テーブル3
     */
    public RString get月別テーブル3() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル3);
    }

    /**
     * 日付関連_月別テーブル4を返します。
     *
     * @return 日付関連_月別テーブル4
     */
    public RString get月別テーブル4() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル4);
    }

    /**
     * 日付関連_月別テーブル5を返します。
     *
     * @return 日付関連_月別テーブル5
     */
    public RString get月別テーブル5() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル5);
    }

    /**
     * 日付関連_月別テーブル6を返します。
     *
     * @return 日付関連_月別テーブル6
     */
    public RString get月別テーブル6() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル6);
    }

    /**
     * 日付関連_月別テーブル7を返します。
     *
     * @return 日付関連_月別テーブル7
     */
    public RString get月別テーブル7() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル7);
    }

    /**
     * 日付関連_月別テーブル8を返します。
     *
     * @return 日付関連_月別テーブル8
     */
    public RString get月別テーブル8() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル8);
    }

    /**
     * 日付関連_月別テーブル9を返します。
     *
     * @return 日付関連_月別テーブル9
     */
    public RString get月別テーブル9() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル9);
    }

    /**
     * 日付関連_月別テーブル10を返します。
     *
     * @return 日付関連_月別テーブル10
     */
    public RString get月別テーブル10() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル10);
    }

    /**
     * 日付関連_月別テーブル11を返します。
     *
     * @return 日付関連_月別テーブル11
     */
    public RString get月別テーブル11() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル11);
    }

    /**
     * 日付関連_月別テーブル12を返します。
     *
     * @return 日付関連_月別テーブル12
     */
    public RString get月別テーブル12() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル12);
    }

    /**
     * 日付関連_月別テーブル13を返します。
     *
     * @return 日付関連_月別テーブル13
     */
    public RString get月別テーブル13() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル13);
    }

    /**
     * 日付関連_月別テーブル14を返します。
     *
     * @return 日付関連_月別テーブル14
     */
    public RString get月別テーブル14() {
        return get(ConfigKeysHizuke.日付関連_月別テーブル14);
    }

    /**
     * 日付関連_月別テーブルを配列で返します。
     *
     * @return 日付関連_月別テーブル
     */
    public RString[] get月別テーブル() {
        RString[] 月別テーブル = {
            get月別テーブル1(),
            get月別テーブル2(),
            get月別テーブル3(),
            get月別テーブル4(),
            get月別テーブル5(),
            get月別テーブル6(),
            get月別テーブル7(),
            get月別テーブル8(),
            get月別テーブル9(),
            get月別テーブル10(),
            get月別テーブル11(),
            get月別テーブル12(),
            get月別テーブル13(),
            get月別テーブル14()
        };
        return 月別テーブル;
    }
}
