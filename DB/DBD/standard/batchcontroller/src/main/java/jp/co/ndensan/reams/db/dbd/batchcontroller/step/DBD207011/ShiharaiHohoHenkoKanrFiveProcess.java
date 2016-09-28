/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoKanrFiveProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuFiveEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoKanrFiveProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuFiveEntity> {

    private static final RString 符号 = new RString("～");

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find帳票印字用データ");

    private ShiharaiHohoHenkoKanrFiveProcessParameter parameter;

    private static final ReportIdDBD REPORT_DBD200007 = ReportIdDBD.DBD200007;

    private static final RString 基準日 = new RString("基準日:");
    private static final RString 登録者選択 = new RString("登録者選択:");
    private static final RString 差止予告登録者２号の選択 = new RString("２号差止予告登録者の選択:");
    private static final RString 差止登録者２号の選択 = new RString("２号差止予告登録者の選択:");
    private static final RString 償還予告登録者１号の選択 = new RString("１号償還予告登録者の選択:");
    private static final RString 償還決定登録者１号の選択 = new RString("１号償還決定登録者の選択:");
    private static final RString 償還決定登録者_差止中あり者のみ１号の選択 = new RString("１号償還決定登録者（差止中あり者のみ）の選択:");
    private static final RString 償還決定登録者_保険料控除あり者のみ１号の選択 = new RString("１号償還決定登録者（保険料控除あり者のみ）の選択:");

    private static final RString 改頁出力順 = new RString("改頁出力順ID:");
    private static final RString 帳票分類ID = new RString("帳票分類ID:");
    private static final RString 帳票ID = new RString("帳票ID:");
    private static final RString 帳票作成日時 = new RString("帳票作成日時:");

    private Association association;
    private IOutputOrder outputOrder;

    @BatchWriter
    private BatchReportWriter<ShiharaiHohoHenkoKanriIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<ShiharaiHohoHenkoKanriIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected void beforeExecute() {
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
                parameter.get帳票ID(), parameter.get改頁出力順ID());
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShiharaiHohoHenkoHaakuFiveMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBD200007.getReportId().value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    int count = 0;
    ShiharaiHohoHenkoEntity reportData;
    ShiharaiHohoHenkoEntity reportData1;

    @Override
    protected void process(ShiharaiHohoHenkoHaakuFiveEntity t) {
        count++;
        if (count == 1) {
            reportData = new ShiharaiHohoHenkoEntity();
            createShiharaiHohoHenkoEntity(t);
        }
        if (count == 2) {
            reportData1 = new ShiharaiHohoHenkoEntity();
            createShiharaiHohoHenkoEntity(t);

            ShiharaiHohoHenkoKanriIchiranReport finder = new ShiharaiHohoHenkoKanriIchiranReport(RDateTime.now(),
                    HokenshaNo.EMPTY, RString.EMPTY, outputOrder, reportData, reportData1);

            finder.writeBy(reportSourceWriter);
            count = 0;
        }
    }

    private ShiharaiHohoHenkoEntity createShiharaiHohoHenkoEntity(ShiharaiHohoHenkoHaakuFiveEntity t) {

        reportData.set被保険者番号(HihokenshaNo.EMPTY);
        reportData.set識別コード(ShikibetsuCode.EMPTY);
        reportData.set被保険者氏名カナ(t.get支払方法変更情報_被保険者氏名カナ());
        reportData.set被保険者氏名(t.get支払方法変更情報_被保険者氏名());
        reportData.set世帯番号(t.get支払方法変更情報_世帯番号());
        reportData.set行政区ｺｰﾄﾞ(t.get支払方法変更情報_行政区コード().getColumnValue());
        reportData.set行政区(t.get支払方法変更情報_行政区());
        reportData.set住所コード(t.get支払方法変更情報_住所());
        reportData.set郵便番号(t.get支払方法変更情報_郵便番号());
        reportData.set住所(t.get支払方法変更情報_住所());

        reportData.set資格取得日(t.get支払方法変更情報_資格取得日());
        reportData.set資格喪失日(t.get支払方法変更情報_資格喪失日());
        reportData.set喪失事由(ShikakuSoshitsuJiyu.toValue(t.get支払方法変更情報_喪失事由()));
        if (t.get支払方法変更情報_申請中() != null && !t.get支払方法変更情報_申請中().isEmpty()) {
            reportData.set資格区分(ShikakuKubun.toValue(t.get支払方法変更情報_申請中()));
        }

        reportData.set住特フラグ(new RString(t.get支払方法変更情報_住特フラグ().toString()));
        reportData.set生保(t.get支払方法変更情報_生保());

        reportData.set要介護度(t.get支払方法変更情報_要介護度().value());
        RStringBuilder builder = new RStringBuilder();
        builder.append(t.get支払方法変更情報_認定開始年月日().toString()).append("～").append(t.get支払方法変更情報_認定終了年月日().toString());
        reportData.set認定有効期間(builder.toRString());
        reportData.set認定日(t.get支払方法変更情報_認定終了年月日());
        reportData.set認定情報_申請中(t.get支払方法変更情報_申請中());
        reportData.set申請日(t.get支払方法変更情報_申請日());
        reportData.set償還未払い情報_申請中(t.get償還未払い_申請中());
        reportData.set償還未払い情報_申請日(t.get償還未払い_申請日());
        reportData.set申請中件数(new RString(t.get償還未払い_申請中件数()));
        if (t.get償還未払い_整理番号() != null && !t.get償還未払い_整理番号().isEmpty()) {
            reportData.set整理番号(new Code(t.get償還未払い_整理番号()));
        }
        if (t.get償還未払い_提供年月() != null && !t.get償還未払い_提供年月().isEmpty()) {
            reportData.set提供年月(new FlexibleYearMonth(t.get償還未払い_提供年月().toDateString()));
        }

        reportData.set未通知件数(new RString(t.get償還未払い_未通知件数()));

        // TODO 滞納管理状況  終了状況
//        reportData.set滞納管理状況();
        reportData.set最長滞納期間(new RString(String.valueOf(t.get収納状況_最長滞納期間())));
        reportData.set以前滞納額(t.get収納状況_以前滞納額());
//        reportData.set以前滞納区分(TainoKubun.toValue(t.get収納状況_以前滞納区分()));
//        reportData.set終了状況();

        reportData.set適用終了日_2行目(t.get滞納者対策情報_適用終了日());
        reportData.set終了受付日_3行目(t.get滞納者対策情報_終了受付日());
        reportData.set予告発行日_4行目(t.get滞納者対策情報_予告発行日());
        reportData.set弁明期限_5行目(t.get滞納者対策情報_弁明期限());
        reportData.set弁明受付日_6行目(t.get滞納者対策情報_弁明受付日());
        reportData.set償還発行日_7行目(t.get滞納者対策情報_償還発行日());

        if (0 != t.get滞納者対策情報_償還証期限()) {
            reportData.set償還証期限_8行目(new FlexibleDate(String.valueOf(t.get滞納者対策情報_償還証期限())));
        }

        reportData.set差止中件数_9行目(new RString(t.get滞納者対策情報_差止中件数()));
        reportData.set差止中金額_10行目((t.get滞納者対策情報_差止中金額()));

        reportData.set差止納付期日_11行目((t.get滞納者対策情報_差止納付期日()));
        reportData.set控除件数_12行目(new RString(t.get滞納者対策情報_控除件数()));
        reportData.set控除証期限_13行目((t.get滞納者対策情報_控除証期限()));
        reportData.set行14(RString.EMPTY);
        reportData.set行15(RString.EMPTY);
        reportData.set行16(RString.EMPTY);
        reportData.set行17(RString.EMPTY);

        return reportData;
    }

    @Override
    protected void afterExecute() {
        if (count == 1) {
            ShiharaiHohoHenkoKanriIchiranReport finder = new ShiharaiHohoHenkoKanriIchiranReport(RDateTime.now(),
                    HokenshaNo.EMPTY, RString.EMPTY, outputOrder, reportData, new ShiharaiHohoHenkoEntity());

            finder.writeBy(reportSourceWriter);
        }
        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString csv出力有無 = new RString("無し");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
        RString 日本語ファイル名 = REPORT_DBD200007.getReportName();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                REPORT_DBD200007.getReportId().value(),
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

    private RString edit認定有効期間(FlexibleDate 認定有効期間開始年月日, FlexibleDate 認定有効期間終了年月日) {
        StringBuilder builder = new StringBuilder();

        if (認定有効期間開始年月日 != null && !FlexibleDate.EMPTY.equals(認定有効期間開始年月日)) {
            builder.append(認定有効期間開始年月日);
        }
        builder.append(符号);
        if (認定有効期間終了年月日 != null && !FlexibleDate.EMPTY.equals(認定有効期間終了年月日)) {
            builder.append(認定有効期間終了年月日);
        }
        return new RString(builder.toString());
    }

    private RString edit収納収納情報なし(FlexibleYear 賦課年度) {
        if (賦課年度 == null || FlexibleYear.EMPTY.equals(賦課年度)) {
            return new RString("1");
        }
        return RString.EMPTY;
    }

    private List<RString> get出力条件内容() {
        List<RString> result = new ArrayList<>();
        result.add(基準日.concat(parameter.get基準日().toString()));
        result.add(登録者選択.concat(parameter.get登録者選択().toString()));
        result.add(差止予告登録者２号の選択.concat(parameter.get差止予告登録者２号の選択()));
        result.add(差止登録者２号の選択.concat(parameter.get差止登録者２号の選択()));
        result.add(償還予告登録者１号の選択.concat(parameter.get償還予告登録者１号の選択()));
        result.add(償還決定登録者１号の選択.concat(parameter.get償還決定登録者１号の選択()));
        result.add(償還決定登録者_差止中あり者のみ１号の選択.concat(parameter.get差止中あり者のみの選択()));
        result.add(償還決定登録者_保険料控除あり者のみ１号の選択.concat(parameter.get保険料控除あり者のみの選択()));

        result.add(改頁出力順.concat(edit改頁出力順ID(parameter.get改頁出力順ID())));
        result.add(帳票分類ID.concat(parameter.get帳票分類ID().getColumnValue()));
        result.add(帳票ID.concat(parameter.get帳票ID().getColumnValue()));
        result.add(帳票作成日時.concat(parameter.get帳票作成日時().toString()));
        return result;
    }

    private RString edit改頁出力順ID(Long 改頁出力順ID) {
        if (改頁出力順ID != null) {
            return new RString(parameter.get改頁出力順ID());
        }
        return RString.EMPTY;
    }
}
