/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kijunshunyugakutekiyokettei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.ChoikiCode;
import jp.co.ndensan.reams.uz.uza.biz.GyoseikuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 基準収入額適用管理entityクラスです。
 *
 * @reamsid_L DBC-4610-030 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KijunShunyugakuTekiyoKetteiEntity extends
        DbTableEntityBase<KijunShunyugakuTekiyoKetteiEntity> implements IDbAccessable {

    private SetaiCode 世帯コード;
    private FlexibleYear 年度;
    private int 履歴番号;
    private HihokenshaNo 被保険者番号;
    private Decimal 算定基準額;
    private FlexibleYearMonth 適用開始年月;
    private FlexibleDate 申請日;
    private FlexibleDate 決定日;
    private ShikibetsuCode 識別コード;
    private boolean 宛先印字対象者フラグ;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    private UaFt250FindAtesakiEntity 宛先Entity;
    private YubinNo 郵便番号;
    private ChoikiCode 町域コード;
    private GyoseikuCode 行政区コード;
    private LasdecCode 市町村コード;
}
