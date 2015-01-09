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
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHokenshaJoho.保険者情報_電話番号;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHokenshaJoho.保険者情報_住所;
import static jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysHokenshaJoho.保険者情報_郵便番号;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HokenshaKosei;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TopPriorityArea;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.HokenshaName;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者情報の業務コンフィグを取得するクラスです。
 *
 * @author N8187 久保田 英男
 * @author N3327 三浦 凌
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
    public HokenshaJohoConfig(IUrBusinessConfig businessConfig) {
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
     * 保険者の住所を返します。
     *
     * @return 保険者の住所
     */
    public AtenaJusho get保険者住所() {
        return new AtenaJusho(this.configs.get(保険者情報_住所));
    }

    /**
     * 保険者の電話番号を返します。
     *
     * @return 保険者の電話番号
     */
    public TelNo get電話番号() {
        return new TelNo(this.configs.get(保険者情報_電話番号));
    }

    /**
     * 保険者の郵便番号を返します。
     *
     * @return 保険者の郵便番号
     */
    public YubinNo get郵便番号() {
        return new YubinNo(this.configs.get(保険者情報_郵便番号));
    }

    /**
     * 保険者情報_保険者構成を取得します。
     *
     * @return 保険者情報_保険者構成
     */
    public RString get保険者情報_保険者構成() {
        return configs.get(保険者情報_保険者構成);
    }

    /**
     * {@link HokenshaKosei 保険者構成}を返します。
     *
     * @return {@link HokenshaKosei 保険者構成}
     */
    public HokenshaKosei get保険者構成() {
        return HokenshaKosei.toValue(configs.get(保険者情報_保険者構成));
    }

    /**
     * 保険者情報_保険者番号を取得します。
     *
     * @return 保険者情報_保険者番号
     */
    public RString get保険者情報_保険者番号() {
        return configs.get(保険者情報_保険者番号);
    }

    /**
     * {@link HokenshaNo 保険者番号}を返します。
     *
     * @return {@link HokenshaNo 保険者番号}
     */
    public HokenshaNo get保険者番号() {
        return new HokenshaNo(configs.get(保険者情報_保険者番号));
    }

    /**
     * 保険者情報_保険者名称を取得します。
     *
     * @return 保険者情報_保険者名称
     */
    public RString get保険者情報_保険者名称() {
        return configs.get(保険者情報_保険者名称);
    }

    /**
     * {@link HokenshaName 保険者名}を返します。
     *
     * @return {@link HokenshaName 保険者名}
     */
    public HokenshaName get保険者名() {
        return new HokenshaName(configs.get(保険者情報_保険者名称));
    }

    /**
     * 保険者情報_最優先地区コードを取得します。
     *
     * @return 保険者情報_最優先地区コード
     */
    public RString get保険者情報_最優先地区コード() {
        return configs.get(保険者情報_最優先地区コード);
    }

    /**
     * {@link TopPriorityArea 最優先地区}を返します。
     *
     * @return {@link TopPriorityArea 最優先地区}
     */
    public TopPriorityArea get最優先地区() {
        return TopPriorityArea.toValue(configs.get(保険者情報_最優先地区コード));
    }
}
