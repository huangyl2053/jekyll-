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
public class KagoKetteiKohifutanshaInShukeiCSVEntity {

    @CsvField(order = 10, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 20, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 30, name = "介護給付費の件数")
    private RString 介護給付費の件数;
    @CsvField(order = 40, name = "介護給付費の単位数")
    private RString 介護給付費の単位数;
    @CsvField(order = 50, name = "介護給付費の公費負担額")
    private RString 介護給付費の公費負担額;
    @CsvField(order = 60, name = "高額介護サービス費の件数")
    private RString 高額介護サービス費の件数;
    @CsvField(order = 70, name = "高額介護サービス費の単位数")
    private RString 高額介護サービス費の単位数;
    @CsvField(order = 80, name = "高額介護サービス費の公費負担額")
    private RString 高額介護サービス費の公費負担額;
    @CsvField(order = 90, name = "特定入所者介護サービス費等の件数")
    private RString 特定入所者介護サービス費等の件数;
    @CsvField(order = 100, name = "特定入所者介護サービス費等の費用額")
    private RString 特定入所者介護サービス費等の費用額;
    @CsvField(order = 110, name = "特定入所者介護サービス費等の公費負担額")
    private RString 特定入所者介護サービス費等の公費負担額;
}
