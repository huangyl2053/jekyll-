/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ocrdataread;

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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5115ImageEntity;
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
    
    private NinteichosahyoGaikyoChosa09BManager manager09b;
    private NinteichosahyoGaikyoChosa09AManager manager09a;
    private NinteichosahyoGaikyoChosa06AManager manager06a;
    private NinteichosahyoKihonChosa06AManager managerKihon06a;
    private NinteichosahyoKihonChosa09AManager managerKihon09a;
    private NinteichosahyoKihonChosa09BManager managerKihon09b;
    
    @BatchWriter
    private BatchPermanentTableWriter<DbT5202NinteichosahyoGaikyoChosa09BEntity> writer09b;
    private BatchPermanentTableWriter<DbT5202NinteichosahyoGaikyoChosa09AEntity> writer09a;
    private BatchPermanentTableWriter<DbT5202NinteichosahyoGaikyoChosa06AEntity> writer06a;
    private BatchPermanentTableWriter<DbT5207NinteichosahyoServiceJokyoEntity> writerService;
    private BatchPermanentTableWriter<DbT5208NinteichosahyoServiceJokyoFlagEntity> writerServiceFlag;
    private BatchPermanentTableWriter<DbT5210NinteichosahyoShisetsuRiyoEntity> writerShisetsu;
    private BatchPermanentTableWriter<DbT5203NinteichosahyoKihonChosa06AEntity> writerKihon06a;
    private BatchPermanentTableWriter<DbT5203NinteichosahyoKihonChosa09AEntity> writerKihon09a;
    private BatchPermanentTableWriter<DbT5203NinteichosahyoKihonChosa09BEntity> writerKihon09b;
    private BatchPermanentTableWriter<DbT5211NinteichosahyoChosaItemEntity> writerItem;
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
                            
                            DbT5202NinteichosahyoGaikyoChosa09BEntity entity = new DbT5202NinteichosahyoGaikyoChosa09BEntity();
                            entity.setGaikyoChosaTextImageKubun(イメージ区分);
                            entity.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_09B));
                            entity.setNinteiChosaKubunCode(result.get認定調査依頼区分コード());
                            entity.setNinteichosaIraiKaisu(result.get認定調査回数());
                            entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
                            entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
                            entity.setNinteiChosaKubunCode(new Code(新規調査));
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
                            
                        } else if (厚労省IF識別コード_09A.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5202NinteichosahyoGaikyoChosa09AEntity entity = new DbT5202NinteichosahyoGaikyoChosa09AEntity();
                            entity.setGaikyoChosaTextImageKubun(イメージ区分);
                            entity.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_09A));
                            entity.setNinteiChosaKubunCode(result.get認定調査依頼区分コード());
                            entity.setNinteichosaIraiKaisu(result.get認定調査回数());
                            entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
                            entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
                            entity.setNinteiChosaKubunCode(new Code(新規調査));
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
                            
                        } else if (厚労省IF識別コード_06A.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5202NinteichosahyoGaikyoChosa06AEntity entity = new DbT5202NinteichosahyoGaikyoChosa06AEntity();
                            
                            entity.setGaikyoChosaTextImageKubun(イメージ区分);
                            entity.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_06A));
                            entity.setNinteiChosaKubunCode(result.get認定調査依頼区分コード());
                            entity.setNinteichosaIraiKaisu(result.get認定調査回数());
                            entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
                            entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
                            entity.setNinteiChosaKubunCode(new Code(新規調査));
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
                    } else if (ocrデータ解析結果.get調査区分().equals(基本調査区分)) {
                        if (厚労省IF識別コード_09B.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5203NinteichosahyoKihonChosa09BEntity entityKihon = new DbT5203NinteichosahyoKihonChosa09BEntity();
                            DbT5211NinteichosahyoChosaItemEntity entityItem = new DbT5211NinteichosahyoChosaItemEntity();
                            
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_09A));
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            
                            writerKihon09b.insert(entityKihon);
                            
                        } else if (厚労省IF識別コード_09A.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5203NinteichosahyoKihonChosa09AEntity entityKihon = new DbT5203NinteichosahyoKihonChosa09AEntity();
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_09A));
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon09a.insert(entityKihon);
                            
                        } else if (厚労省IF識別コード_06A.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5203NinteichosahyoKihonChosa06AEntity entityKihon = new DbT5203NinteichosahyoKihonChosa06AEntity();
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setKoroshoIfShikibetsuCode(new Code(厚労省IF識別コード_06A));
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon06a.insert(entityKihon);
                            
                        }
                    }
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
                    if (ocrデータ解析結果.get調査区分().equals(概況調査区分)) {
                        if (厚労省IF識別コード_09B.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5202NinteichosahyoGaikyoChosa09BEntity entity = manager09b.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号(), イメージ区分);
                            
                            entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
                            entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
                            entity.setNinteiChosaKubunCode(new Code(新規調査));
                            entity.setChosaItakusakiCode(new JigyoshaNo(ocrデータ解析結果.get所属機関()));
                            entity.setChosaJisshiBashoCode(new Code(ocrデータ解析結果.get実施場所()));
                            entity.setChosaJisshiBashoMeisho(get実施場所名称(ocrデータ解析結果.get実施場所()));
                            writer09b.update(entity);
                            
                        } else if (厚労省IF識別コード_09A.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5202NinteichosahyoGaikyoChosa09AEntity entity = manager09a.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号(), イメージ区分);
                            
                            entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
                            entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
                            entity.setNinteiChosaKubunCode(new Code(新規調査));
                            entity.setChosaItakusakiCode(new JigyoshaNo(ocrデータ解析結果.get所属機関()));
                            entity.setChosaJisshiBashoCode(new Code(ocrデータ解析結果.get実施場所()));
                            entity.setChosaJisshiBashoMeisho(get実施場所名称(ocrデータ解析結果.get実施場所()));
                            writer09a.update(entity);
                            
                        } else if (厚労省IF識別コード_06A.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5202NinteichosahyoGaikyoChosa06AEntity entity = manager06a.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号(), イメージ区分);
                            
                            entity.setNinteichosaJisshiYMD(new FlexibleDate(ocrデータ解析結果.get実施日時()));
                            entity.setNinteichosaJuryoYMD(FlexibleDate.getNowDate());
                            entity.setNinteiChosaKubunCode(new Code(新規調査));
                            entity.setChosaItakusakiCode(new JigyoshaNo(ocrデータ解析結果.get所属機関()));
                            entity.setChosaJisshiBashoCode(new Code(ocrデータ解析結果.get実施場所()));
                            entity.setChosaJisshiBashoMeisho(get実施場所名称(ocrデータ解析結果.get実施場所()));
                            writer06a.update(entity);
                            
                        }
                    } else if (ocrデータ解析結果.get調査区分().equals(基本調査区分)) {
                        if (厚労省IF識別コード_09B.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5203NinteichosahyoKihonChosa09BEntity entityKihon = managerKihon09b.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号());
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon09b.update(entityKihon);
                            
                        } else if (厚労省IF識別コード_09A.equals(result.get厚労省IF識別コード())) {
                            DbT5203NinteichosahyoKihonChosa09AEntity entityKihon = managerKihon09a.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号());
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon09a.update(entityKihon);
                        } else if (厚労省IF識別コード_06A.equals(result.get厚労省IF識別コード())) {
                            
                            DbT5203NinteichosahyoKihonChosa06AEntity entityKihon = managerKihon06a.select認定調査票(new ShinseishoKanriNo(result.get申請書管理番号()), result.get認定調査依頼履歴番号());
                            entityKihon.setShinseishoKanriNo(new ShinseishoKanriNo(result.get申請書管理番号()));
                            entityKihon.setNinteichosaRirekiNo(result.get認定調査依頼履歴番号());
                            entityKihon.setShogaiNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get障害高齢者の日常生活自立度()));
                            entityKihon.setNinchishoNichijoSeikatsuJiritsudoCode(new Code(ocrデータ解析結果.get認知症高齢者の日常生活自立度()));
                            writerKihon06a.update(entityKihon);
                        }
                    }
                    List<RString> imageList = ocrデータ解析結果.getイメージファイル();
                    for (int j = 0; j < imageList.size(); j++) {
                        ReadOnlySharedFileEntryDescriptor or_sfd = new ReadOnlySharedFileEntryDescriptor(FilesystemName
                                .fromString(ocrデータ解析結果.get保険者番号().concat(ocrデータ解析結果.get被保険者番号())), result.getイメージ共有ファイルID());
                        SharedFile.appendNewFile(or_sfd, new FilesystemPath(processParameter.getファイルPath()), imageList.get(i).toString());
                    }
                }
            }
        }
    }
    
    private OcrDataReadResult チェック処理(OcrDataReadResult ocrデータ解析結果) {
        
        OcrJohoOcrDataRecordEntity ocrDataデータ行 = (OcrJohoOcrDataRecordEntity) ocrデータ解析結果.getOcrDataデータ行Entity();
        
        if (ocrDataデータ行 != null) {
            if (ocrDataデータ行.get調査区分().equals(概況調査区分)) {
                
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
                
            } else if (ocrDataデータ行.get調査区分().equals(基本調査区分)) {
                
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
    
}
