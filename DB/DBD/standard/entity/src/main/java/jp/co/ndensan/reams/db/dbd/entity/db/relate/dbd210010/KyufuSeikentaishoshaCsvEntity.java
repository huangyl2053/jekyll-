/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd210010;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付制限対象者一覧CSVのデータEntityです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KyufuSeikentaishoshaCsvEntity {

    @CsvField(order = 1, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 2, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 3, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 4, name = "氏名")
    private RString 氏名;
    @CsvField(order = 5, name = "カナ氏名")
    private RString カナ氏名;
    @CsvField(order = 6, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 7, name = "性別コード")
    private RString 性別コード;
    @CsvField(order = 8, name = "性別")
    private RString 性別;
    @CsvField(order = 9, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 10, name = "住所コード")
    private RString 住所コード;
    @CsvField(order = 11, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 12, name = "世帯コード")
    private RString 世帯コード;
    @CsvField(order = 13, name = "住所")
    private RString 住所;
    @CsvField(order = 14, name = "資格取得日")
    private RString 資格取得日;
    @CsvField(order = 15, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 16, name = "認定申請日")
    private RString 認定申請日;
    @CsvField(order = 17, name = "要介護状態区分")
    private RString 要介護状態区分;
    @CsvField(order = 18, name = "要介護状態名称")
    private RString 要介護状態名称;
    @CsvField(order = 19, name = "認定有効開始年月日")
    private RString 認定有効開始年月日;
    @CsvField(order = 20, name = "認定有効終了年月日")
    private RString 認定有効終了年月日;
    @CsvField(order = 21, name = "認定日")
    private RString 認定日;
    @CsvField(order = 22, name = "管理区分")
    private RString 管理区分;
    @CsvField(order = 23, name = "管理区分名称")
    private RString 管理区分名称;
    @CsvField(order = 24, name = "登録区分")
    private RString 登録区分;
    @CsvField(order = 25, name = "登録区分名称")
    private RString 登録区分名称;
    @CsvField(order = 26, name = "適用開始日")
    private RString 適用開始日;
    @CsvField(order = 27, name = "適用終了日")
    private RString 適用終了日;
    @CsvField(order = 28, name = "終了区分")
    private RString 終了区分;
    @CsvField(order = 29, name = "終了区分名称")
    private RString 終了区分名称;
    @CsvField(order = 30, name = "予告登録日")
    private RString 予告登録日;
    @CsvField(order = 31, name = "差止依頼書受理日")
    private RString 差止依頼書受理日;
    @CsvField(order = 32, name = "予告通知書出力日")
    private RString 予告通知書出力日;
    @CsvField(order = 33, name = "予告通知書発行日")
    private RString 予告通知書発行日;
    @CsvField(order = 34, name = "弁明書提出期限")
    private RString 弁明書提出期限;
    @CsvField(order = 35, name = "弁明書受付日")
    private RString 弁明書受付日;
    @CsvField(order = 36, name = "弁明理由")
    private RString 弁明理由;
    @CsvField(order = 37, name = "弁明理由名称")
    private RString 弁明理由名称;
    @CsvField(order = 38, name = "弁明内容決定日")
    private RString 弁明内容決定日;
    @CsvField(order = 39, name = "弁明審査結果")
    private RString 弁明審査結果;
    @CsvField(order = 40, name = "弁明審査結果名称")
    private RString 弁明審査結果名称;
    @CsvField(order = 41, name = "償還払化決定日")
    private RString 償還払化決定日;
    @CsvField(order = 42, name = "償還払化通知書出力日")
    private RString 償還払化通知書出力日;
    @CsvField(order = 43, name = "償還払化通知書発行日")
    private RString 償還払化通知書発行日;
    @CsvField(order = 44, name = "被保険者証提出期限")
    private RString 被保険者証提出期限;
    @CsvField(order = 45, name = "差止対象フラグ")
    private RString 差止対象フラグ;
    @CsvField(order = 46, name = "差止決定日")
    private RString 差止決定日;
    @CsvField(order = 47, name = "差止解除日")
    private RString 差止解除日;
    @CsvField(order = 48, name = "控除決定日")
    private RString 控除決定日;
    @CsvField(order = 49, name = "減額決定日")
    private RString 減額決定日;
    @CsvField(order = 50, name = "減額通知書出力日")
    private RString 減額通知書出力日;
    @CsvField(order = 51, name = "減額通知書発行日")
    private RString 減額通知書発行日;
    @CsvField(order = 52, name = "給付率")
    private RString 給付率;
    @CsvField(order = 53, name = "終了申請書受付日")
    private RString 終了申請書受付日;
    @CsvField(order = 54, name = "終了申請年月日")
    private RString 終了申請年月日;
    @CsvField(order = 55, name = "終了申請理由")
    private RString 終了申請理由;
    @CsvField(order = 56, name = "終了申請理由名称")
    private RString 終了申請理由名称;
    @CsvField(order = 57, name = "終了申請内容決定日")
    private RString 終了申請内容決定日;
    @CsvField(order = 58, name = "終了申請審査結果")
    private RString 終了申請審査結果;
    @CsvField(order = 59, name = "終了申請審査結果名称")
    private RString 終了申請審査結果名称;
    @CsvField(order = 60, name = "徴収権消滅期間")
    private RString 徴収権消滅期間;
    @CsvField(order = 61, name = "納付済期間")
    private RString 納付済期間;
    @CsvField(order = 62, name = "納付済減額期間")
    private RString 納付済減額期間;
    @CsvField(order = 63, name = "確定給付額減額期間・開始日")
    private RString 確定給付額減額期間開始日;
    @CsvField(order = 64, name = "確定給付額減額期間・終了日")
    private RString 確定給付額減額期間終了日;
    @CsvField(order = 65, name = "通知時滞納額合計")
    private RString 通知時滞納額合計;
    @CsvField(order = 66, name = "現在滞納額合計")
    private RString 現在滞納額合計;

}
