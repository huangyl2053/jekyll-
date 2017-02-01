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
     * @param note 備考
     * @return {@link IProcessingResult.Type#SUCCESS}のインスタンス
     */
    public static IProcessingResult success(RString note) {
        return new SimpleProcessingResult(IProcessingResult.Type.SUCCESS, note);
    }

    /**
     * @return {@link IProcessingResult.Type#SUCCESS}のインスタンス（備考なし）
     */
    public static IProcessingResult success() {
        return new SimpleProcessingResult(IProcessingResult.Type.SUCCESS, RString.EMPTY);
    }

    /**
     * @param note 備考
     * @return {@link IProcessingResult.Type#ERROR}のインスタンス
     */
    public static IProcessingResult error(RString note) {
        return new SimpleProcessingResult(IProcessingResult.Type.ERROR, note);
    }

    /**
     * @param messageToNote 備考
     * @return {@link IProcessingResult.Type#ERROR}のインスタンス
     */
    public static IProcessingResult error(OcrTorikomiMessages messageToNote) {
        return new SimpleProcessingResult(IProcessingResult.Type.ERROR, messageToNote.originalMessage());
    }

    /**
     * @param note 備考
     * @return {@link IProcessingResult.Type#WARNING}のインスタンス
     */
    public static IProcessingResult warning(RString note) {
        return new SimpleProcessingResult(IProcessingResult.Type.WARNING, note);
    }

    /**
     * @param messageToNote 備考
     * @return {@link IProcessingResult.Type#WARNING}のインスタンス
     */
    public static IProcessingResult warning(OcrTorikomiMessages messageToNote) {
        return new SimpleProcessingResult(IProcessingResult.Type.WARNING, messageToNote.originalMessage());
    }

    private static final class SimpleProcessingResult implements IProcessingResult {

        private final IProcessingResult.Type theType;
        private final RString theNote;

        SimpleProcessingResult(IProcessingResult.Type theType, RString theNote) {
            this.theType = theType;
            this.theNote = theNote;
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
