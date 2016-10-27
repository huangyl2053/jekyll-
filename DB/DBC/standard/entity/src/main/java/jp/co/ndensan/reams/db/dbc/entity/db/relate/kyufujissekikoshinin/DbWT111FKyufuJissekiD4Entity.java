/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekikoshinin;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 給付実績D4一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2440-010 zhangrui
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT111FKyufuJissekiD4Entity extends DbTableEntityBase<DbWT111FKyufuJissekiD4Entity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private RString recordNo;
    @TempTableColumnOrder(3)
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @TempTableColumnOrder(4)
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @TempTableColumnOrder(5)
    private RString recodeShubetsuCode;
    @TempTableColumnOrder(6)
    private HokenshaNo shokisaiHokenshaNo;
    @TempTableColumnOrder(7)
    private HihokenshaNo hiHokenshaNo;
    @TempTableColumnOrder(8)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(9)
    private JigyoshaNo jigyoshoNo;
    @TempTableColumnOrder(10)
    private RString toshiNo;
    @TempTableColumnOrder(11)
    private int kihonTeikyoNissu;
    @TempTableColumnOrder(12)
    private int kihonTeikyoTanka;
    @TempTableColumnOrder(13)
    private int kihonTeikyoKingaku;
    @TempTableColumnOrder(14)
    private int tokubestuTeikyoNissu;
    @TempTableColumnOrder(15)
    private int tokubestuTeikyoTanka;
    @TempTableColumnOrder(16)
    private int tokubestuTeikyoKingaku;
    @TempTableColumnOrder(17)
    private int syokujiTeikyoNissu;
    @TempTableColumnOrder(18)
    private int kohi1SyokujiTeikyoNissu;
    @TempTableColumnOrder(19)
    private int kohi2SyokujiTeikyoNissu;
    @TempTableColumnOrder(20)
    private int kohi3SyokujiTeikyoNissu;
    @TempTableColumnOrder(21)
    private int syokujiTeikyohiTotal;
    @TempTableColumnOrder(22)
    private int getsugakuHyojunFutanGaku;
    @TempTableColumnOrder(23)
    private int syokujiTeikyohiSeikyugaku;
    @TempTableColumnOrder(24)
    private int kohi1SyokujiTeikyohiSeikyugaku;
    @TempTableColumnOrder(25)
    private int kohi2SyokujiTeikyohiSeikyugaku;
    @TempTableColumnOrder(26)
    private int kohi3SyokujiTeikyohiSeikyugaku;
    @TempTableColumnOrder(27)
    private int nichigakuHyojunFutanGaku;
    @TempTableColumnOrder(28)
    private int atoKihonTeikyoTanka;
    @TempTableColumnOrder(29)
    private int atoTokubestuTeikyoTanka;
    @TempTableColumnOrder(30)
    private int atoSyokujiTeikyohiSeikyugaku;
    @TempTableColumnOrder(31)
    private int saishinsaKaisu;
    @TempTableColumnOrder(32)
    private int kagoKaisu;
    @TempTableColumnOrder(33)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(34)
    private RString seiriNo;
    @TempTableColumnOrder(35)
    private FlexibleYearMonth torikomiYM;
}
