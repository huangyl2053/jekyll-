/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.csv.dbc120920;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査決定請求明細表情報取込共通処理（CSVファイル取込）のRecode1Aクラスです
 *
 * @reamsid_L DBC-2500-013 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SogojigyohiShinsaKetteiCsvFileToreraRecode1AEntity {

    @CsvField(order = 10, name = "レコード種別")
    private RString レコード種別;
    @CsvField(order = 20, name = "レコード番号")
    private RString レコード番号;
    @CsvField(order = 30, name = "交換情報識別番号")
    private RString 交換情報識別番号;
    @CsvField(order = 40, name = "帳票レコード種別")
    private RString 帳票レコード種別;
    @CsvField(order = 50, name = "高額該当件数")
    private RString 高額該当件数;
    @CsvField(order = 60, name = "高額介護サービス費")
    private RString 高額介護サービス費;
    @CsvField(order = 70, name = "公費負担額")
    private RString 公費負担額;
    @CsvField(order = 80, name = "ブランク")
    private RString ブランク;
}
