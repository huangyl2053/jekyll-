/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageInputReadResult;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe250002.OcrImageReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoIkenItemNewManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoKinyuItemManager;
import jp.co.ndensan.reams.db.dbe.service.core.imageinput.ImageinputFindler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKinyuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoKomokuMapping09B;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.ZaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
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

/**
 *
 * @author n2818
 */
public class ImageInputProcess extends BatchProcessBase<RString> {

    private static final RString PATH_SEPARATOR = new RString(File.separator);

    @BatchWriter
    private BatchPermanentTableWriter<DbT5302ShujiiIkenshoJohoEntity> writer_DbT5302;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5303ShujiiIkenshoKinyuItemEntity> writer_DbT5303;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5304ShujiiIkenshoIkenItemEntity> writer_DbT5304;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writer_DbT5115;

    /**
     * このバッチプロセスのパラメータです。
     */
    private OcrImageReadProcessParameter processParameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(processParameter.getファイルPath(), Encode.SJIS);
    }

    @Override
    protected void createWriter() {
        writer_DbT5302 = new BatchPermanentTableWriter<>(DbT5302ShujiiIkenshoJohoEntity.class);
        writer_DbT5303 = new BatchPermanentTableWriter<>(DbT5303ShujiiIkenshoKinyuItemEntity.class);
        writer_DbT5304 = new BatchPermanentTableWriter<>(DbT5304ShujiiIkenshoIkenItemEntity.class);
        writer_DbT5115 = new BatchPermanentTableWriter<>(DbT5115ImageEntity.class);
    }

    @Override
    protected void process(RString line) {
        final ImageInputReadResult 取込解析結果 = ImageInputReadResult.parsed(line);

        ImageinputMapperParamter imp = ImageinputMapperParamter.createParamter(取込解析結果.get保険者番号(),
                取込解析結果.get被保険者番号(),
                取込解析結果.get申請日());
        List<ImageinputResult> 関連データList_ = ImageinputFindler.createInstance().get関連データ(imp).records();
        for (ImageinputResult ir : 関連データList_) {
            /* 主治医意見書テーブルの更新 */
            if (ir.getT5302_主治医意見書情報().isEmpty()) {
                writer_DbT5302.insert(新規追加_DbT5302_要介護認定主治医意見書情報(ir, 取込解析結果));
                for (DbT5303ShujiiIkenshoKinyuItemEntity entity : 新規追加_DbT5303_要介護認定主治医意見書記入項目(ir, 取込解析結果)) {
                    writer_DbT5303.insert(entity);
                }
                for (DbT5304ShujiiIkenshoIkenItemEntity entity : 新規追加_DbT5304_要介護認定主治医意見書意見項目(ir, 取込解析結果)) {
                    writer_DbT5304.insert(entity);
                }
            } else {
                writer_DbT5302.update(データ更新_DbT5302_要介護認定主治医意見書情報(ir, 取込解析結果));
                for (DbT5303ShujiiIkenshoKinyuItemEntity entity : データ更新_DbT5303_要介護認定主治医意見書記入項目(ir, 取込解析結果)) {
                    writer_DbT5303.update(entity);
                }
                for (DbT5304ShujiiIkenshoIkenItemEntity entity : データ更新_DbT5304_要介護認定主治医意見書意見項目(ir, 取込解析結果)) {
                    writer_DbT5304.update(entity);
                }
            }

            /* イメージ情報の更新 */
            if (!ir.hasイメージ情報()) {
                saveImageJoho(取込解析結果, ir);
            } else {
                appendToSharedFileEntry(取込解析結果, ir);
            }
        }
    }

    private boolean saveImageJoho(ImageInputReadResult 取込解析結果, ImageinputResult ir) {
        FilesystemPath copiedDirectory = copyImageFilesToTempDirectory(取込解析結果);
        if (copiedDirectory == null) {
            return false;
        }
        SharedFileDescriptor sfd = SharedFile.defineSharedFile(FilesystemName
                .fromString(取込解析結果.get保険者番号().concat(取込解析結果.get被保険者番号())));
        RDateTime sharedFileID = SharedFile.copyToSharedFile(copiedDirectory, sfd.getSharedFileName());
        /* イメージ情報の更新 */
        DbT5115ImageEntity entityImage = new DbT5115ImageEntity();
        entityImage.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
        entityImage.setImageSharedFileId(sharedFileID);
        writer_DbT5115.insert(entityImage);
        return true;
    }

    @CheckForNull
    private FilesystemPath copyImageFilesToTempDirectory(ImageInputReadResult 取込解析結果) {
        List<RString> imageFileNames = 取込解析結果.getImageFileNames();
        if (imageFileNames == null || imageFileNames.isEmpty()) {
            return null;
        }
        RString tempDirectory = Directory.createTmpDirectory();
        for (RString imageFileName : imageFileNames) {
            RString path = this.processParameter.getImageFilePathFromName(imageFileName);
            if (RString.isNullOrEmpty(path)) {
                //TODO ca3ファイルから読み取ったファイル名に該当するイメージがアップロードされたファイルの中に見つからない場合、
                //     このに制御が移る。入力ファイル不正の可能性あり。適切な処理の検討が必要。
                continue;
            }
            File.copy(path, new RStringBuilder(tempDirectory).append(PATH_SEPARATOR).append(imageFileName).toRString());
        }
        return new FilesystemPath(tempDirectory);
    }

    /**
     * 既存の共有ファイルへファイルを追加します。
     */
    private boolean appendToSharedFileEntry(ImageInputReadResult 取込解析結果, ImageinputResult ir) {
        FilesystemPath copiedDirectory = copyImageFilesToTempDirectory(取込解析結果);
        if (copiedDirectory == null) {
            return false;
        }
        ReadOnlySharedFileEntryDescriptor or_sfd = new ReadOnlySharedFileEntryDescriptor(FilesystemName
                .fromString(取込解析結果.get保険者番号().concat(取込解析結果.get被保険者番号())), ir.getT5115_イメージ共有ファイルID());
        return SharedFile.appendNewFile(or_sfd, copiedDirectory, "");
    }

    private List<DbT5304ShujiiIkenshoIkenItemEntity> 新規追加_DbT5304_要介護認定主治医意見書意見項目(ImageinputResult ir, ImageInputReadResult 取込解析結果)
            throws NullPointerException, IllegalArgumentException {
        List<DbT5304ShujiiIkenshoIkenItemEntity> entitys = new ArrayList<>();
        for (int i = 1; i <= 113; i++) {
            DbT5304ShujiiIkenshoIkenItemEntity entity = new DbT5304ShujiiIkenshoIkenItemEntity();
            entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
            entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
            entity.setRemban(i);
            entity.setKoroshoIfShikibetsuCode(new Code(ir.getT5101_厚労省IF識別コード()));
            switch (IkenshoKomokuMapping09B.toValue(new RString(i))) {
                case 点滴の管理:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(0, 1));
                    }
                    break;
                case ストーマの処置:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(1, 2));
                    }
                    break;
                case 気管切開の処置:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(2, 3));
                    }
                    break;
                case 中心静脈栄養:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(3, 4));
                    }
                    break;
                case 酸素療法:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(4, 5));
                    }
                    break;
                case 疼痛の看護:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(5, 6));
                    }
                    break;
                case 透析:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(6, 7));
                    }
                    break;
                case レスピレーター:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(7, 8));
                    }
                    break;
                case 経管栄養:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(8));
                    }
                    break;
                case モニター測定:
                    if (!取込解析結果.get特別な対応().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get特別な対応().substring(0, 1));
                    }
                    break;
                case じょくそうの処置:
                    if (!取込解析結果.get特別な対応().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get特別な対応().substring(1));
                    }
                    break;
                case カテーテル:
                    entity.setIkenItem(取込解析結果.getカテーテル());
                    break;
                case 寝たきり度:
                    entity.setIkenItem(取込解析結果.get障害高齢者の自立度());
                    break;
                case 認知症高齢者の日常生活自立度:
                    entity.setIkenItem(取込解析結果.get認知症高齢者の自立度());
                    break;
                case 短期記憶:
                    entity.setIkenItem(取込解析結果.get短期記憶());
                    break;
                case 認知能力:
                    entity.setIkenItem(取込解析結果.get認知能力());
                    break;
                case 伝達能力:
                    entity.setIkenItem(取込解析結果.get伝達能力());
                    break;
                case 認知症の周辺症状:
                    entity.setIkenItem(取込解析結果.get問題行動の有無());
                    break;
                case 幻視_幻聴:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(0, 1));
                    }
                    break;
                case 火の不始末:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(1, 2));
                    }
                    break;
                case 妄想:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(2, 3));
                    }
                    break;
                case 不潔行為:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(3, 4));
                    }
                    break;
                case 昼夜逆転:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(4, 5));
                    }
                    break;
                case 異食行動:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(5, 6));
                    }
                    break;
                case 暴言:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(6, 7));
                    }
                    break;
                case 性的問題行動:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(7, 8));
                    }
                    break;
                case 暴行:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(8, 9));
                    }
                    break;
                case その他:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(9, 10));
                    }
                    break;
                case 介護への抵抗:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(10, 11));
                    }
                    break;
                case 徘徊_認知症の周辺症状:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(11));
                    }
                    break;
                case その他の精神_神経症状:
                    entity.setIkenItem(取込解析結果.get精神神経症状());
                    break;
                case 専門医受診の有無:
                    entity.setIkenItem(取込解析結果.get専門科医受診());
                    break;
                case 利き腕:
                    entity.setIkenItem(取込解析結果.get利き腕());
                    break;
                case 過去6カ月の体重の変化:
                    entity.setIkenItem(取込解析結果.get過去6ヶ月間の体重の変化());
                    break;
                case 四肢欠損:
                    entity.setIkenItem(取込解析結果.get四肢欠損());
                    break;
                case 麻痺:
                    entity.setIkenItem(取込解析結果.get麻痺());
                    break;
                case 麻痺_右上肢:
                    entity.setIkenItem(取込解析結果.get麻痺右上肢());
                    break;
                case 麻痺_右上肢_程度:
                    entity.setIkenItem(取込解析結果.get麻痺右上肢程度());
                    break;
                case 麻痺_左上肢:
                    entity.setIkenItem(取込解析結果.get麻痺左上肢());
                    break;
                case 麻痺_左上肢_程度:
                    entity.setIkenItem(取込解析結果.get麻痺左上肢程度());
                    break;
                case 麻痺_右下肢:
                    entity.setIkenItem(取込解析結果.get麻痺右下肢());
                    break;
                case 麻痺_右下肢_程度:
                    entity.setIkenItem(取込解析結果.get麻痺右下肢程度());
                    break;
                case 麻痺_左下肢:
                    entity.setIkenItem(取込解析結果.get麻痺左下肢());
                    break;
                case 麻痺_左下肢_程度:
                    entity.setIkenItem(取込解析結果.get麻痺左下肢程度());
                    break;
                case 麻痺_その他:
                    entity.setIkenItem(取込解析結果.get麻痺その他());
                    break;
                case 麻痺_その他_程度:
                    entity.setIkenItem(取込解析結果.get麻痺その他程度());
                    break;
                case 筋力の低下:
                    entity.setIkenItem(取込解析結果.get筋力低下());
                    break;
                case 筋力の低下_程度:
                    entity.setIkenItem(取込解析結果.get筋力低下程度());
                    break;
                case 関節の拘縮:
                    entity.setIkenItem(取込解析結果.get間接の拘縮());
                    break;
                case 関節の拘縮_程度:
                    entity.setIkenItem(取込解析結果.get間接の拘縮程度());
                    break;
                case 関節の痛み:
                    entity.setIkenItem(取込解析結果.get間接の痛み());
                    break;
                case 関節の痛み_程度:
                    entity.setIkenItem(取込解析結果.get間接の痛み程度());
                    break;
                case 失調_不随意運動:
                    entity.setIkenItem(取込解析結果.get失調不随意運動());
                    break;
                case 失調_不随意運動_上肢_右:
                    if (!取込解析結果.get失調不随意上肢().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意上肢().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_上肢_左:
                    if (!取込解析結果.get失調不随意上肢().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意上肢().substring(1));
                    }
                    break;
                case 失調_不随意運動_下肢_右:
                    if (!取込解析結果.get失調不随意下肢().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意下肢().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_下肢_左:
                    if (!取込解析結果.get失調不随意下肢().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意下肢().substring(1));
                    }
                    break;
                case 失調_不随意運動_体幹_右:
                    if (!取込解析結果.get失調不随意体幹().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意体幹().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_体幹_左:
                    if (!取込解析結果.get失調不随意体幹().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意体幹().substring(1));
                    }
                    break;
                case じょくそう:
                    entity.setIkenItem(取込解析結果.get褥痩());
                    break;
                case じょくそう_程度:
                    entity.setIkenItem(取込解析結果.get褥痩程度());
                    break;
                case その他の皮膚疾患:
                    entity.setIkenItem(取込解析結果.getその他皮膚疾患());
                    break;
                case その他の皮膚疾患_程度:
                    entity.setIkenItem(取込解析結果.getその他皮膚疾患程度());
                    break;
                case 屋外歩行:
                    entity.setIkenItem(取込解析結果.get屋外歩行());
                    break;
                case 車いすの使用:
                    entity.setIkenItem(取込解析結果.get車いすの使用());
                    break;
                case 歩行補助具_装具の使用_用いていない:
                    if (!取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get歩行補助具装具の使用().substring(0, 1));
                    }
                    break;
                case 歩行補助具_装具の使用_屋外で使用:
                    if (!取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get歩行補助具装具の使用().substring(1, 2));
                    }
                    break;
                case 歩行補助具_装具の使用_屋内で使用:
                    if (!取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get歩行補助具装具の使用().substring(2));
                    }
                    break;
                case 食事行為:
                    entity.setIkenItem(取込解析結果.get食事行為());
                    break;
                case 現在の栄養状態:
                    entity.setIkenItem(取込解析結果.get現在の栄養状況());
                    break;
                case 尿失禁:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(0, 1));
                    }
                    break;
                case 転倒_骨折:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(1, 2));
                    }
                    break;
                case 移動能力の低下:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(2, 3));
                    }
                    break;
                case 褥瘡:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(3, 4));
                    }
                    break;
                case 心肺機能の低下:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(4, 5));
                    }
                    break;
                case 閉じこもり:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(5, 6));
                    }
                    break;
                case 意欲低下:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(6, 7));
                    }
                    break;
                case 徘徊_可能性が高い病態:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(7, 8));
                    }
                    break;
                case 低栄養:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(8, 9));
                    }
                    break;
                case 摂食_嚥下機能低下:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(9, 10));
                    }
                    break;
                case 脱水:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(10, 11));
                    }
                    break;
                case 易感染性:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(11, 12));
                    }
                    break;
                case がん等による疼痛:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(12, 13));
                    }
                    break;
                case 病態_その他:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(13));
                    }
                    break;
                case 生活機能の維持_改善の見通し:
                    entity.setIkenItem(取込解析結果.get予後の見通し());
                    break;
                case 訪問診療:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(0, 1));
                    }
                    break;
                case 訪問診療_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(0, 1));
                    }
                    break;
                case 訪問看護:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(1, 2));
                    }
                    break;
                case 訪問看護_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(1, 2));
                    }
                    break;
                case 看護職員による相談:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(2, 3));
                    }
                    break;
                case 看護職員による相談_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(2, 3));
                    }
                    break;
                case 訪問歯科診療:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(3, 4));
                    }
                    break;
                case 訪問歯科診療_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(3, 4));
                    }
                    break;
                case 訪問薬剤管理指導:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(4, 5));
                    }
                    break;
                case 訪問薬剤管理指導_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(4, 5));
                    }
                    break;
                case 訪問リハビリテーション:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(5, 6));
                    }
                    break;
                case 訪問リハビリテーション_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(5, 6));
                    }
                    break;
                case 短期入所療養介護:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(6, 7));
                    }
                    break;
                case 短期入所療養介護_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(6, 7));
                    }
                    break;
                case 訪問歯科衛生指導:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(7, 8));
                    }
                    break;
                case 訪問歯科衛生指導_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(7, 8));
                    }
                    break;
                case 訪問栄養食事指導:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(8, 9));
                    }
                    break;
                case 訪問栄養食事指導_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(8, 9));
                    }
                    break;
                case 通所リハビリテーション:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(9, 10));
                    }
                    break;
                case 通所リハビリテーション_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(9, 10));
                    }
                    break;
                case その他の医療系のサービス:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(10));
                    }
                    break;
                case その他の医療系のサービス_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(10));
                    }
                    break;
                case 介護サービスの留意事項_血圧:
                    entity.setIkenItem(取込解析結果.get血圧());
                    break;
                case 介護サービスの留意事項_移動:
                    entity.setIkenItem(取込解析結果.get移動());
                    break;
                case 介護サービスの留意事項_摂食:
                    entity.setIkenItem(取込解析結果.get摂食());
                    break;
                case 介護サービスの留意事項_運動:
                    entity.setIkenItem(取込解析結果.get運動());
                    break;
                case 介護サービスの留意事項_嚥下:
                    entity.setIkenItem(取込解析結果.get嚥下());
                    break;
                case 感染症の有無:
                    entity.setIkenItem(取込解析結果.get感染症());
                    break;
            }
            entitys.add(entity);
        }
        return entitys;
    }

    private List<DbT5303ShujiiIkenshoKinyuItemEntity> 新規追加_DbT5303_要介護認定主治医意見書記入項目(ImageinputResult ir, ImageInputReadResult 取込解析結果) {
        List<DbT5303ShujiiIkenshoKinyuItemEntity> entitys = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            DbT5303ShujiiIkenshoKinyuItemEntity entity = new DbT5303ShujiiIkenshoKinyuItemEntity();
            entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
            entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
            entity.setRemban(i);
            entity.setKoroshoIfShikibetsuCode(new Code(ir.getT5101_厚労省IF識別コード()));
            switch (IkenshoKinyuMapping09B.toValue(new RString(i))) {
                case その他:
                    //entity.setKinyuItem(取込解析結果.get);
                    break;
                case その他の精神_神経症状:
                    entity.setKinyuItem(取込解析結果.get精神神経症状());
                    break;
                case 専門医受診の有無:
                    entity.setKinyuItem(取込解析結果.get専門科医受診());
                    break;
                case 身長:
                    //entity.setKinyuItem(取込解析結果.get身長);
                    break;
                case 体重:
                    //entity.setKinyuItem(取込解析結果.get体重);
                    break;
                case 四肢欠損:
                    entity.setKinyuItem(取込解析結果.get四肢欠損());
                    break;
                case 麻痺_その他:
                    entity.setKinyuItem(取込解析結果.get麻痺その他());
                    break;
                case 筋力の低下:
                    entity.setKinyuItem(取込解析結果.get筋力低下());
                    break;
                case 関節の拘縮:
                    entity.setKinyuItem(取込解析結果.get間接の拘縮());
                    break;
                case 関節の痛み:
                    entity.setKinyuItem(取込解析結果.get間接の痛み());
                    break;
                case じょくそう:
                    entity.setKinyuItem(取込解析結果.get褥痩());
                    break;
                case その他の皮膚疾患:
                    entity.setKinyuItem(取込解析結果.getその他皮膚疾患());
                    break;
                case 栄養_食生活上の留意点:
                    //entity.setKinyuItem(取込解析結果.get栄養食生活上の留意点());
                    break;
                case 病態_その他:
                    entity.setKinyuItem(取込解析結果.get現在または今後発生の可能性の高い状態());
                    break;
                case 病態_対処方針:
                    //entity.setKinyuItem(取込解析結果.get対処方針());
                    break;
                case その他の医療系のサービス:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setKinyuItem(取込解析結果.get医学的管理の必要性チェック().substring(10, 11));
                    }
                    break;
                case 介護サービスの留意事項_血圧:
                    entity.setKinyuItem(取込解析結果.get血圧());
                    break;
                case 介護サービスの留意事項_移動:
                    entity.setKinyuItem(取込解析結果.get移動());
                    break;
                case 介護サービスの留意事項_摂食:
                    entity.setKinyuItem(取込解析結果.get摂食());
                    break;
                case 介護サービスの留意事項_運動:
                    entity.setKinyuItem(取込解析結果.get運動());
                    break;
                case 介護サービスの留意事項_嚥下:
                    entity.setKinyuItem(取込解析結果.get嚥下());
                    break;
                case 介護サービスの留意事項_その他:
                    //entity.setKinyuItem(取込解析結果.get介護サービスの留意事項());
                    break;
                case 感染症の有無:
                    entity.setKinyuItem(取込解析結果.get感染症());
                    break;
            }
            entitys.add(entity);
        }
        return entitys;
    }

    private DbT5302ShujiiIkenshoJohoEntity 新規追加_DbT5302_要介護認定主治医意見書情報(ImageinputResult ir, ImageInputReadResult 取込解析結果) {
        DbT5302ShujiiIkenshoJohoEntity entity = new DbT5302ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
        entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(ir.getT5101_厚労省IF識別コード());
        entity.setIkenshoIraiKubun(ir.getT5301_主治医意見書依頼区分());
        entity.setShujiiIryoKikanCode(ir.getT5301_主治医医療機関コード());
        entity.setShujiiCode(ir.getT5301_主治医コード());
        entity.setIkenshoJuryoYMD(FlexibleDate.getNowDate());
        entity.setIkenshoKinyuYMD(new FlexibleDate(取込解析結果.get記入日()));
        entity.setIkenshoReadYMD(FlexibleDate.getNowDate());
        entity.setIkenshoSakuseiKaisuKubun(new Code(取込解析結果.get意見書作成回数()));
        if (ir.isT5101_施設入所の有無()) {
            entity.setZaitakuShisetsuKubun(new Code(ZaitakuShisetsuKubun.施設.getコード()));
        } else {
            entity.setZaitakuShisetsuKubun(new Code(ZaitakuShisetsuKubun.在宅.getコード()));
        }
        entity.setIkenshoDoiFlag(フラグ変換_RStringToBoolean(取込解析結果.get同意の有無()));
        entity.setSaishuShinryoYMD(new FlexibleDate(取込解析結果.get最終診察日()));
        entity.setExistTakaJushinFlag(フラグ変換_RStringToBoolean(取込解析結果.get他科受診の有無()));
        edit受診中の他科項目(entity, 取込解析結果);
        entity.setSonotaJushinKaMei(RString.EMPTY);
        entity.setShindamMei1(RString.EMPTY);
        entity.setHasshoYMD1(取込解析結果.get発症年月日１());
        entity.setShindamMei2(RString.EMPTY);
        entity.setHasshoYMD2(取込解析結果.get発症年月日２());
        entity.setShindamMei3(RString.EMPTY);
        entity.setHasshoYMD3(取込解析結果.get発症年月日３());
        entity.setAnteisei(取込解析結果.get症状の安定性());
        entity.setFuanteiJokyo(RString.EMPTY);
        entity.setChiryoNaiyo(RString.EMPTY);
        entity.setTokkiJiko(RString.EMPTY);
        entity.setNijiHanteiKekkaRenrakuFlag(フラグ変換_RStringToBoolean(取込解析結果.get主治医への結果連絡()));
        entity.setIkenshoMemo(RString.EMPTY);
        return entity;
    }

    private DbT5302ShujiiIkenshoJohoEntity データ更新_DbT5302_要介護認定主治医意見書情報(ImageinputResult ir, ImageInputReadResult 取込解析結果) {
        DbT5302ShujiiIkenshoJohoEntity entity = ir.getT5302_主治医意見書情報().get(0);
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
        entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
        entity.setIkenshoKinyuYMD(new FlexibleDate(取込解析結果.get記入日()));
        entity.setIkenshoSakuseiKaisuKubun(new Code(取込解析結果.get意見書作成回数()));
        if (ir.isT5101_施設入所の有無()) {
            entity.setZaitakuShisetsuKubun(new Code(ZaitakuShisetsuKubun.施設.getコード()));
        } else {
            entity.setZaitakuShisetsuKubun(new Code(ZaitakuShisetsuKubun.在宅.getコード()));
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
        return entity;
    }

    private List<DbT5303ShujiiIkenshoKinyuItemEntity> データ更新_DbT5303_要介護認定主治医意見書記入項目(ImageinputResult ir, ImageInputReadResult 取込解析結果) {
        ShujiiIkenshoKinyuItemManager manager_DbT5303 = new ShujiiIkenshoKinyuItemManager();

        List<DbT5303ShujiiIkenshoKinyuItemEntity> entitys = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            DbT5303ShujiiIkenshoKinyuItemEntity entity = manager_DbT5303.select主治医意見書(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()), ir.getT5301_主治医意見書作成依頼履歴番号(), i);
            entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
            entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
            entity.setRemban(i);
            switch (IkenshoKinyuMapping09B.toValue(new RString(i))) {
                case その他:
                    //entity.setKinyuItem(取込解析結果.get);
                    break;
                case その他の精神_神経症状:
                    entity.setKinyuItem(取込解析結果.get精神神経症状());
                    break;
                case 専門医受診の有無:
                    entity.setKinyuItem(取込解析結果.get専門科医受診());
                    break;
                case 身長:
                    //entity.setKinyuItem(取込解析結果.get身長);
                    break;
                case 体重:
                    //entity.setKinyuItem(取込解析結果.get体重);
                    break;
                case 四肢欠損:
                    entity.setKinyuItem(取込解析結果.get四肢欠損());
                    break;
                case 麻痺_その他:
                    entity.setKinyuItem(取込解析結果.get麻痺その他());
                    break;
                case 筋力の低下:
                    entity.setKinyuItem(取込解析結果.get筋力低下());
                    break;
                case 関節の拘縮:
                    entity.setKinyuItem(取込解析結果.get間接の拘縮());
                    break;
                case 関節の痛み:
                    entity.setKinyuItem(取込解析結果.get間接の痛み());
                    break;
                case じょくそう:
                    entity.setKinyuItem(取込解析結果.get褥痩());
                    break;
                case その他の皮膚疾患:
                    entity.setKinyuItem(取込解析結果.getその他皮膚疾患());
                    break;
                case 栄養_食生活上の留意点:
                    //entity.setKinyuItem(取込解析結果.get栄養食生活上の留意点());
                    break;
                case 病態_その他:
                    entity.setKinyuItem(取込解析結果.get現在または今後発生の可能性の高い状態());
                    break;
                case 病態_対処方針:
                    //entity.setKinyuItem(取込解析結果.get対処方針());
                    break;
                case その他の医療系のサービス:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setKinyuItem(取込解析結果.get医学的管理の必要性チェック().substring(10, 11));
                    }
                    break;
                case 介護サービスの留意事項_血圧:
                    entity.setKinyuItem(取込解析結果.get血圧());
                    break;
                case 介護サービスの留意事項_移動:
                    entity.setKinyuItem(取込解析結果.get移動());
                    break;
                case 介護サービスの留意事項_摂食:
                    entity.setKinyuItem(取込解析結果.get摂食());
                    break;
                case 介護サービスの留意事項_運動:
                    entity.setKinyuItem(取込解析結果.get運動());
                    break;
                case 介護サービスの留意事項_嚥下:
                    entity.setKinyuItem(取込解析結果.get嚥下());
                    break;
                case 介護サービスの留意事項_その他:
                    //entity.setKinyuItem(取込解析結果.get介護サービスの留意事項());
                    break;
                case 感染症の有無:
                    entity.setKinyuItem(取込解析結果.get感染症());
                    break;
            }
            entitys.add(entity);
        }
        return entitys;
    }

    private List<DbT5304ShujiiIkenshoIkenItemEntity> データ更新_DbT5304_要介護認定主治医意見書意見項目(ImageinputResult ir, ImageInputReadResult 取込解析結果) {

        ShujiiIkenshoIkenItemNewManager manager_DbT5304 = new ShujiiIkenshoIkenItemNewManager();
        List<DbT5304ShujiiIkenshoIkenItemEntity> entitys = new ArrayList<>();
        for (int i = 1; i <= 113; i++) {
            DbT5304ShujiiIkenshoIkenItemEntity entity = manager_DbT5304.select主治医意見書(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()), ir.getT5301_主治医意見書作成依頼履歴番号(), i);
            entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
            entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
            entity.setRemban(i);
            entity.setIkenItem(RString.EMPTY);
            switch (IkenshoKomokuMapping09B.toValue(new RString(i))) {
                case 点滴の管理:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(0, 1));
                    }
                    break;
                case ストーマの処置:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(1, 2));
                    }
                    break;
                case 気管切開の処置:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(2, 3));
                    }
                    break;
                case 中心静脈栄養:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(3, 4));
                    }
                    break;
                case 酸素療法:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(4, 5));
                    }
                    break;
                case 疼痛の看護:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(5, 6));
                    }
                    break;
                case 透析:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(6, 7));
                    }
                    break;
                case レスピレーター:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(7, 8));
                    }
                    break;
                case 経管栄養:
                    if (!取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get処置内容().substring(8));
                    }
                    break;
                case モニター測定:
                    if (!取込解析結果.get特別な対応().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get特別な対応().substring(0, 1));
                    }
                    break;
                case じょくそうの処置:
                    if (!取込解析結果.get特別な対応().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get特別な対応().substring(1));
                    }
                    break;
                case カテーテル:
                    entity.setIkenItem(取込解析結果.getカテーテル());
                    break;
                case 寝たきり度:
                    entity.setIkenItem(取込解析結果.get障害高齢者の自立度());
                    break;
                case 認知症高齢者の日常生活自立度:
                    entity.setIkenItem(取込解析結果.get認知症高齢者の自立度());
                    break;
                case 短期記憶:
                    entity.setIkenItem(取込解析結果.get短期記憶());
                    break;
                case 認知能力:
                    entity.setIkenItem(取込解析結果.get認知能力());
                    break;
                case 伝達能力:
                    entity.setIkenItem(取込解析結果.get伝達能力());
                    break;
                case 認知症の周辺症状:
                    entity.setIkenItem(取込解析結果.get問題行動の有無());
                    break;
                case 幻視_幻聴:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(0, 1));
                    }
                    break;
                case 火の不始末:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(1, 2));
                    }
                    break;
                case 妄想:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(2, 3));
                    }
                    break;
                case 不潔行為:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(3, 4));
                    }
                    break;
                case 昼夜逆転:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(4, 5));
                    }
                    break;
                case 異食行動:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(5, 6));
                    }
                    break;
                case 暴言:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(6, 7));
                    }
                    break;
                case 性的問題行動:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(7, 8));
                    }
                    break;
                case 暴行:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(8, 9));
                    }
                    break;
                case その他:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(9, 10));
                    }
                    break;
                case 介護への抵抗:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(10, 11));
                    }
                    break;
                case 徘徊_認知症の周辺症状:
                    if (!取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get問題行動().substring(11));
                    }
                    break;
                case その他の精神_神経症状:
                    entity.setIkenItem(取込解析結果.get精神神経症状());
                    break;
                case 専門医受診の有無:
                    entity.setIkenItem(取込解析結果.get専門科医受診());
                    break;
                case 利き腕:
                    entity.setIkenItem(取込解析結果.get利き腕());
                    break;
                case 過去6カ月の体重の変化:
                    entity.setIkenItem(取込解析結果.get過去6ヶ月間の体重の変化());
                    break;
                case 四肢欠損:
                    entity.setIkenItem(取込解析結果.get四肢欠損());
                    break;
                case 麻痺:
                    entity.setIkenItem(取込解析結果.get麻痺());
                    break;
                case 麻痺_右上肢:
                    entity.setIkenItem(取込解析結果.get麻痺右上肢());
                    break;
                case 麻痺_右上肢_程度:
                    entity.setIkenItem(取込解析結果.get麻痺右上肢程度());
                    break;
                case 麻痺_左上肢:
                    entity.setIkenItem(取込解析結果.get麻痺左上肢());
                    break;
                case 麻痺_左上肢_程度:
                    entity.setIkenItem(取込解析結果.get麻痺左上肢程度());
                    break;
                case 麻痺_右下肢:
                    entity.setIkenItem(取込解析結果.get麻痺右下肢());
                    break;
                case 麻痺_右下肢_程度:
                    entity.setIkenItem(取込解析結果.get麻痺右下肢程度());
                    break;
                case 麻痺_左下肢:
                    entity.setIkenItem(取込解析結果.get麻痺左下肢());
                    break;
                case 麻痺_左下肢_程度:
                    entity.setIkenItem(取込解析結果.get麻痺左下肢程度());
                    break;
                case 麻痺_その他:
                    entity.setIkenItem(取込解析結果.get麻痺その他());
                    break;
                case 麻痺_その他_程度:
                    entity.setIkenItem(取込解析結果.get麻痺その他程度());
                    break;
                case 筋力の低下:
                    entity.setIkenItem(取込解析結果.get筋力低下());
                    break;
                case 筋力の低下_程度:
                    entity.setIkenItem(取込解析結果.get筋力低下程度());
                    break;
                case 関節の拘縮:
                    entity.setIkenItem(取込解析結果.get間接の拘縮());
                    break;
                case 関節の拘縮_程度:
                    entity.setIkenItem(取込解析結果.get間接の拘縮程度());
                    break;
                case 関節の痛み:
                    entity.setIkenItem(取込解析結果.get間接の痛み());
                    break;
                case 関節の痛み_程度:
                    entity.setIkenItem(取込解析結果.get間接の痛み程度());
                    break;
                case 失調_不随意運動:
                    entity.setIkenItem(取込解析結果.get失調不随意運動());
                    break;
                case 失調_不随意運動_上肢_右:
                    if (!取込解析結果.get失調不随意上肢().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意上肢().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_上肢_左:
                    if (!取込解析結果.get失調不随意上肢().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意上肢().substring(1));
                    }
                    break;
                case 失調_不随意運動_下肢_右:
                    if (!取込解析結果.get失調不随意下肢().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意下肢().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_下肢_左:
                    if (!取込解析結果.get失調不随意下肢().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意下肢().substring(1));
                    }
                    break;
                case 失調_不随意運動_体幹_右:
                    if (!取込解析結果.get失調不随意体幹().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意体幹().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_体幹_左:
                    if (!取込解析結果.get失調不随意体幹().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get失調不随意体幹().substring(1));
                    }
                    break;
                case じょくそう:
                    entity.setIkenItem(取込解析結果.get褥痩());
                    break;
                case じょくそう_程度:
                    entity.setIkenItem(取込解析結果.get褥痩程度());
                    break;
                case その他の皮膚疾患:
                    entity.setIkenItem(取込解析結果.getその他皮膚疾患());
                    break;
                case その他の皮膚疾患_程度:
                    entity.setIkenItem(取込解析結果.getその他皮膚疾患程度());
                    break;
                case 屋外歩行:
                    entity.setIkenItem(取込解析結果.get屋外歩行());
                    break;
                case 車いすの使用:
                    entity.setIkenItem(取込解析結果.get車いすの使用());
                    break;
                case 歩行補助具_装具の使用_用いていない:
                    if (!取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get歩行補助具装具の使用().substring(0, 1));
                    }
                    break;
                case 歩行補助具_装具の使用_屋外で使用:
                    if (!取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get歩行補助具装具の使用().substring(1, 2));
                    }
                    break;
                case 歩行補助具_装具の使用_屋内で使用:
                    if (!取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get歩行補助具装具の使用().substring(2));
                    }
                    break;
                case 食事行為:
                    entity.setIkenItem(取込解析結果.get食事行為());
                    break;
                case 現在の栄養状態:
                    entity.setIkenItem(取込解析結果.get現在の栄養状況());
                    break;
                case 尿失禁:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(0, 1));
                    }
                    break;
                case 転倒_骨折:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(1, 2));
                    }
                    break;
                case 移動能力の低下:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(2, 3));
                    }
                    break;
                case 褥瘡:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(3, 4));
                    }
                    break;
                case 心肺機能の低下:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(4, 5));
                    }
                    break;
                case 閉じこもり:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(5, 6));
                    }
                    break;
                case 意欲低下:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(6, 7));
                    }
                    break;
                case 徘徊_可能性が高い病態:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(7, 8));
                    }
                    break;
                case 低栄養:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(8, 9));
                    }
                    break;
                case 摂食_嚥下機能低下:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(9, 10));
                    }
                    break;
                case 脱水:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(10, 11));
                    }
                    break;
                case 易感染性:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(11, 12));
                    }
                    break;
                case がん等による疼痛:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(12, 13));
                    }
                    break;
                case 病態_その他:
                    if (!取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get現在または今後発生の可能性の高い状態().substring(13));
                    }
                    break;
                case 生活機能の維持_改善の見通し:
                    entity.setIkenItem(取込解析結果.get予後の見通し());
                    break;
                case 訪問診療:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(0, 1));
                    }
                    break;
                case 訪問診療_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(0, 1));
                    }
                    break;
                case 訪問看護:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(1, 2));
                    }
                    break;
                case 訪問看護_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(1, 2));
                    }
                    break;
                case 看護職員による相談:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(2, 3));
                    }
                    break;
                case 看護職員による相談_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(2, 3));
                    }
                    break;
                case 訪問歯科診療:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(3, 4));
                    }
                    break;
                case 訪問歯科診療_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(3, 4));
                    }
                    break;
                case 訪問薬剤管理指導:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(4, 5));
                    }
                    break;
                case 訪問薬剤管理指導_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(4, 5));
                    }
                    break;
                case 訪問リハビリテーション:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(5, 6));
                    }
                    break;
                case 訪問リハビリテーション_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(5, 6));
                    }
                    break;
                case 短期入所療養介護:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(6, 7));
                    }
                    break;
                case 短期入所療養介護_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(6, 7));
                    }
                    break;
                case 訪問歯科衛生指導:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(7, 8));
                    }
                    break;
                case 訪問歯科衛生指導_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(7, 8));
                    }
                    break;
                case 訪問栄養食事指導:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(8, 9));
                    }
                    break;
                case 訪問栄養食事指導_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(8, 9));
                    }
                    break;
                case 通所リハビリテーション:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(9, 10));
                    }
                    break;
                case 通所リハビリテーション_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(9, 10));
                    }
                    break;
                case その他の医療系のサービス:
                    if (!取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性チェック().substring(10));
                    }
                    break;
                case その他の医療系のサービス_必要性:
                    if (!取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(取込解析結果.get医学的管理の必要性下線().substring(10));
                    }
                    break;
                case 介護サービスの留意事項_血圧:
                    entity.setIkenItem(取込解析結果.get血圧());
                    break;
                case 介護サービスの留意事項_移動:
                    entity.setIkenItem(取込解析結果.get移動());
                    break;
                case 介護サービスの留意事項_摂食:
                    entity.setIkenItem(取込解析結果.get摂食());
                    break;
                case 介護サービスの留意事項_運動:
                    entity.setIkenItem(取込解析結果.get運動());
                    break;
                case 介護サービスの留意事項_嚥下:
                    entity.setIkenItem(取込解析結果.get嚥下());
                    break;
                case 感染症の有無:
                    entity.setIkenItem(取込解析結果.get感染症());
                    break;
            }
            entitys.add(entity);
        }
        return entitys;
    }

    private void edit受診中の他科項目(DbT5302ShujiiIkenshoJohoEntity entity, ImageInputReadResult 取込解析結果) {
        if (!取込解析結果.get記入のあった科().isEmpty()) {
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
    }
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

    private boolean フラグ変換_RStringToBoolean(RString target) {
        return target.equals(new RString("1"));
    }
}
