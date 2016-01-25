/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 支給申請削除処理MyBatisパラメータクラスです。
 *
 */
@lombok.Getter
public class Dbt3034ShokanShinseiParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final FlexibleDate 決定年月日;
    private final RString 支給不支給決定区分;
    private final Decimal 支払金額;
    private final Decimal 支払金額内訳利用者分;
    private final FlexibleYearMonth 決定一覧取込年月;
    private final ShikibetsuCode 識別コード;
    private final RString 削除モード;

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 決定年月日
     * @param 支給不支給決定区分
     * @param 支払金額
     * @param 支払金額内訳利用者分
     * @param 決定一覧取込年月
     * @param 識別コード
     * @param 削除モード
     */
    private Dbt3034ShokanShinseiParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            FlexibleDate 決定年月日,
            RString 支給不支給決定区分,
            Decimal 支払金額,
            Decimal 支払金額内訳利用者分,
            FlexibleYearMonth 決定一覧取込年月,
            ShikibetsuCode 識別コード,
            RString 削除モード) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.決定年月日 = 決定年月日;
        this.支給不支給決定区分 = 支給不支給決定区分;
        this.支払金額 = 支払金額;
        this.支払金額内訳利用者分 = 支払金額内訳利用者分;
        this.決定一覧取込年月 = 決定一覧取込年月;
        this.識別コード = 識別コード;
        this.削除モード = 削除モード;
    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @param 整理番号
     * @param 決定年月日
     * @param 支給不支給決定区分
     * @param 支払金額
     * @param 支払金額内訳利用者分
     * @param 決定一覧取込年月
     * @param 識別コード
     * @param 削除モード
     * @return
     */
    public static Dbt3034ShokanShinseiParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            FlexibleDate 決定年月日,
            RString 支給不支給決定区分,
            Decimal 支払金額,
            Decimal 支払金額内訳利用者分,
            FlexibleYearMonth 決定一覧取込年月,
            ShikibetsuCode 識別コード,
            RString 削除モード) {
        return new Dbt3034ShokanShinseiParameter(被保険者番号, サービス提供年月, 整理番号, 決定年月日,
                支給不支給決定区分, 支払金額, 支払金額内訳利用者分, 決定一覧取込年月, 識別コード, 削除モード);

    }

}
