/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputRelate;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiUtil;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ShinseiKey;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.Catalog;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.catalog.CatalogLine;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.images.SonotaShiryoFileNameConvertionTheory;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.sonota.OcrSonota;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.Models;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.service.core.imageinput.ImageinputFinder;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.ImageJohoUpdater;
import jp.co.ndensan.reams.db.dbe.service.core.ocr.imagejoho.OcrImageClassification;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.applog._Logger;
import jp.co.ndensan.reams.uz.uza.log.applog.gyomu._GyomuLogData;

/**
 * その他資料の読み込み処理です。
 */
//TODO デバッグ用に_Loggerのログを組み込んであるが、製品版にする直前には削除する。Errorのログは、エラーリストの出力へ変更（週つ力内容はユーザ向きに検討する。）
//TODO 個人情報を含むイメージを取り込む場合、その他Eucに登録が必要。
public class ImageInputSonotaProcess extends BatchProcessBase<RString> {

    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writer_DbT5115;
    /**
     * このバッチプロセスのパラメータです。
     */
    private OcrDataReadProcessParameter processParameter;
    private List<OcrSonota> cache;
    private ShinseiKey key;
    private Catalog catalog;

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(processParameter.getファイルPath().findCsvFilePath(), Encode.SJIS);
    }

    @Override
    protected void createWriter() {
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
        final OcrSonota ocrSonota = OcrSonota.parsed(line);
        if (hasBreak(this.key, ocrSonota.getKey())) {
            if (!Objects.equals(ShinseiKey.EMPTY, key)) {
                /* ブレイク処理 */
                _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                        .append("/* その他資料取込開始")
                        .append(" 証記載保険者番号：").append(key.get証記載保険者番号())
                        .append(" 被保険者番号：").append(key.get被保険者番号())
                        .append(" 認定申請日：").append(key.get認定申請日())
                        .append(" 処理対象レコード数：").append(this.cache.size())
                        .append("*/")
                        .toString());
                keyBreakProcess(this.key, this.cache);
                _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                        .append("/* その他資料取込終了")
                        .append(" 証記載保険者番号：").append(key.get証記載保険者番号()).append(" 被保険者番号：").append(key.get被保険者番号())
                        .append(" 認定申請日：").append(key.get認定申請日()).append("*/")
                        .toString());
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
        _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                .append("/* その他資料取込開始")
                .append(" 証記載保険者番号：").append(key.get証記載保険者番号())
                .append(" 被保険者番号：").append(key.get被保険者番号())
                .append(" 認定申請日：").append(key.get認定申請日())
                .append(" 処理対象レコード数：").append(this.cache.size())
                .append("*/")
                .toString());
        keyBreakProcess(this.key, this.cache);
        _Logger.gyomuLog(_GyomuLogData.LogType.Info, new RStringBuilder()
                .append("/* その他資料取込終了")
                .append(" 証記載保険者番号：").append(key.get証記載保険者番号()).append(" 被保険者番号：").append(key.get被保険者番号())
                .append(" 認定申請日：").append(key.get認定申請日()).append("*/")
                .toString());
    }

    private void keyBreakProcess(ShinseiKey key, List<OcrSonota> ocrChosas) {
        ImageinputMapperParamter param = ImageinputMapperParamter.createParamter(
                key.get証記載保険者番号(), key.get被保険者番号(), key.get認定申請日()
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

        RString tempDirectoryPath = Directory.createTmpDirectory();
        boolean copySucceeds = copyFileImages(tempDirectoryPath, ocrChosas);
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
                OcrImageClassification.その他資料
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

    private boolean copyFileImages(RString targetDirectoryPath, List<OcrSonota> ocrSonotas) {
        List<RString> imageFileNames = new ArrayList<>();
        List<OcrSonota> valuesExistsCa3 = new ArrayList<>();
        for (OcrSonota ocrSonota : ocrSonotas) {
            CatalogLine cl = this.catalog.find(Models.ID801, ocrSonota.getSheetID()).orElse(null);
            if (cl == null) {
                continue; //TODO 不正のため、エラーリスト出力対象。
            }
            imageFileNames.addAll(cl.getImageFileNames());
            valuesExistsCa3.add(ocrSonota);
        }
        SonotaShiryoFileNameConvertionTheory theory = new SonotaShiryoFileNameConvertionTheory(valuesExistsCa3);
        if (theory.exceedsLimit()) {
            /*----------------------------------------------------------------------------------*/
            _Logger.gyomuLog(_GyomuLogData.LogType.Error, new RStringBuilder()
                    .append("管理可能な最大数を超えるイメージが指定されています。一部のイメージは保存されません。")
                    .toString());
            /*----------------------------------------------------------------------------------*/
            //TODO 不正のため、エラーリスト出力対象。
        }
        return OcrTorikomiUtil.copyImageFilesToDirectory(targetDirectoryPath, imageFileNames,
                this.processParameter.getImageFilePaths(), theory);
    }

    //--  共通処理  ---------------------------------------------------------------------------------------------------------------------------
    /**
     * 有効な厚労省IF識別コードである場合、{@code true}を返します。
     */
    private static boolean validate厚労省IF識別コード(KoroshoIfShikibetsuCode 厚労省IF識別コード) {
        return 厚労省IF識別コード == KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3;
    }
}
