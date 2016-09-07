package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TsuzukigaraCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 世帯員所得判定明細高額一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempSetaiinShotokuHanteiEntity extends DbTableEntityBase<TempSetaiinShotokuHanteiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    private HihokenshaNo hihokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private FlexibleDate kijunYMD;
    private FlexibleYear shotokuNendo;
    private RString jushochiTokureiFlag;
    private SetaiCode setaiCode;
    private RString honninKubun;
    private RString kazeiKubun;
    private RString kazeiKubunGemmenGo;
    private RString gekihenKanwaKubun;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkiniShunyuGaku;
    private Decimal nenkiniShotokuGaku;
    private Decimal kazeiShotokuGaku;
    private RString torokuGyomu;
    private LasdecCode shichosonCode;
    private RString shoboKubun;
    private RString roreiFukushi;
    private HihokenshaNo setaiinHihokenshaNo;
    private RString honninKazeiKubun;
    private RString setaiKazeiKubun;
    private FlexibleYear tsuzukigaraCodeNen;
    private TsuzukigaraCode atena_tsuzukigaraCode;
    private RString atena_juminShubetsuCode;
    private FlexibleDate atena_seinengappiYMD;

// </editor-fold>
}
