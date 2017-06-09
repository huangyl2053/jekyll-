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

    /**
     * @return 四マスタの管理方法
     */
    public FourMastersManagementSystem get管理方法() {
        return FourMastersManagementSystem.toValue(get四マスタ管理方法());
    }

    /**
     * 四マスタの管理方法を表します。
     */
    public enum FourMastersManagementSystem {

        /**
         * 構成市町村ごとに管理します。
         */
        構成市町村("1"),
        /**
         * 広域保険者で管理します。
         */
        広域保険者("2"),
        /**
         * 本来ありえない不正な値です。
         */
        NULLVALUE("");

        private final RString theCode;

        private FourMastersManagementSystem(String code) {
            this.theCode = new RString(code);
        }

        /**
         * @return 四マスタを構成市町村ごとに管理する場合、{[@code true}.
         */
        public boolean is構成市町村ごと() {
            return this == 構成市町村;
        }

        private static FourMastersManagementSystem toValue(RString code) {
            for (FourMastersManagementSystem v : values()) {
                if (java.util.Objects.equals(v.theCode, code)) {
                    return v;
                }
            }
            return NULLVALUE;
        }

    }
}
