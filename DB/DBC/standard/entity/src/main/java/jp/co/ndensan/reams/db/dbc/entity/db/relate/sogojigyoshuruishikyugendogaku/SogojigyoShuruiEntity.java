/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyoshuruishikyugendogaku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 総合事業種類情報Entityです。
 *
 * @reamsid_L DBC-3364-010 xuxin
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyoShuruiEntity {

    private FlexibleYearMonth 適用開始年月;
    private RString サービス種類略称;

    private FlexibleYearMonth 適用終了年月;
    private Decimal 要支援1;
    private Decimal 要支援2;
    private Decimal 二次予防;
}
