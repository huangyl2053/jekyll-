/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ocrdataread;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosakekkatorikomiocr.NinteiOcrResult;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.db.dbe.business.core.ocrdataread.OcrDataReadResult;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ninteichosakekkatorikomiocr.NinteiOcrMapperParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocrdataread.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.csv.jizenshinsakekka.OcrJohoOcrDataRecordEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteichosahyoGaikyoChosa09BManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteichosahyoGaikyoChosa09AManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteichosahyoGaikyoChosa06AManager;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosakekkatorikomiocr.NinteiOcrFindler;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5202NinteichosahyoGaikyoChosa06AEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5202NinteichosahyoGaikyoChosa09AEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5202NinteichosahyoGaikyoChosa09BEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5203NinteichosahyoKihonChosa06AEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5203NinteichosahyoKihonChosa09AEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5203NinteichosahyoKihonChosa09BEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteichosahyoKihonChosa06AManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteichosahyoKihonChosa09AManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteichosahyoKihonChosa09BManager;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteichosahyoServiceJokyoFlagManager;
import jp.co.ndensan.reams.db.dbe.service.core.basic.NinteichosahyoServiceJokyoManager;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchSimpleReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
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

/**
 * OCR情報受入＿バッチプロセスクラスです。
 *
 * @author n8429
 */
public class OcrDataReadProcess extends BatchProcessBase<RString> {

    private OcrDataReadProcessParameter processParameter;
    private long 読取中行番号;
    private OcrDataReadResult ocrデータ解析結果 = new OcrDataReadResult();
    private static final RString 厚労省IF識別コード_06A = new RString("06A");
    private static final RString 厚労省IF識別コード_09A = new RString("09A");
    private static final RString 厚労省IF識別コード_09B = new RString("09B");
    private static final RString イメージ区分 = new RString("2");
    private static final RString 新規調査 = new RString("0");
    private static final RString 実施場所コード１ = new RString("1");
    private static final RString 実施場所コード２ = new RString("2");
    private static final RString 実施場所コード３ = new RString("3");
    private static final RString 実施場所名称＿在宅 = new RString("在宅");
    private static final RString 実施場所名称＿施設 = new RString("施設");
    private static final RString 実施場所名称＿その他 = new RString("その他");
    private static final RString 概況調査区分 = new RString("501");
    private static final RString 基本調査区分 = new RString("502");
    private static final RString 住宅改修あり = new RString("1");
    private static final RString 住宅改修なし = new RString("2");

    private static final int 連番1 = 1;
    private static final int 連番2 = 2;
    private static final int 連番3 = 3;
    private static final int 連番4 = 4;
    private static final int 連番5 = 5;

    private NinteichosahyoGaikyoChosa09BManager manager09b;
    private NinteichosahyoGaikyoChosa09AManager manager09a;
    private NinteichosahyoGaikyoChosa06AManager manager06a;
    private NinteichosahyoKihonChosa06AManager managerKihon06a;
    private NinteichosahyoKihonChosa09AManager managerKihon09a;
    private NinteichosahyoKihonChosa09BManager managerKihon09b;
    private NinteichosahyoServiceJokyoManager serviceManager;
    private NinteichosahyoServiceJokyoFlagManager serviceFlagManager;

    @BatchWriter
    private BatchPermanentTableWriter<DbT5202NinteichosahyoGaikyoChosa09BEntity> writer09b;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5202NinteichosahyoGaikyoChosa09AEntity> writer09a;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5202NinteichosahyoGaikyoChosa06AEntity> writer06a;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5207NinteichosahyoServiceJokyoEntity> writerService;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5208NinteichosahyoServiceJokyoFlagEntity> writerServiceFlag;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5210NinteichosahyoShisetsuRiyoEntity> writerShisetsu;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5203NinteichosahyoKihonChosa06AEntity> writerKihon06a;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5203NinteichosahyoKihonChosa09AEntity> writerKihon09a;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5203NinteichosahyoKihonChosa09BEntity> writerKihon09b;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5211NinteichosahyoChosaItemEntity> writerItem;
    @BatchWriter
    private BatchPermanentTableWriter<DbT5115ImageEntity> writerImage;

    @Override
    protected IBatchReader createReader() {
        return new BatchSimpleReader(processParameter.getファイルPath(), Encode.SJIS);
    }

    @Override
    protected void createWriter() {
        writer06a = new BatchPermanentTableWriter<>(DbT5202NinteichosahyoGaikyoChosa06AEntity.class);
        writer09a = new BatchPermanentTableWriter<>(DbT5202NinteichosahyoGaikyoChosa09AEntity.class);
        writer09b = new BatchPermanentTableWriter<>(DbT5202NinteichosahyoGaikyoChosa09BEntity.class);
        writerService = new BatchPermanentTableWriter<>(DbT5207NinteichosahyoServiceJokyoEntity.class);
        writerServiceFlag = new BatchPermanentTableWriter<>(DbT5208NinteichosahyoServiceJokyoFlagEntity.class);
        writerShisetsu = new BatchPermanentTableWriter<>(DbT5210NinteichosahyoShisetsuRiyoEntity.class);
        writerKihon06a = new BatchPermanentTableWriter<>(DbT5203NinteichosahyoKihonChosa06AEntity.class);
        writerKihon09a = new BatchPermanentTableWriter<>(DbT5203NinteichosahyoKihonChosa09AEntity.class);
        writerKihon09b = new BatchPermanentTableWriter<>(DbT5203NinteichosahyoKihonChosa09BEntity.class);
        writerItem = new BatchPermanentTableWriter<>(DbT5211NinteichosahyoChosaItemEntity.class);
        writerImage = new BatchPermanentTableWriter<>(DbT5115ImageEntity.class);
    }

    @Override
    protected void process(RString line) {

        if (!processParameter.getファイルPath().contains(".png")) {
            ocrデータ解析結果.clear();
            読取中行番号++;
            ocrデータ解析結果.parse(line, 読取中行番号);

            ocrデータ解析結果 = this.チェック処理(ocrデータ解析結果);

            NinteiOcrMapperParamter paramter = NinteiOcrMapperParamter.createParamter(ocrデータ解析結果.get保険者番号(),
                    ocrデータ解析結果.get被保険者番号(),
                    ocrデータ解析結果.get申請日());

            List<NinteiOcrResult> 関連データList = NinteiOcrFindler.createInstance().get関連データ(paramter).records();
            for (int i = 0; i < 関連データList.size(); i++) {
                NinteiOcrResult result = 関連データList.get(i);

                if (result.getイメージ共有ファイルID().compareTo(RDateTime.MIN) == 0) {

                    if (ocrデータ解析結果.get調査区分().equals(概況調査区分)) {
                        if (厚労省IF識別コード_09B.equals(result.get厚労省IF識別コード())) {

                            dbT5202Entity09BInsert(ocrデータ解析結果, result);
                            dbT5207EntityInsert(ocrデータ解析結果, result);
                            dbT5208EntityInsert(ocrデータ解析結果, result);
                            dbT5210EntityInsert(ocrデータ解析結果, result);

                        } else if (厚労省IF識別コード_09A.equals(result.get厚労省IF識別コード())) {
                            dbT5202Entity09AInsert(ocrデータ解析結果, result);
                            dbT5207EntityInsert(ocrデータ解析結果, result);
                            dbT5208EntityInsert(ocrデータ解析結果, result);
                            dbT5210EntityInsert(ocrデータ解析結果, result);

                        } else if (厚労省IF識別コード_06A.equals(result.get厚労省IF識別コード())) {
                            dbT5202Entity06AInsert(ocrデータ解析結果, result);
                            dbT5207EntityInsert(ocrデータ解析結果, result);
                            dbT5208EntityInsert(ocrデータ解析結果, result);
                            dbT5210EntityInsert(ocrデータ解析結果, result);

                        }
                    } else if (ocrデータ解析結果.get調査区分().equals(基本調査区分)) {
                        if (厚労省IF識別コード_09B.equals(result.get厚労省IF識別コード())) {

                            DbT5203NinteichosahyoKihonChosa09BEntity entityKihon = new DbT5203NinteichosahyoKihonChosa09BEntity();

                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_09B));
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon09b.insert(entityKihon);

                            dbT5211EntityInsert(ocrデータ解析結果, result);

                        } else if (厚労省IF識別コード_09A.equals(result.get厚労省IF識別コード())) {

                            DbT5203NinteichosahyoKihonChosa09AEntity entityKihon = new DbT5203NinteichosahyoKihonChosa09AEntity();
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_09A));
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon09a.insert(entityKihon);

                            dbT5211EntityInsert(ocrデータ解析結果, result);

                        } else if (厚労省IF識別コード_06A.equals(result.get厚労省IF識別コード())) {

                            DbT5203NinteichosahyoKihonChosa06AEntity entityKihon = new DbT5203NinteichosahyoKihonChosa06AEntity();

                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_06A));
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));;
                            writerKihon06a.insert(entityKihon);

                            dbT5211EntityInsert(ocrデータ解析結果, result);

                        }
                    }
                } else {
                    if (ocrデータ解析結果.get調査区分().equals(概況調査区分)) {
                        if (厚労省IF識別コード_09B.equals(result.get厚労省IF識別コード())) {

                            dbT5202Entity09BUpdate(ocrデータ解析結果, result);
                            dbT5207EntityUpdate(ocrデータ解析結果, result);
                            dbT5208EntityUpdate(ocrデータ解析結果, result);

                        } else if (厚労省IF識別コード_09A.equals(result.get厚労省IF識別コード())) {

                            dbT5202Entity09AUpdate(ocrデータ解析結果, result);
                            dbT5207EntityUpdate(ocrデータ解析結果, result);
                            dbT5208EntityUpdate(ocrデータ解析結果, result);

                        } else if (厚労省IF識別コード_06A.equals(result.get厚労省IF識別コード())) {

                            dbT5202Entity06AUpdate(ocrデータ解析結果, result);
                            dbT5207EntityUpdate(ocrデータ解析結果, result);
                            dbT5208EntityUpdate(ocrデータ解析結果, result);

                        }
                    } else if (ocrデータ解析結果.get調査区分().equals(基本調査区分)) {
                        if (厚労省IF識別コード_09B.equals(result.get厚労省IF識別コード())) {
                            managerKihon09b = new NinteichosahyoKihonChosa09BManager();
                            DbT5203NinteichosahyoKihonChosa09BEntity entityKihon = managerKihon09b.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号());
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon09b.update(entityKihon);
                        } else if (厚労省IF識別コード_09A.equals(result.get厚労省IF識別コード())) {
                            managerKihon09a = new NinteichosahyoKihonChosa09AManager();
                            DbT5203NinteichosahyoKihonChosa09AEntity entityKihon = managerKihon09a.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号());
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon09a.update(entityKihon);
                        } else if (厚労省IF識別コード_06A.equals(result.get厚労省IF識別コード())) {
                            managerKihon06a = new NinteichosahyoKihonChosa06AManager();
                            DbT5203NinteichosahyoKihonChosa06AEntity entityKihon = managerKihon06a.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号());
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon06a.update(entityKihon);
                        }
                    }
                }
                List<RString> imageList = new ArrayList<>();

                if (result.getイメージ共有ファイルID().compareTo(RDateTime.MIN) == 0) {
                    SharedFileDescriptor sfd = new SharedFileDescriptor(GyomuCode.DB介護保険, FilesystemName
                            .fromString(ocrデータ解析結果.get保険者番号().concat(ocrデータ解析結果.get被保険者番号())));
                    sfd = SharedFile.defineSharedFile(sfd);
                    CopyToSharedFileOpts opts = new CopyToSharedFileOpts().dateToDelete(RDate.getNowDate().plusMonth(1));
                    SharedFileEntryDescriptor entity = SharedFile.copyToSharedFile(sfd, new FilesystemPath(processParameter.getファイルPath()), opts);
                    DbT5115ImageEntity entityImage = new DbT5115ImageEntity();
                    entityImage.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                    entityImage.setImageSharedFileId(entity.getSharedFileId());
                    writerImage.insert(entityImage);
                } else {
                    imageList = ocrデータ解析結果.getイメージファイル();
                    if (imageList != null) {
                        for (int j = 0; j < imageList.size(); j++) {
                            ReadOnlySharedFileEntryDescriptor or_sfd = new ReadOnlySharedFileEntryDescriptor(FilesystemName
                                    .fromString(ocrデータ解析結果.get保険者番号().concat(ocrデータ解析結果.get被保険者番号())), result.getイメージ共有ファイルID());
                            SharedFile.appendNewFile(or_sfd, new FilesystemPath(processParameter.getファイルPath()), imageList.get(j).toString());
                        }
                    }
                }
            }
        }
    }

    private OcrDataReadResult チェック処理(OcrDataReadResult ocrデータ解析結果) {
        OcrJohoOcrDataRecordEntity ocrDataデータ行 = (OcrJohoOcrDataRecordEntity) ocrデータ解析結果.getOcrDataデータ行Entity();
        if (ocrDataデータ行 != null) {
            if (ocrDataデータ行.get調査区分().equals(概況調査区分)) {
                set概況調査(ocrデータ解析結果, ocrDataデータ行);
            } else if (ocrDataデータ行.get調査区分().equals(基本調査区分)) {
                set基本調査(ocrデータ解析結果, ocrDataデータ行);
            } else {
                ocrデータ解析結果.setイメージファイル(ocrDataデータ行.getファイルList());
            }
        }

        return ocrデータ解析結果;
    }

    private RString get実施場所名称(RString code) {
        if (実施場所コード１.equals(code)) {
            return 実施場所名称＿在宅;
        } else if (実施場所コード２.equals(code)) {
            return 実施場所名称＿施設;
        } else if (実施場所コード３.equals(code)) {
            return 実施場所名称＿その他;
        } else {
            return RString.EMPTY;
        }
    }

    private Boolean 住宅改修チェック(RString code) {
        if (住宅改修あり.equals(code)) {
            return Boolean.TRUE;
        } else if (住宅改修なし.equals(code)) {
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }

    private void set概況調査(OcrDataReadResult ocrデータ解析結果, OcrJohoOcrDataRecordEntity ocrDataデータ行) {

        ocrデータ解析結果.set調査区分(概況調査区分);
        ocrデータ解析結果.set保険者番号(ocrDataデータ行.get保険者番号());
        ocrデータ解析結果.set申請日(ocrDataデータ行.get申請日());
        ocrデータ解析結果.set被保険者番号(ocrDataデータ行.get被保険者番号());
        ocrデータ解析結果.set実施日時(ocrDataデータ行.get行項目_6());
        ocrデータ解析結果.set実施場所(ocrDataデータ行.get行項目_7());
        ocrデータ解析結果.set記入者(ocrDataデータ行.get行項目_8());
        ocrデータ解析結果.set所属機関(ocrDataデータ行.get行項目_9());
        ocrデータ解析結果.setサービス区分コード(ocrDataデータ行.get行項目_10());
        ocrデータ解析結果.set訪問介護の回数(ocrDataデータ行.get行項目_11());
        ocrデータ解析結果.set訪問入浴介護の回数(ocrDataデータ行.get行項目_12());
        ocrデータ解析結果.set訪問看護の回数(ocrDataデータ行.get行項目_13());
        ocrデータ解析結果.set訪問ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数(ocrDataデータ行.get行項目_14());
        ocrデータ解析結果.set居宅療養管理指導の回数(ocrDataデータ行.get行項目_15());
        ocrデータ解析結果.set通所看護の回数(ocrDataデータ行.get行項目_16());
        ocrデータ解析結果.set通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝの回数(ocrDataデータ行.get行項目_17());
        ocrデータ解析結果.set短期入所生活介護の日数(ocrDataデータ行.get行項目_18());
        ocrデータ解析結果.set短期入所療養介護の日数(ocrDataデータ行.get行項目_19());
        ocrデータ解析結果.set特定施設入所者生活介護の日数(ocrDataデータ行.get行項目_20());
        ocrデータ解析結果.set福祉用具貸与の品目(ocrDataデータ行.get行項目_21());
        ocrデータ解析結果.set福祉用具購入の品目(ocrDataデータ行.get行項目_22());
        ocrデータ解析結果.set住宅改修(ocrDataデータ行.get行項目_23());
        ocrデータ解析結果.set夜間対応型訪問介護の日数(ocrDataデータ行.get行項目_24());
        ocrデータ解析結果.set認知症対応型通所介護の日数(ocrDataデータ行.get行項目_25());
        ocrデータ解析結果.set小規模多機能型居宅介護の日数(ocrDataデータ行.get行項目_26());
        ocrデータ解析結果.set認知症対応型共同生活介護の日数(ocrDataデータ行.get行項目_27());
        ocrデータ解析結果.set地域密着型特定施設入居者生活介護の日数(ocrDataデータ行.get行項目_28());
        ocrデータ解析結果.set地域密着型介護老人福祉施設入居者生活介護の日数(ocrDataデータ行.get行項目_29());
        ocrデータ解析結果.set看護小規模多機能型居宅介護(ocrDataデータ行.get行項目_30());
        ocrデータ解析結果.set随時対応型訪問介護看護(ocrDataデータ行.get行項目_31());
        ocrデータ解析結果.set施設利用の有無(ocrDataデータ行.get行項目_32());

    }

    private void set基本調査(OcrDataReadResult ocrデータ解析結果, OcrJohoOcrDataRecordEntity ocrDataデータ行) {

        ocrデータ解析結果.set調査区分(基本調査区分);
        ocrデータ解析結果.set保険者番号(ocrDataデータ行.get保険者番号());
        ocrデータ解析結果.set申請日(ocrDataデータ行.get申請日());
        ocrデータ解析結果.set被保険者番号(ocrDataデータ行.get被保険者番号());
        ocrデータ解析結果.set麻痺(ocrDataデータ行.get行項目_6());
        ocrデータ解析結果.set拘縮(ocrDataデータ行.get行項目_7());
        ocrデータ解析結果.set寝返り(ocrDataデータ行.get行項目_8());
        ocrデータ解析結果.set起き上がり(ocrDataデータ行.get行項目_9());
        ocrデータ解析結果.set座位保持(ocrDataデータ行.get行項目_10());
        ocrデータ解析結果.set両足での立位(ocrDataデータ行.get行項目_11());
        ocrデータ解析結果.set歩行(ocrDataデータ行.get行項目_12());
        ocrデータ解析結果.set立ち上がり(ocrDataデータ行.get行項目_13());
        ocrデータ解析結果.set片足での立位(ocrDataデータ行.get行項目_14());
        ocrデータ解析結果.set洗身(ocrDataデータ行.get行項目_15());
        ocrデータ解析結果.setつめ切り(ocrDataデータ行.get行項目_16());
        ocrデータ解析結果.set視力(ocrDataデータ行.get行項目_17());
        ocrデータ解析結果.set聴力(ocrDataデータ行.get行項目_18());
        ocrデータ解析結果.set移乗(ocrDataデータ行.get行項目_19());
        ocrデータ解析結果.set移動(ocrDataデータ行.get行項目_20());
        ocrデータ解析結果.setえん下(ocrDataデータ行.get行項目_21());
        ocrデータ解析結果.set食事摂取(ocrDataデータ行.get行項目_22());
        ocrデータ解析結果.set排尿(ocrDataデータ行.get行項目_23());
        ocrデータ解析結果.set排便(ocrDataデータ行.get行項目_24());
        ocrデータ解析結果.set口腔清潔(ocrDataデータ行.get行項目_25());
        ocrデータ解析結果.set洗顔(ocrDataデータ行.get行項目_26());
        ocrデータ解析結果.set整髪(ocrDataデータ行.get行項目_27());
        ocrデータ解析結果.set上衣の着脱(ocrDataデータ行.get行項目_28());
        ocrデータ解析結果.setズボン等の着脱(ocrDataデータ行.get行項目_29());
        ocrデータ解析結果.set外出頻度(ocrDataデータ行.get行項目_30());
        ocrデータ解析結果.set意思の疎通(ocrDataデータ行.get行項目_31());
        ocrデータ解析結果.set毎日の日課を理解(ocrDataデータ行.get行項目_32());
        ocrデータ解析結果.set生年月日をいう(ocrDataデータ行.get行項目_33());
        ocrデータ解析結果.set短期記憶(ocrDataデータ行.get行項目_34());
        ocrデータ解析結果.set自分の名前をいう(ocrDataデータ行.get行項目_35());
        ocrデータ解析結果.set今の季節を理解(ocrDataデータ行.get行項目_36());
        ocrデータ解析結果.set場所の理解(ocrDataデータ行.get行項目_37());
        ocrデータ解析結果.set徘徊(ocrDataデータ行.get行項目_38());
        ocrデータ解析結果.set外出して戻れない(ocrDataデータ行.get行項目_39());
        ocrデータ解析結果.set被害的(ocrDataデータ行.get行項目_40());
        ocrデータ解析結果.set作話(ocrDataデータ行.get行項目_41());
        ocrデータ解析結果.set感情が不安定(ocrDataデータ行.get行項目_42());
        ocrデータ解析結果.set昼夜逆転(ocrDataデータ行.get行項目_43());
        ocrデータ解析結果.set同じ話をする(ocrDataデータ行.get行項目_44());
        ocrデータ解析結果.set大声を出す(ocrDataデータ行.get行項目_45());
        ocrデータ解析結果.set介護に抵抗(ocrDataデータ行.get行項目_46());
        ocrデータ解析結果.set落ち着きなし(ocrDataデータ行.get行項目_47());
        ocrデータ解析結果.set一人で出たがる(ocrDataデータ行.get行項目_48());
        ocrデータ解析結果.set収集癖(ocrDataデータ行.get行項目_49());
        ocrデータ解析結果.set物や衣類を壊す(ocrDataデータ行.get行項目_50());
        ocrデータ解析結果.setひどい物忘れ(ocrDataデータ行.get行項目_51());
        ocrデータ解析結果.set独り言(ocrDataデータ行.get行項目_52());
        ocrデータ解析結果.set自分勝手に行動する(ocrDataデータ行.get行項目_53());
        ocrデータ解析結果.set話がまとまらない(ocrDataデータ行.get行項目_54());
        ocrデータ解析結果.set薬の内服(ocrDataデータ行.get行項目_55());
        ocrデータ解析結果.set金銭の管理(ocrDataデータ行.get行項目_56());
        ocrデータ解析結果.set日常の意思決定(ocrDataデータ行.get行項目_57());
        ocrデータ解析結果.set集団への不適応(ocrDataデータ行.get行項目_58());
        ocrデータ解析結果.set買い物(ocrDataデータ行.get行項目_59());
        ocrデータ解析結果.set簡単な調理(ocrDataデータ行.get行項目_60());
        ocrデータ解析結果.set過去14日間に受けた治療(ocrDataデータ行.get行項目_61());
        ocrデータ解析結果.set障害高齢者の日常生活自立度(ocrDataデータ行.get障害高齢者の日常生活自立度());
        ocrデータ解析結果.set認知症高齢者の日常生活自立度(ocrDataデータ行.get認知症高齢者の日常生活自立度());

    }

    private void dbT5202Entity06AInsert(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {
        DbT5202NinteichosahyoGaikyoChosa06AEntity entity = new DbT5202NinteichosahyoGaikyoChosa06AEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
        entity.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
        entity.setGaikyoChosaTextImageKubun(イメージ区分);
        entity.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_06A));
        entity.setNinteichousaIraiKubunCode(result.get認定調査依頼区分コード());
        entity.setNinteichosaIraiKaisu(result.get認定調査回数());
        entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
        entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
        entity.setNinteiChosaKubunCode(new Code(新規調査));
        entity.setChosainCode(ocrデータ解析結果.get記入者());
        entity.setServiceKubunCode(new Code(ocrデータ解析結果.getサービス区分コード()));
        entity.setChosaItakusakiCode(new JigyoshaNo(ocrデータ解析結果.get所属機関()));
        entity.setChosaJisshiBashoCode(new Code(ocrデータ解析結果.get実施場所()));
        entity.setChosaJisshiBashoMeisho(get実施場所名称(ocrデータ解析結果.get実施場所()));
        entity.setRiyoShisetsuShimei(RString.EMPTY);
        entity.setRiyoShisetsuJusho(RString.EMPTY);
        entity.setRiyoShisetsuTelNo(RString.EMPTY);
        entity.setRiyoShisetsuYubinNo(YubinNo.EMPTY);
        entity.setTokki(RString.EMPTY);
        entity.setTokkijikoJuryoYMD(FlexibleDate.EMPTY);
        entity.setTokkijikoUketsukeYMD(FlexibleDate.EMPTY);
        writer06a.insert(entity);
    }

    private void dbT5202Entity09AInsert(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {
        DbT5202NinteichosahyoGaikyoChosa09AEntity entity = new DbT5202NinteichosahyoGaikyoChosa09AEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
        entity.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
        entity.setGaikyoChosaTextImageKubun(イメージ区分);
        entity.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_09A));
        entity.setNinteichousaIraiKubunCode(result.get認定調査依頼区分コード());
        entity.setNinteichosaIraiKaisu(result.get認定調査回数());
        entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
        entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
        entity.setNinteiChosaKubunCode(new Code(新規調査));
        entity.setChosainCode(ocrデータ解析結果.get記入者());
        entity.setServiceKubunCode(new Code(ocrデータ解析結果.getサービス区分コード()));
        entity.setChosaItakusakiCode(new JigyoshaNo(ocrデータ解析結果.get所属機関()));
        entity.setChosaJisshiBashoCode(new Code(ocrデータ解析結果.get実施場所()));
        entity.setChosaJisshiBashoMeisho(get実施場所名称(ocrデータ解析結果.get実施場所()));
        entity.setRiyoShisetsuShimei(RString.EMPTY);
        entity.setRiyoShisetsuJusho(RString.EMPTY);
        entity.setRiyoShisetsuTelNo(RString.EMPTY);
        entity.setRiyoShisetsuYubinNo(YubinNo.EMPTY);
        entity.setTokki(RString.EMPTY);
        entity.setTokkijikoJuryoYMD(FlexibleDate.EMPTY);
        entity.setTokkijikoUketsukeYMD(FlexibleDate.EMPTY);
        writer09a.insert(entity);
    }

    private void dbT5202Entity09BInsert(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {
        DbT5202NinteichosahyoGaikyoChosa09BEntity entity = new DbT5202NinteichosahyoGaikyoChosa09BEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
        entity.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
        entity.setGaikyoChosaTextImageKubun(イメージ区分);
        entity.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_09B));
        entity.setNinteichousaIraiKubunCode(result.get認定調査依頼区分コード());
        entity.setNinteichosaIraiKaisu(result.get認定調査回数());
        entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
        entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
        entity.setNinteiChosaKubunCode(new Code(新規調査));
        entity.setChosainCode(ocrデータ解析結果.get記入者());
        entity.setServiceKubunCode(new Code(ocrデータ解析結果.getサービス区分コード()));
        entity.setChosaItakusakiCode(new JigyoshaNo(ocrデータ解析結果.get所属機関()));
        entity.setChosaJisshiBashoCode(new Code(ocrデータ解析結果.get実施場所()));
        entity.setChosaJisshiBashoMeisho(get実施場所名称(ocrデータ解析結果.get実施場所()));
        entity.setRiyoShisetsuShimei(RString.EMPTY);
        entity.setRiyoShisetsuJusho(RString.EMPTY);
        entity.setRiyoShisetsuTelNo(RString.EMPTY);
        entity.setRiyoShisetsuYubinNo(YubinNo.EMPTY);
        entity.setTokki(RString.EMPTY);
        entity.setTokkijikoJuryoYMD(FlexibleDate.EMPTY);
        entity.setTokkijikoUketsukeYMD(FlexibleDate.EMPTY);
        writer09b.insert(entity);

    }

    private void dbT5202Entity06AUpdate(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {

        manager06a = new NinteichosahyoGaikyoChosa06AManager();
        DbT5202NinteichosahyoGaikyoChosa06AEntity entity = manager06a.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号(), イメージ区分);

        entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
        entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
        entity.setNinteiChosaKubunCode(new Code(新規調査));
        entity.setChosaItakusakiCode(new JigyoshaNo(ocrデータ解析結果.get所属機関()));
        entity.setChosaJisshiBashoCode(new Code(ocrデータ解析結果.get実施場所()));
        entity.setChosaJisshiBashoMeisho(get実施場所名称(ocrデータ解析結果.get実施場所()));
        writer06a.update(entity);

    }

    private void dbT5202Entity09AUpdate(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {

        manager09a = new NinteichosahyoGaikyoChosa09AManager();
        DbT5202NinteichosahyoGaikyoChosa09AEntity entity = manager09a.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号(), イメージ区分);

        entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
        entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
        entity.setNinteiChosaKubunCode(new Code(新規調査));
        entity.setChosaItakusakiCode(new JigyoshaNo(ocrデータ解析結果.get所属機関()));
        entity.setChosaJisshiBashoCode(new Code(ocrデータ解析結果.get実施場所()));
        entity.setChosaJisshiBashoMeisho(get実施場所名称(ocrデータ解析結果.get実施場所()));
        writer09a.update(entity);

    }

    private void dbT5202Entity09BUpdate(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {

        manager09b = new NinteichosahyoGaikyoChosa09BManager();
        DbT5202NinteichosahyoGaikyoChosa09BEntity entity = manager09b.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号(), イメージ区分);

        entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
        entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
        entity.setNinteiChosaKubunCode(new Code(新規調査));
        entity.setChosaItakusakiCode(new JigyoshaNo(ocrデータ解析結果.get所属機関()));
        entity.setChosaJisshiBashoCode(new Code(ocrデータ解析結果.get実施場所()));
        entity.setChosaJisshiBashoMeisho(get実施場所名称(ocrデータ解析結果.get実施場所()));
        writer09b.update(entity);

    }

    private void dbT5207EntityInsert(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {
        DbT5207NinteichosahyoServiceJokyoEntity entityService = new DbT5207NinteichosahyoServiceJokyoEntity();
        entityService.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
        entityService.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
        entityService.setKoroshoIfShikibetsuCode(new Code(result.get厚労省IF識別コード()));
        entityService.setRemban(連番1);
        entityService.setServiceJokyo(Integer.parseInt(ocrデータ解析結果.get訪問介護の回数().toString()));
        writerService.insert(entityService);
        DbT5207NinteichosahyoServiceJokyoEntity entity1 = entityService.clone();
        entity1.setRemban(連番2);
        entity1.setServiceJokyo(Integer.parseInt(ocrデータ解析結果.get訪問入浴介護の回数().toString()));
        writerService.insert(entity1);
        DbT5207NinteichosahyoServiceJokyoEntity entity2 = entityService.clone();
        entity2.setRemban(連番3);
        entity2.setServiceJokyo(Integer.parseInt(ocrデータ解析結果.get訪問看護の回数().toString()));
        writerService.insert(entity2);

    }

    private void dbT5208EntityInsert(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {
        DbT5208NinteichosahyoServiceJokyoFlagEntity serviceFlag = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
        serviceFlag.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
        serviceFlag.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
        serviceFlag.setKoroshoIfShikibetsuCode(new Code(result.get厚労省IF識別コード()));
        serviceFlag.setRemban(連番1);
        serviceFlag.setServiceJokyoFlag(住宅改修チェック(ocrデータ解析結果.get住宅改修()));

        writerServiceFlag.insert(serviceFlag);
    }

    private void dbT5210EntityInsert(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {
        DbT5210NinteichosahyoShisetsuRiyoEntity entityShisetsu = new DbT5210NinteichosahyoShisetsuRiyoEntity();
        entityShisetsu.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
        entityShisetsu.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
        entityShisetsu.setKoroshoIfShikibetsuCode(new Code(result.get厚労省IF識別コード()));
        entityShisetsu.setRemban(連番1);
        entityShisetsu.setShisetsuRiyoFlag(施設利用チェック(entityShisetsu.getRemban()));
        writerShisetsu.insert(entityShisetsu);
    }

    private void dbT5211EntityInsert(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {
        DbT5211NinteichosahyoChosaItemEntity entityItem = new DbT5211NinteichosahyoChosaItemEntity();
        entityItem.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
        entityItem.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
        entityItem.setKoroshoIfShikibetsuCode(new Code(result.get厚労省IF識別コード()));
        entityItem.setRemban(連番1);
        entityItem.setResearchItem(ocrデータ解析結果.get麻痺().substring(0, 1));
        writerItem.insert(entityItem);
    }

    private void dbT5207EntityUpdate(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {

        serviceManager = new NinteichosahyoServiceJokyoManager();

        DbT5207NinteichosahyoServiceJokyoEntity entityService = serviceManager.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号(), 連番1);
        if (entityService != null) {
            entityService.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
            entityService.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
            entityService.setRemban(連番1);
            entityService.setServiceJokyo(Integer.parseInt(ocrデータ解析結果.get訪問介護の回数().toString()));
            writerService.update(entityService);
        }

//        DbT5207NinteichosahyoServiceJokyoEntity entity1 = entityService.clone();
//        entity1.setRemban(連番2);
//        entity1.setServiceJokyo(Integer.parseInt(ocrデータ解析結果.get訪問入浴介護の回数().toString()));
//        writerService.insert(entity1);
//        DbT5207NinteichosahyoServiceJokyoEntity entity2 = entityService.clone();
//        entity2.setRemban(連番3);
//        entity2.setServiceJokyo(Integer.parseInt(ocrデータ解析結果.get訪問看護の回数().toString()));
//        writerService.insert(entity2);
    }

    private void dbT5208EntityUpdate(OcrDataReadResult ocrデータ解析結果, NinteiOcrResult result) {

        serviceFlagManager = new NinteichosahyoServiceJokyoFlagManager();

        DbT5208NinteichosahyoServiceJokyoFlagEntity entityFlag = serviceFlagManager.selectサービスの状況フラグ(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号(), 連番1);
        if (entityFlag != null) {
            entityFlag.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
            entityFlag.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
            entityFlag.setRemban(連番1);
            entityFlag.setServiceJokyoFlag(住宅改修チェック(ocrデータ解析結果.get住宅改修()));
            writerServiceFlag.update(entityFlag);
        }
    }

    private Boolean 施設利用チェック(int code) {
        if (連番5 == code) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
