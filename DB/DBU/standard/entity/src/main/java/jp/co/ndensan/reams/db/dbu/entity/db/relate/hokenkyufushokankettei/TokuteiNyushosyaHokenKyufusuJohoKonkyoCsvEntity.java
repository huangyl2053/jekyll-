/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.hokenkyufushokankettei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定入所者保険給付数情報根拠CSVEntityクラスです。
 *
 * @reamsid_L DBU-5570-030 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiNyushosyaHokenKyufusuJohoKonkyoCsvEntity {

    @CsvField(order = 1, name = "データ区分")
    private RString データ区分;
    @CsvField(order = 2, name = "集計区分")
    private RString 集計区分;
    @CsvField(order = 3, name = "表番号")
    private RString 表番号;
    @CsvField(order = 4, name = "集計番号")
    private RString 集計番号;
    @CsvField(order = 5, name = "集計単位")
    private RString 集計単位;
    @CsvField(order = 6, name = "縦番号")
    private RString 縦番号;
    @CsvField(order = 7, name = "横番号")
    private RString 横番号;
    @CsvField(order = 8, name = "入力識別番号")
    private RString 入力識別番号;
    @CsvField(order = 9, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 10, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 11, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 12, name = "給付実績区分コード")
    private RString 給付実績区分コード;
    @CsvField(order = 13, name = "事業者番号")
    private RString 事業者番号;
    @CsvField(order = 14, name = "整理番号")
    private RString 整理番号;
    @CsvField(order = 15, name = "明細番号")
    private RString 明細番号;
    @CsvField(order = 16, name = "元整理番号")
    private RString 元整理番号;
    @CsvField(order = 17, name = "支給区分コード")
    private RString 支給区分コード;
    @CsvField(order = 18, name = "生年月日")
    private RString 生年月日;
    @CsvField(order = 19, name = "要介護状態区分コード")
    private RString 要介護状態区分コード;
    @CsvField(order = 20, name = "給付実績情報作成区分コード")
    private RString 給付実績情報作成区分コード;
    @CsvField(order = 21, name = "連番")
    private RString 連番;
    @CsvField(order = 22, name = "順次番号")
    private RString 順次番号;
    @CsvField(order = 23, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 24, name = "サービス項目コード")
    private RString サービス項目コード;
    @CsvField(order = 25, name = "後・保険分請求額")
    private RString 後_保険分請求額;
    @CsvField(order = 26, name = "資格区分")
    private RString 資格区分;
    @CsvField(order = 27, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 28, name = "旧市町村コード")
    private RString 旧市町村コード;
    @CsvField(order = 29, name = "現物分存在フラグ")
    private RString 現物分存在フラグ;
}
