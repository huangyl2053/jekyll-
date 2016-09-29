/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc110810;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 受給者突合依頼情報作成のＣＳＶを定義したEntityクラスです。
 *
 * @reamsid_L DBC-2750-030 xuyongchao
 */
@SuppressWarnings("PMd.UnusedPrivateField")
@lombok.Setter
@lombok.Getter
public class SouhuFilesakuseiEntity {

    private RString 種別;
    private RString 番号連番;
    private RString 通番;
    private RString 件数;
    private RString データ種別;
    private RString 保険者番号;
    private RString 事業所番号;
    private RString 都道府県番号;
    private RString 媒体区分;
    private RString 処理対象年月;
    private RString ファイル管理番号;
    private RString 福祉事務所特定番号;
    private RString 交換情報識別番号;
    private RString 突合区分;
    private RString 認定有効年月;
    private RString 突合開始年月;
    private RString 突合終了年月;
    private RString 異動年月日;
    private RString 異動区分コード;
    private RString 異動事由;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 被保険者氏名カナ;
    private RString 生年月日;
    private RString 性別コード;
    private RString 資格取得年月日;
    private RString 資格喪失年月日;
    private RString 老人保健市町村番号;
    private RString 老人保健受給者番号;
    private RString 公費負担者番号;
    private RString 広域連合保険者番号;
    private RString 申請種別コード;
    private RString 変更申請中区分コード;
    private RString 申請年月日;
    private RString みなし要介護区分コード;
    private RString 要介護状態区分コード;
    private RString 認定有効期間開始年月日;
    private RString 認定有効期間終了年月日;
    private RString 居宅サービス計画作成区分コード;
    private RString 居宅介護支援事業所番号;
    private RString 居宅サービス計画適用開始年月日;
    private RString 居宅サービス計画適用終了年月日;
    private RString 訪問支給限度基準額;
    private RString 訪問開始年月日;
    private RString 訪問終了年月日;
    private RString 短期支給限度基準額;
    private RString 短期開始年月日;
    private RString 短期終了年月日;
    private boolean 公費負担上限額減額の有無;
    private RString 償還払化開始年月日;
    private RString 償還払化終了年月日;
    private RString 給付率引下げ開始年月日;
    private RString 給付率引下げ終了年月日;
    private RString 減免申請中区分コード;
    private RString 利用者負担区分コード;
    private Decimal 給付率;
    private RString 適用開始年月日;
    private RString 適用終了年月日;
    private RString 標準負担区分コード;
    private Decimal 負担額;
    private RString 負担額適用開始年月日;
    private RString 負担額適用終了年月日;
    private RString 特定入所者認定申請中区分コード;
    private RString 特定入所者介護サービス区分コード;
    private RString 課税層の特例減額措置対象;
    private RString 食費負担限度額;
    private RString 居住費個室負担限度額;
    private RString 居住費準個室負担限度額;
    private RString 居住費特養負担限度額;
    private RString 居住費従来型個室負担限度額;
    private RString 居住費多床室負担限度額;
    private RString 負担限度額適用開始年月日;
    private RString 負担限度額適用終了年月日;
    private RString 軽減率;
    private RString 軽減率適用開始年月日;
    private RString 軽減率適用終了年月日;
    private boolean 小規模多機能型居宅介護;
    private RString 保険者番号後期;
    private RString 被保険者番号後期;
    private RString 保険者番号国保;
    private RString 被保険者番号国保;
    private RString 個人番号国保;
    private RString 二次予防事業区分コード;
    private RString 二次予防事業開始年月日;
    private RString 二次予防事業終了年月日;
    private RString 住所地特例対象者区分コード;
    private RString 施設所在保険者番号;
    private RString 住所地特例適用開始日;
    private RString 住所地特例適用終了日;
    private RString 居宅費新1負担限度額;
    private RString 居宅費新2負担限度額;
    private RString 居宅費新3負担限度額;
    private RString 二割負担適用開始年月日;
    private RString 二割負担適用終了年月日;

}
