/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 共同処理用受給者異動情報の共通項目Entity
 *
 * @reamsid_L DBC-1952-020 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyoutuuEntity implements Serializable {

    private HihokenshaNo 被保険者番号;
    private FlexibleYearMonth 対象年月;
    private FlexibleDate 異動年月日;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 異動区分;
    private RString 異動事由;
    private FlexibleDate 訂正年月日;
    private RString 訂正区分;
}
