/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力（根拠CSV）_特定入所者管理情報CSVEntityクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuteiNyushoshaGengakuNinteiJohoCSVEntity {

    @CsvField(order = 1, name = "データ区分")
    private RString データ区分;
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
    @CsvField(order = 10, name = "申請年月日")
    private RString 申請年月日;
    @CsvField(order = 11, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 12, name = "決定区分")
    private RString 決定区分;
    @CsvField(order = 13, name = "非承認理由")
    private RString 非承認理由;
    @CsvField(order = 14, name = "適用開始年月日")
    private RString 適用開始年月日;
    @CsvField(order = 15, name = "適用終了年月日")
    private RString 適用終了年月日;
    @CsvField(order = 16, name = "旧措置者")
    private RString 旧措置者;
    @CsvField(order = 17, name = "食費負担限度額")
    private RString 食費負担限度額;
    @CsvField(order = 18, name = "ユニット型個室")
    private RString ユニット型個室;
    @CsvField(order = 19, name = "ユニット型準個室")
    private RString ユニット型準個室;
    @CsvField(order = 20, name = "従来型個室（特養等）")
    private RString 従来型個室_特養等;
    @CsvField(order = 21, name = "従来型個室（老健・療養等）")
    private RString 従来型個室_老健療養等;
    @CsvField(order = 22, name = "多床室")
    private RString 多床室;
    @CsvField(order = 23, name = "居室種別")
    private RString 居室種別;
    @CsvField(order = 24, name = "特例減額措置区分")
    private RString 特例減額措置区分;
    @CsvField(order = 25, name = "境界層該当者")
    private RString 境界層該当者;
    @CsvField(order = 26, name = "激変緩和対象者")
    private RString 激変緩和対象者;
    @CsvField(order = 27, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 28, name = "旧市町村コード")
    private RString 旧市町村コード;
}
