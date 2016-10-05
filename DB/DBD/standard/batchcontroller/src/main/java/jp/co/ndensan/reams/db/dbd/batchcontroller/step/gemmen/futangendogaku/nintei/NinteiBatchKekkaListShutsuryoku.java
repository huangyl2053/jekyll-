/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.futangendogaku.nintei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd206010.TyohyoShutuyukuOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200019.FutangakuNinteiHakkoIchiranOrderKey;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt22006.NinteiBatchKekkaListShutsuryokuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.futangendogaku.ikkatsunintei.FutanGengaokuNintteiKakuninListEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 負担限度額認定申請一括承認（バッチ）_結果一覧出力のprocess処理クラスです。
 *
 * @reamsid_L DBD-3710-070 chenxin
 */
public class NinteiBatchKekkaListShutsuryoku extends BatchKeyBreakBase<FutanGengaokuNintteiKakuninListEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futangendogaku."
                    + "INinteiBatchKekkaListShutsuryokuMapper.get結果一覧データ");
    private NinteiBatchKekkaListShutsuryokuProcessParameter parameter;
    private RString 出力順;
    private Association 導入団体;
    @BatchWriter
    private BatchReportWriter<FutanGendogakuNinteiKakuninIchiranReportSource> batchReportWriter;
    private ReportSourceWriter<FutanGendogakuNinteiKakuninIchiranReportSource> reportSourceWriter;
    private IOutputOrder outputOrder;
    private static final int NUM5 = 5;
    private static final int NUM8 = 8;
    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;
    private RString orderBy = null;
    private static final RString 作成年度 = new RString("【作成年度】");
    private static final RString 認定期間_開始日 = new RString("【認定期間_開始日】");
    private static final RString 認定期間_終了日 = new RString("【認定期間_終了日】");
    private static final RString 決定日 = new RString("【決定日】");
    private static final RString 申請日開始 = new RString("【申請日開始】");
    private static final RString 申請日終了 = new RString("【申請日終了】");
    private static final RString 非課税時_承認しないフラグ = new RString("【非課税時_承認しないフラグ】");
    private static final RString 非課税時_承認しない理由 = new RString("【非課税時_承認しない理由】");
    private static final RString 配偶者課税時_承認しないフラグ = new RString("【配偶者課税時_承認しないフラグ】");
    private static final RString 配偶者課税時_承認しない理由 = new RString("【配偶者課税時_承認しない理由】");
    private static final RString 預貯金等超過時_承認しないフラグ = new RString("【預貯金等超過時_承認しないフラグ】");
    private static final RString 預貯金等超過時_理由 = new RString("【預貯金等超過時_理由】");
    private static final RString テスト処理 = new RString("【テスト処理】");
    private static final RString 確認リスト出力 = new RString("【確認リスト出力】");
    private static final RString 発行日 = new RString("【発行日】");
    private static final RString 改頁出力順ID = new RString("【改頁出力順ID】");
    private static final RString 帳票分類ID = new RString("【帳票分類ID】");
    private static final RString 帳票ID = new RString("【帳票ID】");
    private static final RString 帳票作成日時 = new RString("【帳票作成日時】");
    private static final RString 負担限度額認定申請承認一括 = new RString("【負担限度額認定申請承認一括】");
    private static final RString TRUE = new RString("TRUE");
    private static final RString FALSE = new RString("FALSE");

    @Override
    protected void initialize() {
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給, new ReportId(parameter.get帳票ID()),
                UrControlDataFactory.createInstance().getLoginInfo().getUserId(), Long.valueOf(parameter.get改頁出力順ID().toString()));
        if (outputOrder != null) {
            出力順 = MyBatisOrderByClauseCreator.create(FutangakuNinteiHakkoIchiranOrderKey.class, outputOrder);
        } else {
            出力順 = RString.EMPTY;
        }
        導入団体 = AssociationFinderFactory.createInstance().getAssociation();
        if (null != outputOrder) {
            if (parameter.get改頁出力順ID() != null) {
                orderBy = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(TyohyoShutuyukuOrderKey.class,
                        outputOrder).replace("order by", ","), NUM5);
            } else {
                orderBy = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(TyohyoShutuyukuOrderKey.class,
                        outputOrder).substring(NUM8), NUM5);
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNinteiBatchKekkaListShutsuryokuMybatisParameter());
    }

    @Override
    protected void createWriter() {
        List<RString> pageBreakKeys = new ArrayList<>();
        set改頁Key(outputOrder, pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(parameter.get帳票ID())
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(FutanGengaokuNintteiKakuninListEntity current) {

    }

    @Override
    protected void usualProcess(FutanGengaokuNintteiKakuninListEntity entity) {
//        FutanGendogakuNinteiKakunin reportEntity = new FutanGendogakuNinteiKakunin();
//        FutanGendogakuNinteiKakuninIchiranReport report
//                = new FutanGendogakuNinteiKakuninIchiranReport(reportEntity, 導入団体, outputOrder, reportEntity);
//        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
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
//        if (TyohyoShutuyukuOrderKey.郵便番号.get項目ID().equals(項目ID)) {
//            帳票物理名 = new RString("yubinNo");
//        } else if (TyohyoShutuyukuOrderKey.証記載保険者番号.get項目ID().equals(項目ID)) {
//            帳票物理名 = new RString("hokenshaNo");
//        } else if (TyohyoShutuyukuOrderKey.被保険者番号.get項目ID().equals(項目ID)) {
//            帳票物理名 = new RString("listMeisai_2");
//        }
        return 帳票物理名;
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD200005.getReportId().getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD200005.getReportName(),
                new RString(batchReportWriter.getPageCount()),
                new RString("あり"),
                new RString("DBD200005_FutanGendogakuNinteiKakuninIchiran.rse"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(作成年度.concat(parameter.get作成年度().wareki().toDateString()));
        出力条件.add(認定期間_開始日.concat(parameter.get認定期間_開始日().wareki().toDateString()));
        出力条件.add(認定期間_終了日.concat(parameter.get認定期間_終了日().wareki().toDateString()));
        出力条件.add(決定日.concat(parameter.get決定日().wareki().toDateString()));
        出力条件.add(申請日開始.concat(parameter.get申請日開始().wareki().toDateString()));
        出力条件.add(申請日終了.concat(parameter.get申請日終了().wareki().toDateString()));
        if (parameter.is非課税時_承認しないフラグ()) {
            出力条件.add(非課税時_承認しないフラグ.concat(TRUE));
        } else {
            出力条件.add(非課税時_承認しないフラグ.concat(FALSE));
        }
        出力条件.add(非課税時_承認しない理由.concat(parameter.get非課税時_承認しない理由()));
        if (parameter.is配偶者課税時_承認しないフラグ()) {
            出力条件.add(配偶者課税時_承認しないフラグ.concat(TRUE));
        } else {
            出力条件.add(配偶者課税時_承認しないフラグ.concat(FALSE));
        }
        出力条件.add(配偶者課税時_承認しない理由.concat(parameter.get配偶者課税時_承認しない理由()));
        if (parameter.is預貯金等超過時_承認しないフラグ()) {
            出力条件.add(預貯金等超過時_承認しないフラグ.concat(TRUE));
        } else {
            出力条件.add(預貯金等超過時_承認しないフラグ.concat(FALSE));
        }
        出力条件.add(預貯金等超過時_理由.concat(parameter.get預貯金等超過時_理由()));
        if (parameter.isテスト処理()) {
            出力条件.add(テスト処理.concat(TRUE));
        } else {
            出力条件.add(テスト処理.concat(FALSE));
        }
        if (parameter.is確認リスト出力()) {
            出力条件.add(確認リスト出力.concat(TRUE));
        } else {
            出力条件.add(確認リスト出力.concat(FALSE));
        }
        出力条件.add(発行日.concat(parameter.get発行日().wareki().toDateString()));
        出力条件.add(改頁出力順ID.concat(parameter.get改頁出力順ID()));
        出力条件.add(帳票分類ID);
        出力条件.add(帳票ID.concat(parameter.get帳票ID()));
        出力条件.add(帳票作成日時);
        出力条件.add(負担限度額認定申請承認一括.concat(出力順));
        return 出力条件;
    }
}
