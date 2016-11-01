/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110050;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * 償還払支給申請一時TBLのEntityです。
 *
 * @reamsid_L DBC-2570-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT2111ShokanShinseiTempEntity extends DbTableEntityBase<DbWT2111ShokanShinseiTempEntity>
        implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @PrimaryKey
    @TempTableColumnOrder(2)
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    @TempTableColumnOrder(3)
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    @TempTableColumnOrder(4)
    private RString seiriNo;
    @TempTableColumnOrder(5)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(6)
    private FlexibleDate uketsukeYMD;
    @TempTableColumnOrder(7)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(8)
    private RString shinseiRiyu;
    @TempTableColumnOrder(9)
    private RString shinseishaKubun;
    @TempTableColumnOrder(10)
    private RString shinseishaNameKanji;
    @TempTableColumnOrder(11)
    private RString shinseishaNameKana;
    @TempTableColumnOrder(12)
    private YubinNo shinseishaYubinNo;
    @TempTableColumnOrder(13)
    private RString shinseishaAddress;
    @TempTableColumnOrder(14)
    private TelNo shinseishaTelNo;
    @TempTableColumnOrder(15)
    private JigyoshaNo shinseiJigyoshaNo;
    @TempTableColumnOrder(16)
    private FlexibleDate riyushoSakuseiYMD;
    @TempTableColumnOrder(17)
    private RString riyushoSakuseishaName;
    @TempTableColumnOrder(18)
    private RString riyushoSakuseishaKanaName;
    @TempTableColumnOrder(19)
    private JigyoshaNo riyushoSakuseiJigyoshaNo;
    @TempTableColumnOrder(20)
    private Decimal shiharaiKingakuTotal;
    @TempTableColumnOrder(21)
    private Decimal hokenTaishoHiyogaku;
    @TempTableColumnOrder(22)
    private Decimal hokenKyufugaku;
    @TempTableColumnOrder(23)
    private Decimal riyoshaFutangaku;
    @TempTableColumnOrder(24)
    private RString shikyuShinseiShinsaKubun;
    @TempTableColumnOrder(25)
    private RString shinsaHohoKubun;
    @TempTableColumnOrder(26)
    private RString sofuKubun;
    @TempTableColumnOrder(27)
    private FlexibleYearMonth sofuYM;
    @TempTableColumnOrder(28)
    private boolean kokuhorenSaisofuFlag;
    @TempTableColumnOrder(29)
    private RString shiharaiHohoKubunCode;
    @TempTableColumnOrder(30)
    private RString shiharaiBasho;
    @TempTableColumnOrder(31)
    private FlexibleDate shiharaiKaishiYMD;
    @TempTableColumnOrder(32)
    private FlexibleDate shiharaiShuryoYMD;
    @TempTableColumnOrder(33)
    private RString shiharaiKaishiTime;
    @TempTableColumnOrder(34)
    private RString shiharaiShuryoTime;
    @TempTableColumnOrder(35)
    private long kozaID;
    @TempTableColumnOrder(36)
    private RString juryoininKeiyakuNo;
    @TempTableColumnOrder(37)
    private RString jutakuShoyusha;
    @TempTableColumnOrder(38)
    private RString hihokenshaKankei;
    @TempTableColumnOrder(39)
    private boolean yokaigo3DankaiHenko;
    @TempTableColumnOrder(40)
    private boolean jutakuJushoHenko;
    @TempTableColumnOrder(41)
    private FlexibleDate shinsaYMD;
    @TempTableColumnOrder(42)
    private RString shinsaKekka;
    @TempTableColumnOrder(43)
    private FlexibleYearMonth jizenServiceTeikyoYM;
    @TempTableColumnOrder(44)
    private RString jizenSeiriNo;
    @TempTableColumnOrder(45)
    private RString kaishuShinseiKubun;
    @TempTableColumnOrder(46)
    private RString kaishuShinseiTorikeshijiyuCode;
    @TempTableColumnOrder(47)
    private FlexibleDate ryoshuYMD;
    @TempTableColumnOrder(48)
    private boolean sofuJogaiFlag;
    @TempTableColumnOrder(49)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(50)
    private RString hokenshaName;
    @TempTableColumnOrder(51)
    private boolean jukyushaDaichoFlag;
    @TempTableColumnOrder(52)
    private boolean kyuSochishaFlag;
    @TempTableColumnOrder(53)
    private RString yokaigoJotaiKubunCode;
    @TempTableColumnOrder(54)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(55)
    private FlexibleDate ninteiYukoKikanShuryoYMD;

}
