package jp.co.ndensan.reams.db.dbz.business.report.chosahyomatome;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.core.chosahyomatome.ChosahyoMatomeLayout;
import jp.co.ndensan.reams.db.dbz.entity.report.chosahyomatome.ChosahyoMatomeReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 帳票まとめて印刷のレポートクラスです。
 * @author n8438
 */
public final class ChosahyoMatomeReport extends Report<ChosahyoMatomeReportSource> {
    private final List<ChosahyoMatomeItem> itemlist;
    private final boolean isRyomen;
    
    
    private ChosahyoMatomeReport(List<ChosahyoMatomeItem> itemlist, boolean isRyomen) {
        this.itemlist = itemlist;
        this.isRyomen = isRyomen;
    }
    
    /**
     * パラメータのリストをもったインスタンスを作成します。
     * @param itemlist 帳票のもととなるパラメータ
     * @param isRyomen 両面印刷かどうか（空白ページを入れるかどうか）
     * @return ChosahyoMatomeReport
     */
    public static ChosahyoMatomeReport createFromList(@NonNull List<ChosahyoMatomeItem> itemlist, boolean isRyomen) {
        return new ChosahyoMatomeReport(itemlist, isRyomen);
    }
    

    @Override
    public void writeBy(ReportSourceWriter<ChosahyoMatomeReportSource> writer) {
        for (ChosahyoMatomeItem item: itemlist) {
            if (isRyomen && writer.pageCount().isOdd()
                    && (item.getLayout() != ChosahyoMatomeLayout.認定調査票_基本調査_OCR_両面 && item.getLayout() != ChosahyoMatomeLayout.認定調査票_特記事項_OCR_裏面)) {
                ChosahyoMatomeItem white = new ChosahyoMatomeItem();
                white.setLayout(ChosahyoMatomeLayout.認定調査票_空白ページ);
                writer.writeLine(new ChosahyoMatomeBuilder(white));
            }
            writer.writeLine(new ChosahyoMatomeBuilder(item));
        }
    }
    
}
