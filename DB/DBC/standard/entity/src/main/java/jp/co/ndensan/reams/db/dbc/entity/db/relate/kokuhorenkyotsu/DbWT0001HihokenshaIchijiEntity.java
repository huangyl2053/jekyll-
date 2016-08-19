/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kokuhorenkyotsu;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 被保険者一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2450-030 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT0001HihokenshaIchijiEntity extends DbTableEntityBase<DbWT0001HihokenshaIchijiEntity>
        implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int meisaiRenban;
    @TempTableColumnOrder(2)
    private ShoKisaiHokenshaNo shoHokenshaNo;
    @TempTableColumnOrder(3)
    private HihokenshaNo orgHihokenshaNo;
    @TempTableColumnOrder(4)
    private FlexibleDate serviceTeikyoYmd;
    @TempTableColumnOrder(5)
    private RString orgHihokenshaKanaShimei;
    @TempTableColumnOrder(6)
    private RString orgHihokenshaShimei;
    @TempTableColumnOrder(7)
    private LasdecCode oldShichosonCode;
    @TempTableColumnOrder(8)
    private HihokenshaNo henkanHihokenshaNo;
    @TempTableColumnOrder(9)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(10)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(11)
    private RString KannaiKangaiKubun;
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
    private FlexibleDate shikakuShutokuYmd;
    @TempTableColumnOrder(24)
    private RString shikakuShutokuJiyuCode;
    @TempTableColumnOrder(25)
    private FlexibleDate shikakuSoshitsuYmd;
    @TempTableColumnOrder(26)
    private RString shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(27)
    private HihokenshaNo setaiShuyakuNo;
    @TempTableColumnOrder(22)
    private ShikibetsuCode shikibetsuCode;
}
