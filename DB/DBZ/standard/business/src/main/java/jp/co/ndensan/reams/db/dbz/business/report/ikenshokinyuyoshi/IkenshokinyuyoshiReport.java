/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ikenshokinyuyoshi.IkenshokinyuyoshiBusiness;
import jp.co.ndensan.reams.db.dbz.definition.reportid.ReportIdDBZ;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 要介護認定主治医意見書記入用紙-片面-白黒のReportです。
 *
 * @reamsid_L DBE-0050-030 xuyannan
 */
public class IkenshokinyuyoshiReport extends Report<IkenshokinyuyoshiReportSource> {

    private IkenshokinyuyoshiBusiness business;
    private List<IkenshokinyuyoshiBusiness> businessList;
    private ReportId id;

    /**
     * インスタンスを生成します。
     *
     * @param businessList 要介護認定主治医意見書記入用紙のBusinessList
     */
    public IkenshokinyuyoshiReport(List<IkenshokinyuyoshiBusiness> businessList) {
        this.businessList = businessList;
    }

    /**
     * インスタンスを生成します。
     *
     * @param business 要介護認定主治医意見書記入用紙のBusiness
     * @param id 帳票ID
     */
    public IkenshokinyuyoshiReport(IkenshokinyuyoshiBusiness business, ReportId id) {
        this.business = business;
        this.id = id;
    }

    /**
     * インスタンスを生成します。
     *
     * @param businessList 要介護認定主治医意見書記入用紙のBusinessList
     * @param id 帳票ID
     */
    public IkenshokinyuyoshiReport(List<IkenshokinyuyoshiBusiness> businessList, ReportId id) {
        this.businessList = businessList;
        this.id = id;
    }

    /**
     * 要介護認定主治医意見書記入用紙を生成します。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<IkenshokinyuyoshiReportSource> reportSourceWriter) {
        if (ReportIdDBZ.DBE231001_Ryomen_Mono.getReportId().equals(id) || ReportIdDBZ.DBE231001_Katamen_Mono.getReportId().equals(id)) {
            if (business == null) {
                for (IkenshokinyuyoshiBusiness ikenshokinyuyoshiBusiness : businessList) {
                    IIkenshokinyuyoshiEditor editor = new IkenshokinyuyoshiOmoteEditorImpl(ikenshokinyuyoshiBusiness);
                    IIkenshokinyuyoshiBuilder builder = new IkenshokinyuyoshiOmoteBuilderImpl(editor);
                    reportSourceWriter.writeLine(builder);
                    IIkenshokinyuyoshiEditor uraEditor = new IkenshokinyuyoshiUraEditorImpl(ikenshokinyuyoshiBusiness);
                    IIkenshokinyuyoshiBuilder uraBuilder = new IkenshokinyuyoshiUraBuilderImpl(uraEditor);
                    reportSourceWriter.writeLine(uraBuilder);
                }
            } else {
                IIkenshokinyuyoshiEditor editor = new IkenshokinyuyoshiOmoteEditorImpl(business);
                IIkenshokinyuyoshiBuilder builder = new IkenshokinyuyoshiOmoteBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
                IIkenshokinyuyoshiEditor uraEditor = new IkenshokinyuyoshiUraEditorImpl(business);
                IIkenshokinyuyoshiBuilder uraBuilder = new IkenshokinyuyoshiUraBuilderImpl(uraEditor);
                reportSourceWriter.writeLine(uraBuilder);
            }
        } else if (ReportIdDBZ.DBE231011_Ryomen_Color.getReportId().equals(id) || ReportIdDBZ.DBE231011_Katamen_Color.getReportId().equals(id)) {
            if (business == null) {
                for (IkenshokinyuyoshiBusiness ikenshokinyuyoshiBusiness : businessList) {
                    IIkenshokinyuyoshiOCREditor editor = new IkenshokinyuyoshiOCRomoteEditorImpl(ikenshokinyuyoshiBusiness);
                    IIkenshokinyuyoshiOCRBuilder builder = new IkenshokinyuyoshiOCRomoteBuilderImpl(editor);
                    reportSourceWriter.writeLine(builder);
                    IIkenshokinyuyoshiOCREditor uraEditor = new IkenshokinyuyoshiOCRuraEditorImpl(ikenshokinyuyoshiBusiness);
                    IIkenshokinyuyoshiOCRBuilder uraBuilder = new IkenshokinyuyoshiOCRuraBuilderImpl(uraEditor);
                    reportSourceWriter.writeLine(uraBuilder);
                }
            } else {
                IIkenshokinyuyoshiOCREditor editor = new IkenshokinyuyoshiOCRomoteEditorImpl(business);
                IIkenshokinyuyoshiOCRBuilder builder = new IkenshokinyuyoshiOCRomoteBuilderImpl(editor);
                reportSourceWriter.writeLine(builder);
                IIkenshokinyuyoshiOCREditor uraEditor = new IkenshokinyuyoshiOCRuraEditorImpl(business);
                IIkenshokinyuyoshiOCRBuilder uraBuilder = new IkenshokinyuyoshiOCRuraBuilderImpl(uraEditor);
                reportSourceWriter.writeLine(uraBuilder);
            }
        }
    }
}
