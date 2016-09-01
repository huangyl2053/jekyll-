/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.nenreitoutatsuyoteisha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.nenreitoutatsuyoteishacheck.NenreiTotatsuYoteishaCheckListChohyo;
import jp.co.ndensan.reams.db.dba.business.core.nenreitoutatsuyoteishacheck.NenreiToutatsuYoteishaCheckListCsv;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoItem;
import jp.co.ndensan.reams.db.dba.business.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.torokunenreitoutatsuyoteishacheck.NenreiToutatsuYoteishaCheckListMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba120010.INenreiToutatsuYoteishaCheckListProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListEucCsvEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListJyohoEntity;
import jp.co.ndensan.reams.db.dba.entity.report.nenreitotatsuyoteishaichiranhyo.NenreitotatsuYoteishaIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.nenreitoutatsuyoteishachecklist.INenreiToutatsuYoteishaCheckListMapper;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 年齢到達予定者チェックリストProcessクラスです。
 *
 * @reamsid_L DBA-0580-020 yaodongsheng
 */
public class NenreiToutatsuYoteishaCheckListProcess extends SimpleBatchProcessBase {

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(
            new RString("NenreiToutatsuYoteishaCheckListEucCsvEntity"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final int NENREI_TOUTATSU = 65;
    private static final RString 出力対象者_登録対象者 = new RString("1");
    private static final RString 出力対象者_全ての対象者 = new RString("2");
    private static final RString 住民種別_日本人のみ = new RString("2");
    private static final RString 住民種別_外国人のみ = new RString("3");
    private static final RString 住登内日本人 = new RString("1");
    private static final RString 住登内外国人 = new RString("2");
    private static final RString 住登外日本人 = new RString("3");
    private static final RString 住登外外国人 = new RString("4");
    private static final RString 住所地特例フラグTRUE = new RString("1");
    private static final RString 被保険者区分コード = new RString("2");
    private static final RString 資格区分_新規取得者 = new RString("新規取得者");
    private static final RString 資格区分_2号取得者 = new RString("2号取得者");
    private static final RString 住特者区分_住所地特例 = new RString("住所地特例");
    private static final RString 状態_被保険者 = new RString("被保険者");
    private static final RString 状態_適用除外者 = new RString("適用除外者");
    private static final RString 状態_転入保留対象者 = new RString("転入保留対象者");
    private static final RString 状態_他市町村住所地特例者 = new RString("他市町村住所地特例者");
    private static final RString 生活 = new RString("●");
    private static final RString PSMYO = new RString("psmShikibetsuTaisho");
    private static final int INDEX = 5;
    private INenreiToutatsuYoteishaCheckListProcessParameter processParameter;
    private INenreiToutatsuYoteishaCheckListMapper nenreiCheckListMapper;
    private List<NenreiToutatsuYoteishaCheckListEntity> nenreiCheckListEntity;
    private List<NenreiToutatsuYoteishaCheckListEntity> nenreiCheckListEntity2;
    private List<DbT1009ShikakuShutokuJogaishaEntity> dbT1009Entity;
    private List<DbT1002TekiyoJogaishaEntity> dbT1002TekiyoJogaishaEntity;
    private List<DbT1003TashichosonJushochiTokureiEntity> dbT1003Entity;
    private List<DbT1010TennyushutsuHoryuTaishoshaEntity> dbT1010Entity;
    private NenreiToutatsuYoteishaCheckListJyohoEntity nenreiCheckListJyohoEntity;
    private final List<NenreiToutatsuYoteishaCheckListEntity> removeListEntity = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    private BatchReportWriter<NenreitotatsuYoteishaIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<NenreitotatsuYoteishaIchiranhyoReportSource> reportSourceWriter;
    private EucCsvWriter<NenreiToutatsuYoteishaCheckListEucCsvEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        nenreiCheckListJyohoEntity = new NenreiToutatsuYoteishaCheckListJyohoEntity();
        nenreiCheckListMapper = getMapper(INenreiToutatsuYoteishaCheckListMapper.class);
        if (出力対象者_登録対象者.equals(processParameter.getSyutsuryokutaisyo())) {
            getTorokuSya();
        } else if (出力対象者_全ての対象者.equals(processParameter.getSyutsuryokutaisyo())) {
            getZenbuSya();
        }
        if (nenreiCheckListEntity.isEmpty()) {
            nenreiCheckListJyohoEntity
                    .set年齢到達予定者チェックリスト(nenreiCheckListEntity);
        } else {
            mainsyori();
            nenreiCheckListJyohoEntity.set年齢到達予定者チェックリスト(nenreiCheckListEntity2);
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        nenreiCheckListJyohoEntity.set市町村コード(new RString(
                association.get地方公共団体コード().toString()));
        nenreiCheckListJyohoEntity.set市町村名(association.get市町村名());
        // TODO　QA476
        List<RString> 並び順改頁 = new ArrayList<>();
        for (int i = 0; i < INDEX; i++) {
            並び順改頁.add(RString.EMPTY);
        }
        nenreiCheckListJyohoEntity.set並び順(並び順改頁);
        nenreiCheckListJyohoEntity.set改頁(並び順改頁);
//        ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBA介護資格, ID);
        nenreiCheckListJyohoEntity.set項目名付加フラグ(processParameter.isKoumokumeiflg());
        nenreiCheckListJyohoEntity.set連番付加フラグ(processParameter.isRenbanfukaflg());
        nenreiCheckListJyohoEntity.set日付編集フラグ(processParameter.isNichihensyuflg());

    }

    @Override
    protected void process() {
        NenreiTotatsuYoteishaCheckListChohyo checkListChohyo = new NenreiTotatsuYoteishaCheckListChohyo();
        NenreitotatsuYoteishaIchiranhyoItem item = checkListChohyo.createNenreiToutatsuYoteishaCheckListChohyo(
                nenreiCheckListJyohoEntity);
        NenreiToutatsuYoteishaCheckListCsv checkListCsv = new NenreiToutatsuYoteishaCheckListCsv();
        List<NenreiToutatsuYoteishaCheckListEucCsvEntity> eucCsvEntityList;
        if (processParameter.isRenbanfukaflg()) {
            eucCsvEntityList = checkListCsv.createNenreiToutatsuYoteishaCheckListRenbanCSV(
                    nenreiCheckListJyohoEntity);
        } else {
            eucCsvEntityList = checkListCsv.createNenreiToutatsuYoteishaCheckListCSV(
                    nenreiCheckListJyohoEntity);
        }
        if (!eucCsvEntityList.isEmpty()) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
            RString spoolWorkPath = manager.getEucOutputDirectry();
            eucFilePath = Path.combinePath(spoolWorkPath, new RString("NenreiToutatsuYoteishaCheckListEucCsvEntity.csv"));
            eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8).
                    setNewLine(NewLine.CRLF).
                    hasHeader(nenreiCheckListJyohoEntity.is項目名付加フラグ()).
                    build();

            for (NenreiToutatsuYoteishaCheckListEucCsvEntity eucCsvEntity : eucCsvEntityList) {
                eucCsvWriter.writeLine(eucCsvEntity);
            }
        }
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200001.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        NenreitotatsuYoteishaIchiranhyoReport report = NenreitotatsuYoteishaIchiranhyoReport
                .createFrom(item.getHeadItem(), item.getBodyItem());
        report.writeBy(reportSourceWriter);
        batchReportWriter.close();
        DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanri = new DbT7022ShoriDateKanriEntity();
        dbT7022ShoriDateKanri.setTaishoKaishiYMD(processParameter.getKonkaikaishi());
        dbT7022ShoriDateKanri.setTaishoShuryoYMD(processParameter.getKonkaisyuryo());
        dbT7022ShoriDateKanri.setShoriName(ShoriName.年齢到達予定者チェックリスト.get名称());
        nenreiCheckListMapper.getInsert(dbT7022ShoriDateKanri);
    }

    @Override
    protected void afterExecute() {
        if (eucCsvWriter != null) {
            eucCsvWriter.close();
        }
        AccessLogger.log(AccessLogType.照会, toPersonalData());
        if (eucFilePath != null) {
            manager.spool(eucFilePath);
        }
    }

    private void mainsyori() {
        nenreiCheckListEntity2 = new ArrayList<>();
        for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity) {
            nenreiCheckListEntity2.add(entity);
        }
        removeListEntity.clear();
        for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity2) {
            if (entity.getSeinengappiYMD() == null || entity.getSeinengappiYMD().isEmpty()) {
                removeListEntity.add(entity);
            } else {
                年齢到達日判断(entity);
            }
        }
        nenreiCheckListEntity2.removeAll(removeListEntity);
        RString juminShubetsu = processParameter.getJuminShubetsu();
        removeListEntity.clear();
        for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity2) {
            RString juminShubetsuCode = entity.getJuminShubetsuCode();
            if (住民種別_日本人のみ.equals(juminShubetsu) && !住登内日本人.equals(juminShubetsuCode)
                    && !住登外日本人.equals(juminShubetsuCode)) {
                removeListEntity.add(entity);
            } else if (住民種別_外国人のみ.equals(juminShubetsu) && !住登内外国人
                    .equals(juminShubetsuCode)
                    && !住登外外国人.equals(juminShubetsuCode)) {
                removeListEntity.add(entity);
            }
        }
        nenreiCheckListEntity2.removeAll(removeListEntity);
        setData();
    }

    private void setData() {
        for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity2) {
            if (entity.getHihokenshaNo() == null) {
                entity.setShigekubun(資格区分_新規取得者);
            } else {
                entity.setShigekubun(資格区分_2号取得者);
            }
            if (住所地特例フラグTRUE.equals(entity.getJushochiTokureiFlag())) {
                entity.setJutosyakubun(住特者区分_住所地特例);
            } else {
                entity.setJutosyakubun(RString.EMPTY);
            }
            entity.setSeikatsu(RString.EMPTY);
            List<UrT0508SeikatsuHogoJukyushaEntity> urT0508Seika = nenreiCheckListMapper
                    .getSeikatsuHogojyu(entity.getShikibetsuCode());
            for (UrT0508SeikatsuHogoJukyushaEntity urT0508Sei : urT0508Seika) {
                if (urT0508Sei.getJukyuKaishiYMD()
                        .isBeforeOrEquals(entity.getNenreiyotainichi())
                        && entity.getNenreiyotainichi().isBeforeOrEquals(
                                urT0508Sei.getJukyuHaishiYMD())) {
                    entity.setSeikatsu(生活);
                    break;
                }
            }
            if (被保険者区分コード.equals(entity.getHihokennshaKubunCode())) {
                entity.setJyotei(状態_被保険者);
            }
            if (出力対象者_全ての対象者.equals(processParameter.getSyutsuryokutaisyo())) {
                setJyotai(entity);
            }
            if (!被保険者区分コード.equals(entity.getHihokennshaKubunCode()) && !出力対象者_全ての対象者
                    .equals(processParameter.getSyutsuryokutaisyo())) {
                entity.setJyotei(RString.EMPTY);
            }
        }
    }

    private void 年齢到達日判断(NenreiToutatsuYoteishaCheckListEntity entity) {
        FlexibleDate 消除異動年月日 = FlexibleDate.EMPTY;
        AgeCalculator ageCalculator = new AgeCalculator(DateOfBirthFactory
                .createInstance(entity.getSeinengappiYMD()), JuminJotai.未定義, 消除異動年月日, AgeArrivalDay.前日);
        FlexibleDate 年齢到達日 = ageCalculator.get年齢到達日(NENREI_TOUTATSU);
        entity.setNenreiyotainichi(年齢到達日);
        if (processParameter.getKonkaisyuryo().isBefore(年齢到達日)
                || (年齢到達日.isBefore(processParameter.getKonkaikaishi()))) {
            removeListEntity.add(entity);
        }
    }

    private void setJyotai(NenreiToutatsuYoteishaCheckListEntity entity) {
        getTekiyoJogaiList();
        for (DbT1002TekiyoJogaishaEntity dbT1002entity : dbT1002TekiyoJogaishaEntity) {
            if (dbT1002entity.getShikibetsuCode().equals(entity.getShikibetsuCode())
                    && dbT1002entity.getTekiyoYMD().isBeforeOrEquals(entity.getNenreiyotainichi())
                    && entity.getNenreiyotainichi().isBeforeOrEquals(dbT1002entity.getKaijoYMD())) {
                entity.setJyotei(状態_適用除外者);
                break;
            }
        }
        getTashichosonJushochi();
        for (DbT1003TashichosonJushochiTokureiEntity dbT1003entity : dbT1003Entity) {
            if (dbT1003entity.getShikibetsuCode().equals(entity.getShikibetsuCode())
                    && dbT1003entity.getTekiyoYMD().isBeforeOrEquals(entity.getNenreiyotainichi())
                    && entity.getNenreiyotainichi().isBeforeOrEquals(dbT1003entity.getKaijoYMD())) {
                entity.setJyotei(状態_他市町村住所地特例者);
                break;
            }
        }
        getTennyushutsuHoryuTaishosha();
        for (DbT1010TennyushutsuHoryuTaishoshaEntity dbT1010entity : dbT1010Entity) {
            if (dbT1010entity.getShikibetsuCode().equals(entity.getShikibetsuCode())
                    && entity.getNenreiyotainichi() != null && dbT1010entity.getTorokuIdoYMD() != null
                    && entity.getNenreiyotainichi().isBeforeOrEquals(dbT1010entity.getTorokuIdoYMD())) {
                entity.setJyotei(状態_転入保留対象者);
                break;
            }
        }
    }

    private void getTorokuSya() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);

        ShikibetsuTaishoSearchKeyBuilder key2 = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先), true);
        key2.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        key2.set住民種別(住民種別);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm2 = new UaFt200FindShikibetsuTaishoFunction(key2.getPSM検索キー());
        NenreiToutatsuYoteishaCheckListMybatisParameter torokuParameter
                = new NenreiToutatsuYoteishaCheckListMybatisParameter(
                        new RString(uaFt200Psm.getParameterMap().get(PSMYO.toString()).toString()),
                        new RString(uaFt200Psm2.getParameterMap().get(PSMYO.toString()).toString()),
                        RString.EMPTY);
        nenreiCheckListEntity = nenreiCheckListMapper.
                getTorokuNenreiToutatsuYoteishaCheckList(torokuParameter);
        if (!nenreiCheckListEntity.isEmpty()) {
            getShikakuShutokuJogaiList();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity) {
                for (DbT1009ShikakuShutokuJogaishaEntity dbt1009entity : dbT1009Entity) {
                    if (entity.getShikibetsuCode().equals(dbt1009entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiCheckListEntity.removeAll(removeListEntity);
            getTekiyoJogaiList();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity) {
                for (DbT1002TekiyoJogaishaEntity dbt1002entity : dbT1002TekiyoJogaishaEntity) {
                    if (entity.getShikibetsuCode().equals(dbt1002entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiCheckListEntity.removeAll(removeListEntity);
            getTashichosonJushochi();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity) {
                for (DbT1003TashichosonJushochiTokureiEntity dbt1003entity : dbT1003Entity) {
                    if (entity.getShikibetsuCode().equals(dbt1003entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiCheckListEntity.removeAll(removeListEntity);
            getTennyushutsuHoryuTaishosha();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity) {
                for (DbT1010TennyushutsuHoryuTaishoshaEntity dbt1010entity : dbT1010Entity) {
                    if (entity.getShikibetsuCode().equals(dbt1010entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiCheckListEntity.removeAll(removeListEntity);
        }
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民状態.add(JuminJotai.転出者);
        key.set住民状態(住民状態);
        uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        torokuParameter = new NenreiToutatsuYoteishaCheckListMybatisParameter(
                new RString(uaFt200Psm.getParameterMap().get(PSMYO.toString()).toString()),
                RString.EMPTY,
                RString.EMPTY);
        nenreiCheckListEntity2 = nenreiCheckListMapper.
                getTorokuNenreiToutatsuYoteishaCheckList2(torokuParameter);
        List<NenreiToutatsuYoteishaCheckListEntity> temp = new ArrayList<>();
        if (!nenreiCheckListEntity2.isEmpty()) {
            if (!nenreiCheckListEntity.isEmpty()) {
                for (NenreiToutatsuYoteishaCheckListEntity entity2 : nenreiCheckListEntity2) {
                    getList2(entity2, temp);
                }
                nenreiCheckListEntity.addAll(temp);
            } else {
                nenreiCheckListEntity.addAll(nenreiCheckListEntity2);
            }
        }
    }

    private void getZenbuSya() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        ShikibetsuTaishoSearchKeyBuilder key2 = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先), true);
        key2.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        key2.set住民種別(住民種別);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm2 = new UaFt200FindShikibetsuTaishoFunction(key2.getPSM検索キー());
        NenreiToutatsuYoteishaCheckListMybatisParameter zenbuParameter
                = new NenreiToutatsuYoteishaCheckListMybatisParameter(
                        new RString(uaFt200Psm.getParameterMap().get(PSMYO.toString()).toString()),
                        new RString(uaFt200Psm2.getParameterMap().get(PSMYO.toString()).toString()),
                        RString.EMPTY);
        nenreiCheckListEntity = nenreiCheckListMapper.
                getZenbuNenreiToutatsuYoteishaCheckList(zenbuParameter);
        if (!nenreiCheckListEntity.isEmpty()) {
            getShikakuShutokuJogaiList();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity) {
                for (DbT1009ShikakuShutokuJogaishaEntity dbt1009entity : dbT1009Entity) {
                    if (entity.getShikibetsuCode().equals(dbt1009entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiCheckListEntity.removeAll(removeListEntity);
        }
        List<JuminShubetsu> 住民種別2 = new ArrayList<>();
        住民種別2.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(住民種別2);
        ShikibetsuTaishoSearchKeyBuilder zenbuKey2 = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        zenbuKey2.setデータ取得区分(DataShutokuKubun.直近レコード);
        ShikibetsuTaishoSearchKeyBuilder key3 = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key3.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別3 = new ArrayList<>();
        住民種別3.add(JuminShubetsu.住登外個人_日本人);
        key3.set住民種別(住民種別3);
        uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        uaFt200Psm2 = new UaFt200FindShikibetsuTaishoFunction(zenbuKey2.getPSM検索キー());
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm3 = new UaFt200FindShikibetsuTaishoFunction(key3.getPSM検索キー());
        NenreiToutatsuYoteishaCheckListMybatisParameter zenbuParameter2 = new NenreiToutatsuYoteishaCheckListMybatisParameter(
                new RString(uaFt200Psm.getParameterMap().get(PSMYO.toString()).toString()),
                new RString(uaFt200Psm2.getParameterMap().get(PSMYO.toString()).toString()),
                new RString(uaFt200Psm3.getParameterMap().get(PSMYO.toString()).toString()));
        nenreiCheckListEntity2 = nenreiCheckListMapper.
                getZenbuNenreiToutatsuYoteishaCheckList2(zenbuParameter2);
        List<NenreiToutatsuYoteishaCheckListEntity> temp = new ArrayList<>();
        if (!nenreiCheckListEntity2.isEmpty()) {
            if (!nenreiCheckListEntity.isEmpty()) {
                for (NenreiToutatsuYoteishaCheckListEntity entity2 : nenreiCheckListEntity2) {
                    getList2(entity2, temp);
                }
                nenreiCheckListEntity.addAll(temp);
            } else {
                nenreiCheckListEntity.addAll(nenreiCheckListEntity2);
            }
        }
    }

    private void getList2(NenreiToutatsuYoteishaCheckListEntity entity2, List<NenreiToutatsuYoteishaCheckListEntity> temp) {
        boolean flg = false;
        for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiCheckListEntity) {
            RStringBuilder entity1 = new RStringBuilder();
            RStringBuilder entityNew = new RStringBuilder();
            if (entity1.append(entity.getGyoseikuCode()).append(entity.getGyoseikuName()).append(entity.getHihokennshaKubunCode())
                    .append(entity.getHihokenshaNo() == null ? RString.EMPTY : entity.getHihokenshaNo().value())
                    .append(entity.getJuminShubetsuCode()).append(entity.getJusho()).append(entity.getJushochiTokureiFlag())
                    .append(entity.getJutosyakubun()).append(entity.getJyotei()).append(entity.getKanaMeisho()).append(entity.getMeisho())
                    .append(entity.getNenreiyotainichi() == null ? RString.EMPTY : entity.getNenreiyotainichi().toString())
                    .append(entity.getSeibetsuCode()).append(entity.getSeikatsu())
                    .append(entity.getSeinengappiYMD() == null ? RString.EMPTY : entity.getSeinengappiYMD().toString())
                    .append(entity.getShichosonCode()).append(entity.getShigekubun())
                    .append(entity.getShikibetsuCode() == null ? RString.EMPTY : entity.getShikibetsuCode().value())
                    .append(entity.getZenkokuJushoCode()).equals(entityNew.append(entity2.getGyoseikuCode()).append(entity2.getGyoseikuName())
                            .append(entity2.getHihokennshaKubunCode())
                            .append(entity2.getHihokenshaNo() == null ? RString.EMPTY : entity2.getHihokenshaNo().value())
                            .append(entity2.getJuminShubetsuCode()).append(entity2.getJusho())
                            .append(entity2.getJushochiTokureiFlag()).append(entity2.getJutosyakubun())
                            .append(entity2.getJyotei()).append(entity2.getKanaMeisho()).append(entity2.getMeisho())
                            .append(entity2.getNenreiyotainichi() == null ? RString.EMPTY : entity2.getNenreiyotainichi().toString())
                            .append(entity2.getSeibetsuCode()).append(entity2.getSeikatsu())
                            .append(entity2.getSeinengappiYMD() == null ? RString.EMPTY : entity2.getSeinengappiYMD().toString())
                            .append(entity2.getShichosonCode()).append(entity2.getShigekubun())
                            .append(entity2.getShikibetsuCode() == null ? RString.EMPTY : entity2.getShikibetsuCode().value())
                            .append(entity2.getZenkokuJushoCode()))) {
                flg = true;
                break;
            }
        }
        if (!flg) {
            temp.add(entity2);
        }
    }

    private void getShikakuShutokuJogaiList() {
        dbT1009Entity = nenreiCheckListMapper.getShikakuShutokuJogaiList();
    }

    private void getTekiyoJogaiList() {
        dbT1002TekiyoJogaishaEntity = nenreiCheckListMapper.getTekiyoJogaiList();
    }

    private void getTashichosonJushochi() {
        dbT1003Entity = nenreiCheckListMapper.getTashichosonJushochi();
    }

    private void getTennyushutsuHoryuTaishosha() {
        dbT1010Entity = nenreiCheckListMapper.getTennyushutsuHoryuTaishosha();
    }

    private PersonalData toPersonalData() {
        List<NenreiToutatsuYoteishaCheckListEntity> entityList = nenreiCheckListJyohoEntity.get年齢到達予定者チェックリスト();
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entityList.isEmpty() ? RString.EMPTY : entityList.get(0).getHihokenshaNo().value());
        return PersonalData.of(entityList.isEmpty() ? ShikibetsuCode.EMPTY : entityList.get(0).getShikibetsuCode(), expandedInfo);
    }
}
