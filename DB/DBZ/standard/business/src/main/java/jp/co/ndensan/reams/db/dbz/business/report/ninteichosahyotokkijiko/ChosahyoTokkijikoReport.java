/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ninteichosahyotokkijiko;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ninteichosahyotokkijiko.ChosahyoTokkijikoBusiness;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ninteichosahyotokkijiko.ChosahyoTokkijikoReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定調査票（特記事項）のReportです。
 *
 * @reamsid_L DBE-0080-040 xuyannan
 */
public class ChosahyoTokkijikoReport extends Report<ChosahyoTokkijikoReportSource> {

    private final List<ChosahyoTokkijikoBusiness> businessList;
    private final ChosahyoTokkijikoBusiness business;
    private final ReportId id;

    /**
     * インスタンスを生成します。
     *
     * @param business 要介護認定調査票（特記事項）のbusiness
     * @param id 帳票ID
     */
    public ChosahyoTokkijikoReport(ChosahyoTokkijikoBusiness business, ReportId id) {
        this.businessList = null;
        this.business = business;
        this.id = id;
    }

    /**
     * インスタンスを生成します。
     *
     * @param businessList 要介護認定調査票（特記事項）のbusinessList
     * @param id 帳票ID
     */
    public ChosahyoTokkijikoReport(List<ChosahyoTokkijikoBusiness> businessList, ReportId id) {
        this.businessList = businessList;
        this.business = null;
        this.id = id;
    }

    /**
     * 帳票を作成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosahyoTokkijikoReportSource> reportSourceWriter) {
        if (ReportIdDBZ.DBE221021_Ari_Mono.getReportId().equals(id)) {
            if (business == null) {
                for (ChosahyoTokkijikoBusiness chosahyoTokkijikoBusiness : businessList) {
                    IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoAriMonoEditorImpl(chosahyoTokkijikoBusiness);
                    IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoAriMonoBuilderImpl(editor);
                    reportSourceWriter.writeLine(builder);
                }
            } else {
                IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoAriMonoEditorImpl(business);
                IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoAriMonoBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else if (ReportIdDBZ.DBE221021_Ari_Color.getReportId().equals(id)) {
            if (business == null) {
                for (ChosahyoTokkijikoBusiness chosahyoTokkijikoBusiness : businessList) {
                    IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoAriColorEditorImpl(chosahyoTokkijikoBusiness);
                    IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoAriColorBuilderImpl(editor);
                    reportSourceWriter.writeLine(builder);
                }
            } else {
                IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoAriColorEditorImpl(business);
                IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoAriColorBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else if (ReportIdDBZ.DBE221024_Nashi_Mono.getReportId().equals(id)) {
            if (business == null) {
                for (ChosahyoTokkijikoBusiness chosahyoTokkijikoBusiness : businessList) {
                    IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoNashiMonoEditorImpl(chosahyoTokkijikoBusiness);
                    IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoNashiMonoBuilderImpl(editor);
                    reportSourceWriter.writeLine(builder);
                }
            } else {
                IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoNashiMonoEditorImpl(business);
                IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoNashiMonoBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else if (ReportIdDBZ.DBE221024_Nashi_Color.getReportId().equals(id)) {
            if (business == null) {
                for (ChosahyoTokkijikoBusiness chosahyoTokkijikoBusiness : businessList) {
                    IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoNashiColorEditorImpl(chosahyoTokkijikoBusiness);
                    IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoNashiColorBuilderImpl(editor);
                    reportSourceWriter.writeLine(builder);
                }
            } else {
                IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoNashiColorEditorImpl(business);
                IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoNashiColorBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else if (ReportIdDBZ.DBE221042_Ryomen.getReportId().equals(id)) {
            if (business == null) {
                for (ChosahyoTokkijikoBusiness chosahyoTokkijikoBusiness : businessList) {
                    IChosahyoTokkijikoEditor omoteEditor = new ChosahyoTokkijikoRyomenOmoteEditorImpl(chosahyoTokkijikoBusiness);
                    IChosahyoTokkijikoBuilder omoteBuilder = new ChosahyoTokkijikoRyomenOmoteBuilderImpl(omoteEditor);
                    reportSourceWriter.writeLine(omoteBuilder);
                    IChosahyoTokkijikoEditor uraEditor = new ChosahyoTokkijikoRyomenUraEditorImpl(chosahyoTokkijikoBusiness);
                    IChosahyoTokkijikoBuilder uraBuilder = new ChosahyoTokkijikoRyomenUraBuilderImpl(uraEditor);
                    reportSourceWriter.writeLine(uraBuilder);
                }
            } else {
                IChosahyoTokkijikoEditor omoteEditor = new ChosahyoTokkijikoRyomenOmoteEditorImpl(business);
                IChosahyoTokkijikoBuilder omoteBuilder = new ChosahyoTokkijikoRyomenOmoteBuilderImpl(omoteEditor);
                reportSourceWriter.writeLine(omoteBuilder);
                IChosahyoTokkijikoEditor uraEditor = new ChosahyoTokkijikoRyomenUraEditorImpl(business);
                IChosahyoTokkijikoBuilder uraBuilder = new ChosahyoTokkijikoRyomenUraBuilderImpl(uraEditor);
                reportSourceWriter.writeLine(uraBuilder);
            }
        } else if (ReportIdDBZ.DBE221042_Katamen.getReportId().equals(id)) {
            if (business == null) {
                for (ChosahyoTokkijikoBusiness chosahyoTokkijikoBusiness : businessList) {
                    IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoKatamenEditorImpl(chosahyoTokkijikoBusiness);
                    IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoKatamenBuilderImpl(editor);
                    reportSourceWriter.writeLine(builder);
                }
            } else {
                IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoKatamenEditorImpl(business);
                IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoKatamenBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        } else if (ReportIdDBZ.DBE221003.getReportId().equals(id)
                || ReportIdDBZ.DBE221031.getReportId().equals(id)
                || ReportIdDBZ.DBE221032.getReportId().equals(id)) {
            if (business == null) {
                for (ChosahyoTokkijikoBusiness chosahyoTokkijikoBusiness : businessList) {
                    IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoEditorImpl(chosahyoTokkijikoBusiness);
                    IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoBuilderImpl(editor);
                    reportSourceWriter.writeLine(builder);
                }
            } else {
                IChosahyoTokkijikoEditor editor = new ChosahyoTokkijikoEditorImpl(business);
                IChosahyoTokkijikoBuilder builder = new ChosahyoTokkijikoBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
            }
        }
    }
}
