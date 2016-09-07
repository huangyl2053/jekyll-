package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 高額判定エラー一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempKogakuHanteiEraaEntity extends DbTableEntityBase<TempKogakuHanteiEraaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    private HihokenshaNo hiHokenshaNo;
    private ShikibetsuCode shikibetsuCode;
    private LasdecCode shichosonCode;
    private FlexibleYearMonth serviceTeikyoYM;
    private RString eraaCode;
    private SetaiCode setaiCode;
    private ShikibetsuCode setaiinShikibetsuCode;

// </editor-fold>
}
