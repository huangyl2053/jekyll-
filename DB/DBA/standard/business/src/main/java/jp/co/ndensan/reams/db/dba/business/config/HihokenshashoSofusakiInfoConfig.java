/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.core.config.ConfigKeysHihokenshashoSofusakiInfo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 被保険者の表示方法について定義している業務コンフィグを取得します。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoSofusakiInfoConfig {

    private final Map<ConfigKeysHihokenshashoSofusakiInfo, RString> configs;

    /**
     * コンストラクタです。
     */
    public HihokenshashoSofusakiInfoConfig() {
        this.configs = createMap();
    }

    private Map<ConfigKeysHihokenshashoSofusakiInfo, RString> createMap() {
        Map<ConfigKeysHihokenshashoSofusakiInfo, RString> map = new EnumMap<>(ConfigKeysHihokenshashoSofusakiInfo.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHihokenshashoSofusakiInfo target : ConfigKeysHihokenshashoSofusakiInfo.values()) {
            RString value = new RString(BusinessConfig.get(target, nowDate).toString());
            map.put(target, value);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 世帯主表示有無を示す値を返します。
     *
     * @return 世帯主表示有無
     */
    public RString get世帯主表示有無() {
        return configs.get(ConfigKeysHihokenshashoSofusakiInfo.被保険者証_送付先情報_世帯主表示有無);
    }

    /**
     * 敬称表示方法を示す値を返します。
     *
     * @return 敬称表示方法
     */
    public RString get敬称表示方法() {
        return configs.get(ConfigKeysHihokenshashoSofusakiInfo.被保険者証_送付先情報_敬称表示方法);
    }

    /**
     * 外部帳票文字切れ制御方法を示す値を返します。
     *
     * @return 外部帳票文字切れ制御方法
     */
    public RString get外部帳票文字切れ制御方法() {
        return configs.get(ConfigKeysHihokenshashoSofusakiInfo.被保険者証_外部帳票文字切れ制御方法);
    }

}
