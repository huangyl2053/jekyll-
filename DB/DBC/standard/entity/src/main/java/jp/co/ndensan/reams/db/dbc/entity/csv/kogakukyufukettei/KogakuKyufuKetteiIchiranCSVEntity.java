/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 高額サービス費決定情報取込みの一覧表CSVEntity
 *
 * @reamsid_L DBC-0980-390 zhangrui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KogakuKyufuKetteiIchiranCSVEntity {

    @CsvField(order = 10, name = "処理年月")
    private RString 処理年月;
    @CsvField(order = 20, name = "作成日時")
    private RString 作成日時;
    @CsvField(order = 30, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 40, name = "明細項目")
    private RString 明細項目;
    @CsvField(order = 50, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 60, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 70, name = "通知書番号")
    private RString 通知書番号;
    @CsvField(order = 80, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 90, name = "被保険者氏名カナ")
    private RString 被保険者氏名カナ;
    @CsvField(order = 100, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 110, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 120, name = "決定年月")
    private RString 決定年月;
    @CsvField(order = 130, name = "支払可否")
    private RString 支払可否;
    @CsvField(order = 140, name = "支払方法")
    private RString 支払方法;
    @CsvField(order = 150, name = "利用者負担額")
    private RString 利用者負担額;
    @CsvField(order = 160, name = "決定支給額")
    private RString 決定支給額;
    @CsvField(order = 170, name = "資格喪失事由")
    private RString 資格喪失事由;
    @CsvField(order = 180, name = "資格喪失日")
    private RString 資格喪失日;
    @CsvField(order = 190, name = "町域コード")
    private RString 町域コード;
    @CsvField(order = 200, name = "行政区コード")
    private RString 行政区コード;
    @CsvField(order = 210, name = "行政区名")
    private RString 行政区名;
    @CsvField(order = 220, name = "郵便番号")
    private RString 郵便番号;
    @CsvField(order = 230, name = "住所")
    private RString 住所;
    @CsvField(order = 240, name = "備考")
    private RString 備考;

}
