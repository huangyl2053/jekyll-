/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.report.dbd5720001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5720001.JyukyushaDaichoIdoCheckListProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd200037.JukyushaIdoCheckListReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 帳票出力条件リストの出力service
 *
 * @reamsid_L DBD-1770-020 donghj
 */
public class OutputJokenhyoFactory {

    /**
     * 帳票出力条件リストの出力
     *
     * @param reportSourceWriter ReportSourceWriter<JukyushaIdoCheckListReportSource>
     * @param parameter JyukyushaDaichoIdoCheckListProcessParameter
     */
    public void outputJokenhyoFactory(ReportSourceWriter<JukyushaIdoCheckListReportSource> reportSourceWriter,
            JyukyushaDaichoIdoCheckListProcessParameter parameter) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        RString ページ数 = new RString(reportSourceWriter.pageCount().value());
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBD.DBD200037.getReportId().getColumnValue(),
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBD.DBD200037.getReportName(),
                ページ数,
                new RString("なし"),
                RString.EMPTY,
                contribute(parameter));
        jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory.createInstance(item).print();

    }

    private List<RString> contribute(JyukyushaDaichoIdoCheckListProcessParameter parameter) {
        List<RString> 出力条件 = new ArrayList<>();

        if (parameter.get今回抽出開始年月日() != null) {
            出力条件.add(new RString("【今回抽出開始年月日】　").concat(parameter.get今回抽出開始年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出開始時分秒() != null) {
            出力条件.add(new RString("【今回抽出開始時分秒】　").concat(parameter.get今回抽出開始時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
        if (parameter.get今回抽出終了年月日() != null) {
            出力条件.add(new RString("【今回抽出終了年月日】　").concat(parameter.get今回抽出終了年月日().wareki().toDateString()));
        }
        if (parameter.get今回抽出終了時分秒() != null) {
            出力条件.add(new RString("【今回抽出終了時分秒】　").concat(parameter.get今回抽出終了時分秒().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
        }
        if (parameter.get出力対象() != null) {
            出力条件.add(new RString("【出力対象】　").concat(parameter.get出力対象()));
        }

        return 出力条件;
    }

}
