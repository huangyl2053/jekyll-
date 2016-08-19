/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 二次判定結果登録用データ（モバイル）CSV用データEntity。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NijihanteiKekkaTorokuMobileEucCsvEntity {

    @CsvField(order = 1, name = "介護認定審査会開催番号")
    private RString 介護認定審査会開催番号;
    @CsvField(order = 2, name = "合議体番号")
    private RString 合議体番号;
    @CsvField(order = 3, name = "介護認定審査会開催年月日")
    private RString 介護認定審査会開催年月日;
    @CsvField(order = 4, name = "介護認定審査会開始時刻")
    private RString 介護認定審査会開始時刻;
    @CsvField(order = 5, name = "介護認定審査会終了時刻")
    private RString 介護認定審査会終了時刻;
    @CsvField(order = 6, name = "介護認定審査会開催場所コード")
    private RString 介護認定審査会開催場所コード;
    @CsvField(order = 7, name = "所要時間合計")
    private RString 所要時間合計;
    @CsvField(order = 8, name = "介護認定審査会実施人数")
    private RString 介護認定審査会実施人数;
    @CsvField(order = 9, name = "介護認定審査会審査順")
    private RString 介護認定審査会審査順;
    @CsvField(order = 10, name = "判定結果コード")
    private RString 判定結果コード;
    @CsvField(order = 11, name = "二次判定年月日")
    private RString 二次判定年月日;
    @CsvField(order = 12, name = "二次判定要介護状態区分コード")
    private RString 二次判定要介護状態区分コード;
    @CsvField(order = 13, name = "二次判定認定有効期間")
    private RString 二次判定認定有効期間;
    @CsvField(order = 14, name = "二次判定認定有効開始年月日")
    private RString 二次判定認定有効開始年月日;
    @CsvField(order = 15, name = "二次判定認定有効終了年月日")
    private RString 二次判定認定有効終了年月日;
    @CsvField(order = 16, name = "介護認定審査会意見")
    private RString 介護認定審査会意見;
    @CsvField(order = 17, name = "一次判定結果変更理由")
    private RString 一次判定結果変更理由;
    @CsvField(order = 18, name = "要介護状態像例コード")
    private RString 要介護状態像例コード;
    @CsvField(order = 19, name = "認定審査会意見種類")
    private RString 認定審査会意見種類;
    @CsvField(order = 20, name = "審査会メモ")
    private RString 審査会メモ;
    @CsvField(order = 21, name = "二次判定結果入力方法")
    private RString 二次判定結果入力方法;
    @CsvField(order = 22, name = "二次判定結果入力年月日")
    private RString 二次判定結果入力年月日;
    @CsvField(order = 23, name = "認定申請区分（法令）コード")
    private RString 認定申請区分法令コード;
    @CsvField(order = 24, name = "要介護認定1.5次判定年月日")
    private RString 要介護認定1_5次判定年月日;
    @CsvField(order = 25, name = "要介護認定1.5次判定結果コード")
    private RString 要介護認定1_5次判定結果コード;
    @CsvField(order = 26, name = "要介護認定1.5次判定結果コード（認知症加算）")
    private RString 要介護認定1_5次判定結果コード認知症加算;
    @CsvField(order = 27, name = "要介護認定等基準時間")
    private RString 要介護認定等基準時間;
    @CsvField(order = 28, name = "要介護認定等基準時間（食事）")
    private RString 要介護認定等基準時間食事;
    @CsvField(order = 29, name = "要介護認定等基準時間（排泄）")
    private RString 要介護認定等基準時間排泄;
    @CsvField(order = 30, name = "要介護認定等基準時間（移動）")
    private RString 要介護認定等基準時間移動;
    @CsvField(order = 31, name = "要介護認定等基準時間（清潔保持）")
    private RString 要介護認定等基準時間清潔保持;
    @CsvField(order = 32, name = "要介護認定等基準時間（間接ケア）")
    private RString 要介護認定等基準時間間接ケア;
    @CsvField(order = 33, name = "要介護認定等基準時間（BPSD関連）")
    private RString 要介護認定等基準時間BPSD関連;
    @CsvField(order = 34, name = "要介護認定等基準時間（機能訓練）")
    private RString 要介護認定等基準時間機能訓練;
    @CsvField(order = 35, name = "要介護認定等基準時間（医療関連）")
    private RString 要介護認定等基準時間医療関連;
    @CsvField(order = 36, name = "要介護認定等基準時間（認知症加算）")
    private RString 要介護認定等基準時間認知症加算;
    @CsvField(order = 37, name = "中間評価項目得点第1群")
    private RString 中間評価項目得点第1群;
    @CsvField(order = 38, name = "中間評価項目得点第2群")
    private RString 中間評価項目得点第2群;
    @CsvField(order = 39, name = "中間評価項目得点第3群")
    private RString 中間評価項目得点第3群;
    @CsvField(order = 40, name = "中間評価項目得点第4群")
    private RString 中間評価項目得点第4群;
    @CsvField(order = 41, name = "中間評価項目得点第5群")
    private RString 中間評価項目得点第5群;
    @CsvField(order = 42, name = "要介護認定1.5次判定警告コード")
    private RString 要介護認定1_5次判定警告コード;
    @CsvField(order = 43, name = "要介護認定状態の安定性コード")
    private RString 要介護認定状態の安定性コード;
    @CsvField(order = 44, name = "認知症自立度Ⅱ以上の蓋然性")
    private RString 認知症自立度Ⅱ以上の蓋然性;
    @CsvField(order = 45, name = "認知機能及び状態安定性から推定される給付区分コード")
    private RString 認知機能及び状態安定性から推定される給付区分コード;
    @CsvField(order = 46, name = "申請書管理番号 ")
    private RString 申請書管理番号;
    @CsvField(order = 47, name = "厚労省IF識別コード")
    private RString 厚労省IF識別コード;
    @CsvField(order = 48, name = "厚労省認定ソフトのバージョン")
    private RString 厚労省認定ソフトのバージョン;
    @CsvField(order = 49, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 50, name = "被保険者番号　")
    private RString 被保険者番号;
    @CsvField(order = 51, name = "認定申請年月日")
    private RString 認定申請年月日;
    @CsvField(order = 52, name = "認定申請区分（申請時）コード")
    private RString 認定申請区分申請時コード;
    @CsvField(order = 53, name = "認定申請区分（申請時）")
    private RString 認定申請区分申請時;
    @CsvField(order = 54, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 55, name = "被保険者氏名カナ")
    private RString 被保険者氏名カナ;
    @CsvField(order = 56, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 57, name = "年齢")
    private RString 年齢;
    @CsvField(order = 58, name = "性別")
    private RString 性別;
    @CsvField(order = 59, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 60, name = "住所")
    private RString 住所;
    @CsvField(order = 61, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 62, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 63, name = "一次判定年月日")
    private RString 一次判定年月日;
    @CsvField(order = 64, name = "要介護認定一次判定結果コード")
    private RString 要介護認定一次判定結果コード;
    @CsvField(order = 65, name = "認定調査依頼完了年月日")
    private RString 認定調査依頼完了年月日;
    @CsvField(order = 66, name = "認定調査依頼履歴番号")
    private RString 認定調査依頼履歴番号;
    @CsvField(order = 67, name = "認定調査委託先コード")
    private RString 認定調査委託先コード;
    @CsvField(order = 68, name = "調査委託先")
    private RString 調査委託先;
    @CsvField(order = 69, name = "認定調査員コード")
    private RString 認定調査員コード;
    @CsvField(order = 70, name = "調査員氏名")
    private RString 調査員氏名;
    @CsvField(order = 71, name = "概況特記テキスト・イメージ区分コード")
    private RString 概況特記テキストイメージ区分コード;
    @CsvField(order = 72, name = "概況特記テキスト・イメージ区分")
    private RString 概況特記テキストイメージ区分;
    @CsvField(order = 73, name = "認定調査依頼区分コード")
    private RString 認定調査依頼区分コード;
    @CsvField(order = 74, name = "認定調査依頼区分")
    private RString 認定調査依頼区分;
    @CsvField(order = 75, name = "認定調査回数")
    private RString 認定調査回数;
    @CsvField(order = 76, name = "認定調査実施年月日")
    private RString 認定調査実施年月日;
    @CsvField(order = 77, name = "認定調査受領年月日")
    private RString 認定調査受領年月日;
    @CsvField(order = 78, name = "認定調査区分コード")
    private RString 認定調査区分コード;
    @CsvField(order = 79, name = "認定調査区分")
    private RString 認定調査区分;
    @CsvField(order = 80, name = "認定調査実施場所コード")
    private RString 認定調査実施場所コード;
    @CsvField(order = 81, name = "認定調査実施場所")
    private RString 認定調査実施場所;
    @CsvField(order = 82, name = "認定調査実施場所名称")
    private RString 認定調査実施場所名称;
    @CsvField(order = 83, name = "認定調査・サービス区分コード")
    private RString 認定調査サービス区分コード;
    @CsvField(order = 84, name = "認定調査・サービス区分")
    private RString 認定調査サービス区分;
    @CsvField(order = 85, name = "利用施設名")
    private RString 利用施設名;
    @CsvField(order = 86, name = "利用施設住所")
    private RString 利用施設住所;
    @CsvField(order = 87, name = "利用施設電話番号")
    private RString 利用施設電話番号;
    @CsvField(order = 88, name = "利用施設郵便番号")
    private RString 利用施設郵便番号;
    @CsvField(order = 89, name = "特記")
    private RString 特記;
    @CsvField(order = 90, name = "認定調査特記事項受付年月日")
    private RString 認定調査特記事項受付年月日;
    @CsvField(order = 91, name = "認定調査特記事項受領年月日")
    private RString 認定調査特記事項受領年月日;
    @CsvField(order = 92, name = "住宅改修（改修箇所）")
    private RString 住宅改修改修箇所;
    @CsvField(order = 93, name = "市町村特別給付サービス種類名")
    private RString 市町村特別給付サービス種類名;
    @CsvField(order = 94, name = "介護保険給付以外の在宅サービス種類名")
    private RString 介護保険給付以外の在宅サービス種類名;
    @CsvField(order = 95, name = "概況特記事項（主訴）")
    private RString 概況特記事項主訴;
    @CsvField(order = 96, name = "概況特記事項（家族状況）")
    private RString 概況特記事項家族状況;
    @CsvField(order = 97, name = "概況特記事項（居住環境）")
    private RString 概況特記事項居住環境;
    @CsvField(order = 98, name = "概況特記事項（機器・器械）")
    private RString 概況特記事項機器器械;
    @CsvField(order = 99, name = "認定調査特記事項番号")
    private RString 認定調査特記事項番号;
    @CsvField(order = 100, name = "認定調査特記事項連番")
    private RString 認定調査特記事項連番;
    @CsvField(order = 101, name = "原本マスク区分コード")
    private RString 原本マスク区分コード;
    @CsvField(order = 102, name = "原本マスク区分")
    private RString 原本マスク区分;
    @CsvField(order = 103, name = "特記事項")
    private RString 特記事項;
    @CsvField(order = 104, name = "サービスの状況連番")
    private RString サービスの状況連番;
    @CsvField(order = 105, name = "サービスの状況")
    private RString サービスの状況;
    @CsvField(order = 106, name = "サービスの状況フラグ連番")
    private RString サービスの状況フラグ連番;
    @CsvField(order = 107, name = "サービスの状況フラグ")
    private RString サービスの状況フラグ;
    @CsvField(order = 108, name = "記入項目連番")
    private RString 記入項目連番;
    @CsvField(order = 109, name = "サービスの状況記入")
    private RString サービスの状況記入;
    @CsvField(order = 110, name = "施設利用連番")
    private RString 施設利用連番;
    @CsvField(order = 111, name = "施設利用フラグ")
    private RString 施設利用フラグ;
    @CsvField(order = 112, name = "認定調査・認知症高齢者の日常生活自立度コード")
    private RString 認定調査認知症高齢者の日常生活自立度コード;
    @CsvField(order = 113, name = "認定調査・認知症高齢者の日常生活自立度")
    private RString 認定調査認知症高齢者の日常生活自立度;
    @CsvField(order = 114, name = "認定調査・障害高齢者の日常生活自立度コード")
    private RString 認定調査障害高齢者の日常生活自立度コード;
    @CsvField(order = 115, name = "認定調査・障害高齢者の日常生活自立度")
    private RString 認定調査障害高齢者の日常生活自立度;
    @CsvField(order = 116, name = "調査項目連番")
    private RString 調査項目連番;
    @CsvField(order = 117, name = "調査項目文言")
    private RString 調査項目文言;
    @CsvField(order = 118, name = "内容")
    private RString 内容;

}
