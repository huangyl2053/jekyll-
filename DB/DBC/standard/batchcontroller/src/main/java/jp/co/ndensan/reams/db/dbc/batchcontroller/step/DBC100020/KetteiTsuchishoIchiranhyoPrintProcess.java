/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoBusiness;
import jp.co.ndensan.reams.db.dbc.business.report.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100020.KaishuriyushoShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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

    boolean isExists;
    HokenshaNo 証記載保険者番号;
    JigyoshaNo 介護住宅改修理由書作成事業者番号;
    Decimal count;
    int 連番;
    JigyoshaNo 事業者番号;

    @Override
    protected IBatchReader createReader() {

        isExists = false;
        count = Decimal.ZERO;
        事業者番号 = JigyoshaNo.EMPTY;
        連番 = 0;
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200064.getReportId().value())
                .addBreak(new BreakerCatalog<JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource>().
                        simplePageBreaker(pageBreakKeys)).create();
        business = new KaishuriyushoShikyuKetteitsuchishoBusiness();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.死亡者);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        key.set住民状態(juminJotaiList);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        processParameter.setPsmShikibetsuTaisho(psmShikibetsuTaisho);
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisPatameter());
    }

    @Override
    protected void usualProcess(KaishuriyushoShikyuKetteitsuchishoEntity entity) {

        entity.getRiyushoSakuseiJigyoshaNo();
        if (事業者番号.equals(entity.getRiyushoSakuseiJigyoshaNo())) {
            連番 = 連番 + 1;
        } else {
            連番 = 1;
        }
        isExists = true;
        count = count.add(Decimal.ONE);
        証記載保険者番号 = entity.getShoKisaiHokenshaNo();
        JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData data = business.createcreate住宅改修理由書作成手数料請求書兼申請書(entity);
        data.set作成年月日(processParameter.get作成日());
        data.set集計期間開始(processParameter.get決定開始日());
        data.set集計期間終了(processParameter.get決定終了日());
        data.set連番(new RString(String.valueOf(連番)));
        JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport report = new JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport(data);
        report.writeBy(reportSourceWriter);
        事業者番号 = entity.getRiyushoSakuseiJigyoshaNo();
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity));
    }

    @Override
    protected void keyBreakProcess(KaishuriyushoShikyuKetteitsuchishoEntity current) {
        hasBreak(getBefore(), current);
    }

    private boolean hasBreak(KaishuriyushoShikyuKetteitsuchishoEntity before, KaishuriyushoShikyuKetteitsuchishoEntity current) {
        return !before.getRiyushoSakuseiJigyoshaNo().equals(current.getRiyushoSakuseiJigyoshaNo());
    }

    private PersonalData toPersonalData(KaishuriyushoShikyuKetteitsuchishoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(被保険番号コード), 被保険者番号,
                entity.getHihokenshaNo().value());
        return PersonalData.of(entity.getShikibetsuCode(), expandedInfo);
    }

    @Override
    protected void afterExecute() {
    }
}
