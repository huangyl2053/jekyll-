/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00003;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * から取得した訪問介護利用者の負担額が減額認定者リストEntity設定処理。
 *
 * @reamsid_L DBD-3970-050 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteishaListSakuseiEntity {

    private HihokenshaNo 被保険者番号;
    private RString 本人課税区分;
    private boolean is老齢福祉年金受給者;
    private boolean is所得税課税者;
    private boolean is生活保護受給者;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private RString 要介護認定申請情報_厚労省IF識別コード;
    private RString 要介護認定申請情報_2号特定疾病コード;
    private boolean 受給者台帳Newest_旧措置者フラグ;
    private DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity 訪問介護利用者負担額減額;
    private DbT4010GemmenGengakuShinseiEntity 減免減額申請;
    private List<SetaiInRisutoEntity> 世帯員リスト;
    private SougouJigyouTaisyoSyaEntity 総合事業対象者情報Entity;
    private NinnteiJohoEntity 認定情報Entity;

}
