/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult.Type;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.OcrTorikomiKekkaCsvEntity;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * OCR取込結果リストの編集を行います。
 */
public final class OcrTorikomiResultListEditor implements AutoCloseable {

    private static final RString FILE_NAME = new RString("ファイル名.csv"); //TODO ファイル名
    private static final RString DOUBLE_QUOTATION = new RString("\"");
    private static final RString COMMA = new RString(",");
    private static final RString EUC_ENTITY_ID = new RString("DBE250001");

    private final FileSpoolManager spoolManager;
    private final CsvWriter<OcrTorikomiKekkaCsvEntity> csvWriter;
    private final RString filePath;
    private boolean closes;

    /**
     * インスタンスを生成します。
     */
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
     * 指定の内容より、CSVファイルを書き込みます。 キー項目(OCRID, 帳票連番)で並び替え、内容が重複する行を削除した上で出力します。
     * そのため、同一キーの{@link OcrTorikomiResult}は、同時に引数へ指定されるべきです。
     *
     * @param o {@link OcrTorikomiResult 取込結果}の{@link Collection}
     */
    public void writeMultiLine(Collection<? extends OcrTorikomiResult> o) {
        checkState();
        List<OcrTorikomiKekkaCsvEntity> list = new ArrayList<>();
        for (OcrTorikomiResult otr : o) {
            list.addAll(otr.toEntities());
        }
        writeLineInOrder(list);
    }

    private void checkState() throws IllegalStateException {
        if (closes) {
            throw new IllegalStateException("すでにcloseされたインスタンスです。 要修正：close()メソッドのコール後にwriteLine()が呼ばれている箇所");
        }
    }

    @lombok.Value
    private static class Key implements Comparable<Key> {

        private final RString ocrID;
        private final RString sheetID;

        private Key(OcrTorikomiKekkaCsvEntity entity) {
            this.ocrID = entity.getOCRID();
            this.sheetID = entity.getSheetID();
        }

        @Override
        public int compareTo(Key o) {
            int r = this.ocrID.compareTo(o.ocrID);
            return r != 0 ? r : this.sheetID.compareTo(o.sheetID);
        }
    }

    private void writeLineInOrder(Collection<? extends OcrTorikomiKekkaCsvEntity> o) {
        Map<Key, Entities> map = new HashMap<>();
        for (OcrTorikomiKekkaCsvEntity entity : o) {
            Key key = new Key(entity);
            if (!map.containsKey(key)) {
                map.put(key, new Entities());
            }
            map.get(key).add(entity);
        }
        List<Key> keyList = new ArrayList(map.keySet());
        Collections.sort(keyList);
        for (Key key : keyList) {
            map.get(key).writeBy(this.csvWriter);
        }
    }

    private static class Entities {

        private final Set<OcrTorikomiKekkaCsvEntity> elements;

        private Entities() {
            this.elements = new HashSet<>();
        }

        private boolean add(OcrTorikomiKekkaCsvEntity entity) {
            return this.elements.add(entity);
        }

        private void writeBy(CsvWriter<OcrTorikomiKekkaCsvEntity> csvWriter) {
            if (elements.isEmpty()) {
                return;
            }

            Map<Integer, List<OcrTorikomiKekkaCsvEntity>> map = groupingByKekkaCode(this.elements);
            if (map.containsKey(Type.ERROR.code())) {
                write(Type.ERROR, map, csvWriter);
                return;
            }
            OcrTorikomiKekkaCsvEntity lastWritee = null;
            if (map.containsKey(Type.WARNING.code())) {
                lastWritee = write(Type.WARNING, map, csvWriter);
            }
            writeSuccess(map, csvWriter, lastWritee);
        }

        private static Map<Integer, List<OcrTorikomiKekkaCsvEntity>>
                groupingByKekkaCode(Iterable<? extends OcrTorikomiKekkaCsvEntity> list) {
            Map<Integer, List<OcrTorikomiKekkaCsvEntity>> map = new HashMap<>();
            for (OcrTorikomiKekkaCsvEntity entity : list) {
                int kekkaCode = entity.getKekkaCode();
                if (map.containsKey(kekkaCode)) {
                    map.put(kekkaCode, new ArrayList<OcrTorikomiKekkaCsvEntity>());
                }
                map.get(kekkaCode).add(entity);
            }
            return map;
        }

        private static OcrTorikomiKekkaCsvEntity write(Type type,
                Map<Integer, List<OcrTorikomiKekkaCsvEntity>> map, CsvWriter<OcrTorikomiKekkaCsvEntity> csvWriter) {
            return write(type.getName(), map.get(type.code()), csvWriter);
        }

        private static OcrTorikomiKekkaCsvEntity write(RString kekkaName,
                List<OcrTorikomiKekkaCsvEntity> entities, CsvWriter<OcrTorikomiKekkaCsvEntity> csvWriter) {
            OcrTorikomiKekkaCsvEntity last = null;
            for (OcrTorikomiKekkaCsvEntity entity : entities) {
                entity.set結果(kekkaName);
                csvWriter.writeLine(entity);
                last = entity;
            }
            return last;
        }

        private static final RString INFO = new RString("情報");
        private static final RString SUCCESS = new RString("成功");
        private static final RString COMPLETE = new RString("正常終了");

        private static void writeSuccess(Map<Integer, List<OcrTorikomiKekkaCsvEntity>> map,
                CsvWriter<OcrTorikomiKekkaCsvEntity> csvWriter, OcrTorikomiKekkaCsvEntity lastWritee) {
            List<OcrTorikomiKekkaCsvEntity> list = map.get(Type.SUCCESS.code());
            OcrTorikomiKekkaCsvEntity entity = write(INFO, filteredBikoIsNotEmpty(list), csvWriter);
            boolean hasWarning = (lastWritee != null);
            OcrTorikomiKekkaCsvEntity base = entity != null ? entity : hasWarning ? lastWritee : list.get(0);
            int numOfWarning = hasWarning ? map.get(Type.WARNING.code()).size() : 0;
            csvWriter.writeLine(last(base, hasWarning, numOfWarning));
        }

        private static List<OcrTorikomiKekkaCsvEntity> filteredBikoIsNotEmpty(List<OcrTorikomiKekkaCsvEntity> entities) {
            List<OcrTorikomiKekkaCsvEntity> list = new ArrayList<>();
            for (OcrTorikomiKekkaCsvEntity entity : entities) {
                if (!RString.isNullOrEmpty(entity.get備考())) {
                    list.add(entity);
                }
            }
            return list;
        }

        private static OcrTorikomiKekkaCsvEntity last(OcrTorikomiKekkaCsvEntity base, boolean hasWarning, int numOfWarning) {
            OcrTorikomiKekkaCsvEntity entity = new OcrTorikomiKekkaCsvEntity();
            entity.shallowCopy(base);
            entity.set結果(hasWarning ? SUCCESS : COMPLETE);
            entity.set備考(hasWarning ? OcrTorikomiMessages.警告あり.replaced(Integer.toString(numOfWarning)) : RString.EMPTY);
            return entity;
        }
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
