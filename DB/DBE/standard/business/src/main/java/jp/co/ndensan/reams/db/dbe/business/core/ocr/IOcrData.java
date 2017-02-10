/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;

/**
 * OCR取込結果のレコードであることを表します。
 */
public interface IOcrData {

    /**
     * @return OCRID
     */
    OCRID getOCRID();

    /**
     * @return シートID（帳票連番）
     */
    SheetID getSheetID();
}
