/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hakkoichiranhyo.HomonChosaIraishoMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IHomonChosaIraishoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
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
public class IchiranhyoReportProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final RString 帳票ID = ReportIdDBE.DBE220002.getReportId().value();
    private static final RString CONFIGVALUE = new RString("1");
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private ChosaIraiIchiranhyoHeadItem ichiranhyoHeadItem;
    private List<ChosaIraiIchiranhyoBodyItem> ichiranhyoBodyItemList;
    private HomonChosaIraishoProcessParamter processParamter;
    private HomonChosaIraishoMybitisParamter mybatisParamter;
    private DbT5201NinteichosaIraiJohoEntity dbT5201Entity;
    private RString 訪問調査先住所;
    private RString 訪問調査先名称;
    private RString 事業者番号;
    private RString 郵便番号;

    @BatchWriter
    private BatchReportWriter<ChosaIraiIchiranhyoReportSource> ichiranhyoBatchReportWriter;
    private ReportSourceWriter<ChosaIraiIchiranhyoReportSource> ichiranhyoReportSourceWriter;

    @Override
    protected void initialize() {
        iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
        mybatisParamter = processParamter.toHomonChosaIraishoMybitisParamter();
        ichiranhyoBodyItemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParamter);
    }

    @Override
    protected void createWriter() {
        ichiranhyoBatchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID).create();
        ichiranhyoReportSourceWriter = new ReportSourceWriter<>(ichiranhyoBatchReportWriter);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
        // 内部QA：614　Redmine：＃75422　排他制限の確認
        訪問調査先住所 = entity.get訪問調査先住所();
        訪問調査先名称 = entity.get訪問調査先名称();
        事業者番号 = entity.get事業者番号();
        郵便番号 = entity.get訪問調査先住所_郵便番号();
        update認定調査依頼情報(entity);
        ichiranhyoBodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        NinshoshaSource ninshoshaSource = set出力項目();
        //TODO 内部QA:571　Redmine：#74964　通知文取得方式の確認
        ichiranhyoHeadItem = new ChosaIraiIchiranhyoHeadItem(RDateTime.now(),
                ninshoshaSource.hakkoYMD,
                郵便番号,
                ninshoshaSource.ninshoshaShimeiKakeru,
                訪問調査先住所,
                ninshoshaSource.koinShoryaku,
                ninshoshaSource.denshiKoin,
                訪問調査先名称,
                事業者番号,
                new RString("通知文"));
        ChosaIraiIchiranhyoReport report = ChosaIraiIchiranhyoReport.createFrom(ichiranhyoHeadItem, ichiranhyoBodyItemList);
        report.writeBy(ichiranhyoReportSourceWriter);
    }

    private ChosaIraiIchiranhyoBodyItem setBodyItem(HomonChosaIraishoRelateEntity entity) {
        int i = 0;
        RString 提出期限 = RString.EMPTY;
        if (entity.get要介護認定調査表提出期限() != null) {
            提出期限 = new RString(entity.get要介護認定調査表提出期限().toString());
        }
        return new ChosaIraiIchiranhyoBodyItem(
                RString.EMPTY,
                entity.get調査員名(),
                entity.get被保険者番号(),
                entity.get要介護認定_更新申請日(),
                entity.get申請区分コード(),
                entity.get被保険者氏名(),
                entity.get被保険者氏名カナ(),
                Seibetsu.toValue(entity.get性別コード()).get名称(),
                entity.get生年月日(),
                entity.get被保険者住所(),
                entity.get被保険者電話番号(),
                提出期限);
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
}
