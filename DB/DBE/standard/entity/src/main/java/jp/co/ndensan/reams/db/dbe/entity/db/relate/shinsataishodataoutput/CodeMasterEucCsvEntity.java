/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コードマスタCSV用Entityです。
 *
 * @reamsid_L DBE-1840-011 yaoyahui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CodeMasterEucCsvEntity {

    @CsvField(order = 1, name = "コード種別")
    private RString コード種別;
    @CsvField(order = 2, name = "コード")
    private RString コード;
    @CsvField(order = 3, name = "名称")
    private RString 名称;
    @CsvField(order = 4, name = "備考1")
    private RString 備考1;
    @CsvField(order = 5, name = "備考2")
    private RString 備考2;
    @CsvField(order = 6, name = "備考3")
    private RString 備考3;
    @CsvField(order = 7, name = "備考4")
    private RString 備考4;
    @CsvField(order = 8, name = "備考5")
    private RString 備考5;

}
