/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.seikyugakutsuchishofutanshain;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 請求額通知書一時TBLテーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2790-011 hemin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT1511SeikyugakuTsuchishoTempEntity extends DbTableEntityBase<DbWT1511SeikyugakuTsuchishoTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private ShoKisaiHokenshaNo hokenshaNo;
    @TempTableColumnOrder(3)
    private RString hokenshaName;
    @TempTableColumnOrder(4)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(5)
    private RString shoKisaiHokenshaName;
    @TempTableColumnOrder(6)
    private RString kohiFutanshaNo;
    @TempTableColumnOrder(7)
    private RString kohiFutanshaName;
    @TempTableColumnOrder(8)
    private RString kanCode;
    @TempTableColumnOrder(9)
    private RString kanName;
    @TempTableColumnOrder(10)
    private RString kouCode;
    @TempTableColumnOrder(11)
    private RString kouName;
    @TempTableColumnOrder(12)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(13)
    private RString kokuhorenName;
    @TempTableColumnOrder(14)
    private RString mokuCode;
    @TempTableColumnOrder(15)
    private RString mokuName;
    @TempTableColumnOrder(16)
    private RString serviceShuruiCode;
    @TempTableColumnOrder(17)
    private RString serviceShuruiMei;
    @TempTableColumnOrder(18)
    private Decimal t_Kensu;
    @TempTableColumnOrder(19)
    private Decimal t_JitsuNissu;
    @TempTableColumnOrder(20)
    private Decimal t_Tanisu;
    @TempTableColumnOrder(21)
    private Decimal t_Kingaku;
    @TempTableColumnOrder(22)
    private Decimal s_Kensu;
    @TempTableColumnOrder(23)
    private Decimal s_Tanisu;
    @TempTableColumnOrder(24)
    private Decimal s_Choseigaku;
    @TempTableColumnOrder(25)
    private Decimal kaigokyufuSogojigyohi;
    @TempTableColumnOrder(26)
    private Decimal riyoshaFutangaku;
    @TempTableColumnOrder(27)
    private Decimal kohiFutangaku;
    @TempTableColumnOrder(28)
    private RString gokeiChohyoRecordShubetsu;
    @TempTableColumnOrder(29)
    private Decimal t_GokeiKensu;
    @TempTableColumnOrder(30)
    private Decimal t_GokeiTanisu;
    @TempTableColumnOrder(31)
    private Decimal t_GokeiKingaku;
    @TempTableColumnOrder(32)
    private Decimal s_GokeiKensu;
    @TempTableColumnOrder(33)
    private Decimal s_GokeiTanisu;
    @TempTableColumnOrder(34)
    private Decimal s_GokeiChoseigaku;
    @TempTableColumnOrder(35)
    private Decimal gokeiKaigokyufuSogojigyohi;
    @TempTableColumnOrder(36)
    private Decimal gokeiRiyoshaFutangaku;
    @TempTableColumnOrder(37)
    private Decimal gokeiKohiFutangaku;
    @TempTableColumnOrder(38)
    private RString ruisekiChohyoRecordShubetsu;
    @TempTableColumnOrder(39)
    private Decimal t_RuisekiKensu;
    @TempTableColumnOrder(40)
    private Decimal t_RuisekiTanisu;
    @TempTableColumnOrder(41)
    private Decimal t_RuisekiKingaku;
    @TempTableColumnOrder(42)
    private Decimal s_RuisekiKensu;
    @TempTableColumnOrder(43)
    private Decimal s_RuisekiTanisu;
    @TempTableColumnOrder(44)
    private Decimal s_RuisekiChoseigaku;
    @TempTableColumnOrder(45)
    private Decimal ruisekiKaigokyufuSogojigyohi;
    @TempTableColumnOrder(46)
    private Decimal ruisekiRiyoshaFutangaku;
    @TempTableColumnOrder(47)
    private Decimal ruisekiKohiFutangaku;
    @TempTableColumnOrder(48)
    private RString tesuryoChohyoRecordShubetsu;
    @TempTableColumnOrder(49)
    private Decimal tesuryoSeikyugaku;
    @TempTableColumnOrder(50)
    private Decimal tesuiryoRuisekiSeikyugaku;
}
