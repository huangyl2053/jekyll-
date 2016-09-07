/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitateshoout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 再審査申立一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2540-030 liuhui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT1741SaishinsaMoshitateEntity extends DbTableEntityBase<DbWT1741SaishinsaMoshitateEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(3)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(4)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(5)
    private ServiceShuruiCode serviceTeikyoShuruiCode;
    @TempTableColumnOrder(6)
    private ServiceKomokuCode serviceKomokuCode;
    @TempTableColumnOrder(7)
    private int rirekiNo;
    @TempTableColumnOrder(8)
    private FlexibleDate moshitateYMD;
    @TempTableColumnOrder(9)
    private RString moshitateshaKubunCode;
    @TempTableColumnOrder(10)
    private ShoKisaiHokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(11)
    private int moshitateTanisu;
    @TempTableColumnOrder(12)
    private RString moshitateJiyuCode;
    @TempTableColumnOrder(13)
    private FlexibleYearMonth kokuhorenSofuYM;
    @TempTableColumnOrder(14)
    private boolean kokuhirenSaiSofuAriFlag;
    @TempTableColumnOrder(15)
    private RString biko;
    @TempTableColumnOrder(16)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(17)
    private RString hokenshaName;
    @TempTableColumnOrder(18)
    private RString shokisaiHokenshaName;
    @TempTableColumnOrder(19)
    private RString jigyoshaName;
    @TempTableColumnOrder(20)
    private RString serviceMeisho;
    @TempTableColumnOrder(21)
    private boolean sofuJogaiFlag;

}
