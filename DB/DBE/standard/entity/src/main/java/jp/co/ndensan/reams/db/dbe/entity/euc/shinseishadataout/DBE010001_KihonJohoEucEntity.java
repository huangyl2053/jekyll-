/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.euc.shinseishadataout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請者基本情報のCSV用Entityです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class DBE010001_KihonJohoEucEntity {

    @CsvField(order = 1, name = "申請書管理番号")
    private RString 申請書管理番号;
    @CsvField(order = 2, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 3, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 4, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 5, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 6, name = "被保険者氏名カナ")
    private RString 被保険者氏名カナ;
    @CsvField(order = 7, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 8, name = "性別")
    private RString 性別;
    @CsvField(order = 9, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 10, name = "年齢")
    private RString 年齢;
    @CsvField(order = 11, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 12, name = "被保険者区分")
    private RString 被保険者区分;
    @CsvField(order = 13, name = "２号特定疾病コード")
    private RString _２号特定疾病コード;
    @CsvField(order = 14, name = "２号特定疾病名")
    private RString _２号特定疾病名;
    @CsvField(order = 15, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 16, name = "住所")
    private RString 住所;
    @CsvField(order = 17, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 18, name = "地区コード")
    private RString 地区コード;
    @CsvField(order = 19, name = "地区名")
    private RString 地区名;
    @CsvField(order = 20, name = "申請日")
    private RString 申請日;
    @CsvField(order = 21, name = "申請書区分コード")
    private RString 申請書区分コード;
    @CsvField(order = 22, name = "申請書区分")
    private RString 申請書区分;
    @CsvField(order = 23, name = "申請区分（法令）コード")
    private RString 申請区分_法令_コード;
    @CsvField(order = 24, name = "申請区分（法令）")
    private RString 申請区分_法令;
    @CsvField(order = 25, name = "申請区分（申請時）コード")
    private RString 申請区分_申請時_コード;
    @CsvField(order = 26, name = "申請区分（申請時）")
    private RString 申請区分_申請時;
    @CsvField(order = 27, name = "処理状態区分コード")
    private RString 処理状態区分コード;
    @CsvField(order = 28, name = "処理状態区分")
    private RString 処理状態区分;
    @CsvField(order = 29, name = "在宅／施設")
    private RString 在宅or施設;
    @CsvField(order = 30, name = "入所施設コード")
    private RString 入所施設コード;
    @CsvField(order = 31, name = "入所施設名称")
    private RString 入所施設名称;
    @CsvField(order = 32, name = "連絡先氏名")
    private RString 連絡先氏名;
    @CsvField(order = 33, name = "連絡先郵便番号")
    private RString 連絡先郵便番号;
    @CsvField(order = 34, name = "連絡先住所")
    private RString 連絡先住所;
    @CsvField(order = 35, name = "連絡先電話番号")
    private RString 連絡先電話番号;
    @CsvField(order = 36, name = "連絡先携帯番号")
    private RString 連絡先携帯番号;
    @CsvField(order = 37, name = "連絡先続柄コード")
    private RString 連絡先続柄コード;
    @CsvField(order = 38, name = "連絡先続柄")
    private RString 連絡先続柄;
    @CsvField(order = 39, name = "代行区分コード")
    private RString 代行区分コード;
    @CsvField(order = 40, name = "代行区分")
    private RString 代行区分;
    @CsvField(order = 41, name = "届出者氏名")
    private RString 届出者氏名;
    @CsvField(order = 42, name = "届出者郵便番号")
    private RString 届出者郵便番号;
    @CsvField(order = 43, name = "届出者住所")
    private RString 届出者住所;
    @CsvField(order = 44, name = "届出者電話番号")
    private RString 届出者電話番号;
    @CsvField(order = 45, name = "届出者続柄")
    private RString 届出者続柄;
    @CsvField(order = 46, name = "事業者区分コード")
    private RString 事業者区分コード;
    @CsvField(order = 47, name = "事業者区分")
    private RString 事業者区分;
    @CsvField(order = 48, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 49, name = "現在の段階")
    private RString 現在の段階;
    @CsvField(order = 50, name = "申請登録完了日")
    private RString 申請登録完了日;
    @CsvField(order = 51, name = "調査依頼完了日")
    private RString 調査依頼完了日;
    @CsvField(order = 52, name = "調査完了日")
    private RString 調査完了日;
    @CsvField(order = 53, name = "意見書依頼完了日")
    private RString 意見書依頼完了日;
    @CsvField(order = 54, name = "意見書入手完了日")
    private RString 意見書入手完了日;
    @CsvField(order = 55, name = "一次判定完了日")
    private RString 一次判定完了日;
    @CsvField(order = 56, name = "マスキング完了日")
    private RString マスキング完了日;
    @CsvField(order = 57, name = "審査会登録完了日")
    private RString 審査会登録完了日;
    @CsvField(order = 58, name = "二次判定完了日")
    private RString 二次判定完了日;
    @CsvField(order = 59, name = "センター送信完了日")
    private RString センター送信完了日;
    @CsvField(order = 60, name = "調査区分コード")
    private RString 調査区分コード;
    @CsvField(order = 61, name = "調査区分")
    private RString 調査区分;
    @CsvField(order = 62, name = "調査実施日")
    private RString 調査実施日;
    @CsvField(order = 63, name = "調査委託先コード")
    private RString 調査委託先コード;
    @CsvField(order = 64, name = "調査委託先名称")
    private RString 調査委託先名称;
    @CsvField(order = 65, name = "調査員コード")
    private RString 調査員コード;
    @CsvField(order = 66, name = "調査員名")
    private RString 調査員名;
    @CsvField(order = 67, name = "実施場所コード")
    private RString 実施場所コード;
    @CsvField(order = 68, name = "実施場所")
    private RString 実施場所;
    @CsvField(order = 69, name = "実施場所名称")
    private RString 実施場所名称;
    @CsvField(order = 70, name = "（調査）障害高齢者の日常生活自立度コード")
    private RString 調査_障害高齢者の日常生活自立度コード;
    @CsvField(order = 71, name = "（調査）障害高齢者の日常生活自立度")
    private RString 調査_障害高齢者の日常生活自立度;
    @CsvField(order = 72, name = "（調査）認知症高齢者の日常生活自立度コード")
    private RString 調査_認知症高齢者の日常生活自立度コード;
    @CsvField(order = 73, name = "（調査）認知症高齢者の日常生活自立度")
    private RString 調査_認知症高齢者の日常生活自立度;
    @CsvField(order = 74, name = "医療機関コード")
    private RString 医療機関コード;
    @CsvField(order = 75, name = "医療機関名称")
    private RString 医療機関名称;
    @CsvField(order = 76, name = "主治医コード")
    private RString 主治医コード;
    @CsvField(order = 77, name = "主治医名")
    private RString 主治医名;
    @CsvField(order = 78, name = "記入日")
    private RString 記入日;
    @CsvField(order = 79, name = "最終診療日")
    private RString 最終診療日;
    @CsvField(order = 80, name = "意見書同意")
    private RString 意見書同意;
    @CsvField(order = 81, name = "意見書作成回数区分コード")
    private RString 意見書作成回数区分コード;
    @CsvField(order = 82, name = "意見書作成回数区分")
    private RString 意見書作成回数区分;
    @CsvField(order = 83, name = "（意見）障害高齢者の日常生活自立度コード")
    private RString 意見_障害高齢者の日常生活自立度コード;
    @CsvField(order = 84, name = "（意見）障害高齢者の日常生活自立度")
    private RString 意見_障害高齢者の日常生活自立度;
    @CsvField(order = 85, name = "（意見）認知症高齢者の日常生活自立度コード")
    private RString 意見_認知症高齢者の日常生活自立度コード;
    @CsvField(order = 86, name = "（意見）認知症高齢者の日常生活自立度")
    private RString 意見_認知症高齢者の日常生活自立度;
    @CsvField(order = 87, name = "一次判定日")
    private RString 一次判定日;
    @CsvField(order = 88, name = "一次判定結果コード")
    private RString 一次判定結果コード;
    @CsvField(order = 89, name = "一次判定結果")
    private RString 一次判定結果;
    @CsvField(order = 90, name = "一次判定結果コード（認知症加算）")
    private RString 一次判定結果コード_認知症加算;
    @CsvField(order = 91, name = "一次判定結果（認知症加算）")
    private RString 一次判定結果_認知症加算;
    @CsvField(order = 92, name = "1.5次判定日")
    private RString 一_五次判定日;
    @CsvField(order = 93, name = "1.5次判定結果コード")
    private RString 一_五次判定結果コード;
    @CsvField(order = 94, name = "1.5次判定結果")
    private RString 一_五次判定結果;
    @CsvField(order = 95, name = "1.5次判定結果コード（認知症加算）")
    private RString 一_五次判定結果コード_認知症加算;
    @CsvField(order = 96, name = "1.5次判定結果（認知症加算）")
    private RString 一_五次判定結果_認知症加算;
    @CsvField(order = 97, name = "二次判定日")
    private RString 二次判定日;
    @CsvField(order = 98, name = "二次判定結果コード")
    private RString 二次判定結果コード;
    @CsvField(order = 99, name = "二次判定結果")
    private RString 二次判定結果;
    @CsvField(order = 100, name = "認定有効期間")
    private RString 認定有効期間;
    @CsvField(order = 101, name = "認定有効開始日")
    private RString 認定有効開始日;
    @CsvField(order = 102, name = "認定有効終了日")
    private RString 認定有効終了日;
    @CsvField(order = 103, name = "要介護状態像例コード")
    private RString 要介護状態像例コード;
    @CsvField(order = 104, name = "要介護状態像例")
    private RString 要介護状態像例;
    @CsvField(order = 105, name = "一次判定結果変更理由")
    private RString 一次判定結果変更理由;
    @CsvField(order = 106, name = "審査会意見種類コード")
    private RString 審査会意見種類コード;
    @CsvField(order = 107, name = "審査会意見種類")
    private RString 審査会意見種類;
    @CsvField(order = 108, name = "審査会意見")
    private RString 審査会意見;
    @CsvField(order = 109, name = "審査会メモ")
    private RString 審査会メモ;
    @CsvField(order = 110, name = "審査会開催番号")
    private RString 審査会開催番号;
    @CsvField(order = 111, name = "（予定）合議体番号")
    private RString 予定_合議体番号;
    @CsvField(order = 112, name = "（予定）開催日")
    private RString 予定_開催日;
    @CsvField(order = 113, name = "（結果）合議体番号")
    private RString 結果_合議体番号;
    @CsvField(order = 114, name = "（結果）開催日")
    private RString 結果_開催日;
    @CsvField(order = 115, name = "判定結果コード")
    private RString 判定結果コード;
    @CsvField(order = 116, name = "判定結果")
    private RString 判定結果;
    @CsvField(order = 117, name = "(前回)一次判定日")
    private RString 前回_一次判定日;
    @CsvField(order = 118, name = "(前回)一次判定結果コード")
    private RString 前回_一次判定結果コード;
    @CsvField(order = 119, name = "(前回)一次判定結果")
    private RString 前回_一次判定結果;
    @CsvField(order = 120, name = "(前回)一次判定結果コード（認知症加算）")
    private RString 前回_一次判定結果コード_認知症加算;
    @CsvField(order = 121, name = "(前回)一次判定結果（認知症加算）")
    private RString 前回_一次判定結果_認知症加算;
    @CsvField(order = 122, name = "(前回)1.5次判定日")
    private RString 前回_一_五次判定日;
    @CsvField(order = 123, name = "(前回)1.5次判定結果コード")
    private RString 前回_一_五次判定結果コード;
    @CsvField(order = 124, name = "(前回)1.5次判定結果")
    private RString 前回_一_五次判定結果;
    @CsvField(order = 125, name = "(前回)1.5次判定結果コード（認知症加算）")
    private RString 前回_一_五次判定結果コード_認知症加算;
    @CsvField(order = 126, name = "(前回)1.5次判定結果（認知症加算）")
    private RString 前回_一_五次判定結果_認知症加算;
    @CsvField(order = 127, name = "(前回)二次判定日")
    private RString 前回_二次判定日;
    @CsvField(order = 128, name = "(前回)二次判定結果コード")
    private RString 前回_二次判定結果コード;
    @CsvField(order = 129, name = "(前回)二次判定結果")
    private RString 前回_二次判定結果;
    @CsvField(order = 130, name = "(前回)認定有効期間")
    private RString 前回_認定有効期間;
    @CsvField(order = 131, name = "(前回)認定有効開始日")
    private RString 前回_認定有効開始日;
    @CsvField(order = 132, name = "(前回)認定有効終了日")
    private RString 前回_認定有効終了日;
    @CsvField(order = 133, name = "情報提供同意有無")
    private RString 情報提供同意有無;
    @CsvField(order = 134, name = "厚労省IF識別コード")
    private RString 厚労省IF識別コード;
    @CsvField(order = 135, name = "認定申請情報抽出日")
    private RString 認定申請情報抽出日;
    @CsvField(order = 136, name = "認定調査結果情報抽出日")
    private RString 認定調査結果情報抽出日;
    @CsvField(order = 137, name = "認定調査・意見書結果情報抽出日")
    private RString 認定調査_意見書結果情報抽出日;
    @CsvField(order = 138, name = "一次判定情報抽出日")
    private RString 一次判定情報抽出日;
    @CsvField(order = 139, name = "審査会結果情報抽出日")
    private RString 審査会結果情報抽出日;
    @CsvField(order = 140, name = "センター送信情報抽出日")
    private RString センター送信情報抽出日;
}
