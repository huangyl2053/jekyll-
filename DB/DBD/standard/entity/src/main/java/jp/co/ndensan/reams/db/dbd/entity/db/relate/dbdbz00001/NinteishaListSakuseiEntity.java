/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbz00001;

import java.util.List;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 負担限度額認定者リストEntity設定処理。
 *
 * @reamsid_L DBD-3960-050 x_liuwei
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
    private RString 利用者負担段階;
    private Decimal 非課税年金勘案額;
    private Decimal 合計所得_含年金収入;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private RString 要介護認定申請情報_厚労省IF識別コード;
    private boolean 受給者台帳Newest_旧措置者フラグ;
    private RString 被保険者台帳情報_住所地特例フラグ;
    private RString 入所施設コード;
    private RString 入所施設名称;
    private DbT4010GemmenGengakuShinseiEntity 減免減額申請;
    private List<SetaiInRisutoEntity> 世帯員リスト;
    private NinnteiJohoEntity 認定情報Entity;
    private DbT4018KaigoHokenFutanGendogakuNinteiEntity 介護保険負担限度額認定Entity;
}
