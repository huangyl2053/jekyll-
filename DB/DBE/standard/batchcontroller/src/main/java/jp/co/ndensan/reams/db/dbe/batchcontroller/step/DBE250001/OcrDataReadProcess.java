/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosakekkatorikomiocr.NinteiOcrRelate;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.Filterd;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import static jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages.toSlashSeparatedSeireki;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.Catalog;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.CatalogLine;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.INinteiChosahyoChosaItemAccessor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.INinteiChosahyoServiceJokyoAccessor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.INinteiChosahyoServiceJokyoFlagAccessor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.INinteiChosahyoShisetsuRiyoAccessor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.NinteiChosahyoChosaItemAccessorFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.NinteiChosahyoServiceJokyoAccessorFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.NinteiChosahyoServiceJokyoFlagAccessorFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.NinteiChosahyoShisetsuRiyoAccessorFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrChosa;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrChosas;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrChosasByOCRID;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrNinteichosahyoGakyoChosaEditor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrTokkiJikoColumn;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrTokkiJikoColumns;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.TokkijikoFileNameConvertionTheory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.resultlist.OcrTorikomiResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.resultlist.OcrTorikomiResultListEditor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.resultlist.OcrTorikomiResultsFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.FileNameConvertionTheories;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.GaikyoChosahyoServiceJokyos;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.IGaikyoChosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyoShisetuRiyos;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.IGaikyoChosahyoShisetuRiyo;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.KomokuNo;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.Models;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenTokkiRembanChofuku;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.ChosahyoOcrContextParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.TempOcrCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaContextEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosahyoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosakekkatorikomiocr.INinteiOcrMapper;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ocr.IOcrCsvMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosakekkatorikomiocr.NinteiOcrFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.ImageJohoUpdater;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag.IServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag.ServiceJokyoFlags;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.INinteichosaKomokuMapping;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMappings;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * OCR情報受入＿バッチプロセスクラスです。
 *
 * @author n8429
 */
public class OcrDataReadProcess extends BatchProcessBase<TempOcrCsvEntity> {

    @BatchWriter
    private BatchPermanentTableWriter<DbT5202NinteichosahyoGaikyoChosaEntity> writerGaikyo;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5203NinteichosahyoKihonChosaEntity> writerKihon;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5205NinteichosahyoTokkijikoEntity> writerTokki;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5207NinteichosahyoServiceJokyoEntity> writerService;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5208NinteichosahyoServiceJokyoFlagEntity> writerServiceFlag;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5210NinteichosahyoShisetsuRiyoEntity> writerShisetsu;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5211NinteichosahyoChosaItemEntity> writerItem;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writerImage;
    private OcrTorikomiResultListEditor kekkaListEditor;

    /**
     * このバッチプロセスのパラメータです。
     */
    private OcrDataReadProcessParameter processParameter;
    private List<OcrChosa> cache;
    private ShinseiKey key;
    private Catalog catalog;

    @Override
    protected void initialize() {
        super.initialize();
        this.catalog = new Catalog(this.processParameter.getCatalogFilePath());
        if (!this.catalog.exists()) {
            throw new BatchInterruptedException("カタログファイルがアップロードされていません。");
        }
    }

    @Override
    public void cancel() {
        super.cancel();
        this.kekkaListEditor = new OcrTorikomiResultListEditor();
        OcrTorikomiResult r = new OcrTorikomiResult.Builder(ShinseiKey.EMPTY)
                .set処理結果(ProcessingResultFactory.error(OcrTorikomiMessages.カタログファイルなし.replaced("OCRCHOSA.ca3"))).build();
        this.kekkaListEditor.writeMultiLine(Collections.singletonList(r));
        this.kekkaListEditor.close();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(
                new RStringBuilder().append(IOcrCsvMapper.class.getName()).append(".findCsvDataOrderByKey").toRString(),
                this.processParameter.toOcrCsvMapperParameter()
        );
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        this.cache = new ArrayList<>();
        this.key = ShinseiKey.EMPTY;
    }

    @Override
    protected void createWriter() {
        writerGaikyo = new BatchPermanentTableWriter<>(DbT5202NinteichosahyoGaikyoChosaEntity.class);
        writerKihon = new BatchPermanentTableWriter<>(DbT5203NinteichosahyoKihonChosaEntity.class);
        writerTokki = new BatchPermanentTableWriter<>(DbT5205NinteichosahyoTokkijikoEntity.class);
        writerService = new BatchPermanentTableWriter<>(DbT5207NinteichosahyoServiceJokyoEntity.class);
        writerServiceFlag = new BatchPermanentTableWriter<>(DbT5208NinteichosahyoServiceJokyoFlagEntity.class);
        writerShisetsu = new BatchPermanentTableWriter<>(DbT5210NinteichosahyoShisetsuRiyoEntity.class);
        writerItem = new BatchPermanentTableWriter<>(DbT5211NinteichosahyoChosaItemEntity.class);
        writerImage = new BatchPermanentTableWriter<>(DbT5115ImageEntity.class);
        kekkaListEditor = new OcrTorikomiResultListEditor();
    }

    @Override
    protected void process(TempOcrCsvEntity entity) {
        final OcrChosa ocrChosa = OcrChosa.parsed(entity.getCsvData(), entity.getLineNum());
        if (hasBreak(this.key, ocrChosa.getKey())) {
            if (!Objects.equals(ShinseiKey.EMPTY, key)) {
                keyBreakProcess(this.key, this.cache);
            }
            this.cache = new ArrayList<>();
            this.key = ocrChosa.getKey();
        }
        this.cache.add(ocrChosa);
    }

    private static boolean hasBreak(ShinseiKey before, ShinseiKey current) {
        return !Objects.equals(before, current);
    }

    @Override
    protected void afterExecute() {
        super.afterExecute();
        keyBreakProcess(this.key, this.cache);
        this.kekkaListEditor.close();
    }

    private void keyBreakProcess(ShinseiKey key, List<OcrChosa> ocrChosas) {
        List<OcrTorikomiResult> list = new ArrayList<>();
        Filterd<OcrChosas> filterdFileNormal = new OcrChosas(ocrChosas).filterdNormal();
        list.addAll(makeErrorsForFileBroken(filterdFileNormal.rejected(), key));

        OcrChosasByOCRID groupedByOCRID = filterdFileNormal.passed().groupingByOCRID();
        OcrChosasByOCRID filteredSizeIsOne = groupedByOCRID.filterdSizeIs(1);
        Set<OCRID> passed = new HashSet<>();
        passed.add(OCRID._550);
        passed.addAll(filteredSizeIsOne.keySet());
        list.addAll(havingTooManyLinesToOperate(groupedByOCRID.removed(passed), this.key));
        list.addAll(otherOperation(groupedByOCRID.getAll(passed), this.key));
        this.kekkaListEditor.writeMultiLine(list);
    }

    private List<OcrTorikomiResult> otherOperation(OcrChosasByOCRID ocrChosas, ShinseiKey key) {
        NinteiOcrMapperParamter paramter = toParameterToSearchRelatedData(key);
        NinteiOcrFinder finder = NinteiOcrFinder.createInstance();
        List<NinteiOcrRelate> relatedData = finder.get関連データ(paramter).records();
        if (relatedData.isEmpty()) {
            return makeErrorsForRelatedDataNotFound(ocrChosas, key);
        }

        NinteiOcrRelate nr = relatedData.get(0);
        NinteiOcrRelate.Context context = new NinteiOcrRelate.Context(ocrChosas.values().toList(),
                this.processParameter.get一次判定済み時処理方法());
        IProcessingResults nrValidated = nr.validate(context);
        if (nrValidated.hasError()) {
            return makeErrorsInRelatedData(key, nrValidated, nr);
        }
        ProcessingResults results = new ProcessingResults();
        results.addAll(nrValidated); //警告があれば追加される。
        NinteiChosahyoEntity chosaKekka = search認定調査結果By(finder, paramter);
        results.addAll(saveImageFilesAndUpdateTables(ocrChosas, chosaKekka, nr));
        for (OcrChosa o : ocrChosas.values()) {
            results.addSuccessIfNotContains(o);
        }
        return OcrTorikomiResultsFactory.create(key, results, nr);
    }

    @lombok.Getter
    @lombok.AllArgsConstructor
    private static class SaveImageFilesResult {

        private final RDateTime sharedFileID;
        private final IProcessingResults processingResults;

    }

    private IProcessingResults saveImageFilesAndUpdateTables(OcrChosasByOCRID ocrChosas, NinteiChosahyoEntity entity, NinteiOcrRelate nr) {
        ProcessingResults results = new ProcessingResults();
        RDateTime sharedFileID = nr.getImageSharedFileIDOrNull();
        for (OcrChosasByOCRID.Entry entry : ocrChosas.entrySet()) {
            switch (entry.getOCRID()) {
                case _501: {
                    SaveImageFilesResult result_501 = saveImageFilesAndUpdateTables501(entry.getOcrChosas(), entity, nr, sharedFileID);
                    sharedFileID = result_501.getSharedFileID();
                    results.addAll(result_501.getProcessingResults());
                }
                continue;
                case _502: {
                    SaveImageFilesResult result_502 = saveImageFilesAndUpdateTables502(entry.getOcrChosas(), entity, nr, sharedFileID);
                    sharedFileID = result_502.getSharedFileID();
                    results.addAll(result_502.getProcessingResults());
                }
                continue;
                case _550: {
                    SaveImageFilesResult result_550 = saveImageFilesAndUpdateTables550(entry.getOcrChosas(), entity, nr, sharedFileID);
                    results.addAll(result_550.getProcessingResults());
                }
                continue;
                case _570: {
                    //TODO ID570を利用するユーザに導入する直前には実装が必要。
                }
                default:
            }
        }
        return results;
    }

    //<editor-fold defaultstate="collapsed" desc="ID501">
    private SaveImageFilesResult saveImageFilesAndUpdateTables501(OcrChosas ocrChosas, NinteiChosahyoEntity entity, NinteiOcrRelate nr, RDateTime sharedFileID) {
        if (ocrChosas.isEmpty()) {
            return new SaveImageFilesResult(sharedFileID, ProcessingResults.EMPTY);
        }

        SaveImageFilesResult copyImageResult = copyImageFilesToDirectory_ID501(ocrChosas, nr, sharedFileID);
        ProcessingResults prs = new ProcessingResults(copyImageResult.getProcessingResults());
        if (prs.hasError()) {
            return new SaveImageFilesResult(copyImageResult.getSharedFileID(), prs);
        }

        prs.addAll(insertOrUpdate概況調査By(writerGaikyo, entity, nr, ocrChosas,
                getMapper(INinteiOcrMapper.class
                ), this.processParameter));
        if (!prs.hasError()) {
            insertOrUpdateサービスの状況By(writerService, entity, nr, ocrChosas);
            insertOrUpdateサービスの状況フラグBy(writerServiceFlag, entity, nr, ocrChosas);
            insertOrUpdate施設利用By(writerShisetsu, entity, nr, ocrChosas);
        }
        return new SaveImageFilesResult(copyImageResult.getSharedFileID(), prs);
    }

    private SaveImageFilesResult copyImageFilesToDirectory_ID501(OcrChosas ocrChosas, NinteiOcrRelate nr, RDateTime sharedFileID) {
        OcrChosa ocrChosa = ocrChosas.toList().get(0);
        CatalogLine ca3 = this.catalog.find(Models.ID501, ocrChosa.getSheetID()).orElse(null);
        if (ca3 == null) {
            ProcessingResults results = new ProcessingResults();
            results.add(ProcessingResultFactory.error(ocrChosa, OcrTorikomiMessages.カタログデータなし));
            return new SaveImageFilesResult(sharedFileID, results);
        }
        ImageJohoUpdater.Result result = ImageJohoUpdater.shinseiKey(nr.getShinseishoKanriNo(), nr.get証記載保険者番号(), nr.get被保険者番号())
                .sharedFileID(sharedFileID)
                .imageFilePaths(this.processParameter.getImageFilePaths())
                .fileNameTheory(FileNameConvertionTheories.ID501)
                .targetImageFileNames(ca3.getImageFileNames())
                .ocrData(ocrChosa)
                .save(this.writerImage);
        return new SaveImageFilesResult(result.getSharedFileID(), result.getProcessingResults());
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ID502">
    private SaveImageFilesResult saveImageFilesAndUpdateTables502(OcrChosas ocrChosas, NinteiChosahyoEntity entity, NinteiOcrRelate nr, RDateTime sharedFileID) {
        if (ocrChosas.isEmpty()) {
            return new SaveImageFilesResult(sharedFileID, ProcessingResults.EMPTY);
        }
        insertOrUpdate基本調査By(writerKihon, entity, nr, ocrChosas);
        insertOrUpdate調査項目By(writerItem, entity, nr, ocrChosas);
        return new SaveImageFilesResult(sharedFileID, ProcessingResults.EMPTY);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="ID550">
    private SaveImageFilesResult saveImageFilesAndUpdateTables550(OcrChosas ocrChosas, NinteiChosahyoEntity entity, NinteiOcrRelate nr, RDateTime sharedFileID) {
        if (ocrChosas.isEmpty()) {
            return new SaveImageFilesResult(sharedFileID, ProcessingResults.EMPTY);
        }
        ProcessingResults results = new ProcessingResults();
        OcrTokkiJikoColumns newTokkiJikos = ocrChosas.editedFileNames連番再付番();
        results.addAll(renumbered(newTokkiJikos, ocrChosas));
        OcrTokkiJikoColumns duplicates = findDuplicateKomokuNos(entity.get特記情報(), newTokkiJikos);
        TreatmentWhenTokkiRembanChofuku treatment = this.processParameter.get特記連番重複時処理方法();
        results.addAll(rembanChofuku(duplicates, treatment, ocrChosas));
        OcrTokkiJikoColumns updatingTokkiJikos = (treatment == TreatmentWhenTokkiRembanChofuku.上書きする)
                ? newTokkiJikos
                : newTokkiJikos.removedSameKomokuNo(duplicates);

        SaveImageFilesResult saveImageResult = copyImageFilesToDirectory_ID550(ocrChosas, nr, sharedFileID, updatingTokkiJikos);
        IProcessingResults prs = saveImageResult.getProcessingResults();
        results.addAll(prs);
        insertOrUpdate特記情報By(this.writerTokki, entity, nr, updatingTokkiJikos.removed(prs.allOcrDataInError()));
        return new SaveImageFilesResult(saveImageResult.getSharedFileID(), results);
    }

    private static OcrTokkiJikoColumns findDuplicateKomokuNos(Iterable<? extends DbT5205NinteichosahyoTokkijikoEntity> tokkiJikos, OcrTokkiJikoColumns newTokkiJikos) {
        List<KomokuNo> komokuNos = new ArrayList<>();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : tokkiJikos) {
            komokuNos.add(new KomokuNo(entity.getNinteichosaTokkijikoNo(), entity.getNinteichosaTokkijikoRemban()));
        }
        return newTokkiJikos.filterdByKomokuNo(komokuNos);
    }

    private static IProcessingResults renumbered(OcrTokkiJikoColumns columns, OcrChosas _550) {
        ProcessingResults prs = new ProcessingResults();
        if (columns.isEmpty()) {
            return prs;
        }
        Map<SheetID, RStringBuilder> map = new HashMap<>();
        List<OcrTokkiJikoColumn> sorted = columns.toList();
        Collections.sort(sorted, OcrTokkiJikoColumn.Comparators.OrderByKomokuNo);
        for (OcrTokkiJikoColumn column : sorted) {
            KomokuNo komokuNo = column.komokuNo();
            if (!komokuNo.hasRenumberd()) {
                continue;
            }
            SheetID sheetID = column.sheetID();
            if (!map.containsKey(sheetID)) {
                map.put(sheetID, new RStringBuilder());
            }
            map.get(sheetID).append(komokuNo.beforeToRString()).append("→").append(komokuNo).append(RString.HALF_SPACE);
        }
        for (Map.Entry<SheetID, RStringBuilder> entry : map.entrySet()) {
            OcrChosa ocrChosa = _550.findBySheetID(entry.getKey()).orElse(null);
            if (ocrChosa == null) {
                continue;
            }
            prs.add(ProcessingResultFactory.warning(ocrChosa,
                    OcrTorikomiMessages.特記事項_連番再付番.replaced(entry.getValue().toString())));
        }
        return prs;
    }

    private static IProcessingResults rembanChofuku(OcrTokkiJikoColumns duplicates, TreatmentWhenTokkiRembanChofuku treatment, OcrChosas _550) {
        ProcessingResults prs = new ProcessingResults();
        if (duplicates.isEmpty()) {
            return prs;
        }
        Map<SheetID, RStringBuilder> map = new HashMap<>();
        List<OcrTokkiJikoColumn> columns = duplicates.toList();
        Collections.sort(columns, OcrTokkiJikoColumn.Comparators.OrderByKomokuNo);
        for (OcrTokkiJikoColumn column : columns) {
            SheetID sheetID = column.sheetID();
            if (!map.containsKey(sheetID)) {
                map.put(sheetID, new RStringBuilder());
            }
            map.get(sheetID).append(column.komokuNo()).append(RString.HALF_SPACE);
        }
        for (Map.Entry<SheetID, RStringBuilder> entry : map.entrySet()) {
            OcrChosa ocrChosa = _550.findBySheetID(entry.getKey()).orElse(null);
            if (ocrChosa == null) {
                continue;
            }
            switch (treatment) {
                case 上書きする:
                    prs.add(ProcessingResultFactory.warning(ocrChosa,
                            OcrTorikomiMessages.特記事項_連番重複_上書き.replaced(entry.getValue().toString())));
                    break;
                case 上書きしない:
                    prs.add(ProcessingResultFactory.warning(ocrChosa,
                            OcrTorikomiMessages.特記事項_連番重複_更新取りやめ.replaced(entry.getValue().toString())));
                default:
            }
        }
        return prs;
    }

    private SaveImageFilesResult copyImageFilesToDirectory_ID550(OcrChosas ocrChosas, NinteiOcrRelate nr, RDateTime sharedFileID, OcrTokkiJikoColumns tokkiImageFiles) {
        final ProcessingResults results = new ProcessingResults();
        final TokkijikoFileNameConvertionTheory theory = new TokkijikoFileNameConvertionTheory(tokkiImageFiles);
        RDateTime 共有ファイルID = sharedFileID;
        for (OcrChosa ocrChosa : ocrChosas) {
            SheetID sheetID = ocrChosa.getSheetID();
            Optional<CatalogLine> ca3 = this.catalog.find(Models.ID550, sheetID);
            OcrTokkiJikoColumns columns = tokkiImageFiles.filteredBySheetID(sheetID);
            boolean needsImageFile = !columns.removedEmptyKomokuNo().isEmpty();
            if (needsImageFile) {
                if (!ca3.isPresent()) {
                    results.add(ProcessingResultFactory.error(ocrChosa, OcrTorikomiMessages.カタログデータなし));
                    continue;
                }
            } else {
                continue;
            }
            List<RString> imageNames = columns.filterImageFileNamesByColumnNo(ca3.get().getImageFileNames());
            if (imageNames.isEmpty()) {
                continue;
            }
            ImageJohoUpdater.Result result = ImageJohoUpdater.shinseiKey(nr.getShinseishoKanriNo(), nr.get証記載保険者番号(), nr.get被保険者番号())
                    .sharedFileID(共有ファイルID)
                    .imageFilePaths(this.processParameter.getImageFilePaths())
                    .fileNameTheory(theory)
                    .targetImageFileNames(imageNames)
                    .ocrData(ocrChosa)
                    .save(this.writerImage);
            共有ファイルID = result.getSharedFileID();
            results.addAll(result.getProcessingResults());
        }
        return new SaveImageFilesResult(共有ファイルID, results);
    }
    //</editor-fold>

//--  共通処理  ---------------------------------------------------------------------------------------------------------------------------
    private static NinteiChosahyoEntity search認定調査結果By(NinteiOcrFinder finder, NinteiOcrMapperParamter parameter) {
        List<NinteiChosahyoEntity> entities = finder.get認定調査票(parameter);
        if (entities.isEmpty()) {
            return new NinteiChosahyoEntity();
        }
        return entities.get(0);
    }

    private static NinteiOcrMapperParamter toParameterToSearchRelatedData(ShinseiKey key) {
        return NinteiOcrMapperParamter.createParamter(key.get証記載保険者番号(), key.get被保険者番号(), key.get認定申請日());
    }

    //<editor-fold defaultstate="collapsed" desc="処理結果の作成">
    private static List<OcrTorikomiResult> makeErrorsForFileBroken(OcrChosas ocrChosas, ShinseiKey key) {
        ProcessingResults results = new ProcessingResults();
        for (OcrChosa o : ocrChosas) {
            results.add(ProcessingResultFactory.error(o, OcrTorikomiMessages.フォーマット不正.replaced(
                    Integer.toString(o.getLineNum()),
                    OcrTorikomiMessages.cutToLength(20, o.getデータ行_文字列(), OcrTorikomiMessages.RYAKU).toString()
            )));
        }
        return OcrTorikomiResultsFactory.create(key, results);
    }

    private static List<OcrTorikomiResult> havingTooManyLinesToOperate(OcrChosasByOCRID ocrChosas, ShinseiKey key) {
        return OcrTorikomiResultsFactory.create(key, ocrChosas.values(),
                IProcessingResult.Type.ERROR, OcrTorikomiMessages.同一申請複数存在.replaced("OCRCHOSA.CSV"));
    }

    private static List<OcrTorikomiResult> makeErrorsInRelatedData(ShinseiKey key, IProcessingResults nrValidated, NinteiOcrRelate nr) {
        return OcrTorikomiResultsFactory.create(key, nrValidated, nr);
    }

    private static List<OcrTorikomiResult> makeErrorsForRelatedDataNotFound(OcrChosasByOCRID ocrChosas, ShinseiKey key) {
        return OcrTorikomiResultsFactory.create(key, ocrChosas.values(),
                IProcessingResult.Type.ERROR, OcrTorikomiMessages.有効な要介護認定申請なし);
    }
    //</editor-fold>

//--  DBの更新  -----------------------------------------------------------------
    //<editor-fold defaultstate="collapsed" desc="概況調査">
    private static IProcessingResults insertOrUpdate概況調査By(IBatchTableWriter<? super DbT5202NinteichosahyoGaikyoChosaEntity> dbWriter,
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrChosas ocrChosas, INinteiOcrMapper mapper,
            OcrDataReadProcessParameter batchParam) {
        if (ocrChosas.size() != 1) {
            return ProcessingResults.EMPTY;
        }
        OcrChosa ocrChosa = ocrChosas.findFirst().get();
        DbT5202NinteichosahyoGaikyoChosaEntity entity = createOrEdit概況調査(ninteiChosaEntity, nr, ocrChosa);
        IProcessingResults results = validateDbT5202(entity, nr, ocrChosa, mapper, batchParam);
        if (results.hasError()) {
            return results;
        }
        switch (entity.getState()) {
            case Added:
                dbWriter.insert(entity);
                break;
            case Modified:
                dbWriter.update(entity);
                break;
            default:
        }
        return results;
    }

    private static DbT5202NinteichosahyoGaikyoChosaEntity createOrEdit概況調査(
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrChosa ocrChosa) {
        DbT5202NinteichosahyoGaikyoChosaEntity entity = ninteiChosaEntity.get概況調査().isEmpty()
                ? newDbT5202NinteichosahyoGaikyoChosaEntity(nr)
                : ninteiChosaEntity.get概況調査().get(0);
        OcrNinteichosahyoGakyoChosaEditor.edit(entity, ocrChosa);
        return entity;
    }

    private static DbT5202NinteichosahyoGaikyoChosaEntity newDbT5202NinteichosahyoGaikyoChosaEntity(NinteiOcrRelate nr) {
        DbT5202NinteichosahyoGaikyoChosaEntity entity = new DbT5202NinteichosahyoGaikyoChosaEntity();
        entity.setShinseishoKanriNo(nr.getShinseishoKanriNo());
        entity.setNinteichosaRirekiNo(nr.get認定調査依頼履歴番号());
        entity.setGaikyoChosaTextImageKubun(TokkijikoTextImageKubun.イメージ.getコード());
        entity.setKoroshoIfShikibetsuCode(nr.get厚労省IF識別コード().asCode());
        entity.setNinteichousaIraiKubunCode(nr.get認定調査依頼区分コード());
        entity.setNinteichosaIraiKaisu(nr.get認定調査回数());
        entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
        entity.setNinteiChosaKubunCode(ChosaKubun.新規調査.asCode());
        return entity;
    }

    private static IProcessingResults validateDbT5202(DbT5202NinteichosahyoGaikyoChosaEntity entity,
            NinteiOcrRelate nr, OcrChosa ocrChosa, INinteiOcrMapper mapper, OcrDataReadProcessParameter batchParam) {

        ChosahyoOcrContextParameter param = new ChosahyoOcrContextParameter(nr.get申請書管理番号(),
                ocrChosa.get所属機関(), ocrChosa.get記入者());
        NinteiChosaContextEntity context = mapper.getNinteiChosaContext(param);

        if (!nr.get調査依頼日().isBeforeOrEquals(entity.getNinteichosaJisshiYMD())) {
            return new ProcessingResults(
                    ProcessingResultFactory.error(ocrChosa, OcrTorikomiMessages.調査実施日が依頼日より前.
                            replaced(toSlashSeparatedSeireki(nr.get調査依頼日()),
                                    toSlashSeparatedSeireki(entity.getNinteichosaJisshiYMD())
                            )
                    ));
        }

        RString newChosaItakusakiCode = entity.getChosaItakusakiCode().value();
        if (context.getExists調査員区分() == null) {
            return new ProcessingResults(
                    ProcessingResultFactory.error(ocrChosa, OcrTorikomiMessages.委託先_不存在
                            .replaced(newChosaItakusakiCode.toString())
                    ));
        }
        RString newChosainCode = entity.getChosainCode();
        if (!context.getExists調査員区分()) {
            return new ProcessingResults(ProcessingResultFactory.error(ocrChosa, OcrTorikomiMessages.調査員_不存在
                    .replaced(newChosaItakusakiCode.toString(), newChosainCode.toString()))
            );
        }

        boolean matches所属機関 = newChosaItakusakiCode.equals(nr.get認定調査委託先コード());
        boolean matches調査員 = newChosainCode.equals(nr.get認定調査員コード());
        if (matches所属機関 && matches調査員) {
            return ProcessingResults.EMPTY;
        }
        IProcessingResult.Type type = IProcessingResult.Type.WARNING;
        switch (batchParam.get調査員不一致時処理方法()) {
            case エラーとする:
                type = IProcessingResult.Type.ERROR;
                break;
            case 所属機関が一致すればエラーとしない:
                if (!matches所属機関) {
                    type = IProcessingResult.Type.ERROR;
                }
                break;
            default:
        }
        if (matches所属機関) {
            RString message = OcrTorikomiMessages.依頼時と異なる調査員.replaced(
                    nr.get認定調査委託先コード().toString(), nr.get認定調査員コード().toString(),
                    newChosaItakusakiCode.toString(), newChosainCode.toString()
            );
            return new ProcessingResults(ProcessingResultFactory.create(type, ocrChosa, message));
        } else {
            RString message = OcrTorikomiMessages.依頼時と異なる委託先_調査員.replaced(
                    nr.get認定調査委託先コード().toString(), nr.get認定調査員コード().toString(),
                    newChosaItakusakiCode.toString(), newChosainCode.toString()
            );
            return new ProcessingResults(ProcessingResultFactory.create(type, ocrChosa, message));
        }
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="概況調査 サービスの状況フラグ">
    private static void insertOrUpdateサービスの状況フラグBy(IBatchTableWriter<? super DbT5208NinteichosahyoServiceJokyoFlagEntity> dbWriter,
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrChosas ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        OcrChosa ocrChosa = ocrChosas.findFirst().get();
        for (DbT5208NinteichosahyoServiceJokyoFlagEntity entity : createOrEditサービスの状況フラグ(ninteiChosaEntity, nr, ocrChosa)) {
            switch (entity.getState()) {
                case Added:
                    dbWriter.insert(entity);
                    break;
                case Modified:
                    dbWriter.update(entity);
                    break;
                default:
            }
        }
    }

    private static List<DbT5208NinteichosahyoServiceJokyoFlagEntity> createOrEditサービスの状況フラグ(NinteiChosahyoEntity ninteiChosaEntity,
            NinteiOcrRelate nr, OcrChosa ocrChosa) {
        final Map<Integer, DbT5208NinteichosahyoServiceJokyoFlagEntity> map = ninteiChosaEntity.getサービスの状況フラグ();
        final RString 厚労省IF識別コード = nr.get厚労省IF識別コード().getコード();
        final List<DbT5208NinteichosahyoServiceJokyoFlagEntity> entities = new ArrayList<>();
        final INinteiChosahyoServiceJokyoFlagAccessor accessor = NinteiChosahyoServiceJokyoFlagAccessorFactory.createInstance(ocrChosa, 厚労省IF識別コード);
        for (IServiceJokyoFlag komoku : ServiceJokyoFlags.valuesOf(厚労省IF識別コード)) {
            final int 連番 = komoku.get連番();
            final Optional<Boolean> value = accessor.valueOf(連番);
            if (!value.isPresent()) {
                continue;
            }
            DbT5208NinteichosahyoServiceJokyoFlagEntity entity = map.containsKey(連番)
                    ? map.get(連番)
                    : newDbT5208NinteichosahyoServiceJokyoFlagEntity(nr, 連番);
            entity.setServiceJokyoFlag(value.get());
            entities.add(entity);
        }
        return entities;
    }

    private static DbT5208NinteichosahyoServiceJokyoFlagEntity newDbT5208NinteichosahyoServiceJokyoFlagEntity(NinteiOcrRelate nr, int 連番) {
        DbT5208NinteichosahyoServiceJokyoFlagEntity entity = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
        entity.setShinseishoKanriNo(nr.getShinseishoKanriNo());
        entity.setNinteichosaRirekiNo(nr.get認定調査依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(nr.get厚労省IF識別コード().asCode());
        entity.setRemban(連番);
        return entity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="概況調査 サービスの状況">
    private static void insertOrUpdateサービスの状況By(IBatchTableWriter<? super DbT5207NinteichosahyoServiceJokyoEntity> dbWriter,
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrChosas ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        OcrChosa ocrChosa = ocrChosas.findFirst().get();
        for (DbT5207NinteichosahyoServiceJokyoEntity entity : createOrEditサービスの状況(ninteiChosaEntity, nr, ocrChosa)) {
            switch (entity.getState()) {
                case Added:
                    dbWriter.insert(entity);
                    break;
                case Modified:
                    dbWriter.update(entity);
                    break;
                default:
            }
        }
    }

    private static List<DbT5207NinteichosahyoServiceJokyoEntity> createOrEditサービスの状況(NinteiChosahyoEntity ninteiChosaEntity,
            NinteiOcrRelate nr, OcrChosa ocrChosa) {
        final Map<Integer, DbT5207NinteichosahyoServiceJokyoEntity> map = ninteiChosaEntity.getサービスの状況();
        final RString 厚労省IF識別コード = nr.get厚労省IF識別コード().getコード();
        final List<DbT5207NinteichosahyoServiceJokyoEntity> entities = new ArrayList<>();
        final INinteiChosahyoServiceJokyoAccessor accessor = NinteiChosahyoServiceJokyoAccessorFactory.createInstance(ocrChosa, 厚労省IF識別コード);
        for (IGaikyoChosahyoServiceJokyo komoku : GaikyoChosahyoServiceJokyos.valuesOf(厚労省IF識別コード)) {
            final int 連番 = komoku.get連番AsInt();
            final Optional<Integer> value = accessor.valueOf(連番);
            if (!value.isPresent()) {
                continue;
            }
            DbT5207NinteichosahyoServiceJokyoEntity entity = map.containsKey(連番)
                    ? map.get(連番)
                    : newDbT5207NinteichosahyoServiceJokyoEntity(nr, 連番);
            entity.setServiceJokyo(value.get());
            entities.add(entity);
        }
        return entities;
    }

    private static DbT5207NinteichosahyoServiceJokyoEntity newDbT5207NinteichosahyoServiceJokyoEntity(NinteiOcrRelate nr, int 連番) {
        DbT5207NinteichosahyoServiceJokyoEntity entity = new DbT5207NinteichosahyoServiceJokyoEntity();
        entity.setShinseishoKanriNo(nr.getShinseishoKanriNo());
        entity.setNinteichosaRirekiNo(nr.get認定調査依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(nr.get厚労省IF識別コード().asCode());
        entity.setRemban(連番);
        return entity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="概況調査 施設利用">
    private static void insertOrUpdate施設利用By(IBatchTableWriter<? super DbT5210NinteichosahyoShisetsuRiyoEntity> dbWriter,
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrChosas ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        OcrChosa ocrChosa = ocrChosas.findFirst().get();
        for (DbT5210NinteichosahyoShisetsuRiyoEntity entity : createOrEdit施設利用(ninteiChosaEntity, nr, ocrChosa)) {
            switch (entity.getState()) {
                case Added:
                    dbWriter.insert(entity);
                    break;
                case Modified:
                    dbWriter.update(entity);
                    break;
                default:
            }
        }
    }

    private static List<DbT5210NinteichosahyoShisetsuRiyoEntity> createOrEdit施設利用(NinteiChosahyoEntity ninteiChosaEntity,
            NinteiOcrRelate nr, OcrChosa ocrChosa) {
        final Map<Integer, DbT5210NinteichosahyoShisetsuRiyoEntity> map = ninteiChosaEntity.get施設利用();
        final RString 厚労省IF識別コード = nr.get厚労省IF識別コード().getコード();
        final List<DbT5210NinteichosahyoShisetsuRiyoEntity> entities = new ArrayList<>();
        final INinteiChosahyoShisetsuRiyoAccessor accessor = NinteiChosahyoShisetsuRiyoAccessorFactory.createInstance(ocrChosa, 厚労省IF識別コード);
        for (IGaikyoChosahyoShisetuRiyo komoku : GaikyoChosahyoShisetuRiyos.valuesOf(厚労省IF識別コード)) {
            final int 連番 = komoku.get連番AsInt();
            final Optional<Boolean> value = accessor.valueOf(連番);
            if (!value.isPresent()) {
                continue;
            }
            DbT5210NinteichosahyoShisetsuRiyoEntity entity = map.containsKey(連番)
                    ? map.get(連番)
                    : newDbT5210NinteichosahyoShisetsuRiyoEntity(nr, 連番);
            entity.setShisetsuRiyoFlag(value.get());
            entities.add(entity);
        }
        return entities;
    }

    private static DbT5210NinteichosahyoShisetsuRiyoEntity newDbT5210NinteichosahyoShisetsuRiyoEntity(NinteiOcrRelate nr, int 連番) {
        DbT5210NinteichosahyoShisetsuRiyoEntity entity = new DbT5210NinteichosahyoShisetsuRiyoEntity();
        entity.setShinseishoKanriNo(nr.getShinseishoKanriNo());
        entity.setNinteichosaRirekiNo(nr.get認定調査依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(nr.get厚労省IF識別コード().asCode());
        entity.setRemban(連番);
        return entity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="基本調査">
    private static void insertOrUpdate基本調査By(IBatchTableWriter<? super DbT5203NinteichosahyoKihonChosaEntity> dbWriter,
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrChosas ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        OcrChosa ocrChosa = ocrChosas.findFirst().get();
        DbT5203NinteichosahyoKihonChosaEntity entity = createOrEdit基本調査(ninteiChosaEntity, nr, ocrChosa);
        switch (entity.getState()) {
            case Added:
                dbWriter.insert(entity);
                break;
            case Modified:
                dbWriter.update(entity);
                break;
            default:
        }
    }

    private static DbT5203NinteichosahyoKihonChosaEntity createOrEdit基本調査(NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrChosa ocrChosa) {
        DbT5203NinteichosahyoKihonChosaEntity entity = ninteiChosaEntity.get基本調査().isEmpty()
                ? newDbT5203NinteichosahyoKihonChosaEntity(nr, ocrChosa)
                : ninteiChosaEntity.get基本調査().get(0);
        edit基本調査(ocrChosa, entity);
        return entity;
    }

    private static DbT5203NinteichosahyoKihonChosaEntity newDbT5203NinteichosahyoKihonChosaEntity(NinteiOcrRelate nr, OcrChosa ocrChosa) {
        DbT5203NinteichosahyoKihonChosaEntity entity = new DbT5203NinteichosahyoKihonChosaEntity();
        entity.setShinseishoKanriNo(nr.getShinseishoKanriNo());
        entity.setNinteichosaRirekiNo(nr.get認定調査依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(nr.get厚労省IF識別コード().asCode());
        return entity;
    }

    private static void edit基本調査(OcrChosa ocrChosa, DbT5203NinteichosahyoKihonChosaEntity entity) {
        if (!isNullOrEmpty(ocrChosa.get認知症高齢者の日常生活自立度())) {
            entity.setNinchishoNichijoSeikatsuJiritsudoCode(ocrChosa.get認知症高齢者の日常生活自立度());
        }
        if (!isNullOrEmpty(ocrChosa.get障害高齢者の日常生活自立度())) {
            entity.setShogaiNichijoSeikatsuJiritsudoCode(ocrChosa.get障害高齢者の日常生活自立度());
        }
    }

    private static boolean isNullOrEmpty(Code code) {
        return code == null || Objects.equals(Code.EMPTY, code);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="基本調査 調査項目">
    private static void insertOrUpdate調査項目By(IBatchTableWriter<? super DbT5211NinteichosahyoChosaItemEntity> dbWriter,
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrChosas ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        for (DbT5211NinteichosahyoChosaItemEntity entity : crateOrEdit認定調査票調査項目s(ninteiChosaEntity, nr, ocrChosas.findFirst().get())) {
            switch (entity.getState()) {
                case Added:
                    dbWriter.insert(entity);
                    continue;
                case Modified:
                    dbWriter.update(entity);
                default:
            }
        }
    }

    private static List<DbT5211NinteichosahyoChosaItemEntity> crateOrEdit認定調査票調査項目s(NinteiChosahyoEntity ninteiChosaEntity,
            NinteiOcrRelate nr, OcrChosa ocrChosa) {
        final Map<Integer, DbT5211NinteichosahyoChosaItemEntity> map = ninteiChosaEntity.get調査項目s();
        final RString 厚労省IF識別コード = nr.get厚労省IF識別コード().getコード();
        final INinteiChosahyoChosaItemAccessor accessor = NinteiChosahyoChosaItemAccessorFactory.createInstance(ocrChosa, 厚労省IF識別コード);
        final List<DbT5211NinteichosahyoChosaItemEntity> entities = new ArrayList<>();
        for (INinteichosaKomokuMapping komoku : NinteichosaKomokuMappings.valuesOf(厚労省IF識別コード)) {
            final int 連番 = komoku.get連番();
            final RString value = accessor.valueOf(連番);
            if (RString.isNullOrEmpty(value)) {
                continue;
            }
            DbT5211NinteichosahyoChosaItemEntity entity = map.containsKey(連番)
                    ? map.get(連番)
                    : newDbT5211NinteichosahyoChosaItemEntity(nr, 連番);
            entity.setResearchItem(value);
            entities.add(entity);
        }
        return entities;
    }

    private static DbT5211NinteichosahyoChosaItemEntity newDbT5211NinteichosahyoChosaItemEntity(NinteiOcrRelate nr, int 連番) {
        DbT5211NinteichosahyoChosaItemEntity entity = new DbT5211NinteichosahyoChosaItemEntity();
        entity.setShinseishoKanriNo(nr.getShinseishoKanriNo());
        entity.setNinteichosaRirekiNo(nr.get認定調査依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(nr.get厚労省IF識別コード().asCode());
        entity.setRemban(連番);
        return entity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="特記情報">
    private static void insertOrUpdate特記情報By(IBatchTableWriter<? super DbT5205NinteichosahyoTokkijikoEntity> dbWriter,
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrTokkiJikoColumns updatingTokkiJikos) {
        if (updatingTokkiJikos.isEmpty()) {
            return;
        }
        for (DbT5205NinteichosahyoTokkijikoEntity entity : createOrEdit特記情報(ninteiChosaEntity, nr, updatingTokkiJikos)) {
            switch (entity.getState()) {
                case Added:
                    dbWriter.insert(entity);
                    break;
                case Modified:
                    dbWriter.update(entity);
                    break;
                case Deleted:
                    dbWriter.delete(entity);
                default:
            }
        }
    }

    private static Iterable<DbT5205NinteichosahyoTokkijikoEntity> createOrEdit特記情報(NinteiChosahyoEntity ninteiChosaEntity,
            NinteiOcrRelate nr, OcrTokkiJikoColumns updatingTokkiJikos) {
        TokkiJikoEntityMap map = toTokkiJikoEntityMap(ninteiChosaEntity);
        return createTokkiJohoEntitiesForUpdate(updatingTokkiJikos.groupedByChosaKomokuNo(), map, nr);
    }

    private static TokkiJikoEntityMap toTokkiJikoEntityMap(NinteiChosahyoEntity ninteiChosaEntity) {
        TokkiJikoEntityMap map = new TokkiJikoEntityMap();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : ninteiChosaEntity.get特記情報()) {
            map.put(entity);
        }
        return map;

    }

    private static final class TokkiJikoEntityMap extends HashMap<RString, Map<Integer, DbT5205NinteichosahyoTokkijikoEntity>> {

        private static final long serialVersionUID = -9162244762618145560L;

        private TokkiJikoEntityMap() {
            super();
        }

        /**
         * 指定のentityを、調査項目毎に分類し、さらに連番ごとに分類したMapへ格納します。
         *
         * @param entity {@link DbT5205NinteichosahyoTokkijikoEntity}
         * @return 指定の調査項目に以前に関連付けられていた値（Map標準の動作）
         */
        private DbT5205NinteichosahyoTokkijikoEntity put(DbT5205NinteichosahyoTokkijikoEntity entity) {
            RString key = entity.getNinteichosaTokkijikoNo();
            if (!containsKey(key)) {
                this.put(key, new HashMap<Integer, DbT5205NinteichosahyoTokkijikoEntity>());
            }
            return get(key).put(entity.getNinteichosaTokkijikoRemban(), entity);
        }
    }

    private static Iterable<DbT5205NinteichosahyoTokkijikoEntity> createTokkiJohoEntitiesForUpdate(
            Map<RString, OcrTokkiJikoColumns> updatingTokkiJikos, TokkiJikoEntityMap currentTokkiJikos, NinteiOcrRelate nr) {
        List<DbT5205NinteichosahyoTokkijikoEntity> list = new ArrayList<>();
        Set<RString> processed = new HashSet<>();
        for (Map.Entry<RString, Map<Integer, DbT5205NinteichosahyoTokkijikoEntity>> entry
                : currentTokkiJikos.entrySet()) {
            RString chosaKomokuNo = entry.getKey();
            Map<Integer, DbT5205NinteichosahyoTokkijikoEntity> tokkiJikosByRemban = entry.getValue();
            list.addAll(createTokkiJohoEntitiesEachKomokuNo(tokkiJikosByRemban,
                    updatingTokkiJikos.containsKey(chosaKomokuNo)
                            ? updatingTokkiJikos.get(chosaKomokuNo).groupedByRemban()
                            : Collections.<Integer, OcrTokkiJikoColumns>emptyMap(),
                    nr)
            );
            processed.add(chosaKomokuNo);
        }
        list.addAll(newAdditionalTokkiKomokus(updatingTokkiJikos, processed, nr));
        return list;
    }

    private static List<DbT5205NinteichosahyoTokkijikoEntity> newAdditionalTokkiKomokus(Map<RString, OcrTokkiJikoColumns> imageFiles, Set<RString> processed, NinteiOcrRelate nr) {
        List<DbT5205NinteichosahyoTokkijikoEntity> list = new ArrayList<>();
        for (Map.Entry<RString, OcrTokkiJikoColumns> entry : imageFiles.entrySet()) {
            if (processed.contains(entry.getKey())) {
                continue;
            }
            for (OcrTokkiJikoColumn a : entry.getValue()) {
                DbT5205NinteichosahyoTokkijikoEntity entity = newDbT5205NinteichosahyoTokkijikoEntity(nr, a.komokuNo());
                list.add(entity);
            }
        }
        return list;
    }

    private static List<DbT5205NinteichosahyoTokkijikoEntity> createTokkiJohoEntitiesEachKomokuNo(
            Map<Integer, DbT5205NinteichosahyoTokkijikoEntity> aCurrent,
            Map<Integer, OcrTokkiJikoColumns> aNew,
            NinteiOcrRelate nr) {
        List<DbT5205NinteichosahyoTokkijikoEntity> list = new ArrayList<>();
        list.addAll(createOrUpdateRembanThisTimeUse(aNew, aCurrent, nr));
        return list;
    }

    private static List<DbT5205NinteichosahyoTokkijikoEntity> createOrUpdateRembanThisTimeUse(
            Map<Integer, OcrTokkiJikoColumns> aNew, Map<Integer, DbT5205NinteichosahyoTokkijikoEntity> aCurrent,
            NinteiOcrRelate nr) {
        List<DbT5205NinteichosahyoTokkijikoEntity> list = new ArrayList<>();
        for (Map.Entry<Integer, OcrTokkiJikoColumns> newone : aNew.entrySet()) {
            int newRemban = newone.getKey();
            KomokuNo komokuNo = newone.getValue().getAny().get().komokuNo();
            DbT5205NinteichosahyoTokkijikoEntity entity
                    = aCurrent.containsKey(newRemban)
                            ? aCurrent.get(newRemban)
                            : newDbT5205NinteichosahyoTokkijikoEntity(nr, komokuNo);
            entity.setNinteichosaTokkijikoRemban(komokuNo.getRemban());
            list.add(entity);
        }
        return list;
    }

    private static DbT5205NinteichosahyoTokkijikoEntity newDbT5205NinteichosahyoTokkijikoEntity(NinteiOcrRelate nr, KomokuNo komokuNo) {
        DbT5205NinteichosahyoTokkijikoEntity entity = new DbT5205NinteichosahyoTokkijikoEntity();
        entity.setShinseishoKanriNo(nr.getShinseishoKanriNo());
        entity.setNinteichosaRirekiNo(nr.get認定調査依頼履歴番号());
        entity.setNinteichosaTokkijikoNo(komokuNo.getChosaKomokuNo());
        entity.setNinteichosaTokkijikoRemban(komokuNo.getRemban());
        entity.setTokkijikoTextImageKubun(TokkijikoTextImageKubun.イメージ.getコード());
        entity.setGenponMaskKubun(GenponMaskKubun.原本.getCode());
        return entity;
    }
    //</editor-fold>
}
