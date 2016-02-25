/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho;

import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaisho.ChosaIraishoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.HomonChosaIraishoMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaisho.ChosaIraishoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IHomonChosaIraishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 訪問調査依頼書発行_バッチフ処理クラスです
 */
public class IraishoReportProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final RString 帳票ID = ReportIdDBE.DBE220001.getReportId().value();
    private static final RString CONFIGVALUE = new RString("1");
    private static final RString 年号_明治 = new RString("明");
    private static final RString 年号_大正 = new RString("大");
    private static final RString 年号_昭和 = new RString("昭");
    private static final RString 記号_星 = new RString("*");
    private static final int HIHOKENSHANOLENGTH = 10;
    private static final int 数字_3 = 3;
    private static final int 数字_4 = 4;
    private static final int 数字_5 = 5;
    private static final int 数字_6 = 6;
    private static final int 数字_7 = 7;
    private static final int 数字_8 = 8;
    private static final int 数字_9 = 9;
    private static final int 数字_10 = 10;
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private static RString 被保険者番号1 = RString.EMPTY;
    private static RString 被保険者番号2 = RString.EMPTY;
    private static RString 被保険者番号3 = RString.EMPTY;
    private static RString 被保険者番号4 = RString.EMPTY;
    private static RString 被保険者番号5 = RString.EMPTY;
    private static RString 被保険者番号6 = RString.EMPTY;
    private static RString 被保険者番号7 = RString.EMPTY;
    private static RString 被保険者番号8 = RString.EMPTY;
    private static RString 被保険者番号9 = RString.EMPTY;
    private static RString 被保険者番号10 = RString.EMPTY;
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private ChosaIraishoHeadItem chosaIraishoHeadItem;
    private HomonChosaIraishoProcessParamter processParamter;
    private HomonChosaIraishoMybitisParamter mybatisParamter;
    private DbT5201NinteichosaIraiJohoEntity dbT5201Entity;
    private RString 誕生日明治;
    private RString 誕生日大正;
    private RString 誕生日昭和;
    private RString 性別_男;
    private RString 性別_女;
    @BatchWriter
    private BatchReportWriter<ChosaIraishoReportSource> iraishoBatchReportWriter;
    private ReportSourceWriter<ChosaIraishoReportSource> iraishoReportSourceWriter;

    @Override
    protected void initialize() {
        iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
        mybatisParamter = processParamter.toHomonChosaIraishoMybitisParamter();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParamter);
    }

    @Override
    protected void createWriter() {
        iraishoBatchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID).create();
        iraishoReportSourceWriter = new ReportSourceWriter<>(iraishoBatchReportWriter);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        // 内部QA：614　Redmine：＃75422　排他制限の確認
        update認定調査依頼情報(entity);
        chosaIraishoHeadItem = setChosaIraishoHeadItem(entity);
    }

    @Override
    protected void afterExecute() {
        if (chosaIraishoHeadItem != null) {
            ChosaIraishoReport report = ChosaIraishoReport.createFrom(chosaIraishoHeadItem);
            report.writeBy(iraishoReportSourceWriter);
        }
    }

    private ChosaIraishoHeadItem setChosaIraishoHeadItem(HomonChosaIraishoRelateEntity entity) {
        NinshoshaSource ninshoshaSource = set出力項目();
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        if (entity.get生年月日() != null && !entity.get生年月日().isEmpty()) {
            get年号(new FlexibleDate(entity.get生年月日()));
        }
        get性別(entity.get性別コード());
        get被保険者番号(entity);
        int i = 1;
        return new ChosaIraishoHeadItem(ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                association.get市町村名(),
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.koinShoryaku,
                //TODO 内部QA:571　Redmine：#74964　文書番号取得方式の確認
                new RString("文書番号"),
                RDate.getNowDate().toDateString(),
                被保険者番号1,
                被保険者番号2,
                被保険者番号3,
                被保険者番号4,
                被保険者番号5,
                被保険者番号6,
                被保険者番号7,
                被保険者番号8,
                被保険者番号9,
                被保険者番号10,
                entity.get被保険者氏名カナ(),
                誕生日明治,
                誕生日大正,
                誕生日昭和,
                entity.get生年月日(),
                entity.get被保険者氏名(),
                性別_男,
                性別_女,
                entity.get被保険者住所_郵便番号() != null ? new YubinNo(entity.get被保険者住所_郵便番号()).getEditedYubinNo()
                : RString.EMPTY,
                entity.get被保険者住所(),
                entity.get被保険者電話番号(),
                entity.get訪問調査先住所_郵便番号() != null ? new YubinNo(entity.get訪問調査先住所_郵便番号()).getEditedYubinNo()
                : RString.EMPTY,
                entity.get訪問調査先住所(),
                RString.EMPTY,
                entity.get訪問調査先名称(),
                entity.get訪問調査先電話番号(),
                entity.get要介護認定_更新申請日(),
                entity.get要介護認定調査表提出期限() != null ? new RString(entity.get要介護認定調査表提出期限().toString())
                : RString.EMPTY,
                //TODO 内部QA:571　Redmine：#74964　通知文取得方式の確認
                new RString("通知文1"),
                new RString("通知文2"),
                new RString("通知文3"),
                new RString("通知文4"),
                new RString("通知文5"),
                new RString("通知文6"),
                new RString("通知文7"),
                new RString("通知文8"),
                new RString("通知文9"),
                new RString("通知文10"),
                new RString("通知文11"),
                new RString("通知文12"),
                new RString("通知文13"),
                new RString("通知文14"),
                new RString("通知文15"),
                new RString("通知文16"),
                new RString("通知文17"),
                new RString("通知文18"),
                new RString("通知文19"),
                RString.EMPTY);
    }

    private void get性別(RString 性別コード) {
        if (性別コード.equals(Seibetsu.男.getコード())) {
            性別_男 = Seibetsu.男.get名称();
            性別_女 = 記号_星;
        } else if (性別コード.equals(Seibetsu.女.getコード())) {
            性別_男 = 記号_星;
            性別_女 = Seibetsu.女.get名称();
        }
    }

    private void get被保険者番号(HomonChosaIraishoRelateEntity entity) {
        RString 被保険者番号 = entity.get被保険者番号();
        if (被保険者番号 != null && HIHOKENSHANOLENGTH <= 被保険者番号.length()) {
            被保険者番号1 = 被保険者番号.substring(0, 1);
            被保険者番号2 = 被保険者番号.substring(1, 2);
            被保険者番号3 = 被保険者番号.substring(2, 数字_3);
            被保険者番号4 = 被保険者番号.substring(数字_3, 数字_4);
            被保険者番号5 = 被保険者番号.substring(数字_4, 数字_5);
            被保険者番号6 = 被保険者番号.substring(数字_5, 数字_6);
            被保険者番号7 = 被保険者番号.substring(数字_6, 数字_7);
            被保険者番号8 = 被保険者番号.substring(数字_7, 数字_8);
            被保険者番号9 = 被保険者番号.substring(数字_8, 数字_9);
            被保険者番号10 = 被保険者番号.substring(数字_9, 数字_10);
        }
    }

    private void get年号(FlexibleDate 生年月日) {
        RString 年号 = 生年月日.wareki().toDateString();
        if (年号.startsWith(年号_明治)) {
            誕生日明治 = 年号_明治;
            誕生日大正 = 記号_星;
            誕生日昭和 = 記号_星;
        } else if (年号.startsWith(年号_大正)) {
            誕生日明治 = 記号_星;
            誕生日大正 = 年号_大正;
            誕生日昭和 = 記号_星;
        } else if (年号.startsWith(年号_昭和)) {
            誕生日明治 = 記号_星;
            誕生日大正 = 記号_星;
            誕生日昭和 = 年号_昭和;
        } else {
            誕生日明治 = 記号_星;
            誕生日大正 = 記号_星;
            誕生日昭和 = 記号_星;
        }
    }

    private void update認定調査依頼情報(HomonChosaIraishoRelateEntity entity) {
        dbT5201Entity = new DbT5201NinteichosaIraiJohoEntity();
        RString 認定調査期限設定方法 = BusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, SubGyomuCode.DBE認定支援);
        if (CONFIGVALUE.equals(認定調査期限設定方法)) {
            switch (processParamter.getTeishutsuKigen().toString()) {
                case "0":
                    int 期限日数 = Integer.parseInt(BusinessConfig.get(ConfigNameDBE.認定調査作成期限日数,
                            SubGyomuCode.DBE認定支援).toString());
                    FlexibleDate 認定調査依頼日 = entity.get認定調査依頼年月日();
                    if (認定調査依頼日 != null && !認定調査依頼日.isEmpty()) {
                        entity.set要介護認定調査表提出期限(認定調査依頼日.plusDay(期限日数));
                    }
                    break;
                case "1":
                    entity.set要介護認定調査表提出期限(FlexibleDate.EMPTY);
                    break;
                case "2":
                    if (RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
                        entity.set要介護認定調査表提出期限(new FlexibleDate(processParamter.getKyotsuHizuke()));
                    }
                    break;
                default:
                    break;
            }
        }
        dbT5201Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
        dbT5201Entity.setNinteichosaIraiRirekiNo(entity.get最大依頼履歴番号());
        dbT5201Entity.setLogicalDeletedFlag(false);
        dbT5201Entity.setIraishoShutsuryokuYMD(new FlexibleDate(processParamter.getHakkobi()));
        dbT5201Entity.setNinteichosaKigenYMD(entity.get要介護認定調査表提出期限());
        iHomonChosaIraishoMapper.update認定調査依頼情報(dbT5201Entity);
    }

    private NinshoshaSource set出力項目() {
        ChosaIraiIchiranhyoProperty property = new ChosaIraiIchiranhyoProperty();
        try (ReportManager reportManager = new ReportManager()) {
            try (ReportAssembler<ChosaIraiIchiranhyoReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator ninshoshaSourceBuilderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                INinshoshaSourceBuilder ninshoshaSourceBuilder = ninshoshaSourceBuilderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        RDate.getNowDate(), assembler.getImageFolderPath());
                return ninshoshaSourceBuilder.buildSource();
            }
        }
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T> createAssembler(
            IReportProperty<T> property, ReportManager manager) {
        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaker : property.breakers()) {
            builder.addBreak(breaker);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

// TODO 内部QA：714　Redmine：#76765 出力条件表の実装方式
//    private void set出力条件表() {
//        List 出力条件 = new ArrayList();
//        出力条件.add(processParamter.getIraiFromYMD());
//        出力条件.add(processParamter.getIraiToYMD());
//        出力条件.add(processParamter.getHihokenshaNo());
//        出力条件.add(processParamter.getNinteiChosaIraisyo());
//        出力条件.add(processParamter.getNinteiChosahyo());
//        出力条件.add(processParamter.getNinteiChosaItakusakiCodeList());
//        出力条件.add(processParamter.getNinteiChosainNoList());
//        出力条件.add(processParamter.getHakkobi());
//        出力条件.add(processParamter.getTeishutsuKigen());
//        出力条件.add(processParamter.getKyotsuHizuke());
//        出力条件.add(processParamter.getNinteioChosaIraiIchiranhyo());
//        出力条件.add(processParamter.getNinteiChosaIrai());
//        Association association = AssociationFinderFactory.createInstance().getAssociation();
//        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
//                = new ReportOutputJokenhyoItem(
//                        帳票ID,
//                        association.getLasdecCode_().getColumnValue(),
//                        association.get市町村名(),
//                        new RString("【ジョブ番号】").concat(String.valueOf(JobContextHolder.getJobId())),
//                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, 帳票ID),
//                        RString.EMPTY,
//                        CSV出力有無,
//                        CSVファイル名,
//                        出力条件);
//        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
//    }
}
