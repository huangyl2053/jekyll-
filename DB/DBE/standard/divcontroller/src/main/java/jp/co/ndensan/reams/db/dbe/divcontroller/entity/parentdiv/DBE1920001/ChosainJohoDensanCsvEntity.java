/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE1920001;

import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査員情報ファイルEntity(電算標準版)です。
 *
 * @reamsid_L DBE-1490-010 xuyannan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosainJohoDensanCsvEntity {

    @CsvField(order = 1, name = "シーケンシャル番号")
    private RString シーケンシャル番号;
    @CsvField(order = 2, name = "機能コード")
    private RString 機能コード;
    @CsvField(order = 3, name = "識別コード")
    private RString 識別コード;
    @CsvField(order = 4, name = "委託先コード")
    private RString 委託先コード;
    @CsvField(order = 5, name = "調査員コード")
    private RString 調査員コード;
    @CsvField(order = 6, name = "調査員名称")
    private RString 調査員名称;
    @CsvField(order = 7, name = "資格コード")
    private RString 資格コード;
    @CsvField(order = 8, name = "状況")
    private RString 状況;
    @CsvField(order = 9, name = "調査員名称（カナ）")
    private RString 調査員名称_カナ;
    private int 項目数;
}
