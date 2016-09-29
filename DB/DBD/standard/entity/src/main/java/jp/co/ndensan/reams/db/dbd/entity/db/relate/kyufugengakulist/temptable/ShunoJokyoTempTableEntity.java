/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.ZenkokuJushoCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 収納状況一時テーブルEntity
 *
 * @reamsid_L DBD-3610-050 jinge
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShunoJokyoTempTableEntity extends DbTableEntityBase<ShunoJokyoTempTableEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("ShunoJokyoTemp"));
    }

    @PrimaryKey
    @TempTableColumnOrder(1)
    private HihokenshaNo tmp_hihokenshaNo;
    @TempTableColumnOrder(2)
    private ShikibetsuCode tmp_shikibetsuCode;
    @TempTableColumnOrder(3)
    private RString tmp_hihokenshaShimeiKana;
    @TempTableColumnOrder(4)
    private AtenaMeisho tmp_hihokenshaShimei;
    @TempTableColumnOrder(5)
    private SetaiCode tmp_setaiCode;
    @TempTableColumnOrder(6)
    private GyoseikuCode tmp_gyoseikuCode;
    @TempTableColumnOrder(7)
    private RString tmp_gyoseikuName;
    @TempTableColumnOrder(8)
    private ZenkokuJushoCode tmp_jushoCode;
    @TempTableColumnOrder(9)
    private YubinNo tmp_yubinNo;
    @TempTableColumnOrder(10)
    private AtenaJusho tmp_jusho;
    @TempTableColumnOrder(11)
    private FlexibleDate tmp_shikakuShutokuYMD;
    @TempTableColumnOrder(12)
    private FlexibleDate tmp_shikakuSoshitsuYMD;
    @TempTableColumnOrder(13)
    private RString tmp_shikakuSoshitsuJiyuCode;
    @TempTableColumnOrder(14)
    private RString tmp_shikakuKubunCode;
    @TempTableColumnOrder(15)
    private RString tmp_koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(16)
    private boolean tmp_seihoFlag;
    @TempTableColumnOrder(17)
    private Code tmp_koroshoIfShikibetsuCode;
    @TempTableColumnOrder(18)
    private Code tmp_yokaigoJotaiKubunCode;
    @TempTableColumnOrder(19)
    private FlexibleDate tmp_ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(20)
    private FlexibleDate tmp_ninteiYukoKikanShuryoYMD;
    @TempTableColumnOrder(21)
    private FlexibleDate tmp_ninteiYMD;
    @TempTableColumnOrder(22)
    private boolean tmp_shiseityuFlag;
    @TempTableColumnOrder(23)
    private FlexibleDate tmp_jukyuShinseiYMD;
    @TempTableColumnOrder(24)
    @PrimaryKey
    private FlexibleYear tmp_choteiNendo;
    @TempTableColumnOrder(25)
    @PrimaryKey
    private FlexibleYear tmp_fukaNendo;
    @TempTableColumnOrder(26)
    private RString tmp_tokucho_FuchoKubun;
    @TempTableColumnOrder(27)
    @PrimaryKey
    private TsuchishoNo tmp_tsuchishoNo;
    @TempTableColumnOrder(28)
    @PrimaryKey
    private int tmp_kibetsu;
    @TempTableColumnOrder(29)
    private Decimal tmp_choteigaku;
    @TempTableColumnOrder(30)
    private Decimal tmp_shunyugaku;
    @TempTableColumnOrder(31)
    private Decimal tmp_minogaku;
    @TempTableColumnOrder(32)
    private RDate tmp_nokigen;
    @TempTableColumnOrder(33)
    private RDate tmp_shunyuYMD;
    @TempTableColumnOrder(34)
    private RDate tmp_tokusokujoHakkoYMD;
    @TempTableColumnOrder(35)
    private FlexibleDate tmp_jikoKisanYMD;
    @TempTableColumnOrder(36)
    private RString tmp_jikoKisanJiyu;
    @TempTableColumnOrder(37)
    private RString tmp_minoKannoKubun;
    @TempTableColumnOrder(38)
    private RString tmp_jikoKubun;
}
