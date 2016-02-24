/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishusikyushinsei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 償還払決定情報更新MyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class UpdSyokanbaraiketeJohoParameter {

    private final HihokenshaNo 被保険者番号;
    private final FlexibleYearMonth サービス提供年月;
    private final RString 整理番号;
    private RString 証明書;
    private ShikibetsuCode 識別コード;
    private HokenshaNo 証記載保険者番号;
    private FlexibleDate 決定日;
    private RString 支給区分;
    private final UpShokanShinseiParameter 償還払支給申請;
    private final UpShokanHanteiKekkaParameter 償還払支給判定結果;
    private final UpShokanShukeiParameter 償還払請求集計;

    /**
     * コンストラクタです。
     *
     */
    private UpdSyokanbaraiketeJohoParameter(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 証明書,
            ShikibetsuCode 識別コード,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 決定日,
            RString 支給区分,
            UpShokanShinseiParameter 償還払支給申請,
            UpShokanHanteiKekkaParameter 償還払支給判定結果,
            UpShokanShukeiParameter 償還払請求集計) {
        this.被保険者番号 = 被保険者番号;
        this.サービス提供年月 = サービス提供年月;
        this.整理番号 = 整理番号;
        this.証明書 = 証明書;
        this.識別コード = 識別コード;
        this.証記載保険者番号 = 証記載保険者番号;
        this.決定日 = 決定日;
        this.支給区分 = 支給区分;
        this.償還払支給申請 = 償還払支給申請;
        this.償還払支給判定結果 = 償還払支給判定結果;
        this.償還払請求集計 = 償還払請求集計;

    }

    /**
     * コンストラクタです。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 証明書 証明書
     * @param 識別コード 識別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 決定日 決定日
     * @param 支給区分 支給区分
     * @param 償還払支給申請 償還払支給申請
     * @param 償還払支給判定結果 償還払支給判定結果
     * @param 償還払請求集計 償還払請求集計
     * @return UpdSyokanbaraiketeJohoParameter
     */
    public static UpdSyokanbaraiketeJohoParameter createSelectByKeyParam(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            RString 証明書,
            ShikibetsuCode 識別コード,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 決定日,
            RString 支給区分,
            UpShokanShinseiParameter 償還払支給申請,
            UpShokanHanteiKekkaParameter 償還払支給判定結果,
            UpShokanShukeiParameter 償還払請求集計) {
        return new UpdSyokanbaraiketeJohoParameter(被保険者番号, サービス提供年月, 整理番号, 証明書, 識別コード,
                証記載保険者番号, 決定日, 支給区分, 償還払支給申請, 償還払支給判定結果, 償還払請求集計);
    }
}
