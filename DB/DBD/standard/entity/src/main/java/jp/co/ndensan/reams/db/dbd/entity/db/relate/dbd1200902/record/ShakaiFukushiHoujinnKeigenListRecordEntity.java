/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd1200902.record;

import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担額認定証・決定通知書発行一覧表
 *
 * @reamsid_L DBD-3981-030 x_miaocl
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShakaiFukushiHoujinnKeigenListRecordEntity extends DbTableEntityBase<ShakaiFukushiHoujinnKeigenListRecordEntity> implements IDbAccessable {

    public static final RString TABLE_NAME = new RString("FutanGenndoGakuNinnteiListRecordEntity");
    private RString 確認番号;
    private HihokenshaNo 被保険者番号;
    private IKojin IKojin;
    private FlexibleDate 申請日;
    private FlexibleDate 決定日;
    private FlexibleDate 適用日;
    private FlexibleDate 有効期限;
    private KetteiKubun 決定;
    private KyuSochishaKubun 軽減;
    private Decimal 軽減率_分子;
    private Decimal 軽減率_分母;
    private boolean 居宅サービス限定;
    private boolean 居住費_食費のみ;
    private boolean 旧措置者ユニット型個室のみ;
    private boolean 認定証発行済み;
    private boolean 通知書発行済み;
    private boolean 認定証発行フラグ;
    private boolean 通知書発行フラグ;
    private FlexibleDate 喪失年月日;

}
