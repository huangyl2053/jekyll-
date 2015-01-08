/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.shikaku;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.shikaku.ConfigKeysHihokenshashoJushoEdit;
import jp.co.ndensan.reams.db.dbz.business.config.ConfigValueBoolean;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.GunNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.HowToEditJusho;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.KatagakiPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.ShichosonNamePrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.hokensha.TodofukenNamePrint;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者証を出力する際の住所編集方法について定義している業務コンフィグを取得します。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoJushoEditConfig {

    private final Map<ConfigKeysHihokenshashoJushoEdit, RString> configs;

    /**
     * コンストラクタです。
     */
    public HihokenshashoJushoEditConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    HihokenshashoJushoEditConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysHihokenshashoJushoEdit, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysHihokenshashoJushoEdit, RString> map = new EnumMap<>(ConfigKeysHihokenshashoJushoEdit.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHihokenshashoJushoEdit target : ConfigKeysHihokenshashoJushoEdit.values()) {
            RString value = new RString(businessConfig.get(target, nowDate, SubGyomuCode.DBA介護資格).toString());
            map.put(target, value);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 帳票独自区分を使用するか否かを返します。
     *
     * @return 業務コンフィグの値が帳票独自区分を示す場合true、市町村共通を示す場合false
     */
    public boolean uses帳票独自区分() {
        return ConfigValueBoolean.perseBoolean(
                configs.get(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_帳票独自区分));
    }

    /**
     * 都道府県名付与有無を表す値を返します。
     *
     * @return 都道府県名付与有無
     */
    public TodofukenNamePrint get都道府県名付与有無() {
        RString configKey = configs.get(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_都道府県名付与有無);
        return TodofukenNamePrint.toValue(configKey);
    }

    /**
     * 郡名付与有無を表す値を返します。
     *
     * @return 郡名付与有無
     */
    public GunNamePrint get郡名付与有無() {
        RString configKey = configs.get(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_郡名付与有無);
        return GunNamePrint.toValue(configKey);
    }

    /**
     * 市町村名付与有無を示す値を返します。
     *
     * @return 市町村名付与有無
     */
    public ShichosonNamePrint get市町村名付与有無() {
        RString configKey = configs.get(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_市町村名付与有無);
        return ShichosonNamePrint.toValue(configKey);
    }

    /**
     * 住所編集方法を示す値を返します。
     *
     * @return 住所編集方法
     */
    public HowToEditJusho get住所編集方法() {
        RString configKey = configs.get(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_管内住所編集_編集方法);
        return HowToEditJusho.toValue(configKey);
    }

    /**
     * 方書表示有無を示す値を返します。
     *
     * @return 方書表示有無
     */
    public KatagakiPrint get方書表示有無() {
        RString configKey = configs.get(ConfigKeysHihokenshashoJushoEdit.被保険者証表示方法_住所編集_方書表示有無);
        return KatagakiPrint.toValue(configKey);
    }

}
