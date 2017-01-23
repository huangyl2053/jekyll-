/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ocr;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ocr.OcrCsvMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.TempOcrCsvEntity;

/**
 * OCRCSVデータを格納した一時テーブルを参照します。
 */
public interface IOcrCsvMapper {

    /**
     * @param param {@link OcrCsvMapperParameter}
     * @return {@link TempOcrCsvEntity}
     */
    List<TempOcrCsvEntity> findCsvDataOrderByKey(OcrCsvMapperParameter param);
}
