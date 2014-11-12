/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysGappeiJoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.GappeiJohoKubun;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合併情報のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class GappeiJohoConfig {

    private final Map<ConfigKeysGappeiJoho, RString> configs;

    /**
     * コンストラクタです。
     */
    public GappeiJohoConfig() {
        IUrBusinessConfig businessConfig = UrBusinessConfigFactory.createInstance();
        configs = new HashMap<>();
        for (ConfigKeysGappeiJoho target : ConfigKeysGappeiJoho.values()) {
            this.configs.put(target, businessConfig.get(target, RDate.getNowDate()));
        }
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param configs 合併情報のコンフィグ情報を格納したMap
     */
    public GappeiJohoConfig(Map<ConfigKeysGappeiJoho, RString> configs) {
        this.configs = configs;
    }

    /**
     * 指定したキーに対応する値をコンフィグから取得して返します。
     *
     * @param key キー
     * @return 値
     */
    public RString get(ConfigKeysGappeiJoho key) {
        return configs.get(key);
    }

    /**
     * 合併情報管理_合併情報区分を返します。
     *
     * @return 合併情報管理_合併情報区分
     */
    public GappeiJohoKubun get合併情報区分() {
        return GappeiJohoKubun.toValue(get(ConfigKeysGappeiJoho.合併情報管理_合併情報区分));
    }
}
