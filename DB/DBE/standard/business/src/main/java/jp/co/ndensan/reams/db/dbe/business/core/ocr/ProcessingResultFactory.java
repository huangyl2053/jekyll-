/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * {@link IProcessingResult}のファクトリです。
 */
public final class ProcessingResultFactory {

    private ProcessingResultFactory() {
    }

    /**
     * @param type {@link IProcessingResult.Type}
     * @param ocrData {@link IOcrData}
     * @param messageToNote 備考
     * @return {@link IProcessingResult.Type#SUCCESS}のインスタンス
     */
    public static IProcessingResult create(IProcessingResult.Type type, IOcrData ocrData, OcrTorikomiMessages messageToNote) {
        return new SimpleProcessingResult(ocrData, type, messageToNote.originalMessage());
    }

    /**
     * @param type {@link IProcessingResult.Type}
     * @param ocrData {@link IOcrData}
     * @param messageToNote 備考
     * @return {@link IProcessingResult.Type#SUCCESS}のインスタンス
     */
    public static IProcessingResult create(IProcessingResult.Type type, IOcrData ocrData, RString messageToNote) {
        return new SimpleProcessingResult(ocrData, type, messageToNote);
    }

    /**
     * @param ocrData {@link IOcrData}
     * @param note 備考
     * @return {@link IProcessingResult.Type#SUCCESS}のインスタンス
     */
    public static IProcessingResult success(IOcrData ocrData, RString note) {
        return new SimpleProcessingResult(ocrData, IProcessingResult.Type.SUCCESS, note);
    }

    /**
     * @param ocrData {@link IOcrData}
     * @return {@link IProcessingResult.Type#SUCCESS}のインスタンス（備考なし）
     */
    public static IProcessingResult success(IOcrData ocrData) {
        return new SimpleProcessingResult(ocrData, IProcessingResult.Type.SUCCESS, RString.EMPTY);
    }

    /**
     * @param ocrData {@link IOcrData}
     * @param note 備考
     * @return {@link IProcessingResult.Type#ERROR}のインスタンス
     */
    public static IProcessingResult error(IOcrData ocrData, RString note) {
        return new SimpleProcessingResult(ocrData, IProcessingResult.Type.ERROR, note);
    }

    /**
     * @param ocrData {@link IOcrData}
     * @param messageToNote 備考
     * @return {@link IProcessingResult.Type#ERROR}のインスタンス
     */
    public static IProcessingResult error(IOcrData ocrData, OcrTorikomiMessages messageToNote) {
        return new SimpleProcessingResult(ocrData, IProcessingResult.Type.ERROR, messageToNote.originalMessage());
    }

    /**
     * @param ocrData {@link IOcrData}
     * @param note 備考
     * @return {@link IProcessingResult.Type#WARNING}のインスタンス
     */
    public static IProcessingResult warning(IOcrData ocrData, RString note) {
        return new SimpleProcessingResult(ocrData, IProcessingResult.Type.WARNING, note);
    }

    /**
     * @param ocrData {@link IOcrData}
     * @param messageToNote 備考
     * @return {@link IProcessingResult.Type#WARNING}のインスタンス
     */
    public static IProcessingResult warning(IOcrData ocrData, OcrTorikomiMessages messageToNote) {
        return new SimpleProcessingResult(ocrData, IProcessingResult.Type.WARNING, messageToNote.originalMessage());
    }

    private static final class SimpleProcessingResult implements IProcessingResult {

        private final IOcrData theOcrData;
        private final IProcessingResult.Type theType;
        private final RString theNote;

        SimpleProcessingResult(IOcrData ocrData, IProcessingResult.Type theType, RString theNote) {
            this.theOcrData = ocrData;
            this.theType = theType;
            this.theNote = theNote;
        }

        @Override
        public IOcrData ocrData() {
            return this.theOcrData;
        }

        @Override
        public IProcessingResult.Type type() {
            return this.theType;
        }

        @Override
        public RString note() {
            return this.theNote;
        }
    }
}
