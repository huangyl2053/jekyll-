/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd519001.temp;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定申請情報一時テーブル
 *
 * @reamsid_L DBD-1480-040 liuyl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiShinseiJohoTempEntity extends DbTableEntityBase<NinteiShinseiJohoTempEntity> implements IDbAccessable {

    /**
     * 要介護認定申請情報一時テーブル名称
     */
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("NinteiShinseiJohoTemp");
    }
    @TempTableColumnOrder(1)
    private ShinseishoKanriNo shinseishoKanriNo;
    @TempTableColumnOrder(2)
    private Code koroshoIfShikibetsuCode;
    @TempTableColumnOrder(3)
    private RString shoKisaiHokenshaNo;
    @TempTableColumnOrder(4)
    private FlexibleYear shinseiNendo;
    @TempTableColumnOrder(5)
    private RString hihokenshaNo;
    @TempTableColumnOrder(6)
    private FlexibleDate ninteiShinseiYMD;
    @TempTableColumnOrder(7)
    private EdabanCode ninteiShinseiEdabanCode;
    @TempTableColumnOrder(8)
    private Code ninteiShinseiHoreiKubunCode;
    @TempTableColumnOrder(9)
    private Code ninteiShinseiShinseijiKubunCode;
    @TempTableColumnOrder(10)
    private Code torisageKubunCode;
    @TempTableColumnOrder(11)
    private RString hihokenshaKubunCode;
    @TempTableColumnOrder(12)
    private FlexibleDate seinengappiYMD;
    @TempTableColumnOrder(13)
    private int age;
    @TempTableColumnOrder(14)
    private Code seibetsu;
    @TempTableColumnOrder(15)
    private AtenaKanaMeisho hihokenshaKana;
    @TempTableColumnOrder(16)
    private AtenaMeisho hihokenshaName;
    @TempTableColumnOrder(17)
    private YubinNo yubinNo;
    @TempTableColumnOrder(18)
    private AtenaJusho jusho;
    @TempTableColumnOrder(19)
    private TelNo telNo;
    @TempTableColumnOrder(20)
    private RString shishoCode;
    @TempTableColumnOrder(21)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(22)
    private ChikuCode chikuCode;
    @TempTableColumnOrder(23)
    private boolean minashiNigoEtcTaishoFlag;
    @TempTableColumnOrder(24)
    private Code koikinaiTenkyoKubun;
    @TempTableColumnOrder(25)
    private Code ninteiShinseiYukoKubunCode;
    @TempTableColumnOrder(26)
    private RString shienShinseiKubun;
    @TempTableColumnOrder(27)
    private RString ninteiShinseiRiyu;
    @TempTableColumnOrder(28)
    private RString shinseiServiceDeleteRiyu;
    @TempTableColumnOrder(29)
    private Code zenYokaigoKubunCode;
    @TempTableColumnOrder(30)
    private FlexibleDate zenkaiNinteiYMD;
    @TempTableColumnOrder(31)
    private FlexibleDate zenkaiYukoKikanStart;
    @TempTableColumnOrder(32)
    private FlexibleDate zenkaiYukoKikanEnd;
    @TempTableColumnOrder(33)
    private RString nigoIryoHokenshaName;
    @TempTableColumnOrder(34)
    private RString nigoIryoHokenKigoBango;
    @TempTableColumnOrder(35)
    private Code nigoTokuteiShippeiCode;
    @TempTableColumnOrder(36)
    private RString jidoWariateJogaishaKubun;
    @TempTableColumnOrder(37)
    private boolean johoteikyoDoiFlag;
    @TempTableColumnOrder(38)
    private FlexibleDate johoteikyoSiryoOutputYMD;
    @TempTableColumnOrder(39)
    private Code chosaKubun;
    @TempTableColumnOrder(40)
    private ChosaItakusakiCode ninteiChosaItakusakiCode;
    @TempTableColumnOrder(41)
    private ChosainCode ninteiChosainCode;
    @TempTableColumnOrder(42)
    private RString renrakuJikoToChosain;
    @TempTableColumnOrder(43)
    private RString shujiiIryokikanCode;
    @TempTableColumnOrder(44)
    private RString shujiiCode;
    @TempTableColumnOrder(45)
    private boolean shiteiiFlag;
    @TempTableColumnOrder(46)
    private Code ikenshoDataShubetsu;
    @TempTableColumnOrder(47)
    private RString renrakuJikoToShujii;
    @TempTableColumnOrder(48)
    private boolean enkitsuchiNashiDoiFlag;
    @TempTableColumnOrder(49)
    private boolean shisetsuNyushoFlag;
    @TempTableColumnOrder(50)
    private JigyoshaNo nyushoShisetsuCode;
    @TempTableColumnOrder(51)
    private boolean kateiHomonFlag;
    @TempTableColumnOrder(52)
    private YubinNo homonChosasakiYubinNo;
    @TempTableColumnOrder(53)
    private AtenaJusho homonChosasakiJusho;
    @TempTableColumnOrder(54)
    private AtenaMeisho homonChosasakiName;
    @TempTableColumnOrder(55)
    private TelNo homonChosasakiTelNo;
    @TempTableColumnOrder(56)
    private RString shichosonRenrakuJiko;
    @TempTableColumnOrder(57)
    private Code shoriJotaiKubun;
    @TempTableColumnOrder(58)
    private FlexibleDate torisageYMD;
    @TempTableColumnOrder(59)
    private RString torisageRiyu;
    @TempTableColumnOrder(60)
    private FlexibleDate kyakkaYMD;
    @TempTableColumnOrder(61)
    private RString kyakkaRiyu;
    @TempTableColumnOrder(62)
    private FlexibleDate enkiKetteiYMD;
    @TempTableColumnOrder(63)
    private RString enkiRiyu;
    @TempTableColumnOrder(64)
    private FlexibleDate enkiTsuchiHakkoYMD;
    @TempTableColumnOrder(65)
    private int enkiTsuchiHakkoKaisu;
    @TempTableColumnOrder(66)
    private FlexibleDate enkiMikomiKaishiYMD;
    @TempTableColumnOrder(67)
    private FlexibleDate enkiMikomiShuryoYMD;
    @TempTableColumnOrder(68)
    private boolean shinsaKeizokuFlag;
    @TempTableColumnOrder(69)
    private Code shinsakaiYusenWaritsukeKubunCode;
    @TempTableColumnOrder(70)
    private FlexibleDate koshinTsuchiHakkoYMD;
    @TempTableColumnOrder(71)
    private FlexibleDate koshinTsuchiHakkoKanryoYMD;
    @TempTableColumnOrder(72)
    private FlexibleDate ninteiShinseiJohoTorokuYMD;
    @TempTableColumnOrder(73)
    private int saiChosaIraiKaisu;
    @TempTableColumnOrder(74)
    private int saiSakuseiIraiKaisu;
    @TempTableColumnOrder(75)
    private FlexibleDate ifSofuYMD;
    @TempTableColumnOrder(76)
    private boolean logicalDeletedFlag;

}
