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
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KagoKetteiKohifutanshaInMesaiCSVEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString 帳票レコード種別;
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
    @CsvField(order = 130, name = "過誤申立事由コード")
    private RString 過誤申立事由コード;
    @CsvField(order = 140, name = "過誤申立事由")
    private RString 過誤申立事由;
    @CsvField(order = 150, name = "単位数")
    private RString 単位数;
    @CsvField(order = 160, name = "公費負担額")
    private RString 公費負担額;
}
