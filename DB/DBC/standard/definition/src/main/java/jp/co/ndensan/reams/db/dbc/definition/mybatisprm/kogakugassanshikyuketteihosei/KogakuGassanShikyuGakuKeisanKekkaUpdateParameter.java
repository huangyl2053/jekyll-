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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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

    private KokanShikibetsuNo 更新前交換情報識別番号;
    private KokanShikibetsuNo 更新後交換情報識別番号;
    private HihokenshaNo 更新前被保険者番号;
    private HihokenshaNo 更新後被保険者番号;
    private RString 更新前支給申請書整理番号;
    private RString 更新後支給申請書整理番号;
    private RString 更新前整理番号;
    private RString 更新後整理番号;
    private RString 更新前自己負担額証明書整理番号;
    private RString 更新後自己負担額証明書整理番号;
    private RString 更新前保険制度コード;
    private RString 更新後保険制度コード;
    private RString 更新前給付実績作成区分コード;
    private RString 更新後給付実績作成区分コード;
    private HokenshaNo 更新前証記載保険者番号;
    private HokenshaNo 更新後証記載保険者番号;
    private RString 更新前国保_被保険者証記号;
    private RString 更新後国保_被保険者証記号;
    private FlexibleDate 更新前申請年月日;
    private FlexibleDate 更新後申請年月日;
    private FlexibleDate 更新前決定年月日;
    private FlexibleDate 更新後決定年月日;
    private Decimal 更新前自己負担総額;
    private Decimal 更新後自己負担総額;
    private Decimal 更新前支給額;
    private Decimal 更新後支給額;
    private FlexibleYearMonth 更新前処理年月;
    private FlexibleYearMonth 更新後処理年月;
    private FlexibleYearMonth 更新前受取年月;
    private FlexibleYearMonth 更新後受取年月;
    private FlexibleYearMonth 更新前送付年月;
    private FlexibleYearMonth 更新後送付年月;
    private RString 更新前データ区分;
    private RString 更新後データ区分;
    private RString loginId;
    private boolean 更新前論理削除;
    private boolean 更新後論理削除;
}
