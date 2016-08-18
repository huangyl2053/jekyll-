/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.taishoshakensakumybatisprm;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 過誤申立決定情報照会のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBC-2940-010 jinjue
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TaishoshaKensakuMybitisParamter {

    private final FlexibleYearMonth 取扱年月;
    private final RString 保険者区分;
    private final Decimal 履歴番号;
    private final RString 市町村コード;
    private final RString コード種別;
    private final boolean 履歴番号フラグ;
    private final boolean 市町村フラグ;

    private TaishoshaKensakuMybitisParamter(FlexibleYearMonth 取扱年月, RString 保険者区分, Decimal 履歴番号, RString 市町村コード,
            RString コード種別, boolean 履歴番号フラグ, boolean 市町村フラグ) {
        this.保険者区分 = 保険者区分;
        this.取扱年月 = 取扱年月;
        this.履歴番号 = 履歴番号;
        this.市町村コード = 市町村コード;
        this.コード種別 = コード種別;
        this.履歴番号フラグ = 履歴番号フラグ;
        this.市町村フラグ = 市町村フラグ;
    }

    /**
     * 過誤申立決定情報照会のＳＱＬパラメータを生成します。
     *
     * @param 取扱年月 取扱年月
     * @param 保険者区分 保険者区分
     * @param 履歴番号 履歴番号
     * @param 市町村コード 市町村コード
     * @param コード種別 コード種別
     * @param 履歴番号フラグ 履歴番号フラグ
     * @param 市町村フラグ 市町村フラグ
     *
     * @return 過誤申立決定情報照会のパラメータ
     */
    public static TaishoshaKensakuMybitisParamter createParamter(FlexibleYearMonth 取扱年月, RString 保険者区分,
            Decimal 履歴番号, RString 市町村コード, RString コード種別, boolean 履歴番号フラグ, boolean 市町村フラグ) {
        return new TaishoshaKensakuMybitisParamter(取扱年月, 保険者区分, 履歴番号, 市町村コード, コード種別, 履歴番号フラグ, 市町村フラグ);
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param 取扱年月 取扱年月
     * @param 市町村コード 市町村コード
     * @param 市町村フラグ 市町村フラグ
     * @return 過誤申立決定情報照会のパラメータ
     */
    public static TaishoshaKensakuMybitisParamter creatRirekiParameter(FlexibleYearMonth 取扱年月, RString 市町村コード,
            boolean 市町村フラグ) {
        return new TaishoshaKensakuMybitisParamter(取扱年月, RString.EMPTY, Decimal.ZERO, 市町村コード, RString.EMPTY, false, 市町村フラグ);
    }
}
