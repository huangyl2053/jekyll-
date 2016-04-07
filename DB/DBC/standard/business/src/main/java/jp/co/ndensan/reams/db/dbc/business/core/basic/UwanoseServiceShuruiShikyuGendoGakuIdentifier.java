/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Value;

/**
 * 上乗せサービス種類支給限度額の識別子です。
 */
@Value
@SuppressWarnings("PMD.UnusedPrivateField")
public class UwanoseServiceShuruiShikyuGendoGakuIdentifier implements Serializable {

    private final ServiceShuruiCode サービス種類コード;
    private final RString 要介護状態区分;
    private final FlexibleYearMonth 適用開始年月;
    private final int 履歴番号;

    /**
     * コンストラクタです。
     *
     * @param サービス種類コード サービス種類コード
     * @param 要介護状態区分 要介護状態区分
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public UwanoseServiceShuruiShikyuGendoGakuIdentifier(ServiceShuruiCode サービス種類コード,
            RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        this.サービス種類コード = サービス種類コード;
        this.要介護状態区分 = 要介護状態区分;
        this.適用開始年月 = 適用開始年月;
        this.履歴番号 = 履歴番号;
    }
}
