/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoHaakoFiveProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuFiveEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoHaakuFiveProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuFiveEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find帳票印字用データ");

    private ShiharaiHohoHenkoHaakoFiveProcessParameter parameter;

    private static final ReportIdDBD REPORT_DBD200006 = ReportIdDBD.DBD200006;

//    private static final RString 基準日 = new RString("【基準日】 ");
//    private static final RString 被保険者選択 = new RString("【抽出対象】 被保険者全員");
//    private static final RString 滞納期間 = new RString("【滞納期間】");
//    private static final RString ヵ月経過 = new RString("ヵ月経過");
//    private static final RString 受給者全員 = new RString("【抽出対象】 受給者全員");
//    private static final RString 受給認定申請中者 = new RString("【抽出対象】 受給認定申請中者");
//    private static final RString 受給認定日抽出 = new RString("【抽出方法】 受給認定日抽出");
//    private static final RString 受給認定日抽出の開始 = new RString("【抽出対象】 償還申請中者");
//    private static final RString 受給認定日抽出の終了 = new RString("【抽出方法】 償還支給決定日抽出");
//    private static final RString 受給申請中者 = new RString("受給申請中者:");
//    private static final RString 受給支給決定日抽出 = new RString("受給申請中者の滞納期間:");
//    private static final RString 受給支給決定日抽出の開始 = new RString("受給支給決定日抽出の開始:");
//    private static final RString 受給支給決定日抽出の終了 = new RString("受給支給決定日抽出の終了:");
    private Association association;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShiharaiHohoHenkoHaakuFiveMybatisParameter());
    }

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void process(ShiharaiHohoHenkoHaakuFiveEntity t) {
        // TODO 介護保険　支払方法変更把握リスト帳票スプール
    }

    @Override
    protected void afterExecute() {

        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString csv出力有無 = new RString("無し");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        // TODO
        RString 出力ページ数 = new RString("1");
        RString 日本語ファイル名 = REPORT_DBD200006.getReportName();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                REPORT_DBD200006.getReportId().value(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                日本語ファイル名,
                出力ページ数,
                csv出力有無,
                RString.EMPTY,
                get出力条件内容());
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private List<RString> get出力条件内容() {
        List<RString> result = new ArrayList<>();

        return result;
    }

//    private RString edit日期(FlexibleDate 日期) {
//        if (日期 != null && !日期.isEmpty()) {
//            return new RString(日期.toString());
//        }
//        return RString.EMPTY;
//    }
}
