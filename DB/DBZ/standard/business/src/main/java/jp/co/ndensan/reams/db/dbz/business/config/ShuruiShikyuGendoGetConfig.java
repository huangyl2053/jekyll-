/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShuruiShikyuGendoGet;
import static jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.ConfigKeysShuruiShikyuGendoGet.種類支給限度額_取得方法;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configvalues.ShuruiShikyuGendoGet;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.util.config.IBusinessConfig;

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
        this.configs = createMap(BusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    public ShuruiShikyuGendoGetConfig(IBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysShuruiShikyuGendoGet, RString> createMap(IBusinessConfig businessConfig) {
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
    public ShuruiShikyuGendoGet get種類支給限度額_取得方法() {
        return ShuruiShikyuGendoGet.toValue(configs.get(種類支給限度額_取得方法));
    }
}
