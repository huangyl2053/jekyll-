/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 賦課の情報Temp
 *
 * @reamsid_L DBB-0700-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoTempEntity {

    @TempTableColumnOrder(1)
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(2)
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(3)
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(4)
    private int rirekiNo;
    @TempTableColumnOrder(5)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(6)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(7)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(8)
    private int setaiInsu;
    @TempTableColumnOrder(9)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(10)
    private RString shikakuShutokuJiyu;
    @TempTableColumnOrder(11)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(12)
    private RString shikakuSoshitsuJiyu;
    @TempTableColumnOrder(13)
    private RString seihofujoShurui;
    @TempTableColumnOrder(14)
    private FlexibleDate seihoKaishiYMD;
    @TempTableColumnOrder(15)
    private FlexibleDate seihoHaishiYMD;
    @TempTableColumnOrder(16)
    private FlexibleDate ronenKaishiYMD;
    @TempTableColumnOrder(17)
    private FlexibleDate ronenHaishiYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate fukaYMD;
    @TempTableColumnOrder(19)
    private RString kazeiKubun;
    @TempTableColumnOrder(20)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(21)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(22)
    private Decimal nenkinShunyuGaku;
    @TempTableColumnOrder(22)
    private RString hokenryoDankai;
    @TempTableColumnOrder(24)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(25)
    private Decimal nengakuHokenryo1;
    @TempTableColumnOrder(26)
    private FlexibleYearMonth tsukiwariStartYM1;
    @TempTableColumnOrder(27)
    private FlexibleYearMonth tsukiwariEndYM1;
    @TempTableColumnOrder(28)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(29)
    private Decimal nengakuHokenryo2;
    @TempTableColumnOrder(30)
    private FlexibleYearMonth tsukiwariStartYM2;
    @TempTableColumnOrder(31)
    private FlexibleYearMonth tsukiwariEndYM2;
    @TempTableColumnOrder(32)
    private YMDHMS choteiNichiji;
    @TempTableColumnOrder(33)
    private RString choteiJiyu1;
    @TempTableColumnOrder(34)
    private RString choteiJiyu2;
    @TempTableColumnOrder(35)
    private RString choteiJiyu3;
    @TempTableColumnOrder(36)
    private RString choteiJiyu4;
    @TempTableColumnOrder(37)
    private RString koseiM;
    @TempTableColumnOrder(38)
    private Decimal gemmenMaeHokenryo;
    @TempTableColumnOrder(39)
    private Decimal gemmenGaku;
    @TempTableColumnOrder(10)
    private Decimal kakuteiHokenryo;
    @TempTableColumnOrder(41)
    private RString hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(42)
    private int choshuHohoRirekiNo;
    @TempTableColumnOrder(43)
    private YMDHMS idoKijunNichiji;
    @TempTableColumnOrder(44)
    private RString kozaKubun;
    @TempTableColumnOrder(45)
    private RString kyokaisoKubun;
    @TempTableColumnOrder(46)
    private RString shokkenKubun;
    @TempTableColumnOrder(47)
    private LasdecCode fukaShichosonCode;
    @TempTableColumnOrder(48)
    private Decimal tkSaishutsuKampuGaku;
    @TempTableColumnOrder(49)
    private Decimal fuSaishutsuKampuGaku;
    @TempTableColumnOrder(50)
    private Decimal tkKibetsuGaku01;
    @TempTableColumnOrder(51)
    private Decimal tkKibetsuGaku02;
    @TempTableColumnOrder(52)
    private Decimal tkKibetsuGaku03;
    @TempTableColumnOrder(53)
    private Decimal tkKibetsuGaku04;
    @TempTableColumnOrder(54)
    private Decimal tkKibetsuGaku05;
    @TempTableColumnOrder(55)
    private Decimal tkKibetsuGaku06;
    @TempTableColumnOrder(56)
    private Decimal fuKibetsuGaku01;
    @TempTableColumnOrder(57)
    private Decimal fuKibetsuGaku02;
    @TempTableColumnOrder(58)
    private Decimal fuKibetsuGaku03;
    @TempTableColumnOrder(59)
    private Decimal fuKibetsuGaku04;
    @TempTableColumnOrder(60)
    private Decimal fuKibetsuGaku05;
    @TempTableColumnOrder(61)
    private Decimal fuKibetsuGaku06;
    @TempTableColumnOrder(62)
    private Decimal fuKibetsuGaku07;
    @TempTableColumnOrder(63)
    private Decimal fuKibetsuGaku08;
    @TempTableColumnOrder(64)
    private Decimal fuKibetsuGaku09;
    @TempTableColumnOrder(65)
    private Decimal fuKibetsuGaku10;
    @TempTableColumnOrder(66)
    private Decimal fuKibetsuGaku11;
    @TempTableColumnOrder(67)
    private Decimal fuKibetsuGaku12;
    @TempTableColumnOrder(68)
    private Decimal fuKibetsuGaku13;
    @TempTableColumnOrder(69)
    private Decimal fuKibetsuGaku14;
    @TempTableColumnOrder(70)
    private boolean falg;
}
