/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.config;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.ConfigKeysFukaKeisan;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 賦課計算のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class FukaKeisanConfig {

    private final Map<ConfigKeysFukaKeisan, RString> configs;

    /**
     * コンストラクタです。
     */
    public FukaKeisanConfig() {
        IUrBusinessConfig businessConfig = UrBusinessConfigFactory.createInstance();
        configs = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysFukaKeisan target : ConfigKeysFukaKeisan.values()) {
            this.configs.put(target, businessConfig.get(target, nowDate));
        }
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param configs 賦課計算のコンフィグ情報を格納したMap
     */
    public FukaKeisanConfig(Map<ConfigKeysFukaKeisan, RString> configs) {
        this.configs = configs;
    }

    /**
     * 指定したキーに対応する値をコンフィグから取得して返します。
     *
     * @param key キー
     * @return 値
     */
    public RString get(ConfigKeysFukaKeisan key) {
        return configs.get(key);
    }

    /**
     * ランク管理情報_納期統一年度を返します。
     *
     * @return ランク管理情報_納期統一年度
     */
    public RString get納期統一年度() {
        return get(ConfigKeysFukaKeisan.ランク管理情報_納期統一年度);
    }
}
