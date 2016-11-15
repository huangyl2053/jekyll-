/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC020020;

import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyooshirasetsuchishokigenari.KogakuJigyoOshiraseTsuchishoKigenAriReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyooshirasetsuchishokigennashi.KogakuJigyoOshiraseTsuchishoKigenNashiReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuoshirasetsuchiteshutsukigen.KogakuOshiraseTsuchiTeshutsuKigenNashiReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuoshirasetsuchiteshutsukigenari.KogakuOshiraseTsuchiTeshutsuKigenAriReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyushinseisho.KogakuShikyuShinseishoReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyooshirasetsuchishokigenari.KogakuJigyoOshiraseTsuchishoKigenAriSource;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakujigyooshirasetsuchishokigenari.KogakuJigyoOshiraseTsuchishopaParameterEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyooshirasetsuchishoteshutsukigennashi.KogakuJigyoOshiraseTsuchishoKigenNashiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyooshirasetsuchishoteshutsukigennashi.KogakuJigyoOshiraseTsuchishoKigenNashiSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyoshikyushinseisho.KogakuJigyoShikyuShinseishoSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigenari.KogakuOshiraseTsuchiTeshutsuKigenAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigenari.KogakuOshiraseTsuchiTeshutsuKigenAriSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigennashi.KogakuOshiraseTsuchiTeshutsuKigenNashiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuoshirasetsuchiteshutsukigennashi.KogakuOshiraseTsuchiTeshutsuKigenNashiSource;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakushikyushinseisho.KogakuShikyuShinseishoSource;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 白紙発行のプロセスです。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class PrtShirakamiHakkoProcess extends SimpleBatchProcessBase {

    private static final RString 高額サービス給付のお知らせ通知書 = new RString("高額サービス給付のお知らせ通知書");
    private static final RString 総合事業高額サービス給付のお知らせ通知書 = new RString("総合事業高額サービス給付のお知らせ通知書");
    private static final ReportId 帳票分類ＩＤ_DBC100011 = new ReportId("DBC100011_KogakuOshiraseTsuchi");
    private static final ReportId 帳票分類ＩＤ_DBC100072 = new ReportId("DBC100072_KogakuJigyoOshiraseTsuchisho");
    private static final RString 高額介護サービス費 = new RString("DBCMN43001");
    private static final RString 保険者印 = new RString("0001");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter processParameter;

    private BatchReportWriter<KogakuShikyuShinseishoSource> dbc68BatchReportWriter;
    private ReportSourceWriter<KogakuShikyuShinseishoSource> dbc68ReportSourceWriter;
    private BatchReportWriter<KogakuOshiraseTsuchiTeshutsuKigenAriSource> dbc11BatchReportWriter;
    private ReportSourceWriter<KogakuOshiraseTsuchiTeshutsuKigenAriSource> dbc11ReportSourceWriter;
    private BatchReportWriter<KogakuOshiraseTsuchiTeshutsuKigenNashiSource> dbc12BatchReportWriter;
    private ReportSourceWriter<KogakuOshiraseTsuchiTeshutsuKigenNashiSource> dbc12ReportSourceWriter;

    private BatchReportWriter<KogakuJigyoShikyuShinseishoSource> dbc70BatchReportWriter;
    private ReportSourceWriter<KogakuJigyoShikyuShinseishoSource> dbc70ReportSourceWriter;
    private BatchReportWriter<KogakuJigyoOshiraseTsuchishoKigenAriSource> dbc72BatchReportWriter;
    private ReportSourceWriter<KogakuJigyoOshiraseTsuchishoKigenAriSource> dbc72ReportSourceWriter;
    private BatchReportWriter<KogakuJigyoOshiraseTsuchishoKigenNashiSource> dbc73BatchReportWriter;
    private ReportSourceWriter<KogakuJigyoOshiraseTsuchishoKigenNashiSource> dbc73ReportSourceWriter;

    @Override
    protected void process() {
        Ninshosha 認証者 = NinshoshaFinderFactory.createInstance().get帳票認証者(GyomuCode.DB介護保険, 保険者印);
        RString 認証者名 = 認証者.get市町村付与名称(AssociationFinderFactory.createInstance().getAssociation());
        if (高額介護サービス費.equals(processParameter.getMenuId())) {
            print高額申請書(認証者名);
            print高額お知らせ通知書();
        } else {
            print事業高額申請書(認証者名);
            print事業高額お知らせ通知書();
        }
    }

    private void print高額申請書(RString 認証者名) {
        dbc68BatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100068.getReportId().value()).create();
        dbc68ReportSourceWriter = new ReportSourceWriter<>(dbc68BatchReportWriter);

        KogakuShikyuShinseishoEntity param = new KogakuShikyuShinseishoEntity();
        param.setシステム日付(FlexibleDate.getNowDate());
        param.set申請情報帳票発行一時(null);
        param.set認証者役職名(認証者名);
        param.set空白(true);

        KogakuShikyuShinseishoReport report = new KogakuShikyuShinseishoReport(param);
        report.writeBy(dbc68ReportSourceWriter);
        dbc68BatchReportWriter.close();
    }

    private void print高額お知らせ通知書() {
        NinshoshaSource 認証者情報;
        RString 通常分通知文1 = get定型文(帳票分類ＩＤ_DBC100011, 1, 1);
        RString 通常分通知文2 = get定型文(帳票分類ＩＤ_DBC100011, 1, 2);
        if (processParameter.getShinseishoTeishutsuKigen() == null || processParameter.getShinseishoTeishutsuKigen().isEmpty()) {
            dbc12BatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100012_申請分.getReportId().value()).create();
            dbc12ReportSourceWriter = new ReportSourceWriter<>(dbc12BatchReportWriter);
            認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100012_申請分.getReportId(), FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbc12ReportSourceWriter);

            KogakuOshiraseTsuchiTeshutsuKigenNashiEntity param = new KogakuOshiraseTsuchiTeshutsuKigenNashiEntity();
            param.set空白(true);
            param.set自動償還(false);
            param.set認証者(認証者情報);
            param.set通知文1(通常分通知文1);
            param.set通知文2(通常分通知文2);
            param.set文書番号文字列(processParameter.getBunshoMojiretsu());
            param.setタイトル(高額サービス給付のお知らせ通知書);

            KogakuOshiraseTsuchiTeshutsuKigenNashiReport report = new KogakuOshiraseTsuchiTeshutsuKigenNashiReport(param);
            report.writeBy(dbc12ReportSourceWriter);
            dbc12BatchReportWriter.close();
        } else {
            dbc11BatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100011_Ari.getReportId().value()).create();
            dbc11ReportSourceWriter = new ReportSourceWriter<>(dbc11BatchReportWriter);
            認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100011_Ari.getReportId(), FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbc11ReportSourceWriter);

            KogakuOshiraseTsuchiTeshutsuKigenAriEntity param = new KogakuOshiraseTsuchiTeshutsuKigenAriEntity();
            param.set空白(true);
            param.set自動償還(false);
            param.set認証者(認証者情報);
            param.set通知文1(通常分通知文1);
            param.set通知文2(通常分通知文2);
            param.set文書番号文字列(processParameter.getBunshoMojiretsu());
            param.setタイトル(高額サービス給付のお知らせ通知書);

            KogakuOshiraseTsuchiTeshutsuKigenAriReport report = new KogakuOshiraseTsuchiTeshutsuKigenAriReport(param);
            report.writeBy(dbc11ReportSourceWriter);
            dbc11BatchReportWriter.close();
        }
    }

    private void print事業高額申請書(RString 認証者名) {
        dbc70BatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100070.getReportId().value()).create();
        dbc70ReportSourceWriter = new ReportSourceWriter<>(dbc70BatchReportWriter);

        KogakuJigyoShikyuShinseishoEntity param = new KogakuJigyoShikyuShinseishoEntity();
        param.setシステム日付(RDate.getNowDate());
        param.set申請情報帳票発行一時(null);
        param.set認証者役職名(認証者名);
        param.set空白(true);

        KogakuJigyoShikyuShinseishoReport report = new KogakuJigyoShikyuShinseishoReport(param);
        report.writeBy(dbc70ReportSourceWriter);
        dbc70BatchReportWriter.close();
    }

    private void print事業高額お知らせ通知書() {
        NinshoshaSource 認証者情報;
        RString 通常分通知文1 = get定型文(帳票分類ＩＤ_DBC100072, 1, 1);
        RString 通常分通知文2 = get定型文(帳票分類ＩＤ_DBC100072, 1, 2);
        if (processParameter.getShinseishoTeishutsuKigen() == null || processParameter.getShinseishoTeishutsuKigen().isEmpty()) {
            dbc73BatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100073.getReportId().value()).create();
            dbc73ReportSourceWriter = new ReportSourceWriter<>(dbc73BatchReportWriter);
            認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ＩＤ_DBC100072, FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbc73ReportSourceWriter);

            KogakuJigyoOshiraseTsuchishoKigenNashiEntity param = new KogakuJigyoOshiraseTsuchishoKigenNashiEntity();
            param.set空白(true);
            param.set自動償還(false);
            param.set認証者(認証者情報);
            param.set通知文1(通常分通知文1);
            param.set通知文2(通常分通知文2);
            param.set文書番号文字列(processParameter.getBunshoMojiretsu());
            param.setタイトル(総合事業高額サービス給付のお知らせ通知書);

            KogakuJigyoOshiraseTsuchishoKigenNashiReport report = new KogakuJigyoOshiraseTsuchishoKigenNashiReport(param);
            report.writeBy(dbc73ReportSourceWriter);
            dbc73BatchReportWriter.close();
        } else {
            dbc72BatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100072.getReportId().value()).create();
            dbc72ReportSourceWriter = new ReportSourceWriter<>(dbc72BatchReportWriter);
            認証者情報 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ＩＤ_DBC100072, FlexibleDate.getNowDate(),
                    NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, dbc72ReportSourceWriter);

            KogakuJigyoOshiraseTsuchishopaParameterEntity param = new KogakuJigyoOshiraseTsuchishopaParameterEntity();
            param.set空白(true);
            param.set自動償還(false);
            param.set認証者(認証者情報);
            param.set通知文1(通常分通知文1);
            param.set通知文2(通常分通知文2);
            param.set文書番号文字列(processParameter.getBunshoMojiretsu());
            param.setタイトル(総合事業高額サービス給付のお知らせ通知書);

            KogakuJigyoOshiraseTsuchishoKigenAriReport report = new KogakuJigyoOshiraseTsuchishoKigenAriReport(param);
            report.writeBy(dbc72ReportSourceWriter);
            dbc72BatchReportWriter.close();
        }
    }

    private RString get定型文(ReportId reportId, int パターン番号, int 項目番号) {
        Map<Integer, RString> map = ReportUtil.get通知文(SubGyomuCode.DBC介護給付, reportId, KamokuCode.EMPTY, パターン番号);
        return map == null ? RString.EMPTY : map.get(項目番号);
    }
}
