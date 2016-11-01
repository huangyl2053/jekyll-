/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Report;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppohokenkyufukogakugassan.JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272Entity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogakugassan.JigyoJoukyouHoukokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki272.JigyohokokuCompYoshiki272ReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 保険給付決定状況【高額介護サービス費分】帳票出力のバッチ処理クラスです。
 *
 * @reamsid_L DBU-5590-030 zhangzhiming
 */
public class JigyoHokokuDataReportDBU300020Process extends BatchProcessBase<JigyoJoukyouHoukokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogakugassan."
            + "IJigyoHokokuGeppoHokenkyufuKogakuGassanMapper.getJigyohokokuCompYoshiki272Report");
    private JigyoHokokuGeppoHokenkyufuKogakuGassanProcessParamter processParameter;
    private static final ReportId REPORT_DBU300020 = ReportIdDBU.DBU300020.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(JigyohokokuCompYoshiki272ReportSource.ReportsSourceFields.hokenshaNo.name())));
    private static final RString 月報区分 = new RString("1");
    private static final RString 年報区分 = new RString("2");
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 年報月報区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("旧");
    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki272ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki272ReportSource> reportSourceWriter;
    private List<DbT7021JigyoHokokuTokeiDataEntity> entityData;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
        entityData = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toJigyohokokuCompYoshikiMybitisParamter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300020.value())
                .addBreak(new BreakerCatalog<JigyohokokuCompYoshiki272ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void process(JigyoJoukyouHoukokuDataRelateEntity entity) {
        DbT7021JigyoHokokuTokeiDataEntity dbt7021Entity = new DbT7021JigyoHokokuTokeiDataEntity();
        dbt7021Entity.setTateNo(entity.getTateNo());
        dbt7021Entity.setYokoNo(entity.getYokoNo());
        dbt7021Entity.setShukeiKekkaAtai(entity.getSukeiKekkaAtai());
        dbt7021Entity.setShukeiNo(entity.getSyukeiNo());
        dbt7021Entity.setShichosonCode(entity.getShichosonCode());
        dbt7021Entity.setShukeiKomokuMeisho(set保険者名(entity.getShichosonCode()));
        entityData.add(dbt7021Entity);
    }

    @Override
    protected void afterExecute() {
        JigyohokokuCompYoshiki272Entity reportData = new JigyohokokuCompYoshiki272Entity();
        if (年報月報区分.equals(processParameter.get報告区分())) {
            reportData.set年報月報区分(月報区分);
        } else {
            reportData.set年報月報区分(年報区分);
        }
        reportData.set事業報告統計データ(entityData);
        reportData.set作成日時(processParameter.get処理日時().getRDateTime());
        reportData.set集計年度(processParameter.get集計年度());
        reportData.set集計期間FROM(processParameter.get集計開始年月());
        reportData.set集計期間TO(processParameter.get集計終了年月());
        reportData.set集計年月(processParameter.get決定年月());
        reportData.set過去集計分旧市町村区分(processParameter.get過去集計分旧市町村区分());
        JigyohokokuCompYoshiki272Report report = new JigyohokokuCompYoshiki272Report(reportData);
        report.writeBy(reportSourceWriter);
    }

    private RString set保険者名(LasdecCode shichosonCode) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(shichosonCode);
        if (過去集計分旧市町村区分.equals(processParameter.get過去集計分旧市町村区分())) {
            return 固定文字列_旧.concat(地方公共団体.get市町村名());
        } else {
            return 地方公共団体.get市町村名();
        }
    }
}
