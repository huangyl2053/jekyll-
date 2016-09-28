/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110060;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
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
 * 高額合算申請書一時TBL
 *
 * @reamsid_L DBC-2630-030 wangxue
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT3711KogakuGassanShinseishoTempEntity extends DbTableEntityBase<DbWT3711KogakuGassanShinseishoTempEntity>
        implements IDbAccessable {

    @PrimaryKey
    @TempTableColumnOrder(1)
    private int renban;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private FlexibleYear taishoNendo;
    @TempTableColumnOrder(4)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(5)
    private RString seiriNo;
    @TempTableColumnOrder(6)
    private Decimal rirekiNo;
    @TempTableColumnOrder(7)
    private RString shinseiJokyoKubun;
    @TempTableColumnOrder(8)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(9)
    private RString shikyuShinseishoSeiriNo;
    @TempTableColumnOrder(10)
    private RString kokuhoShikyuShinseishoSeiriNo;
    @TempTableColumnOrder(11)
    private RString shikyuShinseiKubun;
    @TempTableColumnOrder(12)
    private FlexibleDate taishoKeisanKaishiYMD;
    @TempTableColumnOrder(13)
    private FlexibleDate taishoKeisanShuryoYMD;
    @TempTableColumnOrder(14)
    private RString shikyuShinseiKeitai;
    @TempTableColumnOrder(15)
    private RString jikoFutanKofuUmu;
    @TempTableColumnOrder(16)
    private AtenaMeisho shinseiDaihyoshaShimei;
    @TempTableColumnOrder(17)
    private YubinNo shinseiDaihyoshaYubinNo;
    @TempTableColumnOrder(18)
    private RString shinseiDaihyoshaJusho;
    @TempTableColumnOrder(19)
    private TelNo shinseiDaihyoshaTelNo;
    @TempTableColumnOrder(20)
    private RString shotokuKubun;
    @TempTableColumnOrder(21)
    private RString over70_ShotokuKubun;
    @TempTableColumnOrder(22)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(23)
    private RString shikakuSoshitsuJiyu;
    @TempTableColumnOrder(24)
    private FlexibleDate kanyuKaishiYMD;
    @TempTableColumnOrder(25)
    private FlexibleDate kanyuShuryoYMD;
    @TempTableColumnOrder(26)
    private RString kokuho_HokenshaNo;
    @TempTableColumnOrder(27)
    private RString kokuho_HokenshaMeisho;
    @TempTableColumnOrder(28)
    private RString kokuho_HihokenshaShoKigo;
    @TempTableColumnOrder(29)
    private RString kokuho_HihokenshaShoNo;
    @TempTableColumnOrder(30)
    private RString kokuho_SetaiNo;
    @TempTableColumnOrder(31)
    private RString kokuho_Zokugara;
    @TempTableColumnOrder(32)
    private FlexibleDate kokuho_KanyuKaishiYMD;
    @TempTableColumnOrder(33)
    private FlexibleDate kokuho_KanyuShuryoYMD;
    @TempTableColumnOrder(34)
    private RString koki_HokenshaNo;
    @TempTableColumnOrder(35)
    private RString koki_KoikiRengoMeisho;
    @TempTableColumnOrder(36)
    private RString koki_HihokenshaNo;
    @TempTableColumnOrder(37)
    private FlexibleDate koki_KanyuKaishiYMD;
    @TempTableColumnOrder(38)
    private FlexibleDate koki_KanyuShuryoYMD;
    @TempTableColumnOrder(39)
    private RString shiharaiHohoKubun;
    @TempTableColumnOrder(40)
    private RString shiharaiBasho;
    @TempTableColumnOrder(41)
    private FlexibleDate shiharaiKaishiYMD;
    @TempTableColumnOrder(42)
    private FlexibleDate shiharaiShuryoYMD;
    @TempTableColumnOrder(43)
    private RString heichoNaiyo;
    @TempTableColumnOrder(44)
    private RString shiharaiKaishiTime;
    @TempTableColumnOrder(45)
    private RString shiharaiShuryoTime;
    @TempTableColumnOrder(46)
    private long kozaID;
    @TempTableColumnOrder(47)
    private RString biko;
    @TempTableColumnOrder(48)
    private FlexibleYearMonth shikyuShinseisho_SofuYM;
    @TempTableColumnOrder(49)
    private RString saiSofuFlag;
    @TempTableColumnOrder(50)
    private FlexibleYearMonth jikoFutan_KeisanYM;
    @TempTableColumnOrder(51)
    private RString saiKeisanKubun;
    @TempTableColumnOrder(52)
    private boolean sofuJogaiFlag;
    @TempTableColumnOrder(53)
    private boolean jufukuKubun;
    @TempTableColumnOrder(54)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(55)
    private RString shoKisaiHokenshaName;

}
