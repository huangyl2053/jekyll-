/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysShikakushashoKigen;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysShikakushashoKigen.資格者証期限_有効期限初期表示;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysShikakushashoKigen.資格者証期限_有効期限加算値;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 資格者証発行における有効期限の業務コンフィグを取得するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShikakushashoKigenConfig {

    private final Map<ConfigKeysShikakushashoKigen, Integer> configs;

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
    ShikakushashoKigenConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysShikakushashoKigen, Integer> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysShikakushashoKigen, Integer> map = new EnumMap<>(ConfigKeysShikakushashoKigen.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysShikakushashoKigen target : ConfigKeysShikakushashoKigen.values()) {
            Integer value = Integer.valueOf(businessConfig.get(target, nowDate).toString());
            map.put(target, value);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 資格者証期限_有効期限加算値を取得します。
     *
     * @return 資格者証期限_有効期限加算値
     */
    public Decimal get資格者証期限_有効期限加算値() {
        return new Decimal(configs.get(資格者証期限_有効期限加算値).toString());
    }

    /**
     * 資格者証期限_有効期限初期表示を取得します。
     *
     * @return 資格者証期限_有効期限初期表示
     */
    public RString get資格者証期限_有効期限初期表示() {
        return new RString(configs.get(資格者証期限_有効期限初期表示).toString());
    }

}
