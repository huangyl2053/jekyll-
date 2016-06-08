/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jyutakugaisyunaiyolist;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 住宅改修内容一覧のビジネスクラスです。
 *
 * @reamsid_L DBC-0940-010 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JyutakugaisyunaiyoListDataPassModel implements Serializable {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private RString 整理番号;
    private RString 様式番号;
    private ShikibetsuCode 識別コード;
    private RString 状態;
}
