/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB314001;

import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmenfukajoho.FukaJohoTempResult;
import jp.co.ndensan.reams.db.dbb.definition.core.gemmenchoshuyuyo.GemmenChoshuYuyoSakuseiKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.gemmenchoshuyuyo.GemmenChoshuYuyoStateKubun;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb314001.GemmenProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2004GemmenEntity;
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
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

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
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB300021"));
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final int INDEX_ONE = 1;
    private YMDHMS システム日時;
    private RString eucFilePath;
    private GemmenProcessParameter processParameter;
    private GemmenCsvEditor csvEditor;
    private DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity;
    private UaFt200FindShikibetsuTaishoEntity 宛名Entity;
    private FileSpoolManager manager;
    private FlexibleYear choteiNendo = FlexibleYear.EMPTY;
    private FlexibleYear fukaNendo = FlexibleYear.EMPTY;
    private TsuchishoNo tsuchishoNo = TsuchishoNo.EMPTY;
    private int rirekiNo = 0;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter 賦課の情報一時tableWriter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT2004GemmenEntity> 介護賦課減免tableWriter;
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
        processParameter.set宛名検索条件(new UaFt200FindShikibetsuTaishoParam(searchKey));
        return new BatchDbReader(READ_DATA_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        賦課の情報一時tableWriter
                = new BatchEntityCreatedTempTableWriter(賦課の情報一時_TABLE_NAME, DbT2002FukaJohoTempTableEntity.class);
        介護賦課減免tableWriter = new BatchPermanentTableWriter<>(DbT2004GemmenEntity.class);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
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
        if (choteiNendo.equals(entity.get介護賦課().getChoteiNendo()) && fukaNendo.equals(entity.get介護賦課().getFukaNendo())
                && tsuchishoNo.equals(entity.get介護賦課().getTsuchishoNo()) && rirekiNo == entity.get介護賦課().getRirekiNo()) {
            賦課の情報一時Entity = new FukaJohoTempResult().get処理前Entity(賦課の情報一時Entity, entity);
        } else {
            if (賦課の情報一時Entity != null) {
                DbT2002FukaJohoTempTableEntity 賦課の情報一時処理後Data = 賦課の情報一時編集(賦課の情報一時Entity);
                介護賦課減免編集(賦課の情報一時処理後Data);
                csvWriter.writeLine(csvEditor.editor(賦課の情報一時Entity, 賦課の情報一時処理後Data, 宛名Entity));
            }
            賦課の情報一時Entity = new DbT2002FukaJohoTempTableEntity();
            set介護賦課(賦課の情報一時Entity, entity);
            宛名Entity = entity.get宛名Entity();
            choteiNendo = entity.get介護賦課().getChoteiNendo();
            fukaNendo = entity.get介護賦課().getFukaNendo();
            tsuchishoNo = entity.get介護賦課().getTsuchishoNo();
            rirekiNo = entity.get介護賦課().getRirekiNo();
            賦課の情報一時Entity = new FukaJohoTempResult().get処理前Entity(賦課の情報一時Entity, entity);
        }
    }

    @Override
    protected void afterExecute() {
        if (賦課の情報一時Entity != null) {
            DbT2002FukaJohoTempTableEntity 賦課の情報一時処理後Data = 賦課の情報一時編集(賦課の情報一時Entity);
            介護賦課減免編集(賦課の情報一時処理後Data);
            csvWriter.writeLine(csvEditor.editor(賦課の情報一時Entity, 賦課の情報一時処理後Data, 宛名Entity));
        }
        csvWriter.close();
        manager.spool(SubGyomuCode.DBB介護賦課, eucFilePath);

    }

    private void set介護賦課(DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity, GemmenEntity entity) {
        DbT2002FukaEntity 介護賦課 = entity.get介護賦課();
        賦課の情報一時Entity.setChoteiNendo(介護賦課.getChoteiNendo());
        賦課の情報一時Entity.setFukaNendo(介護賦課.getFukaNendo());
        賦課の情報一時Entity.setTsuchishoNo(介護賦課.getTsuchishoNo());
        賦課の情報一時Entity.setRirekiNo(介護賦課.getRirekiNo());
        賦課の情報一時Entity.setHihokenshaNo(介護賦課.getHihokenshaNo());
        賦課の情報一時Entity.setShikibetsuCode(介護賦課.getShikibetsuCode());
        賦課の情報一時Entity.setSetaiCode(介護賦課.getSetaiCode());
        賦課の情報一時Entity.setSetaiInsu(介護賦課.getSetaiInsu());
        賦課の情報一時Entity.setShikakuShutokuYMD(介護賦課.getShikakuShutokuYMD());
        賦課の情報一時Entity.setShikakuShutokuJiyu(介護賦課.getShikakuShutokuJiyu());
        賦課の情報一時Entity.setShikakuSoshitsuYMD(介護賦課.getShikakuSoshitsuYMD());
        賦課の情報一時Entity.setShikakuSoshitsuJiyu(介護賦課.getShikakuSoshitsuJiyu());
        賦課の情報一時Entity.setSeihofujoShurui(介護賦課.getSeihofujoShurui());
        賦課の情報一時Entity.setSeihoKaishiYMD(介護賦課.getSeihoKaishiYMD());
        賦課の情報一時Entity.setSeihoHaishiYMD(介護賦課.getSeihoHaishiYMD());
        賦課の情報一時Entity.setRonenKaishiYMD(介護賦課.getRonenKaishiYMD());
        賦課の情報一時Entity.setRonenHaishiYMD(介護賦課.getRonenHaishiYMD());
        賦課の情報一時Entity.setFukaYMD(介護賦課.getFukaYMD());
        賦課の情報一時Entity.setKazeiKubun(介護賦課.getKazeiKubun());
        賦課の情報一時Entity.setSetaikazeiKubun(介護賦課.getSetaikazeiKubun());
        賦課の情報一時Entity.setGokeiShotokuGaku(介護賦課.getGokeiShotokuGaku());
        賦課の情報一時Entity.setNenkinShunyuGaku(介護賦課.getNenkinShunyuGaku());
        賦課の情報一時Entity.setHokenryoDankai(介護賦課.getHokenryoDankai());
        賦課の情報一時Entity.setHokenryoDankai1(介護賦課.getHokenryoDankai1());
        賦課の情報一時Entity.setNengakuHokenryo1(介護賦課.getNengakuHokenryo1());
        賦課の情報一時Entity.setTsukiwariStartYM1(介護賦課.getTsukiwariStartYM1());
        賦課の情報一時Entity.setTsukiwariEndYM1(介護賦課.getTsukiwariEndYM1());
        賦課の情報一時Entity.setHokenryoDankai2(介護賦課.getHokenryoDankai2());
        賦課の情報一時Entity.setNengakuHokenryo2(介護賦課.getNengakuHokenryo2());
        賦課の情報一時Entity.setTsukiwariStartYM2(介護賦課.getTsukiwariStartYM2());
        賦課の情報一時Entity.setTsukiwariEndYM2(介護賦課.getTsukiwariEndYM2());
        賦課の情報一時Entity.setChoteiNichiji(介護賦課.getChoteiNichiji());
        賦課の情報一時Entity.setChoteiJiyu1(介護賦課.getChoteiJiyu1());
        賦課の情報一時Entity.setChoteiJiyu2(介護賦課.getChoteiJiyu2());
        賦課の情報一時Entity.setChoteiJiyu3(介護賦課.getChoteiJiyu3());
        賦課の情報一時Entity.setChoteiJiyu4(介護賦課.getChoteiJiyu4());
        賦課の情報一時Entity.setKoseiM(介護賦課.getKoseiM());
        賦課の情報一時Entity.setGemmenMaeHokenryo(介護賦課.getGemmenMaeHokenryo());
        賦課の情報一時Entity.setGemmenGaku(介護賦課.getGemmenGaku());
        賦課の情報一時Entity.setKakuteiHokenryo(介護賦課.getKakuteiHokenryo());
        賦課の情報一時Entity.setHokenryoDankaiKarisanntei(介護賦課.getHokenryoDankaiKarisanntei());
        賦課の情報一時Entity.setChoshuHohoRirekiNo(介護賦課.getChoshuHohoRirekiNo());
        賦課の情報一時Entity.setIdoKijunNichiji(介護賦課.getIdoKijunNichiji());
        賦課の情報一時Entity.setKozaKubun(介護賦課.getKozaKubun());
        賦課の情報一時Entity.setKyokaisoKubun(介護賦課.getKyokaisoKubun());
        賦課の情報一時Entity.setShokkenKubun(介護賦課.getShokkenKubun());
        賦課の情報一時Entity.setFukaShichosonCode(介護賦課.getFukaShichosonCode());
        賦課の情報一時Entity.setTkSaishutsuKampuGaku(介護賦課.getTkSaishutsuKampuGaku());
        賦課の情報一時Entity.setFuSaishutsuKampuGaku(介護賦課.getFuSaishutsuKampuGaku());
    }

    private DbT2002FukaJohoTempTableEntity 賦課の情報一時編集(DbT2002FukaJohoTempTableEntity 賦課の情報一時Entity) {
        DbT2002FukaJohoTempTableEntity tempEntity = new DbT2002FukaJohoTempTableEntity();
        FlexibleYear 調定年度 = 賦課の情報一時Entity.getChoteiNendo();
        FlexibleYear 賦課年度 = 賦課の情報一時Entity.getFukaNendo();
        TsuchishoNo 通知書番号 = 賦課の情報一時Entity.getTsuchishoNo();
        HihokenshaNo 被保険者番号 = 賦課の情報一時Entity.getHihokenshaNo();
        if (調定年度 != null && 賦課年度 != null && 通知書番号 != null && 被保険者番号 != null) {
            tempEntity.setChoteiNendo(調定年度);
            tempEntity.setFukaNendo(賦課年度);
            tempEntity.setTsuchishoNo(通知書番号);
            tempEntity.setRirekiNo(賦課の情報一時Entity.getRirekiNo() + INDEX_ONE);
            tempEntity.setHihokenshaNo(被保険者番号);
            tempEntity.setShikibetsuCode(賦課の情報一時Entity.getShikibetsuCode());
            tempEntity.setSetaiCode(賦課の情報一時Entity.getSetaiCode());
            tempEntity.setSetaiInsu(賦課の情報一時Entity.getSetaiInsu());
            tempEntity.setShikakuShutokuYMD(賦課の情報一時Entity.getShikakuShutokuYMD());
            tempEntity.setShikakuShutokuJiyu(賦課の情報一時Entity.getShikakuShutokuJiyu());
            tempEntity.setShikakuSoshitsuYMD(賦課の情報一時Entity.getShikakuSoshitsuYMD());
            tempEntity.setShikakuSoshitsuJiyu(賦課の情報一時Entity.getShikakuSoshitsuJiyu());
            tempEntity.setSeihofujoShurui(賦課の情報一時Entity.getSeihofujoShurui());
            tempEntity.setSeihoKaishiYMD(賦課の情報一時Entity.getSeihoKaishiYMD());
            tempEntity.setSeihoHaishiYMD(賦課の情報一時Entity.getSeihoHaishiYMD());
            tempEntity.setRonenKaishiYMD(賦課の情報一時Entity.getRonenKaishiYMD());
            tempEntity.setRonenHaishiYMD(賦課の情報一時Entity.getRonenHaishiYMD());
            tempEntity.setFukaYMD(賦課の情報一時Entity.getFukaYMD());
            tempEntity.setKazeiKubun(賦課の情報一時Entity.getKazeiKubun());
            tempEntity.setSetaikazeiKubun(賦課の情報一時Entity.getSetaikazeiKubun());
            tempEntity.setGokeiShotokuGaku(賦課の情報一時Entity.getGokeiShotokuGaku());
            tempEntity.setNenkinShunyuGaku(賦課の情報一時Entity.getNenkinShunyuGaku());
            tempEntity.setHokenryoDankai(賦課の情報一時Entity.getHokenryoDankai());
            tempEntity.setHokenryoDankai1(賦課の情報一時Entity.getHokenryoDankai1());
            tempEntity.setNengakuHokenryo1(賦課の情報一時Entity.getNengakuHokenryo1());
            tempEntity.setTsukiwariStartYM1(賦課の情報一時Entity.getTsukiwariStartYM1());
            tempEntity.setTsukiwariEndYM1(賦課の情報一時Entity.getTsukiwariEndYM1());
            tempEntity.setHokenryoDankai2(賦課の情報一時Entity.getHokenryoDankai2());
            tempEntity.setNengakuHokenryo2(賦課の情報一時Entity.getNengakuHokenryo2());
            tempEntity.setTsukiwariStartYM2(賦課の情報一時Entity.getTsukiwariStartYM2());
            tempEntity.setTsukiwariEndYM2(賦課の情報一時Entity.getTsukiwariEndYM2());
            tempEntity.setChoteiNichiji(システム日時);
            tempEntity.setChoteiJiyu1(ChoteiJiyuCode.減免決定による更正.getコード());
            tempEntity.setChoteiJiyu2(RString.EMPTY);
            tempEntity.setChoteiJiyu3(RString.EMPTY);
            tempEntity.setChoteiJiyu4(RString.EMPTY);
            tempEntity.setKoseiM(new RString(システム日時.getMonthValue()));
            tempEntity.setGemmenMaeHokenryo(賦課の情報一時Entity.getGemmenMaeHokenryo());
            tempEntity.setGemmenGaku(賦課の情報一時Entity.getGemmenMaeHokenryo());
            Decimal 減免前介護保険料 = 賦課の情報一時Entity.getGemmenMaeHokenryo();
            if (減免前介護保険料 != null) {
                tempEntity.setKakuteiHokenryo(減免前介護保険料.subtract(賦課の情報一時Entity.getGemmenGaku()));
            }
            tempEntity.setHokenryoDankaiKarisanntei(賦課の情報一時Entity.getHokenryoDankaiKarisanntei());
            tempEntity.setChoshuHohoRirekiNo(賦課の情報一時Entity.getChoshuHohoRirekiNo());
            tempEntity.setIdoKijunNichiji(システム日時);
            tempEntity.setKozaKubun(賦課の情報一時Entity.getKozaKubun());
            tempEntity.setKyokaisoKubun(賦課の情報一時Entity.getKyokaisoKubun());
            tempEntity.setShokkenKubun(賦課の情報一時Entity.getShokkenKubun());
            tempEntity.setFukaShichosonCode(賦課の情報一時Entity.getFukaShichosonCode());
            tempEntity.setTkSaishutsuKampuGaku(賦課の情報一時Entity.getTkSaishutsuKampuGaku());
            tempEntity.setFuSaishutsuKampuGaku(賦課の情報一時Entity.getFuSaishutsuKampuGaku());
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

    private DbT2004GemmenEntity 介護賦課減免編集(DbT2002FukaJohoTempTableEntity 賦課の情報一時処理後Data) {
        DbT2004GemmenEntity 減免Entity = new DbT2004GemmenEntity();
        if (賦課の情報一時処理後Data != null) {
            減免Entity.setChoteiNendo(賦課の情報一時処理後Data.getChoteiNendo());
            減免Entity.setFukaNendo(賦課の情報一時処理後Data.getFukaNendo());
            減免Entity.setTsuchishoNo(賦課の情報一時処理後Data.getTsuchishoNo());
            減免Entity.setRirekiNo(new Decimal(賦課の情報一時処理後Data.getRirekiNo()));
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
                減免Entity.setGemmenJiyu(processParameter.getGemmenJiyu());
            }
            減免Entity.setGemmenTorikeshiJiyuCode(Code.EMPTY);
            減免Entity.setGemmenTorikeshiJiyu(RString.EMPTY);
            減免Entity.setShinseiGemmenGaku(賦課の情報一時処理後Data.getGemmenGaku());
            減免Entity.setKetteiGemmenGaku(賦課の情報一時処理後Data.getGemmenGaku());
            減免Entity.setTorikeshiGemmenGaku(Decimal.ZERO);
            介護賦課減免tableWriter.insert(減免Entity);
        }
        return 減免Entity;
    }

}
