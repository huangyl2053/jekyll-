/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100010;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100010.KaishuriyushoSeikyushoShinseishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc100010.ChouhyouShuturyokuYouDataEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData;
import jp.co.ndensan.reams.db.dbc.entity.report.source.jutariyutesuseikenshinichiran.JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成のバッチ処理クラスです。
 *
 * @reamsid_L DBC-2860-030 suguangjun
 *
 */
public class KaishuriyushoSeikyushoShinseishoDBC200064Process extends BatchKeyBreakBase<ChouhyouShuturyokuYouDataEntity> {

    private static final ReportId REPORT_ID = ReportIdDBC.DBC200064.getReportId();
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc100010."
            + "IKaishuriyushoSeikyushoShinseishoMapper.get帳票出力用データ");
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(
                            new RString(JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource.ReportSourceFields.jigyoshaMeisho.name())));
    private KaishuriyushoSeikyushoShinseishoProcessParameter processParameter;
    @BatchWriter
    private BatchReportWriter<JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource> batchWrite;
    private ReportSourceWriter<JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        super.beforeExecute();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.日本人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.外国人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.住登外個人_日本人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.住登外個人_外国人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.法人);
        key.getPSM検索キー().get住民種別().add(JuminShubetsu.共有者);
        key.getPSM検索キー().get住民状態().add(JuminJotai.住民);
        key.getPSM検索キー().get住民状態().add(JuminJotai.住登外);
        key.getPSM検索キー().get住民状態().add(JuminJotai.消除者);
        key.getPSM検索キー().get住民状態().add(JuminJotai.転出者);
        key.getPSM検索キー().get住民状態().add(JuminJotai.死亡者);
        key.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        processParameter.setPsmShikibetsuTaisho(new RString(uaFt200Psm.getParameterMap().
                get("psmShikibetsuTaisho").toString()));
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toKaishuriyushoSeikyushoShinseishoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_ID.value())
                .addBreak(new BreakerCatalog<JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReportSource>()
                        .simplePageBreaker(PAGE_BREAK_KEYS)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void keyBreakProcess(ChouhyouShuturyokuYouDataEntity entity) {

    }

    @Override
    protected void usualProcess(ChouhyouShuturyokuYouDataEntity entity) {
        JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData data = new JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranData();
        data.set作成年月日(processParameter.get作成日());
        data.set事業者名(entity.get介護住宅改修事業者名称());
        data.set集計期間開始(new FlexibleDate(processParameter.get作成申請年月日開始().toString()));
        data.set集計期間終了(new FlexibleDate(processParameter.get作成申請年月日終了().toString()));
        data.set理由書作成日(entity.get介護住宅改修理由書作成年月日());
        data.set被保険者番号(entity.get被保険者番号().value());
        data.set被保険者氏名(entity.get名称());
        data.set改修先住所(entity.get改修対象住宅住所());
        data.set工事の種類(entity.get改修内容箇所及び規模());
        data.set理由書作成者(entity.get介護住宅改修理由書作成者名());
        data.set備考(RString.EMPTY);
        data.set識別コード(entity.get識別コード());
        JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport report = new JutakukaishuRiyushoTesuryoSeikyuKenShinseishoIchiranReport(data);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
    }
}
