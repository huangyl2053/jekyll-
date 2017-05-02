/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.business.report.ikenshoassortment;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.ikenshoassortment.IkenshoAssortmentLayout;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshoassortment.IkenshoAssortmentReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 意見書まとめて印刷のレポートクラスです。
 * @author n8438
 */
public class IkenshoAssortmentReport extends Report<IkenshoAssortmentReportSource> {
    private final List<IkenshoAssortmentItem> itemlist;
    private final boolean isRyomen;
    
    
    private IkenshoAssortmentReport(List<IkenshoAssortmentItem> itemlist, boolean isRyomen) {
        this.itemlist = itemlist;
        this.isRyomen = isRyomen;
    }
    
    /**
     * パラメータのリストをもったインスタンスを作成します。
     * @param itemlist 帳票のもととなるパラメータ
     * @param isRyomen 両面印刷かどうか（空白ページを入れるかどうか）
     * @return 
     */
    public static IkenshoAssortmentReport createFromList(@NonNull List<IkenshoAssortmentItem> itemlist, boolean isRyomen) {
        return new IkenshoAssortmentReport(itemlist, isRyomen);
    }
    

    @Override
    public void writeBy(ReportSourceWriter<IkenshoAssortmentReportSource> writer) {
        for (IkenshoAssortmentItem item: itemlist) {
            if (isRyomen && writer.pageCount().isOdd() &&
                    //両面にするレイアウト
                    (item.getLayout() != IkenshoAssortmentLayout.主治医意見書記入用紙OCR_両面_カラー裏 && item.getLayout() != IkenshoAssortmentLayout.主治医意見書記入用紙OCR_片面_カラー裏
                    && item.getLayout() != IkenshoAssortmentLayout.主治医意見書記入用紙_両面_白黒_裏 && item.getLayout() != IkenshoAssortmentLayout.主治医意見書記入用紙_片面_白黒_裏
                    && item.getLayout() != IkenshoAssortmentLayout.主治医意見書記入用紙_ORCA裏 && item.getLayout() != IkenshoAssortmentLayout.主治医意見書記入用紙OCR14)) {
                IkenshoAssortmentItem white = new IkenshoAssortmentItem();
                //空白ページレイアウト
                white.setLayout(IkenshoAssortmentLayout.主治医意見書_空白ページ);
                writer.writeLine(new IkenshoAssortmentBuilder(white));
            }
            writer.writeLine(new IkenshoAssortmentBuilder(item));
        }
    }
}
