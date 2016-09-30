/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc110070;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額合算支給額計算結果一時TBLです。
 *
 * @reamsid_L DBC-2670-030 zhaowei
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity
        extends DbTableEntityBase<DbWT3811KogakuGassanShikyuGakuKeisanKekkaTempEntity> implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;

    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private FlexibleYear taishoNendo;
    @TempTableColumnOrder(4)
    private HokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(5)
    private RString shikyuShinseishoSeiriNo;
    @TempTableColumnOrder(6)
    private int rirekiNo;
    @TempTableColumnOrder(7)
    private RString hokenSeidoCode;
    @TempTableColumnOrder(8)
    private RString jikoFutanSeiriNo;
    @TempTableColumnOrder(9)
    private FlexibleDate taishoKeisanKaishiYMD;
    @TempTableColumnOrder(10)
    private FlexibleDate taishoKeisanShuryoYMD;
    @TempTableColumnOrder(11)
    private Decimal setaiFutanSogaku;
    @TempTableColumnOrder(12)
    private Decimal setaiGassanGaku;
    @TempTableColumnOrder(13)
    private Decimal over70_SetaiGassanGaku;
    @TempTableColumnOrder(14)
    private RString shotokuKubun;
    @TempTableColumnOrder(15)
    private RString over70_ShotokuKubun;
    @TempTableColumnOrder(16)
    private Decimal santeiKijunGaku;
    @TempTableColumnOrder(17)
    private Decimal over70_SanteiKijyunGaku;
    @TempTableColumnOrder(18)
    private Decimal setaiShikyuSogaku;
    @TempTableColumnOrder(19)
    private Decimal over70_SetaiShikyuSogaku;
    @TempTableColumnOrder(20)
    private Decimal honninShikyugaku;
    @TempTableColumnOrder(21)
    private Decimal over70_honninShikyugaku;
    @TempTableColumnOrder(22)
    private RString teiShotoku_1_SaiKeisanUmu;
    @TempTableColumnOrder(23)
    private RString biko;
    @TempTableColumnOrder(24)
    private YubinNo kekkaRenrakusakiYubinNo;
    @TempTableColumnOrder(25)
    private RString kekkaRenrakusakiJusho;
    @TempTableColumnOrder(26)
    private RString ketteRenrakusakiMeisho1;
    @TempTableColumnOrder(27)
    private RString kekkaRenrakusakiMeisho2;
    @TempTableColumnOrder(28)
    private FlexibleDate tsuchiYMD;
    @TempTableColumnOrder(29)
    private AtenaMeisho renrakuhyoHakkoshaMei;
    @TempTableColumnOrder(30)
    private YubinNo renrakuhyoHakkoshaYubinNo;
    @TempTableColumnOrder(31)
    private RString renrakuhyoHakkoshaJusho;
    @TempTableColumnOrder(32)
    private YubinNo toiawasesakiYobinNo;
    @TempTableColumnOrder(33)
    private RString toiawasesakiJusho;
    @TempTableColumnOrder(34)
    private RString toiawasesakiMeisho1;
    @TempTableColumnOrder(35)
    private RString toiawasesakiMeisho2;
    @TempTableColumnOrder(36)
    private TelNo toiawasesakiTelNo;
    @TempTableColumnOrder(37)
    private Decimal over70_FutangakuGokei;
    @TempTableColumnOrder(38)
    private Decimal over70_ShikyugakuGokei;
    @TempTableColumnOrder(39)
    private Decimal under70_FutangakuGokei;
    @TempTableColumnOrder(40)
    private Decimal futangakuGokei;
    @TempTableColumnOrder(41)
    private Decimal under70_ShikyugakuGokei;
    @TempTableColumnOrder(42)
    private Decimal shikyugakuGokei;
    @TempTableColumnOrder(43)
    private RString dataKubun;
    @TempTableColumnOrder(44)
    private FlexibleYearMonth uketoriYM;
    @TempTableColumnOrder(45)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(46)
    private RString saisoFG;
    @TempTableColumnOrder(47)
    private FlexibleDate sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD;
    @TempTableColumnOrder(48)
    private boolean sofuJogaiFlag;

}
