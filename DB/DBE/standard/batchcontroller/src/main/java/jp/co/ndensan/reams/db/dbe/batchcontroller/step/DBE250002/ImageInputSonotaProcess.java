/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250001.OcrTorikomiResultUtil;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputRelate;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.Catalog;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.CatalogLine;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist.OcrTorikomiResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.errorlist.OcrTorikomiResultListEditor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.SonotaShiryoFileNameConvertionTheory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.sonota.OcrSonota;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.Models;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.ImageInputProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.TempOcrCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ocr.IOcrCsvMapper;
import jp.co.ndensan.reams.db.dbe.service.core.imageinput.ImageinputFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.ImageJohoUpdater;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IFunction;
import jp.co.ndensan.reams.db.dbz.definition.core.util.function.IPredicate;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.SharedFileEntryInfoEntity;
import jp.co.ndensan.reams.uz.uza.cooperation.entity.UzT0887SharedFileEntryFilesEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * その他資料の読み込み処理です。
 */
//TODO パラメータによる処理分岐
//TODO 取込データ不正時の処理
public class ImageInputSonotaProcess extends BatchProcessBase<TempOcrCsvEntity> {

    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writer_DbT5115;
    private OcrTorikomiResultListEditor kekkaListEditor;

    /**
     * このバッチプロセスのパラメータです。
     */
    private ImageInputProcessParameter processParameter;
    private List<OcrSonota> cache;
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
        this.writer_DbT5115 = new BatchPermanentTableWriter<>(DbT5115ImageEntity.class);
        this.kekkaListEditor = new OcrTorikomiResultListEditor();
        this.kekkaListEditor.close();
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
        final OcrSonota ocrSonota = OcrSonota.parsed(entity.getCsvData(), entity.getLineNum());
        if (hasBreak(this.key, ocrSonota.getKey())) {
            if (!Objects.equals(ShinseiKey.EMPTY, key)) {
                _keyBreakProcess(this.key, this.cache);
            }
            /* キャッシュのクリアとキーの更新 */
            this.cache = new ArrayList<>();
            this.key = ocrSonota.getKey();
        }
        /* キャッシュへの追加 */
        this.cache.add(ocrSonota);
    }

    private static boolean hasBreak(ShinseiKey before, ShinseiKey current) {
        return !Objects.equals(before, current);
    }

    @Override
    protected void afterExecute() {
        super.afterExecute();
        _keyBreakProcess(this.key, this.cache);
    }

    private void _keyBreakProcess(ShinseiKey key, List<OcrSonota> ocrSonotas) {
        List<OcrSonota> normals = new ArrayList<>();
        List<OcrSonota> brokens = new ArrayList<>();
        for (OcrSonota ocrSonota : ocrSonotas) {
            if (ocrSonota.isBroken()) {
                brokens.add(ocrSonota);
            } else {
                normals.add(ocrSonota);
            }
        }
        List<OcrTorikomiResult> list = new ArrayList<>();
        list.addAll(makeErrorsForFileBroken(brokens, key));
        list.addAll(keyBreakProcess(key, normals));
        this.kekkaListEditor.writeMultiLine(list);
    }

    private static Collection<OcrTorikomiResult> makeErrorsForFileBroken(List<OcrSonota> brokens, ShinseiKey key) {
        return OcrTorikomiResultUtil.create(key, brokens,
                IProcessingResult.Type.ERROR, OcrTorikomiMessages.フォーマット不正);
    }

    private List<OcrTorikomiResult> keyBreakProcess(ShinseiKey key, List<OcrSonota> ocrSonotas) {
        List<ImageinputRelate> relatedData = ImageinputFinder.createInstance()
                .get関連データ(toParameterToSearchRelatedData(key)).records();
        if (relatedData.isEmpty()) {
            return OcrTorikomiResultUtil.create(key, ocrSonotas,
                    IProcessingResult.Type.ERROR, OcrTorikomiMessages.有効な要介護認定申請なし);
        }
        ImageinputRelate ir = relatedData.get(0);
        if (!validate厚労省IF識別コード(ir.get厚労省IF識別コード())) {
            return OcrTorikomiResultUtil.create(key, ocrSonotas,
                    IProcessingResult.Type.ERROR, OcrTorikomiMessages.過去制度での申請);
        }
        return OcrTorikomiResultUtil.create(key, copyImageFiles(ocrSonotas, ir));
    }

    private ImageinputMapperParamter toParameterToSearchRelatedData(ShinseiKey key1) {
        return ImageinputMapperParamter.createParamter(key1.get証記載保険者番号(), key1.get被保険者番号(), key1.get認定申請日());
    }

    private IProcessingResults copyImageFiles(List<OcrSonota> ocrSonotas, ImageinputRelate ir) {
        ProcessingResults results = new ProcessingResults();
        Map<OcrSonota, CatalogLine> haveCatalogLines = new HashMap<>();
        for (OcrSonota ocrSonota : ocrSonotas) {
            CatalogLine cl = this.catalog.find(Models.ID801, ocrSonota.getSheetID()).orElse(null);
            if (cl == null) {
                results.add(ProcessingResultFactory.error(ocrSonota, OcrTorikomiMessages.カタログデータなし));
                continue;
            }
            haveCatalogLines.put(ocrSonota, cl);
        }

        SonotaShiryoFileNameConvertionTheory theory = new SonotaShiryoFileNameConvertionTheory(
                haveCatalogLines.keySet(),
                allReadySavedImageFileNames(ir)
        );
        results.addAll(theory.getResults());

        Set<IOcrData> inError = results.allOcrDataInError();
        Set<OcrSonota> targets = new HashSet<>(haveCatalogLines.keySet());
        targets.removeAll(inError);
        RDateTime sharedFileID = ir.getSharedFileIDOrNull();
        for (OcrSonota ocrSonota : targets) {
            ImageJohoUpdater.Result r
                    = ImageJohoUpdater.shinseiKey(ir.get申請書管理番号(), ir.getT5101_証記載保険者番号(), ir.getT5101_被保険者番号())
                    .sharedFileID(sharedFileID)
                    .imageFilePaths(this.processParameter.getImageFilePaths())
                    .fileNameTheory(theory)
                    .targetImageFileNames(haveCatalogLines.get(ocrSonota).getImageFileNames())
                    .ocrData(ocrSonota)
                    .save(this.writer_DbT5115);
            sharedFileID = r.get共有ファイルID();
            results.addAll(r.getResults());
        }
        for (OcrSonota o : ocrSonotas) {
            results.addSuccessIfNotContains(o);
        }
        return results;
    }

    private static List<RString> allReadySavedImageFileNames(ImageinputRelate ir) {
        RDateTime sharedFileID = ir.getSharedFileIDOrNull();
        if (sharedFileID == null) {
            return Collections.emptyList();
        }
        ReadOnlySharedFileEntryDescriptor rsfd = new ReadOnlySharedFileEntryDescriptor(
                compose共有ファイル名(ir.getT5101_証記載保険者番号(), ir.getT5101_被保険者番号()), sharedFileID);
        return ItemList.of(SharedFile.getEntryInfo(rsfd))
                .map(toFilesNames())
                .filter(sonotaShiryoFile())
                .toList();
    }

    //<editor-fold defaultstate="collapsed" desc="toFilesNames()">
    private static final IFunction<SharedFileEntryInfoEntity, RString> TO_FILE_NAME
            = new IFunction<SharedFileEntryInfoEntity, RString>() {
                @Override
                public RString apply(SharedFileEntryInfoEntity t) {
                    UzT0887SharedFileEntryFilesEntity entity = t.getFilesEntity();
                    return entity == null ? RString.EMPTY : entity.getPathname();
                }
            };

    private static IFunction<SharedFileEntryInfoEntity, RString> toFilesNames() {
        return TO_FILE_NAME;

    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="sonotaShiryoFile()">
    private static final Pattern SONOTA_SHIRYO_PATTERN = Pattern.compile("F.+\\.(png|PNG)");
    private static final IPredicate<RString> SONOTA_SHIRYO = new IPredicate<RString>() {
        @Override
        public boolean evaluate(RString t
        ) {
            return SONOTA_SHIRYO_PATTERN.matcher(t).matches();
        }
    };

    private static IPredicate<RString> sonotaShiryoFile() {
        return SONOTA_SHIRYO;
    }
    //</editor-fold>

    private static FilesystemName compose共有ファイル名(RString 証記載保険者番号1, RString 被保険者番号1) {
        return FilesystemName.fromString(証記載保険者番号1.concat(被保険者番号1));
    }

    /**
     * 有効な厚労省IF識別コードである場合、{@code true}を返します。
     */
    private static boolean validate厚労省IF識別コード(KoroshoIfShikibetsuCode 厚労省IF識別コード) {
        return 厚労省IF識別コード == KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
    }
}
