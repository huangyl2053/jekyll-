/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.config;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbu.definition.enumeratedtype.config.ConfigKeysChohyoKyotsuJushoEdit;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票を出力する際の住所編集方法について定義している業務コンフィグを取得します。
 *
 * @author n8178 城間篤人
 */
public class ChohyoKyotsuJushoEditConfig {

    private final Map<ConfigKeysChohyoKyotsuJushoEdit, RString> configs;

    /**
     * コンストラクタです。
     */
    public ChohyoKyotsuJushoEditConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    ChohyoKyotsuJushoEditConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysChohyoKyotsuJushoEdit, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysChohyoKyotsuJushoEdit, RString> map = new EnumMap<>(ConfigKeysChohyoKyotsuJushoEdit.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysChohyoKyotsuJushoEdit target : ConfigKeysChohyoKyotsuJushoEdit.values()) {
            RString value = new RString(businessConfig.get(target, nowDate).toString());
            map.put(target, value);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 都道府県名付与有無を表す値を返します。
     *
     * @return 都道府県名付与有無
     */
    public RString get都道府県名付与有無() {
        return configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_都道府県名付与有無);
    }

    /**
     * 郡名付与有無を表す値を返します。
     *
     * @return 郡名付与有無
     */
    public RString get郡名付与有無() {
        return configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_郡名付与有無);
    }

    /**
     * 市町村名付与有無を示す値を返します。
     *
     * @return 市町村名付与有無
     */
    public RString get市町村名付与有無() {
        return configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_市町村名付与有無);
    }

    /**
     * 住所編集方法を示す値を返します。
     *
     * @return 住所編集方法
     */
    public RString get住所編集方法() {
        return configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_編集方法);
    }

    /**
     * 方書表示有無を示す値を返します。
     *
     * @return 方書表示有無
     */
    public RString get方書表示有無() {
        return configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_住所編集_方書表示有無);
    }
}
