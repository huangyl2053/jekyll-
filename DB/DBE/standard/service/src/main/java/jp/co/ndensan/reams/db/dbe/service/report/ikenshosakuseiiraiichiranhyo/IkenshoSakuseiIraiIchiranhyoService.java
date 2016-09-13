/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ikenshosakuseiiraiichiranhyo;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoItem;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoProperty;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReport;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshosakuseiiraiichiranhyo.IkenshoSakuseiIraiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * 主治医意見書作成依頼一覧Printerです。
 *
 * @reamsid_L DBE-0080-090 zhangzhiming
 */
public class IkenshoSakuseiIraiIchiranhyoService {

    /**
     * 主治医意見書作成依頼一覧を印刷します。
     *
     * @param joho 主治医意見書作成依頼一覧_帳票クラスパラメータクラス
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<IkenshoSakuseiIraiIchiranhyoItem> joho) {
        IkenshoSakuseiIraiIchiranhyoProperty property = new IkenshoSakuseiIraiIchiranhyoProperty();
        return new Printer<IkenshoSakuseiIraiIchiranhyoReportSource>().spool(property, toReports(joho));
    }

    private List<IkenshoSakuseiIraiIchiranhyoReport> toReports(List<IkenshoSakuseiIraiIchiranhyoItem> joho) {
        List<IkenshoSakuseiIraiIchiranhyoReport> list = new ArrayList<>();
        list.add(IkenshoSakuseiIraiIchiranhyoReport.createFrom(joho));
        return list;
    }
}
