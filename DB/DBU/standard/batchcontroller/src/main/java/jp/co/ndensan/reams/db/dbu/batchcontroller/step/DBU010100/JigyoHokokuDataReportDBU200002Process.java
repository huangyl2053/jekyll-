/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100;

import jp.co.ndensan.reams.db.dbu.business.report.shorikekkakakuninist.ShoriKekkaKakuninListReport;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppohokenkyufukogakugassan.JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogakugassan.ShoriKekkaKakuninListRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist.ShoriKekkaKakuninListEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.shorikekkakakuninlist.ShoriKekkaKakuninListReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.api.BatchInfo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 処理結果確認リスト帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
public class JigyoHokokuDataReportDBU200002Process extends BatchProcessBase<ShoriKekkaKakuninListRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogakugassan."
            + "IJigyoHokokuGeppoHokenkyufuKogakuGassanMapper.getShoriKekkaKakuninListReport");
    private JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter processParameter;
    private static final ReportId REPORT_DBU200002 = ReportIdDBU.DBU200002.getReportId();
    private RString 保険者番号;
    private RString 保険者名;
    @BatchWriter
    private BatchReportWriter<ShoriKekkaKakuninListReportSource> batchWrite;
    private ReportSourceWriter<ShoriKekkaKakuninListReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        保険者番号 = 地方公共団体.get地方公共団体コード().value();
        保険者名 = 地方公共団体.get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toShoriKekkaListDataMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU200002.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(ShoriKekkaKakuninListRelateEntity entity) {
        ShoriKekkaKakuninListEntity reportData = new ShoriKekkaKakuninListEntity();
        reportData.set作成日時(processParameter.get処理日時().getRDateTime());
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.setプログラムID(processParameter.getバッチID());
        reportData.set処理名称(BatchInfo.getBatchName(SubGyomuCode.DBU介護統計報告, processParameter.getバッチID()));
        reportData.set項目コード1(new RString("被保険者番号"));
        reportData.set項目コード2(new RString("対象年度"));
        reportData.set項目コード3(new RString("証記載保険者番号"));
        reportData.set項目コード4(new RString("申請書整理番号"));
        reportData.set項目値1(entity.getKomoku1());
        reportData.set項目値2(entity.getKomoku2());
        reportData.set項目値3(entity.getKomoku3());
        reportData.set項目値4(entity.getKomoku4());
        reportData.set内容1(entity.getNaiYou1());
        reportData.set内容2(entity.getNaiYou2());
        ShoriKekkaKakuninListReport report = new ShoriKekkaKakuninListReport(reportData);
        report.writeBy(reportSourceWriter);
    }
}
