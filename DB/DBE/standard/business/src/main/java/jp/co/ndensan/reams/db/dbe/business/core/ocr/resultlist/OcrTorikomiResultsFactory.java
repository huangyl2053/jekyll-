/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.resultlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IRelatedData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 複数件の{@link OcrTorikomiResult}を同時に生成するための機能を持ちます。
 */
public final class OcrTorikomiResultsFactory {

    private OcrTorikomiResultsFactory() {
    }

    /**
     * @param key 申請のキー
     * @param ocrData 対象レコード
     * @param type 結果の種類
     * @param messageToNote 備考の内容
     * @return 出力内容
     */
    public static List<OcrTorikomiResult> create(ShinseiKey key, Iterable<? extends IOcrData> ocrData,
            IProcessingResult.Type type, OcrTorikomiMessages messageToNote) {
        return create(key, ocrData, type, messageToNote.originalMessage());
    }

    /**
     * @param key 申請のキー
     * @param ocrData 対象レコード
     * @param type 結果の種類
     * @param messageToNote 備考の内容
     * @return 出力内容
     */
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

    /**
     * @param key 申請のキー
     * @param results 処理結果
     * @param 関連データ 対象者を表す情報
     * @return 出力内容
     */
    public static List<OcrTorikomiResult> create(ShinseiKey key, IProcessingResults results, IRelatedData 関連データ) {
        return Arrays.asList(new OcrTorikomiResult.Builder(key)
                .set関連データ(関連データ)
                .set処理結果s(results)
                .build());
    }

    /**
     * @param key 申請のキー
     * @param results 処理結果
     * @return 出力内容
     */
    public static List<OcrTorikomiResult> create(ShinseiKey key, IProcessingResults results) {
        return Arrays.asList(new OcrTorikomiResult.Builder(key)
                .set処理結果s(results)
                .build());
    }
}
