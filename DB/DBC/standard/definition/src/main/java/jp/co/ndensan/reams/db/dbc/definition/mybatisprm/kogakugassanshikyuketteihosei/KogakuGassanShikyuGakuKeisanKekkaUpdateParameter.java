/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanshikyuketteihosei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBCMN62004_DBCMNN1005_支給決定情報補正（単）(事業分兼)
 *
 * @reamsid_L DBC-2290-030 quxiaodong
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanShikyuGakuKeisanKekkaUpdateParameter {

    private KokanShikibetsuNo 交換情報識別番号;
    private HihokenshaNo 被保険者番号;
    private RString 支給申請書整理番号;
    private RString 整理番号;
    private RString 自己負担額証明書整理番号;
    private RString 給付実績作成区分コード;
    private HokenshaNo 証記載保険者番号;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private Decimal 自己負担総額;
    private Decimal 支給額;
    private boolean flag;

}
