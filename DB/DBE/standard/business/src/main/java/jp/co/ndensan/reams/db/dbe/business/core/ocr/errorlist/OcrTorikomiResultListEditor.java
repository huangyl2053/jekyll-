/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.OcrTorikomiKekkaCsvEntity;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.Comparators;

/**
 * OCR取込結果リストの編集を行います。
 */
public final class OcrTorikomiResultListEditor implements AutoCloseable {

    private static final Comparator<OcrTorikomiKekkaCsvEntity> OUTPUT_ORDER;

    static {
        OUTPUT_ORDER = new Comparators.MultiComparator<>(new Comparator<OcrTorikomiKekkaCsvEntity>() {
            @Override
            public int compare(OcrTorikomiKekkaCsvEntity o1, OcrTorikomiKekkaCsvEntity o2) {
                return o1.getOCRID().compareTo(o2.getOCRID());
            }
        }, new Comparator<OcrTorikomiKekkaCsvEntity>() {
            @Override
            public int compare(OcrTorikomiKekkaCsvEntity o1, OcrTorikomiKekkaCsvEntity o2) {
                return o1.getSheetID().compareTo(o2.getSheetID());
            }
        }, new Comparator<OcrTorikomiKekkaCsvEntity>() {
            @Override
            public int compare(OcrTorikomiKekkaCsvEntity o1, OcrTorikomiKekkaCsvEntity o2) {
                return Integer.compare(o1.getKekkaCode(), o2.getKekkaCode());
            }
        });
    }
    private static final RString FILE_NAME = new RString("ファイル名.csv"); //TODO ファイル名
    private static final RString DOUBLE_QUOTATION = new RString("\"");
    private static final RString COMMA = new RString(",");
    private static final RString EUC_ENTITY_ID = new RString("DBE250001");

    private final FileSpoolManager spoolManager;
    private final CsvWriter<OcrTorikomiKekkaCsvEntity> csvWriter;
    private final RString filePath;
    private boolean closes;

    public OcrTorikomiResultListEditor() {
        this.spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        this.closes = false;
        this.filePath = Path.combinePath(this.spoolManager.getEucOutputDirectry(), FILE_NAME);
        this.csvWriter = initCsvWriter(this.filePath);
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

    /**
     * 指定の内容より、CSVの1行を書き込みます。
     *
     * インスタンスを生成してから、一度もこのメソッドを呼ばなかった場合、
     * 同一インスタンスの{@link #close()}を呼び出しても、CSVファイルは出力されません。
     *
     * @param o {@link OcrTorikomiResult 取込結果}
     */
    public void writeLine(OcrTorikomiResult o) {
        checkState();
        writeLineInOrder(o.toEntities());
    }

    private void checkState() throws IllegalStateException {
        if (closes) {
            throw new IllegalStateException("すでにcloseされたインスタンスです。 要修正：close()メソッドのコール後にwriteLine()が呼ばれている箇所");
        }
    }

    private void writeLineInOrder(Collection<? extends OcrTorikomiKekkaCsvEntity> o) {
        List<OcrTorikomiKekkaCsvEntity> list = new ArrayList<>(o);
        Collections.sort(list, OUTPUT_ORDER);
        for (OcrTorikomiKekkaCsvEntity entity : list) {
            this.csvWriter.writeLine(entity);
        }
    }

    public void writeMultiLine(Collection<? extends OcrTorikomiResult> o) {
        checkState();
        Set<OcrTorikomiKekkaCsvEntity> set = new HashSet<>();
        for (OcrTorikomiResult otr : o) {
            set.addAll(otr.toEntities());
        }
        writeLineInOrder(set);
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
