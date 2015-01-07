/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.shikaku;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.shikaku.ConfigKeysHihokenshashoSofusakiInfo;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    HihokenshashoSofusakiInfoConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysHihokenshashoSofusakiInfo, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysHihokenshashoSofusakiInfo, RString> map = new EnumMap<>(ConfigKeysHihokenshashoSofusakiInfo.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHihokenshashoSofusakiInfo target : ConfigKeysHihokenshashoSofusakiInfo.values()) {
            RString value = new RString(businessConfig.get(target, nowDate, SubGyomuCode.DBA介護資格).toString());
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
