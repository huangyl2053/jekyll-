/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示差止_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示支払方法_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_証表示減額_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示差止_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示支払方法_記載文言;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_終了分記載区分;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShiharaiHohoHenko.支払方法変更_資格者証表示減額_記載文言;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    ShiharaiHohoHenkoConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysShiharaiHohoHenko, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysShiharaiHohoHenko, RString> map = new EnumMap<>(ConfigKeysShiharaiHohoHenko.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysShiharaiHohoHenko target : ConfigKeysShiharaiHohoHenko.values()) {
            map.put(target, businessConfig.get(target, nowDate, SubGyomuCode.DBD介護受給));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 支払方法変更_証表示支払方法_終了分記載区分を取得します。
     *
     * @return 支払方法変更_証表示支払方法_終了分記載区分
     */
    public RString get支払方法変更_証表示支払方法_終了分記載区分() {
        return new RString(configs.get(支払方法変更_証表示支払方法_終了分記載区分).toString());
    }

    /**
     * 支払方法変更_証表示支払方法_記載文言を取得します。
     *
     * @return 支払方法変更_証表示支払方法_記載文言
     */
    public RString get支払方法変更_証表示支払方法_記載文言() {
        return new RString(configs.get(支払方法変更_証表示支払方法_記載文言).toString());
    }

    /**
     * 支払方法変更_証表示差止_終了分記載区分を取得します。
     *
     * @return 支払方法変更_証表示差止_終了分記載区分
     */
    public RString get支払方法変更_証表示差止_終了分記載区分() {
        return new RString(configs.get(支払方法変更_証表示差止_終了分記載区分).toString());
    }

    /**
     * 支払方法変更_証表示差止_記載文言を取得します。
     *
     * @return 支払方法変更_証表示差止_記載文言
     */
    public RString get支払方法変更_証表示差止_記載文言() {
        return new RString(configs.get(支払方法変更_証表示差止_記載文言).toString());
    }

    /**
     * 支払方法変更_証表示減額_終了分記載区分を取得します。
     *
     * @return 支払方法変更_証表示減額_終了分記載区分
     */
    public RString get支払方法変更_証表示減額_終了分記載区分() {
        return new RString(configs.get(支払方法変更_証表示減額_終了分記載区分).toString());
    }

    /**
     * 支払方法変更_証表示減額_記載文言を取得します。
     *
     * @return 支払方法変更_証表示減額_記載文言
     */
    public RString get支払方法変更_証表示減額_記載文言() {
        return new RString(configs.get(支払方法変更_証表示減額_記載文言).toString());
    }

    /**
     * 支払方法変更_資格者証表示支払方法_終了分記載区分を取得します。
     *
     * @return 支払方法変更_資格者証表示支払方法_終了分記載区分
     */
    public RString get支払方法変更_資格者証表示支払方法_終了分記載区分() {
        return new RString(configs.get(支払方法変更_資格者証表示支払方法_終了分記載区分).toString());
    }

    /**
     * 支払方法変更_資格者証表示支払方法_記載文言を取得します。
     *
     * @return 支払方法変更_資格者証表示支払方法_記載文言
     */
    public RString get支払方法変更_資格者証表示支払方法_記載文言() {
        return new RString(configs.get(支払方法変更_資格者証表示支払方法_記載文言).toString());
    }

    /**
     * 支払方法変更_資格者証表示差止_終了分記載区分を取得します。
     *
     * @return 支払方法変更_資格者証表示差止_終了分記載区分
     */
    public RString get支払方法変更_資格者証表示差止_終了分記載区分() {
        return new RString(configs.get(支払方法変更_資格者証表示差止_終了分記載区分).toString());
    }

    /**
     * 支払方法変更_資格者証表示差止_記載文言を取得します。
     *
     * @return 支払方法変更_資格者証表示差止_記載文言
     */
    public RString get支払方法変更_資格者証表示差止_記載文言() {
        return new RString(configs.get(支払方法変更_資格者証表示差止_記載文言).toString());
    }

    /**
     * 支払方法変更_資格者証表示減額_終了分記載区分を取得します。
     *
     * @return 支払方法変更_資格者証表示減額_終了分記載区分
     */
    public RString get支払方法変更_資格者証表示減額_終了分記載区分() {
        return new RString(configs.get(支払方法変更_資格者証表示減額_終了分記載区分).toString());
    }

    /**
     * 支払方法変更_資格者証表示減額_記載文言を取得します。
     *
     * @return 支払方法変更_資格者証表示減額_記載文言
     */
    public RString get支払方法変更_資格者証表示減額_記載文言() {
        return new RString(configs.get(支払方法変更_資格者証表示減額_記載文言).toString());
    }

}
