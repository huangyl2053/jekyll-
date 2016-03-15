/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.homonchosairaisho;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoBodyItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoHeadItem;
import jp.co.ndensan.reams.db.dbe.business.report.chosairaiichiranhyo.ChosaIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportId.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.HomonChosaIraishoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.HomonChosaIraishoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosairaiichiranhyo.ChosaIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbz.service.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
 *
 * 訪問調査依頼書発行_バッチフ処理クラスです
 */
public class IchiranhyoReportProcess extends BatchProcessBase<HomonChosaIraishoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbe.persistence.db.mapper."
            + "relate.hakkoichiranhyo.IHomonChosaIraishoMapper.get訪問調査依頼書");
    private static final ReportId 帳票ID = ReportIdDBE.DBE220002.getReportId();
 //   private static final RString CONFIGVALUE = new RString("1");
//    private static final RString CSV出力有無 = new RString("なし");
//    private static final RString CSVファイル名 = new RString("-");
    //   private IHomonChosaIraishoMapper iHomonChosaIraishoMapper;
    private ChosaIraiIchiranhyoHeadItem ichiranhyoHeadItem;
    private List<ChosaIraiIchiranhyoBodyItem> ichiranhyoBodyItemList;
    private HomonChosaIraishoProcessParamter processParamter;
    //  private HomonChosaIraishoMybitisParamter mybatisParamter;
    private RString 事業者番号;

    @BatchWriter
    private BatchReportWriter<ChosaIraiIchiranhyoReportSource> ichiranhyoBatchReportWriter;
    private ReportSourceWriter<ChosaIraiIchiranhyoReportSource> ichiranhyoReportSourceWriter;

    @Override
    protected void initialize() {
        //iHomonChosaIraishoMapper = getMapper(IHomonChosaIraishoMapper.class);
        ichiranhyoBodyItemList = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toHomonChosaIraishoMybitisParamter());
    }

    @Override
    protected void createWriter() {
        ichiranhyoBatchReportWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value()).create();
        ichiranhyoReportSourceWriter = new ReportSourceWriter<>(ichiranhyoBatchReportWriter);
    }

    @Override
    protected void process(HomonChosaIraishoRelateEntity entity) {
//        // 内部QA：614　Redmine：＃75422　排他制限の確認
//        事業者番号 = entity.get事業者番号();
//        update認定調査依頼情報(entity);
//        getカスタマーバーコード(entity);
//        ichiranhyoBodyItemList.add(setBodyItem(entity));
    }

    @Override
    protected void afterExecute() {
        if (ichiranhyoBodyItemList != null && !ichiranhyoBodyItemList.isEmpty()) {
            NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBE認定支援,
                    帳票ID,
                    new FlexibleDate(processParamter.getHakkobi()),
                    ichiranhyoReportSourceWriter);
            Map<Integer, RString> 通知文Map = ReportUtil.get通知文(SubGyomuCode.DBE認定支援, 帳票ID, KamokuCode.EMPTY, 1);
            ichiranhyoHeadItem = new ChosaIraiIchiranhyoHeadItem(ninshoshaSource.hakkoYMD,
                    ninshoshaSource.denshiKoin,
                    ninshoshaSource.ninshoshaYakushokuMei,
                    ninshoshaSource.ninshoshaYakushokuMei2,
                    ninshoshaSource.ninshoshaYakushokuMei1,
                    ninshoshaSource.ninshoshaShimeiKakenai,
                    ninshoshaSource.ninshoshaShimeiKakeru,
                    ninshoshaSource.koinMojiretsu,
                    ninshoshaSource.koinShoryaku,
                    new RString("宛名郵便番号"),
                    new RString("宛名住所"),
                    new RString("宛名機関名"),
                    new RString("宛名氏名"),
                    new RString("宛名名称付与"),
                    事業者番号,
                    通知文Map.get(1),
                    通知文Map.get(2));
            ChosaIraiIchiranhyoReport report = ChosaIraiIchiranhyoReport.createFrom(ichiranhyoHeadItem, ichiranhyoBodyItemList);
            report.writeBy(ichiranhyoReportSourceWriter);
        }
    }

//    private ChosaIraiIchiranhyoBodyItem setBodyItem(HomonChosaIraishoRelateEntity entity) {
//        RString 提出期限 = RString.EMPTY;
//        if (entity.get要介護認定調査表提出期限() != null) {
//            提出期限 = new RString(entity.get要介護認定調査表提出期限().toString());
//        }
//        return new ChosaIraiIchiranhyoBodyItem(
//                RString.EMPTY,
//                entity.get調査員名(),
//                entity.get被保険者番号(),
//                entity.get要介護認定_更新申請日(),
//                entity.get申請区分コード(),
//                entity.get被保険者氏名(),
//                entity.get被保険者氏名カナ(),
//                Seibetsu.toValue(entity.get性別コード()).get名称(),
//                entity.get生年月日(),
//                entity.get被保険者住所(),
//                entity.get被保険者電話番号(),
//                提出期限);
//    }
//
//    private void update認定調査依頼情報(HomonChosaIraishoRelateEntity entity) {
//        DbT5201NinteichosaIraiJohoEntity dbT5201Entity = new DbT5201NinteichosaIraiJohoEntity();
//        RString 認定調査期限設定方法 = BusinessConfig.get(ConfigNameDBE.認定調査期限設定方法, SubGyomuCode.DBE認定支援);
//        if (CONFIGVALUE.equals(認定調査期限設定方法)) {
//            switch (processParamter.getTeishutsuKigen().toString()) {
//                case "0":
//                    int 期限日数 = Integer.parseInt(BusinessConfig.get(ConfigNameDBE.認定調査期限日数,
//                            SubGyomuCode.DBE認定支援).toString());
//                    FlexibleDate 認定調査依頼日 = entity.get認定調査依頼年月日();
//                    if (認定調査依頼日 != null && !認定調査依頼日.isEmpty()) {
//                        entity.set要介護認定調査表提出期限(認定調査依頼日.plusDay(期限日数));
//                    }
//                    break;
//                case "1":
//                    entity.set要介護認定調査表提出期限(FlexibleDate.EMPTY);
//                    break;
//                case "2":
//                    if (RString.isNullOrEmpty(processParamter.getKyotsuHizuke())) {
//                        entity.set要介護認定調査表提出期限(new FlexibleDate(processParamter.getKyotsuHizuke()));
//                    }
//                    break;
//                default:
//                    break;
//            }
//        }
//        dbT5201Entity.setShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()));
//        dbT5201Entity.setNinteichosaIraiRirekiNo(entity.get最大依頼履歴番号());
//        dbT5201Entity.setLogicalDeletedFlag(false);
//        dbT5201Entity.setIraishoShutsuryokuYMD(new FlexibleDate(processParamter.getHakkobi()));
//        dbT5201Entity.setNinteichosaKigenYMD(entity.get要介護認定調査表提出期限());
//        iHomonChosaIraishoMapper.update認定調査依頼情報(dbT5201Entity);
//    }
//
//    private RString getカスタマーバーコード(HomonChosaIraishoRelateEntity entity) {
//        RString カスタマーバーコード = RString.EMPTY;
//        CustomerBarCode barCode = new CustomerBarCode();
//        RString 被保険者郵便番号 = entity.get被保険者住所_郵便番号();
//        RString 住所 = entity.get被保険者住所();
//        if (RString.isNullOrEmpty(被保険者郵便番号) && RString.isNullOrEmpty(住所)) {
//            CustomerBarCodeResult result = barCode.convertCustomerBarCode(被保険者郵便番号, 住所);
//            if (result != null) {
//                カスタマーバーコード = result.getCustomerBarCode();
//            }
//        }
//        return カスタマーバーコード;
//    }
//    //TODO 内部QA：714　Redmine：#76765 出力条件表の実装方式
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
//                        帳票ID.value(),
//                        association.getLasdecCode_().getColumnValue(),
//                        association.get市町村名(),
//                        new RString("【ジョブ番号】").concat(String.valueOf(JobContextHolder.getJobId())),
//                        ReportInfo.getReportName(SubGyomuCode.DBE認定支援, 帳票ID.value()),
//                        new RString(String.valueOf(ichiranhyoReportSourceWriter.pageCount().value())),
//                        CSV出力有無,
//                        CSVファイル名,
//                        出力条件);
//        OutputJokenhyoFactory.createInstance(帳票出力条件表パラメータ).print();
//    }
}
