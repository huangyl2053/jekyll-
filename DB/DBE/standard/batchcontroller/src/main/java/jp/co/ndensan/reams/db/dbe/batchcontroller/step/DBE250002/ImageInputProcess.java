/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002;

import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.OcrShujiiIkenshoJohoEditor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.FileNameConvertionTheories;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.ImageJohoUpdater;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.OcrImageClassification;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.OcrIken;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputRelate;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiUtil;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.Catalog;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.CatalogLine;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.IIkenshoIkenKomokuAccessor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.IkenshoIkenKomokuAccessorFactory;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.Models;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.SheetID;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe250002.OcrImageReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoIkenItemNewManager;
import jp.co.ndensan.reams.db.dbe.service.core.imageinput.ImageinputFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IIkenshoKomokuMapping;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMappings;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.applog._Logger;
import jp.co.ndensan.reams.uz.uza.log.applog.gyomu._GyomuLogData;

/**
 * 主治医意見書の読み込み処理です。
 */
//TODO デバッグ用に_Loggerのログを組み込んであるが、製品版にする直前には削除する。Errorのログは、エラーリストの出力へ変更（週つ力内容はユーザ向きに検討する。）
//TODO 個人情報を含むイメージを取り込む場合、その他Eucに登録が必要。
public class ImageInputProcess extends BatchProcessBase<RString> {

    @BatchWriter
    private BatchPermanentTableWriter<DbT5302ShujiiIkenshoJohoEntity> writer_DbT5302;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5304ShujiiIkenshoIkenItemEntity> writer_DbT5304;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writer_DbT5115;

    /**
     * このバッチプロセスのパラメータです。
     */
    private OcrImageReadProcessParameter processParameter;
    private List<OcrIken> cache;
    private ShinseiKey key;
    private Catalog catalog;

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(processParameter.getファイルPath().findCsvFilePath(), Encode.SJIS);
    }

    @Override
    protected void createWriter() {
        writer_DbT5302 = new BatchPermanentTableWriter<>(DbT5302ShujiiIkenshoJohoEntity.class);
        writer_DbT5304 = new BatchPermanentTableWriter<>(DbT5304ShujiiIkenshoIkenItemEntity.class);
        writer_DbT5115 = new BatchPermanentTableWriter<>(DbT5115ImageEntity.class);
    }

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        this.cache = new ArrayList<>();
        this.key = ShinseiKey.EMPTY;
        this.catalog = new Catalog(this.processParameter.getファイルPath().findCa3FilePath());
    }

    @Override
    protected void process(RString line) {
        final OcrIken ocrIken = OcrIken.parsed(line);
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
    }

    private void keyBreakProcess(ShinseiKey key, List<OcrIken> sameKeyValues) {
        _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                .append("/* イメージ取り込み処理開始")
                .append(" 証記載保険者番号：").append(key.get証記載保険者番号())
                .append(" 被保険者番号：").append(key.get被保険者番号())
                .append(" 認定申請日：").append(key.get認定申請日())
                .append(" 処理対象レコード数：").append(this.cache.size())
                .append("*/")
                .toString());
        //TODO 現在、ID=777, ID=778 限定の処理となっている。ID=701等を取り込む場合には検討が必要。
        if (isID777orID778()) {
            processID777or778(key, sameKeyValues);
        }
        _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                .append("/* イメージ取り込み処理終了")
                .append(" 証記載保険者番号：").append(key.get証記載保険者番号())
                .append(" 被保険者番号：").append(key.get被保険者番号())
                .append(" 認定申請日：").append(key.get認定申請日())
                .append("*/")
                .toString());
    }

    private static boolean isID777orID778() {
        return true;
    }

//--  ID777,778  --------------------------------------------------------------------------------------------------------------------------
    private void processID777or778(ShinseiKey key, List<OcrIken> sameKeyValues) {
        if (sameKeyValues.isEmpty() || 3 <= sameKeyValues.size()) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                    .append("処理対象データsize不正です。")
                    .append(" size：").append(sameKeyValues.size())
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return; //TODO 不正のため、エラーリスト出力対象。
        }
        ImageinputMapperParamter param = ImageinputMapperParamter.createParamter(
                key.get証記載保険者番号(),
                key.get被保険者番号(),
                key.get認定申請日()
        );
        List<ImageinputRelate> 関連データ = ImageinputFinder.createInstance().get関連データ(param).records();
        if (関連データ.isEmpty()) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                    .append("関連データの取得に失敗しました。")
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return; //TODO 不正のため、エラーリスト出力対象。
        }
        ImageinputRelate ir = 関連データ.get(0);
        if (!validate厚労省IF識別コード(ir.get厚労省IF識別コード())) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                    .append("過去の制度です。処理をskipします。")
                    .append(" 厚労省IF識別コード：").append(ir.get厚労省IF識別コード().getコード())
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return; //TODO 不正のため、エラーリスト出力対象。
        }

        OcrIken ocrIken = getAnyID777優先(sameKeyValues);
        DbT5302ShujiiIkenshoJohoEntity dbT5302 = createOrEdit主治医意見書情報(ir, ocrIken);
        switch (dbT5302.getState()) {
            case Added:
                writer_DbT5302.insert(dbT5302);
                break;
            case Modified:
                writer_DbT5302.update(dbT5302);
                break;
            default:
        }
        for (DbT5304ShujiiIkenshoIkenItemEntity dbT5304 : createOrEdit主治医意見書意見項目s(ir, ocrIken)) {
            switch (dbT5304.getState()) {
                case Added:
                    writer_DbT5304.insert(dbT5304);
                    continue;
                case Modified:
                    writer_DbT5304.update(dbT5304);
                default:
            }
        }

        RString tempDirectoryPath = Directory.createTmpDirectory();
        boolean copySucceeds = (sameKeyValues.size() == 1)
                ? copyImageFilesToDirectory_ID777or778_1line(tempDirectoryPath, sameKeyValues)
                : copyImageFilesToDirectory_ID777or778_2lines(tempDirectoryPath, sameKeyValues);
        if (!copySucceeds) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                    .append("イメージのコピーに失敗しました。")
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return; //TODO 不正のため、エラーリスト出力対象。
        }

        boolean saveSucceeds = ImageJohoUpdater.create(new FilesystemPath(tempDirectoryPath),
                ir.get申請書管理番号(),
                ir.getT5101_証記載保険者番号(),
                ir.getT5101_被保険者番号(),
                ir.hasイメージ情報() ? ir.getT5115_イメージ共有ファイルID() : null,
                OcrImageClassification.意見書_規定外_規定外ID
        ).updateBy(this.writer_DbT5115);
        if (saveSucceeds) {
            return;
        }
        //TODO 不正のため、エラーリスト出力対象。
        /*----------------------------------------------------------------------------------*/
        _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                .append("イメージ情報の保存に失敗しました。")
                .toString());
        /*----------------------------------------------------------------------------------*/
    }

    OcrIken getAnyID777優先(List<OcrIken> sameKeyValues) {
        for (OcrIken csv : sameKeyValues) {
            if (csv.getOcrID() == OCRID._777) {
                return csv;
            }
        }
        return sameKeyValues.get(0);
    }

    private boolean copyImageFilesToDirectory_ID777or778_1line(RString targetDirectoryPath, List<OcrIken> sameKeyValues) {
        OcrIken value = sameKeyValues.get(0);
        CatalogLine ca3 = findCatalogLine_ID777or778(this.catalog, value.getSheetID()).orElse(null);
        if (ca3 == null) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                    .append("カタログデータの取得に失敗しました。 ")
                    .append(" SheetID下8桁：").append(value.getSheetID().get帳票一連ID下8桁())
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return false; //TODO 不正のため、エラーリスト出力対象。
        }
        FileNameConvertionTheories converter = (value.getOcrID() == OCRID._777)
                ? FileNameConvertionTheories.ID777
                : FileNameConvertionTheories.ID777_reversed;
        return OcrTorikomiUtil.copyImageFilesToDirectory(targetDirectoryPath, ca3.getImageFileNames(),
                this.processParameter.getImageFilePaths(), converter);
    }

    private static Optional<CatalogLine> findCatalogLine_ID777or778(Catalog catalog, SheetID id) {
        Optional<CatalogLine> by777 = catalog.find(Models.ID777, id);
        if (by777.isPresent()) {
            return by777;
        }
        return catalog.find(Models.ID778, id);
    }

    private boolean copyImageFilesToDirectory_ID777or778_2lines(RString targetDirectoryPath, List<OcrIken> sameKeyValues) {
        OcrIken csv_777 = null;
        OcrIken csv_778 = null;
        for (OcrIken csv : sameKeyValues) {
            switch (csv.getOcrID()) {
                case _777:
                    csv_777 = csv;
                    continue;
                case _778:
                    csv_778 = csv;
                default:
            }
        }
        if (csv_777 == null || csv_778 == null) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                    .append("OCRIKEN.csvから対象のレコードが取得できませんでした。 ")
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return false; //TODO 不正のため、エラーリスト出力対象。
        }
        CatalogLine ca3_777 = this.catalog.find(Models.ID777, csv_777.getSheetID()).orElse(null);
        if (ca3_777 == null) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                    .append("カタログデータの取得に失敗しました。 ")
                    .append(" モデル：").append(Models.ID777)
                    .append(" SheetID下8桁：").append(csv_777.getSheetID().get帳票一連ID下8桁())
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return false; //TODO 不正のため、エラーリスト出力対象。
        }
        CatalogLine ca3_778 = findCatalogLine_ID777or778(this.catalog, csv_778.getSheetID()).orElse(null);
        if (ca3_778 != null) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                    .append("表面は OCRID = 777 から、裏面は OCRID = 778 から画像を取得します。")
                    .toString());
            /*----------------------------------------------------------------------------------*/
            boolean copyRimenSucceeds = OcrTorikomiUtil.copyImageFilesToDirectory(targetDirectoryPath, ca3_778.getImageFileNames().subList(0, 1),
                    this.processParameter.getImageFilePaths(), FileNameConvertionTheories.ID777);
            if (!copyRimenSucceeds) {
                /*----------------------------------------------------------------------------------*/
                _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                        .append("裏面の取得に失敗しました。")
                        .toString());
                /*----------------------------------------------------------------------------------*/
                return false; //TODO 不正のため、エラーリスト出力対象。
            }
            return OcrTorikomiUtil.copyImageFilesToDirectory(targetDirectoryPath, ca3_777.getImageFileNames().subList(0, 1),
                    this.processParameter.getImageFilePaths(), FileNameConvertionTheories.ID777);
        }
        /*----------------------------------------------------------------------------------*/
        _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                .append("表面・裏面とも、OCRID = 777 から画像を取得します。")
                .toString());
        /*----------------------------------------------------------------------------------*/
        FileNameConvertionTheories theory
                = new RString("1").equals(csv_777.get全体イメージ表側インデックス())
                        ? FileNameConvertionTheories.ID777
                        : FileNameConvertionTheories.ID777_reversed;
        return OcrTorikomiUtil.copyImageFilesToDirectory(targetDirectoryPath, ca3_777.getImageFileNames(),
                this.processParameter.getImageFilePaths(), theory);
    }

//--  共通処理  ---------------------------------------------------------------------------------------------------------------------------
    /**
     * 有効な厚労省IF識別コードである場合、{@code true}を返します。
     */
    private static boolean validate厚労省IF識別コード(KoroshoIfShikibetsuCode 厚労省IF識別コード) {
        return 厚労省IF識別コード == KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
    }

    private static DbT5302ShujiiIkenshoJohoEntity createOrEdit主治医意見書情報(ImageinputRelate ir, OcrIken ocrIken) {
        DbT5302ShujiiIkenshoJohoEntity entity = ir.getT5302_主治医意見書情報().isEmpty()
                ? newDbT5302ShujiiIkenshoJohoEntity(ir, ocrIken)
                : ir.getT5302_主治医意見書情報().get(0);
        entity.setIkenshoReadYMD(FlexibleDate.getNowDate());
        OcrShujiiIkenshoJohoEditor.edit(entity, ocrIken);
        return entity;
    }

    private static DbT5302ShujiiIkenshoJohoEntity newDbT5302ShujiiIkenshoJohoEntity(ImageinputRelate ir, OcrIken ocrIken) {
        DbT5302ShujiiIkenshoJohoEntity entity = new DbT5302ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
        entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(ir.getT5101_厚労省IF識別コード());
        entity.setIkenshoIraiKubun(ir.getT5301_主治医意見書依頼区分());
        entity.setShujiiIryoKikanCode(ir.getT5301_主治医医療機関コード());
        entity.setShujiiCode(ir.getT5301_主治医コード());
        entity.setSonotaJushinKaMei(RString.EMPTY);
        entity.setShindamMei1(RString.EMPTY);
        entity.setShindamMei2(RString.EMPTY);
        entity.setShindamMei3(RString.EMPTY);
        return entity;
    }

    private static List<DbT5304ShujiiIkenshoIkenItemEntity> createOrEdit主治医意見書意見項目s(ImageinputRelate ir, OcrIken ocrIken) {
        final Map<Integer, DbT5304ShujiiIkenshoIkenItemEntity> map = find意見書意見項目(ir);
        final RString 厚労省IF識別コード = ir.getT5101_厚労省IF識別コード();
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
                new ShinseishoKanriNo(ir.getT5101_申請書管理番号()),
                ir.getT5301_主治医意見書作成依頼履歴番号()
        );
        Map<Integer, DbT5304ShujiiIkenshoIkenItemEntity> map = new HashMap<>();
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : list) {
            map.put(entity.getRemban(), entity);
        }
        return map;
    }

    private static DbT5304ShujiiIkenshoIkenItemEntity newDbT5304ShujiiIkenshoIkenItemEntity(ImageinputRelate ir, RString 厚労省IF識別コード, int 連番) {
        DbT5304ShujiiIkenshoIkenItemEntity entity = new DbT5304ShujiiIkenshoIkenItemEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
        entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード));
        entity.setRemban(連番);
        return entity;
    }
}
