/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ocr.resultlist;

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
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * OCR取込結果リストの編集を行います。
 */
public final class OcrTorikomiResultListEditor implements AutoCloseable {

    private static final RString FILE_NAME = new RString("取込結果リスト.csv");
    private static final RString DISPLAY_NAME_BASE = new RString("取込結果リスト");
    private static final RString DISPLAY_NAME_ERROR = new RString("<br>（エラーあり）");
    private static final RString DISPLAY_NAME_WARNING = new RString("<br>（警告あり）");
    private static final RString DISPLAY_NAME_SUCCESS = new RString("<br>（正常終了）");
    private static final RString DOUBLE_QUOTATION = new RString("\"");
    private static final RString COMMA = new RString(",");
    private static final RString EUC_ENTITY_ID = new RString("DBE250001");

    private final OcrTorikomiType torikomiType;
    private final FileSpoolManager spoolManager;
    private final RString filePath;
    private final CsvWriterWrapper csvWriter;
    private boolean hasClosed;
    private final Set<Type> torikomiKekkaTypes;

    /**
     * インスタンスを生成します。
     *
     * @param torikomiType 処理結果リスト出力対象となる取込処理の種類
     */
    public OcrTorikomiResultListEditor(OcrTorikomiType torikomiType) {
        this.torikomiType = torikomiType;
        this.spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        this.filePath = Path.combinePath(this.spoolManager.getEucOutputDirectry(), FILE_NAME);
        this.csvWriter = new CsvWriterWrapper(this.filePath);
        this.hasClosed = false;
        this.torikomiKekkaTypes = new HashSet<>();
    }

    /**
     * 指定の内容より、CSVファイルを書き込みます。 キー項目(OCRID, 帳票連番)で並び替え、内容が重複する行を削除した上で出力します。
     * そのため、同一キーの{@link OcrTorikomiResult}は、同時に引数へ指定されるべきです。
     *
     * @param o {@link OcrTorikomiResult 取込結果}の{@link Collection}
     */
    public void writeMultiLine(Collection<? extends OcrTorikomiResult> o) {
        if (hasClosed) {
            throw new IllegalStateException("すでにcloseされたインスタンスです。 要修正：close()メソッドのコール後にwriteLine()が呼ばれている箇所");
        }
        List<OcrTorikomiKekkaCsvEntity> list = new ArrayList<>();
        for (OcrTorikomiResult otr : o) {
            list.addAll(otr.toEntities());
        }
        writeLinesGroupingAndOrderByKey(list);
    }

    private void writeLinesGroupingAndOrderByKey(Collection<? extends OcrTorikomiKekkaCsvEntity> o) {
        Map<Key, Entities> map = groupingByKey(o);
        List<Key> keyList = new ArrayList(map.keySet());
        Collections.sort(keyList);
        for (Key key : keyList) {
            this.torikomiKekkaTypes.add(map.get(key).writeBy(this.csvWriter));
        }
    }

    private static Map<Key, Entities> groupingByKey(Collection<? extends OcrTorikomiKekkaCsvEntity> o) {
        Map<Key, Entities> map = new HashMap<>();
        for (OcrTorikomiKekkaCsvEntity entity : o) {
            Key key = new Key(entity);
            if (!map.containsKey(key)) {
                map.put(key, new Entities());
            }
            map.get(key).add(entity);
        }
        return map;
    }

    /**
     * 1行でも書込みを行った場合は、初期化時に指定された{@link FileSpoolManager}を用いて、CSVファイルをスプールします。
     */
    @Override
    public void close() {
        this.hasClosed = true;
        if (csvWriter == null) {
            return;
        }
        this.spoolManager.setDisplayName(composeDisplayName(this.torikomiType, this.torikomiKekkaTypes));
        Optional<AccessLogUUID> uuid = this.csvWriter.closeWithAccessLog();
        if (uuid.isPresent()) {
            this.spoolManager.spool(this.filePath, uuid.get());
        } else {
            this.spoolManager.spool(this.filePath);
        }
    }

    private static RString composeDisplayName(OcrTorikomiType type, Set<Type> types) {
        RStringBuilder builder = new RStringBuilder()
                .append(type.displayName())
                .append(RString.HALF_SPACE)
                .append(DISPLAY_NAME_BASE);
        if (types.contains(Type.ERROR)) {
            return builder.append(DISPLAY_NAME_ERROR).toRString();
        }
        if (types.contains(Type.WARNING)) {
            return builder.append(DISPLAY_NAME_WARNING).toRString();
        }
        if (types.contains(Type.SUCCESS)) {
            return builder.append(DISPLAY_NAME_SUCCESS).toRString();
        }
        return builder.toRString();
    }

    /**
     * このクラス専用のCsvWriterです。
     */
    private static class CsvWriterWrapper {

        private final CsvWriter<OcrTorikomiKekkaCsvEntity> writer;
        private final Set<PersonalData> personalData;

        private CsvWriterWrapper(RString filePath) {
            this.writer = new CsvWriter.InstanceBuilder(filePath)
                    .setEnclosure(DOUBLE_QUOTATION)
                    .setDelimiter(COMMA)
                    .setEncode(Encode.UTF_8withBOM)
                    .setNewLine(NewLine.CRLF)
                    .hasHeader(true)
                    .build();
            this.personalData = new HashSet<>();
        }

        private OcrTorikomiKekkaCsvEntity writeLine(OcrTorikomiKekkaCsvEntity entity) {
            this.writer.writeLine(entity);
            Optional<PersonalData> p = entity.toPersonalDataIfPossible();
            if (p.isPresent()) {
                this.personalData.add(p.get());
            }
            return entity;
        }

        private Optional<AccessLogUUID> closeWithAccessLog() {
            this.writer.close();
            if (this.personalData.isEmpty()) {
                return Optional.empty();
            }
            return Optional.of(AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, this.personalData));
        }
    }

    /**
     * OCR2000iの出力結果(CSV)の中で、1レコードを特定できる OCRID, SheetID のペアをあつかいます。
     *
     * 他のインスタンスと順序（OCRID 昇順＞SheetID 昇順)を比較可能です。
     */
    @lombok.Value
    private static final class Key implements Comparable<Key> {
        //<editor-fold defaultstate="collapsed" desc="implements...">

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
        //</editor-fold>
    }

    /**
     * OcrTorikomiKekkaCsvEntity のセットを持ちます。
     *
     * また、具体的なレコードの編集方法の定義を持ちます。
     */
    private static final class Entities {
        //<editor-fold defaultstate="collapsed" desc="implements...">

        private final Set<OcrTorikomiKekkaCsvEntity> elements;

        private Entities() {
            this.elements = new HashSet<>();
        }

        private boolean add(OcrTorikomiKekkaCsvEntity entity) {
            return this.elements.add(entity);
        }

        private Type writeBy(CsvWriterWrapper csvWriter) {
            if (elements.isEmpty()) {
                return null;
            }

            Map<Integer, List<OcrTorikomiKekkaCsvEntity>> map = groupingByKekkaCode(this.elements);
            if (map.containsKey(Type.ERROR.code())) {
                write(Type.ERROR, map, csvWriter);
                return Type.ERROR;
            }
            OcrTorikomiKekkaCsvEntity lastWritee = null;
            boolean hasWarning = false;
            if (map.containsKey(Type.WARNING.code())) {
                lastWritee = write(Type.WARNING, map, csvWriter);
                hasWarning = true;
            }
            writeSuccess(map, csvWriter, lastWritee);
            return hasWarning ? Type.WARNING : Type.SUCCESS;
        }

        private static Map<Integer, List<OcrTorikomiKekkaCsvEntity>>
                groupingByKekkaCode(Iterable<? extends OcrTorikomiKekkaCsvEntity> list) {
            Map<Integer, List<OcrTorikomiKekkaCsvEntity>> map = new HashMap<>();
            for (OcrTorikomiKekkaCsvEntity entity : list) {
                int kekkaCode = entity.getKekkaCode();
                if (!map.containsKey(kekkaCode)) {
                    map.put(kekkaCode, new ArrayList<OcrTorikomiKekkaCsvEntity>());
                }
                map.get(kekkaCode).add(entity);
            }
            return map;
        }

        private static OcrTorikomiKekkaCsvEntity write(Type type,
                Map<Integer, List<OcrTorikomiKekkaCsvEntity>> map, CsvWriterWrapper csvWriter) {
            return write(type.getName(), map.get(type.code()), csvWriter);
        }

        private static OcrTorikomiKekkaCsvEntity write(RString kekkaName,
                List<OcrTorikomiKekkaCsvEntity> entities, CsvWriterWrapper csvWriter) {
            OcrTorikomiKekkaCsvEntity last = null;
            for (OcrTorikomiKekkaCsvEntity entity : entities) {
                entity.set結果(kekkaName);
                last = csvWriter.writeLine(entity);
            }
            return last;
        }

        private static final RString INFO = new RString("情報");
        private static final RString SUCCESS = new RString("成功");
        private static final RString COMPLETE = new RString("正常終了");

        private static void writeSuccess(Map<Integer, List<OcrTorikomiKekkaCsvEntity>> map,
                CsvWriterWrapper csvWriter, OcrTorikomiKekkaCsvEntity lastWritee) {
            List<OcrTorikomiKekkaCsvEntity> list = map.get(Type.SUCCESS.code());
            OcrTorikomiKekkaCsvEntity entity = write(INFO, filteredBikoIsNotEmpty(list), csvWriter);
            boolean hasWarning = (lastWritee != null);
            OcrTorikomiKekkaCsvEntity base = entity != null ? entity : hasWarning ? lastWritee : list.get(0);
            int numOfWarning = hasWarning ? map.get(Type.WARNING.code()).size() : 0;
            csvWriter.writeLine(last(base, hasWarning, numOfWarning));
        }

        private static List<OcrTorikomiKekkaCsvEntity> filteredBikoIsNotEmpty(List<OcrTorikomiKekkaCsvEntity> entities) {
            if (entities == null) {
                return Collections.emptyList();
            }
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
        //</editor-fold>
    }
}
