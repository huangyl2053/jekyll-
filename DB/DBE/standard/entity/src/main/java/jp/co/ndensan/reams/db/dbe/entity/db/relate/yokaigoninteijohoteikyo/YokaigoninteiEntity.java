/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 要介護認定申請者RelateEntityクラスです。
 *
 * @reamsid_L DBE-0230-030 zhangzhiming
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoninteiEntity {

    private RString 保険者番号;
    private RString 厚労省IF識別コード;
    private RString 申請書管理番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 年齢;
    private RString 性別;
    private RString 郵便番号;
    private FlexibleDate 認定申請年月日;
    private RString 申請区分_申;
    private RString 申請区分_法;
    private RString 前回厚労省IF識別コード;
    private FlexibleDate 前回認定日;
    private FlexibleDate 前回認定有効期間開始年月日;
    private FlexibleDate 前回認定有効期間終了年月日;
    private RString 前回認定有効期間;
    private RString 住所;
    private RString 電話;
    private RString 連絡先郵便番号;
    private RString 連絡先住所;
    private RString 連絡先電話電話;
    private RString 連絡先携帯電話;
    private RString 連絡先氏名;
    private RString 関係;
    private FlexibleDate 審査会開催日;
    private RString 一次判定結果;
    private RString 二次判定結果;
    private FlexibleDate 二次判定年月日;
    private FlexibleDate 認定有効期間開始年月日;
    private FlexibleDate 認定有効期間終了年月日;
    private RString 認定有効期間;
    private RString 要介護状態像例コード;
    private RString 特定疾病;
    private RString 審査会意見;
    private FlexibleDate 実施年月日;
    private RString 実施場所コード;
    private RString 実施場所名称;
    private RString 概況調査特記事項;
    private RString 調査員氏名;
    private RString 事業者名称;
    private FlexibleDate 作成年月日;
    private RString サービス区分コード;
    private RString 施設名;
    private RString 施設住所;
    private RString 施設電話番号;
    private RString 障害高齢者自立度;
    private RString 認知症高齢者自立度;
    private RString 被保険者区分コード;
    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private RString 主治医コード;
    private RString 主治医氏名;
    private RString 合議体番号;
    private RString 審査会審査順;
    private RString 前回認定結果;
    private RString 前々回要介護度;
    private RString 前々回認定有効期間;
    private RString 前々回認定有効期間_開始;
    private RString 前々回認定有効期間_終了;
    private RString 前回二次判定年月日;
    private RString 前回認定有効期間_開始;
    private RString 前回認定有効期間_終了;
    private RString 前回状態像;
    private RString 所属;
    private RString 市町村名;
    private RString 事業者番号;
    private RString 認定調査員コード;
    private RString 調査員資格;
    private RString 要介護認定等基準時間;
    private RString 要介護認定等基準時間_食事;
    private RString 要介護認定等基準時間_排泄;
    private RString 要介護認定等基準時間_移動;
    private RString 要介護認定等基準時間_清潔保持;
    private RString 要介護認定等基準時間_間接ケア;
    private RString 要介護認定等基準時間_BPSD関連;
    private RString 要介護認定等基準時間_機能訓練;
    private RString 要介護認定等基準時間_医療関連;
    private RString 要介護認定等基準時間_認知症加算;
    private RString 警告コード;
    private RString 中間評価項目得点第1群;
    private RString 中間評価項目得点第2群;
    private RString 中間評価項目得点第3群;
    private RString 中間評価項目得点第4群;
    private RString 中間評価項目得点第5群;
    private RString 蓋然性;
    private RString 安定性;
    private RString 給付区分;
    private RString テキスト_イメージ区分;
    private RString 施設利用;
    private RString 変更事由;
}
