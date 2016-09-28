/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100020;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoBusiness;
import jp.co.ndensan.reams.db.dbc.business.report.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100020.KaishuriyushoShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.DbWT3095JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 決定通知書発行のProcessクラスです。
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
public class KetteiTsuchishoIchiranhyoPrintProcess extends BatchKeyBreakBase<KaishuriyushoShikyuKetteitsuchishoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kaishuriyushoshikyuketteitsuchishosakusei.IKaishuriyushoShikyuKetteitsuchishoSakuseiMapper.get住宅改修理由書作成手数料請求");
    private final List<RString> pageBreakKeys = Collections.unmodifiableList(Arrays.asList(
            new RString(JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource.ReportSourceFields.jigyoshaMeisho.name())));
    private static final RString 被保険番号コード = new RString("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");

    private KaishuriyushoShikyuKetteitsuchishoProcessParameter processParameter;
    @BatchWriter
    BatchReportWriter<JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource> batchReportWriter;
    ReportSourceWriter<JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource> reportSourceWriter;
    KaishuriyushoShikyuKetteitsuchishoBusiness business;
    private static final RString 住宅改修理由書作成手数料請求明細_TABLE_NAME = new RString("DbT3095JutakuKaishuRiyushoTesuryoMeisai");
    private static final RString 住宅改修理由書作成手数料請求集計_TABLE_NAME = new RString("DbT3095JutakuKaishuRiyushoTesuryoShukei");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 住宅改修理由書作成手数料請求明細tableWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 住宅改修理由書作成手数料請求集計tableWriter;
    boolean isExists;
    HokenshaNo 証記載保険者番号;
    JigyoshaNo 介護住宅改修理由書作成事業者番号;
    Decimal count;

    @Override
    protected IBatchReader createReader() {

        isExists = false;
        count = Decimal.ZERO;
        住宅改修理由書作成手数料請求明細tableWriter
                = new BatchEntityCreatedTempTableWriter(住宅改修理由書作成手数料請求明細_TABLE_NAME, DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity.class);
        住宅改修理由書作成手数料請求集計tableWriter
                = new BatchEntityCreatedTempTableWriter(住宅改修理由書作成手数料請求集計_TABLE_NAME, DbWT3095JutakuKaishuRiyushoTesuryoShukeiEntity.class);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200064.getReportId().value())
                .addBreak(new BreakerCatalog<JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource>().
                        simplePageBreaker(pageBreakKeys)).create();
        business = new KaishuriyushoShikyuKetteitsuchishoBusiness();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisPatameter());
    }

    @Override
    protected void usualProcess(KaishuriyushoShikyuKetteitsuchishoEntity entity) {

        isExists = true;
        count = count.add(Decimal.ONE);
        // TODO 1782確認中
        住宅改修理由書作成手数料請求明細tableWriter.insert(business.create住宅改修理由書作成手数料請求明細(entity));
        証記載保険者番号 = entity.getShoKisaiHokenshaNo();
        JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData data = business.createcreate住宅改修理由書作成手数料請求書兼申請書(entity);
        data.set作成年月日(processParameter.get作成日());
        data.set集計期間開始(processParameter.get決定開始日());
        data.set集計期間終了(processParameter.get決定終了日());
        JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport report = new JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport(data);
        report.writeBy(reportSourceWriter);
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity));
    }

    @Override
    protected void keyBreakProcess(KaishuriyushoShikyuKetteitsuchishoEntity current) {
        hasBreak(getBefore(), current);
    }

    private boolean hasBreak(KaishuriyushoShikyuKetteitsuchishoEntity before, KaishuriyushoShikyuKetteitsuchishoEntity current) {
        return before.getHihokenshaNo() != current.getHihokenshaNo();
    }

    @Override
    protected void afterExecute() {

        if (isExists) {
            // TODO 1782確認中
            Decimal 介護住宅改修理由書作成単価 = new Decimal(DbBusinessConfig.
                    get(ConfigNameDBC.介護住宅改修理由書作成単価, RDate.getNowDate(), SubGyomuCode.DBC介護給付).toString());
            DbWT3095JutakuKaishuRiyushoTesuryoShukeiEntity entity = new DbWT3095JutakuKaishuRiyushoTesuryoShukeiEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setRiyushoSakuseiJigyoshaNo(介護住宅改修理由書作成事業者番号);
            entity.setRirekiNo(0);
            entity.setShukeiKaishiYM(processParameter.get決定開始日().getYearMonth());
            entity.setShukeiShuryoYM(processParameter.get決定終了日().getYearMonth());
            entity.setRiyushoSakuseiKensu(count);
            entity.setRiyushoSakuseiTanka(介護住宅改修理由書作成単価);
            entity.setRiyushoSakuseiSeikyuKingaku(介護住宅改修理由書作成単価.multiply(count));
            住宅改修理由書作成手数料請求集計tableWriter.insert(entity);

        }
    }

    private PersonalData toPersonalData(KaishuriyushoShikyuKetteitsuchishoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(被保険番号コード), 被保険者番号,
                entity.getHihokenshaNo().value());
        return PersonalData.of(entity.getShikibetsuCode(), expandedInfo);
    }
}
