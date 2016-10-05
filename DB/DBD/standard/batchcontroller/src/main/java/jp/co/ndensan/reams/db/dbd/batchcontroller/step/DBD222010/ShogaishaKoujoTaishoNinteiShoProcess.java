/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD222010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100025.ShogaishaKojoNinteishoProperty;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100025.ShogaishaKojoNinteishoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd4030011.ShogaishakojoTaishoshaListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd4030011.NinteishoJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd100025.NinteishoJohoReportSource;
import jp.co.ndensan.reams.db.dbd.service.core.basic.shogaishakoujo.ShogaishaKoujoService;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu.TeikeibunMojiSize;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.AtesakiFactory;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNoHatsubanHoho;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.entity.db.relate.tsuchishoteikeibun.TsuchishoTeikeibunEntity;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.CountedItem;
import jp.co.ndensan.reams.uz.uza.util.Saiban;

/**
 * 障がい者控除対象者認定書リスト作成帳票出力です。
 *
 * @reamsid_L DBD-3860-030 donghj
 */
public class ShogaishaKoujoTaishoNinteiShoProcess extends BatchProcessBase<NinteishoJohoEntity> {

    private static final ReportId REPORT_DBD100025 = ReportIdDBD.DBD100025.getReportId();
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shogaishakoujotaishoninteisho."
                    + "IShogaishaKoujoTaishoNinteiShoMapper.控除対象者データの取得");
    private ShogaishakojoTaishoshaListProcessParameter parameter;
    private static Association 地方公共団体;
    private static DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private static final RString GENERICKEY = new RString("障がい者控除対象者認定書");
    private static final ReportId 帳票ID = new ReportId("DBD100025_ShogaishaKojoNinteisho");
    private static final ReportId 帳票分類ID = new ReportId("DBD100025_ShogaishaKojoNinteisho");
    private static final int ONE_1 = 1;
    private static final int TWO_2 = 2;
    private static final int THREE_3 = 3;
    private static final int FOUR_4 = 4;
    private static List<RString> 通知書定型文;
    private static IOutputOrder order;
    private static int count;
    private static final int NUM5 = 5;
    private static final RString なし = new RString("なし");
    private static final RString カラ = new RString("～");
    private static final RString より = new RString("＞");
    private static final RString 対象年度 = new RString("【対象年度】");
    private static final RString 被保険者番号 = new RString("【被保険者番号】");
    private static final RString 氏名 = new RString("【氏名】");
    private static final RString 認定区分 = new RString("【認定区分】");
    private static final RString 認定内容 = new RString("【認定内容】");
    private static final RString 認知症高齢者の日常生活自立度 = new RString("【認知症高齢者の日常生活自立度】");
    private static final RString 障害高齢者の日常生活自立度 = new RString("【障害高齢者の日常生活自立度】");
    private static final RString 障がい者手帳 = new RString("【障がい者手帳】");
    private static final RString 喪失事由 = new RString("【喪失事由】");
    private static final RString 喪失日期間 = new RString("【喪失日期間】");
    private static final RString 決定日期間 = new RString("【決定日期間】");
    private static final RString 交付日 = new RString("【発行日】");
    private static final RString 出力順漢字 = new RString("【出力順】");
    private ShikibetsuTaishoPSMSearchKeyBuilder key;
    private IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey;

    @BatchWriter
    private BatchReportWriter<NinteishoJohoReportSource> batchReportWrite;
    private ReportSourceWriter<NinteishoJohoReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票分類ID);
        int パターン番号 = 0;
        if (TeikeibunMojiSize.フォント小.getコード().equals(帳票制御共通.getTeikeibunMojiSize())) {
            パターン番号 = ONE_1;
        } else if (TeikeibunMojiSize.フォント大.getコード().equals(帳票制御共通.getTeikeibunMojiSize())) {
            パターン番号 = TWO_2;
        } else if (TeikeibunMojiSize.フォント上小下大.getコード().equals(帳票制御共通.getTeikeibunMojiSize())) {
            パターン番号 = THREE_3;
        } else if (TeikeibunMojiSize.フォント上大下小.getコード().equals(帳票制御共通.getTeikeibunMojiSize())) {
            パターン番号 = FOUR_4;
        }
        通知書定型文 = new ArrayList();
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = manager.get通知書定型文項目(SubGyomuCode.DBD介護受給, 帳票ID, KamokuCode.EMPTY, パターン番号);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBD介護受給, 帳票ID);
        List<TsuchishoTeikeibunEntity> 通知書定型文List = tsuchishoTeikeibunInfo.get通知書定型文List();
        for (TsuchishoTeikeibunEntity entity : 通知書定型文List) {
            int 項目番号 = entity.getTsuchishoTeikeibunEntity().getSentenceNo();
            RString 文章 = textHenkanRule.editText(entity.getTsuchishoTeikeibunEntity().getSentence());
            通知書定型文.add(項目番号, textHenkanRule.editText(文章));
        }
        key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.未定義);
        shikibetsuTaishoPSMSearchKey = key.build();
        ShogaishaKoujoService service = ShogaishaKoujoService.createInstance();
        count = service.get障がい者控除対象者認定書(parameter.toShogaishaKojoTaishoshaListMyBatisParameter(
                get出力順(), shikibetsuTaishoPSMSearchKey));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShogaishaKojoTaishoshaListMyBatisParameter(
                get出力順(), shikibetsuTaishoPSMSearchKey));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBD100025.value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(NinteishoJohoEntity target) {
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100025.getReportId(),
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        IKojin ikojin = ShikibetsuTaishoFactory.createKojin(target.getPsmEntity());
        IAtesaki iAtesaki = AtesakiFactory.createInstance(target.getAtesakiEntity());
        target.set発行日(parameter.get交付日());
        target.set対象年度(parameter.get対象年度());
        ShogaishaKojoNinteishoReport report = new ShogaishaKojoNinteishoReport(target, ikojin, iAtesaki, new ChohyoSeigyoKyotsu(帳票制御共通),
                地方公共団体, set文書番号(), 通知書定型文, ninshoshaSource);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();

    }

    private RString set文書番号() {
        RString 文書番号 = RString.EMPTY;
        IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
        BunshoNo bushoNo = finder.get文書番号管理(帳票ID, new FlexibleDate(parameter.get交付日().toDateString()));
        if (bushoNo != null) {
            RString 文書番号発番方法 = bushoNo.get文書番号発番方法();
            if (BunshoNoHatsubanHoho.固定.getCode().equals(文書番号発番方法)) {
                文書番号 = bushoNo.edit文書番号();
            } else if (BunshoNoHatsubanHoho.手入力.getCode().equals(文書番号発番方法)) {
                throw new ApplicationException(UrErrorMessages.実行不可.getMessage().replace("文書番号情報の取得"));
            } else if (BunshoNoHatsubanHoho.自動採番.getCode().equals(文書番号発番方法)) {
                CountedItem 採番 = Saiban.get(SubGyomuCode.DBD介護受給, GENERICKEY, new FlexibleYear(RDate.getNowDate().getYear().toDateString()), count);
                文書番号 = bushoNo.edit文書番号(採番.nextString());
                RString 文書番号記号 = bushoNo.get文書番号記号();
                文書番号 = 文書番号記号.concat(文書番号);
            }
        }
        return 文書番号;
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        order = finder.get出力順(SubGyomuCode.DBD介護受給, 帳票ID, Long.parseLong(parameter.get出力順().toString()));
        RString 出力順 = RString.EMPTY;
        if (order != null) {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.
                    create(ShogaishaKojoNinteishoProperty.DBD100025ShutsuryokujunEnum.class, order), NUM5);
        }
        return 出力順;
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().getColumnValue();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = ReportIdDBD.DBD100025.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        RString csv出力有無 = なし;
        RString csvファイル名 = なし;
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(対象年度);
        builder.append(parameter.get対象年度().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.ICHI_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        出力条件.add(builder.toRString());
        builder.append(被保険者番号);
        builder.append(parameter.get被保険者番号());
        出力条件.add(builder.toRString());
        builder.append(氏名);
        builder.append(parameter.get氏名());
        出力条件.add(builder.toRString());
        builder.append(認定区分);
        builder.append(parameter.get認定区分());
        出力条件.add(builder.toRString());
        builder.append(認定内容);
        builder.append(parameter.get認定内容());
        出力条件.add(builder.toRString());
        builder.append(認知症高齢者の日常生活自立度);
        builder.append(parameter.get認知症高齢者の日常生活自立度());
        出力条件.add(builder.toRString());
        builder.append(障害高齢者の日常生活自立度);
        builder.append(parameter.get障害高齢者の日常生活自立度());
        出力条件.add(builder.toRString());
        builder.append(障がい者手帳);
        builder.append(parameter.get障がい者手帳());
        出力条件.add(builder.toRString());
        builder.append(喪失事由);
        builder.append(parameter.get喪失事由());
        出力条件.add(builder.toRString());
        builder.append(喪失日期間);
        if (null != parameter.get喪失日FROM()) {
            builder.append(parameter.get喪失日FROM().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        builder.append(カラ);
        if (null != parameter.get喪失日TO()) {
            builder.append(parameter.get喪失日TO().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        出力条件.add(builder.toRString());
        builder.append(決定日期間);
        if (null != parameter.get決定日FROM()) {
            builder.append(parameter.get決定日FROM().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        builder.append(カラ);
        if (null != parameter.get決定日TO()) {
            builder.append(parameter.get決定日TO().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        出力条件.add(builder.toRString());
        builder.append(交付日);
        if (null != parameter.get交付日()) {
            builder.append(parameter.get交付日().wareki().eraType(EraType.KANJI).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        }
        出力条件.add(builder.toRString());
        RString 設定項目 = RString.EMPTY;
        if (order != null) {
            for (ISetSortItem item : order.get設定項目リスト()) {
                設定項目 = 設定項目.concat(より).concat(item.get項目名());
            }
        }
        if (!設定項目.isEmpty()) {
            設定項目 = 設定項目.substringEmptyOnError(1, 設定項目.length() - 1);
        }
        出力条件.add(出力順漢字.concat(設定項目));
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }
}
