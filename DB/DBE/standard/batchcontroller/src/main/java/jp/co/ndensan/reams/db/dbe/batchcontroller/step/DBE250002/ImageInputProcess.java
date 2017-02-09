/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002;

import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.OcrShujiiIkenshoJohoEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250001.OcrTorikomiResultUtil;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.FileNameConvertionTheories;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.OcrIken;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputRelate;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.Filterd;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResults;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.Catalog;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.CatalogLine;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.IIkenshoIkenKomokuAccessor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.IkenshoIkenKomokuAccessorFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist.OcrTorikomiResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist.OcrTorikomiResultListEditor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.OcrIkens;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.Models;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.ImageInputProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.TempOcrCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ocr.IOcrCsvMapper;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoIkenItemNewManager;
import jp.co.ndensan.reams.db.dbe.service.core.imageinput.ImageinputFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.ImageJohoUpdater;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IIkenshoKomokuMapping;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMappings;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
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
 * 主治医意見書の読み込み処理です。
 */
public class ImageInputProcess extends BatchProcessBase<TempOcrCsvEntity> {

    @BatchWriter
    private BatchPermanentTableWriter<DbT5302ShujiiIkenshoJohoEntity> writer_DbT5302;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5304ShujiiIkenshoIkenItemEntity> writer_DbT5304;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writer_DbT5115;
    private OcrTorikomiResultListEditor kekkaListEditor;

    /**
     * このバッチプロセスのパラメータです。
     */
    private ImageInputProcessParameter processParameter;
    private List<OcrIken> cache;
    private ShinseiKey key;
    private Catalog catalog;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(
                new RStringBuilder().append(IOcrCsvMapper.class.getName()).append(".findCsvDataOrderByKey").toRString(),
                this.processParameter.toOcrCsvMapperParameter()
        );
    }

    @Override
    protected void createWriter() {
        this.writer_DbT5302 = new BatchPermanentTableWriter<>(DbT5302ShujiiIkenshoJohoEntity.class);
        this.writer_DbT5304 = new BatchPermanentTableWriter<>(DbT5304ShujiiIkenshoIkenItemEntity.class);
        this.writer_DbT5115 = new BatchPermanentTableWriter<>(DbT5115ImageEntity.class);
        this.kekkaListEditor = new OcrTorikomiResultListEditor();
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        this.cache = new ArrayList<>();
        this.key = ShinseiKey.EMPTY;
        this.catalog = new Catalog(this.processParameter.getCatalogFilePath());
    }

    @Override
    protected void process(TempOcrCsvEntity entity) {
        final OcrIken ocrIken = OcrIken.parsed(entity.getCsvData(), entity.getLineNum());
        if (hasBreak(this.key, ocrIken.getKey())) {
            if (!Objects.equals(ShinseiKey.EMPTY, key)) {
                /* ブレイク処理 */
                keyBreakProcess(this.key, this.cache);
            }
            /* キャッシュのクリアとキーの更新 */
            this.cache = new ArrayList<>();
            this.key = ocrIken.getKey();
        }
        /* キャッシュへの追加 */
        this.cache.add(ocrIken);
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

    private void keyBreakProcess(ShinseiKey key, List<OcrIken> sameKeyValues) {
        List<OcrTorikomiResult> list = new ArrayList<>();
        OcrIkens ocrIkens = new OcrIkens(sameKeyValues);
        Filterd<OcrIkens> filterdNormal = ocrIkens.filterdNormal();
        list.addAll(makeErrorsForFileBroken(filterdNormal.rejected(), key));
        //TODO 現在、ID=777, ID=778 限定の処理となっている。ID=701等を取り込む場合には検討が必要。
        OcrIkens normals = filterdNormal.passed();
        list.addAll(processID777or778(normals.filterdByOCRIDs(OCRID._777, OCRID._778), key));
        this.kekkaListEditor.writeMultiLine(list);
    }

    private static Collection<OcrTorikomiResult> makeErrorsForFileBroken(OcrIkens brokens, ShinseiKey key) {
        ProcessingResults results = new ProcessingResults();
        for (OcrIken o : brokens) {
            results.add(ProcessingResultFactory.error(o, OcrTorikomiMessages.フォーマット不正.replaced(
                    Integer.toString(o.getLineNum()),
                    OcrTorikomiMessages.cutToLength(20, o.getデータ行_文字列(), OcrTorikomiMessages.RYAKU).toString()
            )));
        }
        return OcrTorikomiResultUtil.create(key, results);
    }

//--  ID777,778  --------------------------------------------------------------------------------------------------------------------------
    private List<OcrTorikomiResult> processID777or778(OcrIkens ocrIkens, ShinseiKey key) {
        ImageinputMapperParamter param = toParameterToSearchRelatedData(key);
        List<ImageinputRelate> relatedData = ImageinputFinder.createInstance().get関連データ(param).records();
        if (relatedData.isEmpty()) {
            return OcrTorikomiResultUtil.create(key, ocrIkens,
                    IProcessingResult.Type.ERROR, OcrTorikomiMessages.有効な要介護認定申請なし);
        }
        ImageinputRelate ir = relatedData.get(0);
        ImageinputRelate.Context context = new ImageinputRelate.Context(ocrIkens.asList(),
                this.processParameter.get一次判定済み時処理方法());
        IProcessingResults nrValidated = ir.validate(context);
        if (nrValidated.hasError()) {
            return OcrTorikomiResultUtil.create(key, nrValidated, ir);
        }
        List<OcrTorikomiResult> list = new ArrayList<>();
        list.addAll(OcrTorikomiResultUtil.create(key, nrValidated, ir));

        ProcessingResults r = new ProcessingResults();
        r.addAll(checkTooManyFilsToOperate(ocrIkens.filterdByOCRIDs(OCRID._777), 1));
        r.addAll(checkTooManyFilsToOperate(ocrIkens.filterdByOCRIDs(OCRID._778), 2));
        list.addAll(OcrTorikomiResultUtil.create(key, r, ir));

        OcrIkens safetyInCurrent = ocrIkens.removed(r.allOcrDataInError());
        if (safetyInCurrent.isEmpty()) {
            return list;
        }

        OcrIken ocrIken = safetyInCurrent.findByOCRIDPrioritizing(OCRID._777, OCRID._778).orElse(null); // このメソッド中でnullはありえない。
        insertOrUpdate主治医意見書情報By(this.writer_DbT5302, ir, ocrIken);
        insertOrUpdate主治医意見書項目By(this.writer_DbT5304, ir, ocrIken);

        CopyImageResult cir = (safetyInCurrent.size() == 1)
                ? copyImageFilesToDirectory_ID777or778_1line(safetyInCurrent, ir)
                : copyImageFilesToDirectory_ID777or778_2lines(safetyInCurrent, ir);
        ProcessingResults results = new ProcessingResults(cir.getResults());
        for (OcrIken o : safetyInCurrent) {
            results.addSuccessIfNotContains(o);
        }
        list.addAll(OcrTorikomiResultUtil.create(key, results, ir));
        return list;
    }

    private static IProcessingResults checkTooManyFilsToOperate(OcrIkens ocrIkens, int maxNum) {
        if (ocrIkens.size() <= maxNum) {
            return ProcessingResults.EMPTY;
        }
        ProcessingResults prs = new ProcessingResults();
        for (OcrIken o : ocrIkens) {
            prs.add(ProcessingResultFactory.error(o, OcrTorikomiMessages.同一申請複数存在.replaced("OCRIKEN.CSV")));
        }
        return prs;
    }

    @lombok.Value
    @lombok.AllArgsConstructor
    private static class CopyImageResult {

        private RDateTime sharedFileID;
        private IProcessingResults results;

        private CopyImageResult(ImageJohoUpdater.Result result) {
            this(result.getSharedFileID(), result.getProcessingResults());
        }
    }

    private CopyImageResult copyImageFilesToDirectory_ID777or778_1line(OcrIkens sameKeyValues, ImageinputRelate ir) {
        OcrIken value = sameKeyValues.asList().get(0);
        CatalogLine ca3 = findCatalogLine_ID777or778(this.catalog, value.getSheetID()).orElse(null);
        if (ca3 == null) {
            ProcessingResults results = new ProcessingResults();
            results.add(ProcessingResultFactory.error(value, OcrTorikomiMessages.カタログデータなし));
            return new CopyImageResult(ir.getSharedFileIDOrNull(), results);
        }
        FileNameConvertionTheories converter = (value.getOCRID() == OCRID._777)
                ? FileNameConvertionTheories.ID777
                : FileNameConvertionTheories.ID777_reversed;
        return new CopyImageResult(
                ImageJohoUpdater.shinseiKey(ir.get申請書管理番号(), ir.get証記載保険者番号(), ir.get被保険者番号())
                .sharedFileID(ir.getSharedFileIDOrNull())
                .imageFilePaths(this.processParameter.getImageFilePaths())
                .fileNameTheory(converter)
                .targetImageFileNames(ca3.getImageFileNames())
                .ocrData(value)
                .save(writer_DbT5115)
        );
    }

    private static Optional<CatalogLine> findCatalogLine_ID777or778(Catalog catalog, SheetID id) {
        Optional<CatalogLine> by777 = catalog.find(Models.ID777, id);
        if (by777.isPresent()) {
            return by777;
        }
        return catalog.find(Models.ID778, id);
    }

    private CopyImageResult copyImageFilesToDirectory_ID777or778_2lines(OcrIkens sameKeyValues, ImageinputRelate ir) {
        ProcessingResults results = new ProcessingResults();
        OcrIken777And778Pair pair = getPair(sameKeyValues);
        if (pair.hasAnyNull()) {
            OcrIken ocrIken = pair.findNonnullValue();
            results.add(ProcessingResultFactory.error(ocrIken, OcrTorikomiMessages.同一申請複数存在));
            return new CopyImageResult(ir.getSharedFileIDOrNull(), results);
        }
        CatalogLine ca3_777 = this.catalog.find(Models.ID777, pair.getCsv777().getSheetID()).orElse(null);
        if (ca3_777 == null) {
            results.add(ProcessingResultFactory.error(pair.getCsv777(), OcrTorikomiMessages.カタログデータなし));
            results.add(ProcessingResultFactory.error(pair.getCsv778(), OcrTorikomiMessages.カタログデータなし));
            return new CopyImageResult(ir.getSharedFileIDOrNull(), results);
        }
        CatalogLine ca3_778 = findCatalogLine_ID777or778(this.catalog, pair.getCsv778().getSheetID()).orElse(null);
        if (ca3_778 != null) {
            ImageJohoUpdater.Result result1 = ImageJohoUpdater.shinseiKey(ir.get申請書管理番号(), ir.get証記載保険者番号(), ir.get被保険者番号())
                    .sharedFileID(ir.getSharedFileIDOrNull())
                    .imageFilePaths(this.processParameter.getImageFilePaths())
                    .fileNameTheory(FileNameConvertionTheories.ID777_reversed)
                    .targetImageFileNames(ca3_778.getImageFileNames().subList(0, 1))
                    .ocrData(pair.getCsv778())
                    .save(writer_DbT5115);
            results.addAll(result1.getProcessingResults());
            ImageJohoUpdater.Result result2 = ImageJohoUpdater.shinseiKey(ir.get申請書管理番号(), ir.get証記載保険者番号(), ir.get被保険者番号())
                    .sharedFileID(result1.getSharedFileID())
                    .imageFilePaths(this.processParameter.getImageFilePaths())
                    .fileNameTheory(FileNameConvertionTheories.ID777)
                    .targetImageFileNames(ca3_777.getImageFileNames().subList(0, 1))
                    .ocrData(pair.getCsv777())
                    .save(writer_DbT5115);
            results.addAll(result2.getProcessingResults());
            return new CopyImageResult(result2.getSharedFileID(), results);
        }

        FileNameConvertionTheories theory
                = new RString("1").equals(pair.getCsv777().get全体イメージ表側インデックス())
                        ? FileNameConvertionTheories.ID777
                        : FileNameConvertionTheories.ID777_reversed;

        ImageJohoUpdater.Result result = ImageJohoUpdater.shinseiKey(ir.get申請書管理番号(), ir.get証記載保険者番号(), ir.get被保険者番号())
                .sharedFileID(ir.getSharedFileIDOrNull())
                .imageFilePaths(this.processParameter.getImageFilePaths())
                .fileNameTheory(theory)
                .targetImageFileNames(ca3_777.getImageFileNames())
                .ocrData(pair.getCsv777())
                .save(writer_DbT5115);
        results.addAll(result.getProcessingResults());
        return new CopyImageResult(result.getSharedFileID(), results);
    }

    @lombok.Value
    private static class OcrIken777And778Pair {

        private OcrIken csv777;
        private OcrIken csv778;

        private OcrIken777And778Pair(OcrIken csv777, OcrIken csv778) {
            this.csv777 = csv777;
            this.csv778 = csv778;
        }

        boolean hasAnyNull() {
            return csv777 == null || csv778 == null;
        }

        OcrIken findNonnullValue() {
            return (csv777 != null) ? csv777
                    : (csv778 != null) ? csv778
                            : null;
        }
    }

    private static OcrIken777And778Pair getPair(OcrIkens ocrIkens) {
        OcrIken csv_777 = null;
        OcrIken csv_778 = null;
        for (OcrIken csv : ocrIkens) {
            switch (csv.getOCRID()) {
                case _777:
                    csv_777 = csv;
                    continue;
                case _778:
                    csv_778 = csv;
                default:
            }
        }
        return new OcrIken777And778Pair(csv_777, csv_778);
    }
//--  共通処理  ---------------------------------------------------------------------------------------------------------------------------

    private static ImageinputMapperParamter toParameterToSearchRelatedData(ShinseiKey key1) {
        return ImageinputMapperParamter.createParamter(key1.get証記載保険者番号(), key1.get被保険者番号(), key1.get認定申請日());
    }

    //<editor-fold defaultstate="collapsed" desc="主治医意見書意見項目">
    private static void insertOrUpdate主治医意見書項目By(IBatchTableWriter<? super DbT5304ShujiiIkenshoIkenItemEntity> dbWriter,
            ImageinputRelate ir, OcrIken ocrIken) {
        for (DbT5304ShujiiIkenshoIkenItemEntity dbT5304 : createOrEdit主治医意見書意見項目s(ir, ocrIken)) {
            switch (dbT5304.getState()) {
                case Added:
                    dbWriter.insert(dbT5304);
                    continue;
                case Modified:
                    dbWriter.update(dbT5304);
                default:
            }
        }
    }

    private static List<DbT5304ShujiiIkenshoIkenItemEntity> createOrEdit主治医意見書意見項目s(ImageinputRelate ir, OcrIken ocrIken) {
        final Map<Integer, DbT5304ShujiiIkenshoIkenItemEntity> map = find意見書意見項目(ir);
        final RString 厚労省IF識別コード = ir.get厚労省IF識別コード().getコード();
        final IIkenshoIkenKomokuAccessor accessor = IkenshoIkenKomokuAccessorFactory.createInstance(ocrIken, 厚労省IF識別コード);
        final List<DbT5304ShujiiIkenshoIkenItemEntity> entities = new ArrayList<>();
        for (IIkenshoKomokuMapping komoku : IkenshoKomokuMappings.valuesOf(厚労省IF識別コード)) {
            final int 連番 = komoku.get連番();
            final RString value = accessor.valueOf(連番);
            if (RString.isNullOrEmpty(value)) {
                continue;
            }
            DbT5304ShujiiIkenshoIkenItemEntity entity = map.containsKey(連番)
                    ? map.get(連番)
                    : newDbT5304ShujiiIkenshoIkenItemEntity(ir, 厚労省IF識別コード, 連番);
            entity.setIkenItem(value);
            entities.add(entity);
        }
        return entities;
    }

    private static Map<Integer, DbT5304ShujiiIkenshoIkenItemEntity> find意見書意見項目(ImageinputRelate ir) {
        ShujiiIkenshoIkenItemNewManager manager = new ShujiiIkenshoIkenItemNewManager();
        List<DbT5304ShujiiIkenshoIkenItemEntity> list = manager.select主治医意見書意見項目(
                ir.get申請書管理番号(),
                ir.get主治医意見書作成依頼履歴番号()
        );
        Map<Integer, DbT5304ShujiiIkenshoIkenItemEntity> map = new HashMap<>();
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : list) {
            map.put(entity.getRemban(), entity);
        }
        return map;
    }

    private static DbT5304ShujiiIkenshoIkenItemEntity newDbT5304ShujiiIkenshoIkenItemEntity(ImageinputRelate ir, RString 厚労省IF識別コード, int 連番) {
        DbT5304ShujiiIkenshoIkenItemEntity entity = new DbT5304ShujiiIkenshoIkenItemEntity();
        entity.setShinseishoKanriNo(ir.get申請書管理番号());
        entity.setIkenshoIraiRirekiNo(ir.get主治医意見書作成依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード));
        entity.setRemban(連番);
        return entity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="主治医意見書情報">
    private static void insertOrUpdate主治医意見書情報By(IBatchTableWriter<? super DbT5302ShujiiIkenshoJohoEntity> dbWriter,
            ImageinputRelate ir, OcrIken ocrIken) {
        DbT5302ShujiiIkenshoJohoEntity dbT5302 = createOrEdit主治医意見書情報(ir, ocrIken);
        switch (dbT5302.getState()) {
            case Added:
                dbWriter.insert(dbT5302);
                break;
            case Modified:
                dbWriter.update(dbT5302);
                break;
            default:
        }
    }

    private static DbT5302ShujiiIkenshoJohoEntity createOrEdit主治医意見書情報(ImageinputRelate ir, OcrIken ocrIken) {
        DbT5302ShujiiIkenshoJohoEntity entity = ir.get主治医意見書情報().isEmpty()
                ? newDbT5302ShujiiIkenshoJohoEntity(ir, ocrIken)
                : ir.get主治医意見書情報().get(0);
        entity.setIkenshoReadYMD(FlexibleDate.getNowDate());
        OcrShujiiIkenshoJohoEditor.edit(entity, ocrIken);
        return entity;
    }

    private static DbT5302ShujiiIkenshoJohoEntity newDbT5302ShujiiIkenshoJohoEntity(ImageinputRelate ir, OcrIken ocrIken) {
        DbT5302ShujiiIkenshoJohoEntity entity = new DbT5302ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(ir.get申請書管理番号());
        entity.setIkenshoIraiRirekiNo(ir.get主治医意見書作成依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(ir.get厚労省IF識別コード().getコード());
        entity.setIkenshoIraiKubun(ir.get主治医意見書依頼区分());
        entity.setShujiiIryoKikanCode(ir.get主治医医療機関コード());
        entity.setShujiiCode(ir.get主治医コード());
        entity.setSonotaJushinKaMei(RString.EMPTY);
        entity.setShindamMei1(RString.EMPTY);
        entity.setShindamMei2(RString.EMPTY);
        entity.setShindamMei3(RString.EMPTY);
        return entity;
    }

    private static IProcessingResults validateDbT5302(DbT5302ShujiiIkenshoJohoEntity entity) {

        return null;
    }
    //</editor-fold>
}
