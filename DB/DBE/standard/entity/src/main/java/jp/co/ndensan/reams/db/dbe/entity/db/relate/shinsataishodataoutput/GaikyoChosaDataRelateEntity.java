/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 概況調査データのマッピング用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GaikyoChosaDataRelateEntity {

    private RString 申請書管理番号;
    private RString 厚労省IF識別コード;
    private RString 証記載保険者番号;
    private RString 被保険者番号;
    private RString 認定申請年月日;
    private RString 認定申請区分_申請時_コード;
    private RString 被保険者氏名;
    private RString 被保険者氏名カナ;
    private RString 生年月日;
    private Decimal 年齢;
    private RString 性別;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
    private RString 保険者名;
    private RString 認定調査依頼完了年月日;
    private Decimal 認定調査依頼履歴番号;
    private RString 認定調査委託先コード;
    private RString 調査委託先;
    private RString 認定調査員コード;
    private RString 調査員氏名;
    private RString 概況特記テキスト_イメージ区分コード;
    private RString 認定調査依頼区分コード;
    private Decimal 認定調査回数;
    private RString 認定調査実施年月日;
    private RString 認定調査受領年月日;
    private RString 認定調査区分コード;
    private RString 認定調査実施場所コード;
    private RString 認定調査実施場所名称;
    private RString 家族等連絡先郵便番号;
    private RString 家族等電話番号;
    private RString 家族等住所;
    private RString 家族等氏名;
    private RString 調査対象者との関係;
    private RString 認定調査_サービス区分コード;
    private RString 利用施設名;
    private RString 利用施設住所;
    private RString 利用施設電話番号;
    private RString 利用施設郵便番号;
    private RString 特記;
    private RString 認定調査特記事項受付年月日;
    private RString 認定調査特記事項受領年月日;
    private RString 住宅改修_改修箇所;
    private RString 市町村特別給付サービス種類名;
    private RString 介護保険給付以外の在宅サービス種類名;
    private RString 認定調査認知症高齢者の日常生活自立度コード;
    private RString 認定調査障害高齢者の日常生活自立度コード;
    private Decimal 中間評価項目得点第1群;
    private Decimal 中間評価項目得点第2群;
    private Decimal 中間評価項目得点第3群;
    private Decimal 中間評価項目得点第4群;
    private Decimal 中間評価項目得点第5群;
    private RString 被保険者区分コード;
    private Decimal 認知症自立度Ⅱ以上の蓋然性;
    private RString 給付区分コード;
    private RString 状態の安定性コード;
    private RString 二号特定疾病コード;
    private RString 認定申請理由;
    private RString 要介護認定一次判定結果コード;
    private Decimal 要介護認定等基準時間;
    private Decimal 要介護認定等基準時間_食事;
    private Decimal 要介護認定等基準時間_排泄;
    private Decimal 要介護認定等基準時間_移動;
    private Decimal 要介護認定等基準時間_清潔保持;
    private Decimal 要介護認定等基準時間_間接ケア;
    private Decimal 要介護認定等基準時間_BPSD関連;
    private Decimal 要介護認定等基準時間_機能訓練;
    private Decimal 要介護認定等基準時間_医療関連;
    private Decimal 要介護認定等基準時間_認知症加算;
    private RString 要介護認定一次判定警告コード;
    private RString 今回_審査会開催番号;
    private RString 今回_認定有効開始年月日;
    private RString 今回_認定有効終了年月日;
    private Decimal 今回_認定期間;
    private RString 今回_二次判定日;
    private RString 今回_申請区分_申;
    private RString 今回_申請区分_法;
    private RString 今回_通知区分;
    private RString 今回_特定疾病;
    private RString 今回_一次判定;
    private RString 今回_二次判定;
    private RString 今回_状態像;
    private RString 今回_審査会メモ;
    private RString 今回_審査会意見;
    private Decimal 介護認定審査会審査順;

}
