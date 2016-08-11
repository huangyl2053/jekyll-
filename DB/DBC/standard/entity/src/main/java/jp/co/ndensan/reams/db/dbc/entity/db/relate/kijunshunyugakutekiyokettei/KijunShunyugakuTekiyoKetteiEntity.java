/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kijunshunyugakutekiyokettei;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 基準収入額適用管理entityクラスです。
 *
 * @reamsid_L DBC-4610-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijunShunyugakuTekiyoKetteiEntity implements Serializable {

    private SetaiCode 世帯コード;
    private FlexibleYear 年度;
    private int 履歴番号;
    private HihokenshaNo 被保険者番号;
    private Decimal 算定基準額;
    private FlexibleYearMonth 適用開始年月;
    private FlexibleDate 申請日;
    private FlexibleDate 決定日;
    private ShikibetsuCode 識別コード;
    private boolean 宛先印字対象者フラグ;
}
