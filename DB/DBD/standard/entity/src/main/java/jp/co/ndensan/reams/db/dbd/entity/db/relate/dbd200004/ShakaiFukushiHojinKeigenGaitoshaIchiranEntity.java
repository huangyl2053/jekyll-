/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd200004;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * MapperIFの戻り値
 *
 * @reamsid_L DBD-3830-050 tianyh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class ShakaiFukushiHojinKeigenGaitoshaIchiranEntity {

    private HihokenshaNo 被保険者番号;
    private UaFt200FindShikibetsuTaishoEntity 宛名;
    private RString 本人課税区分;
    private boolean is老齢福祉年金受給者;
    private boolean is所得税課税者;
    private boolean is生活保護受給者;
    private RString 要介護状態区分コード;
    private RString 厚労省IF識別コード;
    private FlexibleDate 認定年月日;
    private FlexibleDate 認定有効期間開始日;
    private FlexibleDate 認定有効期間終了日;
    private boolean 旧措置者フラグ;
    private ShafukuRiyoshaFutanKeigenEntity 社会福祉法人等利用者負担軽減の情報;
    private RString 入所施設コード;
    private RString 入所施設名称;
    private RString 計画事業者番号;
    private RString 計画事業者名;
    private boolean is自己作成;
    private List<Setaiinshotokujoho> 世帯員リスト;

}
