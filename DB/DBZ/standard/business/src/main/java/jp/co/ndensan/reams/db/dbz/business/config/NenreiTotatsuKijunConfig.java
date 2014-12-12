/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysNenreiTotatsuKijunJoho;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 資格取得における、年齢到達の基準年齢を扱う業務コンフィグ取得クラスです。
 *
 * @author n8178 城間篤人
 */
public class NenreiTotatsuKijunConfig {

    private final Map<ConfigKeysNenreiTotatsuKijunJoho, Integer> configs;

    /**
     * コンストラクタです。
     */
    public NenreiTotatsuKijunConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    NenreiTotatsuKijunConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysNenreiTotatsuKijunJoho, Integer> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysNenreiTotatsuKijunJoho, Integer> map = new EnumMap<>(ConfigKeysNenreiTotatsuKijunJoho.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysNenreiTotatsuKijunJoho target : ConfigKeysNenreiTotatsuKijunJoho.values()) {
            Integer value = Integer.valueOf(businessConfig.get(target, nowDate).toString());
            map.put(target, value);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 年齢到達の基準を示す業務コンフィグキーを受け取り、対応した値を返却します。
     *
     * @param key 年齢到達基準を示す業務コンフィグキー
     * @return コンフィグキーに対応した値
     */
    public int get(ConfigKeysNenreiTotatsuKijunJoho key) {
        return configs.get(key);
    }

}
