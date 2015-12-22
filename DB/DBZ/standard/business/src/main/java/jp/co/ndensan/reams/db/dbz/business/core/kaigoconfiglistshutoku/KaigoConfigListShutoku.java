/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kaigoconfiglistshutoku;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 介護Config取得クラスです。
 *
 * @author wangchao
 */
public class KaigoConfigListShutoku {

    /**
     * 介護Configリスト取得処理。
     *
     * @param コンフィグ コンフィグ
     * @return Map (コンフィグ名,コンフィグ値)
     */
    public Map<Enum, Object> getKaigoConfigList(Class コンフィグ) {
        Map<Enum, Object> KaigoConfigMap = new HashMap();
        for (Enum コンフィグキー : ((Class<Enum>) コンフィグ).getEnumConstants()) {
            RString コンフィグ名称 = BusinessConfig.get(コンフィグキー);

            KaigoConfigMap.put(コンフィグキー, コンフィグ名称);
        }
        return KaigoConfigMap;
    }

    /**
     * 介護Config取得処理（サブ業務指定）。
     *
     * @param コンフィグ コンフィグ
     * @param サブ業務コード サブ業務コード
     * @return Map (コンフィグ名,コンフィグ値)
     */
    public Map<Enum, Object> getKaigoConfigSbuList(Class コンフィグ, SubGyomuCode サブ業務コード) {

        Map<Enum, Object> KaigoConfigMap = new HashMap();
        for (Enum コンフィグキー : ((Class<Enum>) コンフィグ).getEnumConstants()) {
            RString コンフィグ名称 = BusinessConfig.get(コンフィグキー, サブ業務コード);
            KaigoConfigMap.put(コンフィグキー, コンフィグ名称);
        }
        return KaigoConfigMap;
    }
}
