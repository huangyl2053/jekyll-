/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.shokanfukushiyoguhanbaihi;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 福祉用具購入費支給申請一括審査・決定Entityクラスです。
 *
 * @author chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShokanShinseiEntity {

    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString seiriNp;
    private JigyoshaNo jigyoshaNo;
    private RString yoshikiNo;
    private RString meisaiNo;
    private RString 氏名;
    private FlexibleDate shinseiYMD;
    private Decimal hokenKyufugaku;
    private Decimal hokenTaishoHiyogaku;
    private Decimal riyoshaFutangaku;
    private Decimal shiharaiKingakuTotal;
    private RString shinsaKekka;
    private HokenshaNo shoKisaiHokenshaNo;

}
