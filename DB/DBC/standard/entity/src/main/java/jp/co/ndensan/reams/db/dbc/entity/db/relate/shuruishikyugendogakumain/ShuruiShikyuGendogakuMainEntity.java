/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.shuruishikyugendogakumain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ShuruiShikyuGendogakuMainEntityクラスです。
 *
 * @reamsid_L DBC-3440-010 lihang
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShuruiShikyuGendogakuMainEntity {

    private FlexibleYearMonth 適用開始年月;
    private FlexibleYearMonth 適用終了年月;
    private ServiceShuruiCode サービス種類コード;
    private Decimal 要介護１支給限度額;
    private Decimal 要介護２支給限度額;
    private Decimal 要介護３支給限度額;
    private Decimal 要介護４支給限度額;
    private Decimal 要介護５支給限度額;
    private Decimal 経過介護支給限度額;
    private Decimal 要支援１支給限度額;
    private Decimal 要支援2支給限度額;

    /**
     * ShuruiShikyuGendogakuMainEntityのメソッドです。
     *
     * @param 適用終了年月 FlexibleYearMonth
     * @param サービス種類コード ServiceShuruiCode
     * @param 適用開始年月 FlexibleYearMonth
     * @param 要介護１支給限度額 Decimal
     * @param 要介護２支給限度額 Decimal
     * @param 要介護３支給限度額 Decimal
     * @param 要介護４支給限度額 Decimal
     * @param 要介護５支給限度額 Decimal
     * @param 経過介護支給限度額 Decimal
     * @param 要支援１支給限度額 Decimal
     * @param 要支援2支給限度額 Decimal
     */
    public ShuruiShikyuGendogakuMainEntity(FlexibleYearMonth 適用開始年月,
            FlexibleYearMonth 適用終了年月,
            ServiceShuruiCode サービス種類コード,
            Decimal 経過介護支給限度額,
            Decimal 要支援１支給限度額,
            Decimal 要支援2支給限度額,
            Decimal 要介護１支給限度額,
            Decimal 要介護２支給限度額,
            Decimal 要介護３支給限度額,
            Decimal 要介護４支給限度額,
            Decimal 要介護５支給限度額) {
        this.適用開始年月 = 適用開始年月;
        this.適用終了年月 = 適用終了年月;
        this.サービス種類コード = サービス種類コード;
        this.要介護１支給限度額 = 要介護１支給限度額;
        this.要介護２支給限度額 = 要介護２支給限度額;
        this.要介護３支給限度額 = 要介護３支給限度額;
        this.要介護４支給限度額 = 要介護４支給限度額;
        this.要介護５支給限度額 = 要介護５支給限度額;
        this.経過介護支給限度額 = 経過介護支給限度額;
        this.要支援１支給限度額 = 要支援１支給限度額;
        this.要支援2支給限度額 = 要支援2支給限度額;
    }
}
