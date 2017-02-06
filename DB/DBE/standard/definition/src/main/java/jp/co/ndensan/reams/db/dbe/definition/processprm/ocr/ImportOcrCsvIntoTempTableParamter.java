/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.processprm.ocr;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImportOcrCsvIntoTempTableParamter implements IBatchProcessParameter {

    private final RString csvFilePath;
    private final RString tempTableName;

    /**
     * @param csvFilePath CSVファイルのパス
     * @param tempTableName 一時テーブルのパス
     */
    public ImportOcrCsvIntoTempTableParamter(RString csvFilePath, RString tempTableName) {
        this.csvFilePath = csvFilePath;
        this.tempTableName = tempTableName;
    }
}
