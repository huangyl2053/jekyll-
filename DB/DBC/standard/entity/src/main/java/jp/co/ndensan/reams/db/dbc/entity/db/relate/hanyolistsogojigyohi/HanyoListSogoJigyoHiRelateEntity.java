/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistsogojigyohi;

import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(総合事業費情報)のEntityクラスです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListSogoJigyoHiRelateEntity {

    private RString 市町村コード;
    private RString 被保険者番号;
    private RString 給付実績情報作成区分コード;
    private RString 給付実績区分;
    private RString 証記載保険者番号;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 事業者名称;
    private RString 整理番号;
    private RString 生年月日;
    private RString 性別コード;
    private RString 要介護状態区分コード;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 保険者番号後期;
    private RString 被保険者番号後期;
    private RString 保険者番号国保;
    private RString 被保険者証番号国保;
    private RString 個人番号国保;
    private RString 開始年月日;
    private RString 中止年月日;
    private int 前保険サービス単位数;
    private int 前保険請求額;
    private int 前保険利用者負担額;
    private int 後保険サービス単位数;
    private int 後保険請求額;
    private int 後保険利用者負担額;
    private RString 警告区分コード;
    private RString 審査年月;
    private RString 取込年月;
    private RString 明細サービス種類コード;
    private RString 明細サービス種類名称;
    private RString 明細サービス項目コード;
    private RString 明細サービス名称;
    private int 明細単位数;
    private int 明細日数回数;
    private int 明細サービス単位数;
    private RString 明細摘要;
    private int 明細後単位数;
    private int 明細後日数回数;
    private int 明細後サービス単位数;
    private int 明細再審査回数;
    private int 明細過誤回数;
    private RString 集計サービス種類コード;
    private RString 集計サービス種類名称;
    private int 集計サービス実日数;
    private int 集計計画単位数;
    private int 集計限度額管理対象単位数;
    private int 集計限度額管理対象外単位数;
    private int 集計保険単位数合計;
    private int 集計保険単位数単価;
    private int 集計保険請求額;
    private int 集計保険利用者負担額;
    private int 集計後単位数合計;
    private int 集計後保険請求分請求額;
    private int 集計再審査回数;
    private int 集計過誤回数;
    private RString ケアマネジメント費指定基準該当事業所区分;
    private int ケアマネジメント費単位数単価;
    private RString ケアマネジメント費サービスコード;
    private RString ケアマネジメント費サービス種類名称;
    private int ケアマネジメント費単位数;
    private int ケアマネジメント費回数;
    private int ケアマネジメント費サービス単位数;
    private int ケアマネジメント費サービス単位数合計;
    private int ケアマネジメント費請求金額;
    private RString ケアマネジメント費摘要;
    private int ケアマネジメント費利用者負担額;
    private int ケアマネジメント費後単位数;
    private int ケアマネジメント費後回数;
    private int ケアマネジメント費後サービス単位数;
    private int ケアマネジメント費後サービス単位数合計;
    private int ケアマネジメント費後請求金額;
    private int ケアマネジメント費後利用者負担額;
    private int ケアマネジメント費再審査回数;
    private int ケアマネジメント費過誤回数;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
}
