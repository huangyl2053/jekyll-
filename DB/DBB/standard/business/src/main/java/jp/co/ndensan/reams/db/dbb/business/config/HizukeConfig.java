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
     * 日付関連_月別ﾃｰﾌﾞﾙ1を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ1
     */
    public RString get月別ﾃｰﾌﾞﾙ1() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ1);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ2を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ2
     */
    public RString get月別ﾃｰﾌﾞﾙ2() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ2);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ3を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ3
     */
    public RString get月別ﾃｰﾌﾞﾙ3() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ3);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ4を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ4
     */
    public RString get月別ﾃｰﾌﾞﾙ4() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ4);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ5を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ5
     */
    public RString get月別ﾃｰﾌﾞﾙ5() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ5);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ6を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ6
     */
    public RString get月別ﾃｰﾌﾞﾙ6() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ6);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ7を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ7
     */
    public RString get月別ﾃｰﾌﾞﾙ7() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ7);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ8を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ8
     */
    public RString get月別ﾃｰﾌﾞﾙ8() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ8);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ9を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ9
     */
    public RString get月別ﾃｰﾌﾞﾙ9() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ9);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ10を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ10
     */
    public RString get月別ﾃｰﾌﾞﾙ10() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ10);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ11を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ11
     */
    public RString get月別ﾃｰﾌﾞﾙ11() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ11);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ12を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ12
     */
    public RString get月別ﾃｰﾌﾞﾙ12() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ12);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ13を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ13
     */
    public RString get月別ﾃｰﾌﾞﾙ13() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ13);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙ14を返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ14
     */
    public RString get月別ﾃｰﾌﾞﾙ14() {
        return get(ConfigKeysHizuke.日付関連_月別ﾃｰﾌﾞﾙ14);
    }

    /**
     * 日付関連_月別ﾃｰﾌﾞﾙを配列で返します。
     *
     * @return 日付関連_月別ﾃｰﾌﾞﾙ
     */
    public RString[] get月別ﾃｰﾌﾞﾙ() {
        RString[] 月別ﾃｰﾌﾞﾙ = {
            get月別ﾃｰﾌﾞﾙ1(),
            get月別ﾃｰﾌﾞﾙ2(),
            get月別ﾃｰﾌﾞﾙ3(),
            get月別ﾃｰﾌﾞﾙ4(),
            get月別ﾃｰﾌﾞﾙ5(),
            get月別ﾃｰﾌﾞﾙ6(),
            get月別ﾃｰﾌﾞﾙ7(),
            get月別ﾃｰﾌﾞﾙ8(),
            get月別ﾃｰﾌﾞﾙ9(),
            get月別ﾃｰﾌﾞﾙ10(),
            get月別ﾃｰﾌﾞﾙ11(),
            get月別ﾃｰﾌﾞﾙ12(),
            get月別ﾃｰﾌﾞﾙ13(),
            get月別ﾃｰﾌﾞﾙ14()
        };
        return 月別ﾃｰﾌﾞﾙ;
    }
}
