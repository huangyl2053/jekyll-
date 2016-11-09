/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU030020;

import jp.co.ndensan.reams.db.dbu.business.core.jigyohokokunenpoyoshiki1to2.JigyoHokokuNenpoYoshiki1To2Business;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1Report;
import jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku.PrintControlKubun;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokunenpoyoshiki1to2.JigyoHokokuNenpoYoshiki1To2ProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokunenpoyoshiki1to2.JigyoHokokuReportDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokunenpokyuyoshiki1.JigyohokokuNenpoKyuyoshiki1ReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業状況報告年報帳票出力_所得段階のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5610-030 chengsanyuan
 *
 */
public class JigyoHokokuDataReportDBU301125Process extends BatchProcessBase<JigyoHokokuReportDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokunenpoyoshiki1to2."
            + "IJigyoHokokuNenpoYoshiki1To2Mapper.getReportData");
    private JigyoHokokuNenpoYoshiki1To2ProcessParameter processParameter;

    private static final ReportId REPORT_DBU301125 = ReportIdDBU.DBU301125.getReportId();
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("（旧）");
    private static final RString 集計番号フラグ_所得段階 = new RString("2");

    private RString 保険者番号;
    private RString 保険者名;
    private JigyoHokokuNenpoYoshiki1To2Business business;

    @BatchWriter
    private BatchReportWriter<JigyohokokuNenpoKyuyoshiki1ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuNenpoKyuyoshiki1ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        business = new JigyoHokokuNenpoYoshiki1To2Business();
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        保険者番号 = 地方公共団体.get地方公共団体コード().value();
        if (過去集計分旧市町村区分.equals(processParameter.get過去集計分旧市町村区分())) {
            保険者名 = 固定文字列_旧.concat(地方公共団体.get市町村名());
        } else {
            保険者名 = 地方公共団体.get市町村名();
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toGetReportDataParm(集計番号フラグ_所得段階));
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU301125.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoHokokuReportDataRelateEntity entity) {
        business.setKyuyoshikiData(entity);
    }

    @Override
    protected void afterExecute() {
        JigyohokokuNenpoKyuyoshiki1Entity reportData = business.getKyuyoshikiData();
        if (PrintControlKubun.集計後印刷.getコード().equals(processParameter.getプリントコントロール区分())) {
            reportData.set処理日時(processParameter.get処理日時());
        }
        if (PrintControlKubun.過去分の印刷.getコード().equals(processParameter.getプリントコントロール区分())) {
            reportData.set処理日時(processParameter.get作成日時());
        }
        reportData.set保険者名(保険者名);
        reportData.set保険者番号(保険者番号);
        reportData.set集計年度(new FlexibleYear(processParameter.get集計年度()));
        reportData.set集計期間FROM(new FlexibleYearMonth(processParameter.get集計開始年月()));
        reportData.set集計期間TO(new FlexibleYearMonth(processParameter.get集計終了年月()));
        JigyohokokuNenpoKyuyoshiki1Report report = new JigyohokokuNenpoKyuyoshiki1Report(reportData);
        report.writeBy(reportSourceWriter);
    }
}
