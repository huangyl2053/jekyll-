/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込（保険者分）集計CSVEntity
 *
 * @reamsid_L DBC-2520-010 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKetteiHokenshaInCSVGokeiEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 20, name = "帳票レコード種別ヘッダ")
    private RString 帳票レコード種別ヘッダ;
    @CsvField(order = 30, name = "介護給付費_請求_件数")
    private RString 介護給付費_請求_件数;
    @CsvField(order = 40, name = "介護給付費_請求_単位数")
    private RString 介護給付費_請求_単位数;
    @CsvField(order = 50, name = "介護給付費_請求_保険者負担額")
    private RString 介護給付費_請求_保険者負担額;
    @CsvField(order = 60, name = "介護給付費_決定_件数")
    private RString 介護給付費_決定_件数;
    @CsvField(order = 70, name = "介護給付費_決定_単位数")
    private RString 介護給付費_決定_単位数;
    @CsvField(order = 80, name = "介護給付費_決定_保険者負担額")
    private RString 介護給付費_決定_保険者負担額;
    @CsvField(order = 90, name = "介護給付費_調整_件数")
    private RString 介護給付費_調整_件数;
    @CsvField(order = 100, name = "介護給付費_調整_単位数")
    private RString 介護給付費_調整_単位数;
    @CsvField(order = 110, name = "介護給付費_調整_保険者負担額")
    private RString 介護給付費_調整_保険者負担額;
    @CsvField(order = 120, name = "高額介護サービス費_請求_件数")
    private RString 高額介護サービス費_請求_件数;
    @CsvField(order = 130, name = "高額介護サービス費_請求_単位数")
    private RString 高額介護サービス費_請求_単位数;
    @CsvField(order = 140, name = "高額介護サービス費_請求_保険者負担額")
    private RString 高額介護サービス費_請求_保険者負担額;
    @CsvField(order = 150, name = "高額介護サービス費_決定_件数")
    private RString 高額介護サービス費_決定_件数;
    @CsvField(order = 160, name = "高額介護サービス費_決定_単位数")
    private RString 高額介護サービス費_決定_単位数;
    @CsvField(order = 170, name = "高額介護サービス費_決定_保険者負担額")
    private RString 高額介護サービス費_決定_保険者負担額;
    @CsvField(order = 180, name = "高額介護サービス費_調整_件数")
    private RString 高額介護サービス費_調整_件数;
    @CsvField(order = 190, name = "高額介護サービス費_調整_単位数")
    private RString 高額介護サービス費_調整_単位数;
    @CsvField(order = 200, name = "高額介護サービス費_調整_保険者負担額")
    private RString 高額介護サービス費_調整_保険者負担額;

}
