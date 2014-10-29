/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysHokenshaJoho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HokenshaKoseiKubun;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class HokenshaJohoConfig {

    private final Map<ConfigKeysHokenshaJoho, RString> configs;

    /**
     * コンストラクタです。
     */
    public HokenshaJohoConfig() {
        IUrBusinessConfig businessConfig = UrBusinessConfigFactory.createInstance();
        configs = new HashMap<>();
        for (ConfigKeysHokenshaJoho target : ConfigKeysHokenshaJoho.values()) {
            this.configs.put(target, businessConfig.get(target, RDate.getNowDate()));
        }
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param configs 被保険者情報のコンフィグ情報を格納したMap
     */
    public HokenshaJohoConfig(Map<ConfigKeysHokenshaJoho, RString> configs) {
        this.configs = configs;
    }

    /**
     * 指定したキーに対応する値をコンフィグから取得して返します。
     *
     * @param key キー
     * @return 値
     */
    public RString get(ConfigKeysHokenshaJoho key) {
        return configs.get(key);
    }

    /**
     * 保険者情報_保険者構成を返します。
     *
     * @return 保険者情報_保険者構成
     */
    public HokenshaKoseiKubun get保険者構成() {
        return HokenshaKoseiKubun.toValue(get(ConfigKeysHokenshaJoho.保険者情報_保険者構成));
    }
}
