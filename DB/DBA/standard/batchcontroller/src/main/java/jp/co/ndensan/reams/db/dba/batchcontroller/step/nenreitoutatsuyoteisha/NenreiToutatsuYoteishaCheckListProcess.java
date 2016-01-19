/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.nenreitoutatsuyoteisha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.nenreitoutatsuyoteishacheck.NenreiToutatsuYoteishaCheckListCsv;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.torokunenreitoutatsuyoteishacheck.NenreiToutatsuYoteishaCheckListMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processhprm.nenreitoutatsuyoteisha.INenreiToutatsuYoteishaCheckListProcessParameter;
import jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListEntity;
import jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListEucCsvEntity;
import jp.co.ndensan.reams.db.dba.entity.db.nenreitoutatsuyoteishachecklist.NenreiToutatsuYoteishaCheckListJyohoEntity;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.nenreitoutatsuyoteishachecklist.INenreiToutatsuYoteishaCheckListMapper;
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
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urd.entity.db.basic.seikatsuhogo.UrT0508SeikatsuHogoJukyushaEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 年齢到達予定者チェックリストProcessクラスです。
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
    private INenreiToutatsuYoteishaCheckListProcessParameter processParameter;
    private INenreiToutatsuYoteishaCheckListMapper nenreiToutatsuYoteishaCheckListMapper;
    private List<NenreiToutatsuYoteishaCheckListEntity> nenreiToutatsuYoteishaCheckListEntity;
    private List<NenreiToutatsuYoteishaCheckListEntity> nenreiToutatsuYoteishaCheckListEntity2;
    private List<DbT1009ShikakuShutokuJogaishaEntity> dbT1009ShikakuShutokuJogaishaEntity;
    private List<DbT1002TekiyoJogaishaEntity> dbT1002TekiyoJogaishaEntity;
    private List<DbT1003TashichosonJushochiTokureiEntity> dbT1003TashichosonJushochiTokureiEntity;
    private List<DbT1010TennyushutsuHoryuTaishoshaEntity> dbT1010TennyushutsuHoryuTaishoshaEntity;
    private NenreiToutatsuYoteishaCheckListJyohoEntity nenreiToutatsuYoteishaCheckListJyohoEntity;
    private final List<NenreiToutatsuYoteishaCheckListEntity> removeListEntity = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
//    private BatchReportWriter<NenreitotatsuYoteishaIchiranhyoReportSource> batchReportWriter;
//    private ReportSourceWriter<NenreitotatsuYoteishaIchiranhyoReportSource> reportSourceWriter;
    private EucCsvWriter<NenreiToutatsuYoteishaCheckListEucCsvEntity> eucCsvWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        nenreiToutatsuYoteishaCheckListJyohoEntity = new NenreiToutatsuYoteishaCheckListJyohoEntity();
        nenreiToutatsuYoteishaCheckListMapper = getMapper(INenreiToutatsuYoteishaCheckListMapper.class);
        // TODO  QA377 AccessLogの実装方式
//        PersonalData personalData = toPersonalData(nenreiToutatsuYoteishaCheckListEntity);
//        AccessLogger.log(AccessLogType.照会, nenreiToutatsuYoteishaCheckListEntity);
        if (出力対象者_登録対象者.equals(processParameter.getSyutsuryokutaisyo())) {
            getTorokuSya();
        } else if (出力対象者_全ての対象者.equals(processParameter.getSyutsuryokutaisyo())) {
            getZenbuSya();
        }
        if (nenreiToutatsuYoteishaCheckListEntity.isEmpty()) {
            nenreiToutatsuYoteishaCheckListJyohoEntity
                    .set年齢到達予定者チェックリスト(nenreiToutatsuYoteishaCheckListEntity);
        } else {
            nenreiToutatsuYoteishaCheckListEntity2 = new ArrayList<>();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity) {
                nenreiToutatsuYoteishaCheckListEntity2.add(entity);
            }
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity2) {
                if (entity.getSeinengappiYMD() == null || entity.getSeinengappiYMD().isEmpty()) {
                    removeListEntity.add(entity);
                } else {
                    FlexibleDate 消除異動年月日 = FlexibleDate.EMPTY;
                    AgeCalculator ageCalculator = new AgeCalculator(DateOfBirthFactory
                            .createInstance(entity.getSeinengappiYMD()), JuminJotai.未定義, 消除異動年月日);
                    FlexibleDate 年齢到達日 = ageCalculator.get年齢到達日(NENREI_TOUTATSU);
                    entity.setNenreiyotainichi(年齢到達日);
                    // QA489 年齢到達日がnullの場合
                    if (processParameter.getKonkaisyuryo().isBefore(年齢到達日)
                            || (年齢到達日.isBefore(processParameter.getKonkaikaishi()))) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiToutatsuYoteishaCheckListEntity2.removeAll(removeListEntity);
            RString juminShubetsu = processParameter.getJuminShubetsu();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity2) {
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
            nenreiToutatsuYoteishaCheckListEntity2.removeAll(removeListEntity);
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity2) {
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
                List<UrT0508SeikatsuHogoJukyushaEntity> urT0508Seika = nenreiToutatsuYoteishaCheckListMapper
                        .getSeikatsuHogojyu(entity.getShikibetsuCode());
                if (!urT0508Seika.isEmpty() && urT0508Seika.get(0).getJukyuKaishiYMD()
                        .isBeforeOrEquals(entity.getNenreiyotainichi())
                        && entity.getNenreiyotainichi().isBeforeOrEquals(
                                urT0508Seika.get(0).getJukyuHaishiYMD())) {
                    entity.setSeikatsu(生活);
                } else {
                    entity.setSeikatsu(RString.EMPTY);
                }
                if (被保険者区分コード.equals(entity.getHihokennshaKubunCode())) {
                    entity.setJyotei(状態_被保険者);
                }
                if (出力対象者_全ての対象者.equals(processParameter.getSyutsuryokutaisyo())) {
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
                    for (DbT1003TashichosonJushochiTokureiEntity dbT1003entity : dbT1003TashichosonJushochiTokureiEntity) {
                        if (dbT1003entity.getShikibetsuCode().equals(entity.getShikibetsuCode())
                                && dbT1003entity.getTekiyoYMD().isBeforeOrEquals(entity.getNenreiyotainichi())
                                && entity.getNenreiyotainichi().isBeforeOrEquals(dbT1003entity.getKaijoYMD())) {
                            entity.setJyotei(状態_他市町村住所地特例者);
                            break;
                        }
                    }
                    getTennyushutsuHoryuTaishosha();
                    for (DbT1010TennyushutsuHoryuTaishoshaEntity dbT1010entity : dbT1010TennyushutsuHoryuTaishoshaEntity) {
                        if (dbT1010entity.getShikibetsuCode().equals(entity.getShikibetsuCode())
                                && entity.getNenreiyotainichi().isBeforeOrEquals(dbT1010entity.getTorokuIdoYMD())) {
                            entity.setJyotei(状態_転入保留対象者);
                            break;
                        }
                    }
                }
                if (!被保険者区分コード.equals(entity.getHihokennshaKubunCode()) && !出力対象者_全ての対象者
                        .equals(processParameter.getSyutsuryokutaisyo())) {
                    entity.setJyotei(RString.EMPTY);
                }
            }
            nenreiToutatsuYoteishaCheckListJyohoEntity.set年齢到達予定者チェックリスト(nenreiToutatsuYoteishaCheckListEntity2);
        }
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        nenreiToutatsuYoteishaCheckListJyohoEntity.set市町村コード(new RString(
                association.get地方公共団体コード().toString()));
        nenreiToutatsuYoteishaCheckListJyohoEntity.set市町村名(association.get市町村名());
        // TODO　QA476
//        nenreiToutatsuYoteishaCheckListJyohoEntity.set並び順(RString.EMPTY);
//        nenreiToutatsuYoteishaCheckListJyohoEntity.set改頁(RString.EMPTY);
//        ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBA介護資格, ID);
        nenreiToutatsuYoteishaCheckListJyohoEntity.set項目名付加フラグ(processParameter.isKoumokumeiflg());
        nenreiToutatsuYoteishaCheckListJyohoEntity.set連番付加フラグ(processParameter.isRenbanfukaflg());
        nenreiToutatsuYoteishaCheckListJyohoEntity.set日付編集フラグ(processParameter.isNichihensyuflg());

    }

    @Override
    protected void process() {
//        NenreiTotatsuYoteishaCheckListChohyo checkListChohyo = new NenreiTotatsuYoteishaCheckListChohyo();
//        NenreitotatsuYoteishaIchiranhyoItem item = checkListChohyo.createNenreiToutatsuYoteishaCheckListChohyo(
//                nenreiToutatsuYoteishaCheckListJyohoEntity);
        NenreiToutatsuYoteishaCheckListCsv checkListCsv = new NenreiToutatsuYoteishaCheckListCsv();
        List<NenreiToutatsuYoteishaCheckListEucCsvEntity> eucCsvEntityList;
        if (processParameter.isRenbanfukaflg()) {
            eucCsvEntityList = checkListCsv.createNenreiToutatsuYoteishaCheckListRenbanCSV(
                    nenreiToutatsuYoteishaCheckListJyohoEntity);
        } else {
            eucCsvEntityList = checkListCsv.createNenreiToutatsuYoteishaCheckListCSV(
                    nenreiToutatsuYoteishaCheckListJyohoEntity);
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
                    hasHeader(nenreiToutatsuYoteishaCheckListJyohoEntity.is項目名付加フラグ()).
                    build();

            for (NenreiToutatsuYoteishaCheckListEucCsvEntity eucCsvEntity : eucCsvEntityList) {
                eucCsvWriter.writeLine(eucCsvEntity);
            }
        }
        // TODO 南京開発
//        batchReportWriter = BatchReportFactory.createBatchReportWriter(ID.value()).create();
//        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
//        NenreitotatsuYoteishaIchiranhyoReport report = NenreitotatsuYoteishaIchiranhyoReport
//                .createFrom(item.getHeadItem(), item.getBodyItem());
//        report.writeBy(reportSourceWriter);
        DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanri = new DbT7022ShoriDateKanriEntity();
        dbT7022ShoriDateKanri.setTaishoKaishiYMD(processParameter.getKonkaikaishi());
        dbT7022ShoriDateKanri.setTaishoShuryoYMD(processParameter.getKonkaisyuryo());
        dbT7022ShoriDateKanri.setShoriName(ShoriName.年齢到達予定者チェックリスト.get名称());
        nenreiToutatsuYoteishaCheckListMapper.getInsert(dbT7022ShoriDateKanri);
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
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
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                        new RString(uaFt200Psm2.getParameterMap().get("psmShikibetsuTaisho").toString()),
                        RString.EMPTY);
        nenreiToutatsuYoteishaCheckListEntity = nenreiToutatsuYoteishaCheckListMapper.
                getTorokuNenreiToutatsuYoteishaCheckList(torokuParameter);
        if (!nenreiToutatsuYoteishaCheckListEntity.isEmpty()) {
            // QA286 QA364 検索条件は不定です。
            getShikakuShutokuJogaiList();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity) {
                for (DbT1009ShikakuShutokuJogaishaEntity dbt1009entity : dbT1009ShikakuShutokuJogaishaEntity) {
                    if (entity.getShikibetsuCode().equals(dbt1009entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiToutatsuYoteishaCheckListEntity.removeAll(removeListEntity);
            getTekiyoJogaiList();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity) {
                for (DbT1002TekiyoJogaishaEntity dbt1002entity : dbT1002TekiyoJogaishaEntity) {
                    if (entity.getShikibetsuCode().equals(dbt1002entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiToutatsuYoteishaCheckListEntity.removeAll(removeListEntity);
            getTashichosonJushochi();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity) {
                for (DbT1003TashichosonJushochiTokureiEntity dbt1003entity : dbT1003TashichosonJushochiTokureiEntity) {
                    if (entity.getShikibetsuCode().equals(dbt1003entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiToutatsuYoteishaCheckListEntity.removeAll(removeListEntity);
            getTennyushutsuHoryuTaishosha();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity) {
                for (DbT1010TennyushutsuHoryuTaishoshaEntity dbt1010entity : dbT1010TennyushutsuHoryuTaishoshaEntity) {
                    if (entity.getShikibetsuCode().equals(dbt1010entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiToutatsuYoteishaCheckListEntity.removeAll(removeListEntity);
        }
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民状態.add(JuminJotai.転出者);
        key.set住民状態(住民状態);
        uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        torokuParameter = new NenreiToutatsuYoteishaCheckListMybatisParameter(
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                RString.EMPTY,
                RString.EMPTY);
        nenreiToutatsuYoteishaCheckListEntity2 = nenreiToutatsuYoteishaCheckListMapper.
                getTorokuNenreiToutatsuYoteishaCheckList2(torokuParameter);
        if (!nenreiToutatsuYoteishaCheckListEntity2.isEmpty()) {
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity2) {
                nenreiToutatsuYoteishaCheckListEntity.add(entity);
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
                        new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                        new RString(uaFt200Psm2.getParameterMap().get("psmShikibetsuTaisho").toString()),
                        RString.EMPTY);
        nenreiToutatsuYoteishaCheckListEntity = nenreiToutatsuYoteishaCheckListMapper.
                getZenbuNenreiToutatsuYoteishaCheckList(zenbuParameter);
        if (!nenreiToutatsuYoteishaCheckListEntity.isEmpty()) {
            getShikakuShutokuJogaiList();
            removeListEntity.clear();
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity) {
                for (DbT1009ShikakuShutokuJogaishaEntity dbt1009entity : dbT1009ShikakuShutokuJogaishaEntity) {
                    if (entity.getShikibetsuCode().equals(dbt1009entity.getShikibetsuCode())) {
                        removeListEntity.add(entity);
                    }
                }
            }
            nenreiToutatsuYoteishaCheckListEntity.removeAll(removeListEntity);
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
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                new RString(uaFt200Psm2.getParameterMap().get("psmShikibetsuTaisho").toString()),
                new RString(uaFt200Psm3.getParameterMap().get("psmShikibetsuTaisho").toString()));
        // QA368 検索条件が同じので
        nenreiToutatsuYoteishaCheckListEntity2 = nenreiToutatsuYoteishaCheckListMapper.
                getZenbuNenreiToutatsuYoteishaCheckList2(zenbuParameter2);
        if (!nenreiToutatsuYoteishaCheckListEntity2.isEmpty()) {
            for (NenreiToutatsuYoteishaCheckListEntity entity : nenreiToutatsuYoteishaCheckListEntity2) {
                nenreiToutatsuYoteishaCheckListEntity.add(entity);
            }
        }
    }

    private void getShikakuShutokuJogaiList() {
        dbT1009ShikakuShutokuJogaishaEntity = nenreiToutatsuYoteishaCheckListMapper.getShikakuShutokuJogaiList();
    }

    private void getTekiyoJogaiList() {
        dbT1002TekiyoJogaishaEntity = nenreiToutatsuYoteishaCheckListMapper.getTekiyoJogaiList();
    }

    private void getTashichosonJushochi() {
        dbT1003TashichosonJushochiTokureiEntity = nenreiToutatsuYoteishaCheckListMapper.getTashichosonJushochi();
    }

    private void getTennyushutsuHoryuTaishosha() {
        dbT1010TennyushutsuHoryuTaishoshaEntity = nenreiToutatsuYoteishaCheckListMapper.getTennyushutsuHoryuTaishosha();
    }
// TODO  QA377 AccessLogの実装方式
//    private PersonalData toPersonalData(NenreiToutatsuYoteishaCheckListEntity nenreiToutatsuYoteisha) {
//        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("01")), new RString("検索項目"), new RString("被保険者番号"));
//        PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
//        return PersonalData.of(nenreiToutatsuYoteisha.getShikibetsuCode(), expandedInfo);
//    }
}
