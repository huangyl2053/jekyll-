/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SochimotoSochisakiKubun;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.ConfigKeysGaitoshaKensaku;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.SystemException;

/**
 * 該当者検索のコンフィグを取得するクラスです。
 *
 * @author N8156 宮本 康
 */
public class GaitoshaKensakuConfig {

    private final Map<ConfigKeysGaitoshaKensaku, RString> configs;

    /**
     * コンストラクタです。
     */
    public GaitoshaKensakuConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    public GaitoshaKensakuConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysGaitoshaKensaku, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysGaitoshaKensaku, RString> map = new HashMap<>();
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysGaitoshaKensaku target : ConfigKeysGaitoshaKensaku.values()) {
            map.put(target, businessConfig.get(target, nowDate, SubGyomuCode.DBU介護統計報告));
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 指定したキーに対応する値をコンフィグから取得して返します。
     *
     * @param key キー
     * @return 値
     */
    public RString get(ConfigKeysGaitoshaKensaku key) {
        return configs.get(key);
    }

    /**
     * 広域内住所地特例者検索制御_措置元_措置先区分_介護資格を返します。
     *
     * @return 広域内住所地特例者検索制御_措置元_措置先区分_介護資格
     */
    public SochimotoSochisakiKubun get措置元措置先区分_介護資格() {
        return SochimotoSochisakiKubun.toValue(get(ConfigKeysGaitoshaKensaku.広域内住所地特例者検索制御_措置元_措置先区分_介護資格));
    }

    /**
     * 検索制御_最大取得件数を返します。
     *
     * @return 検索制御_最大取得件数
     * @throws SystemException 検索制御_最大取得件数がnullの場合
     */
    public int get最大取得件数() {
        RString data = get(ConfigKeysGaitoshaKensaku.検索制御_最大取得件数);
        if (data == null) {
            throw new SystemException(UrSystemErrorMessages.値がnull.getReplacedMessage("検索制御_最大取得件数"));
        }
        return Integer.parseInt(data.toString());
    }
}
