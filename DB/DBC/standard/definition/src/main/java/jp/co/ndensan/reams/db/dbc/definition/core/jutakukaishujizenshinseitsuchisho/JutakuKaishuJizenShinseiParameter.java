/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.core.jutakukaishujizenshinseitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 住宅改修事前申請データMyBatisパラメータクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JutakuKaishuJizenShinseiParameter {

    private HihokenshaNo 被保険者番号;
    private RString 被保険者氏名;
    private ShikibetsuCode 識別コード;
    private FlexibleDate 申請日;
    private RString 判定区分;
    private RString 承認条件;
    private RString 不承認理由;
    private FlexibleDate 発行日;
    private RString 事業者名;
    private FlexibleDate 承認年月日;
    private FlexibleDate 受付日;
    private RString 不承認の理由;
    private RString 給付の種類;
    private RString 作成者氏名;
    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;
    private Decimal 費用額合計;
    private Decimal 保険対象費用額;
    private Decimal 保険給付額;
    private Decimal 利用者負担額;
    private RString 住宅改修住宅住所;
}
