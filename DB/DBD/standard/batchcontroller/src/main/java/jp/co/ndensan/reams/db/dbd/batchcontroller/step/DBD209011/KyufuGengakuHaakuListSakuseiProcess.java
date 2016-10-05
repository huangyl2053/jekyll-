/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD532001.TsutishoHakkoCommonProcess;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003.KyufuGengakuHaakuListSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KyufuGengakuHaakuListSakuseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200008.KyufuGengakuHaakuIchiranReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 給付額減額滞納者把握情報の取得_Process処理クラスです．
 *
 * @reamsid_L DBD-3610-050 x_miaocl
 */
public class KyufuGengakuHaakuListSakuseiProcess extends BatchProcessBase<KyufuGengakuHaakuListSakuseiEntity> {

    private KyufuGengakuHaakuListSakuseiProcessParameter parameter;
    private static final ReportId REPORT_DBD200008 = ReportIdDBD.DBD200008.getReportId();
    private static final ReportId 帳票ID = new ReportId("DBD200008_KyufuGengakuHaakuIchiran");
    private BatchReportWriter<KyufuGengakuHaakuIchiranReportSource> batchReportWrite;
//    private ReportSourceWriter<KyufuGengakuHaakuIchiranReportSource> reportSourceWriter;
//    private RString reamsLoginID;
//    private Decimal 調定額の合計;
//    private Decimal 収入額の合計;
//    private Decimal 未納額の合計;
//    private Decimal 納付額減額期間;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist."
                    + "IKyufuGengakuHaakuListSakuseiMapper.get給付額減額滞納者把握情報");

    @Override
    protected void initialize() {
//        reamsLoginID = UrControlDataFactory.createInstance().getLoginInfo().getUserId();
//        Association association = AssociationFinderFactory.createInstance().getAssociation();
//        RString 市町村名 = association.get市町村名();
//        調定額の合計 = Decimal.ZERO;
//        収入額の合計 = Decimal.ZERO;
//        未納額の合計 = Decimal.ZERO;
//        納付額減額期間 = Decimal.ZERO;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toKyufuGengakuHaakuListSakuseiMybatisParameter(parameter.get改頁出力順ID()));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(帳票ID.value(),
                SubGyomuCode.DBD介護受給).create();
//        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    @Override
    protected void process(KyufuGengakuHaakuListSakuseiEntity sjhe) {
//        RString 帳票タイトル = new RString("介護保険　給付額減額把握リスト");
    }

    @Override
    protected void afterExecute() {
        バッチ出力条件リストの出力();
    }

//    private RString get出力順() {
//        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
//        IOutputOrder order = finder.get出力順(SubGyomuCode.DBD介護受給, parameter.get帳票ID(), reamsLoginID, parameter.get改頁出力順ID());
//        RString 出力順 = RString.EMPTY;
//        if (order != null) {
//            //出力順 = MyBatisOrderByClauseCreator.create(KyufuGengakuCsvProcessProperty.DBD200008_KyufuGengakuHaakuIchiran.class, order);
//        }
//        return 出力順;
//    }
//    private HihokenshaJohoEntity 給付額減額情報(KyufuGengakuHaakuListSakuseiEntity sjhe) {
//        HihokenshaJohoEntity entity = new HihokenshaJohoEntity();
//        IKojin kojin = ShikibetsuTaishoFactory.createKojin(sjhe.getFindShikibetsuTaishoEntity());
//        entity.set被保険者番号(sjhe.getHihokenshaNo().getColumnValue());
//        entity.set識別コード(kojin.get識別コード().getColumnValue());
//        entity.set被保険者氏名カナ(kojin.get名称().getKana().getColumnValue());
//        entity.set被保険者氏名(kojin.get名称().getName().getColumnValue());
//        entity.set世帯番号(kojin.get世帯コード().getColumnValue());
//        entity.set行政区ｺｰﾄﾞ(kojin.get行政区画().getGyoseiku().getコード().getColumnValue());
//        entity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
//        entity.set住所コード(kojin.get住所().get全国住所コード().value());
//        entity.set郵便番号(sjhe.getYubinNo().getColumnValue());
//        entity.set住所(kojin.get住所().get住所());
//        set資格情報について(entity, sjhe);
//        set認定情報について(entity, sjhe);
//        set減額対象最新情報について(entity);
//        return entity;
//    }
//    private ShounaQingbaoEntity 給付収納情報(KyufuGengakuHaakuListSakuseiEntity sjhe) {
//        ShounaQingbaoEntity entity = new ShounaQingbaoEntity();
//        entity.set賦課年度(sjhe.getFukaNendo());
//        entity.set調定年度(sjhe.getChoteiNendo());
//        entity.set期別(sjhe.getKibetsu());
//        entity.set保険料金(sjhe.getChoteigaku());
//        //TODO
//        //entity.set納期限(reamsLoginID);
//        entity.set滞納額(sjhe.getMinogaku());
//        entity.set滞納区分(sjhe.getTainoKubun());
//        entity.set時効起算日(sjhe.getJikoKisanYMD());
//        entity.set時効起算事由(sjhe.getJikoKisanJiyu());
//        entity.set特徴普徴区分(sjhe.getTokucho_FuchoKubun());
//        if (sjhe.getFukaNendo() == null) {
//            entity.set収納情報なし(true);
//        }
//        return entity;
//    }
//    private GengakushoSaishinJoho 減額対象情報(KyufuGengakuHaakuListSakuseiEntity sjhe) {
//        GengakushoSaishinJoho joho = new GengakushoSaishinJoho();
//        joho.set徴収権消滅期間(sjhe.getShiharaiHohoHenkoGengaku().getChoshukenShometsuKikan());
//        joho.set納付済み期間(sjhe.getShiharaiHohoHenkoGengaku().getNofusumiKikan());
//        joho.set納付額減額期間(sjhe.getShiharaiHohoHenkoGengaku().getNofusumiGengakuKikan());
//        return joho;
//
//    }
//    private void set資格情報について(HihokenshaJohoEntity entity, KyufuGengakuHaakuListSakuseiEntity sjhe) {
//        ShikakuJoho data = new ShikakuJoho();
//        data.set資格取得日(sjhe.getShikakuShutokuYMD());
//        data.set資格喪失日(sjhe.getShikakuSoshitsuYMD());
//        data.set喪失事由(sjhe.getShikakuSoshitsuJiyuCode());
//        data.set資格区分(sjhe.getHihokennshaKubunCode());
//        data.set住特フラグ(sjhe.isKoikinaiJushochiTokureiFlag());
//        data.set生保フラグ(sjhe.isSeihoFlag());
//        entity.set資格情報(data);
//
//    }
//    private void set認定情報について(HihokenshaJohoEntity entity, KyufuGengakuHaakuListSakuseiEntity sjhe) {
//        NinteiJoho data = new NinteiJoho();
//        data.set厚労省IF識別コード(sjhe.getKoroshoIfShikibetsuCode().getColumnValue());
//        data.set要介護状態区分コード(sjhe.getYokaigoJotaiKubunCode().getColumnValue());
//        data.set認定有効期間開始年月日(sjhe.getNinteiYukoKikanKaishiYMD());
//        data.set認定有効期間終了年月日(sjhe.getNinteiYukoKikanShuryoYMD());
//        data.set認定日(sjhe.getNinteiYMD());
//        data.set申請中フラグ(sjhe.isShiseityuFlag());
//        data.set申請日(sjhe.getJukyuShinseiYMD());
//        entity.set認定情報(data);
//    }
//    private void set減額対象最新情報について(HihokenshaJohoEntity entity) {
//        GengakuTaishoSaishinJoho data = new GengakuTaishoSaishinJoho();
//        TaisyoSaisiJoho tsj = new TaisyoSaisiJoho();
//        data.set徴収権消滅期間(tsj.get徴収権消滅期間());
//        data.set納付済み期間(tsj.get納付済み期間());
//        data.set納付額減額期間(納付額減額期間);
//        entity.set減額対象最新情報(data);
//    }
    private void バッチ出力条件リストの出力() {
        Association association = TsutishoHakkoCommonProcess.get地方公共団体();
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 帳票名 = ReportIdDBD.DBD200008.getReportName();
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        RString csv出力有無 = new RString("無し");
        RString csvファイル名 = new RString("無し");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(parameter.get基準日());
        出力条件.add(builder.toRString());
        builder.append(parameter.get時効起算日登録者の選択());
        出力条件.add(builder.toRString());
        builder.append(parameter.get被保険者選択());
        出力条件.add(builder.toRString());
        builder.append(parameter.get受給者全員());
        出力条件.add(builder.toRString());
        builder.append(parameter.get受給認定申請中者());
        出力条件.add(builder.toRString());
        builder.append(parameter.get受給認定日抽出());
        出力条件.add(builder.toRString());
        builder.append(parameter.get受給認定日抽出の開始());
        出力条件.add(builder.toRString());
        builder.append(parameter.get受給認定日抽出の終了());
        出力条件.add(builder.toRString());
        builder.append(parameter.get認定有効終日抽出());
        出力条件.add(builder.toRString());
        builder.append(parameter.get認定有効終日抽出の開始());
        出力条件.add(builder.toRString());
        builder.append(parameter.get認定有効終日抽出の終了());
        出力条件.add(builder.toRString());
        builder.append(parameter.get保険料完納者も出力());
        出力条件.add(builder.toRString());
        builder.append(parameter.get改頁出力順ID());

        //TODO
//        出力条件.add(builder.toRString());
//        builder.append(parameter.get帳票分類ID());
        出力条件.add(builder.toRString());
        builder.append(parameter.get帳票ID());
        出力条件.add(builder.toRString());
        builder.append(parameter.get帳票作成日時());
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                REPORT_DBD200008.value(),
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

//    private void editKyufuGengakuHaakuListSakuseiEntity(List<KyufuGengakuHaakuListSakuseiEntity> resultList) {
//        Map<FlexibleYear, List<KyufuGengakuHaakuListSakuseiEntity>> map = new HashMap<>();
//        List<FlexibleYear> fukaYearList = new ArrayList<>();
//        for (KyufuGengakuHaakuListSakuseiEntity dataEntity : resultList) {
//            if (map.containsKey(dataEntity.getFukaNendo())) {
//                map.get(dataEntity.getFukaNendo()).add(dataEntity);
//            } else {
//                List<KyufuGengakuHaakuListSakuseiEntity> list = new ArrayList<>();
//                list.add(dataEntity);
//                fukaYearList.add(dataEntity.getFukaNendo());
//                map.put(dataEntity.getFukaNendo(), list);
//            }
//        }
//        Map<FlexibleYear, TaisyoSaisiJoho> TaisyoSaisiJohoMap = new HashMap<>();
//        for (FlexibleYear 年度 : fukaYearList) {
//            List<KyufuGengakuHaakuListSakuseiEntity> result = map.get(年度);
//            if (result != null && !result.isEmpty()) {
//                for (KyufuGengakuHaakuListSakuseiEntity data : result) {
//                    調定額の合計 = 調定額の合計.add(data.getChoteigaku());  // A
//                    収入額の合計 = 収入額の合計.add(data.getShunyugaku()); // B
//                    未納額の合計 = 未納額の合計.add(data.getMinogaku());  // C
//                }
//                TaisyoSaisiJoho editData = new TaisyoSaisiJoho();
//                editData.set徴収権消滅期間(収入額の合計.divide(調定額の合計));
//                editData.set納付済み期間(未納額の合計.divide(調定額の合計));
//                TaisyoSaisiJohoMap.put(年度, editData);
//                調定額の合計 = Decimal.ZERO;
//                収入額の合計 = Decimal.ZERO;
//                未納額の合計 = Decimal.ZERO;
//            }
//        }
//        Decimal 徴収権消滅期間の合計 = Decimal.ZERO;
//        Decimal 納付済み期間の合計 = Decimal.ZERO;
//        for (FlexibleYear year : fukaYearList) {
//            TaisyoSaisiJoho data = TaisyoSaisiJohoMap.get(year);
//            徴収権消滅期間の合計 = 徴収権消滅期間の合計.add(data.get徴収権消滅期間()); // α
//            納付済み期間の合計 = 納付済み期間の合計.add(data.get納付済み期間()); //β
//        }
//        納付額減額期間 = 徴収権消滅期間の合計.multiply(徴収権消滅期間の合計.divide(徴収権消滅期間の合計.add(納付済み期間の合計))).multiply(1).divide(2).multiply(12);
//    }
}
