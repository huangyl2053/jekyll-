/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc150030;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 統計表明細一時
 *
 * @reamsid_L DBC-3340-030 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3470ToukeihyoMeisaiTempEntity
        extends DbTableEntityBase<DbWT3470ToukeihyoMeisaiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(3)
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(5)
    private RString jigyoshoNo;
    @TempTableColumnOrder(6)
    private RString toshiNo;
    @TempTableColumnOrder(7)
    private RString yoKaigoJotaiKubunCode;
    @TempTableColumnOrder(8)
    private ServiceShuruiCode serviceShuruiCode;
    @TempTableColumnOrder(9)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(10)
    private Decimal taniSu;
    @TempTableColumnOrder(11)
    private Decimal nissuKaisu;
    @TempTableColumnOrder(12)
    private Decimal serviceTanisu;
    @TempTableColumnOrder(13)
    private ServiceShuruiCode sortYouShuruiCode;
    @TempTableColumnOrder(14)
    private ServiceKomokuCode sortYouKomokuCode;
    @TempTableColumnOrder(15)
    private RString sortYouKomokuName;
    @TempTableColumnOrder(16)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(17)
    private RString koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(18)
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    @TempTableColumnOrder(19)
    private LasdecCode kyuShichosonCode;
    @TempTableColumnOrder(20)
    private ChoikiCode machiikiCode;
    @TempTableColumnOrder(21)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(22)
    private RString chikuCode1;
    @TempTableColumnOrder(23)
    private RString chikuCode2;
    @TempTableColumnOrder(24)
    private RString chikuCode3;
}
