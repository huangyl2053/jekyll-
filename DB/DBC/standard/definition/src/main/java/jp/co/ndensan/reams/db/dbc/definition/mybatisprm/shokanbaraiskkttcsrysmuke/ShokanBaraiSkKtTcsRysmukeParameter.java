/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanbaraiskkttcsrysmuke;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 償還払い支給（不支給）決定通知書（利用者向け）に対するMapperパラメータ
 *
 * @reamsid_L DBC-1000-050 chengsanyuan
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShokanBaraiSkKtTcsRysmukeParameter {

    private final HihokenshaNo 被保険者番号;
    private final RString 支給申請償還整理番号;
    private final FlexibleYearMonth 支給申請サービス提供年月;

    private ShokanBaraiSkKtTcsRysmukeParameter(
            HihokenshaNo 被保険者番号,
            RString 支給申請償還整理番号,
            FlexibleYearMonth 支給申請サービス提供年月) {
        this.被保険者番号 = 被保険者番号;
        this.支給申請償還整理番号 = 支給申請償還整理番号;
        this.支給申請サービス提供年月 = 支給申請サービス提供年月;
    }

    /**
     * 受任者情報を取得するパラメータ作成
     *
     * @param 被保険者番号 被保険者番号
     * @param 支給申請償還整理番号 支給申請償還整理番号
     * @param 支給申請サービス提供年月 支給申請サービス提供年月
     * @return ShokanBaraiSkKtTcsRysmukeParameter
     */
    public static ShokanBaraiSkKtTcsRysmukeParameter createParameter(
            HihokenshaNo 被保険者番号,
            RString 支給申請償還整理番号,
            FlexibleYearMonth 支給申請サービス提供年月) {
        return new ShokanBaraiSkKtTcsRysmukeParameter(被保険者番号, 支給申請償還整理番号, 支給申請サービス提供年月);
    }
}
