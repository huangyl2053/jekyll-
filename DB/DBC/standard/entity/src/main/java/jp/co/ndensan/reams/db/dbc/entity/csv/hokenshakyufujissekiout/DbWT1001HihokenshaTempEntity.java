/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.hokenshakyufujissekiout;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 被保険者一時TBL
 *
 * @reamsid_L DBC-2460-012 jiangwenkai
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT1001HihokenshaTempEntity extends DbTableEntityBase<DbWT1001HihokenshaTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int exRenban;

    @TempTableColumnOrder(2)
    private ShoKisaiHokenshaNo exHokenshaNo;
    @TempTableColumnOrder(3)
    private RString exHokenshaName;
    @TempTableColumnOrder(4)
    private ShoKisaiHokenshaNo exShoHokenshaNo;
    @TempTableColumnOrder(5)
    private HihokenshaNo exHihokenshaNo;
    @TempTableColumnOrder(6)
    private FlexibleDate exServiceTeikyoYm;
    @TempTableColumnOrder(7)
    private boolean henkanFlag;
    @TempTableColumnOrder(8)
    private LasdecCode oldShichosonCode;
    @TempTableColumnOrder(9)
    private HihokenshaNo sofuHihokenshaNo;
    @TempTableColumnOrder(10)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(11)
    private RString kannaiKangaiKubun;
    @TempTableColumnOrder(12)
    private RString yubinNo;
    @TempTableColumnOrder(13)
    private RString choikiCode;
    @TempTableColumnOrder(14)
    private RString gyoseikuCode;
    @TempTableColumnOrder(15)
    private RString gyoseikuMei;
    @TempTableColumnOrder(16)
    private RString jusho;
    @TempTableColumnOrder(17)
    private RString banchi;
    @TempTableColumnOrder(18)
    private RString katagaki;
    @TempTableColumnOrder(19)
    private RString kanaMeisho;
    @TempTableColumnOrder(20)
    private RString meisho;
    @TempTableColumnOrder(21)
    private RString shimei50onKana;
    @TempTableColumnOrder(22)
    private RString shikibetsuCode;
    @TempTableColumnOrder(23)
    private FlexibleDate shikakuShutokuYmd;
    @TempTableColumnOrder(24)
    private RString shikakuShutokuJiyuCode;
    @TempTableColumnOrder(25)
    private FlexibleDate shikakuSoshitsuYmd;
    @TempTableColumnOrder(26)
    private RString shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(27)
    private ShoKisaiHokenshaNo setaiShuyakuNo;
    @TempTableColumnOrder(28)
    private FlexibleDate seinenYmd;
    @TempTableColumnOrder(29)
    private RString seibetsuCode;
    @TempTableColumnOrder(30)
    private FlexibleDate shichosonKanyuYmd;
    @TempTableColumnOrder(31)
    private FlexibleDate shichosonDattaiYmd;

}
