/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jutakukaishusikyushinseiikkatushinsa;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 一括審査・決定情報更新クラスです。
 *
 * @reamsid_L DBC-0991-040 xicongwang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaveIkkatuShinsaDate implements Serializable {

    private final ShokanShinsei dbt3034entity;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private final HokenshaNo 証記載保険者番号;
    private final FlexibleDate 決定年月日;
    private final ShikibetsuCode 識別コード;
    private final RString 支給区分コード;
    private final Decimal 支払金額;

    /**
     * コンストラクタです。
     *
     * @param dbt3034entity 償還払支給申請テーブルのエンティティ
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 決定年月日 決定年月日
     * @param 識別コード 識別コード
     * @param 支給区分コード 支給区分コード
     * @param 支払金額 支払金額
     */
    public SaveIkkatuShinsaDate(ShokanShinsei dbt3034entity,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 決定年月日,
            ShikibetsuCode 識別コード,
            RString 支給区分コード,
            Decimal 支払金額) {
        this.dbt3034entity = dbt3034entity;
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.証記載保険者番号 = 証記載保険者番号;
        this.決定年月日 = 決定年月日;
        this.識別コード = 識別コード;
        this.支給区分コード = 支給区分コード;
        this.支払金額 = 支払金額;
    }
}
