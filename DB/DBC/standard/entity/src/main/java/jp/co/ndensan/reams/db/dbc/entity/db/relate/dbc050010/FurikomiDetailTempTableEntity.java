/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 振込明細一時テーブルクラスです．
 *
 * @reamsid_L DBC-5010-030 x_lilh
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class FurikomiDetailTempTableEntity extends DbTableEntityBase<FurikomiDetailTempTableEntity> implements IDbAccessable {

    /**
     * 振込明細一時テーブル名称
     */
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("DbWT0510FurikomiMeisai");
    }

    @TempTableColumnOrder(1)
    @PrimaryKey
    private RString dataKubun;
    @TempTableColumnOrder(2)
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(3)
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @TempTableColumnOrder(4)
    @PrimaryKey
    private RString seiriNo;
    @TempTableColumnOrder(5)
    @PrimaryKey
    private int rirekiNo;
    @TempTableColumnOrder(6)
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(7)
    private RString ketteiTsuchiNo;
    @TempTableColumnOrder(8)
    private Decimal furikomiKingaku;
    @TempTableColumnOrder(9)
    private Decimal zenkaiShiharaiKingaku;
    @TempTableColumnOrder(10)
    private Decimal sagakuKingakuGokei;
    @TempTableColumnOrder(11)
    private RString shiharaiHohoKubunCode;
    @TempTableColumnOrder(12)
    private long kozaID;
    @TempTableColumnOrder(13)
    private RString juryoininKeiyakuNo;
    @TempTableColumnOrder(14)
    private RString shiharaiBasho;
    @TempTableColumnOrder(15)
    private FlexibleDate shiharaiKaishiYMD;
    @TempTableColumnOrder(16)
    private FlexibleDate shiharaiShuryoYMD;
    @TempTableColumnOrder(17)
    private RString shiharaiKaishiTime;
    @TempTableColumnOrder(18)
    private RString shiharaiShuryoTime;
    @TempTableColumnOrder(19)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(20)
    private AtenaKanaMeisho shimeiKana;
    @TempTableColumnOrder(21)
    private AtenaMeisho shimei;
    @TempTableColumnOrder(22)
    private RString shimei50onKana;
    @TempTableColumnOrder(23)
    private ChoikiCode choikiCode;
    @TempTableColumnOrder(24)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(25)
    private RString gyoseikuMei;
    @TempTableColumnOrder(26)
    private YubinNo yubinNo;
    @TempTableColumnOrder(27)
    private RString jusho;
    @TempTableColumnOrder(28)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(29)
    private boolean kozaDataFlag;
    @TempTableColumnOrder(30)
    private ShikibetsuCode kozaShikibetsuCode;
    @TempTableColumnOrder(31)
    private KinyuKikanCode kinyuKikanCode;
    @TempTableColumnOrder(32)
    private RString kinyuKikanName;
    @TempTableColumnOrder(33)
    private RString kinyuKikanKanaName;
    @TempTableColumnOrder(34)
    private KinyuKikanShitenCode kinyuKikanShitenCode;
    @TempTableColumnOrder(35)
    private RString kinyuKikanShitenName;
    @TempTableColumnOrder(36)
    private RString kinyuKikanShitenKanaName;
    @TempTableColumnOrder(37)
    private RString yokinShubetsuCode;
    @TempTableColumnOrder(38)
    private RString yokinShubetsuName;
    @TempTableColumnOrder(39)
    private RString kozaNo;
    @TempTableColumnOrder(40)
    private AtenaKanaMeisho kozaMeiginin;
    @TempTableColumnOrder(41)
    private AtenaMeisho kozaMeigininKanji;
    @TempTableColumnOrder(42)
    private RString kozaNayoseKey;
    @TempTableColumnOrder(43)
    private boolean shinseiDataFlag;
    @TempTableColumnOrder(44)
    private Code shinseiKubunCode;
    @TempTableColumnOrder(45)
    private Code yokaigoJotaiKubunCode;
    @TempTableColumnOrder(46)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(47)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
}
