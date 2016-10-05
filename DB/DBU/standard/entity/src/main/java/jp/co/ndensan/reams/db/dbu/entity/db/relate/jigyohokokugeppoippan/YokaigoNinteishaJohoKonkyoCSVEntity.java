/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力（根拠CSV）_受給者台帳情報CSVEntityクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteishaJohoKonkyoCSVEntity {

    @CsvField(order = 1, name = "集計データ区分")
    private RString 集計データ区分;
    @CsvField(order = 2, name = "集計区分 ")
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
    @CsvField(order = 8, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 9, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 10, name = "要介護認定状態区分コード")
    private RString 要介護認定状態区分コード;
    @CsvField(order = 11, name = "受給申請年月日")
    private RString 受給申請年月日;
    @CsvField(order = 12, name = "認定有効期間開始年月日")
    private RString 認定有効期間開始年月日;
    @CsvField(order = 13, name = "認定有効期間終了年月日")
    private RString 認定有効期間終了年月日;
    @CsvField(order = 14, name = "認定年月日")
    private RString 認定年月日;
    @CsvField(order = 15, name = "有効無効区分")
    private RString 有効無効区分;
    @CsvField(order = 16, name = "データ区分")
    private RString データ区分;
    @CsvField(order = 17, name = "旧措置者フラグ")
    private RString 旧措置者フラグ;
    @CsvField(order = 18, name = "論理削除フラグ")
    private RString 論理削除フラグ;
    @CsvField(order = 19, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 20, name = "旧市町村コード")
    private RString 旧市町村コード;
}
