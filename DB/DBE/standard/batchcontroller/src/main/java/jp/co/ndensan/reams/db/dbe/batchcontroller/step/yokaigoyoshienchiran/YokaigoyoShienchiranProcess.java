/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.yokaigoyoshienchiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoyoshienchiran.YokaigoyoShienchiran;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranItem;
import jp.co.ndensan.reams.db.dbe.business.report.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseijouhouinnsatu.ShinseiJouhouInsatuProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseimonitor.ShinseiMonitorEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.yokaigoyoshienshinseiichiran.YokaigoYoshienShinseiIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 申請情報印刷のデータを作成します。
 *
 * @reamsid_L DBE-1390-020 suguangjun
 */
public class YokaigoyoShienchiranProcess extends BatchProcessBase<ShinseiMonitorEntity> {

    private static final ReportId REPORT_ID = ReportIdDBE.DBE011001.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseijouhouinnsatu."
            + "IShinseiJouhouInsatuRelateMapper.selectShinseiJouhou");
    private ShinseiJouhouInsatuProcessParameter processParameter;
    private static final RString MIDDLELINE = RString.EMPTY;
    private static final RString 無し = new RString("無し");
    @BatchWriter
    private BatchReportWriter<YokaigoYoshienShinseiIchiranReportSource> batchWrite;
    private ReportSourceWriter<YokaigoYoshienShinseiIchiranReportSource> reportSourceWriter;
    private int index_tmp = 0;
    private RString 導入団体コード;
    private RString 市町村名;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        導入団体コード = 導入団体クラス.getLasdecCode_().value();
        市町村名 = 導入団体クラス.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        processParameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap().
                get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toShinseiJouhouInsatuMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void afterExecute() {
        if (index_tmp == 0) {
            YokaigoYoshienShinseiIchiranItem item = new YokaigoYoshienShinseiIchiranItem();
            item.setHihokenshaName(new RString("該当データがありません"));
            item.setRenban(new RString("1"));
            YokaigoYoshienShinseiIchiranReport report = YokaigoYoshienShinseiIchiranReport.createFrom(item);
            report.writeBy(reportSourceWriter);
        }
        バッチ出力条件リストの出力();
    }

    @Override
    protected void process(ShinseiMonitorEntity entity) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity));
        index_tmp++;
        YokaigoyoShienchiran chiran = new YokaigoyoShienchiran();
        YokaigoYoshienShinseiIchiranItem item = chiran.getIchiranItem(entity);
        item.setRenban(new RString(index_tmp));
        YokaigoYoshienShinseiIchiranReport report = YokaigoYoshienShinseiIchiranReport.createFrom(item);
        report.writeBy(reportSourceWriter);
    }

    private PersonalData toPersonalData(ShinseiMonitorEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0001")), new RString("申請書管理番号"),
                entity.get申請書管理番号());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private void バッチ出力条件リストの出力() {
        RStringBuilder ジョブ番号_Tmp = new RStringBuilder();
        ジョブ番号_Tmp.append(JobContextHolder.getJobId());
        RString ジョブ番号 = ジョブ番号_Tmp.toRString();
        RString 帳票名 = ReportIdDBE.DBE011001.getReportName();
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        RString csv出力有無 = 無し;
        RString csvファイル名 = MIDDLELINE;
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(dateFormat(processParameter.getShinnseikaFrom()));
        出力条件.add(dateFormat(processParameter.getShinnseikaTo()));
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE011001.getReportId().value(), 導入団体コード, 市町村名, ジョブ番号,
                帳票名, 出力ページ数, csv出力有無, csvファイル名, 出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(item);
        printer.print();
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }

}
