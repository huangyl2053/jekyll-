/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110090;

import jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout.DbWT1002KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 過誤申立一時TBLクラスです
 *
 * @reamsid_L DBC-2530-030 jiangwenkai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1731KagoMoshitateTempEntity extends DbTableEntityBase<DbWT1002KokuhorenSakuseiErrorTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private JigyoshaNo jigyoshaNo;
    @TempTableColumnOrder(3)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(5)
    private int rirekiNo;
    @TempTableColumnOrder(6)
    private FlexibleDate moshitateYMD;
    @TempTableColumnOrder(7)
    private RString moshitateshaKubunCode;
    @TempTableColumnOrder(8)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(9)
    private RString moshitateJiyuCode;
    @TempTableColumnOrder(10)
    private FlexibleYearMonth kokuhorenSofuYM;
    @TempTableColumnOrder(11)
    private boolean kokuhirenSaiSofuAriFlag;
    @TempTableColumnOrder(12)
    private boolean dogetsuShinsaAriFlag;
    @TempTableColumnOrder(13)
    private RString moshitateshoKubunCode;
    @TempTableColumnOrder(14)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(15)
    private RString hokenshaName;
    @TempTableColumnOrder(16)
    private RString jigyoshaName;
    @TempTableColumnOrder(17)
    private RString shoKisaiHokenshaName;
    @TempTableColumnOrder(18)
    private boolean sofuJogaiFlag;
}
