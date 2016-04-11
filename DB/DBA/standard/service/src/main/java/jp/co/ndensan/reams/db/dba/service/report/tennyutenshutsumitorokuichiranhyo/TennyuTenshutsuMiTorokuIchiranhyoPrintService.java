/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.report.tennyutenshutsumitorokuichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoProperty;
import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoReport;
import jp.co.ndensan.reams.db.dba.business.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMiTorokuIchiranhyoReportJoho;
import jp.co.ndensan.reams.db.dba.entity.report.tennyutenshutsumitorokuichiranhyo.TennyuTenshutsuMitorokuIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 転入転出未登録一覧表Printerです。
 *
 * @reamsid_L DBU-4110-040 yaodongsheng
 */
public class TennyuTenshutsuMiTorokuIchiranhyoPrintService {

    /**
     * 転入転出未登録一覧表を印刷します。
     *
     * @param joho 転入転出未登録一覧表作成_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(TennyuTenshutsuMiTorokuIchiranhyoReportJoho joho) {
        TennyuTenshutsuMiTorokuIchiranhyoProperty property = new TennyuTenshutsuMiTorokuIchiranhyoProperty();

        return new Printer<TennyuTenshutsuMitorokuIchiranhyoReportSource>().spool(property, toReports(joho));
    }

    private static List<TennyuTenshutsuMiTorokuIchiranhyoReport> toReports(TennyuTenshutsuMiTorokuIchiranhyoReportJoho joho) {
        List<TennyuTenshutsuMiTorokuIchiranhyoReport> list = new ArrayList<>();
        list.add(TennyuTenshutsuMiTorokuIchiranhyoReport.createFrom(joho.getHeadItem(), joho.getBodyItemList()));
        return list;
    }

}
