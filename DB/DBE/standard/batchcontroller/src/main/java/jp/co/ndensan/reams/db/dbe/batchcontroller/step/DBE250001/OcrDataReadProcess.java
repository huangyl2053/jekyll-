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
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.FileNameConvertionTheories;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosakekkatorikomiocr.NinteiOcrRelate;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiUtil;
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
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrChosa;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrChosas;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrNinteichosahyoGakyoChosaEditor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.TokkiImageFileName;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.TokkiImageFileNames;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.TokkijikoFileNameConvertionTheory;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.GaikyoChosahyoServiceJokyos;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.IGaikyoChosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyoShisetuRiyos;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.IGaikyoChosahyoShisetuRiyo;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.KomokuNo;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.Models;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.ocr.TempOcrCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosahyoEntity;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ocr.IOcrCsvMapper;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosakekkatorikomiocr.NinteiOcrFindler;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.ImageJohoUpdater;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.OcrImageClassification;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag.IServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag.ServiceJokyoFlags;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.INinteichosaKomokuMapping;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMappings;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.applog._Logger;
import jp.co.ndensan.reams.uz.uza.log.applog.gyomu._GyomuLogData;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

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

    /**
     * このバッチプロセスのパラメータです。
     */
    private OcrDataReadProcessParameter processParameter;
    private List<OcrChosa> cache;
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
    protected void beforeExecute() {
        super.beforeExecute();
        this.cache = new ArrayList<>();
        this.key = ShinseiKey.EMPTY;
        this.catalog = new Catalog(this.processParameter.getファイルPath().findCa3FilePath());
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
    }

    @Override
    protected void process(TempOcrCsvEntity entity) {
        final OcrChosa ocrChosa = OcrChosa.parsed(entity.getCsvData());
        if (hasBreak(this.key, ocrChosa.getKey())) {
            if (!Objects.equals(ShinseiKey.EMPTY, key)) {
                _keyBreakProcess();
            }
            /* キャッシュのクリアとキーの更新 */
            this.cache = new ArrayList<>();
            this.key = ocrChosa.getKey();
        }
        /* キャッシュへの追加 */
        this.cache.add(ocrChosa);
    }

    private void _keyBreakProcess() {
        _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                .append("/* 認定調査票取り込み処理開始")
                .append(" 証記載保険者番号：").append(key.get証記載保険者番号())
                .append(" 被保険者番号：").append(key.get被保険者番号())
                .append(" 認定申請日：").append(key.get認定申請日())
                .append(" 処理対象レコード数：").append(this.cache.size())
                .append("*/")
                .toString());
        /* ブレイク処理 */
        keyBreakProcess(this.key, this.cache);
        _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                .append("/* 認定調査票取り込み処理終了")
                .append(" 証記載保険者番号：").append(key.get証記載保険者番号()).append(" 被保険者番号：").append(key.get被保険者番号())
                .append(" 認定申請日：").append(key.get認定申請日()).append("*/")
                .toString());
    }

    private static boolean hasBreak(ShinseiKey before, ShinseiKey current) {
        return !Objects.equals(before, current);
    }

    @Override
    protected void afterExecute() {
        super.afterExecute();
        _keyBreakProcess();
    }

    private void keyBreakProcess(ShinseiKey key, List<OcrChosa> ocrChosas) {
        NinteiOcrMapperParamter paramter = NinteiOcrMapperParamter.createParamter(
                key.get証記載保険者番号(), key.get被保険者番号(), key.get認定申請日()
        );
        NinteiOcrFindler finder = NinteiOcrFindler.createInstance();
        List<NinteiOcrRelate> 関連データ = finder.get関連データ(paramter).records();
        if (関連データ.isEmpty()) {
            //<editor-fold defaultstate="collapsed" desc="関連データの取得に失敗しました。">
            //TODO 不正のため、エラーリスト出力対象。
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                    .append("関連データの取得に失敗しました。").toString());
            /*----------------------------------------------------------------------------------*/
            //</editor-fold>
            return;
        }
        NinteiOcrRelate nr = 関連データ.get(0);
        if (!validate厚労省IF識別コード(nr.get厚労省IF識別コード())) {
            //<editor-fold defaultstate="collapsed" desc="過去の制度での申請です。処理をskipします。">
            //TODO 不正のため、エラーリスト出力対象。
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                    .append("過去の制度での申請です。処理をskipします。")
                    .append(" 厚労省IF識別コード：").append(nr.get厚労省IF識別コード().getコード()).toString());
            /*----------------------------------------------------------------------------------*/
            //</editor-fold>
            return;
        }
        NinteiChosahyoEntity entity = find認定調査票データBy(finder, paramter);
        Map<OCRID, List<OcrChosa>> groupedByOCRID = groupingByOCRID(ocrChosas);
        if (!saveImageFiles(groupedByOCRID, nr)) {
            //<editor-fold defaultstate="collapsed" desc="イメージ情報の保存に失敗しました。">
            //TODO 不正のため、エラーリスト出力対象。
        /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error,
                    new RStringBuilder()
                    .append("イメージ情報の保存に失敗しました。")
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return;
            //</editor-fold>
        }
        update認定調査票関連情報(groupedByOCRID, entity, nr);
    }

    //<editor-fold defaultstate="collapsed" desc="イメージファイルの保存">
    private boolean saveImageFiles(Map<OCRID, List<OcrChosa>> groupedByOCRID, NinteiOcrRelate nr) {
        List<OcrImageClassification> imageTypes = new ArrayList<>();
        RString tempDirectoryPath = Directory.createTmpDirectory();
        for (Map.Entry<OCRID, List<OcrChosa>> entry : groupedByOCRID.entrySet()) {
            switch (entry.getKey()) {
                case _501:
                    if (copyImageFilesToDirectory_ID501(tempDirectoryPath, entry.getValue())) {
                        imageTypes.add(OcrImageClassification.調査票_概況調査);
                        continue;
                    }
                    //<editor-fold defaultstate="collapsed" desc="ID501と紐付くイメージ情報のコピーに失敗しました。">
                    //TODO 不正のため、エラーリスト出力対象。
                     /*----------------------------------------------------------------------------------*/
                    _Logger.gyomuLog(_GyomuLogData.LogType.Error,
                            new RStringBuilder()
                            .append("ID501と紐付くイメージ情報のコピーに失敗しました。")
                            .toString());
                    /*----------------------------------------------------------------------------------*/
                    //</editor-fold>
                    return false;
                case _550:
                    List<OcrChosa> _550 = entry.getValue();
                    TokkiImageFileNames imageFileNames = new OcrChosas(_550).editedFileNames連番重複再付番();
                    if (copyImageFilesToDirectory_ID550(tempDirectoryPath, _550, imageFileNames)) {
                        imageTypes.add(OcrImageClassification.調査票_特記事項);
                        continue;
                    }
                    //<editor-fold defaultstate="collapsed" desc="ID550と紐付くイメージ情報のコピーに失敗しました。">
                    //TODO 不正のため、エラーリスト出力対象。
                    /*----------------------------------------------------------------------------------*/
                    _Logger.gyomuLog(_GyomuLogData.LogType.Error,
                            new RStringBuilder()
                            .append("ID550と紐付くイメージ情報のコピーに失敗しました。")
                            .toString());
                    /*----------------------------------------------------------------------------------*/
                    //</editor-fold>
                    return false;
                case _570: //TODO 必要なユーザには実装する。
                default:
            }
        }
        boolean saveSucceeds = ImageJohoUpdater.create(new FilesystemPath(tempDirectoryPath),
                new ShinseishoKanriNo(nr.get申請書管理番号()),
                nr.get証記載保険者番号(),
                nr.get被保険者番号(),
                nr.hasイメージ情報() ? nr.getイメージ共有ファイルID() : null,
                imageTypes
        ).updateBy(this.writerImage);
        //<editor-fold defaultstate="collapsed" desc="イメージ情報の保存処理中に失敗しました。">
        //TODO 不正のため、エラーリスト出力対象。
        /*----------------------------------------------------------------------------------*/
        if (!saveSucceeds) {
            _Logger.gyomuLog(_GyomuLogData.LogType.Error,
                    new RStringBuilder()
                    .append("イメージ情報の保存処理中に失敗しました。")
                    .toString());
        }
        /*----------------------------------------------------------------------------------*/
        //</editor-fold>
        return saveSucceeds;
    }

    private boolean copyImageFilesToDirectory_ID501(RString targetDirectoryPath, List<OcrChosa> ocrChosas) {
        if (ocrChosas.size() != 1) {
            return false;
        }
        OcrChosa ocrChosa = ocrChosas.get(0);
        CatalogLine ca3 = this.catalog.find(Models.ID501, ocrChosa.getSheetID()).orElse(null);
        if (ca3 == null) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                    .append("カタログデータの取得に失敗しました。 ")
                    .append(" SheetID下8桁：").append(ocrChosa.getSheetID().get帳票一連ID下8桁())
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return false; //TODO 不正のため、エラーリスト出力対象。
        }
        return OcrTorikomiUtil.copyImageFilesToDirectory(targetDirectoryPath, ca3.getImageFileNames(),
                this.processParameter.getImageFilePaths(), FileNameConvertionTheories.ID501);
    }

    private boolean copyImageFilesToDirectory_ID550(RString targetDirectoryPath, List<OcrChosa> ocrChosas, TokkiImageFileNames tokkiImageFiles) {
        List<RString> imageFileNames = new ArrayList<>();
        for (OcrChosa ocrChosa : ocrChosas) {
            TokkiImageFileNames fileNames = ocrChosa.collectTokkiImageFileNames();
            Optional<CatalogLine> cl = this.catalog.find(Models.ID550, ocrChosa.getSheetID());
            boolean needsImageFile = !fileNames.removedEmptyKomokuNo().isEmpty();
            if (!cl.isPresent()) {
                if (needsImageFile) {
                    /*----------------------------------------------------------------------------------*/
                    _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                            .append("OCRCHOSA.CSVに特記事項情報がありますが、カタログデータがありません。")
                            .append(" SheetID下8桁：").append(ocrChosa.getSheetID().get帳票一連ID下8桁())
                            .toString());
                    /*----------------------------------------------------------------------------------*/
                    return false;
                } else {
                    continue;
                }
            }
            if (!needsImageFile) {
                /*----------------------------------------------------------------------------------*/
                _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                        .append("カタログデータがありますが、OCRCHOSA.CSVには特記事項情報がありません。")
                        .append(" SheetID下8桁：").append(ocrChosa.getSheetID().get帳票一連ID下8桁())
                        .toString());
                /*----------------------------------------------------------------------------------*/
                return false;
            }
            List<RString> imageNames = cl.get().getImageFileNames();
            imageNames.removeAll(fileNames.onlyEmptyKomokuNo().fileNameValues());
            imageFileNames.addAll(imageNames);
        }
        return OcrTorikomiUtil.copyImageFilesToDirectory(targetDirectoryPath, imageFileNames,
                this.processParameter.getImageFilePaths(), new TokkijikoFileNameConvertionTheory(tokkiImageFiles));
    }
    //</editor-fold>

    private void update認定調査票関連情報(Map<OCRID, List<OcrChosa>> groupedByOCRID, NinteiChosahyoEntity entity, NinteiOcrRelate nr) {
        /* DB更新 */
        for (Map.Entry<OCRID, List<OcrChosa>> entry : groupedByOCRID.entrySet()) {
            switch (entry.getKey()) {
                case _501:
                    List<OcrChosa> _501 = entry.getValue();
                    insertOrUpdate概況調査By(writerGaikyo, entity, nr, _501);
                    insertOrUpdateサービスの状況By(writerService, entity, nr, _501);
                    insertOrUpdateサービスの状況フラグBy(writerServiceFlag, entity, nr, _501);
                    insertOrUpdate施設利用By(writerShisetsu, entity, nr, _501);
                    continue;
                case _502:
                    List<OcrChosa> _502 = entry.getValue();
                    insertOrUpdate基本調査By(writerKihon, entity, nr, _502);
                    insertOrUpdate調査項目By(writerItem, entity, nr, _502);
                case _550:
                    List<OcrChosa> _550 = entry.getValue();
                    insertOrUpdate特記情報By(writerTokki, entity, nr, _550);
                case _570:
                    continue; //TODO 必要なユーザには実装する。
                default:
            }
        }
    }

//--  共通処理  ---------------------------------------------------------------------------------------------------------------------------
    /**
     * 指定の申請に関する調査票情報を取得します。
     *
     * @param finder 検索に用いるインスタンス
     * @param parameter 検索条件となるパラメータ
     * @return 指定の申請に関する調査票情報
     */
    private static NinteiChosahyoEntity find認定調査票データBy(NinteiOcrFindler finder, NinteiOcrMapperParamter parameter) {
        List<NinteiChosahyoEntity> entities = finder.get認定調査票(parameter);
        if (entities.isEmpty()) {
            return new NinteiChosahyoEntity();
        }
        for (NinteiChosahyoEntity entity : entities) {
            if (Objects.equals(entity.getGaikyoChosaTextImageKubun(), TokkijikoTextImageKubun.イメージ.getコード())) {
                return entity;
            }
        }
        NinteiChosahyoEntity newEntity = entities.get(0).copied(); // TokkijikoTextImageKubun.テキスト のレコード
        newEntity.clear概況調査(); // 「イメージ」のレコードを追加するためクリア
        newEntity.clear概況特記(); // 「イメージ」のレコードを追加するためクリア
        return newEntity;
    }

    /**
     * CSVレコードを OCRID 毎に分割します。
     *
     * @param list CSVレコード
     * @return OCRID毎に分割されたCSVレコード
     */
    private static Map<OCRID, List<OcrChosa>> groupingByOCRID(List<OcrChosa> list) {
        Map<OCRID, List<OcrChosa>> map = new HashMap<>();
        for (OcrChosa v : list) {
            OCRID ocrID = v.getOcrID();
            if (!map.containsKey(ocrID)) {
                map.put(ocrID, new ArrayList<OcrChosa>());
            }
            map.get(ocrID).add(v);
        }
        return map;
    }

    /**
     * 有効な厚労省IF識別コードである場合、{@code true}を返します。
     */
    private static boolean validate厚労省IF識別コード(KoroshoIfShikibetsuCode 厚労省IF識別コード) {
        return 厚労省IF識別コード == KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
    }

    //<editor-fold defaultstate="collapsed" desc="概況調査">
    private static void insertOrUpdate概況調査By(IBatchTableWriter<? super DbT5202NinteichosahyoGaikyoChosaEntity> dbWriter,
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, List<OcrChosa> ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        OcrChosa ocrChosa = ocrChosas.get(0);
        DbT5202NinteichosahyoGaikyoChosaEntity entity = createOrEdit概況調査(ninteiChosaEntity, nr, ocrChosa);
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

    private static DbT5202NinteichosahyoGaikyoChosaEntity createOrEdit概況調査(NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, OcrChosa ocrChosa) {
        DbT5202NinteichosahyoGaikyoChosaEntity entity = ninteiChosaEntity.get概況調査().isEmpty()
                ? newDbT5202NinteichosahyoGaikyoChosaEntity(nr, ocrChosa)
                : ninteiChosaEntity.get概況調査().get(0);
        OcrNinteichosahyoGakyoChosaEditor.edit(entity, ocrChosa);
        return entity;
    }

    private static DbT5202NinteichosahyoGaikyoChosaEntity newDbT5202NinteichosahyoGaikyoChosaEntity(NinteiOcrRelate nr, OcrChosa ocrChosa) {
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="概況調査 サービスの状況フラグ">
    private static void insertOrUpdateサービスの状況フラグBy(IBatchTableWriter<? super DbT5208NinteichosahyoServiceJokyoFlagEntity> dbWriter,
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, List<OcrChosa> ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        OcrChosa ocrChosa = ocrChosas.get(0);
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
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, List<OcrChosa> ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        OcrChosa ocrChosa = ocrChosas.get(0);
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
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, List<OcrChosa> ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        OcrChosa ocrChosa = ocrChosas.get(0);
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
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, List<OcrChosa> ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        OcrChosa ocrChosa = ocrChosas.get(0);
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
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, List<OcrChosa> ocrChosas) {
        if (ocrChosas.size() != 1) {
            return;
        }
        for (DbT5211NinteichosahyoChosaItemEntity entity : crateOrEdit認定調査票調査項目s(ninteiChosaEntity, nr, ocrChosas.get(0))) {
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
            NinteiChosahyoEntity ninteiChosaEntity, NinteiOcrRelate nr, List<OcrChosa> ocrChosas) {
        if (ocrChosas.isEmpty()) {
            return;
        }
        Map<RString, TokkiImageFileNames> imageFileNames = new OcrChosas(ocrChosas).editedFileNames連番重複再付番().groupedByChosaKomokuNo();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : createOrEdit特記情報(ninteiChosaEntity, nr, imageFileNames)) {
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
            NinteiOcrRelate nr, Map<RString, TokkiImageFileNames> imageFileNames) {
        TokkiJikoEntityMap map = classifyEntityUnderKomokuNoRemovingText(ninteiChosaEntity);
        return createTokkiJohoEntitiesForUpdate(imageFileNames, map, nr);
    }

    private static TokkiJikoEntityMap classifyEntityUnderKomokuNoRemovingText(NinteiChosahyoEntity ninteiChosaEntity) {
        TokkiJikoEntityMap map = new TokkiJikoEntityMap();
        for (DbT5205NinteichosahyoTokkijikoEntity entity : ninteiChosaEntity.get特記情報()) {
            if (TokkijikoTextImageKubun.テキスト.getコード().equals(entity.getTokkijikoTextImageKubun())) {
                continue;
            }
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
            Map<RString, TokkiImageFileNames> imageFileNames, TokkiJikoEntityMap map, NinteiOcrRelate nr) {
        List<DbT5205NinteichosahyoTokkijikoEntity> list = new ArrayList<>();
        Set<RString> processed = new HashSet<>();
        for (Map.Entry<RString, Map<Integer, DbT5205NinteichosahyoTokkijikoEntity>> entry
                : map.entrySet()) {
            RString chosaKomokuNo = entry.getKey();
            list.addAll(createTokkiJohoEntitiesEachKomokuNo(
                    entry.getValue(),
                    imageFileNames.containsKey(chosaKomokuNo)
                            ? imageFileNames.get(chosaKomokuNo).groupedByRemban()
                            : Collections.<Integer, TokkiImageFileNames>emptyMap(),
                    nr)
            );
            processed.add(chosaKomokuNo);
        }
        list.addAll(newAdditions(imageFileNames, processed, nr));
        return list;
    }

    private static List<DbT5205NinteichosahyoTokkijikoEntity> newAdditions(Map<RString, TokkiImageFileNames> imageFiles, Set<RString> processed, NinteiOcrRelate nr) {
        List<DbT5205NinteichosahyoTokkijikoEntity> list = new ArrayList<>();
        for (Map.Entry<RString, TokkiImageFileNames> entry : imageFiles.entrySet()) {
            if (processed.contains(entry.getKey())) {
                continue;
            }
            for (TokkiImageFileName a : entry.getValue()) {
                DbT5205NinteichosahyoTokkijikoEntity entity = newDbT5205NinteichosahyoTokkijikoEntity(nr, a.komokuNo());
                list.add(entity);
            }
        }
        return list;
    }

    private static List<DbT5205NinteichosahyoTokkijikoEntity> createTokkiJohoEntitiesEachKomokuNo(
            Map<Integer, DbT5205NinteichosahyoTokkijikoEntity> sameKomokuBefore,
            Map<Integer, TokkiImageFileNames> sameKomokuFresh,
            NinteiOcrRelate nr) {
        List<DbT5205NinteichosahyoTokkijikoEntity> list = new ArrayList<>();
        list.addAll(deleteRembanThisTimeNotUse(sameKomokuBefore, sameKomokuFresh));
        list.addAll(createOrUpdateRembanThisTimeUse(sameKomokuFresh, sameKomokuBefore, nr));
        return list;
    }

    private static List<DbT5205NinteichosahyoTokkijikoEntity> createOrUpdateRembanThisTimeUse(
            Map<Integer, TokkiImageFileNames> sameKomokuFresh, Map<Integer, DbT5205NinteichosahyoTokkijikoEntity> sameKomokuBefore,
            NinteiOcrRelate nr) {
        List<DbT5205NinteichosahyoTokkijikoEntity> list = new ArrayList<>();
        for (Map.Entry<Integer, TokkiImageFileNames> fresh : sameKomokuFresh.entrySet()) {
            int freshRemban = fresh.getKey();
            KomokuNo komokuNo = fresh.getValue().getAny().get().komokuNo();
            DbT5205NinteichosahyoTokkijikoEntity entity
                    = sameKomokuBefore.containsKey(freshRemban)
                            ? sameKomokuBefore.get(freshRemban)
                            : newDbT5205NinteichosahyoTokkijikoEntity(nr, komokuNo);
            entity.setNinteichosaTokkijikoRemban(komokuNo.getRemban());
            list.add(entity);
        }
        return list;
    }

    private static List<DbT5205NinteichosahyoTokkijikoEntity> deleteRembanThisTimeNotUse(
            Map<Integer, DbT5205NinteichosahyoTokkijikoEntity> sameKomokuBefore,
            Map<Integer, TokkiImageFileNames> sameKomokuFresh) {
        List<DbT5205NinteichosahyoTokkijikoEntity> list = new ArrayList<>();
        if (sameKomokuFresh.isEmpty()) {
            return list;
        }
        for (DbT5205NinteichosahyoTokkijikoEntity before : sameKomokuBefore.values()) {
            if (!sameKomokuFresh.containsKey(before.getNinteichosaTokkijikoRemban())) {
                before.setState(EntityDataState.Deleted);
                list.add(before);
            }
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
