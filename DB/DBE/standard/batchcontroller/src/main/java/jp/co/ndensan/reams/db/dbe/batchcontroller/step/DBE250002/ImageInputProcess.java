/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageInputReadResult;
import jp.co.ndensan.reams.db.dbe.business.core.imageinput.ImageinputResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe250002.OcrImageReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.imageinput.OcrJohoOcrImageEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoIkenItemNewManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.ShujiiIkenshoJohoManager;
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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.CopyToSharedFileOpts;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileDescriptor;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.SharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n2818
 */
public class ImageInputProcess extends BatchProcessBase<RString> {

    private OcrImageReadProcessParameter processParameter;
    private long 読取中行番号;
    private ImageInputReadResult イメージ取込解析結果 = new ImageInputReadResult();
    private static final RString 意見書_表 = new RString("701");
    private static final RString 意見書_裏 = new RString("702");
    private static final RString 意見書_ID777 = new RString("777");
    private static final RString 意見書_ID778 = new RString("778");

    private ShujiiIkenshoJohoManager manager_DbT5302;
    private ShujiiIkenshoKinyuItemManager manager_DbT5303;
    private ShujiiIkenshoIkenItemNewManager manager_DbT5304;

    @BatchWriter
    private BatchPermanentTableWriter<DbT5302ShujiiIkenshoJohoEntity> writer_DbT5302;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5303ShujiiIkenshoKinyuItemEntity> writer_DbT5303;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5304ShujiiIkenshoIkenItemEntity> writer_DbT5304;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writer_DbT5115;

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
        if (!processParameter.getファイルPath().contains(".png")) {
            イメージ取込解析結果.clear();
            読取中行番号++;
            イメージ取込解析結果.parse(line, 読取中行番号);

            イメージ取込解析結果 = this.チェック処理(イメージ取込解析結果);

            ImageinputMapperParamter imp = ImageinputMapperParamter.createParamter(イメージ取込解析結果.get保険者番号(),
                    イメージ取込解析結果.get被保険者番号(),
                    イメージ取込解析結果.get申請日());

            List<ImageinputResult> 関連データList_ = ImageinputFindler.createInstance().get関連データ(imp).records();
            for (ImageinputResult ir : 関連データList_) {
                if (ir.getT5115_イメージ共有ファイルID().compareTo(RDateTime.MIN) == 0) {
                    writer_DbT5302.insert(新規追加_DbT5302_要介護認定主治医意見書情報(ir));
                    for (DbT5303ShujiiIkenshoKinyuItemEntity entity : 新規追加_DbT5303_要介護認定主治医意見書記入項目(ir)) {
                        writer_DbT5303.insert(entity);
                    }
                    for (DbT5304ShujiiIkenshoIkenItemEntity entity : 新規追加_DbT5304_要介護認定主治医意見書意見項目(ir)) {
                        writer_DbT5304.insert(entity);
                    }
                } else {
                    writer_DbT5302.update(データ更新_DbT5302_要介護認定主治医意見書情報(ir));
                    for (DbT5303ShujiiIkenshoKinyuItemEntity entity : データ更新_DbT5303_要介護認定主治医意見書記入項目(ir)) {
                        writer_DbT5303.update(entity);
                    }
                    for (DbT5304ShujiiIkenshoIkenItemEntity entity : データ更新_DbT5304_要介護認定主治医意見書意見項目(ir)) {
                        writer_DbT5304.update(entity);
                    }
                }

                List<RString> imageList = new ArrayList<>();

                if (ir.getT5115_イメージ共有ファイルID().compareTo(RDateTime.MIN) == 0) {
                    SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName
                            .fromString(イメージ取込解析結果.get保険者番号().concat(イメージ取込解析結果.get被保険者番号())));
                    sfd = SharedFile.defineSharedFile(sfd);
                    CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
                    SharedFileEntryDescriptor entity = SharedFile.copyToSharedFile(sfd, new FilesystemPath(processParameter.getファイルPath()), opts);
                    DbT5115ImageEntity entityImage = new DbT5115ImageEntity();
                    entityImage.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
                    entityImage.setImageSharedFileId(entity.getSharedFileId());
                    writer_DbT5115.insert(entityImage);
                } else {
                    imageList = processParameter.getファイルList();
                    if (imageList != null) {
                        for (int j = 0; j < imageList.size(); j++) {
                            ReadOnlySharedFileEntryDescriptor or_sfd = new ReadOnlySharedFileEntryDescriptor(FilesystemName
                                    .fromString(イメージ取込解析結果.get保険者番号().concat(イメージ取込解析結果.get被保険者番号())), ir.getT5115_イメージ共有ファイルID());
                            SharedFile.appendNewFile(or_sfd, new FilesystemPath(processParameter.getファイルPathList().get(j)), imageList.get(j).toString());
                        }
                    }
                }
            }
        }
    }

    private List<DbT5304ShujiiIkenshoIkenItemEntity> 新規追加_DbT5304_要介護認定主治医意見書意見項目(ImageinputResult ir)
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
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(0, 1));
                    }
                    break;
                case ストーマの処置:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(1, 2));
                    }
                    break;
                case 気管切開の処置:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(2, 3));
                    }
                    break;
                case 中心静脈栄養:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(3, 4));
                    }
                    break;
                case 酸素療法:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(4, 5));
                    }
                    break;
                case 疼痛の看護:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(5, 6));
                    }
                    break;
                case 透析:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(6, 7));
                    }
                    break;
                case レスピレーター:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(7, 8));
                    }
                    break;
                case 経管栄養:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(8));
                    }
                    break;
                case モニター測定:
                    if (!イメージ取込解析結果.get特別な対応().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get特別な対応().substring(0, 1));
                    }
                    break;
                case じょくそうの処置:
                    if (!イメージ取込解析結果.get特別な対応().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get特別な対応().substring(1));
                    }
                    break;
                case カテーテル:
                    entity.setIkenItem(イメージ取込解析結果.getカテーテル());
                    break;
                case 寝たきり度:
                    entity.setIkenItem(イメージ取込解析結果.get障害高齢者の自立度());
                    break;
                case 認知症高齢者の日常生活自立度:
                    entity.setIkenItem(イメージ取込解析結果.get認知症高齢者の自立度());
                    break;
                case 短期記憶:
                    entity.setIkenItem(イメージ取込解析結果.get短期記憶());
                    break;
                case 認知能力:
                    entity.setIkenItem(イメージ取込解析結果.get認知能力());
                    break;
                case 伝達能力:
                    entity.setIkenItem(イメージ取込解析結果.get伝達能力());
                    break;
                case 認知症の周辺症状:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動の有無());
                    break;
                case 幻視_幻聴:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(0, 1));
                    }
                    break;
                case 火の不始末:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(1, 2));
                    }
                    break;
                case 妄想:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(2, 3));
                    }
                    break;
                case 不潔行為:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(3, 4));
                    }
                    break;
                case 昼夜逆転:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(4, 5));
                    }
                    break;
                case 異食行動:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(5, 6));
                    }
                    break;
                case 暴言:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(6, 7));
                    }
                    break;
                case 性的問題行動:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(7, 8));
                    }
                    break;
                case 暴行:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(8, 9));
                    }
                    break;
                case その他:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(9, 10));
                    }
                    break;
                case 介護への抵抗:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(10, 11));
                    }
                    break;
                case 徘徊_認知症の周辺症状:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(11));
                    }
                    break;
                case その他の精神_神経症状:
                    entity.setIkenItem(イメージ取込解析結果.get精神神経症状());
                    break;
                case 専門医受診の有無:
                    entity.setIkenItem(イメージ取込解析結果.get専門科医受診());
                    break;
                case 利き腕:
                    entity.setIkenItem(イメージ取込解析結果.get利き腕());
                    break;
                case 過去6カ月の体重の変化:
                    entity.setIkenItem(イメージ取込解析結果.get過去6ヶ月間の体重の変化());
                    break;
                case 四肢欠損:
                    entity.setIkenItem(イメージ取込解析結果.get四肢欠損());
                    break;
                case 麻痺:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺());
                    break;
                case 麻痺_右上肢:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺右上肢());
                    break;
                case 麻痺_右上肢_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺右上肢程度());
                    break;
                case 麻痺_左上肢:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺左上肢());
                    break;
                case 麻痺_左上肢_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺左上肢程度());
                    break;
                case 麻痺_右下肢:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺右下肢());
                    break;
                case 麻痺_右下肢_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺右下肢程度());
                    break;
                case 麻痺_左下肢:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺左下肢());
                    break;
                case 麻痺_左下肢_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺左下肢程度());
                    break;
                case 麻痺_その他:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺その他());
                    break;
                case 麻痺_その他_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺その他程度());
                    break;
                case 筋力の低下:
                    entity.setIkenItem(イメージ取込解析結果.get筋力低下());
                    break;
                case 筋力の低下_程度:
                    entity.setIkenItem(イメージ取込解析結果.get筋力低下程度());
                    break;
                case 関節の拘縮:
                    entity.setIkenItem(イメージ取込解析結果.get間接の拘縮());
                    break;
                case 関節の拘縮_程度:
                    entity.setIkenItem(イメージ取込解析結果.get間接の拘縮程度());
                    break;
                case 関節の痛み:
                    entity.setIkenItem(イメージ取込解析結果.get間接の痛み());
                    break;
                case 関節の痛み_程度:
                    entity.setIkenItem(イメージ取込解析結果.get間接の痛み程度());
                    break;
                case 失調_不随意運動:
                    entity.setIkenItem(イメージ取込解析結果.get失調不随意運動());
                    break;
                case 失調_不随意運動_上肢_右:
                    if (!イメージ取込解析結果.get失調不随意上肢().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意上肢().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_上肢_左:
                    if (!イメージ取込解析結果.get失調不随意上肢().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意上肢().substring(1));
                    }
                    break;
                case 失調_不随意運動_下肢_右:
                    if (!イメージ取込解析結果.get失調不随意下肢().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意下肢().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_下肢_左:
                    if (!イメージ取込解析結果.get失調不随意下肢().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意下肢().substring(1));
                    }
                    break;
                case 失調_不随意運動_体幹_右:
                    if (!イメージ取込解析結果.get失調不随意体幹().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意体幹().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_体幹_左:
                    if (!イメージ取込解析結果.get失調不随意体幹().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意体幹().substring(1));
                    }
                    break;
                case じょくそう:
                    entity.setIkenItem(イメージ取込解析結果.get褥痩());
                    break;
                case じょくそう_程度:
                    entity.setIkenItem(イメージ取込解析結果.get褥痩程度());
                    break;
                case その他の皮膚疾患:
                    entity.setIkenItem(イメージ取込解析結果.getその他皮膚疾患());
                    break;
                case その他の皮膚疾患_程度:
                    entity.setIkenItem(イメージ取込解析結果.getその他皮膚疾患程度());
                    break;
                case 屋外歩行:
                    entity.setIkenItem(イメージ取込解析結果.get屋外歩行());
                    break;
                case 車いすの使用:
                    entity.setIkenItem(イメージ取込解析結果.get車いすの使用());
                    break;
                case 歩行補助具_装具の使用_用いていない:
                    if (!イメージ取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get歩行補助具装具の使用().substring(0, 1));
                    }
                    break;
                case 歩行補助具_装具の使用_屋外で使用:
                    if (!イメージ取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get歩行補助具装具の使用().substring(1, 2));
                    }
                    break;
                case 歩行補助具_装具の使用_屋内で使用:
                    if (!イメージ取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get歩行補助具装具の使用().substring(2));
                    }
                    break;
                case 食事行為:
                    entity.setIkenItem(イメージ取込解析結果.get食事行為());
                    break;
                case 現在の栄養状態:
                    entity.setIkenItem(イメージ取込解析結果.get現在の栄養状況());
                    break;
                case 尿失禁:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(0, 1));
                    }
                    break;
                case 転倒_骨折:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(1, 2));
                    }
                    break;
                case 移動能力の低下:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(2, 3));
                    }
                    break;
                case 褥瘡:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(3, 4));
                    }
                    break;
                case 心肺機能の低下:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(4, 5));
                    }
                    break;
                case 閉じこもり:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(5, 6));
                    }
                    break;
                case 意欲低下:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(6, 7));
                    }
                    break;
                case 徘徊_可能性が高い病態:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(7, 8));
                    }
                    break;
                case 低栄養:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(8, 9));
                    }
                    break;
                case 摂食_嚥下機能低下:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(9, 10));
                    }
                    break;
                case 脱水:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(10, 11));
                    }
                    break;
                case 易感染性:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(11, 12));
                    }
                    break;
                case がん等による疼痛:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(12, 13));
                    }
                    break;
                case 病態_その他:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(13));
                    }
                    break;
                case 生活機能の維持_改善の見通し:
                    entity.setIkenItem(イメージ取込解析結果.get予後の見通し());
                    break;
                case 訪問診療:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(0, 1));
                    }
                    break;
                case 訪問診療_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(0, 1));
                    }
                    break;
                case 訪問看護:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(1, 2));
                    }
                    break;
                case 訪問看護_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(1, 2));
                    }
                    break;
                case 看護職員による相談:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(2, 3));
                    }
                    break;
                case 看護職員による相談_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(2, 3));
                    }
                    break;
                case 訪問歯科診療:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(3, 4));
                    }
                    break;
                case 訪問歯科診療_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(3, 4));
                    }
                    break;
                case 訪問薬剤管理指導:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(4, 5));
                    }
                    break;
                case 訪問薬剤管理指導_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(4, 5));
                    }
                    break;
                case 訪問リハビリテーション:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(5, 6));
                    }
                    break;
                case 訪問リハビリテーション_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(5, 6));
                    }
                    break;
                case 短期入所療養介護:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(6, 7));
                    }
                    break;
                case 短期入所療養介護_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(6, 7));
                    }
                    break;
                case 訪問歯科衛生指導:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(7, 8));
                    }
                    break;
                case 訪問歯科衛生指導_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(7, 8));
                    }
                    break;
                case 訪問栄養食事指導:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(8, 9));
                    }
                    break;
                case 訪問栄養食事指導_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(8, 9));
                    }
                    break;
                case 通所リハビリテーション:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(9, 10));
                    }
                    break;
                case 通所リハビリテーション_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(9, 10));
                    }
                    break;
                case その他の医療系のサービス:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(10));
                    }
                    break;
                case その他の医療系のサービス_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(10));
                    }
                    break;
                case 介護サービスの留意事項_血圧:
                    entity.setIkenItem(イメージ取込解析結果.get血圧());
                    break;
                case 介護サービスの留意事項_移動:
                    entity.setIkenItem(イメージ取込解析結果.get移動());
                    break;
                case 介護サービスの留意事項_摂食:
                    entity.setIkenItem(イメージ取込解析結果.get摂食());
                    break;
                case 介護サービスの留意事項_運動:
                    entity.setIkenItem(イメージ取込解析結果.get運動());
                    break;
                case 介護サービスの留意事項_嚥下:
                    entity.setIkenItem(イメージ取込解析結果.get嚥下());
                    break;
                case 感染症の有無:
                    entity.setIkenItem(イメージ取込解析結果.get感染症());
                    break;
            }
            entitys.add(entity);
        }
        return entitys;
    }

    private List<DbT5303ShujiiIkenshoKinyuItemEntity> 新規追加_DbT5303_要介護認定主治医意見書記入項目(ImageinputResult ir) throws NullPointerException, IllegalArgumentException {
        List<DbT5303ShujiiIkenshoKinyuItemEntity> entitys = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            DbT5303ShujiiIkenshoKinyuItemEntity entity = new DbT5303ShujiiIkenshoKinyuItemEntity();
            entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
            entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
            entity.setRemban(i);
            entity.setKoroshoIfShikibetsuCode(new Code(ir.getT5101_厚労省IF識別コード()));
            switch (IkenshoKinyuMapping09B.toValue(new RString(i))) {
                case その他:
                    //entity.setKinyuItem(イメージ取込解析結果.get);
                    break;
                case その他の精神_神経症状:
                    entity.setKinyuItem(イメージ取込解析結果.get精神神経症状());
                    break;
                case 専門医受診の有無:
                    entity.setKinyuItem(イメージ取込解析結果.get専門科医受診());
                    break;
                case 身長:
                    //entity.setKinyuItem(イメージ取込解析結果.get身長);
                    break;
                case 体重:
                    //entity.setKinyuItem(イメージ取込解析結果.get体重);
                    break;
                case 四肢欠損:
                    entity.setKinyuItem(イメージ取込解析結果.get四肢欠損());
                    break;
                case 麻痺_その他:
                    entity.setKinyuItem(イメージ取込解析結果.get麻痺その他());
                    break;
                case 筋力の低下:
                    entity.setKinyuItem(イメージ取込解析結果.get筋力低下());
                    break;
                case 関節の拘縮:
                    entity.setKinyuItem(イメージ取込解析結果.get間接の拘縮());
                    break;
                case 関節の痛み:
                    entity.setKinyuItem(イメージ取込解析結果.get間接の痛み());
                    break;
                case じょくそう:
                    entity.setKinyuItem(イメージ取込解析結果.get褥痩());
                    break;
                case その他の皮膚疾患:
                    entity.setKinyuItem(イメージ取込解析結果.getその他皮膚疾患());
                    break;
                case 栄養_食生活上の留意点:
                    //entity.setKinyuItem(イメージ取込解析結果.get栄養食生活上の留意点());
                    break;
                case 病態_その他:
                    entity.setKinyuItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態());
                    break;
                case 病態_対処方針:
                    //entity.setKinyuItem(イメージ取込解析結果.get対処方針());
                    break;
                case その他の医療系のサービス:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setKinyuItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(10, 11));
                    }
                    break;
                case 介護サービスの留意事項_血圧:
                    entity.setKinyuItem(イメージ取込解析結果.get血圧());
                    break;
                case 介護サービスの留意事項_移動:
                    entity.setKinyuItem(イメージ取込解析結果.get移動());
                    break;
                case 介護サービスの留意事項_摂食:
                    entity.setKinyuItem(イメージ取込解析結果.get摂食());
                    break;
                case 介護サービスの留意事項_運動:
                    entity.setKinyuItem(イメージ取込解析結果.get運動());
                    break;
                case 介護サービスの留意事項_嚥下:
                    entity.setKinyuItem(イメージ取込解析結果.get嚥下());
                    break;
                case 介護サービスの留意事項_その他:
                    //entity.setKinyuItem(イメージ取込解析結果.get介護サービスの留意事項());
                    break;
                case 感染症の有無:
                    entity.setKinyuItem(イメージ取込解析結果.get感染症());
                    break;
            }
            entitys.add(entity);
        }
        return entitys;
    }

    private DbT5302ShujiiIkenshoJohoEntity 新規追加_DbT5302_要介護認定主治医意見書情報(ImageinputResult ir) throws IllegalArgumentException {
        DbT5302ShujiiIkenshoJohoEntity entity = new DbT5302ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
        entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
        entity.setKoroshoIfShikibetsuCode(ir.getT5101_厚労省IF識別コード());
        entity.setIkenshoIraiKubun(ir.getT5301_主治医意見書依頼区分());
        entity.setShujiiIryoKikanCode(ir.getT5301_主治医医療機関コード());
        entity.setShujiiCode(ir.getT5301_主治医コード());
        entity.setIkenshoJuryoYMD(FlexibleDate.getNowDate());
        entity.setIkenshoKinyuYMD(new FlexibleDate(イメージ取込解析結果.get記入日()));
        entity.setIkenshoReadYMD(FlexibleDate.getNowDate());
        entity.setIkenshoSakuseiKaisuKubun(new Code(イメージ取込解析結果.get意見書作成回数()));
        if (ir.isT5101_施設入所の有無()) {
            entity.setZaitakuShisetsuKubun(new Code(ZaitakuShisetsuKubun.施設.getコード()));
        } else {
            entity.setZaitakuShisetsuKubun(new Code(ZaitakuShisetsuKubun.在宅.getコード()));
        }
        entity.setIkenshoDoiFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get同意の有無()));
        entity.setSaishuShinryoYMD(new FlexibleDate(イメージ取込解析結果.get最終診察日()));
        entity.setExistTakaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get他科受診の有無()));
        edit受診中の他科項目(entity);
        entity.setSonotaJushinKaMei(RString.EMPTY);
        entity.setShindamMei1(RString.EMPTY);
        entity.setHasshoYMD1(イメージ取込解析結果.get発症年月日１());
        entity.setShindamMei2(RString.EMPTY);
        entity.setHasshoYMD2(イメージ取込解析結果.get発症年月日２());
        entity.setShindamMei3(RString.EMPTY);
        entity.setHasshoYMD3(イメージ取込解析結果.get発症年月日３());
        entity.setAnteisei(イメージ取込解析結果.get症状の安定性());
        entity.setFuanteiJokyo(RString.EMPTY);
        entity.setChiryoNaiyo(RString.EMPTY);
        entity.setTokkiJiko(RString.EMPTY);
        entity.setNijiHanteiKekkaRenrakuFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get主治医への結果連絡()));
        entity.setIkenshoMemo(RString.EMPTY);
        return entity;
    }

    private DbT5302ShujiiIkenshoJohoEntity データ更新_DbT5302_要介護認定主治医意見書情報(ImageinputResult ir) throws IllegalArgumentException {

        manager_DbT5302 = new ShujiiIkenshoJohoManager();
        DbT5302ShujiiIkenshoJohoEntity entity = manager_DbT5302.select主治医意見書(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()), ir.getT5301_主治医意見書作成依頼履歴番号());
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
        entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
        entity.setIkenshoKinyuYMD(new FlexibleDate(イメージ取込解析結果.get記入日()));
        entity.setIkenshoSakuseiKaisuKubun(new Code(イメージ取込解析結果.get意見書作成回数()));
        if (ir.isT5101_施設入所の有無()) {
            entity.setZaitakuShisetsuKubun(new Code(ZaitakuShisetsuKubun.施設.getコード()));
        } else {
            entity.setZaitakuShisetsuKubun(new Code(ZaitakuShisetsuKubun.在宅.getコード()));
        }
        entity.setIkenshoDoiFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get同意の有無()));
        entity.setSaishuShinryoYMD(new FlexibleDate(イメージ取込解析結果.get最終診察日()));
        entity.setExistTakaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get他科受診の有無()));
        edit受診中の他科項目(entity);
        entity.setShindamMei1(RString.EMPTY);
        entity.setHasshoYMD1(イメージ取込解析結果.get発症年月日１());
        entity.setShindamMei2(RString.EMPTY);
        entity.setHasshoYMD2(イメージ取込解析結果.get発症年月日２());
        entity.setShindamMei3(RString.EMPTY);
        entity.setHasshoYMD3(イメージ取込解析結果.get発症年月日３());
        entity.setAnteisei(イメージ取込解析結果.get症状の安定性());
        return entity;
    }

    private List<DbT5303ShujiiIkenshoKinyuItemEntity> データ更新_DbT5303_要介護認定主治医意見書記入項目(ImageinputResult ir) throws NullPointerException, IllegalArgumentException {

        manager_DbT5303 = new ShujiiIkenshoKinyuItemManager();

        List<DbT5303ShujiiIkenshoKinyuItemEntity> entitys = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
            DbT5303ShujiiIkenshoKinyuItemEntity entity = manager_DbT5303.select主治医意見書(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()), ir.getT5301_主治医意見書作成依頼履歴番号(), i);
            entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
            entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
            entity.setRemban(i);
            switch (IkenshoKinyuMapping09B.toValue(new RString(i))) {
                case その他:
                    //entity.setKinyuItem(イメージ取込解析結果.get);
                    break;
                case その他の精神_神経症状:
                    entity.setKinyuItem(イメージ取込解析結果.get精神神経症状());
                    break;
                case 専門医受診の有無:
                    entity.setKinyuItem(イメージ取込解析結果.get専門科医受診());
                    break;
                case 身長:
                    //entity.setKinyuItem(イメージ取込解析結果.get身長);
                    break;
                case 体重:
                    //entity.setKinyuItem(イメージ取込解析結果.get体重);
                    break;
                case 四肢欠損:
                    entity.setKinyuItem(イメージ取込解析結果.get四肢欠損());
                    break;
                case 麻痺_その他:
                    entity.setKinyuItem(イメージ取込解析結果.get麻痺その他());
                    break;
                case 筋力の低下:
                    entity.setKinyuItem(イメージ取込解析結果.get筋力低下());
                    break;
                case 関節の拘縮:
                    entity.setKinyuItem(イメージ取込解析結果.get間接の拘縮());
                    break;
                case 関節の痛み:
                    entity.setKinyuItem(イメージ取込解析結果.get間接の痛み());
                    break;
                case じょくそう:
                    entity.setKinyuItem(イメージ取込解析結果.get褥痩());
                    break;
                case その他の皮膚疾患:
                    entity.setKinyuItem(イメージ取込解析結果.getその他皮膚疾患());
                    break;
                case 栄養_食生活上の留意点:
                    //entity.setKinyuItem(イメージ取込解析結果.get栄養食生活上の留意点());
                    break;
                case 病態_その他:
                    entity.setKinyuItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態());
                    break;
                case 病態_対処方針:
                    //entity.setKinyuItem(イメージ取込解析結果.get対処方針());
                    break;
                case その他の医療系のサービス:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setKinyuItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(10, 11));
                    }
                    break;
                case 介護サービスの留意事項_血圧:
                    entity.setKinyuItem(イメージ取込解析結果.get血圧());
                    break;
                case 介護サービスの留意事項_移動:
                    entity.setKinyuItem(イメージ取込解析結果.get移動());
                    break;
                case 介護サービスの留意事項_摂食:
                    entity.setKinyuItem(イメージ取込解析結果.get摂食());
                    break;
                case 介護サービスの留意事項_運動:
                    entity.setKinyuItem(イメージ取込解析結果.get運動());
                    break;
                case 介護サービスの留意事項_嚥下:
                    entity.setKinyuItem(イメージ取込解析結果.get嚥下());
                    break;
                case 介護サービスの留意事項_その他:
                    //entity.setKinyuItem(イメージ取込解析結果.get介護サービスの留意事項());
                    break;
                case 感染症の有無:
                    entity.setKinyuItem(イメージ取込解析結果.get感染症());
                    break;
            }
            entitys.add(entity);
        }
        return entitys;
    }

    private List<DbT5304ShujiiIkenshoIkenItemEntity> データ更新_DbT5304_要介護認定主治医意見書意見項目(ImageinputResult ir)
            throws NullPointerException, IllegalArgumentException {

        manager_DbT5304 = new ShujiiIkenshoIkenItemNewManager();
        List<DbT5304ShujiiIkenshoIkenItemEntity> entitys = new ArrayList<>();
        for (int i = 1; i <= 113; i++) {
            DbT5304ShujiiIkenshoIkenItemEntity entity = manager_DbT5304.select主治医意見書(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()), ir.getT5301_主治医意見書作成依頼履歴番号(), i);
            entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
            entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
            entity.setRemban(i);
            entity.setIkenItem(RString.EMPTY);
            switch (IkenshoKomokuMapping09B.toValue(new RString(i))) {
                case 点滴の管理:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(0, 1));
                    }
                    break;
                case ストーマの処置:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(1, 2));
                    }
                    break;
                case 気管切開の処置:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(2, 3));
                    }
                    break;
                case 中心静脈栄養:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(3, 4));
                    }
                    break;
                case 酸素療法:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(4, 5));
                    }
                    break;
                case 疼痛の看護:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(5, 6));
                    }
                    break;
                case 透析:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(6, 7));
                    }
                    break;
                case レスピレーター:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(7, 8));
                    }
                    break;
                case 経管栄養:
                    if (!イメージ取込解析結果.get処置内容().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(8));
                    }
                    break;
                case モニター測定:
                    if (!イメージ取込解析結果.get特別な対応().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get特別な対応().substring(0, 1));
                    }
                    break;
                case じょくそうの処置:
                    if (!イメージ取込解析結果.get特別な対応().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get特別な対応().substring(1));
                    }
                    break;
                case カテーテル:
                    entity.setIkenItem(イメージ取込解析結果.getカテーテル());
                    break;
                case 寝たきり度:
                    entity.setIkenItem(イメージ取込解析結果.get障害高齢者の自立度());
                    break;
                case 認知症高齢者の日常生活自立度:
                    entity.setIkenItem(イメージ取込解析結果.get認知症高齢者の自立度());
                    break;
                case 短期記憶:
                    entity.setIkenItem(イメージ取込解析結果.get短期記憶());
                    break;
                case 認知能力:
                    entity.setIkenItem(イメージ取込解析結果.get認知能力());
                    break;
                case 伝達能力:
                    entity.setIkenItem(イメージ取込解析結果.get伝達能力());
                    break;
                case 認知症の周辺症状:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動の有無());
                    break;
                case 幻視_幻聴:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(0, 1));
                    }
                    break;
                case 火の不始末:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(1, 2));
                    }
                    break;
                case 妄想:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(2, 3));
                    }
                    break;
                case 不潔行為:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(3, 4));
                    }
                    break;
                case 昼夜逆転:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(4, 5));
                    }
                    break;
                case 異食行動:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(5, 6));
                    }
                    break;
                case 暴言:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(6, 7));
                    }
                    break;
                case 性的問題行動:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(7, 8));
                    }
                    break;
                case 暴行:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(8, 9));
                    }
                    break;
                case その他:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(9, 10));
                    }
                    break;
                case 介護への抵抗:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(10, 11));
                    }
                    break;
                case 徘徊_認知症の周辺症状:
                    if (!イメージ取込解析結果.get問題行動().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(11));
                    }
                    break;
                case その他の精神_神経症状:
                    entity.setIkenItem(イメージ取込解析結果.get精神神経症状());
                    break;
                case 専門医受診の有無:
                    entity.setIkenItem(イメージ取込解析結果.get専門科医受診());
                    break;
                case 利き腕:
                    entity.setIkenItem(イメージ取込解析結果.get利き腕());
                    break;
                case 過去6カ月の体重の変化:
                    entity.setIkenItem(イメージ取込解析結果.get過去6ヶ月間の体重の変化());
                    break;
                case 四肢欠損:
                    entity.setIkenItem(イメージ取込解析結果.get四肢欠損());
                    break;
                case 麻痺:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺());
                    break;
                case 麻痺_右上肢:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺右上肢());
                    break;
                case 麻痺_右上肢_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺右上肢程度());
                    break;
                case 麻痺_左上肢:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺左上肢());
                    break;
                case 麻痺_左上肢_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺左上肢程度());
                    break;
                case 麻痺_右下肢:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺右下肢());
                    break;
                case 麻痺_右下肢_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺右下肢程度());
                    break;
                case 麻痺_左下肢:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺左下肢());
                    break;
                case 麻痺_左下肢_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺左下肢程度());
                    break;
                case 麻痺_その他:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺その他());
                    break;
                case 麻痺_その他_程度:
                    entity.setIkenItem(イメージ取込解析結果.get麻痺その他程度());
                    break;
                case 筋力の低下:
                    entity.setIkenItem(イメージ取込解析結果.get筋力低下());
                    break;
                case 筋力の低下_程度:
                    entity.setIkenItem(イメージ取込解析結果.get筋力低下程度());
                    break;
                case 関節の拘縮:
                    entity.setIkenItem(イメージ取込解析結果.get間接の拘縮());
                    break;
                case 関節の拘縮_程度:
                    entity.setIkenItem(イメージ取込解析結果.get間接の拘縮程度());
                    break;
                case 関節の痛み:
                    entity.setIkenItem(イメージ取込解析結果.get間接の痛み());
                    break;
                case 関節の痛み_程度:
                    entity.setIkenItem(イメージ取込解析結果.get間接の痛み程度());
                    break;
                case 失調_不随意運動:
                    entity.setIkenItem(イメージ取込解析結果.get失調不随意運動());
                    break;
                case 失調_不随意運動_上肢_右:
                    if (!イメージ取込解析結果.get失調不随意上肢().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意上肢().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_上肢_左:
                    if (!イメージ取込解析結果.get失調不随意上肢().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意上肢().substring(1));
                    }
                    break;
                case 失調_不随意運動_下肢_右:
                    if (!イメージ取込解析結果.get失調不随意下肢().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意下肢().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_下肢_左:
                    if (!イメージ取込解析結果.get失調不随意下肢().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意下肢().substring(1));
                    }
                    break;
                case 失調_不随意運動_体幹_右:
                    if (!イメージ取込解析結果.get失調不随意体幹().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意体幹().substring(0, 1));
                    }
                    break;
                case 失調_不随意運動_体幹_左:
                    if (!イメージ取込解析結果.get失調不随意体幹().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get失調不随意体幹().substring(1));
                    }
                    break;
                case じょくそう:
                    entity.setIkenItem(イメージ取込解析結果.get褥痩());
                    break;
                case じょくそう_程度:
                    entity.setIkenItem(イメージ取込解析結果.get褥痩程度());
                    break;
                case その他の皮膚疾患:
                    entity.setIkenItem(イメージ取込解析結果.getその他皮膚疾患());
                    break;
                case その他の皮膚疾患_程度:
                    entity.setIkenItem(イメージ取込解析結果.getその他皮膚疾患程度());
                    break;
                case 屋外歩行:
                    entity.setIkenItem(イメージ取込解析結果.get屋外歩行());
                    break;
                case 車いすの使用:
                    entity.setIkenItem(イメージ取込解析結果.get車いすの使用());
                    break;
                case 歩行補助具_装具の使用_用いていない:
                    if (!イメージ取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get歩行補助具装具の使用().substring(0, 1));
                    }
                    break;
                case 歩行補助具_装具の使用_屋外で使用:
                    if (!イメージ取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get歩行補助具装具の使用().substring(1, 2));
                    }
                    break;
                case 歩行補助具_装具の使用_屋内で使用:
                    if (!イメージ取込解析結果.get歩行補助具装具の使用().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get歩行補助具装具の使用().substring(2));
                    }
                    break;
                case 食事行為:
                    entity.setIkenItem(イメージ取込解析結果.get食事行為());
                    break;
                case 現在の栄養状態:
                    entity.setIkenItem(イメージ取込解析結果.get現在の栄養状況());
                    break;
                case 尿失禁:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(0, 1));
                    }
                    break;
                case 転倒_骨折:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(1, 2));
                    }
                    break;
                case 移動能力の低下:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(2, 3));
                    }
                    break;
                case 褥瘡:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(3, 4));
                    }
                    break;
                case 心肺機能の低下:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(4, 5));
                    }
                    break;
                case 閉じこもり:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(5, 6));
                    }
                    break;
                case 意欲低下:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(6, 7));
                    }
                    break;
                case 徘徊_可能性が高い病態:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(7, 8));
                    }
                    break;
                case 低栄養:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(8, 9));
                    }
                    break;
                case 摂食_嚥下機能低下:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(9, 10));
                    }
                    break;
                case 脱水:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(10, 11));
                    }
                    break;
                case 易感染性:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(11, 12));
                    }
                    break;
                case がん等による疼痛:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(12, 13));
                    }
                    break;
                case 病態_その他:
                    if (!イメージ取込解析結果.get現在または今後発生の可能性の高い状態().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(13));
                    }
                    break;
                case 生活機能の維持_改善の見通し:
                    entity.setIkenItem(イメージ取込解析結果.get予後の見通し());
                    break;
                case 訪問診療:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(0, 1));
                    }
                    break;
                case 訪問診療_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(0, 1));
                    }
                    break;
                case 訪問看護:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(1, 2));
                    }
                    break;
                case 訪問看護_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(1, 2));
                    }
                    break;
                case 看護職員による相談:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(2, 3));
                    }
                    break;
                case 看護職員による相談_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(2, 3));
                    }
                    break;
                case 訪問歯科診療:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(3, 4));
                    }
                    break;
                case 訪問歯科診療_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(3, 4));
                    }
                    break;
                case 訪問薬剤管理指導:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(4, 5));
                    }
                    break;
                case 訪問薬剤管理指導_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(4, 5));
                    }
                    break;
                case 訪問リハビリテーション:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(5, 6));
                    }
                    break;
                case 訪問リハビリテーション_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(5, 6));
                    }
                    break;
                case 短期入所療養介護:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(6, 7));
                    }
                    break;
                case 短期入所療養介護_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(6, 7));
                    }
                    break;
                case 訪問歯科衛生指導:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(7, 8));
                    }
                    break;
                case 訪問歯科衛生指導_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(7, 8));
                    }
                    break;
                case 訪問栄養食事指導:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(8, 9));
                    }
                    break;
                case 訪問栄養食事指導_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(8, 9));
                    }
                    break;
                case 通所リハビリテーション:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(9, 10));
                    }
                    break;
                case 通所リハビリテーション_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(9, 10));
                    }
                    break;
                case その他の医療系のサービス:
                    if (!イメージ取込解析結果.get医学的管理の必要性チェック().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(10));
                    }
                    break;
                case その他の医療系のサービス_必要性:
                    if (!イメージ取込解析結果.get医学的管理の必要性下線().isEmpty()) {
                        entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(10));
                    }
                    break;
                case 介護サービスの留意事項_血圧:
                    entity.setIkenItem(イメージ取込解析結果.get血圧());
                    break;
                case 介護サービスの留意事項_移動:
                    entity.setIkenItem(イメージ取込解析結果.get移動());
                    break;
                case 介護サービスの留意事項_摂食:
                    entity.setIkenItem(イメージ取込解析結果.get摂食());
                    break;
                case 介護サービスの留意事項_運動:
                    entity.setIkenItem(イメージ取込解析結果.get運動());
                    break;
                case 介護サービスの留意事項_嚥下:
                    entity.setIkenItem(イメージ取込解析結果.get嚥下());
                    break;
                case 感染症の有無:
                    entity.setIkenItem(イメージ取込解析結果.get感染症());
                    break;
            }
            entitys.add(entity);
        }
        return entitys;
    }

    private void edit受診中の他科項目(DbT5302ShujiiIkenshoJohoEntity entity) {
        if (!イメージ取込解析結果.get記入のあった科().isEmpty()) {
            entity.setExistNaikaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_内科, 桁数固定値_内科 + 切り出し桁数)));
            entity.setExistSeishinkaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_精神科, 桁数固定値_精神科 + 切り出し桁数)));
            entity.setExistGekaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_外科, 桁数固定値_外科 + 切り出し桁数)));
            entity.setExistSeikeigekaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_整形外科, 桁数固定値_整形外科 + 切り出し桁数)));
            entity.setExistNoshinkeigekaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_脳神経外科, 桁数固定値_脳神経外科 + 切り出し桁数)));
            entity.setExistHifukaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_皮膚科, 桁数固定値_皮膚科 + 切り出し桁数)));
            entity.setExistHinyokikaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_泌尿器科, 桁数固定値_泌尿器科 + 切り出し桁数)));
            entity.setExistFujinkaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_婦人科, 桁数固定値_婦人科 + 切り出し桁数)));
            entity.setExistJibiinkokaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_耳鼻咽喉科, 桁数固定値_耳鼻咽喉科 + 切り出し桁数)));
            entity.setExistRehabilitationkaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_リハビリテーション科, 桁数固定値_リハビリテーション科 + 切り出し桁数)));
            entity.setExistShikaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_歯科, 桁数固定値_歯科 + 切り出し桁数)));
            entity.setExistGankaJushinFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_眼科, 桁数固定値_眼科 + 切り出し桁数)));
            entity.setExistSonotaJushinkaFlag(フラグ変換_RStringToBoolean(イメージ取込解析結果.get記入のあった科().substring(桁数固定値_その他受診科, 桁数固定値_その他受診科 + 切り出し桁数)));
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

    private ImageInputReadResult チェック処理(ImageInputReadResult ocrイメージ解析結果) {

        OcrJohoOcrImageEntity ocrImageデータ行 = (OcrJohoOcrImageEntity) ocrイメージ解析結果.getOcrイメージ行Entity();

        if (ocrImageデータ行 != null) {
            if (意見書_表.equals(ocrImageデータ行.get意見書区分())) {
                set意見書_表(ocrImageデータ行, ocrイメージ解析結果);
            } else if (意見書_裏.equals(ocrImageデータ行.get意見書区分())) {
                set意見書_裏(ocrImageデータ行, ocrイメージ解析結果);
            } else if (意見書_ID777.equals(ocrImageデータ行.get意見書区分())) {
                set意見書_ID777(ocrImageデータ行, ocrイメージ解析結果);
            } else if (意見書_ID778.equals(ocrImageデータ行.get意見書区分())) {
                set意見書_ID778(ocrImageデータ行, ocrイメージ解析結果);
            } else {
                processParameter.setファイルList(ocrイメージ解析結果.getイメージファイル());
            }
        }
        return ocrイメージ解析結果;
    }

    private void set意見書_表(OcrJohoOcrImageEntity ocrImageデータ行, ImageInputReadResult ocrイメージ解析結果) {

        ocrイメージ解析結果.set保険者番号(ocrImageデータ行.get保険者番号());
        ocrイメージ解析結果.set申請日(ocrImageデータ行.get申請日());
        ocrイメージ解析結果.set被保険者番号(ocrImageデータ行.get被保険者番号());
        ocrイメージ解析結果.set同意の有無(ocrImageデータ行.get行項目_6());
        ocrイメージ解析結果.set最終診察日(ocrImageデータ行.get行項目_7());
        ocrイメージ解析結果.set記入日(ocrImageデータ行.get行項目_8());
        ocrイメージ解析結果.set受領日(ocrImageデータ行.get行項目_9());
        ocrイメージ解析結果.set意見書作成回数(ocrImageデータ行.get行項目_10());
        ocrイメージ解析結果.set他科受診の有無(ocrImageデータ行.get行項目_11());
        ocrイメージ解析結果.set記入のあった科(ocrImageデータ行.get行項目_12());
        ocrイメージ解析結果.set発症年月日１和暦(ocrImageデータ行.get行項目_13());
        ocrイメージ解析結果.set発症年月日１(ocrImageデータ行.get行項目_14());
        ocrイメージ解析結果.set発症年月日２和暦(ocrImageデータ行.get行項目_15());
        ocrイメージ解析結果.set発症年月日２(ocrImageデータ行.get行項目_16());
        ocrイメージ解析結果.set発症年月日３和暦(ocrImageデータ行.get行項目_17());
        ocrイメージ解析結果.set発症年月日３(ocrImageデータ行.get行項目_18());
        ocrイメージ解析結果.set症状の安定性(ocrImageデータ行.get行項目_19());
        ocrイメージ解析結果.set処置内容(ocrImageデータ行.get行項目_20());
        ocrイメージ解析結果.set特別な対応(ocrImageデータ行.get行項目_21());
        ocrイメージ解析結果.setカテーテル(ocrImageデータ行.get行項目_22());
        ocrイメージ解析結果.set障害高齢者の自立度(ocrImageデータ行.get行項目_23());
        ocrイメージ解析結果.set認知症高齢者の自立度(ocrImageデータ行.get行項目_24());
        ocrイメージ解析結果.set短期記憶(ocrImageデータ行.get行項目_25());
        ocrイメージ解析結果.set認知能力(ocrImageデータ行.get行項目_26());
        ocrイメージ解析結果.set伝達能力(ocrImageデータ行.get行項目_27());
        ocrイメージ解析結果.set問題行動の有無(ocrImageデータ行.get行項目_28());
        ocrイメージ解析結果.set問題行動(ocrImageデータ行.get行項目_29());
        ocrイメージ解析結果.set精神神経症状(ocrImageデータ行.get行項目_30());
        ocrイメージ解析結果.set専門科医受診(ocrImageデータ行.get行項目_31());
    }

    private void set意見書_裏(OcrJohoOcrImageEntity ocrImageデータ行, ImageInputReadResult ocrイメージ解析結果) {

        ocrイメージ解析結果.set保険者番号(ocrImageデータ行.get保険者番号());
        ocrイメージ解析結果.set申請日(ocrImageデータ行.get申請日());
        ocrイメージ解析結果.set被保険者番号(ocrImageデータ行.get被保険者番号());
        ocrイメージ解析結果.set利き腕(ocrImageデータ行.get行項目_6());
        ocrイメージ解析結果.set過去6ヶ月間の体重の変化(ocrImageデータ行.get行項目_7());
        ocrイメージ解析結果.set四肢欠損(ocrImageデータ行.get行項目_8());
        ocrイメージ解析結果.set麻痺(ocrImageデータ行.get行項目_9());
        ocrイメージ解析結果.set麻痺右上肢(ocrImageデータ行.get行項目_10());
        ocrイメージ解析結果.set麻痺右上肢程度(ocrImageデータ行.get行項目_11());
        ocrイメージ解析結果.set麻痺右下肢(ocrImageデータ行.get行項目_12());
        ocrイメージ解析結果.set麻痺右下肢程度(ocrImageデータ行.get行項目_13());
        ocrイメージ解析結果.set麻痺左上肢(ocrImageデータ行.get行項目_14());
        ocrイメージ解析結果.set麻痺左上肢程度(ocrImageデータ行.get行項目_15());
        ocrイメージ解析結果.set麻痺左下肢(ocrImageデータ行.get行項目_16());
        ocrイメージ解析結果.set麻痺左下肢程度(ocrImageデータ行.get行項目_17());
        ocrイメージ解析結果.set麻痺その他(ocrImageデータ行.get行項目_18());
        ocrイメージ解析結果.set麻痺その他程度(ocrImageデータ行.get行項目_19());
        ocrイメージ解析結果.set筋力低下(ocrImageデータ行.get行項目_20());
        ocrイメージ解析結果.set筋力低下程度(ocrImageデータ行.get行項目_21());
        ocrイメージ解析結果.set間接の拘縮(ocrImageデータ行.get行項目_22());
        ocrイメージ解析結果.set間接の拘縮程度(ocrImageデータ行.get行項目_23());
        ocrイメージ解析結果.set間接の痛み(ocrImageデータ行.get行項目_24());
        ocrイメージ解析結果.set間接の痛み程度(ocrImageデータ行.get行項目_25());
        ocrイメージ解析結果.set失調不随意運動(ocrImageデータ行.get行項目_26());
        ocrイメージ解析結果.set失調不随意上肢(ocrImageデータ行.get行項目_27());
        ocrイメージ解析結果.set失調不随意下肢(ocrImageデータ行.get行項目_28());
        ocrイメージ解析結果.set失調不随意体幹(ocrImageデータ行.get行項目_29());
        ocrイメージ解析結果.set褥痩(ocrImageデータ行.get行項目_30());
        ocrイメージ解析結果.set褥痩程度(ocrImageデータ行.get行項目_31());
        ocrイメージ解析結果.setその他皮膚疾患(ocrImageデータ行.get行項目_32());
        ocrイメージ解析結果.setその他皮膚疾患程度(ocrImageデータ行.get行項目_33());
        ocrイメージ解析結果.set屋外歩行(ocrImageデータ行.get行項目_34());
        ocrイメージ解析結果.set車いすの使用(ocrImageデータ行.get行項目_35());
        ocrイメージ解析結果.set歩行補助具装具の使用(ocrImageデータ行.get行項目_36());
        ocrイメージ解析結果.set食事行為(ocrImageデータ行.get行項目_37());
        ocrイメージ解析結果.set現在の栄養状況(ocrImageデータ行.get行項目_38());
        ocrイメージ解析結果.set現在または今後発生の可能性の高い状態(ocrImageデータ行.get行項目_39());
        ocrイメージ解析結果.set予後の見通し(ocrImageデータ行.get行項目_40());
        ocrイメージ解析結果.set医学的管理の必要性チェック(ocrImageデータ行.get行項目_41());
        ocrイメージ解析結果.set医学的管理の必要性下線(ocrImageデータ行.get行項目_42());
        ocrイメージ解析結果.set血圧(ocrImageデータ行.get行項目_43());
        ocrイメージ解析結果.set移動(ocrImageデータ行.get行項目_44());
        ocrイメージ解析結果.set摂食(ocrImageデータ行.get行項目_45());
        ocrイメージ解析結果.set運動(ocrImageデータ行.get行項目_46());
        ocrイメージ解析結果.set嚥下(ocrImageデータ行.get行項目_47());
        ocrイメージ解析結果.set感染症(ocrImageデータ行.get行項目_48());
        ocrイメージ解析結果.set主治医への結果連絡(ocrImageデータ行.get行項目_49());
    }

    private void set意見書_ID777(OcrJohoOcrImageEntity ocrImageデータ行, ImageInputReadResult ocrイメージ解析結果) {

        ocrイメージ解析結果.set保険者番号(ocrImageデータ行.get保険者番号());
        ocrイメージ解析結果.set申請日(ocrImageデータ行.get申請日());
        ocrイメージ解析結果.set被保険者番号(ocrImageデータ行.get被保険者番号());
        ocrイメージ解析結果.setID777_記入日(ocrImageデータ行.get行項目_6());
        ocrイメージ解析結果.setID777_受領日(ocrImageデータ行.get行項目_7());
        ocrイメージ解析結果.setID777_障害高齢者の自立度(ocrImageデータ行.get行項目_8());
        ocrイメージ解析結果.setID777_認知症高齢者の自立度(ocrImageデータ行.get行項目_9());
        ocrイメージ解析結果.setID777_短期記憶(ocrImageデータ行.get行項目_10());
        ocrイメージ解析結果.setID777_認知能力(ocrImageデータ行.get行項目_11());
        ocrイメージ解析結果.setID777_伝達能力(ocrImageデータ行.get行項目_12());
        ocrイメージ解析結果.setID777_食事行為(ocrImageデータ行.get行項目_13());
        ocrイメージ解析結果.setID777_主治医への結果連絡(ocrImageデータ行.get行項目_14());
    }

    private void set意見書_ID778(OcrJohoOcrImageEntity ocrImageデータ行, ImageInputReadResult ocrイメージ解析結果) {

        ocrイメージ解析結果.set保険者番号(ocrImageデータ行.get保険者番号());
        ocrイメージ解析結果.set申請日(ocrImageデータ行.get申請日());
        ocrイメージ解析結果.set被保険者番号(ocrImageデータ行.get被保険者番号());
    }

}
