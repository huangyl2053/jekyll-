/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shuruishikyugendogakumain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBC4210011_種類支給限度額登録のListParameterです。
 *
 * @reamsid_L DBC-3440-010 lihang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShuruiShikyuGendogakuMainListParameter {

    private FlexibleYearMonth 適用開始年月;
    private ServiceShuruiCode サービス種類コード;
    private RString 要介護状態区分;
    private int 履歴番号;

    /**
     * コンストラクタです
     *
     * @param 適用開始年月 FlexibleYearMonth
     * @param サービス種類コード ServiceShuruiCode
     * @param 要介護状態区分 RString
     * @param 履歴番号 int
     */
    public ShuruiShikyuGendogakuMainListParameter(FlexibleYearMonth 適用開始年月,
            ServiceShuruiCode サービス種類コード, RString 要介護状態区分, int 履歴番号) {

        this.適用開始年月 = 適用開始年月;
        this.サービス種類コード = サービス種類コード;
        this.要介護状態区分 = 要介護状態区分;
        this.履歴番号 = 履歴番号;
    }
}
