/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakuservicehihanteikekkaout;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費給付判定結果情報作成の帳票CSVEntity
 *
 * @reamsid_L DBC-2610-030 liuhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuServicehiHanteiDoIchiranCSVEntity {

    @CsvField(order = 10, name = "送付年月")
    private RString 送付年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "保険者番号")
    private RString 保険者番号;
    @CsvField(order = 40, name = "保険者名")
    private RString 保険者名;
    @CsvField(order = 50, name = "No.")
    private RString no;
    @CsvField(order = 60, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 70, name = "被保険者カナ氏名")
    private RString 被保険者カナ氏名;
    @CsvField(order = 80, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 90, name = "町域コード")
    private RString 町域コード;
    @CsvField(order = 100, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 110, name = "住所")
    private RString 住所;
    @CsvField(order = 120, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 130, name = "行政区")
    private RString 行政区;
    @CsvField(order = 140, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 150, name = "支給区分")
    private RString 支給区分;
    @CsvField(order = 160, name = "支給区分名")
    private RString 支給区分名;
    @CsvField(order = 170, name = "審査方法")
    private RString 審査方法;
    @CsvField(order = 180, name = "審査方法名")
    private RString 審査方法名;
    @CsvField(order = 190, name = "受付年月日")
    private RString 受付年月日;
    @CsvField(order = 200, name = "決定年月日")
    private RString 決定年月日;
    @CsvField(order = 210, name = "本人支払額")
    private RString 本人支払額;
    @CsvField(order = 220, name = "支給額")
    private RString 支給額;
    @CsvField(order = 230, name = "不支給理由")
    private RString 不支給理由;

}
