package jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 高額介護サービス費給付対象者明細全件更新一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-2010-040 huzongcheng
 */
@lombok.Setter
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity extends
        DbTableEntityBase<TempKogakuKyufuTaishoshaMeisaiZenUpdateEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private JigyoshaNo jigyoshaNo;
    private ServiceShuruiCode serviceShuruiCode;
    private int rirekiNo;
    private Decimal serviceHiyoGokeiGaku;
    private Decimal riyoshaFutanGaku;
    private RString kogakuKyufuKonkyo;

// </editor-fold>
}
