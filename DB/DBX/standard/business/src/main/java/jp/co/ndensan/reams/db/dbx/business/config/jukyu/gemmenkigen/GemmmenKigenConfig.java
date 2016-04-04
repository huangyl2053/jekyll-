/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen;

import jp.co.ndensan.reams.db.dbx.business.config.util.ConfigLoaderByConfigKeys;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コンフィグ「減免期限_○○」を取得します。
 * <p/>
 * このクラスの役割はコンフィグに設定された値の取得のみです。
 * 基準日が含まれる年度の判定等は、{@link GemmenNendoResearcher}で行うことができます。
 *
 * @see GemmenGengakuShurui
 * @see GemmenNendoResearcher
 */
final class GemmmenKigenConfig extends ConfigLoaderByConfigKeys<ConfigKeysGemmenKigen> {

    private GemmmenKigenConfig(RDate rDate) {
        super(ConfigKeysGemmenKigen.class, rDate);
    }

    private GemmmenKigenConfig(FlexibleDate fDate) {
        this(toRDate(fDate));
    }

    private static RDate toRDate(FlexibleDate fDate) {
        return new RDate(fDate.getYearValue(), fDate.getMonthValue(), fDate.getDayValue());
    }

    /**
     * 指定の減免の、基準日時点の年度終了日（月日）を返却します。
     *
     * @param 減免減額種類 対象とする減免の種類
     * @param 基準日 年度終了日（月日）を判断したい基準日
     * @return 年度終了日（月日）
     */
    static RString get期限月日(GemmenGengakuShurui 減免減額種類, FlexibleDate 基準日) {
        switch (減免減額種類) {
            case 負担限度額認定:
                return new GemmmenKigenConfig(基準日).get(ConfigKeysGemmenKigen.減免期限_特定入所者);
            case 利用者負担額減額:
                return new GemmmenKigenConfig(基準日).get(ConfigKeysGemmenKigen.減免期限_利用減免);
            case 社会福祉法人等利用者負担軽減:
                return find社福期限月日(基準日);
            case 訪問介護利用者負担額減額:
                return new GemmmenKigenConfig(基準日).get(ConfigKeysGemmenKigen.減免期限_特別減免);
            case 特別地域加算減免:
                return new GemmmenKigenConfig(基準日).get(ConfigKeysGemmenKigen.減免期限_特地減免);
            case 標準負担額減免:
                return new GemmmenKigenConfig(基準日).get(ConfigKeysGemmenKigen.減免期限_標準減額);
            case 特定標準負担額減額:
                return new GemmmenKigenConfig(基準日).get(ConfigKeysGemmenKigen.減免期限_標準減額);
            default:
                return RString.EMPTY;
        }
    }

    private static final FlexibleDate SHAFUKU_HOKAISEI = new FlexibleDate("20050930");

    private static RString find社福期限月日(FlexibleDate fDate) {
        if (fDate.isBeforeOrEquals(SHAFUKU_HOKAISEI)) {
            return new GemmmenKigenConfig(fDate).get(ConfigKeysGemmenKigen.減免期限_法人減免);
        } else {
            return new GemmmenKigenConfig(fDate).get(ConfigKeysGemmenKigen.減免期限_法人軽減);
        }
    }
}
