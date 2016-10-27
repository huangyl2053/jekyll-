/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakucalc;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 事業分支給額計算クラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JigyobunShikyugakuCalcResult {

    private HihokenshaNo 被保険者番号;
    private FlexibleYear 対象年度;
    private HokenshaNo 証記載保険者番号;
    private RString 支給申請書整理番号;
    private Decimal 算定基準額;
    private Decimal 算定基準額_70以上;
    private Decimal 支給額;
    private Decimal 支給額_70以上;

    private List<HihokenshaFutangaku> 支給額明細List;
    private List<HihokenshaFutangaku> 事業高額合算List;
    private List<HihokenshaFutangaku> 転入前事業高額合算List;

}
