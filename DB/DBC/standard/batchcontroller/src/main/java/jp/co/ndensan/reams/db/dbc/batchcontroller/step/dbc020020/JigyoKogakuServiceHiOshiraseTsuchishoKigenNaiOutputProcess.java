/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020020;

import jp.co.ndensan.reams.db.dbc.business.report.kogakujigyooshirasetsuchishokigennashi.KogakuJigyoOshiraseTsuchishoKigenNashiReport;
import jp.co.ndensan.reams.db.dbc.business.report.kogakuservicetsuchisho.KogakuJigyoShinseishoHakkoIchiranOrder;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufuoshirasetsuchisho.KogakuKaigoServicehiOshiraseHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigoservicehikyufuoshirasetsuchisho.ShinseiJohoChohyoTempRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyooshirasetsuchishoteshutsukigennashi.KogakuJigyoOshiraseTsuchishoKigenNashiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakujigyooshirasetsuchishoteshutsukigennashi.KogakuJigyoOshiraseTsuchishoKigenNashiSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibun;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 高額サービス費（総合事業）お知らせ通知書発行（通常分・自動償還分）の処理です。
 *
 * @reamsid_L DBC-4770-030 zhujun
 */
public class JigyoKogakuServiceHiOshiraseTsuchishoKigenNaiOutputProcess extends BatchProcessBase<ShinseiJohoChohyoTempRelateEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufuoshirasetsuchisho.IKogakuKaigoServicehiOshiraseHakkoMapper.getお知らせ通知書データ");
    private static final ReportId 帳票分類ＩＤ = new ReportId("DBC100072_KogakuJigyoOshiraseTsuchisho");
    private static final RString ORDER_BY = new RString("order by");
    private static final int パターン番号_2 = 2;
    private static final int パターン番号_3 = 3;
    private static final RString 総合事業高額サービス給付のお知らせ通知書 = new RString("総合事業高額サービス給付のお知らせ通知書");
    private static final RString 総合事業高額サービス給付のお知らせ通知書自動償還分 = new RString("総合事業高額サービス給付のお知らせ通知書（自動償還分）");

    private KogakuKaigoServicehiOshiraseHakkoProcessParameter parameter;

    private NinshoshaSource 認証者情報_通常分;
    private NinshoshaSource 認証者情報_償還分;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private Association 地方公共団体;
    private RString 通常分通知文1;
    private RString 通常分通知文2;
    private RString 償還分通知文1;
    private RString 償還分通知文2;
    private int count;

    private TsuchishoTeikeibunFinder find;

    @BatchWriter
    private BatchReportWriter<KogakuJigyoOshiraseTsuchishoKigenNashiSource> 通常分BatchReportWriter;
    private ReportSourceWriter<KogakuJigyoOshiraseTsuchishoKigenNashiSource> 通常分ReportSourceWriter;
    @BatchWriter
    private BatchReportWriter<KogakuJigyoOshiraseTsuchishoKigenNashiSource> 自動償還分BatchReportWriter;
    private ReportSourceWriter<KogakuJigyoOshiraseTsuchishoKigenNashiSource> 自動償還分ReportSourceWriter;

    @Override
    protected void initialize() {
        count = 1;
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();

        IOutputOrder 出力順 = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC200091.getReportId(), parameter.getShutsuryokujunId());
        if (出力順 != null) {
            parameter.setOrderBy(MyBatisOrderByClauseCreator.create(
                    KogakuJigyoShinseishoHakkoIchiranOrder.class, 出力順).replace(ORDER_BY, RString.EMPTY));
        }
        find = new TsuchishoTeikeibunFinder();
        通常分通知文1 = get定型文(帳票分類ＩＤ, 1, 1);
        通常分通知文2 = get定型文(帳票分類ＩＤ, 1, パターン番号_2);
        償還分通知文1 = get定型文(帳票分類ＩＤ, パターン番号_3, 1);
        通常分通知文2 = get定型文(帳票分類ＩＤ, パターン番号_3, パターン番号_2);

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, parameter.toMybatisParamter());
    }

    @Override
    protected void createWriter() {
        通常分BatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100073.getReportId().value()).create();
        通常分ReportSourceWriter = new ReportSourceWriter<>(通常分BatchReportWriter);

        自動償還分BatchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC100073.getReportId().value()).create();
        自動償還分ReportSourceWriter = new ReportSourceWriter<>(自動償還分BatchReportWriter);
    }

    @Override
    protected void beforeExecute() {
        認証者情報_通常分 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ＩＤ, FlexibleDate.getNowDate(),
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, 通常分ReportSourceWriter);
        認証者情報_償還分 = ReportUtil.get認証者情報(SubGyomuCode.DBC介護給付, 帳票分類ＩＤ, FlexibleDate.getNowDate(),
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, 自動償還分ReportSourceWriter);

        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, 帳票分類ＩＤ);
    }

    @Override
    protected void process(ShinseiJohoChohyoTempRelateEntity entity) {
        KogakuJigyoOshiraseTsuchishoKigenNashiEntity param = new KogakuJigyoOshiraseTsuchishoKigenNashiEntity();
        param.set申請情報帳票発行一時(entity.get申請情報());
        if (entity.get申請情報().isJidoShokanTaishoFlagChohyo()) {
            param.set自動償還(true);
            param.set通知文1(償還分通知文1);
            param.set通知文2(償還分通知文2);
            param.set連番(new RString(count));
            param.set認証者(認証者情報_償還分);
            param.set文書番号文字列(parameter.getBunshoMojiretsu());
            param.setタイトル(総合事業高額サービス給付のお知らせ通知書自動償還分);
            param.set送付別宛先(EditedAtesakiBuilder.create編集後宛先(AtesakiFactory.createInstance(entity.get宛先()), 地方公共団体,
                    帳票制御共通).getSofubutsuAtesakiSource().get送付物宛先ソース());
            KogakuJigyoOshiraseTsuchishoKigenNashiReport report = new KogakuJigyoOshiraseTsuchishoKigenNashiReport(param);
            report.writeBy(自動償還分ReportSourceWriter);
        } else {
            param.set自動償還(false);
            param.set通知文1(通常分通知文1);
            param.set通知文2(通常分通知文2);
            param.set連番(new RString(count));
            param.set認証者(認証者情報_通常分);
            param.setタイトル(総合事業高額サービス給付のお知らせ通知書);
            param.set文書番号文字列(parameter.getBunshoMojiretsu());
            param.set送付別宛先(EditedAtesakiBuilder.create編集後宛先(AtesakiFactory.createInstance(entity.get宛先()), 地方公共団体,
                    帳票制御共通).getSofubutsuAtesakiSource().get送付物宛先ソース());
            KogakuJigyoOshiraseTsuchishoKigenNashiReport report = new KogakuJigyoOshiraseTsuchishoKigenNashiReport(param);
            report.writeBy(通常分ReportSourceWriter);
        }
    }

    private RString get定型文(ReportId reportId, int パターン番号, int 項目番号) {
        TsuchishoTeikeibun teikeibun = find.get通知書定型文_最新適用開始日(SubGyomuCode.DBC介護給付,
                reportId, KamokuCode.EMPTY, パターン番号, 項目番号);
        return teikeibun == null ? RString.EMPTY : teikeibun.get文章();
    }
}
