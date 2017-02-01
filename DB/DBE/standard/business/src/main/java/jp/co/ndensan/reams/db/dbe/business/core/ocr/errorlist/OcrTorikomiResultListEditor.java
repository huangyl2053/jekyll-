/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist;

import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.OcrTorikomiKekkaCsvEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;

/**
 * OCR取込結果リストの編集を行います。
 */
public final class OcrTorikomiResultListEditor implements AutoCloseable {

    private static final RString FILE_NAME = new RString("ファイル名.csv"); //TODO ファイル名
    private static final RString DOUBLE_QUOTATION = new RString("\"");
    private static final RString COMMA = new RString(",");

    private final FileSpoolManager spoolManager;
    private CsvWriter<OcrTorikomiKekkaCsvEntity> csvWriter;
    private RString filePath;
    private boolean closes;

    private OcrTorikomiResultListEditor(FileSpoolManager spoolManager) {
        this.spoolManager = spoolManager;
        this.closes = false;
    }

    /**
     * @param spoolManager 作成したCSVファイルをスプールする際に用いる{@link FileSpoolManager}
     * @return {@link OcrTorikomiResultListEditor}
     */
    public static OcrTorikomiResultListEditor spoolBy(FileSpoolManager spoolManager) {
        return new OcrTorikomiResultListEditor(spoolManager);
    }

    /**
     * 指定の内容より、CSVの1行を書き込みます。
     *
     * インスタンスを生成してから、一度もこのメソッドを呼ばなかった場合、
     * 同一インスタンスの{@link #close()}を呼び出しても、CSVファイルは出力されません。
     *
     * @param o {@link OcrTorikomiResult 取込結果}
     */
    public void writeLine(OcrTorikomiResult o) {
        if (closes) {
            throw new IllegalStateException("すでにcloseされたインスタンスです。 要修正：close()メソッドのコール後にwriteLine()が呼ばれている箇所");
        }
        if (this.csvWriter == null) {
            this.filePath = composeFilePath();
            this.csvWriter = initCsvWriter(filePath);
        }
        this.csvWriter.writeLine(o.toEntity());
    }

    private static CsvWriter<OcrTorikomiKekkaCsvEntity> initCsvWriter(RString filePath) {
        return new CsvWriter.InstanceBuilder(filePath)
                .setEnclosure(DOUBLE_QUOTATION)
                .setDelimiter(COMMA)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    private RString composeFilePath() {
        return Path.combinePath(this.spoolManager.getEucOutputDirectry(), FILE_NAME);
    }

    /**
     * 1行でも書込みを行った場合は、初期化時に指定された{@link FileSpoolManager}を用いて、CSVファイルをスプールします。
     */
    @Override
    public void close() {
        this.closes = true;
        if (csvWriter == null) {
            return;
        }
        this.csvWriter.close();
        this.spoolManager.spool(this.filePath); //TODO アクセスログ
    }
}
