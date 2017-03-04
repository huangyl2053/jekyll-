/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 介護認定の四マスタ関連のコンフィグ取得クラスです。
 */
public class FourMasterConfig {

    private final Map<ConfigKeysFourMaster, RString> configs;

    /**
     * コンストラクタです。
     */
    public FourMasterConfig() {
        this.configs = createMap();
    }

    private Map<ConfigKeysFourMaster, RString> createMap() {
        Map<ConfigKeysFourMaster, RString> map = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysFourMaster target : ConfigKeysFourMaster.values()) {
            map.put(target, BusinessConfig.get(target, nowDate, SubGyomuCode.DBE認定支援));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 四マスタ管理方法を返します。
     *
     * @return 四マスタ管理方法　1：構成市町村、2：広域保険者
     */
    public RString get四マスタ管理方法() {
        return configs.get(ConfigKeysFourMaster.四マスタ管理方法);
    }
}
