/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.kyotsutokei;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.configkeys.kyotsutokei.ConfigKeysChohyoKyotsuJushoEdit;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.util.config.IBusinessConfig;

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
        this.configs = createMap(BusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    ChohyoKyotsuJushoEditConfig(IBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysChohyoKyotsuJushoEdit, RString> createMap(IBusinessConfig businessConfig) {
        Map<ConfigKeysChohyoKyotsuJushoEdit, RString> map = new EnumMap<>(ConfigKeysChohyoKyotsuJushoEdit.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysChohyoKyotsuJushoEdit target : ConfigKeysChohyoKyotsuJushoEdit.values()) {
            RString value = new RString(businessConfig.get(target, nowDate, SubGyomuCode.DBU介護統計報告).toString());
            map.put(target, value);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * {@link TodofukenNamePrint 都道府県名付与有無}を返します。
     *
     * @return 都道府県名付与有無
     */
    public TodofukenNamePrint get都道府県名付与有無() {
        RString configKey = configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_都道府県名付与有無);
        return TodofukenNamePrint.toValue(configKey);
    }

    /**
     * {@link GunNamePrint 郡名付与有無}を返します。
     *
     * @return 郡名付与有無
     */
    public GunNamePrint get郡名付与有無() {
        RString configKey = configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_郡名付与有無);
        return GunNamePrint.toValue(configKey);
    }

    /**
     * {@link ShichosonNamePrint 市町村名付与有無}を示す値を返します。
     *
     * @return 市町村名付与有無
     */
    public ShichosonNamePrint get市町村名付与有無() {
        RString configKey = configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_市町村名付与有無);
        return ShichosonNamePrint.toValue(configKey);
    }

    /**
     * {@link HowToEditJusho 住所編集方法}を返します。
     *
     * @return 住所編集方法
     */
    public HowToEditJusho get住所編集方法() {
        RString configKey = configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_管内住所編集_編集方法);
        return HowToEditJusho.toValue(configKey);
    }

    /**
     * {@link KatagakiPrint 方書表示有無}を返します。
     *
     * @return 方書表示有無
     */
    public KatagakiPrint get方書表示有無() {
        RString configKey = configs.get(ConfigKeysChohyoKyotsuJushoEdit.帳票共通住所編集方法_住所編集_方書表示有無);
        return KatagakiPrint.toValue(configKey);
    }
}
