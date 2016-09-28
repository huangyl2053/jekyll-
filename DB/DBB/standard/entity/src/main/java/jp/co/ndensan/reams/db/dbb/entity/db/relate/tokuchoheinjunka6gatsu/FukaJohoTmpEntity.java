/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴平準化（特徴6月分）バッチTemp賦課情報です。
 *
 * @reamsid_L DBB-0810-010 yebangqiang
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FukaJohoTmpEntity extends DbTableEntityBase<FukaJohoTmpEntity> implements IDbAccessable {

    @TempTableColumnOrder(1)
    private RString insertDantaiCd;
    @TempTableColumnOrder(2)
    private RDateTime insertTimestamp;
    @TempTableColumnOrder(3)
    private RString insertReamsLoginId;
    @TempTableColumnOrder(4)
    private UUID insertContextId;
    @TempTableColumnOrder(5)
    private boolean isDeleted = false;
    @TempTableColumnOrder(6)
    private int updateCount = 0;
    @TempTableColumnOrder(7)
    private RDateTime lastUpdateTimestamp;
    @TempTableColumnOrder(8)
    private RString lastUpdateReamsLoginId;
    @TempTableColumnOrder(9)
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(10)
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(11)
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(12)
    private int rirekiNo;
    @TempTableColumnOrder(13)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(14)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(15)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(16)
    private int setaiInsu;
    @TempTableColumnOrder(17)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(18)
    private RString shikakuShutokuJiyu;
    @TempTableColumnOrder(19)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(20)
    private RString shikakuSoshitsuJiyu;
    @TempTableColumnOrder(21)
    private RString seihofujoShurui;
    @TempTableColumnOrder(22)
    private FlexibleDate seihoKaishiYMD;
    @TempTableColumnOrder(23)
    private FlexibleDate seihoHaishiYMD;
    @TempTableColumnOrder(24)
    private FlexibleDate ronenKaishiYMD;
    @TempTableColumnOrder(25)
    private FlexibleDate ronenHaishiYMD;
    @TempTableColumnOrder(26)
    private FlexibleDate fukaYMD;
    @TempTableColumnOrder(27)
    private RString kazeiKubun;
    @TempTableColumnOrder(28)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(29)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(30)
    private Decimal nenkinShunyuGaku;
    @TempTableColumnOrder(31)
    private RString hokenryoDankai;
    @TempTableColumnOrder(32)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(33)
    private Decimal nengakuHokenryo1;
    @TempTableColumnOrder(34)
    private FlexibleYearMonth tsukiwariStartYM1;
    @TempTableColumnOrder(35)
    private FlexibleYearMonth tsukiwariEndYM1;
    @TempTableColumnOrder(36)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(37)
    private Decimal nengakuHokenryo2;
    @TempTableColumnOrder(38)
    private FlexibleYearMonth tsukiwariStartYM2;
    @TempTableColumnOrder(39)
    private FlexibleYearMonth tsukiwariEndYM2;
    @TempTableColumnOrder(40)
    private YMDHMS choteiNichiji;
    @TempTableColumnOrder(41)
    private RString choteiJiyu1;
    @TempTableColumnOrder(42)
    private RString choteiJiyu2;
    @TempTableColumnOrder(43)
    private RString choteiJiyu3;
    @TempTableColumnOrder(44)
    private RString choteiJiyu4;
    @TempTableColumnOrder(45)
    private RString koseiM;
    @TempTableColumnOrder(46)
    private Decimal gemmenMaeHokenryo;
    @TempTableColumnOrder(47)
    private Decimal gemmenGaku;
    @TempTableColumnOrder(48)
    private Decimal kakuteiHokenryo;
    @TempTableColumnOrder(49)
    private RString hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(50)
    private int choshuHohoRirekiNo;
    @TempTableColumnOrder(51)
    private YMDHMS idoKijunNichiji;
    @TempTableColumnOrder(52)
    private RString kozaKubun;
    @TempTableColumnOrder(53)
    private RString kyokaisoKubun;
    @TempTableColumnOrder(54)
    private RString shokkenKubun;
    @TempTableColumnOrder(55)
    private LasdecCode fukaShichosonCode;
    @TempTableColumnOrder(56)
    private Decimal tkSaishutsuKampuGaku;
    @TempTableColumnOrder(57)
    private Decimal fuSaishutsuKampuGaku;
    @TempTableColumnOrder(58)
    private Decimal choteigaku;
    @TempTableColumnOrder(59)
    private int ki;
    @TempTableColumnOrder(60)
    private RString choshuHouhou;
    @TempTableColumnOrder(61)
    private Decimal tkKibetsuGaku01;
    @TempTableColumnOrder(62)
    private Decimal tkKibetsuGaku02;
    @TempTableColumnOrder(63)
    private Decimal tkKibetsuGaku03;
    @TempTableColumnOrder(64)
    private Decimal tkKibetsuGaku04;
    @TempTableColumnOrder(65)
    private Decimal tkKibetsuGaku05;
    @TempTableColumnOrder(66)
    private Decimal tkKibetsuGaku06;
    @TempTableColumnOrder(67)
    private Decimal fuKibetsuGaku01;
    @TempTableColumnOrder(68)
    private Decimal fuKibetsuGaku02;
    @TempTableColumnOrder(69)
    private Decimal fuKibetsuGaku03;
    @TempTableColumnOrder(70)
    private Decimal fuKibetsuGaku04;
    @TempTableColumnOrder(71)
    private Decimal fuKibetsuGaku05;
    @TempTableColumnOrder(72)
    private Decimal fuKibetsuGaku06;
    @TempTableColumnOrder(73)
    private Decimal fuKibetsuGaku07;
    @TempTableColumnOrder(74)
    private Decimal fuKibetsuGaku08;
    @TempTableColumnOrder(75)
    private Decimal fuKibetsuGaku09;
    @TempTableColumnOrder(76)
    private Decimal fuKibetsuGaku10;
    @TempTableColumnOrder(77)
    private Decimal fuKibetsuGaku11;
    @TempTableColumnOrder(78)
    private Decimal fuKibetsuGaku12;
    @TempTableColumnOrder(79)
    private Decimal fuKibetsuGaku13;
    @TempTableColumnOrder(80)
    private Decimal fuKibetsuGaku14;
}
