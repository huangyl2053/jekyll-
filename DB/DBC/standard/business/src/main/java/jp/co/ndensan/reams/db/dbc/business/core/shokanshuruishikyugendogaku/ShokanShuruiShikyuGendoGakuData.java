/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanshuruishikyugendogaku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還支給限度額一覧dataです。
 *
 * @reamsid_L DBC-3460-010 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShuruiShikyuGendoGakuData {

    private FlexibleYearMonth tekiyoKaishiYM;
    private FlexibleYearMonth tekiyoShuryoYM;
    private RString 区分;
    private Decimal 居宅介護_福祉用具;
    private Decimal 居宅介護_住宅改修;
    private Decimal 居宅支援_福祉用具;
    private Decimal 居宅支援_住宅改修;
    private int 最新フラグ;

}
