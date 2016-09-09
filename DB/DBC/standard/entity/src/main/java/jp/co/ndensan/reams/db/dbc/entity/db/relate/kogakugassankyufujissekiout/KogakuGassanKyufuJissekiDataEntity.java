/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassankyufujissekiout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 送付対象データ取得の高額合算給付実績データ。
 *
 * @reamsid_L DBC-2710-030 wangxue
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuGassanKyufuJissekiDataEntity {

    private KokanShikibetsuNo 交換情報識別番号;
    private HihokenshaNo 被保険者番号;
    private RString 支給申請書整理番号;
    private RString 整理番号;
    private RString 自己負担額証明書整理番号;
    private RString 保険制度コード;
    private RString 給付実績作成区分コード;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 国保_被保険者証記号;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private Decimal 自己負担総額;
    private Decimal 支給額;
    private FlexibleYearMonth 処理年月;
    private FlexibleYearMonth 受取年月;
    private FlexibleYearMonth 送付年月;
    private RString データ区分;
}
