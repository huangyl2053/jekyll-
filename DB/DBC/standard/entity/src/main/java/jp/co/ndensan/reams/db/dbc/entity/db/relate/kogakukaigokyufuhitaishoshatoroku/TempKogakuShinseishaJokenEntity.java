package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 高額申請者条件高額一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempKogakuShinseishaJokenEntity extends DbTableEntityBase<TempKogakuShinseishaJokenEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    private FlexibleYearMonth saikoServiceTeikyoYM;
    private FlexibleYearMonth saishinServiceTeikyoYM;

// </editor-fold>
}
