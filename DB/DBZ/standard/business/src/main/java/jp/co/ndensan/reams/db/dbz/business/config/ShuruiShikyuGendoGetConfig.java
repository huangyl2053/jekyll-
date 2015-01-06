/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShuruiShikyuGendoGet;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysShuruiShikyuGendoGet.種類支給限度額_取得方法;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.ConfigValuesShuruiShikyuGendoGet;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 種類支給限度額コンフィグを取得するためのクラスです。
 *
 * @author n8187 久保田 英男
 */
public class ShuruiShikyuGendoGetConfig {

    private final Map<ConfigKeysShuruiShikyuGendoGet, RString> configs;

    /**
     * コンストラクタです。
     */
    public ShuruiShikyuGendoGetConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    public ShuruiShikyuGendoGetConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysShuruiShikyuGendoGet, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysShuruiShikyuGendoGet, RString> map = new EnumMap<>(ConfigKeysShuruiShikyuGendoGet.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysShuruiShikyuGendoGet target : ConfigKeysShuruiShikyuGendoGet.values()) {
            map.put(target, businessConfig.get(target, nowDate, SubGyomuCode.DBD介護受給));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 種類支給限度額_取得方法を取得します。
     *
     * @return 種類支給限度額_取得方法
     */
    public ConfigValuesShuruiShikyuGendoGet get種類支給限度額_取得方法() {
        return ConfigValuesShuruiShikyuGendoGet.toValue(configs.get(種類支給限度額_取得方法));
    }
}
