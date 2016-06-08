/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.jukyu;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.config.ConfigValueBoolean;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShikakushashoItakudaikoHyoji;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者の表示有無;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者表示終了文言;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShikakushashoItakudaikoHyoji.資格者証表示方法_委託代行業者表示開始文言;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.ShikakushashoItakudaikoHyoji;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 資格者証発行における委託代行業者の業務コンフィグを取得するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class ShikakushashoItakudaikoHyojiConfig {

    private final Map<ConfigKeysShikakushashoItakudaikoHyoji, RString> configs;

    /**
     * コンストラクタです。
     */
    public ShikakushashoItakudaikoHyojiConfig() {
        this.configs = createMap();
    }

    private Map<ConfigKeysShikakushashoItakudaikoHyoji, RString> createMap() {
        Map<ConfigKeysShikakushashoItakudaikoHyoji, RString> map = new EnumMap<>(ConfigKeysShikakushashoItakudaikoHyoji.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysShikakushashoItakudaikoHyoji target : ConfigKeysShikakushashoItakudaikoHyoji.values()) {
            map.put(target, BusinessConfig.get(target, nowDate, SubGyomuCode.DBD介護受給));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 資格者証表示方法_委託代行業者の表示有無を取得します。
     *
     * @return 資格者証表示方法_委託代行業者の表示有無
     */
    public ShikakushashoItakudaikoHyoji get資格者証表示方法_委託代行業者の表示有無() {
        return ShikakushashoItakudaikoHyoji.toValue(configs.get(資格者証表示方法_委託代行業者の表示有無));
    }

    /**
     * {@link ConfigKeysShikakushashoItakudaikoHyoji#資格者証表示方法_委託代行業者の表示有無}について、
     * 表示する場合は{@code true}、しない場合は{@code false}を返します。
     *
     * @return 表示する場合は{@code true}、しない場合は{@code false}
     */
    public boolean prints委託代行事業者() {
        return ConfigValueBoolean.parseBoolean(configs.get(資格者証表示方法_委託代行業者の表示有無));
    }

    /**
     * 資格者証表示方法_委託代行業者表示開始文言を取得します。
     *
     * @return 資格者証表示方法_委託代行業者表示開始文言
     */
    public RString get資格者証表示方法_委託代行業者表示開始文言() {
        return configs.get(資格者証表示方法_委託代行業者表示開始文言);
    }

    /**
     * 資格者証表示方法_委託代行業者表示終了文言を取得します。
     *
     * @return 資格者証表示方法_委託代行業者表示終了文言
     */
    public RString get資格者証表示方法_委託代行業者表示終了文言() {
        return configs.get(資格者証表示方法_委託代行業者表示終了文言);
    }
}
