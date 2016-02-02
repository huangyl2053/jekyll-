/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kaigoconfiglistshutoku;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 介護Config取得のビジネスクラスです。
 *
 */
public class KaigoConfigListShutoku {

    /**
     * 介護Configリスト取得処理。
     *
     * @param enumList Enum コンフィグのリスト
     * @return Map (コンフィグ名,コンフィグ値)
     */
    public Map<Enum, Object> getKaigoConfigList(List<Enum> enumList) {
        Map<Enum, Object> kaigoConfigMap = new HashMap();
        for (Enum コンフィグキー : enumList) {
            RString コンフィグ名称 = BusinessConfig.get(コンフィグキー);
            kaigoConfigMap.put(コンフィグキー, コンフィグ名称);
        }
        return kaigoConfigMap;
    }

    /**
     * 介護Config取得処理（サブ業務指定）。
     *
     * @param enumList Enum コンフィグのリスト
     * @param サブ業務コード サブ業務コード
     * @return Map (コンフィグ名,コンフィグ値)
     */
    public Map<Enum, Object> getKaigoConfigSbuList(List<Enum> enumList, SubGyomuCode サブ業務コード) {
        Map<Enum, Object> kaigoConfigMap = new HashMap();
        for (Enum コンフィグキー : enumList) {
            RString コンフィグ名称 = BusinessConfig.get(コンフィグキー, サブ業務コード);
            kaigoConfigMap.put(コンフィグキー, コンフィグ名称);
        }
        return kaigoConfigMap;
    }
}
