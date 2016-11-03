/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd571001.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * バッチ設計_DBD571001_受給者台帳を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaDaichoCyouhyoujouhouTempTableEntity extends DbTableEntityBase<JukyushaDaichoCyouhyoujouhouTempTableEntity> implements IDbAccessable {

    /**
     * 検索条件一時テーブル名称
     */
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("JukyushaDaichoCyouhyoujouhouTempTable");
    }

    @TempTableColumnOrder(1)
    private LasdecCode temp_T4001shichosonCode;
    @TempTableColumnOrder(2)
    private HihokenshaNo temp_T4001hihokenshaNo;
    @TempTableColumnOrder(3)
    private ShikibetsuCode temp_T4001shikibetsuCode;
    @TempTableColumnOrder(4)
    private FlexibleDate temp_T4001ninteiYMD;
    @TempTableColumnOrder(5)
    private Code temp_T4001jukyuShinseiJiyu;
    @TempTableColumnOrder(6)
    private RString temp_T4001dataKubun;
    @TempTableColumnOrder(7)
    private RString temp_T4001yokaigoJotaiKubunCode;
    @TempTableColumnOrder(8)
    private FlexibleDate temp_T4001ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(9)
    private FlexibleDate temp_T4001ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(10)
    private Decimal temp_T4001shikyuGendoTanisu;
    @TempTableColumnOrder(11)
    private FlexibleDate temp_T4001shikyuGendoKaishiYMD;
    @TempTableColumnOrder(12)
    private FlexibleDate temp_T4001shikyuGendoShuryoYMD;
    @TempTableColumnOrder(13)
    private Decimal temp_T4001tankiSikyuGendoNissu;
    @TempTableColumnOrder(14)
    private FlexibleDate temp_T4001tankiShikyuGendoKaishiYMD;
    @TempTableColumnOrder(15)
    private FlexibleDate temp_T4001tankiShikyuGendoShuryoYMD;
    @TempTableColumnOrder(16)
    private boolean temp_T4001kyuSochishaFlag;
    @TempTableColumnOrder(17)
    private FlexibleDate temp_T4001soshitsuYMD;
    @TempTableColumnOrder(18)
    private boolean temp_T4001shikakuShutokuMaeShinseiFlag;
    @TempTableColumnOrder(19)
    private FlexibleDate temp_T4001jukyuShikakuShomeishoHakkoYMD1;
    @TempTableColumnOrder(20)
    private FlexibleDate temp_T4001jukyuShikakuShomeishoHakkoYMD2;
    @TempTableColumnOrder(21)
    private RString temp_T4001shinseishaKankeiCode;
    @TempTableColumnOrder(22)
    private RString temp_T4001homninKankei;
    @TempTableColumnOrder(23)
    private RString t4101_shinseishoKanriNo;
    @TempTableColumnOrder(24)
    private RString t4101_koroshoIfShikibetsuCode;
    @TempTableColumnOrder(25)
    private FlexibleDate t4101_enkiTsuchiHakkoYMD;
    @TempTableColumnOrder(26)
    private Decimal t4101_enkiTsuchiHakkoKaisu;
    @TempTableColumnOrder(27)
    private boolean t4101_shiteiiFlag;
    @TempTableColumnOrder(28)
    private RString t4101_ninteiShinseiShinseijiKubunCode;
    @TempTableColumnOrder(29)
    private RString t4101_ninteiShinseiHoreiKubunCode;
    @TempTableColumnOrder(30)
    private RString t4101_homonChosasakiYubinNo;
    @TempTableColumnOrder(31)
    private RString t4101_homonChosasakiJusho;
    @TempTableColumnOrder(32)
    private RString t4101_homonChosasakiName;
    @TempTableColumnOrder(33)
    private RString t4101_homonChosasakiTelNo;
    @TempTableColumnOrder(34)
    private RString t4123_shinseishoKanriNo;
    @TempTableColumnOrder(35)
    private FlexibleDate t4123_ninteichosaYoteiYMD;
    @TempTableColumnOrder(36)
    private FlexibleDate t4123_ikenshoTorokuYoteiYMD;
    @TempTableColumnOrder(37)
    private RString t4003_shinseishoKanriNo;
    @TempTableColumnOrder(40)
    private FlexibleDate t4003_shinseiYMD;
    @TempTableColumnOrder(41)
    private FlexibleDate t4003_chosaItakuYMD;
    @TempTableColumnOrder(42)
    private FlexibleDate t4003_chosaShuryoYMD;
    @TempTableColumnOrder(43)
    private FlexibleDate t4003_ikenshoIraiYMD;
    @TempTableColumnOrder(44)
    private FlexibleDate t4003_ikenshoToriyoseYMD;
    @TempTableColumnOrder(45)
    private FlexibleDate t4003_shinsakaiShiryoSakuseiYMD;
    @TempTableColumnOrder(46)
    private FlexibleDate t4003_shinsakaiYoteiYMD;
    @TempTableColumnOrder(47)
    private FlexibleDate t4003_nijiHanteiYMD;
    @TempTableColumnOrder(48)
    private RString t4003_ichijiHanteiKekkaCode;
    @TempTableColumnOrder(49)
    private FlexibleDate t4003_ichijiHanteiYMD;
    @TempTableColumnOrder(50)
    private RString t4003_ichijiHanteiKekkaKasanCode;
    @TempTableColumnOrder(51)
    private RString t4003_tokuteiShippeiCode;
    @TempTableColumnOrder(52)
    private RString t4003_chosaItakusakiCode;
    @TempTableColumnOrder(53)
    private RString t4003_chosainCode;
    @TempTableColumnOrder(54)
    private RString t4003_iryoKikanCode;
    @TempTableColumnOrder(55)
    private RString t4003_shujiiCode;
    @TempTableColumnOrder(56)
    private RString t4003_shinsakaiIken;
    @TempTableColumnOrder(57)
    private FlexibleDate t4101_ninteiShinseiYMD;
    @TempTableColumnOrder(58)
    private RString x4102_shinseishoKanriNo;
    @TempTableColumnOrder(59)
    private FlexibleDate x4102_ninteichosaIraiYMD;
    @TempTableColumnOrder(60)
    private FlexibleDate x4102_ninteichosaJisshiYMD;
    @TempTableColumnOrder(61)
    private FlexibleDate x4102_ikenshoSakuseiIraiYMD;
    @TempTableColumnOrder(62)
    private FlexibleDate x4102_ikenshoJuryoYMD;
    @TempTableColumnOrder(63)
    private FlexibleDate x4102_shinsakaiShiryoSakuseiYMD;
    @TempTableColumnOrder(64)
    private FlexibleDate t4123_ninteiShinsakaiYoteiYMD;
    @TempTableColumnOrder(65)
    private FlexibleDate x4102_nijiHanteiYMD;
    @TempTableColumnOrder(66)
    private RString x4102_ichijiHanteiKekkaCode;
    @TempTableColumnOrder(67)
    private FlexibleDate x4102_ichijiHanteiYMD;
    @TempTableColumnOrder(68)
    private RString x4102_ichijiHanteiKekkaNinchishoKasanCode;
    @TempTableColumnOrder(69)
    private RString t4101_nigoTokuteiShippeiCode;
    @TempTableColumnOrder(70)
    private RString t4101_ninteiChosaItakusakiCode;
    @TempTableColumnOrder(71)
    private RString t4101_ninteiChosainCode;
    @TempTableColumnOrder(72)
    private RString t4101_shujiiIryokikanCode;
    @TempTableColumnOrder(73)
    private RString t4101_shujiiCode;
    @TempTableColumnOrder(74)
    private RString x4102_shinsakaiIken;
    @TempTableColumnOrder(75)
    private RString t4910_shichosonCode;
    @TempTableColumnOrder(76)
    private RString t4910_ninteichosaItakusakiCode;
    @TempTableColumnOrder(77)
    private RString t4910_jigyoshaMeisho;
    @TempTableColumnOrder(78)
    private RString t4913_shichosonCode;
    @TempTableColumnOrder(79)
    private RString t4913_ninteiChosaItakusakiCode;
    @TempTableColumnOrder(80)
    private RString t4913_ninteiChosainCode;
    @TempTableColumnOrder(81)
    private RString t4913_chosainShimei;
    @TempTableColumnOrder(82)
    private RString t4911_shichosonCode;
    @TempTableColumnOrder(83)
    private RString t4911_shujiiIryokikanCode;
    @TempTableColumnOrder(84)
    private RString t4911_iryoKikanMeisho;
    @TempTableColumnOrder(85)
    private RString t4912_shichosonCode;
    @TempTableColumnOrder(86)
    private RString t4912_shujiiIryokikanCode;
    @TempTableColumnOrder(87)
    private RString t4912_shujiiCode;
    @TempTableColumnOrder(88)
    private RString t4912_shujiiName;
    @TempTableColumnOrder(89)
    private RString x4120_shinseishoKanriNo;
    @TempTableColumnOrder(90)
    private RString x4120_shinseiTodokedeDaikoKubunCode;
    @TempTableColumnOrder(91)
    private RString x4120_shinseiTodokedeshaShimei;
    @TempTableColumnOrder(92)
    private RString x4120_jigyoshaName;
    @TempTableColumnOrder(93)
    private RString x4001_shichosonCode;
    @TempTableColumnOrder(94)
    private RString x4001_hihokenshaNo;
    @TempTableColumnOrder(95)
    private RString x4001_rirekiNo;
    @TempTableColumnOrder(96)
    private RString x4001_edaban;
    @TempTableColumnOrder(97)
    private RString x4001_jukyuShinseiJiyu;
    @TempTableColumnOrder(98)
    private RString x4001_dataKubun;
    @TempTableColumnOrder(99)
    private int psm_rirekiNo;
    @TempTableColumnOrder(100)
    private RString psm_kanjiShimei;
    @TempTableColumnOrder(101)
    private RString psm_kanaShimei;
    @TempTableColumnOrder(102)
    private RString psm_honsekiZenkokuJushoCode;
    @TempTableColumnOrder(103)
    private RString psm_honsekiJusho;
    @TempTableColumnOrder(104)
    private RString psm_seibetsuCode;
    @TempTableColumnOrder(105)
    private FlexibleDate psm_seinengappiYMD;
    @TempTableColumnOrder(106)
    private RString psm_setaiCode;
    @TempTableColumnOrder(107)
    private ShikibetsuCode psm_shikibetsuCode;
    @TempTableColumnOrder(108)
    private RString psm_gyoseikuCode;
    @TempTableColumnOrder(109)
    private RString psm_gyoseikuName;
    @TempTableColumnOrder(110)
    private RString psm_renrakusaki1;
    @TempTableColumnOrder(111)
    private RString psm_renrakusaki2;
    @TempTableColumnOrder(112)
    private RString psm_chikuCode1;
    @TempTableColumnOrder(113)
    private RString psm_chikuName1;
    @TempTableColumnOrder(114)
    private RString psm_chikuCode2;
    @TempTableColumnOrder(115)
    private RString psm_chikuName2;
    @TempTableColumnOrder(116)
    private RString psm_chikuCode3;
    @TempTableColumnOrder(117)
    private RString psm_chikuName3;
    @TempTableColumnOrder(118)
    private RString psm_choikiCode;
    @TempTableColumnOrder(119)
    private FlexibleDate psm_shoriYMD;
    @TempTableColumnOrder(120)
    private RString t7005_shikibetsuCode;
    @TempTableColumnOrder(121)
    private RString t7005_rojinHokenShichosonCode;
    @TempTableColumnOrder(122)
    private RString t7005_rojinHokenJukyushaNo;
    @TempTableColumnOrder(123)
    private RString t7051_shichosonShokibetsuID;
    @TempTableColumnOrder(124)
    private RString t7051_shichosonMeisho;
    @TempTableColumnOrder(125)
    private RString x1008_shikibetsuCode;
    @TempTableColumnOrder(126)
    private int x1008_rirekiNo;
    @TempTableColumnOrder(127)
    private RString x1008_iryoHokenShubetsuCode;
    @TempTableColumnOrder(128)
    private RString x1008_iryoHokenshaNo;
    @TempTableColumnOrder(129)
    private RString x1008_iryoHokenshaMeisho;
    @TempTableColumnOrder(130)
    private RString x1008_iryoHokenKigoNo;
    @TempTableColumnOrder(131)
    private FlexibleYearMonth x3015_serviceTeikyoYM;
    @TempTableColumnOrder(132)
    private FlexibleYearMonth x3017_serviceTeikyoYM;
    @TempTableColumnOrder(133)
    private RString x3056_hihokenshaNo;
    @TempTableColumnOrder(134)
    private RString x3056_shoKisaiHokenshaNo;
    @TempTableColumnOrder(135)
    private int x3056_rirekiNo;
    @TempTableColumnOrder(135)
    private FlexibleYearMonth x3056_serviceTeikyoYM;
    @TempTableColumnOrder(136)
    private RString x3034_hiHokenshaNo;
    @TempTableColumnOrder(137)
    private FlexibleYearMonth x3034_serviceTeikyoYM;
    @TempTableColumnOrder(138)
    private RString x3034_seiriNo;
    @TempTableColumnOrder(139)
    private RString x2002_choteiNendo;
    @TempTableColumnOrder(140)
    private RString x2002_fukaNendo;
    @TempTableColumnOrder(141)
    private RString x2002_tsuchishoNo;
    @TempTableColumnOrder(142)
    private int x2002_rirekiNo;
    @TempTableColumnOrder(143)
    private RString x2002_hokenryoDankai;
    @TempTableColumnOrder(144)
    private int rank_number;
}
