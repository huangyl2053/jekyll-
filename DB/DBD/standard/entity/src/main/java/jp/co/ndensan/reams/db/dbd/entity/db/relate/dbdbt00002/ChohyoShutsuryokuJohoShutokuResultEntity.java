/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt00002;

import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.TaishoshaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 利用者負担額減免認定者リストEntityクラスです．
 *
 * @reamsid_L DBD-3980-050 x_youyj
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChohyoShutsuryokuJohoShutokuResultEntity extends DbTableEntityBase<TaishoshaJohoTempTableEntity> implements IDbAccessable {
    private HihokenshaNo 被保険者番号;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;
    private RString 本人課税区分;
    private boolean is老齢福祉年金受給者;
    private boolean is所得税課税者;
    private boolean is生活保護受給者;
    private RString 厚労省IF識別コード;
    private boolean 旧措置者フラグ;
    private DbT4014RiyoshaFutangakuGengakuEntity 利用者負担額減額Entity;
    private DbT4010GemmenGengakuShinseiEntity 減免減額申請Entity;
    private RString 入所施設コード;
    private RString 入所施設名称;
    private SeteiYouEntity 世帯員Entity;
    private HihokenshaNo 総者の被保険者番号;
    private FlexibleDate 総者のチェックリスト実施日;
    private FlexibleDate 総者の適用開始年月日;
    private FlexibleDate 総者の適用終了年月日;
    private HihokenshaNo 認定情報の被保険者番号;
    private RString 認定情報の要介護状態区分コード;
    private FlexibleDate 認定情報の認定年月日;
    private FlexibleDate 認定情報の認定有効期間開始年月日;
    private FlexibleDate 認定情報の認定有効期間終了年月日;
    private FlexibleDate 帳票作成日時;
    private RString 出力順;
    private RString 導入団体コード;
    private RString 導入団体名称;
    private RString 帳票ID;
    private RString 帳票タイトル;
    private RString 改ページ;
}
