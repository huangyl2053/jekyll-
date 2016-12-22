/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD522001;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD532001.TsutishoHakkoCommonProcess.get地方公共団体;
import jp.co.ndensan.reams.db.dbd.business.report.dbd522001.YokaigoNinteiEnkiTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.enkitsuchisho.EnkiTsuchishohakenIchiranhyoJyohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.enkitsuchisho.YokaigoNinteiEnkiTshuchishoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd522001.YokaigoNinteiEnkiTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbx.business.core.basic.KaigoDonyuKeitai;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.basic.KaigoDonyuKeitaiManager;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5101NinteiShinseiJohoDac;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.HojinDaihyoshaRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SetainushiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 延期通知書情報の作成_process処理クラスです。
 *
 * @reamsid_L DBD-1410-020 chenxin
 */
public class EnkiTsuchishoJyohoReportProcess extends BatchProcessBase<DbT4101NinteiShinseiJohoEntity> {

    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INDEX_ZERO = 0;

    private static final ReportId REPORT_DBD522001 = ReportIdDBD.DBD522001.getReportId();
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.enkitsuchisho."
                    + "IEnkiTsuchishoMapper.selectBy申請書管理番号リスト");

    @BatchWriter
    private BatchReportWriter<YokaigoNinteiEnkiTshuchishoReportSource> batchReportWriter;
    private ReportSourceWriter<YokaigoNinteiEnkiTshuchishoReportSource> reportSourceWriter;
    private EnkiTsuchishohakenIchiranhyoJyohoProcessParameter parameter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT4101NinteiShinseiJohoEntity> dbT4101TableWriter;
    private SofubutsuAtesakiSource sofubutsuAtesakiSource;
    private static final RString 申請書管理番号リスト = new RString("【申請書管理番号】");
    private static final RString 申請書管理番号空白 = new RString("　　　　　　　　　　　　");
    private static final RString 通知書発行日 = new RString("【通知書発行日】");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toEnkiTsuchishoJyohoMybatisParameter());
    }

    @Override
    protected void initialize() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(REPORT_DBD522001.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchReportWriter);
        dbT4101TableWriter = new BatchPermanentTableWriter<>(DbT4101NinteiShinseiJohoEntity.class);
        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());
        EditedAtesaki 編集後宛先 = EditedAtesakiBuilder.create編集後宛先(宛先, get地方公共団体(), get帳票共通情報(REPORT_DBD522001));
        sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();

    }

    @Override
    protected void process(DbT4101NinteiShinseiJohoEntity dbtEntity) {
        YokaigoNinteiEnkiTshuchishoEntity entity = new YokaigoNinteiEnkiTshuchishoEntity();
        entity.setEntity(dbtEntity);
        DbT5101NinteiShinseiJohoDac dbT5101Dac = InstanceProvider.create(DbT5101NinteiShinseiJohoDac.class);
        boolean 広域フラグ = false;
        DbT5101NinteiShinseiJohoEntity 要介護認定申請情報 = null;
        KaigoDonyuKeitaiManager 介護導入形態manager = KaigoDonyuKeitaiManager.createInstance();
        List<KaigoDonyuKeitai> list介護事務 = 介護導入形態manager.get介護導入形態By業務分類(GyomuBunrui.介護事務);
        if (!list介護事務.get(INDEX_ZERO).get導入形態コード().equals(DonyuKeitaiCode.事務広域)){
            List<KaigoDonyuKeitai> list介護認定 = 介護導入形態manager.get介護導入形態By業務分類(GyomuBunrui.介護認定);
            if (list介護認定.get(INDEX_ZERO).get導入形態コード().equals(DonyuKeitaiCode.認定広域)){
                要介護認定申請情報 =  dbT5101Dac.selectByKey(dbtEntity.getShinseishoKanriNo());
                広域フラグ = true;
            }
        }
        if (広域フラグ = true){
            set送付先申請先情報(entity, 要介護認定申請情報);
        }else{
            set送付物宛先情報(entity);
        }
        
        FlexibleDate 通知書発行日 = get通知書発行日(dbtEntity.getShinseishoKanriNo().value());
        entity.set文書番号(parameter.get文書番号());
        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(
                SubGyomuCode.DBD介護受給,
                REPORT_DBD522001,
                通知書発行日,
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし,
                reportSourceWriter);
        entity.set電子公印(ninshoshaSource.denshiKoin);
        entity.set発行日(ninshoshaSource.hakkoYMD);
        entity.set認証者役職名(ninshoshaSource.ninshoshaYakushokuMei);
        entity.set認証者役職名1(ninshoshaSource.ninshoshaYakushokuMei1);
        entity.set認証者役職名2(ninshoshaSource.ninshoshaYakushokuMei2);
        entity.set認証者氏名公印に掛けない(ninshoshaSource.ninshoshaShimeiKakenai);
        entity.set認証者氏名公印に掛ける(ninshoshaSource.ninshoshaShimeiKakeru);
        entity.set公印省略(ninshoshaSource.koinShoryaku);
        entity.set公印文字列(ninshoshaSource.koinMojiretsu);
        Map<Integer, RString> map = ReportUtil.get通知文(
                SubGyomuCode.DBD介護受給,
                REPORT_DBD522001,
                KamokuCode.EMPTY,
                1);
        entity.set通知文1(map.get(1));
        entity.set通知文2(map.get(2));
        map = ReportUtil.get通知文(
                SubGyomuCode.DBD介護受給,
                REPORT_DBD522001,
                KamokuCode.EMPTY,
                2);
        entity.setフフォント大(map.get(2));
        map = ReportUtil.get通知文(
                SubGyomuCode.DBD介護受給,
                REPORT_DBD522001,
                KamokuCode.EMPTY,
                INT_3);
        entity.setフォント混在_1(map.get(2));
        entity.setフォント混在_2(map.get(INT_3));
        map = ReportUtil.get通知文(
                SubGyomuCode.DBD介護受給,
                REPORT_DBD522001,
                KamokuCode.EMPTY,
                INT_4);
        entity.setフォント混在2_1(map.get(2));
        entity.setフォント混在2_2(map.get(INT_3));
        YokaigoNinteiEnkiTshuchishoReport report = new YokaigoNinteiEnkiTshuchishoReport(entity);
        report.writeBy(reportSourceWriter);

        dbtEntity.setEnkiTsuchiHakkoYMD(通知書発行日);
        dbtEntity.setEnkiTsuchiHakkoKaisu(entity.getEntity().getEnkiTsuchiHakkoKaisu() + 1);
        dbT4101TableWriter.update(dbtEntity);
    }

    private FlexibleDate get通知書発行日(RString 申請書管理番号) {
        FlexibleDate 通知書発行日 = FlexibleDate.EMPTY;
        for (int index = 0; index < parameter.get申請書管理番号リスト().size(); index++) {
            if (申請書管理番号.equals(parameter.get申請書管理番号リスト().get(index))) {
                通知書発行日 = parameter.get通知書発行日().get(index);
            }
        }
        return 通知書発行日;
    }

    private void set送付先申請先情報(YokaigoNinteiEnkiTshuchishoEntity entity, DbT5101NinteiShinseiJohoEntity 要介護認定申請情報){
        entity.set郵便番号(要介護認定申請情報.getYubinNo().getEditedYubinNo());
        entity.set行政区(RString.EMPTY);
        entity.set住所TextField(要介護認定申請情報.getJusho().getColumnValue());
        entity.set住所優先順位1(RString.EMPTY);
        entity.set住所優先順位2(RString.EMPTY);
        entity.set住所優先順位3(RString.EMPTY);
        entity.set方書TextField(RString.EMPTY);
        entity.set方書優先順位1標準(RString.EMPTY);
        entity.set方書優先順位2標準(RString.EMPTY);
        entity.set方書優先順位1小(RString.EMPTY);
        entity.set方書優先順位2小(RString.EMPTY);
        entity.set代納人区分(RString.EMPTY);
        entity.set氏名1TextField(要介護認定申請情報.getHihokenshaName().getColumnValue());
        entity.set氏名1優先順位1標準(RString.EMPTY);
        entity.set氏名1優先順位2標準(RString.EMPTY);
        entity.set氏名1優先順位1小(RString.EMPTY);
        entity.set氏名1優先順位2小(RString.EMPTY);
        entity.set氏名2TextField(RString.EMPTY);
        entity.set氏名2優先順位1標準(RString.EMPTY);
        entity.set氏名2優先順位2標準(RString.EMPTY);
        entity.set氏名2優先順位1小(RString.EMPTY);
        entity.set氏名2優先順位2小(RString.EMPTY);
        entity.set氏名1敬称1(new RString("様"));
        entity.set氏名1敬称2(RString.EMPTY);
        entity.set氏名2敬称1(RString.EMPTY);
        entity.set氏名2敬称2(RString.EMPTY);
        entity.set左括弧1(RString.EMPTY);
        entity.set左括弧2(RString.EMPTY);
        entity.set右括弧1(RString.EMPTY);
        entity.set右括弧2(RString.EMPTY);
        entity.setカスタマバーコード(RString.EMPTY);
    }
        
    private void set送付物宛先情報(YokaigoNinteiEnkiTshuchishoEntity entity) {
        entity.set郵便番号(sofubutsuAtesakiSource.yubinNo);
        entity.set行政区(sofubutsuAtesakiSource.gyoseiku);
        entity.set住所TextField(sofubutsuAtesakiSource.jushoText);
        entity.set住所優先順位1(sofubutsuAtesakiSource.jusho1);
        entity.set住所優先順位2(sofubutsuAtesakiSource.jusho2);
        entity.set住所優先順位3(sofubutsuAtesakiSource.jusho3);
        entity.set方書TextField(sofubutsuAtesakiSource.katagakiText);
        entity.set方書優先順位1標準(sofubutsuAtesakiSource.katagaki1);
        entity.set方書優先順位2標準(sofubutsuAtesakiSource.katagaki2);
        entity.set方書優先順位1小(sofubutsuAtesakiSource.katagakiSmall1);
        entity.set方書優先順位2小(sofubutsuAtesakiSource.katagakiSmall2);
        entity.set代納人区分(sofubutsuAtesakiSource.dainoKubunMei);
        entity.set氏名1TextField(sofubutsuAtesakiSource.shimeiText);
        entity.set氏名1優先順位1標準(sofubutsuAtesakiSource.shimei1);
        entity.set氏名1優先順位2標準(sofubutsuAtesakiSource.shimei2);
        entity.set氏名1優先順位1小(sofubutsuAtesakiSource.shimeiSmall1);
        entity.set氏名1優先順位2小(sofubutsuAtesakiSource.shimeiSmall2);
        entity.set氏名2TextField(sofubutsuAtesakiSource.samabunShimeiText);
        entity.set氏名2優先順位1標準(sofubutsuAtesakiSource.samabunShimei1);
        entity.set氏名2優先順位2標準(sofubutsuAtesakiSource.samabunShimei2);
        entity.set氏名2優先順位1小(sofubutsuAtesakiSource.samabunShimeiSmall1);
        entity.set氏名2優先順位2小(sofubutsuAtesakiSource.samabunShimeiSmall2);
        entity.set氏名1敬称1(sofubutsuAtesakiSource.meishoFuyo1);
        entity.set氏名1敬称2(sofubutsuAtesakiSource.meishoFuyo2);
        entity.set氏名2敬称1(sofubutsuAtesakiSource.samaBun1);
        entity.set氏名2敬称2(sofubutsuAtesakiSource.samaBun2);
        entity.set左括弧1(sofubutsuAtesakiSource.kakkoLeft1);
        entity.set左括弧2(sofubutsuAtesakiSource.kakkoLeft2);
        entity.set右括弧1(sofubutsuAtesakiSource.kakkoRight1);
        entity.set右括弧2(sofubutsuAtesakiSource.kakkoRight2);
        entity.setカスタマバーコード(sofubutsuAtesakiSource.customerBarCode);
    }

    private ChohyoSeigyoKyotsu get帳票共通情報(ReportId reportId) {
        return new ChohyoSeigyoKyotsuManager().get帳票制御共通(SubGyomuCode.DBD介護受給, reportId);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString ページ数 = new RString(reportSourceWriter.pageCount().value());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD522001.getReportId().getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD522001.getReportName(),
                ページ数,
                new RString("無し"),
                RString.EMPTY,
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        // TODO：2016/12/20 不要の為、削除
//        boolean 空白Flag = Boolean.FALSE;
        出力条件.add(通知書発行日.concat(get通知書発行日リスト()));
        // TODO：2016/12/20 不要の為、削除
//        if (parameter.get申請書管理番号リスト() != null) {
//            for (RString 申請書管理番号 : parameter.get申請書管理番号リスト()) {
//                if (!空白Flag) {
//                    出力条件.add(申請書管理番号リスト.concat(申請書管理番号));
//                    空白Flag = Boolean.TRUE;
//                } else {
//                    出力条件.add(申請書管理番号空白.concat(申請書管理番号));
//                }
//            }
//        }
        return 出力条件;
    }

    private RString get通知書発行日リスト() {
        RString 通知書発行日リスト = RString.EMPTY;
        for (FlexibleDate date : parameter.get通知書発行日()) {
            if (通知書発行日リスト.isEmpty()) {
                通知書発行日リスト = 通知書発行日リスト.concat(date.wareki().toDateString());
            } else {
                通知書発行日リスト = 通知書発行日リスト.concat(",").concat(date.wareki().toDateString());
            }

        }
        return 通知書発行日リスト;
    }

}
