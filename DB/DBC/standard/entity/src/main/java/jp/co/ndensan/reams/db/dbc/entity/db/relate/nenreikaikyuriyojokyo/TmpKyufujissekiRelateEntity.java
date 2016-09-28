/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.nenreikaikyuriyojokyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績データ一時デーブルクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class TmpKyufujissekiRelateEntity implements IDbAccessable {

    @TempTableColumnOrder(1)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(2)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(3)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(4)
    private FlexibleDate umareYMD;
    @TempTableColumnOrder(5)
    private ServiceShuruiCode serviceSyuruiCode;
    @TempTableColumnOrder(6)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(7)
    private AtenaMeisho meisho;
}
