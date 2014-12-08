/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysHizuke;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
        for (ConfigKeysHizuke target : ConfigKeysHizuke.values()) {
            this.configs.put(target, businessConfig.get(target, RDate.getNowDate()));
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
     * 日付関連_調定年度を返します。
     *
     * @return 日付関連_調定年度
     */
    public FlexibleYear get調定年度() {
        RString data = get(ConfigKeysHizuke.日付関連_調定年度);
        return (data != null) ? new FlexibleYear(data) : null;
    }

    /**
     * 日付関連_所得年度を返します。
     *
     * @return 日付関連_所得年度
     */
    public FlexibleYear get所得年度() {
        RString data = get(ConfigKeysHizuke.日付関連_所得年度);
        return (data != null) ? new FlexibleYear(data) : null;
    }

    /**
     * 日付関連_当初年度を返します。
     *
     * @return 日付関連_当初年度
     */
    public FlexibleYear get当初年度() {
        RString data = get(ConfigKeysHizuke.日付関連_当初年度);
        return (data != null) ? new FlexibleYear(data) : null;
    }

    /**
     * 日付関連_遡及年度を返します。
     *
     * @return 日付関連_遡及年度
     */
    public FlexibleYear get遡及年度() {
        RString data = get(ConfigKeysHizuke.日付関連_遡及年度);
        return (data != null) ? new FlexibleYear(data) : null;
    }
}
