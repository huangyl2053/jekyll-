/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.syujiyikenshosakuseyiraihakou;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.syujiyikensho.IkenshoSakuseiIraiHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 主治医意見書作成依頼発行一覧表のReportです。
 */
public class SyujiyikenshosakuseyiraihakouReport extends Report<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> {

    private final List<SyujiyikenshosakuseyiraihakouBodyItem> bodyItemList;
    private final SyujiyikenshosakuseyiraihakouHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医意見書作成依頼発行一覧表ヘッダのITEM
     * @param itemList 主治医意見書作成依頼発行一覧表ボディのITEMリスト
     * @return 主治医意見書作成依頼発行一覧表のReport
     */
    public static SyujiyikenshosakuseyiraihakouReport createFrom(
            SyujiyikenshosakuseyiraihakouHeadItem headItem,
            @NonNull List<SyujiyikenshosakuseyiraihakouBodyItem> itemList) {

        return new SyujiyikenshosakuseyiraihakouReport(
                headItem,
                itemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医意見書作成依頼発行一覧表ヘッダのITEM
     * @param itemList 主治医意見書作成依頼発行一覧表のITEMリスト
     */
    protected SyujiyikenshosakuseyiraihakouReport(
            SyujiyikenshosakuseyiraihakouHeadItem headItem,
            List<SyujiyikenshosakuseyiraihakouBodyItem> itemList) {

        this.headItem = headItem;
        this.bodyItemList = itemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> reportSourceWriter) {
        int renban = 0;
        RString breakKey = RString.EMPTY;
        for (SyujiyikenshosakuseyiraihakouBodyItem bodyItem : bodyItemList) {
            if (!breakKey.equals(setBreakKey(bodyItem))) {
                renban = 1;
            } else {
                renban++;
            }
            SyujiyikenshosakuseyiraihakouHeaderEditor headerEditor = new SyujiyikenshosakuseyiraihakouHeaderEditor(headItem);
            SyujiyikenshosakuseyiraihakouBodyEditor bodyEditor
                    = new SyujiyikenshosakuseyiraihakouBodyEditor(bodyItem, new RString(String.valueOf(renban)));
            ISyujiyikenshosakuseyiraihakouBuilder builder = new SyujiyikenshosakuseyiraihakouBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
            breakKey = setBreakKey(bodyItem);
        }
    }

    private RString setBreakKey(SyujiyikenshosakuseyiraihakouBodyItem item) {
        return new RStringBuilder().append(item.getListHakkoIchiranhyo_1_1()).
                append(item.getListHakkoIchiranhyo_1_2()).append(item.getListHakkoIchiranhyo_1_3()).toRString();
    }
}
