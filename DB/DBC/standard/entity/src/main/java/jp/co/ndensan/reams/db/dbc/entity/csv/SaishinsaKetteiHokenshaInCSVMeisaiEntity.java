/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 再審査決定通知書情報取込（保険者分）明細CSVEntity
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaInCSVMeisaiEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 20, name = "帳票レコード種別ヘッダ")
    private RString 帳票レコード種別ヘッダ;
    @CsvField(order = 30, name = "事業所番号")
    private RString 事業所番号;
    @CsvField(order = 40, name = "事業所名")
    private RString 事業所名;
    @CsvField(order = 50, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 60, name = "被保険者氏名")
    private RString 被保険者氏名;
    @CsvField(order = 70, name = "サービス提供年月")
    private RString サービス提供年月;
    @CsvField(order = 80, name = "サービス種類コード")
    private RString サービス種類コード;
    @CsvField(order = 90, name = "サービス種類名")
    private RString サービス種類名;
    @CsvField(order = 100, name = "申立事由コード")
    private RString 申立事由コード;
    @CsvField(order = 110, name = "申立事由")
    private RString 申立事由;
    @CsvField(order = 120, name = "再審査結果コード")
    private RString 再審査結果コード;
    @CsvField(order = 130, name = "当初請求単位数")
    private RString 当初請求単位数;
    @CsvField(order = 140, name = "原番単位数")
    private RString 原番単位数;
    @CsvField(order = 150, name = "申立単位数")
    private RString 申立単位数;
    @CsvField(order = 160, name = "決定単位数")
    private RString 決定単位数;
    @CsvField(order = 170, name = "調整単位数")
    private RString 調整単位数;
    @CsvField(order = 180, name = "保険者負担額")
    private RString 保険者負担額;

}
