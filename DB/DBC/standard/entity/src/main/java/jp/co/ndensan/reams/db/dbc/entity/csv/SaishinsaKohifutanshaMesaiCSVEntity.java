/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込（公費負担者分）明細部
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKohifutanshaMesaiCSVEntity {

    @CsvField(order = 10, name = "取扱年月")
    private RString 取扱年月;
    @CsvField(order = 20, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 30, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 40, name = "事業所名")
    private RString 事業所名;
    @CsvField(order = 50, name = "公費受給者番号")
    private RString 公費受給者番号;
    @CsvField(order = 60, name = "公費受給者氏名")
    private RString 公費受給者氏名;
    @CsvField(order = 70, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 80, name = "証記載保険者名")
    private RString 証記載保険者名;
    @CsvField(order = 90, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 100, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 110, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 120, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 130, name = "再審査申立事由コード")
    private RString 再審査申立事由コード;
    @CsvField(order = 140, name = "再審査申立事由")
    private RString 再審査申立事由;
    @CsvField(order = 150, name = "再審査結果コード")
    private RString 再審査結果コード;
    @CsvField(order = 160, name = "当初請求単位数")
    private RString 当初請求単位数;
    @CsvField(order = 170, name = "原番単位数")
    private RString 原番単位数;
    @CsvField(order = 180, name = "申立単位数")
    private RString 申立単位数;
    @CsvField(order = 190, name = "決定単位数")
    private RString 決定単位数;
    @CsvField(order = 200, name = "調整単位数")
    private RString 調整単位数;
    @CsvField(order = 210, name = "公費負担額")
    private RString 公費負担額;
}
