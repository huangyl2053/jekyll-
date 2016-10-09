/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040031;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額支給額集計処理データentityクラスです。
 *
 * @reamsid_L DBC-2320-050 yuanzhenxia
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakugassanJikofutangakuInfoHoseiSubEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private HokenshaNo 証記載保険者番号;
    private Decimal 履歴番号;
    private Decimal 合計高額支給額;
    private RString 結果支給区分コード;
    private Decimal 支給金額;
    private RString 審査支払区分;
    private RString 決定支給区分コード;
    private Decimal 決定高額支給額;
    private HokenshaNo 中間DB証記載保険者番号;
    private FlexibleYear 中間DB対象年度;

}
