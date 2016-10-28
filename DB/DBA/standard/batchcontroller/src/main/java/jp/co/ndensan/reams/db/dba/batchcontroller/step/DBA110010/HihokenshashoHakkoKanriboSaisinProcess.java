/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA110010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakkokanribochohyodatasakusei.HihohenshashoHakkoKanriboChohyoDataSakusei;
import jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakokanribocsvdatasakusei.HihohenshashoHakoKanriboCsvDataSakusei;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba110010.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakoKanriboCsvDataSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 被保険者証発行管理簿_バッチ処理クラスです
 *
 * @reamsid_L DBA-0600-020 zhangguopeng
 */
public class HihokenshashoHakkoKanriboSaisinProcess extends BatchKeyBreakBase<AkasiHakouKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshashohakkokanribo."
            + "IHihokenshashoHakkoKanriboMapper.get証発行管理リスト最新情報");
    private static final RString 証発行モード_001 = new RString("001");
    private static final RString 証発行モード_002 = new RString("002");
    private static final RString 被保険者証発行 = new RString("介護保険　被保険者証発行管理一覧表");
    private static final RString 資格者証発行 = new RString("介護保険　資格者証発行管理一覧表");
    private static final RString CSV名称_被保険者証発行 = new RString("被保険者証発行管理簿.csv");
    private static final RString CSV名称_資格者証発行 = new RString("資格者証発行管理簿.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBA210004"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString ORDERBYCLAUSE = new RString("order by");
    private static final RString COMMA = new RString(",");
    private static final RString ログコード = new RString("003");
    private static final RString ログ表示名 = new RString("被保険者番号");
    private RString eucFilePath;
    private HihokenshashoHakkoKanriboProcessParameter processParameter;
    private HihokenshashoHakkoKanriboMybatisParameter mybatisParameter;
    private FileSpoolManager manager;
    private RString csvName;
    private List<PersonalData> personalDataList;
    private int renban;
    private ShutsuryokujunRelateEntity 出力順Entity;
    private AkasiHakouKanriRelateEntity relateEntity;

    @BatchWriter
    private CsvWriter<HihohenshashoHakoKanriboCsvDataSakuseiEntity> csvWriter;
    @BatchWriter
    private BatchReportWriter<HihokenshashoHakkoKanriIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<HihokenshashoHakkoKanriIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        出力順Entity = get出力順項目();
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        mybatisParameter = HihokenshashoHakkoKanriboMybatisParameter.create_Param(
                processParameter.getAkasihakoumod(),
                processParameter.getKoufukayisihi(),
                processParameter.getKoufusiuryouhi(),
                processParameter.getKasyuukayisihi(),
                processParameter.getKasyuusiuryouhi(),
                processParameter.getKofuJiyulist(),
                processParameter.getKaishuJiyulist(),
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()),
                出力順Entity.get出力順OrderBy().replace(ORDERBYCLAUSE, COMMA));
        relateEntity = new AkasiHakouKanriRelateEntity();
        relateEntity.setAkasihakoumode(processParameter.getAkasihakoumod());
        if (証発行モード_001.equals(processParameter.getAkasihakoumod())) {
            relateEntity.setChouhouTitle(被保険者証発行);
            csvName = CSV名称_被保険者証発行;
        } else if (証発行モード_002.equals(processParameter.getAkasihakoumod())) {
            relateEntity.setChouhouTitle(資格者証発行);
            csvName = CSV名称_資格者証発行;
        }
        relateEntity.setShichosonCode(new LasdecCode(association.get地方公共団体コード().getColumnValue()));
        relateEntity.setShichosonMeisho(association.get市町村名());
        relateEntity.setKoumukumeyifukaflg(processParameter.isKoumukumeyifukaflg());
        relateEntity.setRenbanfukaflg(processParameter.isRenbanfukaflg());
        relateEntity.setHizikehensyuuflg(processParameter.isHizikehensyuuflg());
        personalDataList = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, csvName);
        csvWriter = new CsvWriter.InstanceBuilder(this.eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(processParameter.isKoumukumeyifukaflg()).
                build();
        List<RString> pageBreakKeys = Collections.unmodifiableList(出力順Entity.getPageBreakKeys());
        if (pageBreakKeys != null && !pageBreakKeys.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200004.getReportId().value()).
                    addBreak(new BreakerCatalog<HihokenshashoHakkoKanriIchiranhyoReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200004.getReportId().value()).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void usualProcess(AkasiHakouKanriEntity entity) {
        renban++;
        personalDataList = new ArrayList<>();
        HihohenshashoHakoKanriboCsvDataSakusei checkListCsv = new HihohenshashoHakoKanriboCsvDataSakusei();
        csvWriter.writeLine(checkListCsv.getShohakkoKanriCSVDataListAddRenban(
                entity, processParameter.isKoumukumeyifukaflg(),
                processParameter.isHizikehensyuuflg(), renban));
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code(ログコード),
                ログ表示名, entity.getHihokenshaNo());
        personalDataList.add(PersonalData.of(entity.getShikibetsuCode(), expandedInformations));
        HihohenshashoHakkoKanriboChohyoDataSakusei chohyoDataSakusei = new HihohenshashoHakkoKanriboChohyoDataSakusei();
        relateEntity.setAkasiHakouKanriEntity(entity);
        HihokenshashoHakkoKanriIchiranhyoReport report = new HihokenshashoHakkoKanriIchiranhyoReport(
                chohyoDataSakusei.getShohakkoKanriChohyoDataList(relateEntity, 出力順Entity));
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void keyBreakProcess(AkasiHakouKanriEntity current) {
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, id);
    }

    private ShutsuryokujunRelateEntity get出力順項目() {
        return ReportUtil.get出力順情報(HihohenshashoHakkoKanriboChohyoDataSakusei.ShutsuryokujunEnum.class,
                SubGyomuCode.DBA介護資格,
                ReportIdDBA.DBA200004.getReportId(),
                processParameter.getSyuturyokujunid());
    }

}
