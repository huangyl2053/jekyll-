/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHokenshaJoho;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHokenshaJoho.保険者情報_保険者名称;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHokenshaJoho.保険者情報_保険者構成;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHokenshaJoho.保険者情報_保険者番号;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHokenshaJoho.保険者情報_最優先地区コード;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報の業務コンフィグを取得するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class HokenshaJohoConfig {

    private final Map<ConfigKeysHokenshaJoho, RString> configs;

    /**
     * コンストラクタです。
     */
    public HokenshaJohoConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    HokenshaJohoConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysHokenshaJoho, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysHokenshaJoho, RString> map = new EnumMap<>(ConfigKeysHokenshaJoho.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHokenshaJoho target : ConfigKeysHokenshaJoho.values()) {
            map.put(target, businessConfig.get(target, nowDate, SubGyomuCode.DBU介護統計報告));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 保険者情報_保険者構成を取得します。
     *
     * @return 保険者情報_保険者構成
     */
    public RString get保険者情報_保険者構成() {
        return new RString(configs.get(保険者情報_保険者構成).toString());
    }

    /**
     * 保険者情報_保険者番号を取得します。
     *
     * @return 保険者情報_保険者番号
     */
    public RString get保険者情報_保険者番号() {
        return new RString(configs.get(保険者情報_保険者番号).toString());
    }

    /**
     * 保険者情報_保険者名称を取得します。
     *
     * @return 保険者情報_保険者名称
     */
    public RString get保険者情報_保険者名称() {
        return new RString(configs.get(保険者情報_保険者名称).toString());
    }

    /**
     * 保険者情報_最優先地区コードを取得します。
     *
     * @return 保険者情報_最優先地区コード
     */
    public RString get保険者情報_最優先地区コード() {
        return new RString(configs.get(保険者情報_最優先地区コード).toString());
    }

}
