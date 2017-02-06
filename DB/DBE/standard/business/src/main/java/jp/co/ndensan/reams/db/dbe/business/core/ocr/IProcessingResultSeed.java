/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

/**
 *
 */
public interface IProcessingResultSeed {

    /**
     * @return 処理結果の種類
     */
    IProcessingResult.Type type();

    /**
     * @param ocrData
     * @return
     */
    IProcessingResult toProcessingResult(IOcrData ocrData);
}
