/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kubunshikyugendogaku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 区分支給限度額一覧dataです。
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KubunShikyuGendogakuData {

    private FlexibleYearMonth tekiyoKaishiYM;
    private FlexibleYearMonth tekiyoShuryoYM;
    private RString tableKubun;
    private Decimal yokaigo1ShikyuGendogaku;
    private Decimal yokaigo2ShikyuGendogaku;
    private Decimal yokaigo3ShikyuGendogaku;
    private Decimal yokaigo4ShikyuGendogaku;
    private Decimal yokaigo5ShikyuGendogaku;
    private Decimal keikaKaigoShikyuGendogaku;
    private Decimal yoshien1ShikyuGendogaku;
    private Decimal yoshien2ShikyuGendogaku;
    private RString hdnSaishinFlag;
}
