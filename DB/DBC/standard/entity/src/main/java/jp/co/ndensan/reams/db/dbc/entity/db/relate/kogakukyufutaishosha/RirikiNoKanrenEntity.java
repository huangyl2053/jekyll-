/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;

/**
 * 最大履歴番号関連したエンティティ。
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class RirikiNoKanrenEntity {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth サービス提供年月;
    private int 履歴番号;

}
