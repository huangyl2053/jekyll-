package jp.co.ndensan.reams.db.dbb.entity.db.relate.keisangojoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * DbTKeisangoJohoTempTableEntity項目定義クラスです。
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
@OnNextSchema("rgdb")
public class DbTKeisangoJohoTempTableEntity extends DbTableEntityBase<DbTKeisangoJohoTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TempTableColumnOrder(1)
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(2)
    private FlexibleYear fukaNendo;
    @TempTableColumnOrder(3)
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(4)
    private RString koseiZengoKubun;
    @TempTableColumnOrder(5)
    private RString sakuseiShoriName;
    @TempTableColumnOrder(6)
    private int fukaRirekiNo;
    @TempTableColumnOrder(7)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(8)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(9)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(10)
    private int setaiInsu;
    @TempTableColumnOrder(11)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(12)
    private RString shikakuShutokuJiyu;
    @TempTableColumnOrder(13)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(14)
    private RString shikakuSoshitsuJiyu;
    @TempTableColumnOrder(15)
    private RString seihofujoShurui;
    @TempTableColumnOrder(16)
    private FlexibleDate seihoKaishiYMD;
    @TempTableColumnOrder(17)
    private FlexibleDate seihoHaishiYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate ronenKaishiYMD;
    @TempTableColumnOrder(19)
    private FlexibleDate ronenHaishiYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate fukaYMD;
    @TempTableColumnOrder(21)
    private RString kazeiKubun;
    @TempTableColumnOrder(22)
    private RString setaikazeiKubun;
    @TempTableColumnOrder(23)
    private Decimal gokeiShotokuGaku;
    @TempTableColumnOrder(24)
    private Decimal nenkinShunyuGaku;
    @TempTableColumnOrder(25)
    private RString hokenryoDankai;
    @TempTableColumnOrder(26)
    private RString hokenryoDankai1;
    @TempTableColumnOrder(27)
    private Decimal nengakuHokenryo1;
    @TempTableColumnOrder(28)
    private FlexibleDate tsukiwariStartYM1;
    @TempTableColumnOrder(29)
    private FlexibleDate tsukiwariEndYM1;
    @TempTableColumnOrder(30)
    private RString hokenryoDankai2;
    @TempTableColumnOrder(31)
    private Decimal nengakuHokenryo2;
    @TempTableColumnOrder(32)
    private FlexibleDate tsukiwariStartYM2;
    @TempTableColumnOrder(33)
    private FlexibleDate tsukiwariEndYM2;
    @TempTableColumnOrder(34)
    private YMDHMS choteiNichiji;
    @TempTableColumnOrder(35)
    private RString choteiJiyu1;
    @TempTableColumnOrder(36)
    private RString choteiJiyu2;
    @TempTableColumnOrder(37)
    private RString choteiJiyu3;
    @TempTableColumnOrder(38)
    private RString choteiJiyu4;
    @TempTableColumnOrder(39)
    private RString koseiM;
    @TempTableColumnOrder(40)
    private Decimal gemmenMaeHokenryo;
    @TempTableColumnOrder(41)
    private Decimal gemmenGaku;
    @TempTableColumnOrder(42)
    private Decimal kakuteiHokenryo;
    @TempTableColumnOrder(43)
    private RString hokenryoDankaiKarisanntei;
    @TempTableColumnOrder(44)
    private int choshuHohoRirekiNo;
    @TempTableColumnOrder(45)
    private YMDHMS idoKijunNichiji;
    @TempTableColumnOrder(46)
    private RString kozaKubun;
    @TempTableColumnOrder(47)
    private RString kyokaisoKubun;
    @TempTableColumnOrder(48)
    private RString shokkenKubun;
    @TempTableColumnOrder(49)
    private LasdecCode fukaShichosonCode;
    @TempTableColumnOrder(50)
    private Decimal tkSaishutsuKampuGaku;
    @TempTableColumnOrder(51)
    private Decimal fuSaishutsuKampuGaku;
    @TempTableColumnOrder(52)
    private Decimal tkKibetsuGaku01;
    @TempTableColumnOrder(53)
    private Decimal tkKibetsuGaku02;
    @TempTableColumnOrder(54)
    private Decimal tkKibetsuGaku03;
    @TempTableColumnOrder(55)
    private Decimal tkKibetsuGaku04;
    @TempTableColumnOrder(56)
    private Decimal tkKibetsuGaku05;
    @TempTableColumnOrder(57)
    private Decimal tkKibetsuGaku06;
    @TempTableColumnOrder(58)
    private Decimal fuKibetsuGaku01;
    @TempTableColumnOrder(59)
    private Decimal fuKibetsuGaku02;
    @TempTableColumnOrder(60)
    private Decimal fuKibetsuGaku03;
    @TempTableColumnOrder(61)
    private Decimal fuKibetsuGaku04;
    @TempTableColumnOrder(62)
    private Decimal fuKibetsuGaku05;
    @TempTableColumnOrder(63)
    private Decimal fuKibetsuGaku06;
    @TempTableColumnOrder(64)
    private Decimal fuKibetsuGaku07;
    @TempTableColumnOrder(65)
    private Decimal fuKibetsuGaku08;
    @TempTableColumnOrder(66)
    private Decimal fuKibetsuGaku09;
    @TempTableColumnOrder(67)
    private Decimal fuKibetsuGaku10;
    @TempTableColumnOrder(68)
    private Decimal fuKibetsuGaku11;
    @TempTableColumnOrder(69)
    private Decimal fuKibetsuGaku12;
    @TempTableColumnOrder(70)
    private Decimal fuKibetsuGaku13;
    @TempTableColumnOrder(71)
    private Decimal fuKibetsuGaku14;
    @TempTableColumnOrder(72)
    private RString choshuHoho4gatsu;
    @TempTableColumnOrder(73)
    private RString choshuHoho5gatsu;
    @TempTableColumnOrder(74)
    private RString choshuHoho6gatsu;
    @TempTableColumnOrder(75)
    private RString choshuHoho7gatsu;
    @TempTableColumnOrder(76)
    private RString choshuHoho8gatsu;
    @TempTableColumnOrder(77)
    private RString choshuHoho9gatsu;
    @TempTableColumnOrder(78)
    private RString choshuHoho10gatsu;
    @TempTableColumnOrder(79)
    private RString choshuHoho11gatsu;
    @TempTableColumnOrder(80)
    private RString choshuHoho12gatsu;
    @TempTableColumnOrder(81)
    private RString choshuHoho1gatsu;
    @TempTableColumnOrder(82)
    private RString choshuHoho2gatsu;
    @TempTableColumnOrder(83)
    private RString choshuHoho3gatsu;
    @TempTableColumnOrder(84)
    private RString choshuHohoYoku4gatsu;
    @TempTableColumnOrder(85)
    private RString choshuHohoYoku5gatsu;
    @TempTableColumnOrder(86)
    private RString choshuHohoYoku6gatsu;
    @TempTableColumnOrder(87)
    private RString choshuHohoYoku7gatsu;
    @TempTableColumnOrder(88)
    private RString choshuHohoYoku8gatsu;
    @TempTableColumnOrder(89)
    private RString choshuHohoYoku9gatsu;
    @TempTableColumnOrder(90)
    private RString kariNenkinNo;
    @TempTableColumnOrder(91)
    private RString kariNenkinCode;
    @TempTableColumnOrder(92)
    private RString kariHosokuM;
    @TempTableColumnOrder(93)
    private RString honNenkinNo;
    @TempTableColumnOrder(94)
    private RString honNenkinCode;
    @TempTableColumnOrder(95)
    private RString honHosokuM;
    @TempTableColumnOrder(96)
    private RString yokunendoKariNenkinNo;
    @TempTableColumnOrder(97)
    private RString yokunendoKariNenkinCode;
    @TempTableColumnOrder(98)
    private RString yokunendoKariHosokuM;
    @TempTableColumnOrder(99)
    private boolean iraiSohuzumiFlag;
    @TempTableColumnOrder(100)
    private boolean tsuikaIraiSohuzumiFlag;
    @TempTableColumnOrder(101)
    private YMDHMS tokuchoTeishiNichiji;
    @TempTableColumnOrder(102)
    private RString tokuchoTeishiJiyuCode;
    @TempTableColumnOrder(103)
    private Decimal tkShunyuGaku01;
    @TempTableColumnOrder(104)
    private Decimal tkShunyuGaku02;
    @TempTableColumnOrder(105)
    private Decimal tkShunyuGaku03;
    @TempTableColumnOrder(106)
    private Decimal tkShunyuGaku04;
    @TempTableColumnOrder(107)
    private Decimal tkShunyuGaku05;
    @TempTableColumnOrder(108)
    private Decimal tkShunyuGaku06;
    @TempTableColumnOrder(109)
    private Decimal fuShunyuGaku01;
    @TempTableColumnOrder(110)
    private Decimal fuShunyuGaku02;
    @TempTableColumnOrder(111)
    private Decimal fuShunyuGaku03;
    @TempTableColumnOrder(112)
    private Decimal fuShunyuGaku04;
    @TempTableColumnOrder(113)
    private Decimal fuShunyuGaku05;
    @TempTableColumnOrder(114)
    private Decimal fuShunyuGaku06;
    @TempTableColumnOrder(115)
    private Decimal fuShunyuGaku07;
    @TempTableColumnOrder(116)
    private Decimal fuShunyuGaku08;
    @TempTableColumnOrder(117)
    private Decimal fuShunyuGaku09;
    @TempTableColumnOrder(118)
    private Decimal fuShunyuGaku10;
    @TempTableColumnOrder(119)
    private Decimal fuShunyuGaku11;
    @TempTableColumnOrder(120)
    private Decimal fuShunyuGaku12;
    @TempTableColumnOrder(121)
    private Decimal fuShunyuGaku13;
    @TempTableColumnOrder(122)
    private Decimal fuShunyuGaku14;
}
