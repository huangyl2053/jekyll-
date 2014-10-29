/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysNenreiTotatsuKijun;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得における、年齢到達の基準年齢を扱う業務コンフィグ取得クラスです。
 *
 * @author n8178 城間篤人
 */
public class NenreiTotatsuKijunConfig {

    private Map<ConfigKeysNenreiTotatsuKijun, RString> configs;

    /**
     * コンストラクタです。
     */
    public NenreiTotatsuKijunConfig() {
        IUrBusinessConfig loader = UrBusinessConfigFactory.createInstance();
        Map<ConfigKeysNenreiTotatsuKijun, RString> configs = new EnumMap<>(ConfigKeysNenreiTotatsuKijun.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysNenreiTotatsuKijun target : ConfigKeysNenreiTotatsuKijun.values()) {
            this.configs.put(target, loader.get(target, nowDate));
        }
        this.configs = Collections.unmodifiableMap(configs);
    }

    //コンフィグ情報を外から注入する場合のコンストラクタ（バッチ、テスト時に使用する）
    public NenreiTotatsuKijunConfig(Map<ConfigKeysNenreiTotatsuKijun, RString> configs) {
        this.configs = configs;
    }

    public Integer get(ConfigKeysNenreiTotatsuKijun key) {
        return new Integer(configs.get(key).toString());
    }
}
