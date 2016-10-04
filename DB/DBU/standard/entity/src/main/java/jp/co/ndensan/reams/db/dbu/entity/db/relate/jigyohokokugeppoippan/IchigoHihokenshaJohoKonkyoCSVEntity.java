/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppoippan;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ファイル出力（根拠CSV）_世帯情報CSVEntityクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IchigoHihokenshaJohoKonkyoCSVEntity {

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
    @CsvField(order = 9, name = "異動日")
    private RString 異動日;
    @CsvField(order = 10, name = "枝番")
    private RString 枝番;
    @CsvField(order = 11, name = "市町村コード")
    private RString 市町村コード;
    @CsvField(order = 12, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 13, name = "異動事由コード")
    private RString 異動事由コード;
    @CsvField(order = 14, name = "資格取得年月日")
    private RString 資格取得年月日;
    @CsvField(order = 15, name = "資格取得届出年月日")
    private RString 資格取得届出年月日;
    @CsvField(order = 16, name = "資格喪失事由コード")
    private RString 資格喪失事由コード;
    @CsvField(order = 17, name = "資格喪失年月日")
    private RString 資格喪失年月日;
    @CsvField(order = 18, name = "資格喪失届出年月日")
    private RString 資格喪失届出年月日;
    @CsvField(order = 19, name = "被保険者区分コード")
    private RString 被保険者区分コード;
    @CsvField(order = 20, name = "住所地特例フラグ")
    private RString 住所地特例フラグ;
    @CsvField(order = 21, name = "広域内住所地特例フラグ")
    private RString 広域内住所地特例フラグ;
    @CsvField(order = 22, name = "広住特措置元市町村コード")
    private RString 広住特措置元市町村コード;
    @CsvField(order = 23, name = "旧市町村コード")
    private RString 旧市町村コード;
    @CsvField(order = 24, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 25, name = "生年月日")
    private RString 生年月日;
}
