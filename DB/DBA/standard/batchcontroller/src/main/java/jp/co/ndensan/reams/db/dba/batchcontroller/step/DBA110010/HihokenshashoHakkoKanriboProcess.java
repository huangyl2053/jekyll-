/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA110010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakkokanribochohyodatasakusei.HihohenshashoHakkoKanriboChohyoDataSakusei;
import jp.co.ndensan.reams.db.dba.business.core.hihohenshashohakokanribocsvdatasakusei.HihohenshashoHakoKanriboCsvDataSakusei;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoBreaker;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriTitleCreator;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba110010.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakkoKanriboChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakoKanriboCsvDataSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshashohakkokanribo.IHihokenshashoHakkoKanriboMapper;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 被保険者証発行管理簿_バッチ処理クラスです
 *
 * @reamsid_L DBA-0600-020 zhangguopeng
 */
public class HihokenshashoHakkoKanriboProcess extends SimpleBatchProcessBase {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private HihokenshashoHakkoKanriboProcessParameter processParameter;
    private HihokenshashoHakkoKanriboMybatisParameter mybatisParameter;
    private IHihokenshashoHakkoKanriboMapper mapper;
    private AkasiHakouKanriRelateEntity shoHakkoKanriRelate;
    private FileSpoolManager manager;
    private IOutputOrder shutsuryokujun;

    @BatchWriter
    private EucCsvWriter<HihohenshashoHakoKanriboCsvDataSakuseiEntity> eucCsvWriter;
    private BatchReportWriter<HihokenshashoHakkoKanriIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<HihokenshashoHakkoKanriIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(IHihokenshashoHakkoKanriboMapper.class);

        IChohyoShutsuryokujunFinder shutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        shutsuryokujun = shutsuryokujunFinder.get出力順(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200004.getReportId(),
                processParameter.getSyuturyokujunid());
    }

    @Override
    protected void process() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();

        RString csvName = HihokenshashoHakkoKanriTitleCreator.createCSV名称(processParameter.getAkasihakoumod(),
                processParameter.getSiyuturiyokudaysyou());

        shoHakkoKanriRelate = new AkasiHakouKanriRelateEntity();
        shoHakkoKanriRelate.setAkasihakoumode(processParameter.getAkasihakoumod());
        shoHakkoKanriRelate.setChouhouTitle(HihokenshashoHakkoKanriTitleCreator.create帳票名(processParameter.getAkasihakoumod(),
                processParameter.getSiyuturiyokudaysyou()));

        shoHakkoKanriRelate.setShichosonCode(new LasdecCode(association.get地方公共団体コード().getColumnValue()));
        shoHakkoKanriRelate.setShichosonMeisho(association.get市町村名());
        shoHakkoKanriRelate.setKoumukumeyifukaflg(processParameter.isKoumukumeyifukaflg());
        shoHakkoKanriRelate.setRenbanfukaflg(processParameter.isRenbanfukaflg());
        shoHakkoKanriRelate.setHizikehensyuuflg(processParameter.isHizikehensyuuflg());
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
                processParameter.isSeyisinjyohoflg(),
                processParameter.getSiyuturiyokudaysyou(),
                HihokenshashoHakkoKanriboCommonProcess.createOrderBy(shutsuryokujun),
                HihokenshashoHakkoKanriboCommonProcess.createPageBreakItem(shutsuryokujun)
        );
        List<AkasiHakouKanriEntity> akaEntityList = mapper.get証発行管理リスト情報(mybatisParameter);
        List<AkasiHakouKanriEntity> 最新情報リスト = new ArrayList<>();
        for (AkasiHakouKanriEntity akasiEntity : akaEntityList) {
            最新情報リスト.add(akasiEntity);
        }
        shoHakkoKanriRelate.setAkasiHakouKanriEntityList(最新情報リスト);
        HihohenshashoHakkoKanriboChohyoDataSakusei chohyoDataSakusei = new HihohenshashoHakkoKanriboChohyoDataSakusei();
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> chohyoDataSakuseiEntityList
                = chohyoDataSakusei.getShohakkoKanriChohyoDataList(shoHakkoKanriRelate, shutsuryokujun.get設定項目リスト());
        HihohenshashoHakoKanriboCsvDataSakusei checkListCsv = new HihohenshashoHakoKanriboCsvDataSakusei();
        List<HihohenshashoHakoKanriboCsvDataSakuseiEntity> eucCsvEntityList = new ArrayList<>();

        for (int i = 0; i < chohyoDataSakuseiEntityList.size(); i++) {
            HihohenshashoHakkoKanriboChohyoDataSakuseiEntity ent = chohyoDataSakuseiEntityList.get(i);
            ent.set連番(i + 1);
            eucCsvEntityList.add(checkListCsv.getShohakkoKanriCSVDataListAddRenban(
                    ent,
                    processParameter.isKoumukumeyifukaflg(),
                    processParameter.isHizikehensyuuflg()));
        }

        if (!最新情報リスト.isEmpty()) {
            List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> bodyItemList = new ArrayList<>();
            bodyItemList.addAll(chohyoDataSakusei.getShohakkoKanriChohyoDataList(shoHakkoKanriRelate, shutsuryokujun.get設定項目リスト()));
            ReportId reportId = HihokenshashoHakkoKanriboCommonProcess.getReportId(processParameter.getAkasihakoumod(),
                    processParameter.getSiyuturiyokudaysyou());
            batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId.value())
                    .addBreak(new HihokenshashoHakkoKanriIchiranhyoBreaker(shutsuryokujun.get設定項目リスト()))
                    .create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
            HihokenshashoHakkoKanriIchiranhyoReport report = HihokenshashoHakkoKanriIchiranhyoReport.createFrom(processParameter, bodyItemList);
            report.writeBy(reportSourceWriter);
            batchReportWriter.close();

            EucEntityId eucEntityId = HihokenshashoHakkoKanriboCommonProcess.getEucEntityId連番(processParameter.getAkasihakoumod(),
                    processParameter.getSiyuturiyokudaysyou());
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, eucEntityId, UzUDE0831EucAccesslogFileType.Csv);
            RString spoolWorkPath = manager.getEucOutputDirectry();
            this.eucFilePath = Path.combinePath(spoolWorkPath, csvName);
            eucCsvWriter = new EucCsvWriter.InstanceBuilder(this.eucFilePath, eucEntityId).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(shoHakkoKanriRelate.isKoumukumeyifukaflg()).
                    build();
            List<PersonalData> personalDataList = new ArrayList<>();
            for (HihohenshashoHakoKanriboCsvDataSakuseiEntity csvEntity : eucCsvEntityList) {
                eucCsvWriter.writeLine(csvEntity);
                ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"),
                        new RString("被保険者番号"), csvEntity.getHihokenshaNo());
                PersonalData personalData = PersonalData.of(new ShikibetsuCode(csvEntity.getShikibetsuCode()), expandedInformations);
                personalDataList.add(personalData);
            }
            HihokenshashoHakkoKanriboCommonProcess.outputJokenhyoFactory(eucEntityId,
                    shoHakkoKanriRelate, association, csvName, processParameter, eucCsvWriter);
            eucCsvWriter.close();
            AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(eucFilePath, id);
        }
    }

}
