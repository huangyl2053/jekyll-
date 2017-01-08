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
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.OcrIken;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputRelate;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OCRID;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.Catalog;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.CatalogLine;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.IIkenshoIkenKomokuAccessor;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ikensho.IkenshoIkenKomokuAccessorFactory;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.Models;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
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
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.File;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.applog._Logger;
import jp.co.ndensan.reams.uz.uza.log.applog.gyomu._GyomuLogData;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 *
 */
public class ImageInputProcess extends BatchProcessBase<RString> {

    private static final RString PATH_SEPARATOR = new RString(File.separator);
    private static final int 切り出し桁数 = 1;
    private static final int 桁数固定値_内科 = 0;
    private static final int 桁数固定値_皮膚科 = 1;
    private static final int 桁数固定値_リハビリテーション科 = 2;
    private static final int 桁数固定値_精神科 = 3;
    private static final int 桁数固定値_泌尿器科 = 4;
    private static final int 桁数固定値_歯科 = 5;
    private static final int 桁数固定値_外科 = 6;
    private static final int 桁数固定値_婦人科 = 7;
    private static final int 桁数固定値_その他受診科 = 8;
    private static final int 桁数固定値_整形外科 = 9;
    private static final int 桁数固定値_眼科 = 10;
    private static final int 桁数固定値_脳神経外科 = 11;
    private static final int 桁数固定値_耳鼻咽喉科 = 12;
    private static final RString 主治医意見書_表_BAK = new RString("E0001_BAK.png");
    private static final RString 主治医意見書_裏_BAK = new RString("E0002_BAK.png");

    @BatchWriter
    private BatchPermanentTableWriter<DbT5302ShujiiIkenshoJohoEntity> writer_DbT5302;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5304ShujiiIkenshoIkenItemEntity> writer_DbT5304;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writer_DbT5115;

    /**
     * このバッチプロセスのパラメータです。
     */
    //TODO ca3ファイルのパスが必要。
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
        final OcrIken 取込解析結果 = OcrIken.parsed(line);
        if (hasBreak(this.key, 取込解析結果.getKey())) {
            /* ブレイク処理 */
            keyBreakProcess(this.key, this.cache);
            /* キャッシュのクリア と キーの更新 */
            this.cache = new ArrayList<>();
            this.key = 取込解析結果.getKey();
            return;
        }
        /* キャッシュへの追加 */
        this.cache.add(取込解析結果);
    }

    private static boolean hasBreak(ShinseiKey before, ShinseiKey current) {
        return !Objects.equals(before, current);
    }

    @Override
    protected void afterExecute() {
        super.afterExecute();
        keyBreakProcess(this.key, this.cache);
    }

    private static boolean isID777orID778() {
        return true;
    }

    private void keyBreakProcess(ShinseiKey key, List<OcrIken> sameKeyValues) {
        //TODO 現在、ID=777, ID=778 限定の処理となっている。ID=701等を取り込む場合には検討が必要。
        if (isID777orID778()) {
            processID777or778(key, sameKeyValues);
        }
    }

//--  ID777,778  --------------------------------------------------------------------------------------------------------------------------
    private void processID777or778(ShinseiKey key, List<OcrIken> sameKeyValues) {
        if (sameKeyValues.isEmpty() || 3 <= sameKeyValues.size()) {
            return; //TODO 不正のため、エラーリスト出力対象。
        }
        ImageinputMapperParamter param = ImageinputMapperParamter.createParamter(
                key.get証記載保険者番号(),
                key.get被保険者番号(),
                key.get認定申請日()
        );
        List<ImageinputRelate> 関連データ = ImageinputFinder.createInstance().get関連データ(param).records();
        if (関連データ.isEmpty()) {
            return; //TODO 不正のため、エラーリスト出力対象。
        }
        ImageinputRelate ir = 関連データ.get(0);
        if (!validate厚労省IF識別コード(ir.get厚労省IF識別コード())) {
            return; //TODO 不正のため、エラーリスト出力対象。
        }

        OcrIken 取込解析結果 = getAnyID777優先(sameKeyValues);
        if (ir.getT5302_主治医意見書情報().isEmpty()) {
            writer_DbT5302.insert(新規追加_DbT5302_要介護認定主治医意見書情報(ir, 取込解析結果));
        } else {
            writer_DbT5302.update(データ更新_DbT5302_要介護認定主治医意見書情報(ir, 取込解析結果));
        }
        for (DbT5304ShujiiIkenshoIkenItemEntity entity : データ更新_DbT5304_要介護認定主治医意見書意見項目(ir, 取込解析結果)) {
            if (entity.getState() == EntityDataState.Added) {
                writer_DbT5304.insert(entity);
                continue;
            }
            if (entity.getState() == EntityDataState.Modified) {
                writer_DbT5304.update(entity);
            }
        }

        RString tempDirectoryPath = Directory.createTmpDirectory();
        boolean successes = (sameKeyValues.size() == 1)
                ? copyImageFilesToDirectory_ID777or778_1line(tempDirectoryPath, sameKeyValues)
                : copyImageFilesToDirectory_ID777or778_2lines(tempDirectoryPath, sameKeyValues);
        if (!successes) {
            return; //TODO 不正のため、エラーリスト出力対象。
        }

        saveImageJoho(new FilesystemPath(tempDirectoryPath), ir);
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
            _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                    .append("カタログデータの取得に失敗しました。 ")
                    .append("SheetID下8桁：").append(value.getSheetID().get帳票一連ID下8桁())
                    .toString());
            /*----------------------------------------------------------------------------------*/
            return false;
        }
        FileNameConvertionTheories converter = (value.getOcrID() == OCRID._777)
                ? FileNameConvertionTheories.ID777
                : FileNameConvertionTheories.ID777_reversed;
        return copyImageFilesToDirectory(targetDirectoryPath, ca3.getImageFileNames(),
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
            return false;
        }
        CatalogLine ca3_777 = this.catalog.find(Models.ID777, csv_777.getSheetID()).orElse(null);
        if (ca3_777 == null) {
            return false;
        }
        CatalogLine ca3_778 = findCatalogLine_ID777or778(this.catalog, csv_778.getSheetID()).orElse(null);
        if (ca3_778 != null) {
            boolean result = copyImageFilesToDirectory(targetDirectoryPath, ca3_778.getImageFileNames().subList(0, 1),
                    this.processParameter.getImageFilePaths(), FileNameConvertionTheories.ID777_reversed);
            return result || copyImageFilesToDirectory(targetDirectoryPath, ca3_777.getImageFileNames().subList(0, 1),
                    this.processParameter.getImageFilePaths(), FileNameConvertionTheories.ID777_reversed);
        }
        FileNameConvertionTheories theory
                = new RString("1").equals(csv_777.get全体イメージ表側インデックス())
                        ? FileNameConvertionTheories.ID777
                        : FileNameConvertionTheories.ID777_reversed;
        return copyImageFilesToDirectory(targetDirectoryPath, ca3_777.getImageFileNames(),
                this.processParameter.getImageFilePaths(), theory);
    }

//--  共通処理  ---------------------------------------------------------------------------------------------------------------------------
    /**
     * 有効な厚労省IF識別コードである場合、{@code true}を返します。
     */
    private static boolean validate厚労省IF識別コード(KoroshoIfShikibetsuCode 厚労省IF識別コード) {
        return 厚労省IF識別コード == KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
    }

    /**
     * 指定のフォルダに指定のファイルをコピーします。
     * ファイル名のフルパスは{@link OcrImageReadProcessParameter}より取得します。
     * ファイル名の変換ルールは{@link FileNameConvertionTheories}にて指定します。
     */
    private static boolean copyImageFilesToDirectory(RString directoryPath, List<RString> imageFileNames,
            OcrFiles imageFiles, FileNameConvertionTheories converter) {
        if (imageFileNames == null || imageFileNames.isEmpty()) {
            return false;
        }
        for (RString imageFileName : imageFileNames) {
            RString path = imageFiles.findFilePathFromName(imageFileName);
            if (RString.isNullOrEmpty(path)) {
                //TODO ca3ファイルから読み取ったファイル名に該当するイメージがアップロードファイル中に見つからない場合、ここに制御が移る。
                //入力ファイル不正の可能性あり。適切な処理の検討が必要。
                continue;
            }
            File.copy(path, new RStringBuilder(directoryPath).append(PATH_SEPARATOR).append(converter.convert(imageFileName)).toRString());
        }
        return true;
    }

    /**
     * イメージ情報の新規登録と、共有ファイルエントリの作成・追加を行います。
     */
    private boolean saveImageJoho(FilesystemPath targetDirectory, ImageinputRelate ir) {
        if (targetDirectory == null) {
            return false;
        }
        if (!ir.hasイメージ情報()) {
            SharedFileDescriptor sfd = SharedFile.defineSharedFile(FilesystemName
                    .fromString(ir.getT5101_証記載保険者番号().concat(ir.getT5101_被保険者番号())));
            RDateTime sharedFileID = SharedFile.copyToSharedFile(targetDirectory, sfd.getSharedFileName());
            /* イメージ情報の更新 */
            DbT5115ImageEntity entityImage = new DbT5115ImageEntity();
            entityImage.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
            entityImage.setImageSharedFileId(sharedFileID);
            this.writer_DbT5115.insert(entityImage);
            return true;
        } else {
            ReadOnlySharedFileEntryDescriptor ro_sfd = new ReadOnlySharedFileEntryDescriptor(FilesystemName
                    .fromString(ir.getT5101_証記載保険者番号().concat(ir.getT5101_被保険者番号())), ir.getT5115_イメージ共有ファイルID());
            deleteIfExists(ro_sfd, 主治医意見書_表_BAK, 主治医意見書_裏_BAK);
            return SharedFile.appendNewFile(ro_sfd, targetDirectory, RString.EMPTY.toString());
        }
    }

    private static void deleteIfExists(ReadOnlySharedFileEntryDescriptor ro_sfd, final RString... targes) {
        RString tmpDirectoryPath = Directory.createTmpDirectory();
        SharedFile.copyToLocal(ro_sfd, new FilesystemPath(tmpDirectoryPath));
        java.io.File tmpDirectory = new java.io.File(tmpDirectoryPath.toString());
        for (final RString target : targes) {
            _deleteIfExistsIn(tmpDirectory, target, ro_sfd);
        }
        tmpDirectory.delete();
    }

    private static void _deleteIfExistsIn(java.io.File tmpDirectory, final RString target, ReadOnlySharedFileEntryDescriptor ro_sfd) {
        for (String fileName : tmpDirectory.list()) {
            if (!fileName.contains(target)) {
                continue;
            }
            SharedFile.deleteFileInEntry(ro_sfd, target.toString());
        }
    }

    private DbT5302ShujiiIkenshoJohoEntity 新規追加_DbT5302_要介護認定主治医意見書情報(ImageinputRelate ir, OcrIken 取込解析結果) {
        DbT5302ShujiiIkenshoJohoEntity entity = new DbT5302ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
        entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(ir.getT5101_厚労省IF識別コード());
        entity.setIkenshoIraiKubun(ir.getT5301_主治医意見書依頼区分());
        entity.setShujiiIryoKikanCode(ir.getT5301_主治医医療機関コード());
        entity.setShujiiCode(ir.getT5301_主治医コード());
        entity.setIkenshoReadYMD(FlexibleDate.getNowDate());
        entity.setSonotaJushinKaMei(RString.EMPTY);
        return 共通編集_DbT5302_要介護認定主治医意見書情報(entity, ir, 取込解析結果);
    }

    private DbT5302ShujiiIkenshoJohoEntity データ更新_DbT5302_要介護認定主治医意見書情報(ImageinputRelate ir, OcrIken 取込解析結果) {
        DbT5302ShujiiIkenshoJohoEntity entity = ir.getT5302_主治医意見書情報().get(0);
        return 共通編集_DbT5302_要介護認定主治医意見書情報(entity, ir, 取込解析結果);
    }

    private DbT5302ShujiiIkenshoJohoEntity 共通編集_DbT5302_要介護認定主治医意見書情報(DbT5302ShujiiIkenshoJohoEntity entity,
            ImageinputRelate ir, OcrIken 取込解析結果) {
        entity.setIkenshoJuryoYMD(new FlexibleDate(取込解析結果.get受領日()));
        entity.setIkenshoKinyuYMD(new FlexibleDate(取込解析結果.get記入日()));
        entity.setIkenshoSakuseiKaisuKubun(new Code(取込解析結果.get意見書作成回数()));
        if (ir.isT5101_施設入所の有無()) {
            entity.setZaitakuShisetsuKubun(ZaitakuShisetsuKubun.施設.getCode());
        } else {
            entity.setZaitakuShisetsuKubun(ZaitakuShisetsuKubun.在宅.getCode());
        }
        entity.setIkenshoDoiFlag(フラグ変換_RStringToBoolean(取込解析結果.get同意の有無()));
        entity.setSaishuShinryoYMD(new FlexibleDate(取込解析結果.get最終診察日()));
        entity.setExistTakaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get他科受診の有無()));
        edit受診中の他科項目(entity, 取込解析結果);
        entity.setShindamMei1(RString.EMPTY);
        entity.setHasshoYMD1(取込解析結果.get発症年月日１());
        entity.setShindamMei2(RString.EMPTY);
        entity.setHasshoYMD2(取込解析結果.get発症年月日２());
        entity.setShindamMei3(RString.EMPTY);
        entity.setHasshoYMD3(取込解析結果.get発症年月日３());
        entity.setAnteisei(取込解析結果.get症状の安定性());
        entity.setNijiHanteiKekkaRenrakuFlag(フラグ変換_RStringToBoolean(取込解析結果.get主治医への結果連絡()));
        return entity;
    }

    private static boolean フラグ変換_RStringToBoolean(RString target) {
        return target.equals(new RString("1"));
    }

    private static void edit受診中の他科項目(DbT5302ShujiiIkenshoJohoEntity entity, OcrIken 取込解析結果) {
        if (取込解析結果.get記入のあった科().isEmpty()) {
            return;
        }
        entity.setExistNaikaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_内科, 桁数固定値_内科 + 切り出し桁数)));
        entity.setExistSeishinkaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_精神科, 桁数固定値_精神科 + 切り出し桁数)));
        entity.setExistGekaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_外科, 桁数固定値_外科 + 切り出し桁数)));
        entity.setExistSeikeigekaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_整形外科, 桁数固定値_整形外科 + 切り出し桁数)));
        entity.setExistNoshinkeigekaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_脳神経外科, 桁数固定値_脳神経外科 + 切り出し桁数)));
        entity.setExistHifukaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_皮膚科, 桁数固定値_皮膚科 + 切り出し桁数)));
        entity.setExistHinyokikaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_泌尿器科, 桁数固定値_泌尿器科 + 切り出し桁数)));
        entity.setExistFujinkaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_婦人科, 桁数固定値_婦人科 + 切り出し桁数)));
        entity.setExistJibiinkokaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_耳鼻咽喉科, 桁数固定値_耳鼻咽喉科 + 切り出し桁数)));
        entity.setExistRehabilitationkaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_リハビリテーション科, 桁数固定値_リハビリテーション科 + 切り出し桁数)));
        entity.setExistShikaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_歯科, 桁数固定値_歯科 + 切り出し桁数)));
        entity.setExistGankaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_眼科, 桁数固定値_眼科 + 切り出し桁数)));
        entity.setExistSonotaJushinkaFlag(フラグ変換_RStringToBoolean(取込解析結果.get記入のあった科().substring(桁数固定値_その他受診科, 桁数固定値_その他受診科 + 切り出し桁数)));
    }

    private List<DbT5304ShujiiIkenshoIkenItemEntity> データ更新_DbT5304_要介護認定主治医意見書意見項目(ImageinputRelate ir, OcrIken 取込解析結果) {
        final Map<Integer, DbT5304ShujiiIkenshoIkenItemEntity> map = find意見書意見項目(ir);
        final RString 厚労省IF識別コード = ir.getT5101_厚労省IF識別コード();
        final IIkenshoIkenKomokuAccessor accessor = IkenshoIkenKomokuAccessorFactory.createInstance(取込解析結果, 厚労省IF識別コード);
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
