/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_記載文言;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.ShiharaiHohoHenkoShuryobunKisaiKubun;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 支払方法変更コンフィグを取得するためのクラスです。
 *
 * @author n8187 久保田 英男
 */
public class ShiharaiHohoHenkoConfig {

    private final Map<ConfigKeysShiharaiHohoHenko, RString> configs;

    /**
     * コンストラクタです。
     */
    public ShiharaiHohoHenkoConfig() {
        this.configs = createMap();
    }

    private Map<ConfigKeysShiharaiHohoHenko, RString> createMap() {
        Map<ConfigKeysShiharaiHohoHenko, RString> map = new EnumMap<>(ConfigKeysShiharaiHohoHenko.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysShiharaiHohoHenko target : ConfigKeysShiharaiHohoHenko.values()) {
            map.put(target, BusinessConfig.get(target, nowDate, SubGyomuCode.DBD介護受給));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 支払方法変更_証表示支払方法_終了分記載区分を取得します。
     *
     * @return 支払方法変更_証表示支払方法_終了分記載区分
     */
    public ShiharaiHohoHenkoShuryobunKisaiKubun get支払方法変更_証表示支払方法_終了分記載区分() {
        return ShiharaiHohoHenkoShuryobunKisaiKubun.toValue(configs.get(支払方法変更_証表示支払方法_終了分記載区分));
    }

    /**
     * 支払方法変更_証表示支払方法_記載文言を取得します。
     *
     * @return 支払方法変更_証表示支払方法_記載文言
     */
    public RString get支払方法変更_証表示支払方法_記載文言() {
        return configs.get(支払方法変更_証表示支払方法_記載文言);
    }

    /**
     * 支払方法変更_証表示差止_終了分記載区分を取得します。
     *
     * @return 支払方法変更_証表示差止_終了分記載区分
     */
    public ShiharaiHohoHenkoShuryobunKisaiKubun get支払方法変更_証表示差止_終了分記載区分() {
        return ShiharaiHohoHenkoShuryobunKisaiKubun.toValue(configs.get(支払方法変更_証表示差止_終了分記載区分));
    }

    /**
     * 支払方法変更_証表示差止_記載文言を取得します。
     *
     * @return 支払方法変更_証表示差止_記載文言
     */
    public RString get支払方法変更_証表示差止_記載文言() {
        return configs.get(支払方法変更_証表示差止_記載文言);
    }

    /**
     * 支払方法変更_証表示減額_終了分記載区分を取得します。
     *
     * @return 支払方法変更_証表示減額_終了分記載区分
     */
    public ShiharaiHohoHenkoShuryobunKisaiKubun get支払方法変更_証表示減額_終了分記載区分() {
        return ShiharaiHohoHenkoShuryobunKisaiKubun.toValue(configs.get(支払方法変更_証表示減額_終了分記載区分));
    }

    /**
     * 支払方法変更_証表示減額_記載文言を取得します。
     *
     * @return 支払方法変更_証表示減額_記載文言
     */
    public RString get支払方法変更_証表示減額_記載文言() {
        return configs.get(支払方法変更_証表示減額_記載文言);
    }

    /**
     * 支払方法変更_資格者証表示支払方法_終了分記載区分を取得します。
     *
     * @return 支払方法変更_資格者証表示支払方法_終了分記載区分
     */
    public ShiharaiHohoHenkoShuryobunKisaiKubun get支払方法変更_資格者証表示支払方法_終了分記載区分() {
        return ShiharaiHohoHenkoShuryobunKisaiKubun.toValue(configs.get(支払方法変更_資格者証表示支払方法_終了分記載区分));
    }

    /**
     * 支払方法変更_資格者証表示支払方法_記載文言を取得します。
     *
     * @return 支払方法変更_資格者証表示支払方法_記載文言
     */
    public RString get支払方法変更_資格者証表示支払方法_記載文言() {
        return configs.get(支払方法変更_資格者証表示支払方法_記載文言);
    }

    /**
     * 支払方法変更_資格者証表示差止_終了分記載区分を取得します。
     *
     * @return 支払方法変更_資格者証表示差止_終了分記載区分
     */
    public ShiharaiHohoHenkoShuryobunKisaiKubun get支払方法変更_資格者証表示差止_終了分記載区分() {
        return ShiharaiHohoHenkoShuryobunKisaiKubun.toValue(configs.get(支払方法変更_資格者証表示差止_終了分記載区分));
    }

    /**
     * 支払方法変更_資格者証表示差止_記載文言を取得します。
     *
     * @return 支払方法変更_資格者証表示差止_記載文言
     */
    public RString get支払方法変更_資格者証表示差止_記載文言() {
        return configs.get(支払方法変更_資格者証表示差止_記載文言);
    }

    /**
     * 支払方法変更_資格者証表示減額_終了分記載区分を取得します。
     *
     * @return 支払方法変更_資格者証表示減額_終了分記載区分
     */
    public ShiharaiHohoHenkoShuryobunKisaiKubun get支払方法変更_資格者証表示減額_終了分記載区分() {
        return ShiharaiHohoHenkoShuryobunKisaiKubun.toValue(configs.get(支払方法変更_資格者証表示減額_終了分記載区分));
    }

    /**
     * 支払方法変更_資格者証表示減額_記載文言を取得します。
     *
     * @return 支払方法変更_資格者証表示減額_記載文言
     */
    public RString get支払方法変更_資格者証表示減額_記載文言() {
        return configs.get(支払方法変更_資格者証表示減額_記載文言);
    }
}
