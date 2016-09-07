/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報ファイルEntity(厚労省)です。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShujiiJohoKouroushouCsvEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "医療機関コード")
    private RString 医療機関コード;
    @CsvField(order = 5, name = "主治医コード")
    private RString 主治医コード;
    @CsvField(order = 6, name = "主治医名称")
    private RString 主治医名称;
    @CsvField(order = 7, name = "状況")
    private RString 状況;
    private int 項目数;
}
