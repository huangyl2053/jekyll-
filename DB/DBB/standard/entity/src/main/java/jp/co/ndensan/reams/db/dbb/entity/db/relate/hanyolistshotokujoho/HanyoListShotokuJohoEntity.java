/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.hanyolistshotokujoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt250FindAtesakiEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBBBT22002_汎用リスト 所得情報Entityのクラス
 *
 * @reamsid_L DBB-1901-030 surun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShotokuJohoEntity {

    private FlexibleYear 所得年度;
    private ShikibetsuCode 識別コード;
    private RString 課税区分減免前;
    private RString 課税区分減免後;
    private Decimal 合計所得金額;
    private Decimal 公的年金収入額;
    private Decimal 公的年金所得額;
    private Decimal 課税所得額;
    private RString 激変緩和措置区分;
    private RString 優先区分;
    private YMDHMS 処理日時;
    private HihokenshaNo dbv1001被保険者番号;
    private FlexibleDate 異動日;
    private RString 枝番;
    private RString 異動事由コード;
    private LasdecCode 市町村コード;
    private ShikibetsuCode dbv1001識別コード;
    private RString 資格取得事由コード;
    private FlexibleDate 資格取得年月日;
    private FlexibleDate 資格取得届出年月日;
    private FlexibleDate 第1号資格取得年月日;
    private RString 被保険者区分コード;
    private RString 資格喪失事由コード;
    private FlexibleDate 資格喪失年月日;
    private FlexibleDate 資格喪失届出年月日;
    private RString 資格変更事由コード;
    private FlexibleDate 資格変更年月日;
    private FlexibleDate 資格変更届出年月日;
    private RString 住所地特例適用事由コード;
    private FlexibleDate 適用年月日;
    private FlexibleDate 適用届出年月日;
    private RString 住所地特例解除事由コード;
    private FlexibleDate 解除年月日;
    private FlexibleDate 解除届出年月日;
    private RString 住所地特例フラグ;
    private RString 広域内住所地特例フラグ;
    private LasdecCode 広住特措置元市町村コード;
    private LasdecCode 旧市町村コード;
    private FlexibleYear 賦課年度;
    private HihokenshaNo 被保険者番号;
    private RString 保険料段階;
    private RString 保険料段階仮算定時;

    /**
     * -- GETTER -- 宛名Entity。
     *
     * @return 宛名Entity -- SETTER -- 宛名Entity。
     *
     * @param 宛名Entity 宛名Entity
     */
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    /**
     * -- GETTER -- 宛先Entity。
     *
     * @return 宛先Entity -- SETTER -- 宛先Entity。
     *
     * @param 宛先Entity 宛先Entity
     */

    private UaFt250FindAtesakiEntity 宛先Entity;

}
