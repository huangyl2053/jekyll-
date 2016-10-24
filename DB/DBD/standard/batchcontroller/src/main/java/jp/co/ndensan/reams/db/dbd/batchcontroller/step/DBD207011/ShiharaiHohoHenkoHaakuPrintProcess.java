/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD207011;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.dbd207011.ShiharaiHohoHenkoHaakuOrderKey;
import jp.co.ndensan.reams.db.dbd.business.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReport;
import jp.co.ndensan.reams.db.dbd.definition.core.common.TainoKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd207010.ShiharaiHohoHenkoHaakoFiveProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShiharaiHohoHenkoHaakuFiveEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd207010.ShunoStatusJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShunoKibetsuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenkolist.ShunoNendoEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200007.ShiharaiHohoHenkoKanriIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
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
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * DBDMN32001_2_支払方法変更滞納者把握リスト作成_バッチプロセス5クラスです．
 *
 * @reamsid_L DBD-3650-050 x_lilh
 */
public class ShiharaiHohoHenkoHaakuPrintProcess extends BatchProcessBase<ShiharaiHohoHenkoHaakuFiveEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shiharaihohohenkohaakuichiran."
            + "IShiharaiHohoHenkoHakuListMainMapper.find帳票印字用データ");

    private ShiharaiHohoHenkoHaakoFiveProcessParameter parameter;

    private static final ReportIdDBD REPORT_DBD200006 = ReportIdDBD.DBD200006;

    private static final RString 選択あり = new RString("0");
    private static final RString 申請中 = new RString("申請中");

    private static final RString 基準日 = new RString("【基準日】 ");
    private static final RString 被保険者選択 = new RString("【抽出対象】 被保険者全員");
    private static final RString 滞納期間 = new RString("【滞納期間】");
    private static final RString ヵ月経過 = new RString("ヵ月経過");
    private static final RString 受給者全員 = new RString("【抽出対象】 受給者全員");
    private static final RString 受給認定申請中者 = new RString("【抽出対象】 受給認定申請中者");
    private static final RString 受給認定日抽出 = new RString("【抽出方法】 受給認定日抽出");
    private static final RString 対象期間 = new RString("【対象期間】");
    private static final RString カラ = new RString("～");
    private static final RString 償還申請中者 = new RString("【抽出対象】 償還申請中者");
    private static final RString 償還支給決定日抽出 = new RString("【抽出方法】 償還支給決定日抽出");
    private static final RString バッチ出力条件出力順 = new RString("出力順:");
    private static final int 帳票期別リストSIZE = 3;
    private static final RString より = new RString("＞");

    private static final int NO_0 = 0;
    private static final int NO_1 = 1;
    private static final int NO_2 = 2;
    private static final int NO_3 = 3;
    private static final int NO_4 = 4;

    private Association association;
    private IOutputOrder outputOrder;
    private RString 出力順;

    @BatchWriter
    private BatchReportWriter<ShiharaiHohoHenkoKanriIchiranReportSource> batchReportWrite;
    private ReportSourceWriter<ShiharaiHohoHenkoKanriIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().get出力順(SubGyomuCode.DBD介護受給,
                parameter.get帳票ID(), parameter.get改頁出力順ID());
        出力順 = get出力順(outputOrder);
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toShiharaiHohoHenkoHaakuFiveMybatisParameter(uaFt200Psm, 出力順));
    }

    @Override
    protected void createWriter() {
        List<RString> pageBreakKeys = new ArrayList<>();
        set改頁Key(outputOrder, pageBreakKeys);
        batchReportWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBD200006.getReportId().value(),
                SubGyomuCode.DBD介護受給).addBreak(
                        new BreakerCatalog<ShiharaiHohoHenkoKanriIchiranReportSource>().simplePageBreaker(pageBreakKeys)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWrite);
    }

    int count = 0;
    ShiharaiHohoHenkoEntity reportData;

    @Override
    protected void process(ShiharaiHohoHenkoHaakuFiveEntity t) {
        count++;
        if (count == 1) {
            reportData = new ShiharaiHohoHenkoEntity();
            createShiharaiHohoHenkoEntity(t);
            ShiharaiHohoHenkoKanriIchiranReport finder = new ShiharaiHohoHenkoKanriIchiranReport(RDateTime.now(),
                    new HokenshaNo(association.get地方公共団体コード().value()), association.get市町村名(),
                    outputOrder, reportData, new ShiharaiHohoHenkoEntity());

            finder.writeBy(reportSourceWriter);
        }
        if (count == 2) {
            reportData = new ShiharaiHohoHenkoEntity();
            createShiharaiHohoHenkoEntity(t);

            ShiharaiHohoHenkoKanriIchiranReport finder = new ShiharaiHohoHenkoKanriIchiranReport(RDateTime.now(),
                    new HokenshaNo(association.get地方公共団体コード().value()), association.get市町村名(),
                    outputOrder, new ShiharaiHohoHenkoEntity(), reportData);

            finder.writeBy(reportSourceWriter);
            count = 0;
        }
    }

    @Override
    protected void afterExecute() {

        RString 導入団体コード = association.getLasdecCode_().value();
        RString 市町村名 = association.get市町村名();
        RString csv出力有無 = new RString("無し");
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 出力ページ数 = new RString(String.valueOf(batchReportWrite.getPageCount()));
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
                改頁１ = to帳票物理名(list.get(NO_0).get項目ID());
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
        if (ShiharaiHohoHenkoHaakuOrderKey.郵便番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("yubinNo");
        } else if (ShiharaiHohoHenkoHaakuOrderKey.町域コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("choikiCode");
        } else if (ShiharaiHohoHenkoHaakuOrderKey.行政区コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("gyoseikuCode");
        } else if (ShiharaiHohoHenkoHaakuOrderKey.世帯コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("setaiCode");
        } else if (ShiharaiHohoHenkoHaakuOrderKey.識別コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shikibetsuCode");
        } else if (ShiharaiHohoHenkoHaakuOrderKey.氏名５０音カナ.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shimeiKana");
        } else if (ShiharaiHohoHenkoHaakuOrderKey.市町村コード.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("shichosonCode");
        } else if (ShiharaiHohoHenkoHaakuOrderKey.被保険者番号.get項目ID().equals(項目ID)) {
            帳票物理名 = new RString("hihokenshaNo");
        }
        return 帳票物理名;
    }

    private ShiharaiHohoHenkoEntity createShiharaiHohoHenkoEntity(ShiharaiHohoHenkoHaakuFiveEntity t) {

        reportData.set被保険者番号(t.get対象者情報_被保険者番号());
        edit宛名情報について(t);
        edit資格情報について(t);
        edit生活保護受給者について(t);
        edit認定情報について(t);
        edit償還情報について(t);
        edit滞納者対策情報について(t);
        List<ShunoStatusJohoEntity> 収納状況情報List = t.get収納状況情報リスト();
        if (収納状況情報List != null && !収納状況情報List.isEmpty()) {
            reportData.set収納情報List(edit収納情報List(収納状況情報List));
        } else {
            reportData.set収納情報なし(new RString("1"));
        }

        return reportData;
    }

    private void edit宛名情報について(ShiharaiHohoHenkoHaakuFiveEntity t) {
        if (t.get宛名情報() != null) {
            IKojin kojin = ShikibetsuTaishoFactory.createKojin(t.get宛名情報());

            reportData.set識別コード(kojin.get識別コード());
            reportData.set被保険者氏名カナ(kojin.get名称().getKana().value());
            reportData.set被保険者氏名(kojin.get名称().getName().value());

            if (kojin.get世帯コード() != null && !kojin.get世帯コード().isEmpty()) {
                reportData.set世帯番号(new Code(kojin.get世帯コード().getColumnValue()));
            }
            reportData.set行政区コード(kojin.get行政区画().getGyoseiku().getコード().value());
            reportData.set行政区(kojin.get行政区画().getGyoseiku().get名称());
            reportData.set住所コード(kojin.get住所().get全国住所コード().getColumnValue());
            reportData.set郵便番号(kojin.get住所().get郵便番号());
            reportData.set住所(kojin.get住所().get住所());
        }
    }

    private void edit資格情報について(ShiharaiHohoHenkoHaakuFiveEntity t) {
        reportData.set資格取得日(t.get資格情報_資格取得年月日());
        reportData.set資格喪失日(t.get資格情報_資格喪失年月日());
        reportData.set喪失事由(ShikakuSoshitsuJiyu.toValue(t.get資格情報_資格喪失事由コード()));
        if (t.get資格情報_被保険者区分コード() != null && !t.get資格情報_被保険者区分コード().isEmpty()) {
            reportData.set資格区分(ShikakuKubun.toValue(t.get資格情報_被保険者区分コード()));
        }
        reportData.set住特フラグ(t.get資格情報_住所地特例フラグ());
    }

    private void edit生活保護受給者について(ShiharaiHohoHenkoHaakuFiveEntity t) {
        if (t.get生活保護受給者_識別コード() != null && !ShikibetsuCode.EMPTY.equals(t.get生活保護受給者_識別コード())) {
            reportData.set生保(true);
        } else {
            reportData.set生保(false);
        }
    }

    private void edit認定情報について(ShiharaiHohoHenkoHaakuFiveEntity t) {

        if (t.get認定情報_要介護認定状態区分コード() != null && Code.EMPTY.equals(t.get認定情報_要介護認定状態区分コード())) {
            reportData.set要介護度(t.get認定情報_要介護認定状態区分コード().getColumnValue());
        }

        RStringBuilder builder = new RStringBuilder();
        builder.append(t.get認定情報_認定有効期間開始年月日()).append("～").append(t.get認定情報_認定有効期間終了年月日());
        reportData.set認定有効期間(builder.toRString());
        reportData.set認定日(t.get償還未払い_申請日());

        if (t.get申請中認定情報_被保険者番号() != null) {
            reportData.set認定情報_申請中(申請中);
        } else {
            reportData.set認定情報_申請中(RString.EMPTY);
        }
    }

    private void edit償還情報について(ShiharaiHohoHenkoHaakuFiveEntity t) {
        reportData.set申請日(t.get償還未払い_申請日());

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

    }

    private void edit滞納者対策情報について(ShiharaiHohoHenkoHaakuFiveEntity t) {
        if (t.get滞納者対策情報_登録区分() != null && !RString.EMPTY.equals(t.get滞納者対策情報_登録区分())) {
            reportData.set滞納管理状況(ShiharaiHenkoTorokuKubun.toValue(t.get滞納者対策情報_登録区分()));
        }

        if (t.get収納状況情報リスト() != null && !t.get収納状況情報リスト().isEmpty()) {
            ShunoStatusJohoEntity 収納状況情報 = t.get収納状況情報リスト().get(0);
            reportData.set最長滞納期間(new RString(String.valueOf(収納状況情報.get収納状況_最長滞納期間())));
            reportData.set以前滞納額(収納状況情報.get収納状況_以前滞納額());
            if (収納状況情報.get収納状況_以前滞納区分() != null && !収納状況情報.get収納状況_以前滞納区分().isEmpty()) {
                reportData.set以前滞納区分(TainoKubun.toValue(収納状況情報.get収納状況_以前滞納区分()));
            }
        }
        if (t.get滞納者対策情報_終了区分() != null && !RString.EMPTY.equals(t.get滞納者対策情報_終了区分())) {
            reportData.set終了状況(ShiharaiHenkoShuryoKubun.toValue(t.get滞納者対策情報_終了区分()));
        }
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

    }

    private FlexibleDate edit日期(RDate 納期限) {
        if (納期限 != null) {
            return new FlexibleDate(納期限.toDateString());
        }
        return FlexibleDate.EMPTY;
    }

    List<FlexibleYear> 賦課年度List = new ArrayList<>();

    private List<ShunoNendoEntity> edit収納情報List(List<ShunoStatusJohoEntity> 収納状況情報List) {

        List<ShunoNendoEntity> 帳票用収納状況情報List = new ArrayList<>();
        Map<FlexibleYear, List<ShunoStatusJohoEntity>> 収納状況情報Map = new HashMap<>();
        for (ShunoStatusJohoEntity 収納状況情報Data : 収納状況情報List) {
            if (収納状況情報Map.containsKey(収納状況情報Data.get収納状況_賦課年度())) {
                収納状況情報Map.get(収納状況情報Data.get収納状況_賦課年度()).add(収納状況情報Data);
                賦課年度List.add(収納状況情報Data.get収納状況_賦課年度());
            } else {
                List<ShunoStatusJohoEntity> new収納状況情報List = new ArrayList<>();
                new収納状況情報List.add(収納状況情報Data);
                収納状況情報Map.put(収納状況情報Data.get収納状況_賦課年度(), new収納状況情報List);
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
                    帳票用収納状況情報.set過年度フラグ(true);
                } else {
                    帳票用収納状況情報.set過年度フラグ(false);
                    ShunoKibetsuEntity 期別情報 = new ShunoKibetsuEntity();
                    期別情報.set期別(new RString(収納状況情報Data.get収納状況_期()));
                    期別情報.set保険料金(収納状況情報Data.get収納状況_調定額());
                    期別情報.set納期限(edit日期(収納状況情報Data.get収納状況_納期限()));
                    期別情報.set滞納額(収納状況情報Data.get収納状況_未納額());
                    if (収納状況情報Data.get収納状況_滞納区分() != null && !収納状況情報Data.get収納状況_滞納区分().isEmpty()) {
                        期別情報.set滞納区分(TainoKubun.toValue(収納状況情報Data.get収納状況_滞納区分()));
                    }

                    期別情報.set時効起算日(収納状況情報Data.get収納状況_時効起算日());
                    期別情報.set時効起算事由(収納状況情報Data.get収納状況_時効起算事由());
                    期別情報List.add(期別情報);
                    帳票用収納状況情報.set期別情報(期別情報List);
                }
            }
            while (期別情報List.size() < 帳票期別リストSIZE) {
                期別情報List.add(new ShunoKibetsuEntity());
            }
            帳票用収納状況情報List.add(帳票用収納状況情報);
        }
        return 帳票用収納状況情報List;
    }

    private List<RString> get出力条件内容() {
        List<RString> list = new ArrayList<>();
        list.add(基準日.concat(format日期(parameter.get基準日())));

        if (選択あり.equals(parameter.get被保険者選択())) {
            list.add(被保険者選択);
            list.add(滞納期間.concat(new RString(parameter.get被保険者全員の滞納期間())).concat(ヵ月経過));
        } else {
            if (選択あり.equals(parameter.get受給者全員())) {
                list.add(受給者全員);
                list.add(滞納期間.concat(new RString(parameter.get受給者全員の滞納期間())).concat(ヵ月経過));
            }

            if (選択あり.equals(parameter.get受給申請中者())) {
                list.add(受給認定申請中者);
                list.add(滞納期間.concat(new RString(parameter.get受給認定申請中者の滞納期間())).concat(ヵ月経過));
            }

            if (選択あり.equals(parameter.get受給認定日抽出())) {
                list.add(受給認定日抽出);
                list.add(対象期間.concat(format日期(parameter.get受給認定日抽出の開始()))
                        .concat(カラ).concat(format日期(parameter.get受給認定日抽出の終了())));
            }

            if (選択あり.equals(parameter.get受給認定申請中者())) {
                list.add(償還申請中者);
                list.add(滞納期間.concat(new RString(parameter.get受給申請中者の滞納期間())).concat(ヵ月経過));
            }

            if (選択あり.equals(parameter.get受給認定申請中者())) {
                list.add(償還支給決定日抽出);
                list.add(対象期間.concat(format日期(parameter.get受給認定日抽出の開始()))
                        .concat(カラ).concat(format日期(parameter.get受給支給決定日抽出の終了())));
                list.add(滞納期間.concat(new RString(parameter.get受給支給決定日抽出の滞納期間())).concat(ヵ月経過));
            }
        }
        RString 設定項目 = RString.EMPTY;
        if (outputOrder != null) {
            for (ISetSortItem item : outputOrder.get設定項目リスト()) {
                設定項目 = 設定項目.concat(より).concat(item.get項目名());
            }
        }
        if (!設定項目.isEmpty()) {
            設定項目 = 設定項目.substringEmptyOnError(1, 設定項目.length() - 1);
        }
        list.add(バッチ出力条件出力順.concat(設定項目));
        return list;
    }

    private RString format日期(FlexibleDate 変更前日期) {

        if (変更前日期 != null && !変更前日期.isEmpty()) {
            return 変更前日期.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }
}
