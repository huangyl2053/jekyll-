/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkokuhorenjukyusha;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト 国保連受給者情報Entityクラスです。
 *
 * @reamsid_L DBC-3104-020 yaodongsheng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKokuhorenJukyushaRelateEntity {

    private RString 市町村コード;
    private RString 二次予防事業対象者_適用開始年月日;
    private RString 二次予防事業対象者_適用終了年月日;
    private RString 調査実施日;
    private RString 決定年月日;
    private RString 送付年月;
    private RString 被保険者番号;
    private int 履歴番号;
    private RString 異動年月日;
    private RString 異動区分コード;
    private RString 受給者異動事由;
    private RString 証記載保険者番号;
    private RString 被保険者氏名カナ;
    private RString 生年月日;
    private RString 性別コード;
    private RString 資格取得年月日;
    private RString 資格喪失年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 公費負担者番号;
    private RString 広域連合政令市保険者番号;
    private RString 申請種別コード;
    private RString 変更申請中区分コード;
    private RString 申請年月日;
    private RString みなし要介護状態区分コード;
    private RString 要介護状態区分コード;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString 居宅サービス計画作成区分コード;
    private RString 居宅介護支援事業所番号;
    private RString 事業者番号;
    private RString 居宅サービス計画適用開始年月日;
    private RString 居宅サービス計画適用終了年月日;
    private int 訪問通所サービス支給限度基準額;
    private RString 訪問通所サービス上限管理適用期間開始年月日;
    private RString 訪問通所サービス上限管理適用期間終了年月日;
    private int 短期入所サービス支給限度基準額;
    private RString 短期入所サービス上限管理適用期間開始年月日;
    private RString 短期入所サービス上限管理適用期間終了年月日;
    private boolean 公費負担上限額減額有フラグ;
    private RString 償還払化開始年月日;
    private RString 償還払化終了年月日;
    private RString 給付率引下げ開始年月日;
    private RString 給付率引下げ終了年月日;
    private RString 減免申請中区分コード;
    private RString 利用者負担区分コード;
    private int 給付率;
    private RString 適用開始年月日;
    private RString 適用終了年月日;
    private RString 標準負担区分コード;
    private int 負担額;
    private RString 負担額適用開始年月日;
    private RString 負担額適用終了年月日;
    private RString 特定入所者認定申請中区分コード;
    private RString 特定入所者介護サービス区分コード;
    private RString 課税層の特例減額措置対象フラグ;
    private RString 食費負担限度額;
    private RString 居住費ユニット型個室負担限度額;
    private RString 居住費ユニット型準個室負担限度額;
    private RString 居住費従来型個室特養等負担限度額;
    private RString 居住費従来型個室老健療養等負担限度額;
    private RString 居住費多床室負担限度額;
    private RString 負担限度額適用開始年月日;
    private RString 負担限度額適用終了年月日;
    private RString 軽減率;
    private RString 軽減率適用開始年月日;
    private RString 軽減率適用終了年月日;
    private boolean 小多機能居宅介護利用開始月利用有フラグ;
    private RString 後期高齢者医療保険者番号;
    private RString 後期高齢者医療被保険者番号;
    private RString 国民健康保険保険者番号;
    private RString 国民健康保険被保険者証番号;
    private RString 国民健康保険個人番号;
    private RString 二次予防事業有効期間開始年月日;
    private RString 二次予防事業有効期間終了年月日;
    private RString 二次予防事業区分コード;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
}
