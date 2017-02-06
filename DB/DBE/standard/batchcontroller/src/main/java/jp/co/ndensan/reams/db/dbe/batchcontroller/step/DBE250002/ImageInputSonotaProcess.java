/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
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
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.TempOcrCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ocr.IOcrCsvMapper;
import jp.co.ndensan.reams.db.dbe.service.core.imageinput.ImageinputFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.ImageJohoUpdater;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * その他資料の読み込み処理です。
 */
//TODO デバッグ用に_Loggerのログを組み込んであるが、製品版にする直前には削除する。Errorのログは、エラーリストの出力へ変更（週つ力内容はユーザ向きに検討する。）
//TODO 個人情報を含むイメージを取り込む場合、その他Eucに登録が必要。
public class ImageInputSonotaProcess extends BatchProcessBase<TempOcrCsvEntity> {

    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writer_DbT5115;
    private OcrTorikomiResultListEditor kekkaListEditor;

    /**
     * このバッチプロセスのパラメータです。
     */
    private OcrDataReadProcessParameter processParameter;
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
        final OcrSonota ocrSonota = OcrSonota.parsed(entity.getCsvData());
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
        this.kekkaListEditor.writeMultiLine(keyBreakProcess(key, ocrSonotas));
    }

    private List<OcrTorikomiResult> keyBreakProcess(ShinseiKey key, List<OcrSonota> ocrSonotas) {
        List<ImageinputRelate> relatedData = ImageinputFinder.createInstance().get関連データ(toParameterToSearchRelatedData(key)).records();
        if (relatedData.isEmpty()) {
            return OcrTorikomiResultUtil.create(key, ocrSonotas,
                    IProcessingResult.Type.ERROR, OcrTorikomiMessages.有効な要介護認定申請なし);
        }
        ImageinputRelate ir = relatedData.get(0);
        if (!validate厚労省IF識別コード(ir.get厚労省IF識別コード())) {
            return OcrTorikomiResultUtil.create(key, ocrSonotas,
                    IProcessingResult.Type.ERROR, OcrTorikomiMessages.過去制度での申請);
        }
        IProcessingResults copySucceeds = copyFileImages(ocrSonotas, ir);
        return OcrTorikomiResultUtil.create(key, copySucceeds);
    }

    private ImageinputMapperParamter toParameterToSearchRelatedData(ShinseiKey key1) {
        return ImageinputMapperParamter.createParamter(key1.get証記載保険者番号(), key1.get被保険者番号(), key1.get認定申請日());
    }

    private IProcessingResults copyFileImages(List<OcrSonota> ocrSonotas, ImageinputRelate ir) {
        IProcessingResults results = new ProcessingResults();

        Map<OcrSonota, CatalogLine> map = new HashMap<>();

        for (OcrSonota ocrSonota : ocrSonotas) {
            CatalogLine cl = this.catalog.find(Models.ID801, ocrSonota.getSheetID()).orElse(null);
            if (cl == null) {
                results.add(ProcessingResultFactory.error(ocrSonota, OcrTorikomiMessages.カタログデータなし));
                continue;
            }
            map.put(ocrSonota, cl);
        }

        SonotaShiryoFileNameConvertionTheory theory = new SonotaShiryoFileNameConvertionTheory(map.keySet());
        results.addAll(theory.getResults());

        Set<IOcrData> inError = results.allOcrDataInError();
        RDateTime sharedFileID = ir.getSharedFileIDOrNull();
        for (Map.Entry<OcrSonota, CatalogLine> entry : map.entrySet()) {
            if (inError.contains(entry.getKey())) {
                continue;
            }
            ImageJohoUpdater.Result r
                    = ImageJohoUpdater.shinseiKey(ir.get申請書管理番号(), ir.getT5101_証記載保険者番号(), ir.getT5101_被保険者番号())
                    .sharedFileID(sharedFileID)
                    .imageFilePaths(this.processParameter.getImageFilePaths())
                    .fileNameTheory(theory)
                    .targetImageFileNames(entry.getValue().getImageFileNames())
                    .ocrData(entry.getKey())
                    .save(this.writer_DbT5115);

            sharedFileID = r.get共有ファイルID();
            results.addAll(r.getResults());
        }
        return results;
    }

    //--  共通処理  ---------------------------------------------------------------------------------------------------------------------------
    /**
     * 有効な厚労省IF識別コードである場合、{@code true}を返します。
     */
    private static boolean validate厚労省IF識別コード(KoroshoIfShikibetsuCode 厚労省IF識別コード) {
        return 厚労省IF識別コード == KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
    }
}
