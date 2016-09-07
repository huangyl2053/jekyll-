/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.ikenshoirairirekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran.IkenshoirairirekiIchiran;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoirairirekiichiran.IkenshoirairirekiIchiranProperty;
import jp.co.ndensan.reams.db.dbe.business.report.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReport;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ikenshoirairirekiichiran.IkenshoirairirekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.Printer;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;

/**
 * DBE230004_主治医意見書作成依頼履歴一覧表のPrinterです。
 *
 * @reamsid_L DBE-0260-020 zuotao
 */
public class IkenshoirairirekiIchiranPrintService {

    /**
     * 主治医意見書作成依頼履歴一覧表を印刷します。
     *
     * @param businessList 主治医意見書作成依頼履歴一覧表のBusinessList
     * @return {@link SourceDataCollection}
     */
    public SourceDataCollection print(List<IkenshoirairirekiIchiran> businessList) {
        IkenshoirairirekiIchiranProperty property = new IkenshoirairirekiIchiranProperty();
        return new Printer<IkenshoirairirekiIchiranReportSource>().spool(property, new IkenshoirairirekiIchiranReport(businessList));
    }
}
