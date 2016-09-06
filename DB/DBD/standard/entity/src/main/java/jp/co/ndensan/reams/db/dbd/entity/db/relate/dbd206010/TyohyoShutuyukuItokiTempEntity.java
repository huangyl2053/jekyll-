/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;
import lombok.Getter;
import lombok.Setter;

/**
 * 帳票出力用一時テーブルentityクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TyohyoShutuyukuItokiTempEntity extends
        DbTableEntityBase<TyohyoShutuyukuItokiTempEntity> implements IDbAccessable {

    /**
     * テーブル名です。
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("tyohyoShutuyukuItokiTemp"));
    }
    @TempTableColumnOrder(1)
    private RString jigyoshaNo;
    @TempTableColumnOrder(2)
    private RString jigyoshaName;
    @TempTableColumnOrder(3)
    private RString jigyoshaNameKana;
    @TempTableColumnOrder(4)
    private RString yubinNo;
    @TempTableColumnOrder(5)
    private AtenaJusho jigyoshaAddress;
    @TempTableColumnOrder(6)
    private TelNo telNo;
    @TempTableColumnOrder(7)
    private FlexibleDate yukoKaishiYMD;
    @TempTableColumnOrder(8)
    private FlexibleDate yukoShuryoYMD;

    @TempTableColumnOrder(9)
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @TempTableColumnOrder(10)
    private HihokenshaNo hihokenshaNo;
    @TempTableColumnOrder(11)
    private int rirekiNo;
    @TempTableColumnOrder(12)
    private boolean kyotakuServiceGentei;
    @TempTableColumnOrder(13)
    private boolean kyojuhiShokuhiNomi;
    @TempTableColumnOrder(14)
    private boolean kyusochishaUnitTypeKoshitsuNomi;
    @TempTableColumnOrder(15)
    private RString kakuninNo;
    @TempTableColumnOrder(16)
    private FlexibleDate tekiyoKaishiYMD;
    @TempTableColumnOrder(17)
    private FlexibleDate tekiyoShuryoYMD;

    @TempTableColumnOrder(18)
    private RString shikibetsuCode;
    @TempTableColumnOrder(19)
    private RString hihokennshaKubunCode;
    @TempTableColumnOrder(20)
    private FlexibleDate shikakuShutokuYMD;
    @TempTableColumnOrder(21)
    private RString shikakuShutokuJiyuCode;
    @TempTableColumnOrder(22)
    private FlexibleDate shikakuSoshitsuYMD;
    @TempTableColumnOrder(23)
    private RString shikakuHenkoJiyuCode;
    @TempTableColumnOrder(24)
    private boolean jushochiTokureiFlag;
    @TempTableColumnOrder(25)
    private boolean koikinaiJushochiTokureiFlag;
    @TempTableColumnOrder(26)
    private LasdecCode koikinaiTokureiSochimotoShichosonCode;
    @TempTableColumnOrder(27)
    private LasdecCode shichosonCode;
    @TempTableColumnOrder(28)
    private LasdecCode kyuShichosonCode;

    @TempTableColumnOrder(29)
    private Code yokaigoJotaiKubunCode;
    @TempTableColumnOrder(30)
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    @TempTableColumnOrder(31)
    private FlexibleDate ninteiYukoKikanShuryoYMD;

    @TempTableColumnOrder(32)
    private FlexibleYearMonth taishoYM;
    @TempTableColumnOrder(33)
    private RString sakuseiKubunCode;
    @TempTableColumnOrder(34)
    private RString keikakuJigyoshaNo;

    @TempTableColumnOrder(35)
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @TempTableColumnOrder(36)
    private FlexibleYearMonth shinsaYM;
    @TempTableColumnOrder(37)
    private RString editPattern;
}
