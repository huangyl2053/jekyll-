/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb314001;

import jp.co.ndensan.reams.db.dbb.definition.core.gemmenchoshuyuyo.GemmenChoshuYuyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.gemmenchoshuyuyo.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb314001.GemmenProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2004GemmenEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajoho.fukajoho.FukaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku.DbT2002FukaJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen.GemmenCsvEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.gemmen.GemmenEntity;
import jp.co.ndensan.reams.db.dbb.service.core.gemmen.gemmen.GemmenCsvEditor;
import jp.co.ndensan.reams.db.dbx.definition.core.choteijiyu.ChoteiJiyuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * バッチ設計_DBBMN61002_介護保険料減免登録(一括)のProcess
 *
 * @reamsid_L DBB-1670-030 surun
 */
public class GemmenProcess extends BatchProcessBase<GemmenEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "gemmen.IGemmenMapper.getData");
    private static final RString 賦課の情報一時_TABLE_NAME = new RString("DbT2002FukaJohoTemp");
    private static final RString 出力ファイル名 = new RString("GENMENKEKKA.csv");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final int INDEX_ONE = 1;
    private YMDHMS システム日時;
    private RString eucFilePath;
    private GemmenProcessParameter processParameter;
    private GemmenCsvEditor csvEditor;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 賦課の情報一時tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbV2004GemmenEntity> 介護賦課減免tableWriter;
    private CsvWriter<GemmenCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        システム日時 = YMDHMS.now();
        csvEditor = new GemmenCsvEditor();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder builder = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険,
                KensakuYusenKubun.住登外優先);
        IShikibetsuTaishoPSMSearchKey searchKey = builder.build();
        processParameter.set宛名検索条件(searchKey);
        return new BatchDbReader(READ_DATA_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        賦課の情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(賦課の情報一時_TABLE_NAME, DbT2002FukaJohoTempTableEntity.class);
        介護賦課減免tableWriter = new BatchPermanentTableWriter<>(DbV2004GemmenEntity.class);
        RString spoolWorkPath = Path.getTmpDirectoryPath();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();
    }

    @Override
    protected void process(GemmenEntity entity) {
        if (entity != null && entity.get賦課の情報() != null && entity.get賦課の情報().get介護賦課Entity() != null) {
            DbT2002FukaJohoTempTableEntity 賦課の情報一時Data = 賦課の情報一時編集(entity);
            介護賦課減免編集(賦課の情報一時Data);
            csvWriter.writeLine(csvEditor.editor(entity, 賦課の情報一時Data));
        }
    }

    private DbT2002FukaJohoTempTableEntity 賦課の情報一時編集(GemmenEntity entity) {
        DbT2002FukaJohoTempTableEntity tempEntity = new DbT2002FukaJohoTempTableEntity();
        FukaJohoRelateEntity 賦課の情報 = entity.get賦課の情報();
        DbT2002FukaEntity 介護賦課Entity = 賦課の情報.get介護賦課Entity();
        FlexibleYear 調定年度 = 介護賦課Entity.getChoteiNendo();
        FlexibleYear 賦課年度 = 介護賦課Entity.getFukaNendo();
        TsuchishoNo 通知書番号 = 介護賦課Entity.getTsuchishoNo();
        HihokenshaNo 被保険者番号 = 介護賦課Entity.getHihokenshaNo();
        if (調定年度 != null && 賦課年度 != null && 通知書番号 != null && 被保険者番号 != null) {
            tempEntity.setChoteiNendo(調定年度);
            tempEntity.setFukaNendo(賦課年度);
            tempEntity.setTsuchishoNo(通知書番号);
            tempEntity.setRirekiNo(介護賦課Entity.getRirekiNo() + INDEX_ONE);
            tempEntity.setHihokenshaNo(被保険者番号);
            tempEntity.setShikibetsuCode(介護賦課Entity.getShikibetsuCode());
            tempEntity.setSetaiCode(介護賦課Entity.getSetaiCode());
            tempEntity.setSetaiInsu(介護賦課Entity.getSetaiInsu());
            tempEntity.setShikakuShutokuYMD(介護賦課Entity.getShikakuShutokuYMD());
            tempEntity.setShikakuShutokuJiyu(介護賦課Entity.getShikakuShutokuJiyu());
            tempEntity.setShikakuSoshitsuYMD(介護賦課Entity.getShikakuSoshitsuYMD());
            tempEntity.setShikakuSoshitsuJiyu(介護賦課Entity.getShikakuSoshitsuJiyu());
            tempEntity.setSeihofujoShurui(介護賦課Entity.getSeihofujoShurui());
            tempEntity.setSeihoKaishiYMD(介護賦課Entity.getSeihoKaishiYMD());
            tempEntity.setSeihoHaishiYMD(介護賦課Entity.getSeihoHaishiYMD());
            tempEntity.setRonenKaishiYMD(介護賦課Entity.getRonenKaishiYMD());
            tempEntity.setRonenHaishiYMD(介護賦課Entity.getRonenHaishiYMD());
            tempEntity.setFukaYMD(介護賦課Entity.getFukaYMD());
            tempEntity.setKazeiKubun(介護賦課Entity.getKazeiKubun());
            tempEntity.setSetaikazeiKubun(介護賦課Entity.getSetaikazeiKubun());
            tempEntity.setGokeiShotokuGaku(介護賦課Entity.getGokeiShotokuGaku());
            tempEntity.setNenkinShunyuGaku(介護賦課Entity.getNenkinShunyuGaku());
            tempEntity.setHokenryoDankai(介護賦課Entity.getHokenryoDankai());
            tempEntity.setHokenryoDankai1(介護賦課Entity.getHokenryoDankai1());
            tempEntity.setNengakuHokenryo1(介護賦課Entity.getNengakuHokenryo1());
            tempEntity.setTsukiwariStartYM1(介護賦課Entity.getTsukiwariStartYM1());
            tempEntity.setTsukiwariEndYM1(介護賦課Entity.getTsukiwariEndYM1());
            tempEntity.setHokenryoDankai2(介護賦課Entity.getHokenryoDankai2());
            tempEntity.setNengakuHokenryo2(介護賦課Entity.getNengakuHokenryo2());
            tempEntity.setTsukiwariStartYM2(介護賦課Entity.getTsukiwariStartYM2());
            tempEntity.setTsukiwariEndYM2(介護賦課Entity.getTsukiwariEndYM2());
            tempEntity.setChoteiNichiji(システム日時);
            tempEntity.setChoteiJiyu1(ChoteiJiyuCode.減免決定による更正.getコード());
            tempEntity.setChoteiJiyu2(RString.EMPTY);
            tempEntity.setChoteiJiyu3(RString.EMPTY);
            tempEntity.setChoteiJiyu4(RString.EMPTY);
            tempEntity.setKoseiM(new RString(システム日時.getMonthValue()));
            tempEntity.setGemmenMaeHokenryo(介護賦課Entity.getGemmenMaeHokenryo());
            tempEntity.setGemmenGaku(介護賦課Entity.getGemmenMaeHokenryo());
            Decimal 減免前介護保険料 = 介護賦課Entity.getGemmenMaeHokenryo();
            if (減免前介護保険料 != null) {
                tempEntity.setKakuteiHokenryo(減免前介護保険料.subtract(介護賦課Entity.getGemmenGaku()));
            }
            tempEntity.setHokenryoDankaiKarisanntei(介護賦課Entity.getHokenryoDankaiKarisanntei());
            tempEntity.setChoshuHohoRirekiNo(介護賦課Entity.getChoshuHohoRirekiNo());
            tempEntity.setIdoKijunNichiji(システム日時);
            tempEntity.setKozaKubun(介護賦課Entity.getKozaKubun());
            tempEntity.setKyokaisoKubun(介護賦課Entity.getKyokaisoKubun());
            tempEntity.setShokkenKubun(介護賦課Entity.getShokkenKubun());
            tempEntity.setFukaShichosonCode(介護賦課Entity.getFukaShichosonCode());
            tempEntity.setTkSaishutsuKampuGaku(介護賦課Entity.getTkSaishutsuKampuGaku());
            tempEntity.setFuSaishutsuKampuGaku(介護賦課Entity.getFuSaishutsuKampuGaku());
            tempEntity.setTkKibetsuGaku01(Decimal.ZERO);
            tempEntity.setTkKibetsuGaku02(Decimal.ZERO);
            tempEntity.setTkKibetsuGaku03(Decimal.ZERO);
            tempEntity.setTkKibetsuGaku04(Decimal.ZERO);
            tempEntity.setTkKibetsuGaku05(Decimal.ZERO);
            tempEntity.setTkKibetsuGaku06(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku01(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku02(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku03(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku04(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku05(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku06(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku07(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku08(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku09(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku10(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku11(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku12(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku13(Decimal.ZERO);
            tempEntity.setFuKibetsuGaku14(Decimal.ZERO);
            賦課の情報一時tableWriter.insert(tempEntity);
        }
        return tempEntity;
    }

    private DbV2004GemmenEntity 介護賦課減免編集(DbT2002FukaJohoTempTableEntity 賦課の情報一時Data) {
        DbV2004GemmenEntity 減免Entity = new DbV2004GemmenEntity();
        if (賦課の情報一時Data != null) {
            減免Entity.setChoteiNendo(賦課の情報一時Data.getChoteiNendo());
            減免Entity.setFukaNendo(賦課の情報一時Data.getFukaNendo());
            減免Entity.setTsuchishoNo(賦課の情報一時Data.getTsuchishoNo());
            減免Entity.setRirekiNo(賦課の情報一時Data.getRirekiNo());
            if (processParameter != null) {
                減免Entity.setShinseiYMD(processParameter.getShinseiYMD());
                減免Entity.setKetteiYMD(processParameter.getKetteiYMD());
            }
            減免Entity.setTorikeshiYMD(null);
            減免Entity.setJotaiKubun(GemmenChoshuYuyoStateKubun.決定_承認.getコード());
            減免Entity.setSakuseiKubun(GemmenChoshuYuyoSakuseiKubun.決定_承認.getコード());
            if (processParameter != null) {
                減免Entity.setShinseiJiyu(processParameter.getShinseiJiyu());
                減免Entity.setGemmenJiyuCode(processParameter.getGemmenJiyuCode());
            }
            減免Entity.setGemmenJiyu(RString.EMPTY);
            減免Entity.setGemmenTorikeshiJiyuCode(null);
            減免Entity.setGemmenTorikeshiJiyu(RString.EMPTY);
            減免Entity.setShinseiGemmenGaku(賦課の情報一時Data.getGemmenGaku());
            減免Entity.setKetteiGemmenGaku(賦課の情報一時Data.getGemmenGaku());
            減免Entity.setTorikeshiGemmenGaku(Decimal.ZERO);
            介護賦課減免tableWriter.insert(減免Entity);
        }
        return 減免Entity;
    }

}
