/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 高額合算自己負担額明細一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2640-011 qinzhen
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity
        extends DbTableEntityBase<DbWT37H2KogakuGassanaJikofutangakuMeisaiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private HihokenshaNo hokenshaNoIn;
    @TempTableColumnOrder(3)
    private FlexibleYear taishoNendo;
    @TempTableColumnOrder(4)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(5)
    private RString shikyuShinseishoSeiriNo;
    @TempTableColumnOrder(6)
    private int rirekiNo;
    @TempTableColumnOrder(7)
    private RString taishoM;
    @TempTableColumnOrder(8)
    private Decimal jikoFutanGaku;
    @TempTableColumnOrder(9)
    private Decimal uchisu_70_74JikoFutanGaku;
    @TempTableColumnOrder(10)
    private Decimal under_70KogakuShikyuGaku;
    @TempTableColumnOrder(11)
    private Decimal over_70_74KogakuShikyuGaku;
    @TempTableColumnOrder(12)
    private RString tekiyo;
    @TempTableColumnOrder(13)
    private Decimal sumi_JikoFutanGaku;
    @TempTableColumnOrder(14)
    private Decimal sumi_70_74JikoFutanGaku;
    @TempTableColumnOrder(15)
    private Decimal sumi_under_70KogakuShikyuGaku;
    @TempTableColumnOrder(16)
    private Decimal sumi_70_74KogakuShikyuGaku;
    @TempTableColumnOrder(17)
    private RString sumi_Tekiyo;
    @TempTableColumnOrder(18)
    private Boolean jikoFutangakuSaiFlag;

}
