/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コードマスタCSV用データEntity。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CodeMasterEucCsvEntity {

    @CsvField(order = 1, name = "コード名称")
    private RString コード名称;
    @CsvField(order = 2, name = "コード値")
    private RString コード値;
    @CsvField(order = 3, name = "コード表示名称")
    private RString コード表示名称;
}
