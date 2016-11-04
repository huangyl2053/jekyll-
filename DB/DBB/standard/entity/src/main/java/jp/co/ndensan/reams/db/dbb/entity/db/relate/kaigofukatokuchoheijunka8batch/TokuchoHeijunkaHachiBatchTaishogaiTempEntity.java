/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka8batch;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch.TokuchoHeijunkaRokuBatchTaishogaiTempEntity;
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
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 対象外データTempEntity
 *
 * @reamsid_L DBB-0860-030 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeijunkaHachiBatchTaishogaiTempEntity
        extends DbTableEntityBase<TokuchoHeijunkaRokuBatchTaishogaiTempEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString 備考コード;
    @TempTableColumnOrder(2)
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(3)
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(4)
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(5)
    private int rirekiNo;
    @TempTableColumnOrder(6)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(7)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(8)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(9)
    private int setaiInsu;
    @TempTableColumnOrder(10)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(11)
    private RString shikakuShutokuJiyu;
    @TempTableColumnOrder(12)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(13)
    private RString shikakuSoshitsuJiyu;
    @TempTableColumnOrder(14)
    private RString seihofujoShurui;
    @TempTableColumnOrder(15)
    private FlexibleDate seihoKaishiYMD;
    @TempTableColumnOrder(16)
    private FlexibleDate seihoHaishiYMD;
    @TempTableColumnOrder(17)
    private FlexibleDate ronenKaishiYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate ronenHaishiYMD;
    @TempTableColumnOrder(19)
    private FlexibleDate fukaYMD;
    @TempTableColumnOrder(20)
    private RString kazeiKubun;
    @TempTableColumnOrder(21)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(22)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(23)
    private Decimal nenkinShunyuGaku;
    @TempTableColumnOrder(24)
    private RString hokenryoDankai;
    @TempTableColumnOrder(25)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(26)
    private Decimal nengakuHokenryo1;
    @TempTableColumnOrder(27)
    private FlexibleYearMonth tsukiwariStartYM1;
    @TempTableColumnOrder(28)
    private FlexibleYearMonth tsukiwariEndYM1;
    @TempTableColumnOrder(29)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(30)
    private Decimal nengakuHokenryo2;
    @TempTableColumnOrder(31)
    private FlexibleYearMonth tsukiwariStartYM2;
    @TempTableColumnOrder(32)
    private FlexibleYearMonth tsukiwariEndYM2;
    @TempTableColumnOrder(33)
    private YMDHMS choteiNichiji;
    @TempTableColumnOrder(34)
    private RString choteiJiyu1;
    @TempTableColumnOrder(35)
    private RString choteiJiyu2;
    @TempTableColumnOrder(36)
    private RString choteiJiyu3;
    @TempTableColumnOrder(37)
    private RString choteiJiyu4;
    @TempTableColumnOrder(38)
    private RString koseiM;
    @TempTableColumnOrder(39)
    private Decimal gemmenMaeHokenryo;
    @TempTableColumnOrder(40)
    private Decimal gemmenGaku;
    @TempTableColumnOrder(41)
    private Decimal kakuteiHokenryo;
    @TempTableColumnOrder(42)
    private RString hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(43)
    private int choshuHohoRirekiNo;
    @TempTableColumnOrder(44)
    private YMDHMS idoKijunNichiji;
    @TempTableColumnOrder(45)
    private RString kozaKubun;
    @TempTableColumnOrder(46)
    private RString kyokaisoKubun;
    @TempTableColumnOrder(47)
    private RString shokkenKubun;
    @TempTableColumnOrder(48)
    private LasdecCode fukaShichosonCode;
    @TempTableColumnOrder(49)
    private Decimal tkSaishutsuKampuGaku;
    @TempTableColumnOrder(50)
    private Decimal fuSaishutsuKampuGaku;
    @TempTableColumnOrder(51)
    private Decimal tokubetsuChoteigaku01;
    @TempTableColumnOrder(52)
    private Decimal tokubetsuChoteigaku02;
    @TempTableColumnOrder(53)
    private Decimal tokubetsuChoteigaku03;
    @TempTableColumnOrder(54)
    private Decimal fuchoChoteigaku01;
    @TempTableColumnOrder(55)
    private Decimal fuchoChoteigaku02;
    @TempTableColumnOrder(56)
    private Decimal fuchoChoteigaku03;
    @TempTableColumnOrder(57)
    private Decimal fuchoChoteigaku04;
    @TempTableColumnOrder(58)
    private Decimal fuchoChoteigaku05;
    @TempTableColumnOrder(59)
    private Decimal fuchoChoteigaku06;
    @TempTableColumnOrder(60)
    private Decimal fuchoChoteigaku07;
    @TempTableColumnOrder(61)
    private Decimal fuchoChoteigaku08;
    @TempTableColumnOrder(62)
    private Decimal fuchoChoteigaku09;
    @TempTableColumnOrder(63)
    private Decimal fuchoChoteigaku10;
    @TempTableColumnOrder(64)
    private Decimal fuchoChoteigaku11;
    @TempTableColumnOrder(65)
    private Decimal fuchoChoteigaku12;
    @TempTableColumnOrder(66)
    private Decimal fuchoChoteigaku13;
    @TempTableColumnOrder(67)
    private Decimal fuchoChoteigaku14;
    @TempTableColumnOrder(68)
    private Decimal tokubetsuChoteigaku04;
    @TempTableColumnOrder(69)
    private Decimal tokubetsuChoteigaku05;
    @TempTableColumnOrder(70)
    private Decimal tokubetsuChoteigaku06;
    private RString choshuHouhou;
    private int ki;
    private Decimal choteigaku;
}
