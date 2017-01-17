/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
import jp.co.ndensan.reams.db.dbe.business.core.ocr.chosahyo.OcrNinteichosahyoGakyoChosaEditor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.TokkijikoFileNameConvertionTheory;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.GaikyoChosahyoServiceJokyos;
import jp.co.ndensan.reams.db.dbe.definition.core.chosaKekkaInfoGaikyo.IGaikyoChosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.GaikyoChosahyoShisetuRiyos;
import jp.co.ndensan.reams.db.dbe.definition.core.gaikyochosahyouniteichosahyousiseturiy.IGaikyoChosahyoShisetuRiyo;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.Models;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocrdataread.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosahyoEntity;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosakekkatorikomiocr.NinteiOcrFindler;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.ImageJohoUpdater;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.OcrImageClassification;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag.IServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyoflag.ServiceJokyoFlags;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.INinteichosaKomokuMapping;
import jp.co.ndensan.reams.db.dbz.definition.core.ninteichosahyou.NinteichosaKomokuMappings;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ChosaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.TokkijikoTextImageKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5202NinteichosahyoGaikyoChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.applog._Logger;
import jp.co.ndensan.reams.uz.uza.log.applog.gyomu._GyomuLogData;

/**
 * OCR情報受入＿バッチプロセスクラスです。
 *
 * @author n8429
 */
public class OcrDataReadProcess extends BatchProcessBase<RString> {

    @BatchWriter
    private BatchPermanentTableWriter<DbT5202NinteichosahyoGaikyoChosaEntity> writerGaikyo;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5203NinteichosahyoKihonChosaEntity> writerKihon;
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
        return new BatchSimpleReader(processParameter.getファイルPath().findCsvFilePath(), Encode.SJIS);
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
        writerService = new BatchPermanentTableWriter<>(DbT5207NinteichosahyoServiceJokyoEntity.class);
        writerServiceFlag = new BatchPermanentTableWriter<>(DbT5208NinteichosahyoServiceJokyoFlagEntity.class);
        writerShisetsu = new BatchPermanentTableWriter<>(DbT5210NinteichosahyoShisetsuRiyoEntity.class);
        writerItem = new BatchPermanentTableWriter<>(DbT5211NinteichosahyoChosaItemEntity.class);
        writerImage = new BatchPermanentTableWriter<>(DbT5115ImageEntity.class);
    }

    @Override
    protected void process(RString line) {
        final OcrChosa ocrChosa = OcrChosa.parsed(line);
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

        RString tempDirectoryPath = Directory.createTmpDirectory();
        List<OcrImageClassification> imageTypes = new ArrayList<>();
        NinteiChosahyoEntity entity = find認定調査票データBy(finder, paramter);
        for (Map.Entry<OCRID, List<OcrChosa>> entry : groupingByOCRID(ocrChosas).entrySet()) {
            switch (entry.getKey()) {
                case _501:
                    /* DB更新 */
                    List<OcrChosa> _501 = entry.getValue();
                    insertOrUpdate概況調査By(writerGaikyo, entity, nr, _501);
                    insertOrUpdateサービスの状況By(writerService, entity, nr, _501);
                    insertOrUpdateサービスの状況フラグBy(writerServiceFlag, entity, nr, _501);
                    insertOrUpdate施設利用By(writerShisetsu, entity, nr, _501);
                    /* イメージコピー */
                    if (copyImageFilesToDirectory_ID501(tempDirectoryPath, _501)) {
                        imageTypes.add(OcrImageClassification.調査票_概況調査);
                    }
                    continue;
                case _502:
                    /* DB更新 */
                    List<OcrChosa> _502 = entry.getValue();
                    insertOrUpdate基本調査By(writerKihon, entity, nr, _502);
                    insertOrUpdate調査項目By(writerItem, entity, nr, _502);
                    continue;
                case _550:
                    /* イメージコピー */
                    List<OcrChosa> _550 = entry.getValue();
                    if (copyImageFilesToDirectory_ID550(tempDirectoryPath, _550)) {
                        imageTypes.add(OcrImageClassification.調査票_特記事項);
                    }
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
        if (saveSucceeds) {
            return;
        }

        //TODO 不正のため、エラーリスト出力対象。
        /*----------------------------------------------------------------------------------*/
        _Logger.gyomuLog(_GyomuLogData.LogType.Error,
                new RStringBuilder()
                .append("イメージ情報の保存に失敗しました。")
                .toString());
        /*----------------------------------------------------------------------------------*/
        //</editor-fold>
    }

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

    private boolean copyImageFilesToDirectory_ID550(RString targetDirectoryPath, List<OcrChosa> ocrChosas) {
        List<RString> imageFileNames = new ArrayList<>();
        List<OcrChosa> valuesExistsCa3 = new ArrayList<>();
        for (OcrChosa ocrChosa : ocrChosas) {
            CatalogLine cl = this.catalog.find(Models.ID550, ocrChosa.getSheetID()).orElse(null);
            if (cl == null) {
                continue;
            }
            List<RString> imageNames = cl.getImageFileNames();
            imageNames.removeAll(ocrChosa.get特記事項ImageFileName_KomokuNoIsNotPresent());
            imageFileNames.addAll(imageNames);
            valuesExistsCa3.add(ocrChosa);
        }
        return OcrTorikomiUtil.copyImageFilesToDirectory(targetDirectoryPath, imageFileNames,
                this.processParameter.getImageFilePaths(), new TokkijikoFileNameConvertionTheory(valuesExistsCa3));
    }

//--  共通処理  ---------------------------------------------------------------------------------------------------------------------------
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
}
