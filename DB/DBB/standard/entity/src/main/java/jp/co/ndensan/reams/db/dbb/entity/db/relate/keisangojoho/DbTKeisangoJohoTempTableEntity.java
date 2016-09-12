package jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho;

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
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 計算後情報一時テーブルEntity項目定義クラスです。
 *
 * @reamsid_L DBB-9060-010 duanzhanli
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbTKeisangoJohoTempTableEntity extends DbTableEntityBase<DbTKeisangoJohoTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

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
    @PrimaryKey
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(10)
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(11)
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(12)
    private RString koseiZengoKubun;
    @TempTableColumnOrder(13)
    private RString sakuseiShoriName;
    @TempTableColumnOrder(14)
    @PrimaryKey
    private int fukaRirekiNo;
    @TempTableColumnOrder(15)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(16)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(17)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(18)
    private int setaiInsu;
    @TempTableColumnOrder(19)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(20)
    private RString shikakuShutokuJiyu;
    @TempTableColumnOrder(21)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(22)
    private RString shikakuSoshitsuJiyu;
    @TempTableColumnOrder(23)
    private RString seihofujoShurui;
    @TempTableColumnOrder(24)
    private FlexibleDate seihoKaishiYMD;
    @TempTableColumnOrder(25)
    private FlexibleDate seihoHaishiYMD;
    @TempTableColumnOrder(26)
    private FlexibleDate ronenKaishiYMD;
    @TempTableColumnOrder(27)
    private FlexibleDate ronenHaishiYMD;
    @TempTableColumnOrder(28)
    private FlexibleDate fukaYMD;
    @TempTableColumnOrder(29)
    private RString kazeiKubun;
    @TempTableColumnOrder(30)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(31)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(32)
    private Decimal nenkinShunyuGaku;
    @TempTableColumnOrder(33)
    private RString hokenryoDankai;
    @TempTableColumnOrder(34)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(35)
    private Decimal nengakuHokenryo1;
    @TempTableColumnOrder(36)
    private FlexibleYearMonth tsukiwariStartYM1;
    @TempTableColumnOrder(37)
    private FlexibleYearMonth tsukiwariEndYM1;
    @TempTableColumnOrder(38)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(39)
    private Decimal nengakuHokenryo2;
    @TempTableColumnOrder(40)
    private FlexibleYearMonth tsukiwariStartYM2;
    @TempTableColumnOrder(41)
    private FlexibleYearMonth tsukiwariEndYM2;
    @TempTableColumnOrder(42)
    private YMDHMS choteiNichiji;
    @TempTableColumnOrder(43)
    private RString choteiJiyu1;
    @TempTableColumnOrder(44)
    private RString choteiJiyu2;
    @TempTableColumnOrder(45)
    private RString choteiJiyu3;
    @TempTableColumnOrder(46)
    private RString choteiJiyu4;
    @TempTableColumnOrder(47)
    private RString koseiM;
    @TempTableColumnOrder(48)
    private Decimal gemmenMaeHokenryo;
    @TempTableColumnOrder(49)
    private Decimal gemmenGaku;
    @TempTableColumnOrder(50)
    private Decimal kakuteiHokenryo;
    @TempTableColumnOrder(51)
    private RString hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(52)
    private int choshuHohoRirekiNo;
    @TempTableColumnOrder(53)
    private YMDHMS idoKijunNichiji;
    @TempTableColumnOrder(54)
    private RString kozaKubun;
    @TempTableColumnOrder(55)
    private RString kyokaisoKubun;
    @TempTableColumnOrder(56)
    private RString shokkenKubun;
    @TempTableColumnOrder(57)
    private LasdecCode fukaShichosonCode;
    @TempTableColumnOrder(58)
    private Decimal tkSaishutsuKampuGaku;
    @TempTableColumnOrder(59)
    private Decimal fuSaishutsuKampuGaku;
    @TempTableColumnOrder(60)
    private Decimal tkKibetsuGaku01;
    @TempTableColumnOrder(61)
    private Decimal tkKibetsuGaku02;
    @TempTableColumnOrder(62)
    private Decimal tkKibetsuGaku03;
    @TempTableColumnOrder(63)
    private Decimal tkKibetsuGaku04;
    @TempTableColumnOrder(64)
    private Decimal tkKibetsuGaku05;
    @TempTableColumnOrder(65)
    private Decimal tkKibetsuGaku06;
    @TempTableColumnOrder(66)
    private Decimal fuKibetsuGaku01;
    @TempTableColumnOrder(67)
    private Decimal fuKibetsuGaku02;
    @TempTableColumnOrder(68)
    private Decimal fuKibetsuGaku03;
    @TempTableColumnOrder(69)
    private Decimal fuKibetsuGaku04;
    @TempTableColumnOrder(70)
    private Decimal fuKibetsuGaku05;
    @TempTableColumnOrder(71)
    private Decimal fuKibetsuGaku06;
    @TempTableColumnOrder(72)
    private Decimal fuKibetsuGaku07;
    @TempTableColumnOrder(73)
    private Decimal fuKibetsuGaku08;
    @TempTableColumnOrder(74)
    private Decimal fuKibetsuGaku09;
    @TempTableColumnOrder(75)
    private Decimal fuKibetsuGaku10;
    @TempTableColumnOrder(76)
    private Decimal fuKibetsuGaku11;
    @TempTableColumnOrder(77)
    private Decimal fuKibetsuGaku12;
    @TempTableColumnOrder(78)
    private Decimal fuKibetsuGaku13;
    @TempTableColumnOrder(79)
    private Decimal fuKibetsuGaku14;
    @TempTableColumnOrder(80)
    private RString choshuHoho4gatsu;
    @TempTableColumnOrder(81)
    private RString choshuHoho5gatsu;
    @TempTableColumnOrder(82)
    private RString choshuHoho6gatsu;
    @TempTableColumnOrder(83)
    private RString choshuHoho7gatsu;
    @TempTableColumnOrder(84)
    private RString choshuHoho8gatsu;
    @TempTableColumnOrder(85)
    private RString choshuHoho9gatsu;
    @TempTableColumnOrder(86)
    private RString choshuHoho10gatsu;
    @TempTableColumnOrder(87)
    private RString choshuHoho11gatsu;
    @TempTableColumnOrder(88)
    private RString choshuHoho12gatsu;
    @TempTableColumnOrder(89)
    private RString choshuHoho1gatsu;
    @TempTableColumnOrder(90)
    private RString choshuHoho2gatsu;
    @TempTableColumnOrder(91)
    private RString choshuHoho3gatsu;
    @TempTableColumnOrder(92)
    private RString choshuHohoYoku4gatsu;
    @TempTableColumnOrder(93)
    private RString choshuHohoYoku5gatsu;
    @TempTableColumnOrder(94)
    private RString choshuHohoYoku6gatsu;
    @TempTableColumnOrder(95)
    private RString choshuHohoYoku7gatsu;
    @TempTableColumnOrder(96)
    private RString choshuHohoYoku8gatsu;
    @TempTableColumnOrder(97)
    private RString choshuHohoYoku9gatsu;
    @TempTableColumnOrder(98)
    private RString kariNenkinNo;
    @TempTableColumnOrder(99)
    private RString kariNenkinCode;
    @TempTableColumnOrder(100)
    private RString kariHosokuM;
    @TempTableColumnOrder(101)
    private RString honNenkinNo;
    @TempTableColumnOrder(102)
    private RString honNenkinCode;
    @TempTableColumnOrder(103)
    private RString honHosokuM;
    @TempTableColumnOrder(104)
    private RString yokunendoKariNenkinNo;
    @TempTableColumnOrder(105)
    private RString yokunendoKariNenkinCode;
    @TempTableColumnOrder(106)
    private RString yokunendoKariHosokuM;
    @TempTableColumnOrder(107)
    private boolean iraiSohuzumiFlag;
    @TempTableColumnOrder(108)
    private boolean tsuikaIraiSohuzumiFlag;
    @TempTableColumnOrder(109)
    private YMDHMS tokuchoTeishiNichiji;
    @TempTableColumnOrder(110)
    private RString tokuchoTeishiJiyuCode;
    @TempTableColumnOrder(111)
    private Decimal tkShunyuGaku01;
    @TempTableColumnOrder(112)
    private Decimal tkShunyuGaku02;
    @TempTableColumnOrder(113)
    private Decimal tkShunyuGaku03;
    @TempTableColumnOrder(114)
    private Decimal tkShunyuGaku04;
    @TempTableColumnOrder(115)
    private Decimal tkShunyuGaku05;
    @TempTableColumnOrder(116)
    private Decimal tkShunyuGaku06;
    @TempTableColumnOrder(117)
    private Decimal fuShunyuGaku01;
    @TempTableColumnOrder(118)
    private Decimal fuShunyuGaku02;
    @TempTableColumnOrder(119)
    private Decimal fuShunyuGaku03;
    @TempTableColumnOrder(120)
    private Decimal fuShunyuGaku04;
    @TempTableColumnOrder(121)
    private Decimal fuShunyuGaku05;
    @TempTableColumnOrder(122)
    private Decimal fuShunyuGaku06;
    @TempTableColumnOrder(123)
    private Decimal fuShunyuGaku07;
    @TempTableColumnOrder(124)
    private Decimal fuShunyuGaku08;
    @TempTableColumnOrder(125)
    private Decimal fuShunyuGaku09;
    @TempTableColumnOrder(126)
    private Decimal fuShunyuGaku10;
    @TempTableColumnOrder(127)
    private Decimal fuShunyuGaku11;
    @TempTableColumnOrder(128)
    private Decimal fuShunyuGaku12;
    @TempTableColumnOrder(129)
    private Decimal fuShunyuGaku13;
    @TempTableColumnOrder(130)
    private Decimal fuShunyuGaku14;
}
