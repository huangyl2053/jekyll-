/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE701001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.yokaigonintei.shinsei.HihokenshaKubun;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hokokushiryosakusei.SinsakaiHanteiJyokyoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jotaikubumbetsuhantei.JotaikubumbetsuhanteiReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 *
 * @author n3509
 */
public class JokenhyoProcess extends SimpleBatchProcessBase {

    private static final RString JIGYOJYOKYOHOKOKU = new RString("【事業状況報告出力区分】");
    private static final RString JISSIJYOKYOTOKEI = new RString("【実施状況統計出力区分】");
    private static final RString SINSAHANTEIJYOKYO = new RString("【審査判定状況出力区分】");
    private static final RString SINSAKAIKANRENTOKEI = new RString("【審査会関連統計資料作成出力区分】");
    private static final RString CSVSHUTSURYOKU = new RString("【CSV出力区分】");
    private static final RString SHUTSURYOKUFAIRU = new RString("【出力ファイル名】");
    private static final RString HOKENSYANO = new RString("【保険者番号】");
    private static final RString HIHOKENSYAKUBUN = new RString("【被保険者区分】");
    private static final RString GOGITAINO = new RString("【合議体番号】");
    private static final RString TAISHOTSUKIKUBUN = new RString("【対象月編集区分】");
    private static final RString TAISHOYM = new RString("【対象年月】");
    private static final RString KIJYUNYMD = new RString("【基準年月日】");
    private static final RString TAISHOGEPPIKUBUN = new RString("【対象月日編集区分】");
    private static final RString TAISHOGEPPIFROM = new RString("【対象月日開始】");
    private static final RString TAISHOGEPPITO = new RString("【対象月日終了】");
    private static final RString SINSEIKUBUNSINSEITOKI = new RString("【申請区分(申請時)】");
    private static final RString SINSEIKUBUNHOREI = new RString("【申請区分(法令)】");
    private SinsakaiHanteiJyokyoProcessParameter paramter;
    private final RString 出力する = new RString("出力する");
    private final RString 出力しない = new RString("出力しない");
    private final RString 使用する = new RString("使用する");
    private final RString 使用しない = new RString("使用しない");
    private final RString 集計する = new RString("集計単位として使用する");
    private final RString 集計しない = new RString("集計単位として使用しない");

    @BatchWriter
    private ReportSourceWriter<JotaikubumbetsuhanteiReportSource> reportSourceWriter;

    @Override
    protected void process() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                getReportId(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                get帳票タイトル(),
                new RString(reportSourceWriter.pageCount().value()),
                new RString(paramter.isCsvShutsuryoku() ? "有り" : "無し"),
                new RString(paramter.isCsvShutsuryoku() ? "D__県報告資料ファイル.CSV" : "ー"),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString getReportId() {
        RStringBuilder 帳票ID = new RStringBuilder(RString.EMPTY);

        if (paramter.isJigyoJyokyoHokoku()) {
            帳票ID.append(ReportIdDBE.DBE702001.getReportId().value());
        }
        if (paramter.isJissiJyokyoTokei()) {
            if (帳票ID.length() != 0) {
                帳票ID.append("・");
            }
            帳票ID.append(ReportIdDBE.DBE701003.getReportId().value());
        }
        if (paramter.isSinsaHanteiJyokyo()) {
            if (帳票ID.length() != 0) {
                帳票ID.append("・");
            }
            帳票ID.append(ReportIdDBE.DBE701001.getReportId().value());
        }
        if (paramter.isSinsakaiKanrenTokei()) {
            if (帳票ID.length() != 0) {
                帳票ID.append("・");
            }
            帳票ID.append(ReportIdDBE.DBE701005.getReportId().value());
            帳票ID.append("・");
            帳票ID.append(ReportIdDBE.DBE701006.getReportId().value());
            帳票ID.append("・");
            帳票ID.append(ReportIdDBE.DBE701007.getReportId().value());
            帳票ID.append("・");
            帳票ID.append(ReportIdDBE.DBE701008.getReportId().value());
            帳票ID.append("・");
            帳票ID.append(ReportIdDBE.DBE701009.getReportId().value());
        }
        return 帳票ID.toRString();
    }

    private RString get帳票タイトル() {

        RStringBuilder 帳票タイトル = new RStringBuilder(RString.EMPTY);

        if (paramter.isJigyoJyokyoHokoku()) {
            帳票タイトル.append("要介護認定事業状況報告");
        }
        if (paramter.isJissiJyokyoTokei()) {
            if (帳票タイトル.length() != 0) {
                帳票タイトル.append("・");
            }
            帳票タイトル.append("要介護認定実施状況統計");
        }
        if (paramter.isSinsaHanteiJyokyo()) {
            if (帳票タイトル.length() != 0) {
                帳票タイトル.append("・");
            }
            帳票タイトル.append("介護認定審査会判定状況表");
        }
        if (paramter.isSinsakaiKanrenTokei()) {
            if (帳票タイトル.length() != 0) {
                帳票タイトル.append("・");
            }
            帳票タイトル.append("要介護状態区分別判定件数");
            帳票タイトル.append("・認定審査会審査判定状況");
            帳票タイトル.append("・介護認定審査会集計表（判定別）");
            帳票タイトル.append("・介護認定審査会集計表（申請区分別）");
            帳票タイトル.append("・介護認定審査会集計表（現在の状況別）");
        }
        return 帳票タイトル.toRString();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(JIGYOJYOKYOHOKOKU);
        条件.append(paramter.isJigyoJyokyoHokoku() ? 出力する : 出力しない);
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(JISSIJYOKYOTOKEI);
        条件.append(paramter.isJissiJyokyoTokei() ? 出力する : 出力しない);
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAHANTEIJYOKYO);
        条件.append(paramter.isSinsaHanteiJyokyo() ? 出力する : 出力しない);
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSAKAIKANRENTOKEI);
        条件.append(paramter.isSinsakaiKanrenTokei() ? 出力する : 出力しない);
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(CSVSHUTSURYOKU);
        条件.append(paramter.isCsvShutsuryoku() ? 出力する : 出力しない);
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SHUTSURYOKUFAIRU);
        条件.append(paramter.getShutsuryokuFairuName());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HOKENSYANO);
        条件.append(paramter.getHokensyaNo());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(HIHOKENSYAKUBUN);
        条件.append(paramter.isJigyoJyokyoHokoku() ? RString.EMPTY : HihokenshaKubun.toValue(
                paramter.getHihokenshaKubun()).get名称());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(GOGITAINO);
        条件.append(paramter.isJigyoJyokyoHokoku() ? RString.EMPTY : new RString(paramter.getGogitaiNo()));
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOTSUKIKUBUN);
        条件.append(paramter.isTaishoTsukiKubun() ? 使用する : 使用しない);
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOYM);
        条件.append(!paramter.isTaishoTsukiKubun() ? RString.EMPTY
                : new RYearMonth(paramter.getTaishoNendoYM()).wareki().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIKUBUN);
        条件.append(paramter.isTaishoGeppiKubun() ? 使用する : 使用しない);
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPIFROM);
        条件.append(paramter.isEmptyTaishoGeppiFrom() ? RString.EMPTY
                : new RDate(paramter.getTaishoGeppiFrom().toString()).wareki().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(TAISHOGEPPITO);
        条件.append(paramter.isEmptyTaishoGeppiTo() ? RString.EMPTY
                : new RDate(paramter.getTaishoGeppiTo().toString()).wareki().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(KIJYUNYMD);
        条件.append(paramter.getKijyunYMD() == null ? RString.EMPTY : paramter.getKijyunYMD().wareki().toDateString());
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNSINSEITOKI);
        条件.append(paramter.isShinseiji() ? 集計する : 集計しない);
        出力条件.add(条件.toRString());
        条件 = new RStringBuilder();
        条件.append(SINSEIKUBUNHOREI);
        条件.append(paramter.isHorei() ? 集計する : 集計しない);
        出力条件.add(条件.toRString());
        return 出力条件;
    }
}
