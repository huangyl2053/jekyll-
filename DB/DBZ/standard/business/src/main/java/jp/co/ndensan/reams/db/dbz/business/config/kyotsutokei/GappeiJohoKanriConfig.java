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
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.kyotsutokei.ConfigKeysGappeiJohoKanri;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 合併情報管理について定義している業務コンフィグを取得します。
 *
 * @author n8178 城間篤人
 * @deprecated {@link jp.co.ndensan.reams.db.dbx.business.config.gappeijohokanri.GappeiJohoKanri}を使用して下さい。
 */
@Deprecated
public class GappeiJohoKanriConfig {

    private final Map<ConfigKeysGappeiJohoKanri, RString> configs;

    /**
     * コンストラクタです。
     */
    public GappeiJohoKanriConfig() {
        this.configs = createMap();
    }

    private Map<ConfigKeysGappeiJohoKanri, RString> createMap() {
        Map<ConfigKeysGappeiJohoKanri, RString> map = new EnumMap<>(ConfigKeysGappeiJohoKanri.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysGappeiJohoKanri target : ConfigKeysGappeiJohoKanri.values()) {
            RString value = new RString(BusinessConfig.get(target, nowDate, SubGyomuCode.DBU介護統計報告).toString());
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
