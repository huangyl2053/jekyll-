/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd581001;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 受給者台帳一時テーブルのクラスです。
 *
 * @reamsid_L DBD-1771-020 chenxin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class JukyushaDaichoTempEntity extends DbTableEntityBase<JukyushaDaichoTempEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("受給者台帳一時テーブル");

    @TempTableColumnOrder(1)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(2)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    private RString rirekiNo;
    @TempTableColumnOrder(4)
    private RString edaban;
    @TempTableColumnOrder(5)
    private ShinseishoKanriNo shinseishoKanriNo;
    @TempTableColumnOrder(6)
    private RString shinseiJokyoKubun;
    @TempTableColumnOrder(7)
    private RString shishoCode;
    @TempTableColumnOrder(8)
    private boolean chokkinFlag;
    @TempTableColumnOrder(9)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(10)
    private Code jukyuShinseiJiyu;
    @TempTableColumnOrder(11)
    private RString shinseiRiyu;
    @TempTableColumnOrder(12)
    private Code shinseishaKankeiCode;
    @TempTableColumnOrder(13)
    private RString homninKankei;
    @TempTableColumnOrder(14)
    private FlexibleDate jukyuShinseiYMD;
    @TempTableColumnOrder(15)
    private Code nigoTokuteiShippeiCode;
    @TempTableColumnOrder(16)
    private FlexibleDate shinsakaiIraiYMD;
    @TempTableColumnOrder(17)
    private Code yokaigoJotaiKubunCode;
    @TempTableColumnOrder(18)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(19)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate ninteiYMD;
    @TempTableColumnOrder(21)
    private Code minashiCode;
    @TempTableColumnOrder(22)
    private ServiceShuruiCode shiteiServiceShurui01;
    @TempTableColumnOrder(23)
    private ServiceShuruiCode shiteiServiceShurui02;
    @TempTableColumnOrder(24)
    private ServiceShuruiCode shiteiServiceShurui03;
    @TempTableColumnOrder(25)
    private ServiceShuruiCode shiteiServiceShurui04;
    @TempTableColumnOrder(26)
    private ServiceShuruiCode shiteiServiceShurui05;
    @TempTableColumnOrder(27)
    private ServiceShuruiCode shiteiServiceShurui06;
    @TempTableColumnOrder(28)
    private ServiceShuruiCode shiteiServiceShurui07;
    @TempTableColumnOrder(29)
    private ServiceShuruiCode shiteiServiceShurui08;
    @TempTableColumnOrder(30)
    private ServiceShuruiCode shiteiServiceShurui09;
    @TempTableColumnOrder(31)
    private ServiceShuruiCode shiteiServiceShurui10;
    @TempTableColumnOrder(32)
    private ServiceShuruiCode shiteiServiceShurui11;
    @TempTableColumnOrder(33)
    private ServiceShuruiCode shiteiServiceShurui12;
    @TempTableColumnOrder(34)
    private ServiceShuruiCode shiteiServiceShurui13;
    @TempTableColumnOrder(35)
    private ServiceShuruiCode shiteiServiceShurui14;
    @TempTableColumnOrder(36)
    private ServiceShuruiCode shiteiServiceShurui15;
    @TempTableColumnOrder(37)
    private ServiceShuruiCode shiteiServiceShurui16;
    @TempTableColumnOrder(38)
    private ServiceShuruiCode shiteiServiceShurui17;
    @TempTableColumnOrder(39)
    private ServiceShuruiCode shiteiServiceShurui18;
    @TempTableColumnOrder(40)
    private ServiceShuruiCode shiteiServiceShurui19;
    @TempTableColumnOrder(41)
    private ServiceShuruiCode shiteiServiceShurui20;
    @TempTableColumnOrder(42)
    private ServiceShuruiCode shiteiServiceShurui21;
    @TempTableColumnOrder(43)
    private ServiceShuruiCode shiteiServiceShurui22;
    @TempTableColumnOrder(44)
    private ServiceShuruiCode shiteiServiceShurui23;
    @TempTableColumnOrder(45)
    private ServiceShuruiCode shiteiServiceShurui24;
    @TempTableColumnOrder(46)
    private ServiceShuruiCode shiteiServiceShurui25;
    @TempTableColumnOrder(47)
    private ServiceShuruiCode shiteiServiceShurui26;
    @TempTableColumnOrder(48)
    private ServiceShuruiCode shiteiServiceShurui27;
    @TempTableColumnOrder(49)
    private ServiceShuruiCode shiteiServiceShurui28;
    @TempTableColumnOrder(50)
    private ServiceShuruiCode shiteiServiceShurui29;
    @TempTableColumnOrder(51)
    private ServiceShuruiCode shiteiServiceShurui30;
    @TempTableColumnOrder(52)
    private FlexibleDate soshitsuYMD;
    @TempTableColumnOrder(53)
    private FlexibleDate chokkinIdoYMD;
    @TempTableColumnOrder(54)
    private Code chokkinIdoJiyuCode;
    @TempTableColumnOrder(55)
    private Code yukoMukoKubun;
    @TempTableColumnOrder(56)
    private Code dataKubun;
    @TempTableColumnOrder(57)
    private RString remban;
    @TempTableColumnOrder(58)
    private RString idoRiyu;
    @TempTableColumnOrder(59)
    private Code shinseishoKubun;
    @TempTableColumnOrder(60)
    private Code sakujoJiyuCode;
    @TempTableColumnOrder(61)
    private boolean yoshienshaNinteiShinseiFlag;
    @TempTableColumnOrder(62)
    private Decimal shikyuGendoTanisu;
    @TempTableColumnOrder(63)
    private FlexibleDate shikyuGendoKaishiYMD;
    @TempTableColumnOrder(64)
    private FlexibleDate shikyuGendoShuryoYMD;
    @TempTableColumnOrder(65)
    private int tankiSikyuGendoNissu;
    @TempTableColumnOrder(66)
    private FlexibleDate tankiShikyuGendoKaishiYMD;
    @TempTableColumnOrder(67)
    private FlexibleDate tankiShikyuGendoShuryoYMD;
    @TempTableColumnOrder(68)
    private FlexibleDate toshoNinteiYukoKaishiYMD;
    @TempTableColumnOrder(69)
    private FlexibleDate toshoNinteiYukoShuryoYMD;
    @TempTableColumnOrder(70)
    private FlexibleDate jukyuShikakuShomeishoHakkoYMD1;
    @TempTableColumnOrder(71)
    private FlexibleDate jukyuShikakuShomeishoHakkoYMD2;
    @TempTableColumnOrder(72)
    private FlexibleDate shindanMeireishoHakkoYMD;
    @TempTableColumnOrder(73)
    private FlexibleDate nigoShinseiJuriTsuchishoHakkoYMD;
    @TempTableColumnOrder(74)
    private FlexibleDate ninteiKekkaTsuchishoHakkoYMD;
    @TempTableColumnOrder(75)
    private FlexibleDate kubunHenkoTsuchishoHakkoYMD;
    @TempTableColumnOrder(76)
    private FlexibleDate serviceHenkoTsuchishoHakkoYMD;
    @TempTableColumnOrder(77)
    private FlexibleDate ninteiKyakkaTsuchishoHakkoYMD;
    @TempTableColumnOrder(78)
    private FlexibleDate ninteiTorikeshiTsuchishoHakkoYMD;
    @TempTableColumnOrder(79)
    private boolean shikakuShutokuMaeShinseiFlag;
    @TempTableColumnOrder(80)
    private boolean kyuSochishaFlag;
    @TempTableColumnOrder(81)
    private boolean logicalDeletedFlag;
    @TempTableColumnOrder(82)
    private FlexibleDate ninteichosaIraiYMD;
    @TempTableColumnOrder(83)
    private FlexibleDate ninteichosaJisshiYMD;
    @TempTableColumnOrder(84)
    private FlexibleDate ikenshoSakuseiIraiYMD;
    @TempTableColumnOrder(85)
    private FlexibleDate ikenshoJuryoYMD;
    @TempTableColumnOrder(86)
    private FlexibleDate ninteiShinsakaiWariateYoteiYMD;
    @TempTableColumnOrder(87)
    private FlexibleDate ninteichosaYoteiYMD;
    @TempTableColumnOrder(88)
    private FlexibleDate ikenshoSakuseiIraiYoteiYMD;

    @TempTableColumnOrder(90)
    private RString shichosonMeisho;
    @TempTableColumnOrder(91)
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    @TempTableColumnOrder(92)
    private FlexibleDate shinsakaiYoteiYMD;
    @TempTableColumnOrder(93)
    private FlexibleDate shikakuSoshitsuYMD;

    @TempTableColumnOrder(94)
    private RString ninteiYM;
    @TempTableColumnOrder(95)
    private RString jukyuShinseiYM;
    @TempTableColumnOrder(96)
    private RString ninteichosaIraiYM;
    @TempTableColumnOrder(97)
    private RString ninteichosaJisshiYM;
    @TempTableColumnOrder(98)
    private RString ikenshoSakuseiIraiYM;
    @TempTableColumnOrder(99)
    private RString ikenshoJuryoYM;
    @TempTableColumnOrder(100)
    private RString shinsakaiIraiYM;
    @TempTableColumnOrder(101)
    private RString ninteiShinsakaiWariateYoteiYM;
    @TempTableColumnOrder(102)
    private RString shinsakaiShiryoSakuseiYM;
    @TempTableColumnOrder(103)
    private RString ninteichosaYoteiYM;
    @TempTableColumnOrder(104)
    private RString ikenshoSakuseiIraiYoteiYM;

}
