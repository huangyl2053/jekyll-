/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100020;

import jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoBusiness;
import jp.co.ndensan.reams.db.dbc.business.report.jutakukaishuriyushosakusei.JutakuKaishuRiyushoSakuseiReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc100020.KaishuriyushoShikyuKetteitsuchishoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jutakukaishuriyushosakusei.JutakuKaishuRiyushoSakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.jutakukaishuriyushosakusei.JutakuKaishuRiyushoSakuseiReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.toiawasesaki.Toiawasesaki;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.toiawasesaki.ToiawasesakiFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.BushoCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 決定通知書発行のProcessクラスです。
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
public class KetteiTsuchishoPrintProcess extends BatchProcessBase<KaishuriyushoShikyuKetteitsuchishoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kaishuriyushoshikyuketteitsuchishosakusei.IKaishuriyushoShikyuKetteitsuchishoSakuseiMapper.get住宅改修理由書作成手数料請求");
    private static final RString 被保険番号コード = new RString("0003");
    private static final RString 被保険者番号 = new RString("被保険者番号");

    private KaishuriyushoShikyuKetteitsuchishoProcessParameter processParameter;
    @BatchWriter
    BatchReportWriter<JutakuKaishuRiyushoSakuseiReportSource> batchReportWriter;
    ReportSourceWriter<JutakuKaishuRiyushoSakuseiReportSource> reportSourceWriter;
    NinshoshaSource 認証者情報;
    ChohyoSeigyoKyotsu 帳票共通情報;
    RString 通知文上段;
    RString 通知文下段;
    Toiawasesaki 問合せ;
    JigyoshaNo 事業者番号;
    KaishuriyushoShikyuKetteitsuchishoBusiness business;

    @Override
    protected IBatchReader createReader() {
        事業者番号 = JigyoshaNo.EMPTY;
        business = new KaishuriyushoShikyuKetteitsuchishoBusiness();
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100044.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100044.getReportId(), processParameter.get作成日(),
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        帳票共通情報 = new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100044.getReportId());
        通知文上段 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100044.getReportId(), KamokuCode.EMPTY, 1, 1, FlexibleDate.getNowDate());
        通知文下段 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100044.getReportId(), KamokuCode.EMPTY, 1, 2, FlexibleDate.getNowDate());
        問合せ = ToiawasesakiFinderFactory.createInstance()
                .get問合せ先(
                        GyomuCode.DB介護保険, ReportIdDBC.DBC100044.getReportId(), BushoCode.EMPTY, RDate.getNowDate());
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toMybatisPatameter());
    }

    @Override
    protected void process(KaishuriyushoShikyuKetteitsuchishoEntity entity) {

        if (事業者番号.equals(entity.getRiyushoSakuseiJigyoshaNo())) {
            return;
        }
        JutakuKaishuRiyushoSakuseiEntity 帳票データ
                = business.create決定通知書情報(認証者情報, 帳票共通情報, 通知文上段, 通知文下段, 問合せ, entity);
        帳票データ.setBunshoNo(processParameter.get文書番号());
        JutakuKaishuRiyushoSakuseiReport report = new JutakuKaishuRiyushoSakuseiReport(帳票データ);
        report.writeBy(reportSourceWriter);
        AccessLogger.log(AccessLogType.照会, toPersonalData(entity));
        事業者番号 = entity.getRiyushoSakuseiJigyoshaNo();
    }

    private PersonalData toPersonalData(KaishuriyushoShikyuKetteitsuchishoEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(被保険番号コード), 被保険者番号,
                entity.getHihokenshaNo().value());
        return PersonalData.of(entity.getShikibetsuCode(), expandedInfo);
    }
}
