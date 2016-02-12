/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysKaigoToiawasesaki;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 問合せ先について定義している業務コンフィグを取得します。
 */
public class KaigoToiawasesakiConfig {

    private final Map<ConfigKeysKaigoToiawasesaki, RString> configs;

    /**
     * コンストラクタです。
     */
    public KaigoToiawasesakiConfig() {
        this.configs = createMap();
    }

    private Map<ConfigKeysKaigoToiawasesaki, RString> createMap() {
        Map<ConfigKeysKaigoToiawasesaki, RString> map = new EnumMap<>(ConfigKeysKaigoToiawasesaki.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysKaigoToiawasesaki target : ConfigKeysKaigoToiawasesaki.values()) {
            RString value = new RString(BusinessConfig.get(target, nowDate, SubGyomuCode.DBU介護統計報告).toString());
            map.put(target, value);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 問合せ先_管理単位を表す値を返します。
     *
     * @return 問合せ先_管理単位
     */
    public RString get問合せ先_管理単位() {
        return configs.get(ConfigKeysKaigoToiawasesaki.問合せ先_管理単位);
    }

    /**
     * EUC共通_文字コードを表す値を返します。
     *
     * @return EUC共通_文字コード
     */
    public RString getEUC共通_文字コード() {
        return configs.get(ConfigKeysKaigoToiawasesaki.EUC共通_文字コード);
    }

}
