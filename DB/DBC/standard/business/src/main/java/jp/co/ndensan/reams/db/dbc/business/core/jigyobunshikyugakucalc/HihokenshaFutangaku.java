/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.jigyobunshikyugakucalc;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc020070.ShikyugakuCalcTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 計算用明細データクラスです。
 *
 * @reamsid_L DBC-4830-030 zhujun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaFutangaku {

    private HihokenshaNo 明細被保険者番号;
    private HokenshaNo 明細保険者番号;
    private RString 明細番号;
    private Decimal 負担額_70歳以上;
    private Decimal 按分率_70歳以上;
    private Decimal 支給額_70歳以上;
    private Decimal 負担額_70歳未満;
    private Decimal 負担額;
    private Decimal 按分率;
    private Decimal 支給額_70歳未満;
    private Decimal 支給額;

    private Decimal 負担額_70歳以上_合計;

    private ShikyugakuCalcTempEntity 計算結果明細;
    private ShikyugakuCalcTempEntity 証明書;
    private ShikyugakuCalcTempEntity 自己負担額;
}
