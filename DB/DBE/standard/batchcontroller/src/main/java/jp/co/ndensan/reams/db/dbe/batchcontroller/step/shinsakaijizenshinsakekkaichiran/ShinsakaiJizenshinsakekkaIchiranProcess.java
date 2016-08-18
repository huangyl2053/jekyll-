/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsakaijizenshinsakekkaichiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.JizenShinsaKekkaRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.shinsakaijizenshinsakekkaichiran.ShinsakaiJizenshinsakekkaIchiranReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaijizenshinsakekkaichiran.IShinsakaiJIzenShinsakekkaIchiranMapper;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事前審査結果一覧表の帳票のプロセス処理の帳票出力のプロセスクラスです。
 *
 * @reamsid_L DBE-1640-020 zhaoyao
 */
public class ShinsakaiJizenshinsakekkaIchiranProcess extends BatchProcessBase<ShinsakaiJizenshinsakekkaIchiranRelateEntity> {

    private static final RString MYBATIS_SELECT_ID_TAISHOSHA = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsakaijizenshinsakekkaichiran."
            + "IShinsakaiJIzenShinsakekkaIchiranMapper.get審査会対象者情報");
    private static final ReportId REPORT_ID = ReportIdDBE.DBE520001.getReportId();
    private static final RString なし = new RString("なし");
    private static final int ZERO = 0;
    private static final int YON = 4;
    private ShinsakaiJizenshinsakekkaIchiranProcessParameter parameter;
    private IShinsakaiJIzenShinsakekkaIchiranMapper mapper;
    private List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> 審査会結果情報;
    private List<JizenShinsaKekkaRelateEntity> 審査員名;
    private List<ShinsakaiJizenshinsakekkaIchiranRelateEntity> 審査会情報;
    private int データフラグ;

    @BatchWriter
    private BatchReportWriter<ShinsakaiJizenshinsakekkaIchiranReportSource> batchWriter;
    private ReportSourceWriter<ShinsakaiJizenshinsakekkaIchiranReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        mapper = getMapper(IShinsakaiJIzenShinsakekkaIchiranMapper.class);
        審査会結果情報 = new ArrayList<>();
        審査員名 = new ArrayList<>();
        審査会情報 = new ArrayList<>();
        審査会結果情報 = mapper.get事前審査会結果情報(parameter.toMybitisParamter());
        審査員名 = mapper.get審査員名(parameter.toMybitisParamter());
        審査会情報 = mapper.get審査会情報(parameter.toMybitisParamter());
        データフラグ = mapper.get審査会対象者情報(parameter.toMybitisParamter()).size();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID_TAISHOSHA, parameter.toMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(REPORT_ID.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShinsakaiJizenshinsakekkaIchiranRelateEntity 審査会対象者情報) {
        ShinsakaiJizenshinsakekkaIchiranBusiness business = new ShinsakaiJizenshinsakekkaIchiranBusiness(
                審査会対象者情報, 審査会情報, 審査員名, 審査会結果情報, データフラグ);
        ShinsakaiJizenshinsakekkaIchiranReport report = new ShinsakaiJizenshinsakekkaIchiranReport(business);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        帳票バッチ出力条件リストの出力();
    }

    private void 帳票バッチ出力条件リストの出力() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBE.DBE520001.getReportId().value(), 導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(), new RString(JobContextHolder.getJobId()),
                ReportIdDBE.DBE520001.getReportName(), new RString(reportSourceWriter.pageCount().value()),
                なし, なし, set出力条件());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> set出力条件() {
        List<RString> 出力条件 = new ArrayList<>();
        RString 条件;
        if (RString.isNullOrEmpty(parameter.get介護認定審査会開催番号())) {
            条件 = RString.EMPTY;
        } else {
            条件 = new RStringBuilder("【審査会開催年度】")
                    .append(parameter.get介護認定審査会開催番号().substring(ZERO, YON))
                    .append(new RString("【審査会開催番号】"))
                    .append(parameter.get介護認定審査会開催番号().substring(parameter.get介護認定審査会開催番号().length() - YON))
                    .toRString();
        }
        出力条件.add(条件);
        return 出力条件;
    }
}
