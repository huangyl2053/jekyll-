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
import jp.co.ndensan.reams.db.dbe.business.core.ocrdataread.OcrDataReadResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.imageinput.ImageinputMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocrdataread.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.imageinput.ImageInputCsvEntity;
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
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author n2818
 */
public class ImageInputProcess extends BatchProcessBase<RString> {

    private OcrDataReadProcessParameter processParameter;
    private long 読取中行番号;
    private OcrDataReadResult ocrデータ解析結果 = new OcrDataReadResult();
    private ImageInputReadResult イメージ取込解析結果 = new ImageInputReadResult();
    private static final RString イメージ区分 = new RString("2");
    private static final RString 新規調査 = new RString("0");

    @BatchWriter
    private BatchPermanentTableWriter<DbT5302ShujiiIkenshoJohoEntity> writer_DbT5302;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5303ShujiiIkenshoKinyuItemEntity> writer_DbT5303;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5304ShujiiIkenshoIkenItemEntity> writer_DbT5304;

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(processParameter.getファイルPath(), Encode.SJIS);
    }

    @Override
    protected void createWriter() {
        writer_DbT5302 = new BatchPermanentTableWriter<>(DbT5302ShujiiIkenshoJohoEntity.class);
        writer_DbT5303 = new BatchPermanentTableWriter<>(DbT5303ShujiiIkenshoKinyuItemEntity.class);
        writer_DbT5304 = new BatchPermanentTableWriter<>(DbT5304ShujiiIkenshoIkenItemEntity.class);
    }

    @Override
    protected void process(RString line) {

        //ocrデータ解析結果.clear();
        イメージ取込解析結果.clear();
        読取中行番号++;
        ocrデータ解析結果.parse(line, 読取中行番号);

//        ocrデータ解析結果 = this.チェック処理(ocrデータ解析結果);
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

            }
        }
    }

    private List<DbT5304ShujiiIkenshoIkenItemEntity> 新規追加_DbT5304_要介護認定主治医意見書意見項目(ImageinputResult ir)
            throws NullPointerException, IllegalArgumentException {
        DbT5304ShujiiIkenshoIkenItemEntity entity = new DbT5304ShujiiIkenshoIkenItemEntity();
        List<DbT5304ShujiiIkenshoIkenItemEntity> entitys = new ArrayList<>();
        for (int i = 1; i <= 113; i++) {
            entity.setShinseishoKanriNo(new ShinseishoKanriNo(ir.getT5101_申請書管理番号()));
            entity.setIkenshoIraiRirekiNo(ir.getT5301_主治医意見書作成依頼履歴番号());
            entity.setRemban(i);
            entity.setKoroshoIfShikibetsuCode(new Code(ir.getT5101_厚労省IF識別コード()));
            switch (IkenshoKomokuMapping09B.toValue(new RString(i))) {
                case 点滴の管理:
                    entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(0, 1));
                    break;
                case ストーマの処置:
                    entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(1, 2));
                    break;
                case 気管切開の処置:
                    entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(2, 3));
                    break;
                case 中心静脈栄養:
                    entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(3, 4));
                    break;
                case 酸素療法:
                    entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(4, 5));
                    break;
                case 疼痛の看護:
                    entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(5, 6));
                    break;
                case 透析:
                    entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(6, 7));
                    break;
                case レスピレーター:
                    entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(7, 8));
                    break;
                case 経管栄養:
                    entity.setIkenItem(イメージ取込解析結果.get処置内容().substring(8));
                    break;
                case モニター測定:
                    entity.setIkenItem(イメージ取込解析結果.get特別な対応().substring(0, 1));
                    break;
                case じょくそうの処置:
                    entity.setIkenItem(イメージ取込解析結果.get特別な対応().substring(1));
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
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(0, 1));
                    break;
                case 火の不始末:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(1, 2));
                    break;
                case 妄想:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(2, 3));
                    break;
                case 不潔行為:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(3, 4));
                    break;
                case 昼夜逆転:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(4, 5));
                    break;
                case 異食行動:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(5, 6));
                    break;
                case 暴言:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(6, 7));
                    break;
                case 性的問題行動:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(7, 8));
                    break;
                case 暴行:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(8, 9));
                    break;
                case その他:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(9, 10));
                    break;
                case 介護への抵抗:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(10, 11));
                    break;
                case 徘徊_認知症の周辺症状:
                    entity.setIkenItem(イメージ取込解析結果.get問題行動().substring(11));
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
                    entity.setIkenItem(イメージ取込解析結果.get失調不随意上肢().substring(0, 1));
                    break;
                case 失調_不随意運動_上肢_左:
                    entity.setIkenItem(イメージ取込解析結果.get失調不随意上肢().substring(1));
                    break;
                case 失調_不随意運動_下肢_右:
                    entity.setIkenItem(イメージ取込解析結果.get失調不随意下肢().substring(0, 1));
                    break;
                case 失調_不随意運動_下肢_左:
                    entity.setIkenItem(イメージ取込解析結果.get失調不随意下肢().substring(1));
                    break;
                case 失調_不随意運動_体幹_右:
                    entity.setIkenItem(イメージ取込解析結果.get失調不随意体幹().substring(0, 1));
                    break;
                case 失調_不随意運動_体幹_左:
                    entity.setIkenItem(イメージ取込解析結果.get失調不随意体幹().substring(1));
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
                    entity.setIkenItem(イメージ取込解析結果.get歩行補助具装具の使用().substring(0, 1));
                    break;
                case 歩行補助具_装具の使用_屋外で使用:
                    entity.setIkenItem(イメージ取込解析結果.get歩行補助具装具の使用().substring(1, 2));
                    break;
                case 歩行補助具_装具の使用_屋内で使用:
                    entity.setIkenItem(イメージ取込解析結果.get歩行補助具装具の使用().substring(2));
                    break;
                case 食事行為:
                    entity.setIkenItem(イメージ取込解析結果.get食事行為());
                    break;
                case 現在の栄養状態:
                    entity.setIkenItem(イメージ取込解析結果.get現在の栄養状況());
                    break;
                case 尿失禁:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(0, 1));
                    break;
                case 転倒_骨折:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(1, 2));
                    break;
                case 移動能力の低下:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(2, 3));
                    break;
                case 褥瘡:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(3, 4));
                    break;
                case 心肺機能の低下:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(4, 5));
                    break;
                case 閉じこもり:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(5, 6));
                    break;
                case 意欲低下:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(6, 7));
                    break;
                case 徘徊_可能性が高い病態:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(7, 8));
                    break;
                case 低栄養:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(8, 9));
                    break;
                case 摂食_嚥下機能低下:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(9, 10));
                    break;
                case 脱水:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(10, 11));
                    break;
                case 易感染性:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(11, 12));
                    break;
                case がん等による疼痛:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(12, 13));
                    break;
                case 病態_その他:
                    entity.setIkenItem(イメージ取込解析結果.get現在または今後発生の可能性の高い状態().substring(13));
                    break;
                case 生活機能の維持_改善の見通し:
                    entity.setIkenItem(イメージ取込解析結果.get予後の見通し());
                    break;
                case 訪問診療:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(0, 1));
                    break;
                case 訪問診療_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(0, 1));
                    break;
                case 訪問看護:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(1, 2));
                    break;
                case 訪問看護_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(1, 2));
                    break;
                case 看護職員による相談:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(2, 3));
                    break;
                case 看護職員による相談_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(2, 3));
                    break;
                case 訪問歯科診療:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(3, 4));
                    break;
                case 訪問歯科診療_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(3, 4));
                    break;
                case 訪問薬剤管理指導:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(4, 5));
                    break;
                case 訪問薬剤管理指導_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(4, 5));
                    break;
                case 訪問リハビリテーション:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(5, 6));
                    break;
                case 訪問リハビリテーション_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(5, 6));
                    break;
                case 短期入所療養介護:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(6, 7));
                    break;
                case 短期入所療養介護_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(6, 7));
                    break;
                case 訪問歯科衛生指導:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(7, 8));
                    break;
                case 訪問歯科衛生指導_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(7, 8));
                    break;
                case 訪問栄養食事指導:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(8, 9));
                    break;
                case 訪問栄養食事指導_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(8, 9));
                    break;
                case 通所リハビリテーション:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(9, 10));
                    break;
                case 通所リハビリテーション_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(9, 10));
                    break;
                case その他の医療系のサービス:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(10));
                    break;
                case その他の医療系のサービス_必要性:
                    entity.setIkenItem(イメージ取込解析結果.get医学的管理の必要性下線().substring(10));
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
        DbT5303ShujiiIkenshoKinyuItemEntity entity = new DbT5303ShujiiIkenshoKinyuItemEntity();
        List<DbT5303ShujiiIkenshoKinyuItemEntity> entitys = new ArrayList<>();
        for (int i = 1; i <= 23; i++) {
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
                    entity.setKinyuItem(イメージ取込解析結果.get医学的管理の必要性チェック().substring(10, 11));
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

    private void edit受診中の他科項目(DbT5302ShujiiIkenshoJohoEntity entity) {
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

//    private OcrDataReadResult チェック処理(OcrDataReadResult ocrデータ解析結果) {
//
//        ImageInputCsvEntity ocrDataデータ行 = (ImageInputCsvEntity) ocrデータ解析結果.getOcrDataデータ行Entity();
//        RString データレコードの保険者番号 = RString.EMPTY;
//        RString データレコードの申請日 = RString.EMPTY;
//        RString データレコードの被保険者番号 = RString.EMPTY;
//        RString データレコードの実施日時 = RString.EMPTY;
//        RString データレコードの実施場所 = RString.EMPTY;
//        RString データレコードの記入者 = RString.EMPTY;
//        RString データレコードの所属機関 = RString.EMPTY;
//
//        if (ocrDataデータ行 != null) {
//            データレコードの保険者番号 = ocrDataデータ行.get保険者番号();
//            データレコードの申請日 = ocrDataデータ行.get申請日();
//            データレコードの被保険者番号 = ocrDataデータ行.get被保険者番号();
//        }
//
//        ocrデータ解析結果.set保険者番号(データレコードの保険者番号);
//        ocrデータ解析結果.set被保険者番号(データレコードの被保険者番号);
//        ocrデータ解析結果.set申請日(データレコードの申請日);
//        ocrデータ解析結果.set実施日時(データレコードの実施日時);
//        ocrデータ解析結果.set実施場所(データレコードの実施場所);
//        ocrデータ解析結果.set記入者(データレコードの記入者);
//        ocrデータ解析結果.set所属機関(データレコードの所属機関);
//
//        List<RString> imageList = ocrデータ解析結果.getイメージファイル();
//
//        return ocrデータ解析結果;
//    }
}
