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
public class JukyushaDaichoCyouhyoujouhouTempTableEntity
        extends DbTableEntityBase<JukyushaDaichoCyouhyoujouhouTempTableEntity> implements IDbAccessable {

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
    private int psm_rirekiNo;
    @TempTableColumnOrder(35)
    private RString psm_kanjiShimei;
    @TempTableColumnOrder(36)
    private RString psm_kanaShimei;
    @TempTableColumnOrder(37)
    private RString psm_honsekiZenkokuJushoCode;
    @TempTableColumnOrder(38)
    private RString psm_honsekiJusho;
    @TempTableColumnOrder(39)
    private RString psm_seibetsuCode;
    @TempTableColumnOrder(40)
    private FlexibleDate psm_seinengappiYMD;
    @TempTableColumnOrder(41)
    private RString psm_setaiCode;
    @TempTableColumnOrder(42)
    private ShikibetsuCode psm_shikibetsuCode;
    @TempTableColumnOrder(43)
    private RString psm_gyoseikuCode;
    @TempTableColumnOrder(44)
    private RString psm_gyoseikuName;
    @TempTableColumnOrder(45)
    private RString psm_renrakusaki1;
    @TempTableColumnOrder(46)
    private RString psm_renrakusaki2;
    @TempTableColumnOrder(47)
    private RString psm_chikuCode1;
    @TempTableColumnOrder(48)
    private RString psm_chikuName1;
    @TempTableColumnOrder(49)
    private RString psm_chikuCode2;
    @TempTableColumnOrder(50)
    private RString psm_chikuName2;
    @TempTableColumnOrder(51)
    private RString psm_chikuCode3;
    @TempTableColumnOrder(52)
    private RString psm_chikuName3;
    @TempTableColumnOrder(53)
    private RString psm_choikiCode;
    @TempTableColumnOrder(54)
    private FlexibleDate psm_shoriYMD;
    @TempTableColumnOrder(55)
    private RString t7005_shikibetsuCode;
    @TempTableColumnOrder(56)
    private RString t7005_rojinHokenShichosonCode;
    @TempTableColumnOrder(57)
    private RString t7005_rojinHokenJukyushaNo;
    @TempTableColumnOrder(58)
    private RString t7051_shichosonShokibetsuID;
    @TempTableColumnOrder(59)
    private RString t7051_shichosonMeisho;
    @TempTableColumnOrder(60)
    private RString x1008_shikibetsuCode;
    @TempTableColumnOrder(61)
    private int x1008_rirekiNo;
    @TempTableColumnOrder(62)
    private RString x1008_iryoHokenShubetsuCode;
    @TempTableColumnOrder(63)
    private RString x1008_iryoHokenshaNo;
    @TempTableColumnOrder(64)
    private RString x1008_iryoHokenshaMeisho;
    @TempTableColumnOrder(65)
    private RString x1008_iryoHokenKigoNo;
    @TempTableColumnOrder(66)
    private FlexibleYearMonth x3015_serviceTeikyoYM;
    @TempTableColumnOrder(67)
    private FlexibleYearMonth x3017_serviceTeikyoYM;
    @TempTableColumnOrder(68)
    private RString x3056_hihokenshaNo;
    @TempTableColumnOrder(69)
    private RString x3056_shoKisaiHokenshaNo;
    @TempTableColumnOrder(70)
    private int x3056_rirekiNo;
    @TempTableColumnOrder(71)
    private FlexibleYearMonth x3056_serviceTeikyoYM;
    @TempTableColumnOrder(72)
    private RString x3034_hiHokenshaNo;
    @TempTableColumnOrder(73)
    private FlexibleYearMonth x3034_serviceTeikyoYM;
    @TempTableColumnOrder(74)
    private RString x3034_seiriNo;
    @TempTableColumnOrder(75)
    private RString x2002_choteiNendo;
    @TempTableColumnOrder(76)
    private RString x2002_fukaNendo;
    @TempTableColumnOrder(77)
    private RString x2002_tsuchishoNo;
    @TempTableColumnOrder(78)
    private int x2002_rirekiNo;
    @TempTableColumnOrder(79)
    private RString x2002_hokenryoDankai;
    @TempTableColumnOrder(80)
    private int rank_number;
    @TempTableColumnOrder(81)
    private RString temp_T4001rirekiNo;
    @TempTableColumnOrder(82)
    private RString temp_T4001edaban;
}
