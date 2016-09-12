/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kogakushokaitaishoshakensaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費一覧EntityResult
 *
 * @reamsid_L DBC-3000-060 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuShokaiTaishoshaKensakuResultEntity {

    private HihokenshaNo 被保険者番号;
    private IShikibetsuTaisho 識別対象;
    private FlexibleYearMonth サービス提供年月;
    private Decimal 高額支給額;
    private FlexibleDate 申請年月日;
    private FlexibleDate 決定年月日;
    private RString 支給区分コード;
    private Decimal 支給金額;
    private boolean 自動償還対象フラグ;
    private Decimal 履歴番号;
    private HokenshaNo 証記載保険者番号;

}
