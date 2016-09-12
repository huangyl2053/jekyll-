/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.dbc0030011;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費照会（対象者検索）の引き継ぎ情報です。
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServiceData implements Serializable {

    private static final long serialVersionUID = 1L;

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private Decimal 履歴番号;
    private HokenshaNo 証記載保険者番号;
    private ShikibetsuCode 識別コード;

}
