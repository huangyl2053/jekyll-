/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.config.shikaku;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configkeys.shikaku.ConfigKeysHihokenshashoPrint;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.ConfigValueBoolean;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.HihokenshaNoPrintType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.HihokenshashoPrintType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.KyotakuJigyoshaRirekiPrintType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.configvalues.YukoKigenPrintType;
import jp.co.ndensan.reams.ur.urz.business.config.IUrBusinessConfig;
import jp.co.ndensan.reams.ur.urz.business.config.UrBusinessConfigFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者の表示方法について定義している業務コンフィグを取得します。
 *
 * @author n8178 城間篤人
 */
public class HihokenshashoPrintConfig {

    private final Map<ConfigKeysHihokenshashoPrint, RString> configs;

    /**
     * コンストラクタです。
     */
    public HihokenshashoPrintConfig() {
        this.configs = createMap(UrBusinessConfigFactory.createInstance());
    }

    /**
     * コンフィグ情報を外から注入する場合のコンストラクタです。テスト時に使用します。
     *
     * @param businessConfig 業務コンフィグを取得するインスタンス
     */
    HihokenshashoPrintConfig(IUrBusinessConfig businessConfig) {
        this.configs = createMap(businessConfig);
    }

    private Map<ConfigKeysHihokenshashoPrint, RString> createMap(IUrBusinessConfig businessConfig) {
        Map<ConfigKeysHihokenshashoPrint, RString> map = new EnumMap<>(ConfigKeysHihokenshashoPrint.class);
        RDate nowDate = RDate.getNowDate();
        for (ConfigKeysHihokenshashoPrint target : ConfigKeysHihokenshashoPrint.values()) {
            RString value = new RString(businessConfig.get(target, nowDate, SubGyomuCode.DBA介護資格).toString());
            map.put(target, value);
        }
        return Collections.unmodifiableMap(map);
    }

    /**
     * 氏名カナ表示有無を示す値を返します。
     *
     * @return 氏名カナ表示有無
     */
    public boolean is氏名カナ表示有り() {
        return ConfigValueBoolean.perseBoolean(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_氏名カナ表示有無));
    }

    /**
     * 証表示タイプを示す値を返します。
     *
     * @return 証表示タイプ
     */
    public HihokenshashoPrintType get証表示タイプ() {
        return HihokenshashoPrintType.toValue(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_証表示タイプ));
    }

    /**
     * 被保険者番号表示書式を示す値を返します。
     *
     * @return 被保険者番号表示書式
     */
    public HihokenshaNoPrintType get被保険者番号表示書式() {
        return HihokenshaNoPrintType.toValue(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_被保険者番号表示書式));
    }

    /**
     * 郵便番号表示有無を示す値を返します。
     *
     * @return 郵便番号表示有無
     */
    public boolean is郵便番号表示有り() {
        return ConfigValueBoolean.perseBoolean(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_郵便番号表示有無));
    }

    /**
     * 要介護認定期限切れの表示有無を示す値を返します。
     *
     * @return 要介護認定期限切れの表示有無
     */
    public boolean is要介護認定期限切れ表示有り() {
        return ConfigValueBoolean.perseBoolean(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_要介護認定期限切れ_表示有無));
    }

    /**
     * 居宅支援事業者適用切れの表示有無を示す値を返します。
     *
     * @return 居宅支援事業者適用切れの表示有無
     */
    public boolean is居宅支援事業者適用切れ表示有り() {
        return ConfigValueBoolean.perseBoolean(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_居宅支援事業者適用切れ_表示有無));
    }

    /**
     * 居宅支援事業者履歴の表示方法を示す値を返します。
     *
     * @return 居宅支援事業者履歴の表示方法
     */
    public KyotakuJigyoshaRirekiPrintType get居宅支援事業者履歴表示方法() {
        return KyotakuJigyoshaRirekiPrintType.toValue(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_居宅支援事業者履歴_表示方法));
    }

    /**
     * 合併前の被保険者証を印刷する際、有効期限をどのように表示するかを示す値を返します。
     *
     * @return 有効期限表示方法
     */
    public YukoKigenPrintType get合併前印刷時_有効期限表示方法() {
        return YukoKigenPrintType.toValue(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_合併前印刷時_有効期限));
    }

    /**
     * 委託代行業者の表示有無を示す値を返します。
     *
     * @return 委託代行業者の表示有無
     */
    public boolean is委託代行業者表示有り() {
        return ConfigValueBoolean.perseBoolean(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_委託代行業者_表示有無));
    }

    /**
     * 委託第業者を表示する際の、表示開始文言を示す値を返します。
     *
     * @return 表示開始文言
     */
    public RString get委託代行業者表示開始文言() {
        return configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_委託代行業者_表示開始文言);
    }

    /**
     * 委託第業者を表示する際の、表示終了文言を示す値を返します。
     *
     * @return 表示終了文言
     */
    public RString get委託代行業者_表示終了文言() {
        return configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_委託代行業者_表示終了文言);
    }

    /**
     * 適用開始日と事業者届出日の、切替表示区分を示す値を返します。
     *
     * @return 適用開始日と事業者届出日の切替表示区分
     */
    public boolean is届出日の代わりに適用開始日を表示() {
        return ConfigValueBoolean.perseBoolean(
                configs.get(ConfigKeysHihokenshashoPrint.被保険者証表示方法_居宅支援事業者届出日_適用開始日切替表示区分));
    }
}
