/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShikakushashoKigen;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShikakushashoKigen.資格者証期限_有効期限初期表示;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShikakushashoKigen.資格者証期限_有効期限加算値;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.ConfigValuesShikakushashoKigen;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格者証発行における有効期限の業務コンフィグを取得するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShikakushashoKigenConfig {

    private final Map<ConfigKeysShikakushashoKigen, RString> configs;

    /**
     * コンストラクタです。
     */
    public ShikakushashoKigenConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    public ShikakushashoKigenConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysShikakushashoKigen, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysShikakushashoKigen, RString> map = new EnumMap<>(ConfigKeysShikakushashoKigen.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysShikakushashoKigen target : ConfigKeysShikakushashoKigen.values()) {
            map.put(target, businessConfig.get(target, nowDate, SubGyomuCode.DBD介護受給));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 資格者証期限_有効期限加算値を取得します。
     *
     * @return 資格者証期限_有効期限加算値
     */
    public int get資格者証期限_有効期限加算値() {
        return Integer.parseInt(configs.get(資格者証期限_有効期限加算値).toString());
    }

    /**
     * 資格者証期限_有効期限初期表示を取得します。
     *
     * @return 資格者証期限_有効期限初期表示
     */
    public ConfigValuesShikakushashoKigen get資格者証期限_有効期限初期表示() {
        return ConfigValuesShikakushashoKigen.toValue(configs.get(資格者証期限_有効期限初期表示));
    }
}
