/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.kyotsutokei;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.config.ConfigValueBoolean;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.kyotsutokei.ConfigKeysGappeiJohoKanri;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n8178 城間篤人
 */
public class GappeiJohoKanriConfig {

    private final Map<ConfigKeysGappeiJohoKanri, RString> configs;

    /**
     * コンストラクタです。
     */
    public GappeiJohoKanriConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    GappeiJohoKanriConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysGappeiJohoKanri, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysGappeiJohoKanri, RString> map = new EnumMap<>(ConfigKeysGappeiJohoKanri.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysGappeiJohoKanri target : ConfigKeysGappeiJohoKanri.values()) {
            RString value = new RString(businessConfig.get(target, nowDate, SubGyomuCode.DBU介護統計報告).toString());
            map.put(target, value);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 合併ありならtrue、合併なしならfalseを返します。
     *
     * @return 合併ありならtrue
     */
    public boolean is合併あり() {
        return ConfigValueBoolean.parseBoolean(configs.get(ConfigKeysGappeiJohoKanri.合併情報管理_合併情報区分));
    }
}
