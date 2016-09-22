/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 収納滞納状況一時テーブルEntity
 *
 * @reamsid_L DBD-3610-050 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoTainoJokyoTempTableEntity extends DbTableEntityBase<ShunoTainoJokyoTempTableEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("ShunoTainoJokyoTemp"));
    }

    @TempTableColumnOrder(1)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(2)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(3)
    private AtenaKanaMeisho hihokenshaShimeiKana;
    @TempTableColumnOrder(4)
    private AtenaMeisho hihokenshaShimei;
    @TempTableColumnOrder(5)
    private SetaiCode setaiCode;
    @TempTableColumnOrder(6)
    private GyoseikuCode gyoseikuCode;
    @TempTableColumnOrder(7)
    private RString gyoseikuName;
    @TempTableColumnOrder(8)
    private ZenkokuJushoCode jushoCode;
    @TempTableColumnOrder(9)
    private YubinNo yubinNo;
    @TempTableColumnOrder(10)
    private RString jusho;
    @TempTableColumnOrder(11)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(12)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(13)
    private RString shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(14)
    private RString 資格区分;
    @TempTableColumnOrder(15)
    private RString koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(16)
    private boolean seihoFlag;
    @TempTableColumnOrder(17)
    private Code koroshoIfShikibetsuCode;
    @TempTableColumnOrder(18)
    private Code yokaigoJotaiKubunCode;
    @TempTableColumnOrder(19)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(21)
    private FlexibleDate ninteiYMD;
    @TempTableColumnOrder(22)
    private boolean shiseityuFlag;
    @TempTableColumnOrder(23)
    private FlexibleDate jukyuShinseiYMD;
    @TempTableColumnOrder(24)
    private RYear choteiNendo;
    @TempTableColumnOrder(25)
    private RYear fukaNendo;
    @TempTableColumnOrder(26)
    private RString tokucho_FuchoKubun;
    @TempTableColumnOrder(27)
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(28)
    private RString kibetsu;
    @TempTableColumnOrder(29)
    private Decimal choteigaku;
    @TempTableColumnOrder(30)
    private Decimal shunyugaku;
    @TempTableColumnOrder(31)
    private Decimal minogaku;
    @TempTableColumnOrder(32)
    private RDate shunyuYMD;
    @TempTableColumnOrder(33)
    private RDate tokusokujoHakkoYMD;
    @TempTableColumnOrder(34)
    private FlexibleDate jikoKisanYMD;
    @TempTableColumnOrder(35)
    private RString jikoKisanJiyu;
    @TempTableColumnOrder(36)
    private RString minoKannoKubun;
    @TempTableColumnOrder(37)
    private RString jikoKubun;
    @TempTableColumnOrder(38)
    private RString tainoKubun;
}
