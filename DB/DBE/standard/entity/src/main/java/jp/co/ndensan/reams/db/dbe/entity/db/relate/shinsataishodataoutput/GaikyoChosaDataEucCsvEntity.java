/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 概況調査データCSV用Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GaikyoChosaDataEucCsvEntity {

    @CsvField(order = 1, name = "申請書管理番号")
    private RString 申請書管理番号;
    @CsvField(order = 2, name = "厚労省IF識別コード")
    private RString 厚労省IF識別コード;
    @CsvField(order = 3, name = "厚労省認定ソフトのバージョン")
    private RString 厚労省認定ソフトのバージョン;
    @CsvField(order = 4, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 5, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 6, name = "認定申請年月日")
    private RString 認定申請年月日;
    @CsvField(order = 7, name = "認定申請区分_申請時_コード")
    private RString 認定申請区分_申請時_コード;
    @CsvField(order = 8, name = "認定申請区分_申請時")
    private RString 認定申請区分_申請時;
    @CsvField(order = 9, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 10, name = "被保険者氏名カナ")
    private RString 被保険者氏名カナ;
    @CsvField(order = 11, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 12, name = "年齢")
    private Decimal 年齢;
    @CsvField(order = 13, name = "性別")
    private RString 性別;
    @CsvField(order = 14, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 15, name = "住所")
    private RString 住所;
    @CsvField(order = 16, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 17, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 18, name = "認定調査依頼完了年月日")
    private RString 認定調査依頼完了年月日;
    @CsvField(order = 19, name = "認定調査依頼履歴番号")
    private Decimal 認定調査依頼履歴番号;
    @CsvField(order = 20, name = "認定調査委託先コード")
    private RString 認定調査委託先コード;
    @CsvField(order = 21, name = "調査委託先")
    private RString 調査委託先;
    @CsvField(order = 22, name = "認定調査員コード")
    private RString 認定調査員コード;
    @CsvField(order = 23, name = "調査員氏名")
    private RString 調査員氏名;
    @CsvField(order = 24, name = "概況特記テキスト_イメージ区分コード")
    private RString 概況特記テキスト_イメージ区分コード;
    @CsvField(order = 25, name = "概況特記テキスト_イメージ区分")
    private RString 概況特記テキスト_イメージ区分;
    @CsvField(order = 26, name = "認定調査依頼区分コード")
    private RString 認定調査依頼区分コード;
    @CsvField(order = 27, name = "認定調査依頼区分")
    private RString 認定調査依頼区分;
    @CsvField(order = 28, name = "認定調査回数")
    private Decimal 認定調査回数;
    @CsvField(order = 29, name = "認定調査実施年月日")
    private RString 認定調査実施年月日;
    @CsvField(order = 30, name = "認定調査受領年月日")
    private RString 認定調査受領年月日;
    @CsvField(order = 31, name = "認定調査区分コード")
    private RString 認定調査区分コード;
    @CsvField(order = 32, name = "認定調査区分")
    private RString 認定調査区分;
    @CsvField(order = 33, name = "認定調査実施場所コード")
    private RString 認定調査実施場所コード;
    @CsvField(order = 34, name = "認定調査実施場所")
    private RString 認定調査実施場所;
    @CsvField(order = 35, name = "認定調査実施場所名称")
    private RString 認定調査実施場所名称;
    @CsvField(order = 36, name = "家族等連絡先郵便番号")
    private RString 家族等連絡先郵便番号;
    @CsvField(order = 37, name = "家族等電話番号")
    private RString 家族等電話番号;
    @CsvField(order = 38, name = "家族等住所")
    private RString 家族等住所;
    @CsvField(order = 39, name = "家族等氏名")
    private RString 家族等氏名;
    @CsvField(order = 40, name = "調査対象者との関係")
    private RString 調査対象者との関係;
    @CsvField(order = 41, name = "認定調査_サービス区分コード")
    private RString 認定調査_サービス区分コード;
    @CsvField(order = 42, name = "認定調査_サービス区分")
    private RString 認定調査_サービス区分;
    @CsvField(order = 43, name = "利用施設名")
    private RString 利用施設名;
    @CsvField(order = 44, name = "利用施設住所")
    private RString 利用施設住所;
    @CsvField(order = 45, name = "利用施設電話番号")
    private RString 利用施設電話番号;
    @CsvField(order = 46, name = "利用施設郵便番号")
    private RString 利用施設郵便番号;
    @CsvField(order = 47, name = "特記")
    private RString 特記;
    @CsvField(order = 48, name = "認定調査特記事項受付年月日")
    private RString 認定調査特記事項受付年月日;
    @CsvField(order = 49, name = "認定調査特記事項受領年月日")
    private RString 認定調査特記事項受領年月日;
    @CsvField(order = 50, name = "住宅改修_改修箇所")
    private RString 住宅改修_改修箇所;
    @CsvField(order = 51, name = "市町村特別給付サービス種類名")
    private RString 市町村特別給付サービス種類名;
    @CsvField(order = 52, name = "介護保険給付以外の在宅サービス種類名")
    private RString 介護保険給付以外の在宅サービス種類名;
    @CsvField(order = 53, name = "サービスの状況連番01")
    private int サービスの状況連番01;
    @CsvField(order = 54, name = "サービスの状況01")
    private int サービスの状況01;
    @CsvField(order = 55, name = "サービスの状況連番02")
    private int サービスの状況連番02;
    @CsvField(order = 56, name = "サービスの状況02")
    private int サービスの状況02;
    @CsvField(order = 57, name = "サービスの状況連番03")
    private int サービスの状況連番03;
    @CsvField(order = 58, name = "サービスの状況03")
    private int サービスの状況03;
    @CsvField(order = 59, name = "サービスの状況連番04")
    private int サービスの状況連番04;
    @CsvField(order = 60, name = "サービスの状況04")
    private int サービスの状況04;
    @CsvField(order = 61, name = "サービスの状況連番05")
    private int サービスの状況連番05;
    @CsvField(order = 62, name = "サービスの状況05")
    private int サービスの状況05;
    @CsvField(order = 63, name = "サービスの状況連番06")
    private int サービスの状況連番06;
    @CsvField(order = 64, name = "サービスの状況06")
    private int サービスの状況06;
    @CsvField(order = 65, name = "サービスの状況連番07")
    private int サービスの状況連番07;
    @CsvField(order = 66, name = "サービスの状況07")
    private int サービスの状況07;
    @CsvField(order = 67, name = "サービスの状況連番08")
    private int サービスの状況連番08;
    @CsvField(order = 68, name = "サービスの状況08")
    private int サービスの状況08;
    @CsvField(order = 69, name = "サービスの状況連番09")
    private int サービスの状況連番09;
    @CsvField(order = 70, name = "サービスの状況09")
    private int サービスの状況09;
    @CsvField(order = 71, name = "サービスの状況連番10")
    private int サービスの状況連番10;
    @CsvField(order = 72, name = "サービスの状況10")
    private int サービスの状況10;
    @CsvField(order = 73, name = "サービスの状況連番11")
    private int サービスの状況連番11;
    @CsvField(order = 74, name = "サービスの状況11")
    private int サービスの状況11;
    @CsvField(order = 75, name = "サービスの状況連番12")
    private int サービスの状況連番12;
    @CsvField(order = 76, name = "サービスの状況12")
    private int サービスの状況12;
    @CsvField(order = 77, name = "サービスの状況連番13")
    private int サービスの状況連番13;
    @CsvField(order = 78, name = "サービスの状況13")
    private int サービスの状況13;
    @CsvField(order = 79, name = "サービスの状況連番14")
    private int サービスの状況連番14;
    @CsvField(order = 80, name = "サービスの状況14")
    private int サービスの状況14;
    @CsvField(order = 81, name = "サービスの状況連番15")
    private int サービスの状況連番15;
    @CsvField(order = 82, name = "サービスの状況15")
    private int サービスの状況15;
    @CsvField(order = 83, name = "サービスの状況連番16")
    private int サービスの状況連番16;
    @CsvField(order = 84, name = "サービスの状況16")
    private int サービスの状況16;
    @CsvField(order = 85, name = "サービスの状況連番17")
    private int サービスの状況連番17;
    @CsvField(order = 86, name = "サービスの状況17")
    private int サービスの状況17;
    @CsvField(order = 87, name = "サービスの状況連番18")
    private int サービスの状況連番18;
    @CsvField(order = 88, name = "サービスの状況18")
    private int サービスの状況18;
    @CsvField(order = 89, name = "サービスの状況連番19")
    private int サービスの状況連番19;
    @CsvField(order = 90, name = "サービスの状況19")
    private int サービスの状況19;
    @CsvField(order = 91, name = "サービスの状況連番20")
    private int サービスの状況連番20;
    @CsvField(order = 92, name = "サービスの状況20")
    private int サービスの状況20;
    @CsvField(order = 93, name = "サービスの状況フラグ連番")
    private int サービスの状況フラグ連番;
    @CsvField(order = 94, name = "サービスの状況フラグ")
    private boolean サービスの状況フラグ;
    @CsvField(order = 95, name = "記入項目連番01")
    private int 記入項目連番01;
    @CsvField(order = 96, name = "サービスの状況記入01")
    private RString サービスの状況記入01;
    @CsvField(order = 97, name = "記入項目連番02")
    private int 記入項目連番02;
    @CsvField(order = 98, name = "サービスの状況記入02")
    private RString サービスの状況記入02;
    @CsvField(order = 99, name = "施設利用連番01")
    private int 施設利用連番01;
    @CsvField(order = 100, name = "施設利用フラグ01")
    private boolean 施設利用フラグ01;
    @CsvField(order = 101, name = "施設利用連番02")
    private int 施設利用連番02;
    @CsvField(order = 102, name = "施設利用フラグ02")
    private boolean 施設利用フラグ02;
    @CsvField(order = 103, name = "施設利用連番03")
    private int 施設利用連番03;
    @CsvField(order = 104, name = "施設利用フラグ03")
    private boolean 施設利用フラグ03;
    @CsvField(order = 105, name = "施設利用連番04")
    private int 施設利用連番04;
    @CsvField(order = 106, name = "施設利用フラグ04")
    private boolean 施設利用フラグ04;
    @CsvField(order = 107, name = "施設利用連番05")
    private int 施設利用連番05;
    @CsvField(order = 108, name = "施設利用フラグ05")
    private boolean 施設利用フラグ05;
    @CsvField(order = 109, name = "施設利用連番06")
    private int 施設利用連番06;
    @CsvField(order = 110, name = "施設利用フラグ06")
    private boolean 施設利用フラグ06;
    @CsvField(order = 111, name = "施設利用連番07")
    private int 施設利用連番07;
    @CsvField(order = 112, name = "施設利用フラグ07")
    private boolean 施設利用フラグ07;
    @CsvField(order = 113, name = "施設利用連番08")
    private int 施設利用連番08;
    @CsvField(order = 114, name = "施設利用フラグ08")
    private boolean 施設利用フラグ08;
    @CsvField(order = 115, name = "施設利用連番09")
    private int 施設利用連番09;
    @CsvField(order = 116, name = "施設利用フラグ09")
    private boolean 施設利用フラグ09;
    @CsvField(order = 117, name = "認定調査認知症高齢者の日常生活自立度コード")
    private RString 認定調査認知症高齢者の日常生活自立度コード;
    @CsvField(order = 118, name = "認定調査認知症高齢者の日常生活自立度")
    private RString 認定調査認知症高齢者の日常生活自立度;
    @CsvField(order = 119, name = "認定調査障害高齢者の日常生活自立度コード")
    private RString 認定調査障害高齢者の日常生活自立度コード;
    @CsvField(order = 120, name = "認定調査障害高齢者の日常生活自立度")
    private RString 認定調査障害高齢者の日常生活自立度;
    @CsvField(order = 121, name = "ステータス")
    private RString ステータス;
    @CsvField(order = 122, name = "中間評価項目得点第1群")
    private Decimal 中間評価項目得点第1群;
    @CsvField(order = 123, name = "中間評価項目得点第2群")
    private Decimal 中間評価項目得点第2群;
    @CsvField(order = 124, name = "中間評価項目得点第3群")
    private Decimal 中間評価項目得点第3群;
    @CsvField(order = 125, name = "中間評価項目得点第4群")
    private Decimal 中間評価項目得点第4群;
    @CsvField(order = 126, name = "中間評価項目得点第5群")
    private Decimal 中間評価項目得点第5群;
    @CsvField(order = 127, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 128, name = "被保険者区分名称")
    private RString 被保険者区分名称;
    @CsvField(order = 129, name = "認知症自立度Ⅱ以上の蓋然性")
    private Decimal 認知症自立度Ⅱ以上の蓋然性;
    @CsvField(order = 130, name = "給付区分コード")
    private RString 給付区分コード;
    @CsvField(order = 131, name = "給付区分")
    private RString 給付区分;
    @CsvField(order = 132, name = "状態の安定性コード")
    private RString 状態の安定性コード;
    @CsvField(order = 133, name = "状態の安定性")
    private RString 状態の安定性;
    @CsvField(order = 134, name = "主治医認定調査認知症高齢者の日常生活自立度コード")
    private RString 主治医認定調査認知症高齢者の日常生活自立度コード;
    @CsvField(order = 135, name = "主治医認定調査認知症高齢者の日常生活自立度")
    private RString 主治医認定調査認知症高齢者の日常生活自立度;
    @CsvField(order = 136, name = "主治医認定調査障害高齢者の日常生活自立度コード")
    private RString 主治医認定調査障害高齢者の日常生活自立度コード;
    @CsvField(order = 137, name = "主治医認定調査障害高齢者の日常生活自立度")
    private RString 主治医認定調査障害高齢者の日常生活自立度;
    @CsvField(order = 138, name = "二号特定疾病コード")
    private RString 二号特定疾病コード;
    @CsvField(order = 139, name = "認定申請理由")
    private RString 認定申請理由;
    @CsvField(order = 140, name = "要介護認定一次判定結果コード")
    private RString 要介護認定一次判定結果コード;
    @CsvField(order = 141, name = "要介護認定一次判定結果")
    private RString 要介護認定一次判定結果;
    @CsvField(order = 142, name = "要介護認定等基準時間")
    private Decimal 要介護認定等基準時間;
    @CsvField(order = 143, name = "要介護認定等基準時間_食事")
    private Decimal 要介護認定等基準時間_食事;
    @CsvField(order = 144, name = "要介護認定等基準時間_排泄")
    private Decimal 要介護認定等基準時間_排泄;
    @CsvField(order = 145, name = "要介護認定等基準時間_移動")
    private Decimal 要介護認定等基準時間_移動;
    @CsvField(order = 146, name = "要介護認定等基準時間_清潔保持")
    private Decimal 要介護認定等基準時間_清潔保持;
    @CsvField(order = 147, name = "要介護認定等基準時間_間接ケア")
    private Decimal 要介護認定等基準時間_間接ケア;
    @CsvField(order = 148, name = "要介護認定等基準時間_BPSD関連")
    private Decimal 要介護認定等基準時間_BPSD関連;
    @CsvField(order = 149, name = "要介護認定等基準時間_機能訓練")
    private Decimal 要介護認定等基準時間_機能訓練;
    @CsvField(order = 150, name = "要介護認定等基準時間_医療関連")
    private Decimal 要介護認定等基準時間_医療関連;
    @CsvField(order = 151, name = "要介護認定等基準時間_認知症加算")
    private Decimal 要介護認定等基準時間_認知症加算;
    @CsvField(order = 152, name = "要介護認定一次判定警告コード")
    private RString 要介護認定一次判定警告コード;
    @CsvField(order = 153, name = "前回_審査会開催番号")
    private RString 前回_審査会開催番号;
    @CsvField(order = 154, name = "前回_認定有効開始年月日")
    private RString 前回_認定有効開始年月日;
    @CsvField(order = 155, name = "前回_認定有効終了年月日")
    private RString 前回_認定有効終了年月日;
    @CsvField(order = 156, name = "前回_認定期間")
    private Decimal 前回_認定期間;
    @CsvField(order = 157, name = "前回_二次判定日")
    private RString 前回_二次判定日;
    @CsvField(order = 158, name = "前回_申請区分_申")
    private RString 前回_申請区分_申;
    @CsvField(order = 159, name = "前回_申請区分_法")
    private RString 前回_申請区分_法;
    @CsvField(order = 160, name = "前回_通知区分")
    private RString 前回_通知区分;
    @CsvField(order = 161, name = "前回_特定疾病")
    private RString 前回_特定疾病;
    @CsvField(order = 162, name = "前回_一次判定")
    private RString 前回_一次判定;
    @CsvField(order = 163, name = "前回_二次判定")
    private RString 前回_二次判定;
    @CsvField(order = 164, name = "前回_状態像")
    private RString 前回_状態像;
    @CsvField(order = 165, name = "前回_審査会メモ")
    private RString 前回_審査会メモ;
    @CsvField(order = 166, name = "前回_審査会意見")
    private RString 前回_審査会意見;
    @CsvField(order = 167, name = "前々回_審査会開催番号")
    private RString 前々回_審査会開催番号;
    @CsvField(order = 168, name = "前々回_認定有効開始年月日")
    private RString 前々回_認定有効開始年月日;
    @CsvField(order = 169, name = "前々回_認定有効終了年月日")
    private RString 前々回_認定有効終了年月日;
    @CsvField(order = 170, name = "前々回_認定期間")
    private Decimal 前々回_認定期間;
    @CsvField(order = 171, name = "前々回_二次判定日")
    private RString 前々回_二次判定日;
    @CsvField(order = 172, name = "前々回_申請区分_申")
    private RString 前々回_申請区分_申;
    @CsvField(order = 173, name = "前々回_申請区分_法")
    private RString 前々回_申請区分_法;
    @CsvField(order = 174, name = "前々回_通知区分")
    private RString 前々回_通知区分;
    @CsvField(order = 175, name = "前々回_特定疾病")
    private RString 前々回_特定疾病;
    @CsvField(order = 176, name = "前々回_一次判定")
    private RString 前々回_一次判定;
    @CsvField(order = 177, name = "前々回_二次判定")
    private RString 前々回_二次判定;
    @CsvField(order = 178, name = "前々回_状態像")
    private RString 前々回_状態像;
    @CsvField(order = 179, name = "前々回_審査会メモ")
    private RString 前々回_審査会メモ;
    @CsvField(order = 180, name = "前々回_審査会意見")
    private RString 前々回_審査会意見;
    @CsvField(order = 181, name = "今回_審査会開催番号")
    private RString 今回_審査会開催番号;
    @CsvField(order = 182, name = "今回_認定有効開始年月日")
    private RString 今回_認定有効開始年月日;
    @CsvField(order = 183, name = "今回_認定有効終了年月日")
    private RString 今回_認定有効終了年月日;
    @CsvField(order = 184, name = "今回_認定期間")
    private Decimal 今回_認定期間;
    @CsvField(order = 185, name = "今回_二次判定日")
    private RString 今回_二次判定日;
    @CsvField(order = 186, name = "今回_申請区分_申")
    private RString 今回_申請区分_申;
    @CsvField(order = 187, name = "今回_申請区分_法")
    private RString 今回_申請区分_法;
    @CsvField(order = 188, name = "今回_通知区分")
    private RString 今回_通知区分;
    @CsvField(order = 189, name = "今回_特定疾病")
    private RString 今回_特定疾病;
    @CsvField(order = 190, name = "今回_一次判定")
    private RString 今回_一次判定;
    @CsvField(order = 191, name = "今回_二次判定")
    private RString 今回_二次判定;
    @CsvField(order = 192, name = "今回_状態像")
    private RString 今回_状態像;
    @CsvField(order = 193, name = "今回_審査会メモ")
    private RString 今回_審査会メモ;
    @CsvField(order = 194, name = "今回_審査会意見")
    private RString 今回_審査会意見;
    @CsvField(order = 195, name = "要介護認定1_5次判定年月日")
    private RString 要介護認定1_5次判定年月日;
    @CsvField(order = 196, name = "要介護認定1_5次判定結果コード")
    private RString 要介護認定1_5次判定結果コード;
    @CsvField(order = 197, name = "要介護認定1_5次判定結果")
    private RString 要介護認定1_5次判定結果;
    @CsvField(order = 198, name = "要介護認定1_5次判定結果コード_認知症加算")
    private RString 要介護認定1_5次判定結果コード_認知症加算;
    @CsvField(order = 199, name = "要介護認定1_5次判定結果_認知症加算")
    private RString 要介護認定1_5次判定結果_認知症加算;
    @CsvField(order = 200, name = "要介護認定等基準時間_1_5次")
    private Decimal 要介護認定等基準時間_1_5次;
    @CsvField(order = 201, name = "要介護認定等基準時間_食事_1_5次")
    private Decimal 要介護認定等基準時間_食事_1_5次;
    @CsvField(order = 202, name = "要介護認定等基準時間_排泄_1_5次")
    private Decimal 要介護認定等基準時間_排泄_1_5次;
    @CsvField(order = 203, name = "要介護認定等基準時間_移動_1_5次")
    private Decimal 要介護認定等基準時間_移動_1_5次;
    @CsvField(order = 204, name = "要介護認定等基準時間_清潔保持_1_5次")
    private Decimal 要介護認定等基準時間_清潔保持_1_5次;
    @CsvField(order = 205, name = "要介護認定等基準時間_間接ケア_1_5次")
    private Decimal 要介護認定等基準時間_間接ケア_1_5次;
    @CsvField(order = 206, name = "要介護認定等基準時間_BPSD関連_1_5次")
    private Decimal 要介護認定等基準時間_BPSD関連_1_5次;
    @CsvField(order = 207, name = "要介護認定等基準時間_機能訓練_1_5次")
    private Decimal 要介護認定等基準時間_機能訓練_1_5次;
    @CsvField(order = 208, name = "要介護認定等基準時間_医療関連_1_5次")
    private Decimal 要介護認定等基準時間_医療関連_1_5次;
    @CsvField(order = 209, name = "要介護認定等基準時間_認知症加算_1_5次")
    private Decimal 要介護認定等基準時間_認知症加算_1_5次;
    @CsvField(order = 210, name = "中間評価項目得点第1群_1_5次")
    private Decimal 中間評価項目得点第1群_1_5次;
    @CsvField(order = 211, name = "中間評価項目得点第2群_1_5次")
    private Decimal 中間評価項目得点第2群_1_5次;
    @CsvField(order = 212, name = "中間評価項目得点第3群_1_5次")
    private Decimal 中間評価項目得点第3群_1_5次;
    @CsvField(order = 213, name = "中間評価項目得点第4群_1_5次")
    private Decimal 中間評価項目得点第4群_1_5次;
    @CsvField(order = 214, name = "中間評価項目得点第5群_1_5次")
    private Decimal 中間評価項目得点第5群_1_5次;
    @CsvField(order = 215, name = "要介護認定1_5次判定警告コード_1_5次")
    private RString 要介護認定1_5次判定警告コード_1_5次;
    @CsvField(order = 216, name = "要介護認定状態の安定性コード_1_5次")
    private RString 要介護認定状態の安定性コード_1_5次;
    @CsvField(order = 217, name = "認知症自立度Ⅱ以上の蓋然性_1_5次")
    private Decimal 認知症自立度Ⅱ以上の蓋然性_1_5次;
    @CsvField(order = 218, name = "認知機能及び状態安定性から推定される給付区分コード_1_5次")
    private RString 認知機能及び状態安定性から推定される給付区分コード_1_5次;
    @CsvField(order = 219, name = "短期記憶内容コード")
    private RString 短期記憶内容コード;
    @CsvField(order = 220, name = "短期記憶内容")
    private RString 短期記憶内容;
    @CsvField(order = 221, name = "認知能力内容コード")
    private RString 認知能力内容コード;
    @CsvField(order = 222, name = "認知能力内容")
    private RString 認知能力内容;
    @CsvField(order = 223, name = "伝達能力内容コード")
    private RString 伝達能力内容コード;
    @CsvField(order = 224, name = "伝達能力内容")
    private RString 伝達能力内容;
    @CsvField(order = 225, name = "食事行為内容コード")
    private RString 食事行為内容コード;
    @CsvField(order = 226, name = "食事行為内容")
    private RString 食事行為内容;
    @CsvField(order = 227, name = "介護認定審査会審査順")
    private Decimal 介護認定審査会審査順;

}
