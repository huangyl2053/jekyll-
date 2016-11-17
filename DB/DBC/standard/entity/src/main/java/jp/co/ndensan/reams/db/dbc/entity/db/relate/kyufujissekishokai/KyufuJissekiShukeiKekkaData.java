/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekishokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 集計データEntityクラスです。
 *
 * @reamsid_L DBC-2970-010 wangjie2
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuJissekiShukeiKekkaData {

    private FlexibleYearMonth serviceTeikyoYM;
    private ServiceShuruiCode serviceSyuruiCode;
    private Decimal tanisu;
    private Decimal dekidakaTanisu;
    private Decimal seikyugaku;
    private Decimal riyoshaFutangaku;

}
