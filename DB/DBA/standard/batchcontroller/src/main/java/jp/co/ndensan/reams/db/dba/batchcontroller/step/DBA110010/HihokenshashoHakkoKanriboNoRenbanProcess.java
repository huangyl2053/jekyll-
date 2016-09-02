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
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dba.business.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshashohakkokanribo.HihokenshashoHakkoKanriboMybatisParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba110010.HihokenshashoHakkoKanriboProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.AkasiHakouKanriRelateEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakkoKanriboChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.db.relate.hihokenshashohakkokanribo.HihohenshashoHakoKanriboCsvDataNoRebanSakuseiEntity;
import jp.co.ndensan.reams.db.dba.entity.report.hihokenshashohakkokanriichiranhyo.HihokenshashoHakkoKanriIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshashohakkokanribo.IHihokenshashoHakkoKanriboMapper;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * @reamsid_L DBA-0600-020 dingyi
 */
public class HihokenshashoHakkoKanriboNoRenbanProcess extends SimpleBatchProcessBase {

    private static final RString 証発行モード_001 = new RString("001");
    private static final RString 証発行モード_002 = new RString("002");
    private static final RString 発行管理リスト = new RString("1");
    private static final RString 被保険者証発行 = new RString("介護保険　被保険者証発行管理一覧表");
    private static final RString 資格者証発行 = new RString("介護保険　資格者証発行管理一覧表");
    private static final RString CSV名称_被保険者証発行 = new RString("被保険者証発行管理簿.csv");
    private static final RString CSV名称_資格者証発行 = new RString("資格者証発行管理簿.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBA200004"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private HihokenshashoHakkoKanriboProcessParameter processParameter;
    private HihokenshashoHakkoKanriboMybatisParameter mybatisParameter;
    private IHihokenshashoHakkoKanriboMapper mapper;
    private AkasiHakouKanriRelateEntity relateEntityList;
    private FileSpoolManager manager;

    @BatchWriter
    private EucCsvWriter<HihohenshashoHakoKanriboCsvDataNoRebanSakuseiEntity> eucCsvWriter;
    private BatchReportWriter<HihokenshashoHakkoKanriIchiranhyoReportSource> batchReportWriter;
    private ReportSourceWriter<HihokenshashoHakkoKanriIchiranhyoReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(IHihokenshashoHakkoKanriboMapper.class);

    }

    @Override
    protected void process() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        relateEntityList = new AkasiHakouKanriRelateEntity();
        relateEntityList.setAkasihakoumode(processParameter.getAkasihakoumod());
        RString csvName = CSV名称_被保険者証発行;
        if (証発行モード_001.equals(processParameter.getAkasihakoumod())) {
            relateEntityList.setChouhouTitle(被保険者証発行);
            csvName = CSV名称_被保険者証発行;
        } else if (証発行モード_002.equals(processParameter.getAkasihakoumod())) {
            relateEntityList.setChouhouTitle(資格者証発行);
            csvName = CSV名称_資格者証発行;
        }
        // TODO QA #73393 出力順ID実装方式 回復待ち  2016/01/20まで
        relateEntityList.setSortJun(processParameter.getSyuturyokujunid());
        relateEntityList.setKayiPeji(processParameter.getSyuturyokujunid());
        relateEntityList.setShichosonCode(new LasdecCode(association.get地方公共団体コード().getColumnValue()));
        relateEntityList.setShichosonMeisho(association.get市町村名());
        relateEntityList.setKoumukumeyifukaflg(processParameter.isKoumukumeyifukaflg());
        relateEntityList.setRenbanfukaflg(processParameter.isRenbanfukaflg());
        relateEntityList.setHizikehensyuuflg(processParameter.isHizikehensyuuflg());
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
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
        List<AkasiHakouKanriEntity> akaEntityList = mapper.get証発行管理リスト情報(mybatisParameter);
        List<AkasiHakouKanriEntity> 最新情報リスト = new ArrayList<>();
        RString 被保険者番号 = RString.EMPTY;
        for (int i = 0; i < akaEntityList.size(); i++) {
            if (発行管理リスト.equals(processParameter.getSiyuturiyokudaysyou()) && processParameter.isSeyisinjyohoflg()
                    && 被保険者番号.equals(akaEntityList.get(i).getHihokenshaNo())) {
                continue;
            }
            AkasiHakouKanriEntity akasiEntity = new AkasiHakouKanriEntity();
            akasiEntity.setRenban(i);
            akasiEntity.setHihokenshaNo(akaEntityList.get(i).getHihokenshaNo());
            akasiEntity.setShikibetsuCode(akaEntityList.get(i).getShikibetsuCode());
            akasiEntity.setShichosonCode(akaEntityList.get(i).getShichosonCode());
            akasiEntity.setKofuYMD(akaEntityList.get(i).getKofuYMD());
            akasiEntity.setKofuJiyu(akaEntityList.get(i).getKofuJiyu());
            akasiEntity.setKaishuYMD(akaEntityList.get(i).getKaishuYMD());
            akasiEntity.setKaishuJiyu(akaEntityList.get(i).getKaishuJiyu());
            akasiEntity.setYukoKigenYMD(akaEntityList.get(i).getYukoKigenYMD());
            akasiEntity.setShoYoshikiKubunCode(akaEntityList.get(i).getShoYoshikiKubunCode());
            akasiEntity.setYubinNo(akaEntityList.get(i).getYubinNo());
            akasiEntity.setMeisho(akaEntityList.get(i).getMeisho());
            akasiEntity.setJusho(akaEntityList.get(i).getJusho());
            最新情報リスト.add(akasiEntity);
            被保険者番号 = akaEntityList.get(i).getHihokenshaNo();
        }
        relateEntityList.setAkasiHakouKanriEntityList(最新情報リスト);
        HihohenshashoHakkoKanriboChohyoDataSakusei chohyoDataSakusei = new HihohenshashoHakkoKanriboChohyoDataSakusei();
        List<HihohenshashoHakkoKanriboChohyoDataSakuseiEntity> chohyoDataSakuseiEntityList
                = chohyoDataSakusei.getShohakkoKanriChohyoDataList(relateEntityList);
        HihohenshashoHakoKanriboCsvDataSakusei checkListCsv = new HihohenshashoHakoKanriboCsvDataSakusei();
        List<HihohenshashoHakoKanriboCsvDataNoRebanSakuseiEntity> eucCsvEntityList;
        eucCsvEntityList = checkListCsv.getShohakkoKanriCSVDataList(chohyoDataSakuseiEntityList,
                processParameter.isKoumukumeyifukaflg(),
                processParameter.isHizikehensyuuflg());
        if (!eucCsvEntityList.isEmpty()) {
            manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
            RString spoolWorkPath = manager.getEucOutputDirectry();
            this.eucFilePath = Path.combinePath(spoolWorkPath, csvName);
            eucCsvWriter = new EucCsvWriter.InstanceBuilder(this.eucFilePath, EUC_ENTITY_ID).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(relateEntityList.isKoumukumeyifukaflg()).
                    build();
            List<PersonalData> personalDataList = new ArrayList<>();
            for (HihohenshashoHakoKanriboCsvDataNoRebanSakuseiEntity csvEntity : eucCsvEntityList) {
                eucCsvWriter.writeLine(csvEntity);
                ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"),
                        new RString("被保険者番号"), csvEntity.getHihokenshaNo());
                PersonalData personalData = PersonalData.of(new ShikibetsuCode(csvEntity.getShikibetsuCode()), expandedInformations);
                personalDataList.add(personalData);
            }
            eucCsvWriter.close();
            AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(eucFilePath, id);
        }
        if (!最新情報リスト.isEmpty()) {
            HihokenshashoHakkoKanriIchiranhyoHeadItem headItem = new HihokenshashoHakkoKanriIchiranhyoHeadItem(
                    chohyoDataSakuseiEntityList.get(0).get印刷日時(),
                    RString.EMPTY,
                    chohyoDataSakuseiEntityList.get(0).get帳票タイトル(),
                    chohyoDataSakuseiEntityList.get(0).get市町村コード(),
                    chohyoDataSakuseiEntityList.get(0).get市町村名(),
                    chohyoDataSakuseiEntityList.get(0).getソート順１(),
                    chohyoDataSakuseiEntityList.get(0).getソート順２(),
                    chohyoDataSakuseiEntityList.get(0).getソート順３(),
                    chohyoDataSakuseiEntityList.get(0).getソート順４(),
                    chohyoDataSakuseiEntityList.get(0).getソート順５(),
                    chohyoDataSakuseiEntityList.get(0).get改頁１(),
                    chohyoDataSakuseiEntityList.get(0).get改頁２(),
                    chohyoDataSakuseiEntityList.get(0).get改頁３(),
                    chohyoDataSakuseiEntityList.get(0).get改頁４(),
                    chohyoDataSakuseiEntityList.get(0).get改頁５()
            );
            List<HihokenshashoHakkoKanriIchiranhyoBodyItem> bodyItemList = chohyoDataSakusei.setShohakkoKanriChohyoDataList(relateEntityList);
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBA.DBA200004.getReportId().value()).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
            HihokenshashoHakkoKanriIchiranhyoReport report = HihokenshashoHakkoKanriIchiranhyoReport.createFrom(headItem, bodyItemList);
            report.writeBy(reportSourceWriter);
            batchReportWriter.close();
        }
    }

}
