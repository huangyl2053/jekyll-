/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC815001;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishosBusiness;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukaigotaishoshachushutsusokyubun.KakobunJissekiKihonBusiness;
import jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo.kogakuservicehitaishoshaichiransokyubun.KogakuServicehiTaishoshaIchiranSokyubunReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.KougakukaigoSabishiEucEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigotaishoshachushutsusokyubun.TaishoushaitiranhyouhakkouShorientity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehitaishoshaichiransokyubun.KogakuServicehiTaishoshaIchiranSokyubunEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehitaishoshaichiransokyubun.KogakuServicehiTaishoshaIchiranSokyubunReportSource;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukaigotaishoshachushutsusokyubun.KogakuKaigoTaishoshaChushutsuSokyubun;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBCMN41003_高額介護対象者抽出（遡及分）のProcessです。
 *
 * @reamsid_L DBC-5750-030 wanghui
 */
public class TaishoushaitiranhyouhakkouShori extends BatchKeyBreakBase<TaishoushaitiranhyouhakkouShorientity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.kogakukaigotaishoshachushutsusokyubun.IKogakuKaigoTaishoshaChushutsuSokyubunMapper.get対象者一覧表発行処理");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200100"));
    private FileSpoolManager manager;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private KogakuKaigoTaishoshaChushutsuSokyubun sokyubun;
    private KogakuKaigoTaishoProcessParameter parameter;
    private List<RString> pageBreakKeys;
    private ShutsuryokujunRelateEntity 出力順Entity;
    private KogakuServicehiTaishoshaIchiranSokyubunEntity sokyubunentity;
    private LasdecCode 団体コード;
    private KakobunJissekiKihonBusiness business;
    private KougakukaigoSabishiEucEntity eucentity;
    private int 連番;
    @BatchWriter
    private BatchReportWriter<KogakuServicehiTaishoshaIchiranSokyubunReportSource> batchReportWriter;
    private ReportSourceWriter<KogakuServicehiTaishoshaIchiranSokyubunReportSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<KougakukaigoSabishiEucEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void initialize() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        団体コード = association.get地方公共団体コード();
        出力順Entity = get出力順項目();
        sokyubun = KogakuKaigoTaishoshaChushutsuSokyubun.createInstance();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString 対象者一覧CSV名 = new RString("DBC200100_KogakuTaishoshaIchiranSokyubun.csv");
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), 対象者一覧CSV名);
        business = new KakobunJissekiKihonBusiness();
        連番 = 1;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, business.setparameter(parameter, 団体コード.value(), 出力順Entity.get出力順OrderBy()));
    }

    @Override
    protected void createWriter() {
        pageBreakKeys = Collections.unmodifiableList(出力順Entity.getPageBreakKeys());
        if (pageBreakKeys != null && !pageBreakKeys.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200100.getReportId().value())
                    .addBreak(new BreakerCatalog<KogakuServicehiTaishoshaIchiranSokyubunReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200100.getReportId().value()).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void keyBreakProcess(TaishoushaitiranhyouhakkouShorientity entity) {

    }

    @Override
    protected void usualProcess(TaishoushaitiranhyouhakkouShorientity entity) {
        連番 = sokyubun.get給付実績基本データ抽出(entity, eucentity, 連番);
        eucCsvWriterJunitoJugo.writeLine(eucentity);
        sokyubunentity = sokyubun.get高額介護サービス費対象者一覧表(entity, 出力順Entity);
        KogakuServicehiTaishoshaIchiranSokyubunReport report = new KogakuServicehiTaishoshaIchiranSokyubunReport(sokyubunentity);
        report.writeBy(reportSourceWriter);
        sokyubun.getアクセスログ(entity.get識別コード());
    }

    @Override
    protected void afterExecute() {
        eucCsvWriterJunitoJugo.close();
        manager.spool(eucFilePath);
    }

    private ShutsuryokujunRelateEntity get出力順項目() {
        return ReportUtil.get出力順情報(KogakuKaigoTaishosBusiness.ShutsuryokujunEnum.class, SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200100.getReportId(),
                parameter.get出力順ID());
    }
}
