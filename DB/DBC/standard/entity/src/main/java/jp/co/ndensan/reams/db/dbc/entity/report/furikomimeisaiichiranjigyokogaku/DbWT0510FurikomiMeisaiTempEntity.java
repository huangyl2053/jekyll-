/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 振込明細一覧Entity項目定義クラスです。
 *
 * @reamsid_L DBC-4870-070 wangxingpeng
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DbWT0510FurikomiMeisaiTempEntity extends DbTableEntityBase<DbWT0510FurikomiMeisaiTempEntity>
        implements IDbAccessable {

    @TempTableColumnOrder(1)
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(3)
    private FlexibleYear taishoNendo;
    @TempTableColumnOrder(4)
    private RString shikyuShinseishoSeiriNo;
    @TempTableColumnOrder(5)
    private int rirekiNo;
    @TempTableColumnOrder(6)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(7)
    private RString ketteiTsuchiNo;
    @TempTableColumnOrder(8)
    private Decimal furikomiKingaku;
    @TempTableColumnOrder(9)
    private FlexibleDate keisanKaishiYMD;
    @TempTableColumnOrder(10)
    private FlexibleDate keisanShuryoYMD;
    @TempTableColumnOrder(11)
    private FlexibleDate shinseiYMD;
    @TempTableColumnOrder(12)
    private FlexibleDate ketteiYMD;
    @TempTableColumnOrder(13)
    private Decimal jikoFutanSogaku;
    @TempTableColumnOrder(14)
    private RString shiharaiHohoKubunCode;
    @TempTableColumnOrder(15)
    private long kozaID;
    @TempTableColumnOrder(16)
    private RString shiharaiBasho;
    @TempTableColumnOrder(17)
    private FlexibleDate shiharaiKaishiYMD;
    @TempTableColumnOrder(18)
    private FlexibleDate shiharaiShuryoYMD;
    @TempTableColumnOrder(19)
    private RTime shiharaiKaishiTime;
    @TempTableColumnOrder(20)
    private RTime shiharaiShuryoTime;
    @TempTableColumnOrder(21)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(22)
    private AtenaKanaMeisho shimeiKana;
    @TempTableColumnOrder(23)
    private AtenaMeisho shimei;
    @TempTableColumnOrder(24)
    private RString shimei50onKana;
    @TempTableColumnOrder(25)
    private ChoikiCode choikiCode;
    @TempTableColumnOrder(26)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(27)
    private RString gyoseikuMei;
    @TempTableColumnOrder(28)
    private YubinNo yubinNo;
    @TempTableColumnOrder(29)
    private AtenaJusho jusho;
    @TempTableColumnOrder(30)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(31)
    private boolean kozaDataFlag;
    @TempTableColumnOrder(32)
    private ShikibetsuCode kozaShikibetsuCode;
    @TempTableColumnOrder(33)
    private KinyuKikanCode kinyuKikanCode;
    @TempTableColumnOrder(34)
    private RString kinyuKikanName;
    @TempTableColumnOrder(35)
    private RString kinyuKikanKanaName;
    @TempTableColumnOrder(36)
    private KinyuKikanShitenCode kinyuKikanShitenCode;
    @TempTableColumnOrder(37)
    private RString kinyuKikanShitenName;
    @TempTableColumnOrder(38)
    private RString kinyuKikanShitenKanaName;
    @TempTableColumnOrder(39)
    private RString yokinShubetsuCode;
    @TempTableColumnOrder(40)
    private RString yokinShubetsuName;
    @TempTableColumnOrder(41)
    private RString kozaNo;
    @TempTableColumnOrder(42)
    private AtenaKanaMeisho kozaMeiginin;
    @TempTableColumnOrder(43)
    private AtenaMeisho kozaMeigininKanji;
    @TempTableColumnOrder(44)
    private RString kozaNayoseKey;
    @TempTableColumnOrder(45)
    private boolean shinseiDataFlag;
    @TempTableColumnOrder(46)
    private Code shinseiKubunCode;
    @TempTableColumnOrder(47)
    private Code yokaigoJotaiKubunCode;
    @TempTableColumnOrder(48)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(49)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(50)
    private boolean sogoJigyoFlag;
    @TempTableColumnOrder(51)
    private FlexibleDate sogoJigyoTekiyoKaishiYMD;
    @TempTableColumnOrder(52)
    private FlexibleDate sogoJigyoTekiyoShuryoYMD;
//    @TempTableColumnOrder(53)
//    private RString hihokenshaShime;

}
