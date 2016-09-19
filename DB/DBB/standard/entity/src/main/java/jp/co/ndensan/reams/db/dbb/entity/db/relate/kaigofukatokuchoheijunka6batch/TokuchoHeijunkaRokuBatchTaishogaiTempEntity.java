/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigofukatokuchoheijunka6batch;

import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchoheinjunka6gatsu.FukaJohoTmpEntity;
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
 * @reamsid_L DBB-0810-010 yebangqiang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoHeijunkaRokuBatchTaishogaiTempEntity
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

    /**
     * コンストラクタです。
     *
     */
    public TokuchoHeijunkaRokuBatchTaishogaiTempEntity() {
        this.choteiNendo = null;
        this.fukaNendo = null;
        this.tsuchishoNo = null;
        this.rirekiNo = 0;
        this.hihokenshaNo = null;
    }

    /**
     * コンストラクタです。
     *
     * @param 介護賦課 HeinjunkaFukaTmpEntity
     * @param 備考コード RString
     */
    public TokuchoHeijunkaRokuBatchTaishogaiTempEntity(FukaJohoTmpEntity 介護賦課, RString 備考コード) {
        this.choteiNendo = 介護賦課.getChoteiNendo();
        this.fukaNendo = 介護賦課.getFukaNendo();
        this.tsuchishoNo = 介護賦課.getTsuchishoNo();
        this.rirekiNo = 介護賦課.getRirekiNo();
        this.hihokenshaNo = 介護賦課.getHihokenshaNo();
        this.shikibetsuCode = 介護賦課.getShikibetsuCode();
        this.setaiCode = 介護賦課.getSetaiCode();
        this.setaiInsu = 介護賦課.getSetaiInsu();
        this.shikakuShutokuYMD = 介護賦課.getShikakuShutokuYMD();
        this.shikakuShutokuJiyu = 介護賦課.getShikakuShutokuJiyu();
        this.shikakuSoshitsuYMD = 介護賦課.getShikakuSoshitsuYMD();
        this.shikakuSoshitsuJiyu = 介護賦課.getShikakuSoshitsuJiyu();
        this.seihofujoShurui = 介護賦課.getSeihofujoShurui();
        this.seihoKaishiYMD = 介護賦課.getSeihoKaishiYMD();
        this.seihoHaishiYMD = 介護賦課.getSeihoHaishiYMD();
        this.ronenKaishiYMD = 介護賦課.getRonenKaishiYMD();
        this.ronenHaishiYMD = 介護賦課.getRonenHaishiYMD();
        this.fukaYMD = 介護賦課.getFukaYMD();
        this.kazeiKubun = 介護賦課.getKazeiKubun();
        this.setaikazeiKubun = 介護賦課.getSetaikazeiKubun();
        this.gokeiShotokuGaku = 介護賦課.getGokeiShotokuGaku();
        this.nenkinShunyuGaku = 介護賦課.getNenkinShunyuGaku();
        this.hokenryoDankai = 介護賦課.getHokenryoDankai();
        this.hokenryoDankai1 = 介護賦課.getHokenryoDankai1();
        this.nengakuHokenryo1 = 介護賦課.getNengakuHokenryo1();
        this.tsukiwariStartYM1 = 介護賦課.getTsukiwariStartYM1();
        this.tsukiwariEndYM1 = 介護賦課.getTsukiwariEndYM1();
        this.hokenryoDankai2 = 介護賦課.getHokenryoDankai2();
        this.nengakuHokenryo2 = 介護賦課.getNengakuHokenryo2();
        this.tsukiwariStartYM2 = 介護賦課.getTsukiwariStartYM2();
        this.tsukiwariEndYM2 = 介護賦課.getTsukiwariEndYM2();
        this.choteiNichiji = 介護賦課.getChoteiNichiji();
        this.choteiJiyu1 = 介護賦課.getChoteiJiyu1();
        this.choteiJiyu2 = 介護賦課.getChoteiJiyu2();
        this.choteiJiyu3 = 介護賦課.getChoteiJiyu3();
        this.choteiJiyu4 = 介護賦課.getChoteiJiyu4();
        this.koseiM = 介護賦課.getKoseiM();
        this.gemmenMaeHokenryo = 介護賦課.getGemmenMaeHokenryo();
        this.gemmenGaku = 介護賦課.getGemmenGaku();
        this.kakuteiHokenryo = 介護賦課.getKakuteiHokenryo();
        this.choshuHohoRirekiNo = 介護賦課.getChoshuHohoRirekiNo();
        this.idoKijunNichiji = 介護賦課.getIdoKijunNichiji();
        this.kozaKubun = 介護賦課.getKozaKubun();
        this.kyokaisoKubun = 介護賦課.getKyokaisoKubun();
        this.shokkenKubun = 介護賦課.getShokkenKubun();
        this.fukaShichosonCode = 介護賦課.getFukaShichosonCode();
        this.tkSaishutsuKampuGaku = 介護賦課.getTkSaishutsuKampuGaku();
        this.fuSaishutsuKampuGaku = 介護賦課.getFuSaishutsuKampuGaku();
        this.hokenryoDankaiKarisanntei = 介護賦課.getHokenryoDankaiKarisanntei();
        this.tokubetsuChoteigaku01 = 介護賦課.getTkKibetsuGaku01();
        this.tokubetsuChoteigaku02 = 介護賦課.getTkKibetsuGaku02();
        this.tokubetsuChoteigaku03 = 介護賦課.getTkKibetsuGaku03();
        this.tokubetsuChoteigaku04 = 介護賦課.getTkKibetsuGaku04();
        this.tokubetsuChoteigaku05 = 介護賦課.getTkKibetsuGaku05();
        this.tokubetsuChoteigaku06 = 介護賦課.getTkKibetsuGaku06();
        this.fuchoChoteigaku01 = 介護賦課.getFuKibetsuGaku01();
        this.fuchoChoteigaku02 = 介護賦課.getFuKibetsuGaku02();
        this.fuchoChoteigaku03 = 介護賦課.getFuKibetsuGaku03();
        this.fuchoChoteigaku04 = 介護賦課.getFuKibetsuGaku04();
        this.fuchoChoteigaku05 = 介護賦課.getFuKibetsuGaku05();
        this.fuchoChoteigaku06 = 介護賦課.getFuKibetsuGaku06();
        this.fuchoChoteigaku07 = 介護賦課.getFuKibetsuGaku07();
        this.fuchoChoteigaku08 = 介護賦課.getFuKibetsuGaku08();
        this.fuchoChoteigaku09 = 介護賦課.getFuKibetsuGaku09();
        this.fuchoChoteigaku10 = 介護賦課.getFuKibetsuGaku10();
        this.fuchoChoteigaku11 = 介護賦課.getFuKibetsuGaku11();
        this.fuchoChoteigaku12 = 介護賦課.getFuKibetsuGaku12();
        this.fuchoChoteigaku13 = 介護賦課.getFuKibetsuGaku13();
        this.fuchoChoteigaku14 = 介護賦課.getFuKibetsuGaku14();
        this.備考コード = 備考コード;
    }
}
