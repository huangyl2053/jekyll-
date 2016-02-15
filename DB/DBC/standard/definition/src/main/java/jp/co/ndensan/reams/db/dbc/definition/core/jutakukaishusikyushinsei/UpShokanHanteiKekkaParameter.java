/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給判定結果MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpShokanHanteiKekkaParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final HokenshaNo 証記載保険者番号;
    private final FlexibleDate 決定年月日;
    private final RString 支給決定区分;
    private final Decimal 支払金額;
    private final Decimal 前回支払金額;
    private final Decimal 差額金額合計;

    /**
     * コンストラクタです。
     *
     */
    private UpShokanHanteiKekkaParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 決定年月日,
            RString 支給決定区分,
            Decimal 支払金額,
            Decimal 前回支払金額,
            Decimal 差額金額合計) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.決定年月日 = 決定年月日;
        this.支給決定区分 = 支給決定区分;
        this.支払金額 = 支払金額;
        this.前回支払金額 = 前回支払金額;
        this.差額金額合計 = 差額金額合計;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 証記載保険者番号
     * @param 決定年月日
     * @param 支給決定区分
     * @param 支払金額
     * @param 前回支払金額
     * @param 差額金額合計
     * @return
     */
    public static UpShokanHanteiKekkaParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 決定年月日,
            RString 支給決定区分,
            Decimal 支払金額,
            Decimal 前回支払金額,
            Decimal 差額金額合計) {
        return new UpShokanHanteiKekkaParameter(被保険者番号, サービス提供年月, 整理番号, 証記載保険者番号,
                決定年月日, 支給決定区分, 支払金額, 前回支払金額, 差額金額合計);
    }
}
