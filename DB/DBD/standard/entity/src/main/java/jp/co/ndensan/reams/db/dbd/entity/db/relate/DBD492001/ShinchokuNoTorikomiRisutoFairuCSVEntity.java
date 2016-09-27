/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.DBD492001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定結果連携データ取込CSV用データEntity
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinchokuNoTorikomiRisutoFairuCSVEntity {

    @CsvField(order = 1, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 2, name = "識別コード名称")
    private RString 識別コード名称;
    @CsvField(order = 3, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 4, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 5, name = "認定申請日")
    private RString 認定申請日;
    @CsvField(order = 6, name = "枝番")
    private RString 枝番;
    @CsvField(order = 7, name = "申請区分_法令_コード")
    private RString 申請区分_法令_コード;
    @CsvField(order = 8, name = "申請区分_法令_コード名称")
    private RString 申請区分_法令_コード名称;
    @CsvField(order = 9, name = "申請区分_申請時_コード")
    private RString 申請区分_申請時_コード;
    @CsvField(order = 10, name = "申請区分_申請時_コード名称")
    private RString 申請区分_申請時_コード名称;
    @CsvField(order = 11, name = "取下区分コード")
    private RString 取下区分コード;
    @CsvField(order = 12, name = "取下区分コード名称")
    private RString 取下区分コード名称;
    @CsvField(order = 13, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 14, name = "被保険者区分コード名称")
    private RString 被保険者区分コード名称;
    @CsvField(order = 15, name = "申請代行区分コード")
    private RString 申請代行区分コード;
    @CsvField(order = 16, name = "申請代行区分コード名称")
    private RString 申請代行区分コード名称;
    @CsvField(order = 17, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 18, name = "年齢")
    private RString 年齢;
    @CsvField(order = 19, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 20, name = "性別コード名称")
    private RString 性別コード名称;
    @CsvField(order = 21, name = "被保険者ｶﾅ氏名")
    private RString 被保険者ｶﾅ氏名;
    @CsvField(order = 22, name = "被保険者漢字氏名")
    private RString 被保険者漢字氏名;
    @CsvField(order = 23, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 24, name = "住所")
    private RString 住所;
    @CsvField(order = 25, name = "電話番号")
    private RString 電話番号;
    @CsvField(order = 26, name = "病院施設等の名称")
    private RString 病院施設等の名称;
    @CsvField(order = 27, name = "病院施設等の所在地")
    private RString 病院施設等の所在地;
    @CsvField(order = 28, name = "前回の認定審査会結果")
    private RString 前回の認定審査会結果;
    @CsvField(order = 29, name = "前回の認定審査会結果名称")
    private RString 前回の認定審査会結果名称;
    @CsvField(order = 30, name = "前回の認定有効期間_開始")
    private RString 前回の認定有効期間_開始;
    @CsvField(order = 31, name = "前回の認定有効期間_終了")
    private RString 前回の認定有効期間_終了;
    @CsvField(order = 32, name = "主治医医療機関番号")
    private RString 主治医医療機関番号;
    @CsvField(order = 33, name = "主治医番号")
    private RString 主治医番号;
    @CsvField(order = 34, name = "意見書依頼日")
    private RString 意見書依頼日;
    @CsvField(order = 35, name = "意見書入手日")
    private RString 意見書入手日;
    @CsvField(order = 36, name = "意見書_短期記憶")
    private RString 意見書_短期記憶;
    @CsvField(order = 37, name = "意見書_認知能力")
    private RString 意見書_認知能力;
    @CsvField(order = 38, name = "意見書_伝達能力")
    private RString 意見書_伝達能力;
    @CsvField(order = 39, name = "意見書_食事行為")
    private RString 意見書_食事行為;
    @CsvField(order = 40, name = "意見書_認知症高齢者の日常生活自立度")
    private RString 意見書_認知症高齢者の日常生活自立度;
    @CsvField(order = 41, name = "調査依頼日")
    private RString 調査依頼日;
    @CsvField(order = 42, name = "調査実施日")
    private RString 調査実施日;
    @CsvField(order = 43, name = "指定居宅介護支援事業者等番号")
    private RString 指定居宅介護支援事業者等番号;
    @CsvField(order = 44, name = "委託区分")
    private RString 委託区分;
    @CsvField(order = 45, name = "委託区分名称")
    private RString 委託区分名称;
    @CsvField(order = 46, name = "認定調査員番号")
    private RString 認定調査員番号;
    @CsvField(order = 47, name = "認定調査員資格コード")
    private RString 認定調査員資格コード;
    @CsvField(order = 48, name = "認定調査員資格コード名称")
    private RString 認定調査員資格コード名称;
    @CsvField(order = 49, name = "一次判定日")
    private RString 一次判定日;
    @CsvField(order = 50, name = "一次判定結果")
    private RString 一次判定結果;
    @CsvField(order = 51, name = "一次判定結果名称")
    private RString 一次判定結果名称;
    @CsvField(order = 52, name = "一次判定結果_認知症加算")
    private RString 一次判定結果_認知症加算;
    @CsvField(order = 53, name = "一次判定結果_認知症加算_名称")
    private RString 一次判定結果_認知症加算_名称;
    @CsvField(order = 54, name = "認定審査会資料作成日")
    private RString 認定審査会資料作成日;
    @CsvField(order = 55, name = "認定審査会予定日")
    private RString 認定審査会予定日;
    @CsvField(order = 56, name = "合議体番号")
    private RString 合議体番号;
    @CsvField(order = 57, name = "審査会資料番号")
    private RString 審査会資料番号;
    @CsvField(order = 58, name = "二次判定日")
    private RString 二次判定日;
    @CsvField(order = 59, name = "二次判定結果")
    private RString 二次判定結果;
    @CsvField(order = 60, name = "二次判定結果名称")
    private RString 二次判定結果名称;
    @CsvField(order = 61, name = "認定有効期間_開始")
    private RString 認定有効期間_開始;
    @CsvField(order = 62, name = "認定有効期間_終了")
    private RString 認定有効期間_終了;
    @CsvField(order = 63, name = "特定疾病コード")
    private RString 特定疾病コード;
    @CsvField(order = 64, name = "特定疾病コード名称")
    private RString 特定疾病コード名称;
    @CsvField(order = 65, name = "要介護１の場合の状態像")
    private RString 要介護１の場合の状態像;
    @CsvField(order = 66, name = "要介護１の場合の状態像名称")
    private RString 要介護１の場合の状態像名称;
    @CsvField(order = 67, name = "現在のサービス区分コード")
    private RString 現在のサービス区分コード;
    @CsvField(order = 68, name = "現在のサービス区分コード名称")
    private RString 現在のサービス区分コード名称;
    @CsvField(order = 69, name = "現在の状況")
    private RString 現在の状況;
    @CsvField(order = 70, name = "現在の状況名称")
    private RString 現在の状況名称;

}
