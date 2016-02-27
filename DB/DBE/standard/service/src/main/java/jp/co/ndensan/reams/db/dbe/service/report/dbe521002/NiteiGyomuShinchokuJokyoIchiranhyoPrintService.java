/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.service.report.dbe521002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoJoho;
import jp.co.ndensan.reams.db.dbe.business.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoProerty;
import jp.co.ndensan.reams.db.dbe.business.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoReport;
import jp.co.ndensan.reams.db.dbe.entity.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 *
 * 要介護認定業務進捗状況一覧表Printクラスです。
 */
public class NiteiGyomuShinchokuJokyoIchiranhyoPrintService {
    
    /**
     * 要介護認定業務進捗状況一覧表Printします。
     * @param reportJoho 要介護認定業務進捗状況一覧表作成_帳票クラスパラメータ
     * @return 要介護認定業務進捗状況一覧表作成_帳票
     */
    public SourceDataCollection print(NiteiGyomuShinchokuJokyoIchiranhyoJoho reportJoho) {
        NiteiGyomuShinchokuJokyoIchiranhyoProerty property = new NiteiGyomuShinchokuJokyoIchiranhyoProerty();
        return new Printer<NiteiGyomuShinchokuJokyoIchiranhyoReportSource>().spool(property, toReports(reportJoho));
    }
    
    private static List<NiteiGyomuShinchokuJokyoIchiranhyoReport> toReports(NiteiGyomuShinchokuJokyoIchiranhyoJoho joho) {
        List<NiteiGyomuShinchokuJokyoIchiranhyoReport> list = new ArrayList<>();
        list.add(NiteiGyomuShinchokuJokyoIchiranhyoReport.createReport(joho.getBodyItem()));
        return list;
    }
    
}
