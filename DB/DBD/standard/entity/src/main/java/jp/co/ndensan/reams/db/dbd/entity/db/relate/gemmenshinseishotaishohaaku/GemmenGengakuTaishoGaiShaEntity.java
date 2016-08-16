/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmenshinseishotaishohaaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.KoroshoInterfaceShikibetsuCode;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 減免・減額更新申請対象外者一覧entityクラスです。
 *
 * @reamsid_L DBD-3530-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenGengakuTaishoGaiShaEntity {

    private RString 本人区分;
    private HihokenshaNo 被保険者番号;
    private ShikibetsuCode 識別コード;
    private LasdecCode 市町村コード;
    private FlexibleDate 基準年月日;
    private FlexibleYear 所得年度;
    private ShoKisaiHokenshaNo 証記載保険者番号;
    private RString 決定区分;
    private FlexibleDate 減免申請日;
    private FlexibleDate 減免決定日;
    private FlexibleDate 減免適用日;
    private FlexibleDate 減免有効期限;
    private RString 世帯課税区分;
    private RString 利用者負担段階;
    private Boolean 老齢福祉年金受給区分;
    private Boolean 生活保護受給区分;
    private Decimal 課税所得額;
    private RString 課税区分;
    private RString 入所施設コード;
    private RString 入所施設名称;
    private RString 要介護認定状態区分コード;
    private KoroshoInterfaceShikibetsuCode 厚労省IF識別コード;
    private RString 旧措置;
    private FlexibleDate 要介護認定日;
    private FlexibleDate 認定開始日;
    private FlexibleDate 認定終了日;
    private UaFt200FindShikibetsuTaishoEntity psmEntity;

}
