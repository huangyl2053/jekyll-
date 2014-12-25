/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHihokenshashoItakudaikoHyoji;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示有無;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示終了文言;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHihokenshashoItakudaikoHyoji.被保険者証表示方法_委託代行業者_表示開始文言;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証発行における委託代行業者の業務コンフィグを取得するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HihokenshashoItakudaikoHyojiConfig {

    private final Map<ConfigKeysHihokenshashoItakudaikoHyoji, RString> configs;

    /**
     * コンストラクタです。
     */
    public HihokenshashoItakudaikoHyojiConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    HihokenshashoItakudaikoHyojiConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysHihokenshashoItakudaikoHyoji, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysHihokenshashoItakudaikoHyoji, RString> map = new EnumMap<>(ConfigKeysHihokenshashoItakudaikoHyoji.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHihokenshashoItakudaikoHyoji target : ConfigKeysHihokenshashoItakudaikoHyoji.values()) {
            map.put(target, businessConfig.get(target, nowDate, SubGyomuCode.DBA介護資格));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 被保険者証表示方法_委託代行業者_表示有無を取得します。
     *
     * @return 被保険者証表示方法_委託代行業者_表示有無
     */
    public RString get被保険者証表示方法_委託代行業者_表示有無() {
        return configs.get(被保険者証表示方法_委託代行業者_表示有無);
    }

    /**
     * 被保険者証表示方法_委託代行業者_表示開始文言を取得します。
     *
     * @return 被保険者証表示方法_委託代行業者_表示開始文言
     */
    public RString get被保険者証表示方法_委託代行業者_表示開始文言() {
        return configs.get(被保険者証表示方法_委託代行業者_表示開始文言);
    }

    /**
     * 被保険者証表示方法_委託代行業者_表示終了文言を取得します。
     *
     * @return 被保険者証表示方法_委託代行業者_表示終了文言
     */
    public RString get被保険者証表示方法_委託代行業者_表示終了文言() {
        return configs.get(被保険者証表示方法_委託代行業者_表示終了文言);
    }
}
