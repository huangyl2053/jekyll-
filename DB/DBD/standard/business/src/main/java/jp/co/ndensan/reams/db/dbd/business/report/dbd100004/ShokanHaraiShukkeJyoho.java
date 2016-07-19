/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd100004;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払集計情報のクラス
 *
 * @author b_liuyang2
 */
@lombok.Getter
@lombok.Setter
public class ShokanHaraiShukkeJyoho {

    private FlexibleYearMonth サービス提供年月;
    private RString サービス種類コード;
    private Decimal 支払金額;

}
