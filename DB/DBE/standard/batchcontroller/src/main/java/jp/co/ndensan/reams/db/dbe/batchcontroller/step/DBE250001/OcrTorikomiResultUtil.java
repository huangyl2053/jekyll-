/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResultSeed;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist.OcrTorikomiResult;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 */
public final class OcrTorikomiResultUtil {

    private OcrTorikomiResultUtil() {
    }

    public static List<OcrTorikomiResult> create(ShinseiKey key, Iterable<? extends IOcrData> ocrData,
            IProcessingResult.Type type, OcrTorikomiMessages messageToNote) {
        return create(key, ocrData, type, messageToNote.originalMessage());
    }

    public static List<OcrTorikomiResult> create(ShinseiKey key, Iterable<? extends IOcrData> ocrData,
            IProcessingResult.Type type, RString messageToNote) {
        List<OcrTorikomiResult> results = new ArrayList<>();
        for (IOcrData o : ocrData) {
            results.add(new OcrTorikomiResult.Builder(key)
                    .set処理結果(ProcessingResultFactory.create(type, o, messageToNote))
                    .build());
        }
        return results;
    }

    public static List<OcrTorikomiResult> create(ShinseiKey key, IProcessingResults results) {
        return Arrays.asList(new OcrTorikomiResult.Builder(key)
                .set処理結果s(results)
                .build());
    }
}
