/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD206010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd206010.TyohyoShutuyukuOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200017.JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranReport;
import jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist.JigyoshaSentaku;
import jp.co.ndensan.reams.db.dbd.definition.core.shafugemmentaisyousyalist.ShikakuSoshitsushaSentaku;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd206010.DBD206010TyohyoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd206010.ShafukugemmenTaishoshaJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200017.JigyoshoMukeShakaiFukushiHojinKeigenReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 事業所向け社会福祉法人軽減対象者一覧発行のprocessクラスです。
 *
 * @reamsid_L DBD-3810-030 liuwei2
 */
public class TyohyoShutuyukuProcess extends BatchKeyBreakBase<ShafukugemmenTaishoshaJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.jigyoshomukeshakai.IShafukugemmenTaishoshaJohoMapper.get社福減免対象者情報");
    private DBD206010TyohyoProcessParameter processParameter;
    private static Association association;
    private IOutputOrder outputOrder;
    private static final int NUM5 = 5;
    private static final int NUM8 = 8;
    private int 番号;
    private static final ReportId REPORT_DBD200017 = ReportIdDBD.DBD200017.getReportId();
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private RString orderBy = null;

    @BatchWriter
    private BatchReportWriter<JigyoshoMukeShakaiFukushiHojinKeigenReportSource> batchReportWriter;
    private ReportSourceWriter<JigyoshoMukeShakaiFukushiHojinKeigenReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        IChohyoShutsuryokujunFinder chohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
        long 帳票出力順ID = processParameter.get出力順ID();
        outputOrder = chohyoShutsuryokujunFinder.get出力順(
                SubGyomuCode.DBD介護受給, ReportIdDBD.DBD200017.getReportId(), 帳票出力順ID);

        if (null != outputOrder) {
            if (processParameter.get出力順ID() != null) {
                orderBy = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(TyohyoShutuyukuOrderKey.class,
                        outputOrder).replace("order by", ","), NUM5);
            } else {
                orderBy = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(TyohyoShutuyukuOrderKey.class,
                        outputOrder).substring(NUM8), NUM5);
            }
        }
        番号 = 1;
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder build
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別List = new ArrayList<>();
        List<JuminJotai> 住民状態List = new ArrayList<>();
        build.setデータ取得区分(DataShutokuKubun.直近レコード);
        build.set住民種別(get住民種別(住民種別List));
        build.set住民状態(get住民状態(住民状態List));
        build.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        IShikibetsuTaishoPSMSearchKey key = build.build();
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toDBD206010TyohyoMybatisParameter(key, orderBy));
    }

    @Override
    protected void createWriter() {
        List<RString> pageBreakKeys = new ArrayList<>();
        set改頁Key(outputOrder, pageBreakKeys);
        if (!pageBreakKeys.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD200017.value())
                    .addBreak(new TyohyoShutuyukuSourcePageBreak(pageBreakKeys)).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD200017.value(), SubGyomuCode.DBD介護受給).create();
        }
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(ShafukugemmenTaishoshaJohoEntity t) {
    }

    @Override
    protected void usualProcess(ShafukugemmenTaishoshaJohoEntity t) {
        outputMessage(t);
    }

    private void outputMessage(ShafukugemmenTaishoshaJohoEntity t) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation(
                new LasdecCode(t.get証記載保険者番号().value()));
        JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranReport report
                = new JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranReport(t, association, 地方公共団体, outputOrder, 番号++);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        if (番号 == 1) {
            JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranReport report
                    = new JigyoshoMukeShakaiFukushiHojinKeigenTaishoshoIchiranReport(null, association, null, outputOrder, 番号++);
            report.writeBy(reportSourceWriter);
        }
        outputJokenhyoFactory();
    }

    private void set改頁Key(IOutputOrder outputOrder, List<RString> pageBreakKeys) {
        RString 改頁１ = RString.EMPTY;
        RString 改頁２ = RString.EMPTY;
        RString 改頁３ = RString.EMPTY;
        RString 改頁４ = RString.EMPTY;
        RString 改頁５ = RString.EMPTY;
        if (outputOrder != null) {
            List<ISetSortItem> list = outputOrder.get設定項目リスト();
            if (list == null) {
                list = new ArrayList<>();
            }
            if (list.size() > NO_0 && list.get(NO_0).is改頁項目()) {
                改頁１ = to帳票物理名(list.get(0).get項目ID());
            }
            if (list.size() > NO_1 && list.get(NO_1).is改頁項目()) {
                改頁２ = to帳票物理名(list.get(NO_1).get項目ID());
            }
            if (list.size() > NO_2 && list.get(NO_2).is改頁項目()) {
                改頁３ = to帳票物理名(list.get(NO_2).get項目ID());
            }
            if (list.size() > NO_3 && list.get(NO_3).is改頁項目()) {
                改頁４ = to帳票物理名(list.get(NO_3).get項目ID());
            }
            if (list.size() > NO_4 && list.get(NO_4).is改頁項目()) {
                改頁５ = to帳票物理名(list.get(NO_4).get項目ID());
            }

            if (!改頁１.isEmpty()) {
                pageBreakKeys.add(改頁１);
            }
            if (!改頁２.isEmpty()) {
                pageBreakKeys.add(改頁２);
            }
            if (!改頁３.isEmpty()) {
                pageBreakKeys.add(改頁３);
            }
            if (!改頁４.isEmpty()) {
                pageBreakKeys.add(改頁４);
            }
            if (!改頁５.isEmpty()) {
                pageBreakKeys.add(改頁５);
            }
        }
    }

    private RString to帳票物理名(RString 項目ID) {

        RString 帳票物理名 = RString.EMPTY;

        if (TyohyoShutuyukuOrderKey.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("yubinNo");
        } else if (TyohyoShutuyukuOrderKey.証記載保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("hokenshaNo");
        } else if (TyohyoShutuyukuOrderKey.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("listMeisai_2");
        }
        return 帳票物理名;
    }

    private void outputJokenhyoFactory() {
        RString ページ数 = new RString(reportSourceWriter.pageCount().value());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                new RString("DBD200005"),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("「事業者向け社福減免対象者一覧表」"),
                ページ数,
                new RString("なし"),
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(new RString("【抽出対象者】"));
        出力条件.add(new RString("基 準 日：").concat(processParameter.get基準日().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()));

        if (ShikakuSoshitsushaSentaku.出力する.getコード().equals(processParameter.get資格喪失者選択())) {
            出力条件.add(new RString("資格喪失者：出力する"));
        }
        if (!ShikakuSoshitsushaSentaku.出力する.getコード().equals(processParameter.get資格喪失者選択())) {
            出力条件.add(new RString("資格喪失者：出力しない"));
        }
        if (JigyoshaSentaku.計画事業者.getコード().equals(processParameter.get事業者選択())) {
            出力条件.add(new RString("事業者選択：計画事業者"));
        }
        if (JigyoshaSentaku.サービス事業者.getコード().equals(processParameter.get事業者選択())) {
            出力条件.add(new RString("事業者選択：サービス事業者"));
        }
        if (JigyoshaSentaku.計画事業者とサービス事業者.getコード().equals(processParameter.get事業者選択())) {
            出力条件.add(new RString("事業者選択：計画事業者＋サービス事業者"));
        }
        if (processParameter.get事業者番号() != null && !processParameter.get事業者番号().isEmpty()) {
            出力条件.add(new RString("事業者：").concat(processParameter.get事業者番号()).concat(processParameter.get事業者名()));
        }

        return 出力条件;
    }

    private List<JuminShubetsu> get住民種別(List<JuminShubetsu> 住民種別List) {
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民種別List.add(JuminShubetsu.住登外個人_日本人);
        住民種別List.add(JuminShubetsu.住登外個人_外国人);
        return 住民種別List;
    }

    private List<JuminJotai> get住民状態(List<JuminJotai> 住民状態List) {
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        return 住民状態List;
    }

}
