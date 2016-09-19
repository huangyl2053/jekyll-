/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.saishinsamoshitatetouroku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護給付費再審査申立書作成のRelateEntityです。
 *
 * @reamsid_L DBC-2230-030 chenxiangyu
 */
@lombok.Getter
@lombok.Setter
public class SaishinsaMoshitateTourokuRelateEntity implements Serializable {

    private RString 氏名;
    private RString 証記載保険者名;
    private RString 事業者名;
    private RString 行番号;
    private RString サービス種類コード;
    private RString サービス種類略称;
    private RString サービス項目コード;
    private RString サービス略称;
    private RString サービス名称;
    private RString 最大履歴番号;
    private RString insertDantaiCd;
    private RString insertTimestamp;
    private RString insertReamsLoginId;
    private RString insertContextId;
    private RString isDeleted;
    private RString updateCount;
    private RString lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private RString 交換情報識別番号;
    private RString 入力識別番号;
    private RString レコード種別コード;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString サービス提供年月;
    private RString 事業所番号;
    private RString 給付実績情報作成区分コード;
    private RString 給付実績区分コード;
    private RString 通し番号;
    private RString 公費1_負担者番号;
    private RString 公費1_受給者番号;
    private RString 公費2_負担者番号;
    private RString 公費2_受給者番号;
    private RString 公費3_負担者番号;
    private RString 公費3_受給者番号;
    private RString 生年月日;
    private RString 性別コード;
    private RString 要介護状態区分コード;
    private RString 旧措置入所者特例コード;
    private RString 認定有効期間_開始年月日;
    private RString 認定有功期間_終了年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 保険者番号_後期;
    private RString 被保険者番号_後期;
    private RString 保険者番号_国保;
    private RString 被保険者証番号_国保;
    private RString 個人番号_国保;
    private RString 居宅サービス計画作成区分コード;
    private RString 事業所番号_居宅介護支援事業所等;
    private RString 開始年月日;
    private RString 中止年月日;
    private RString 中止理由_入所前の状況コード;
    private RString 入所年月日;
    private RString 退所年月日;
    private RString 入所実日数;
    private RString 外泊日数;
    private RString 退所後の状態コード;
    private RString 保険給付率;
    private RString 公費1給付率;
    private RString 公費2給付率;
    private RString 公費3給付率;
    private RString 前_保険_サービス単位数;
    private RString 前_保険_請求額;
    private RString 前_保険_利用者負担額;
    private RString 前_保険_緊急時施設療養費請求額;
    private RString 前_保険_特定診療費請求額;
    private RString 前_保険_特定入所者介護サービス費等請求額;
    private RString 前_公費1_サービス単位数;
    private RString 前_公費1_請求額;
    private RString 前_公費1_本人負担額;
    private RString 前_公費1_緊急時施設療養費請求額;
    private RString 前_公費1_特定診療費請求額;
    private RString 前_公費1_特定入所者介護サービス費等請求額;
    private RString 前_公費2_サービス単位数;
    private RString 前_公費2_請求額;
    private RString 前_公費2_本人負担額;
    private RString 前_公費2_緊急時施設療養費請求額;
    private RString 前_公費2_特定診療費請求額;
    private RString 前_公費2_特定入所者介護サービス費等請求額;
    private RString 前_公費3_サービス単位数;
    private RString 前_公費3_請求額;
    private RString 前_公費3_本人負担額;
    private RString 前_公費3_緊急時施設療養費請求額;
    private RString 前_公費3_特定診療費請求額;
    private RString 前_公費3_特定入所者介護サービス費等請求額;
    private RString 後_保険_サービス単位数;
    private RString 後_保険_請求額;
    private RString 後_保険_利用者負担額;
    private RString 後_緊急時施設療養費請求額;
    private RString 後_保険_特定診療費請求額;
    private RString 後_保険_特定入所者介護サービス費等請求額;
    private RString 後_公費1_サービス単位数;
    private RString 後_公費1_請求額;
    private RString 後_公費1_本人負担額;
    private RString 後_公費1_緊急時施設療養費請求額;
    private RString 後_公費1_特定診療費請求額;
    private RString 後_公費1_特定入所者介護サービス費等請求額;
    private RString 後_公費2_サービス単位数;
    private RString 後_公費2_請求額;
    private RString 後_公費2_利用者負担額;
    private RString 後_公費2_緊急時施設療養費請求額;
    private RString 後_公費2_特定診療費請求額;
    private RString 後_公費2_特定入所者介護サービス費等請求額;
    private RString 後_公費3_サービス単位数;
    private RString 後_公費3_請求額;
    private RString 後_公費3_利用者負担額;
    private RString 後_公費3_緊急時施設療養費請求額;
    private RString 後_公費3_特定診療費請求額;
    private RString 後_公費3_特定入所者介護サービス費等請求額;
    private RString 警告区分コード;
    private RString 審査年月;
    private RString 整理番号;
    private RString 送付年月;
    private RString 取込年月;
    private RString 独自作成区分;
    private RString 保険者保有給付実績情報削除済フラグ;
    private RString 履歴番号;
    private RString 申立年月日;
    private RString 申立者区分コード;
    private RString 申立単位数;
    private RString 申立事由コード;
    private RString 国保連送付年月;
    private RString 国保連再送付有フラグ;
    private RString 備考;
    private RString 識別コード;
}
