/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 再審査決定通知書情報取込（保険者分）一時テーブル（明細）Entity
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaInMeisaiEntity
        extends DbTableEntityBase<SaishinsaKetteiHokenshaInMeisaiEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private FlexibleYearMonth toriatsukaiYM;
    @TempTableColumnOrder(2)
    private int rirekiNo;
    @TempTableColumnOrder(3)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(4)
    private RString jigyoshoName;
    @TempTableColumnOrder(5)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(6)
    private RString hiHokenshaName;
    @TempTableColumnOrder(7)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(8)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(9)
    private RString serviceShuruiName;
    @TempTableColumnOrder(10)
    private RString moushitateJiyuCode;
    @TempTableColumnOrder(11)
    private RString moushitateJiyu;
    @TempTableColumnOrder(12)
    private RString saishinsaResultCode;
    @TempTableColumnOrder(13)
    private Decimal toshoSeikyuTanisu;
    @TempTableColumnOrder(14)
    private Decimal genshinSeikyuTanisu;
    @TempTableColumnOrder(15)
    private Decimal moushitateTanisu;
    @TempTableColumnOrder(16)
    private Decimal ketteiTanisu;
    @TempTableColumnOrder(17)
    private Decimal choseiTanisu;
    @TempTableColumnOrder(18)
    private Decimal hokenshaFutangaku;
    @TempTableColumnOrder(19)
    private ShikibetsuCode shikibetsuCode;

}
