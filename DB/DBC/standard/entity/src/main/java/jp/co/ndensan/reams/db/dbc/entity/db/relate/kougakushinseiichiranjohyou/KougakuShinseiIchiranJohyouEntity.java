/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kougakushinseiichiranjohyou;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * ビジネス設計_DBCKD00005_高額申請一覧共有子Div（画面）
 *
 * @reamsid_L DBC-2020-050 quxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KougakuShinseiIchiranJohyouEntity {

    private FlexibleYearMonth サービス年月;
    private RString 管理番号;
    private Decimal 利用者負担額合計;
    private Decimal 算定基準額;
    private Decimal 支払済額合計;
    private Decimal 高額支給額;
    private Decimal 決定支給額;
    private RString 支給区分;
    private FlexibleYearMonth 対象取込年月;
    private FlexibleYearMonth 判定送付年月;
    private FlexibleYearMonth 判定取込年月;
    private HokenshaNo 証記載番号;
    private FlexibleYearMonth 対象者判定審査年月;
    private FlexibleDate 決定年月日;
}
