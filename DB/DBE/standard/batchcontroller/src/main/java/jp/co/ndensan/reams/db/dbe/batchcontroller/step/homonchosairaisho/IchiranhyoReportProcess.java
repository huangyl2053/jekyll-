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
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.teikeibunhenkan.KaigoTextHenkanRuleCreator;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.ninshosha.Ninshosha;
import jp.co.ndensan.reams.ur.urz.business.core.teikeibunhenkan.ITextHenkanRule;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.NinshoshaSourceBuilderFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.INinshoshaManager;
import jp.co.ndensan.reams.ur.urz.service.core.ninshosha.NinshoshaFinderFactory;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.api.ReportInfo;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCode;
import jp.co.ndensan.reams.uz.uza.report.util.barcode.CustomerBarCodeResult;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 *
 * 訪問調査依頼書発行_バッチフ処理クラスです
 */
public class IchiranhyoReportProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final ReportId 帳票ID = ReportIdDBE.DBE220002.getReportId();
    private static final RString CONFIGVALUE = new RString("1");
    private static RString 通知文1 = RString.EMPTY;
    private static RString 通知文2 = RString.EMPTY;
    private static final RString CSV出力有無 = new RString("なし");
    private static final RString CSVファイル名 = new RString("-");
    private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private ChosaIraiIchiranhyoHeadItem ichiranhyoHeadItem;
    private List<ChosaIraiIchiranhyoBodyItem> ichiranhyoBodyItemList;
    private HomonChosaIraishoProcessParamter processParamter;
    private HomonChosaIraishoMybitisParamter mybatisParamter;
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
        get通知書定型文();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParamter);
    }

    @Override
    protected void createWriter() {
        ichiranhyoBatchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
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
        getカスタマーバーコード(entity);
        ichiranhyoBodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        set出力条件表();
        NinshoshaSource ninshoshaSource = get認証者();
        //TODO 内部QA:571　Redmine：#74964　通知文取得方式の確認
        ichiranhyoHeadItem = new ChosaIraiIchiranhyoHeadItem(ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.koinShoryaku,
                郵便番号,
                訪問調査先住所,
                RString.EMPTY,
                RString.EMPTY,
                訪問調査先名称,
                事業者番号,
                通知文1,
                通知文2);
        ChosaIraiIchiranhyoReport report = ChosaIraiIchiranhyoReport.createFrom(ichiranhyoHeadItem, ichiranhyoBodyItemList);
        report.writeBy(ichiranhyoReportSourceWriter);
    }

    private ChosaIraiIchiranhyoBodyItem setBodyItem(HomonChosaIraishoRelateEntity entity) {
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
        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = new DbT5201NinteichosaIraiJohoEntity();
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

    private RString getカスタマーバーコード(HomonChosaIraishoRelateEntity entity) {
        RString カスタマーバーコード = RString.EMPTY;
        CustomerBarCode barCode = new CustomerBarCode();
        RString 被保険者郵便番号 = entity.get被保険者住所_郵便番号();
        RString 住所 = entity.get被保険者住所();
        if (RString.isNullOrEmpty(被保険者郵便番号) && RString.isNullOrEmpty(住所)) {
            CustomerBarCodeResult result = barCode.convertCustomerBarCode(被保険者郵便番号, 住所);
            if (result != null) {
                カスタマーバーコード = result.getCustomerBarCode();
            }
        }
        return カスタマーバーコード;
    }

    private NinshoshaSource get認証者() {
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        Association association = finder.getAssociation();
        INinshoshaManager iNinshoshaManager = NinshoshaFinderFactory.createInstance();
        Ninshosha ninshosha = iNinshoshaManager.get帳票認証者(GyomuCode.DB介護保険,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                new FlexibleDate(processParamter.getHakkobi()));
        INinshoshaSourceBuilder iNinshoshaSourceBuilder = NinshoshaSourceBuilderFactory.createInstance(ninshosha,
                association,
                ichiranhyoReportSourceWriter.getImageFolderPath(),
                new RDate(processParamter.getHakkobi().toString()), true, true, KenmeiFuyoKubunType.付与なし);
        return iNinshoshaSourceBuilder.buildSource();
    }

    private void get通知書定型文() {
        TsuchishoTeikeibunManager tsuchishoTeikeibunManager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo tsuchishoTeikeibunInfo = tsuchishoTeikeibunManager.get通知書定型文項目(SubGyomuCode.DBE認定支援,
                帳票ID, KamokuCode.EMPTY, 1);
        ITextHenkanRule textHenkanRule = KaigoTextHenkanRuleCreator.createRule(SubGyomuCode.DBE認定支援, 帳票ID);
        List<TsuchishoTeikeibunEntity> tsuchishoTeikeibunList = tsuchishoTeikeibunInfo.get通知書定型文List();
        int 項目番号;
        for (TsuchishoTeikeibunEntity tsuchishoTeikeibun : tsuchishoTeikeibunList) {
            項目番号 = tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentenceNo();
            if (項目番号 == 1) {
                通知文1 = textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence());
            } else if (項目番号 == 2) {
                通知文2 = textHenkanRule.editText(tsuchishoTeikeibun.getTsuchishoTeikeibunEntity().getSentence());
            }
        }
    }

    //TODO 内部QA：714　Redmine：#76765 出力条件表の実装方式
    private void set出力条件表() {
        List 出力条件 = new ArrayList();
        出力条件.add(processParamter.getIraiFromYMD());
        出力条件.add(processParamter.getIraiToYMD());
        出力条件.add(processParamter.getHihokenshaNo());
        出力条件.add(processParamter.getNinteiChosaIraisyo());
        出力条件.add(processParamter.getNinteiChosahyo());
        出力条件.add(processParamter.getNinteiChosaItakusakiCodeList());
        出力条件.add(processParamter.getNinteiChosainNoList());
        出力条件.add(processParamter.getHakkobi());
        出力条件.add(processParamter.getTeishutsuKigen());
        出力条件.add(processParamter.getKyotsuHizuke());
        出力条件.add(processParamter.getNinteioChosaIraiIchiranhyo());
        出力条件.add(processParamter.getNinteiChosaIrai());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem 帳票出力条件表パラメータ
                = new ReportOutputJokenhyoItem(
                        帳票ID.value(),
                        association.getLasdecCode_().getColumnValue(),
                        association.get市町村名(),
                        new RString("【ジョブ番号】").concat(String.valueOf(JobContextHolder.getJobId())),
                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, 帳票ID.value()),
                        new RString(String.valueOf(ichiranhyoReportSourceWriter.pageCount().value())),
                        CSV出力有無,
                        CSVファイル名,
                        出力条件);
        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
    }
}
