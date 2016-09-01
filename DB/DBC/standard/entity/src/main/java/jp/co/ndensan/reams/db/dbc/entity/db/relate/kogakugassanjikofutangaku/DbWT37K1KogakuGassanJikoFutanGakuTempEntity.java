/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
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

/**
 * 高額合算自己負担額一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBC-2660-030 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class DbWT37K1KogakuGassanJikoFutanGakuTempEntity extends
        DbTableEntityBase<DbWT37K1KogakuGassanJikoFutanGakuTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    @PrimaryKey
    private int renban;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private FlexibleYear taishoNendo;
    @TempTableColumnOrder(4)
    private HokenshaNo hokenshaNo;
    @TempTableColumnOrder(5)
    private RString shikyuShinseishoSeiriNo;
    @TempTableColumnOrder(6)
    private int rirekiNo;
    @TempTableColumnOrder(7)
    private RString hokenSeidoCode;
    @TempTableColumnOrder(8)
    private RString hokenshaMei;
    @TempTableColumnOrder(9)
    private RString kokuho_HihokenshaShoKigo;
    @TempTableColumnOrder(10)
    private AtenaKanaMeisho hihokenshaShimeiKana;
    @TempTableColumnOrder(11)
    private AtenaMeisho hihokenshaShimei;
    @TempTableColumnOrder(12)
    private FlexibleDate umareYMD;
    @TempTableColumnOrder(13)
    private Code seibetsuCode;
    @TempTableColumnOrder(14)
    private RString shotokuKubun;
    @TempTableColumnOrder(15)
    private RString over70_ShotokuKubun;
    @TempTableColumnOrder(16)
    private RString jikoFutanSeiriNo;
    @TempTableColumnOrder(17)
    private RString koki_HokenshaNo;
    @TempTableColumnOrder(18)
    private RString koki_HihokenshaNo;
    @TempTableColumnOrder(19)
    private RString kokuho_HokenshaNo;
    @TempTableColumnOrder(20)
    private RString kokuho_HihokenshaShoNo;
    @TempTableColumnOrder(21)
    private RString kokuho_KojinNo;
    @TempTableColumnOrder(22)
    private RString idoKubun;
    @TempTableColumnOrder(23)
    private RString hoseiZumiSofuKubun;
    @TempTableColumnOrder(24)
    private FlexibleDate taishoKeisanKaishiYMD;
    @TempTableColumnOrder(25)
    private FlexibleDate taishoKeisanShuryoYMD;
    @TempTableColumnOrder(26)
    private FlexibleDate hihokenshaKaishiYMD;
    @TempTableColumnOrder(27)
    private FlexibleDate hihokenshaShuryoYMD;
    @TempTableColumnOrder(28)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(29)
    private Decimal gokei_JikoFutanGaku;
    @TempTableColumnOrder(30)
    private Decimal gokei_70_74JikoFutanGaku;
    @TempTableColumnOrder(31)
    private Decimal gokei_Under70KogakuShikyuGaku;
    @TempTableColumnOrder(32)
    private Decimal gokei_70_74KogakuShikyuGaku;
    @TempTableColumnOrder(33)
    private Decimal sumi_Gokei_JikoFutanGaku;
    @TempTableColumnOrder(34)
    private Decimal sumi_Gokei_70_74JikoFutanGaku;
    @TempTableColumnOrder(35)
    private Decimal sumi_Gokei_Under70KogakuShikyuGaku;
    @TempTableColumnOrder(36)
    private Decimal sumi_Gokei_70_74KogakuShikyuGaku;
    @TempTableColumnOrder(37)
    private AtenaMeisho atesakiShimei;
    @TempTableColumnOrder(38)
    private YubinNo atesakiYubinNo;
    @TempTableColumnOrder(39)
    private RString atesakiJusho;
    @TempTableColumnOrder(40)
    private RString madoguchi_TaishoshaHanteiCode;
    @TempTableColumnOrder(41)
    private RString shiharaiBasho;
    @TempTableColumnOrder(42)
    private FlexibleDate shikaraiKaishiYMD;
    @TempTableColumnOrder(43)
    private FlexibleDate shiharaiShuryoYMD;
    @TempTableColumnOrder(44)
    private RString heichoNaiyo;
    @TempTableColumnOrder(45)
    private RString shiharaiKaishiTime;
    @TempTableColumnOrder(46)
    private RString shiharaiShuryoTime;
    @TempTableColumnOrder(47)
    private RString biko;
    @TempTableColumnOrder(48)
    private RString dataSakuseiKubun;
    @TempTableColumnOrder(49)
    private FlexibleYearMonth kakunin_UketoriYM;
    @TempTableColumnOrder(50)
    private FlexibleYearMonth hoseiZumi_SofuYM;
    @TempTableColumnOrder(51)
    private FlexibleYearMonth shomeisho_UketoriYM;
    @TempTableColumnOrder(52)
    private RString saisoFlag;
    @TempTableColumnOrder(53)
    private RString sofuTaishoGaiFlag;
    @TempTableColumnOrder(54)
    private FlexibleDate jikoFutanKeisanYMD;
    @TempTableColumnOrder(55)
    private FlexibleDate shomeiShoSakuseiYMD;
    @TempTableColumnOrder(56)
    private RString koki_KokuhoShoriKubun;
    @TempTableColumnOrder(57)
    private RString jikoFutangakuShomeishoRealHakkoFlag;
    @TempTableColumnOrder(58)
    private FlexibleDate batchHoseiJissiYMD;
    @TempTableColumnOrder(59)
    private FlexibleDate realHoseiJissiYMD;
    @TempTableColumnOrder(60)
    private HokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(61)
    private boolean sofuJogaiFlag;

}
