/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ocr;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link IOcrCsvMapper}のパラメータです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class OcrCsvMapperParameter implements IMyBatisParameter {

    private final RString tempTableName;

    public OcrCsvMapperParameter(RString tempTableName) {
        this.tempTableName = tempTableName;
    }
}
