/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再審査決定通知書情報取込（公費負担者分）集計部
 *
 * @reamsid_L DBC-2820-010 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SaishinsaKohifutanshaShukeiCSVEntity {

    @CsvField(order = 10, name = "取扱年月")
    private RString 取扱年月;
    @CsvField(order = 20, name = "履歴番号")
    private RString 履歴番号;
    @CsvField(order = 30, name = "介護給付費請求件数")
    private RString 介護給付費請求件数;
    @CsvField(order = 40, name = "介護給付費請求単位数")
    private RString 介護給付費請求単位数;
    @CsvField(order = 50, name = "介護給付費請求公費負担額")
    private RString 介護給付費請求公費負担額;
    @CsvField(order = 60, name = "介護給付費決定件数")
    private RString 介護給付費決定件数;
    @CsvField(order = 70, name = "介護給付費決定単位数")
    private RString 介護給付費決定単位数;
    @CsvField(order = 80, name = "介護給付費決定公費負担額")
    private RString 介護給付費決定公費負担額;
    @CsvField(order = 90, name = "介護給付費調整件数")
    private RString 介護給付費調整件数;
    @CsvField(order = 100, name = "介護給付費調整単位数")
    private RString 介護給付費調整単位数;
    @CsvField(order = 110, name = "介護給付費調整公費負担額")
    private RString 介護給付費調整公費負担額;
    @CsvField(order = 120, name = "高額介護サービス費請求件数")
    private RString 高額介護サービス費請求件数;
    @CsvField(order = 130, name = "高額介護サービス費請求単位数")
    private RString 高額介護サービス費請求単位数;
    @CsvField(order = 140, name = "高額介護サービス費請求公費負担額")
    private RString 高額介護サービス費請求公費負担額;
    @CsvField(order = 150, name = "高額介護サービス費決定件数")
    private RString 高額介護サービス費決定件数;
    @CsvField(order = 160, name = "高額介護サービス費決定単位数")
    private RString 高額介護サービス費決定単位数;
    @CsvField(order = 170, name = "高額介護サービス費決定公費負担額")
    private RString 高額介護サービス費決定公費負担額;
    @CsvField(order = 180, name = "高額介護サービス費調整件数")
    private RString 高額介護サービス費調整件数;
    @CsvField(order = 190, name = "高額介護サービス費調整単位数")
    private RString 高額介護サービス費調整単位数;
    @CsvField(order = 200, name = "高額介護サービス費調整公費負担額")
    private RString 高額介護サービス費調整公費負担額;
    @CsvField(order = 210, name = "公費負担者番号")
    private RString 公費負担者番号;
    @CsvField(order = 220, name = "公費負担者名")
    private RString 公費負担者名;
    @CsvField(order = 230, name = "作成年月日")
    private RString 作成年月日;
    @CsvField(order = 240, name = "国保連合会名")
    private RString 国保連合会名;
    @CsvField(order = 250, name = "審査委員会名")
    private RString 審査委員会名;
}
