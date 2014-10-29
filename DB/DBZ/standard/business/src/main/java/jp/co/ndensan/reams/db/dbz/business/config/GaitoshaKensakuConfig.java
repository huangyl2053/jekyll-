/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ConfigKeysGaitoshaKensaku;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.SochimotoSochisakiKubun;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

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
        IUrBusinessConfig businessConfig = UrBusinessConfigFactory.createInstance();
        configs = new HashMap<>();
        for (ConfigKeysGaitoshaKensaku target : ConfigKeysGaitoshaKensaku.values()) {
            this.configs.put(target, businessConfig.get(target, RDate.getNowDate()));
        }
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param configs 該当者検索のコンフィグ情報を格納したMap
     */
    public GaitoshaKensakuConfig(Map<ConfigKeysGaitoshaKensaku, RString> configs) {
        this.configs = configs;
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
}
