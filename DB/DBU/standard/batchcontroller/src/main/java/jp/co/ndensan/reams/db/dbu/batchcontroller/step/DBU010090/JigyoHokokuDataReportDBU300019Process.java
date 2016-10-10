/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU010090;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.report.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Report;
import jp.co.ndensan.reams.db.dbu.definition.processprm.jigyohokokugeppohokenkyufukogaku.JigyoHokokuGeppoHokenkyufuKogakuProcessParamter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.basic.DbT7021JigyoHokokuTokeiDataEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271Data;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.jigyohokokugeppohokenkyufukogaku.JigyoJoukyouHoukokuDataRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.jigyohokokucompyoshiki271.JigyohokokuCompYoshiki271ReportSource;
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
 * @reamsid_L DBU-5580-030 zhangzhiming
 */
public class JigyoHokokuDataReportDBU300019Process extends BatchProcessBase<JigyoJoukyouHoukokuDataRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.jigyohokokugeppohokenkyufukogaku."
            + "IJigyoHokokuGeppoHokenkyufuKogakuMapper.getJigyohokokuCompYoshiki271Report");
    private JigyoHokokuGeppoHokenkyufuKogakuProcessParamter processParameter;
    private static final ReportId REPORT_DBU300019 = ReportIdDBU.DBU300019.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(JigyohokokuCompYoshiki271ReportSource.ReportsSourceFields.hokenshaNo.name())));
    private static final RString 年報月報区分 = new RString("月報");
    private static final RString 過去集計分旧市町村区分 = new RString("1");
    private static final RString 固定文字列_旧 = new RString("旧");
    @BatchWriter
    private BatchReportWriter<JigyohokokuCompYoshiki271ReportSource> batchWrite;
    private ReportSourceWriter<JigyohokokuCompYoshiki271ReportSource> reportSourceWriter;
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
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBU300019.value())
                .addBreak(new BreakerCatalog<JigyohokokuCompYoshiki271ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS)).create();
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
        JigyohokokuCompYoshiki271Data reportData = new JigyohokokuCompYoshiki271Data();
        reportData.set年報月報区分(年報月報区分);
        reportData.set作成日時(processParameter.get処理日時().getRDateTime());
        reportData.set集計年月(processParameter.get集計年月());
        reportData.set事業報告統計データ(entityData);
        reportData.set過去集計分旧市町村区分(processParameter.get過去集計分旧市町村区分());
        JigyohokokuCompYoshiki271Report report = new JigyohokokuCompYoshiki271Report(reportData);
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
