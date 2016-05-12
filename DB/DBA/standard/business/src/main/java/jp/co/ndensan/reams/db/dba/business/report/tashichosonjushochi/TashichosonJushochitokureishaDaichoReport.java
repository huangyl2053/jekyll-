/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.tashichosonjushochi;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.report.tashichosonjushochi.TashichosonJushochitokureishaDaichoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 他市町村住所地特例者台帳のReportです。
 *
 * @reamsid_L DBA-0402-030 xuyannan
 */
public class TashichosonJushochitokureishaDaichoReport extends Report<TashichosonJushochitokureishaDaichoReportSource> {

    private final List<TashichosonJushochitokureishaDaichoBodyItem> bodyItemList;
    private final TashichosonJushochitokureishaDaichoHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 他市町村住所地特例者台帳ヘッダのITEM
     * @param itemList 他市町村住所地特例者台帳ボディのITEMリスト
     * @return 他市町村住所地特例者台帳のReport
     */
    public static TashichosonJushochitokureishaDaichoReport createFrom(
            TashichosonJushochitokureishaDaichoHeadItem headItem,
            @NonNull List<TashichosonJushochitokureishaDaichoBodyItem> itemList) {

        return new TashichosonJushochitokureishaDaichoReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 他市町村住所地特例者台帳ヘッダのITEM
     * @param itemList 他市町村住所地特例者台帳のITEMリスト
     */
    protected TashichosonJushochitokureishaDaichoReport(
            TashichosonJushochitokureishaDaichoHeadItem headItem,
            List<TashichosonJushochitokureishaDaichoBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    /**
     * 帳票の作成です。
     *
     * @param reportSourceWriter 帳票Writer
     */
    @Override
    public void writeBy(ReportSourceWriter<TashichosonJushochitokureishaDaichoReportSource> reportSourceWriter) {
        TashichosonJushochitokureishaDaichoHeaderEditor headerEditor = new TashichosonJushochitokureishaDaichoHeaderEditor(headItem);
        for (TashichosonJushochitokureishaDaichoBodyItem bodyItem : bodyItemList) {
            TashichosonJushochitokureishaDaichoBodyEditor bodyEditor = new TashichosonJushochitokureishaDaichoBodyEditor(bodyItem);
            ITashichosonJushochitokureishaDaichoBuilder builder = new TashichosonJushochitokureishaDaichoBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

}
