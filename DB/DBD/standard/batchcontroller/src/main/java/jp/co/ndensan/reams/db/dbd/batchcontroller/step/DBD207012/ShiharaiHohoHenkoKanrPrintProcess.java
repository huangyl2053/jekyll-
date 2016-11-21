/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207012;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.dbd207011.ShiharaiHohoHenkoHaakuOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReport;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TainoKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoKanrFiveProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuFiveEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShunoStatusJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShunoKibetsuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShunoNendoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
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
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoKanrPrintProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuFiveEntity> {

    private static final RString より = new RString("＞");

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find帳票印字用データ");

    private ShiharaiHohoHenkoKanrFiveProcessParameter parameter;

    private static final ReportIdDBD REPORT_DBD200007 = ReportIdDBD.DBD200007;

    private static final RString 選択あり = new RString("0");
    private static final RString SELECTED_VALUE_0 = new RString("0");
    private static final RString SELECTED_VALUE_1 = new RString("1");
    private static final RString SELECTED_VALUE_2 = new RString("2");
    private static final RString SELECTED_VALUE_3 = new RString("3");
    private static final RString SELECTED_VALUE_4 = new RString("4");
    private static final RString SELECTED_VALUE_5 = new RString("5");
    private static final RString SELECTED_VALUE_6 = new RString("6");

    private static final RString 申請中 = new RString("申請中");

    private static final RString 基準日 = new RString("【基準日】");
    private static final RString 抽出対象 = new RString("【抽出対象】 ");
    private static final RString 登録者選択 = new RString("【抽出対象】 全登録者");
    private static final RString 差止予告登録者２号の選択 = new RString("２号差止予告登録者");
    private static final RString 差止登録者２号の選択 = new RString("２号差止登録者");
    private static final RString 償還予告登録者１号の選択 = new RString("１号償還予告登録者");
    private static final RString 償還決定登録者１号の選択 = new RString("１号償還決定登録者");
    private static final RString 償還決定登録者_差止中あり者のみ１号の選択 = new RString("１号償還決定登録者（差止中あり者のみ");
    private static final RString 償還決定登録者_保険料控除あり者のみ１号の選択 = new RString("１号償還決定登録者（保険料控除あり者のみ）");

    private static final RString 全て = new RString("全て");
    private static final RString 通知書未発行のみ = new RString("通知書未発行のみ");
    private static final RString 適用中者のみ = new RString("適用中者のみ");
    private static final RString 適用終了者のみ = new RString("適用終了者のみ");
    private static final RString 適用中者滞納保険料なしのみ = new RString("適用中者（滞納保険料なし）のみ");
    private static final RString 滞納保険料なしのみ = new RString("滞納保険料なしのみ");

    private static final RString バッチ出力条件出力順 = new RString("出力順:");
    private static final int 帳票期別リストSIZE = 3;
    private Association association;
    private IOutputOrder outputOrder;
    private RString 出力順;
    private List<PersonalData> personalDataList;

    @BatchWriter
    private BatchReportWriter<ShiharaiHohoHenkoKanriIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<ShiharaiHohoHenkoKanriIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        personalDataList = new ArrayList<>();
        association = AssociationFinderFactory.createInstance().getAssociation();
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
                parameter.get帳票ID(), parameter.get改頁出力順ID());
        出力順 = get出力順(outputOrder);
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);

        IShikibetsuTaishoPSMSearchKey psmShikibetsuTaisho = key.build();
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShiharaiHohoHenkoHaakuFiveMybatisParameter(psmShikibetsuTaisho, 出力順));
    }

    @Override
    protected void createWriter() {
        batchReportWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBD200007.getReportId().value(),
                SubGyomuCode.DBD介護受給).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    ShiharaiHohoHenkoEntity reportData;
    ShiharaiHohoHenkoEntity reportData1;

    @Override
    protected void process(ShiharaiHohoHenkoHaakuFiveEntity t) {
        if (reportData == null && reportData1 == null) {
            reportData = new ShiharaiHohoHenkoEntity();
            createShiharaiHohoHenkoEntity(t, reportData);
        } else {
            reportData1 = new ShiharaiHohoHenkoEntity();
            createShiharaiHohoHenkoEntity(t, reportData1);

            if (is改頁()) {
                ShiharaiHohoHenkoKanriIchiranReport finder = new ShiharaiHohoHenkoKanriIchiranReport(RDateTime.now(),
                        new HokenshaNo(association.get地方公共団体コード().value()), association.get市町村名(),
                        outputOrder, reportData, new ShiharaiHohoHenkoEntity(), REPORT_DBD200007);
                finder.writeBy(reportSourceWriter);
                reportData = reportData1;
                reportData1 = null;
            } else {
                ShiharaiHohoHenkoKanriIchiranReport finder = new ShiharaiHohoHenkoKanriIchiranReport(RDateTime.now(),
                        new HokenshaNo(association.get地方公共団体コード().value()), association.get市町村名(),
                        outputOrder, reportData, reportData1, REPORT_DBD200007);
                finder.writeBy(reportSourceWriter);
                reportData = null;
                reportData1 = null;
            }
        }
        personalDataList.add(toPersonalData(t));
    }

    private boolean is改頁() {
        List<RString> 改頁IDList = new ArrayList<>();
        if (outputOrder == null || outputOrder.get設定項目リスト() == null || outputOrder.get設定項目リスト().isEmpty()) {
            return false;
        }
        List<ISetSortItem> list = outputOrder.get設定項目リスト();
        for (ISetSortItem data : list) {
            if (data.is改頁項目()) {
                改頁IDList.add(data.get項目ID());
            }
        }
        return is改頁項目_1(改頁IDList) || is改頁項目_2(改頁IDList);
    }

    private boolean is改頁項目_1(List<RString> 改頁IDList) {
        return (改頁IDList.contains(ShiharaiHohoHenkoHaakuOrderKey.郵便番号.get項目ID())
                && !reportData.get郵便番号().equals(reportData1.get郵便番号()))
                || (改頁IDList.contains(ShiharaiHohoHenkoHaakuOrderKey.町域コード.get項目ID())
                && !reportData.get町域コード().equals(reportData1.get町域コード()))
                || (改頁IDList.contains(ShiharaiHohoHenkoHaakuOrderKey.行政区コード.get項目ID())
                && !reportData.get行政区コード().equals(reportData1.get行政区コード()))
                || (改頁IDList.contains(ShiharaiHohoHenkoHaakuOrderKey.世帯コード.get項目ID())
                && !reportData.get世帯番号().equals(reportData1.get世帯番号()));
    }

    private boolean is改頁項目_2(List<RString> 改頁IDList) {
        return (改頁IDList.contains(ShiharaiHohoHenkoHaakuOrderKey.識別コード.get項目ID())
                && !reportData.get識別コード().equals(reportData1.get識別コード()))
                || (改頁IDList.contains(ShiharaiHohoHenkoHaakuOrderKey.氏名５０音カナ.get項目ID())
                && !reportData.get被保険者氏名カナ().equals(reportData1.get被保険者氏名カナ()))
                || (改頁IDList.contains(ShiharaiHohoHenkoHaakuOrderKey.市町村コード.get項目ID())
                && !reportData.get市町村コード().equals(reportData1.get市町村コード()))
                || (改頁IDList.contains(ShiharaiHohoHenkoHaakuOrderKey.被保険者番号.get項目ID())
                && !reportData.get被保険者番号().equals(reportData1.get被保険者番号()));
    }

    private RString get出力順(IOutputOrder order) {
        if (order != null) {
            RString 出力順 = MyBatisOrderByClauseCreator.create(ShiharaiHohoHenkoHaakuOrderKey.class, order);
            return 出力順.concat(",対象者情報_被保険者番号,"
                    + "収納状況_調定年度,収納状況_賦課年度"
                    + ",収納状況_通知書番号,収納状況_期");
        }
        return new RString("order by 対象者情報_被保険者番号,"
                + "収納状況_調定年度,収納状況_賦課年度"
                + ",収納状況_通知書番号,収納状況_期");
    }

    private ShiharaiHohoHenkoEntity createShiharaiHohoHenkoEntity(ShiharaiHohoHenkoHaakuFiveEntity t, ShiharaiHohoHenkoEntity reportDataEntity) {

        reportDataEntity.set被保険者番号(t.get対象者情報_被保険者番号());

        edit宛名情報について(t, reportDataEntity);
        edit資格情報について(t, reportDataEntity);
        edit生活保護受給者について(t, reportDataEntity);
        edit認定情報について(t, reportDataEntity);
        edit償還情報について(t, reportDataEntity);
        edit滞納者対策情報について(t, reportDataEntity);
        List<ShunoStatusJohoEntity> 収納状況情報List = t.get収納状況情報リスト();
        if (収納状況情報List != null && !収納状況情報List.isEmpty()) {
            reportDataEntity.set収納情報List(edit収納情報List(収納状況情報List));
        } else {
            reportDataEntity.set収納情報なし(new RString("1"));
        }
        return reportDataEntity;
    }

    @Override
    protected void afterExecute() {
        if (reportData != null) {
            ShiharaiHohoHenkoKanriIchiranReport finder = new ShiharaiHohoHenkoKanriIchiranReport(RDateTime.now(),
                    new HokenshaNo(association.get地方公共団体コード().value()), association.get市町村名(),
                    outputOrder, reportData, new ShiharaiHohoHenkoEntity(), REPORT_DBD200007);

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

        AccessLogUUID reportLog = AccessLogger.logReport(personalDataList);
        batchReportWrite.addPrivacy(reportLog);
    }

    private void edit宛名情報について(ShiharaiHohoHenkoHaakuFiveEntity t, ShiharaiHohoHenkoEntity reportDataEntity) {
        if (t.get宛名情報() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.get宛名情報());

            reportDataEntity.set識別コード(kojin.get識別コード());
            reportDataEntity.set被保険者氏名カナ(kojin.get名称().getKana().value());
            reportDataEntity.set被保険者氏名(kojin.get名称().getName().value());

            if (kojin.get世帯コード() != null && !kojin.get世帯コード().isEmpty()) {
                reportDataEntity.set世帯番号(new Code(kojin.get世帯コード().getColumnValue()));
            } else {
                reportDataEntity.set世帯番号(new Code(RString.EMPTY));
            }
            reportDataEntity.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            reportDataEntity.set行政区(kojin.get行政区画().getGyoseiku().get名称());
            reportDataEntity.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
            reportDataEntity.set郵便番号(kojin.get住所().get郵便番号());
            reportDataEntity.set住所(kojin.get住所().get住所());
            reportDataEntity.set町域コード(kojin.get住所().get町域コード().getColumnValue());
        } else {
            reportDataEntity.set識別コード(ShikibetsuCode.EMPTY);
            reportDataEntity.set被保険者氏名カナ(RString.EMPTY);
            reportDataEntity.set被保険者氏名(RString.EMPTY);
            reportDataEntity.set世帯番号(new Code(RString.EMPTY));

            reportDataEntity.set行政区コード(RString.EMPTY);
            reportDataEntity.set行政区(RString.EMPTY);
            reportDataEntity.set住所コード(RString.EMPTY);
            reportDataEntity.set郵便番号(new YubinNo(RString.EMPTY));
            reportDataEntity.set住所(RString.EMPTY);
            reportDataEntity.set町域コード(RString.EMPTY);
        }
    }

    private void edit資格情報について(ShiharaiHohoHenkoHaakuFiveEntity t, ShiharaiHohoHenkoEntity reportDataEntity) {
        reportDataEntity.set資格取得日(t.get資格情報_資格取得年月日());
        reportDataEntity.set資格喪失日(t.get資格情報_資格喪失年月日());
        reportDataEntity.set喪失事由(ShikakuSoshitsuJiyu.toValue(t.get資格情報_資格喪失事由コード()));
        if (t.get資格情報_被保険者区分コード() != null && !t.get資格情報_被保険者区分コード().isEmpty()) {
            reportDataEntity.set資格区分(ShikakuKubun.toValue(t.get資格情報_被保険者区分コード()));
        }
        reportDataEntity.set住特フラグ(t.get資格情報_住所地特例フラグ());
    }

    private void edit生活保護受給者について(ShiharaiHohoHenkoHaakuFiveEntity t, ShiharaiHohoHenkoEntity reportDataEntity) {
        if (t.get生活保護受給者_識別コード() != null && !ShikibetsuCode.EMPTY.equals(t.get生活保護受給者_識別コード())) {
            reportDataEntity.set生保(true);
        } else {
            reportDataEntity.set生保(false);
        }
    }

    private void edit認定情報について(ShiharaiHohoHenkoHaakuFiveEntity t, ShiharaiHohoHenkoEntity reportDataEntity) {

        if (t.get認定情報_要介護認定状態区分コード() != null && !Code.EMPTY.equals(t.get認定情報_要介護認定状態区分コード())) {
            reportDataEntity.set要介護度(YokaigoJotaiKubun.toValue(t.get認定情報_要介護認定状態区分コード().getColumnValue()).get略称());
        }

        RStringBuilder builder = new RStringBuilder();
        if (t.get認定情報_認定有効期間開始年月日() != null && !t.get認定情報_認定有効期間開始年月日().isEmpty()
                || (t.get認定情報_認定有効期間終了年月日() != null && t.get認定情報_認定有効期間終了年月日().isEmpty())) {
            builder.append(t.get認定情報_認定有効期間開始年月日()).append("～").append(t.get認定情報_認定有効期間終了年月日());
        }
        reportDataEntity.set認定有効期間(builder.toRString());
        reportDataEntity.set認定日(t.get償還未払い_申請日());

        if (t.get申請中認定情報_被保険者番号() != null) {
            reportDataEntity.set認定情報_申請中(申請中);
        } else {
            reportDataEntity.set認定情報_申請中(RString.EMPTY);
        }
    }

    private void edit償還情報について(ShiharaiHohoHenkoHaakuFiveEntity t, ShiharaiHohoHenkoEntity reportDataEntity) {
        reportDataEntity.set申請日(t.get償還未払い_申請日());
        reportDataEntity.set償還未払い情報_申請中(t.get償還未払い_申請中());
        reportDataEntity.set償還未払い情報_申請日(t.get償還未払い_申請日());
        reportDataEntity.set申請中件数(new RString(t.get償還未払い_申請中件数()));
        if (t.get償還未払い_整理番号() != null && !t.get償還未払い_整理番号().isEmpty()) {
            reportDataEntity.set整理番号(new Code(t.get償還未払い_整理番号()));
        }
        if (t.get償還未払い_提供年月() != null && !t.get償還未払い_提供年月().isEmpty()) {
            reportDataEntity.set提供年月(new FlexibleYearMonth(t.get償還未払い_提供年月().toDateString()));
        }
        reportDataEntity.set未通知件数(new RString(t.get償還未払い_未通知件数()));
    }

    private void edit滞納者対策情報について(ShiharaiHohoHenkoHaakuFiveEntity t, ShiharaiHohoHenkoEntity reportDataEntity) {
        if (t.get滞納者対策情報_登録区分() != null && !RString.EMPTY.equals(t.get滞納者対策情報_登録区分())) {
            reportDataEntity.set滞納管理状況(ShiharaiHenkoTorokuKubun.toValue(t.get滞納者対策情報_登録区分()));
        }

        if (t.get収納状況情報リスト() != null && !t.get収納状況情報リスト().isEmpty()) {
            ShunoStatusJohoEntity 収納状況情報 = t.get収納状況情報リスト().get(0);
            reportDataEntity.set最長滞納期間(new RString(String.valueOf(収納状況情報.get収納状況_最長滞納期間())));
            reportDataEntity.set以前滞納額(収納状況情報.get収納状況_以前滞納額());
            if (収納状況情報.get収納状況_以前滞納区分() != null && !収納状況情報.get収納状況_以前滞納区分().isEmpty()) {
                reportDataEntity.set以前滞納区分(TainoKubun.toValue(収納状況情報.get収納状況_以前滞納区分()));
            }
        }
        if (t.get滞納者対策情報_終了区分() != null && !RString.EMPTY.equals(t.get滞納者対策情報_終了区分())) {
            reportDataEntity.set終了状況(ShiharaiHenkoShuryoKubun.toValue(t.get滞納者対策情報_終了区分()));
        }

        reportDataEntity.set適用終了日_2行目(t.get滞納者対策情報_適用終了日());
        reportDataEntity.set終了受付日_3行目(t.get滞納者対策情報_終了受付日());
        reportDataEntity.set予告発行日_4行目(t.get滞納者対策情報_予告発行日());
        reportDataEntity.set弁明期限_5行目(t.get滞納者対策情報_弁明期限());
        reportDataEntity.set弁明受付日_6行目(t.get滞納者対策情報_弁明受付日());
        reportDataEntity.set償還発行日_7行目(t.get滞納者対策情報_償還発行日());
        reportDataEntity.set償還証期限_8行目(t.get滞納者対策情報_償還証期限());

        reportDataEntity.set差止中件数_9行目(new RString(t.get滞納者対策情報_差止中件数()));
        reportDataEntity.set差止中金額_10行目((t.get滞納者対策情報_差止中金額()));

        reportDataEntity.set差止納付期日_11行目((t.get滞納者対策情報_差止納付期日()));
        reportDataEntity.set控除件数_12行目(new RString(t.get滞納者対策情報_控除件数()));
        reportDataEntity.set控除証期限_13行目((t.get滞納者対策情報_控除証期限()));
        reportDataEntity.set行14(RString.EMPTY);
        reportDataEntity.set行15(RString.EMPTY);
        reportDataEntity.set行16(RString.EMPTY);
        reportDataEntity.set行17(RString.EMPTY);

    }

    private FlexibleDate edit日期(RDate 納期限) {
        if (納期限 != null) {
            return new FlexibleDate(納期限.toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    private List<ShunoNendoEntity> edit収納情報List(List<ShunoStatusJohoEntity> 収納状況情報List) {

        List<FlexibleYear> 賦課年度List = new ArrayList<>();
        RString configValue = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        FlexibleYear 日付関連_調定年度 = new FlexibleYear(configValue);

        List<ShunoNendoEntity> 帳票用収納状況情報List = new ArrayList<>();
        Map<FlexibleYear, List<ShunoStatusJohoEntity>> 収納状況情報Map = new HashMap<>();
        for (ShunoStatusJohoEntity 収納状況情報Data : 収納状況情報List) {
            if (収納状況情報Map.containsKey(収納状況情報Data.get収納状況_賦課年度())) {
                収納状況情報Map.get(収納状況情報Data.get収納状況_賦課年度()).add(収納状況情報Data);
            } else {
                List<ShunoStatusJohoEntity> new収納状況情報List = new ArrayList<>();
                new収納状況情報List.add(収納状況情報Data);
                収納状況情報Map.put(収納状況情報Data.get収納状況_賦課年度(), new収納状況情報List);
                賦課年度List.add(収納状況情報Data.get収納状況_賦課年度());
            }
        }
        for (FlexibleYear 賦課年度 : 賦課年度List) {
            List<ShunoStatusJohoEntity> 賦課収納状況情報List = 収納状況情報Map.get(賦課年度);
            List<ShunoKibetsuEntity> 期別情報List = new ArrayList<>();
            ShunoNendoEntity 帳票用収納状況情報 = new ShunoNendoEntity();
            for (ShunoStatusJohoEntity 収納状況情報Data : 賦課収納状況情報List) {
                if (収納状況情報Data.is収納状況_過年度フラグ()) {
                    帳票用収納状況情報.set過年度フラグ(true);
                    ShunoKibetsuEntity 過年度期別情報 = new ShunoKibetsuEntity();
                    過年度期別情報.set滞納額(収納状況情報Data.get収納状況_調定額());
                    過年度期別情報.set時効起算日(収納状況情報Data.get収納状況_時効起算日());
                    過年度期別情報.set時効起算事由(収納状況情報Data.get収納状況_時効起算事由());
                    過年度期別情報.set納期限(edit日期(収納状況情報Data.get収納状況_納期限()));
                    帳票用収納状況情報.set過年度期別情報(過年度期別情報);
                    帳票用収納状況情報.set賦課年度(賦課年度);
                    帳票用収納状況情報.set過年度フラグ(true);
                } else {
                    帳票用収納状況情報.set過年度フラグ(false);
                    ShunoKibetsuEntity 期別情報 = new ShunoKibetsuEntity();
                    期別情報.set期別(new RString(収納状況情報Data.get収納状況_期()));
                    期別情報.set保険料金(収納状況情報Data.get収納状況_調定額());
                    期別情報.set納期限(edit日期(収納状況情報Data.get収納状況_納期限()));
                    期別情報.set滞納額(収納状況情報Data.get収納状況_未納額());
                    if (収納状況情報Data.get収納状況_滞納区分() != null) {
                        期別情報.set滞納区分(TainoKubun.toValue(収納状況情報Data.get収納状況_滞納区分()));
                    }

                    期別情報.set時効起算日(収納状況情報Data.get収納状況_時効起算日());
                    期別情報.set時効起算事由(収納状況情報Data.get収納状況_時効起算事由());
                    期別情報List.add(期別情報);
                    帳票用収納状況情報.set賦課年度(賦課年度);
                    帳票用収納状況情報.set期別情報(期別情報List);
                }
            }

            if (帳票用収納状況情報.get賦課年度().equals(日付関連_調定年度.minusYear(2))) {
                帳票用収納状況情報List.add(帳票用収納状況情報);
            }

            if (帳票用収納状況情報.get賦課年度().equals(日付関連_調定年度.minusYear(1))) {
                帳票用収納状況情報List.add(帳票用収納状況情報);
            }

            if (帳票用収納状況情報.get賦課年度().equals(日付関連_調定年度)) {
                帳票用収納状況情報List.add(帳票用収納状況情報);
            }

        }
        return getNew帳票用収納状況情報List(帳票用収納状況情報List, 日付関連_調定年度);
    }

    private List<ShunoNendoEntity> getNew帳票用収納状況情報List(List<ShunoNendoEntity> old帳票用収納状況情報List, FlexibleYear 日付関連_調定年度) {
        List<ShunoNendoEntity> new帳票用収納状況情報List = new ArrayList<>();

        ShunoNendoEntity 収納状況minus2 = null;
        ShunoNendoEntity 収納状況minus1 = null;
        ShunoNendoEntity 収納状況equal調定年度 = null;

        for (ShunoNendoEntity data : old帳票用収納状況情報List) {
            if (data.get賦課年度().equals(日付関連_調定年度.minusYear(2))) {
                収納状況minus2 = data;
            }
            if (data.get賦課年度().equals(日付関連_調定年度.minusYear(1))) {
                収納状況minus1 = data;
            }
            if (data.get賦課年度().equals(日付関連_調定年度)) {
                収納状況equal調定年度 = data;
            }
        }

        if (収納状況minus2 == null) {
            new帳票用収納状況情報List.add(new ShunoNendoEntity());
        } else {
            new帳票用収納状況情報List.add(収納状況minus2);
        }
        if (収納状況minus1 == null) {
            new帳票用収納状況情報List.add(new ShunoNendoEntity());
        } else {
            new帳票用収納状況情報List.add(収納状況minus1);
        }
        if (収納状況equal調定年度 == null) {
            new帳票用収納状況情報List.add(new ShunoNendoEntity());
        } else {
            new帳票用収納状況情報List.add(収納状況equal調定年度);
        }

        return new帳票用収納状況情報List;
    }

    private List<RString> get出力条件内容() {
        List<RString> result = new ArrayList<>();
        result.add(基準日.concat(format日期(parameter.get基準日())));
        if (選択あり.equals(parameter.get登録者選択())) {
            result.add(登録者選択);
        } else if (SELECTED_VALUE_1.equals(parameter.get登録者選択())) {
            出力条件_差止予告登録者２号の選択(result);
        } else if (SELECTED_VALUE_2.equals(parameter.get登録者選択())) {
            出力条件_差止登録者２号の選択(result);
        } else if (SELECTED_VALUE_3.equals(parameter.get登録者選択())) {
            出力条件_償還予告登録者１号の選択(result);
        } else if (SELECTED_VALUE_4.equals(parameter.get登録者選択())) {
            出力条件_償還決定登録者１号の選択(result);
        } else if (SELECTED_VALUE_5.equals(parameter.get登録者選択())) {
            出力条件_差止中あり者のみ１号の選択(result);
        } else if (SELECTED_VALUE_6.equals(parameter.get登録者選択())) {
            出力条件_保険料控除あり者のみ１号の選択(result);
        }

        RString 設定項目 = RString.EMPTY;
        if (outputOrder != null) {
            for (int i = 0; i < outputOrder.get設定項目リスト().size(); i++) {
                ISetSortItem item = outputOrder.get設定項目リスト().get(i);
                if (0 == i) {
                    設定項目 = item.get項目名();
                } else {
                    設定項目 = 設定項目.concat(より).concat(item.get項目名());
                }
            }
        }
        if (!RString.EMPTY.equals(設定項目)) {
            result.add(バッチ出力条件出力順.concat(設定項目));
        }

        return result;
    }

    private void 出力条件_差止予告登録者２号の選択(List<RString> result) {
        if (SELECTED_VALUE_0.equals(parameter.get差止予告登録者２号の選択())) {
            result.add(抽出対象.concat(差止予告登録者２号の選択).concat(RString.FULL_SPACE).concat(全て));
        } else if (SELECTED_VALUE_1.equals(parameter.get差止予告登録者２号の選択())) {
            result.add(抽出対象.concat(差止予告登録者２号の選択).concat(RString.FULL_SPACE).concat(通知書未発行のみ));
        } else if (SELECTED_VALUE_2.equals(parameter.get差止予告登録者２号の選択())) {
            result.add(抽出対象.concat(差止予告登録者２号の選択).concat(RString.FULL_SPACE).concat(適用中者のみ));
        } else if (SELECTED_VALUE_3.equals(parameter.get差止予告登録者２号の選択())) {
            result.add(抽出対象.concat(差止予告登録者２号の選択).concat(RString.FULL_SPACE).concat(適用終了者のみ));
        }
    }

    private void 出力条件_差止登録者２号の選択(List<RString> result) {
        if (SELECTED_VALUE_0.equals(parameter.get差止登録者２号の選択())) {
            result.add(抽出対象.concat(差止登録者２号の選択).concat(RString.FULL_SPACE).concat(全て));
        } else if (SELECTED_VALUE_1.equals(parameter.get差止登録者２号の選択())) {
            result.add(抽出対象.concat(差止登録者２号の選択).concat(RString.FULL_SPACE).concat(通知書未発行のみ));
        } else if (SELECTED_VALUE_2.equals(parameter.get差止登録者２号の選択())) {
            result.add(抽出対象.concat(差止登録者２号の選択).concat(RString.FULL_SPACE).concat(適用中者のみ));
        } else if (SELECTED_VALUE_3.equals(parameter.get差止登録者２号の選択())) {
            result.add(抽出対象.concat(差止登録者２号の選択).concat(RString.FULL_SPACE).concat(適用終了者のみ));
        }
    }

    private void 出力条件_償還予告登録者１号の選択(List<RString> result) {
        if (SELECTED_VALUE_0.equals(parameter.get償還予告登録者１号の選択())) {
            result.add(抽出対象.concat(償還予告登録者１号の選択).concat(RString.FULL_SPACE).concat(全て));
        } else if (SELECTED_VALUE_1.equals(parameter.get償還予告登録者１号の選択())) {
            result.add(抽出対象.concat(償還予告登録者１号の選択).concat(RString.FULL_SPACE).concat(通知書未発行のみ));
        } else if (SELECTED_VALUE_2.equals(parameter.get償還予告登録者１号の選択())) {
            result.add(抽出対象.concat(償還予告登録者１号の選択).concat(RString.FULL_SPACE).concat(適用中者のみ));
        } else if (SELECTED_VALUE_3.equals(parameter.get償還予告登録者１号の選択())) {
            result.add(抽出対象.concat(償還予告登録者１号の選択).concat(RString.FULL_SPACE).concat(適用中者滞納保険料なしのみ));
        } else if (SELECTED_VALUE_4.equals(parameter.get償還予告登録者１号の選択())) {
            result.add(抽出対象.concat(償還予告登録者１号の選択).concat(RString.FULL_SPACE).concat(適用終了者のみ));
        }
    }

    private void 出力条件_償還決定登録者１号の選択(List<RString> result) {
        if (SELECTED_VALUE_0.equals(parameter.get償還決定登録者１号の選択())) {
            result.add(抽出対象.concat(償還決定登録者１号の選択).concat(RString.FULL_SPACE).concat(全て));
        } else if (SELECTED_VALUE_1.equals(parameter.get償還決定登録者１号の選択())) {
            result.add(抽出対象.concat(償還決定登録者１号の選択).concat(RString.FULL_SPACE).concat(通知書未発行のみ));
        } else if (SELECTED_VALUE_2.equals(parameter.get償還決定登録者１号の選択())) {
            result.add(抽出対象.concat(償還決定登録者１号の選択).concat(RString.FULL_SPACE).concat(適用中者のみ));
        } else if (SELECTED_VALUE_3.equals(parameter.get償還決定登録者１号の選択())) {
            result.add(抽出対象.concat(償還決定登録者１号の選択).concat(RString.FULL_SPACE).concat(適用中者滞納保険料なしのみ));
        } else if (SELECTED_VALUE_4.equals(parameter.get償還決定登録者１号の選択())) {
            result.add(抽出対象.concat(償還決定登録者１号の選択).concat(RString.FULL_SPACE).concat(適用終了者のみ));
        }
    }

    private void 出力条件_差止中あり者のみ１号の選択(List<RString> result) {
        if (SELECTED_VALUE_0.equals(parameter.get差止中あり者のみの選択())) {
            result.add(抽出対象.concat(償還決定登録者_差止中あり者のみ１号の選択).concat(RString.FULL_SPACE).concat(全て));
        } else if (SELECTED_VALUE_1.equals(parameter.get差止中あり者のみの選択())) {
            result.add(抽出対象.concat(償還決定登録者_差止中あり者のみ１号の選択).concat(RString.FULL_SPACE).concat(通知書未発行のみ));
        } else if (SELECTED_VALUE_2.equals(parameter.get差止中あり者のみの選択())) {
            result.add(抽出対象.concat(償還決定登録者_差止中あり者のみ１号の選択).concat(RString.FULL_SPACE).concat(適用中者滞納保険料なしのみ));
        }
    }

    private void 出力条件_保険料控除あり者のみ１号の選択(List<RString> result) {
        if (SELECTED_VALUE_0.equals(parameter.get保険料控除あり者のみの選択())) {
            result.add(抽出対象.concat(償還決定登録者_保険料控除あり者のみ１号の選択).concat(RString.FULL_SPACE).concat(全て));
        } else if (SELECTED_VALUE_1.equals(parameter.get保険料控除あり者のみの選択())) {
            result.add(抽出対象.concat(償還決定登録者_保険料控除あり者のみ１号の選択).concat(RString.FULL_SPACE).concat(通知書未発行のみ));
        } else if (SELECTED_VALUE_2.equals(parameter.get保険料控除あり者のみの選択())) {
            result.add(抽出対象.concat(償還決定登録者_保険料控除あり者のみ１号の選択).concat(RString.FULL_SPACE).concat(滞納保険料なしのみ));
        }
    }

    private PersonalData toPersonalData(ShiharaiHohoHenkoHaakuFiveEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get資格情報_被保険者番号().getColumnValue());
        return PersonalData.of(entity.get資格情報_識別コード() == null ? ShikibetsuCode.EMPTY : entity.get資格情報_識別コード(), expandedInfo);
    }

    private RString format日期(FlexibleDate 変更前日期) {

        if (変更前日期 != null && !変更前日期.isEmpty()) {
            return 変更前日期.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }
}
