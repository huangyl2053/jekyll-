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
 *
 * @reamsid_L DBE-0080-100 lizhuoxuan
 */
public class SyujiyikenshosakuseyiraihakouReport extends Report<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> {

    private final List<SyujiyikenshosakuseyiraihakouBodyItem> bodyItemList;
    private final SyujiyikenshosakuseyiraihakouBodyItem bodyItem;
    private final SyujiyikenshosakuseyiraihakouHeadItem headItem;
    private final int count;

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
                null,
                itemList,
                0);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医意見書作成依頼発行一覧表ヘッダのITEM
     * @param bodyItem 主治医意見書作成依頼発行一覧表ボディのITEM
     * @param count count
     * @return 主治医意見書作成依頼発行一覧表のReport
     */
    public static SyujiyikenshosakuseyiraihakouReport createFrom(
            SyujiyikenshosakuseyiraihakouHeadItem headItem,
            SyujiyikenshosakuseyiraihakouBodyItem bodyItem,
            int count) {

        return new SyujiyikenshosakuseyiraihakouReport(
                headItem,
                bodyItem,
                null,
                count);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 主治医意見書作成依頼発行一覧表ヘッダのITEM
     * @param bodyItem 主治医意見書作成依頼発行一覧表のITEM
     * @param itemList 主治医意見書作成依頼発行一覧表のITEMリスト
     * @param count count
     */
    protected SyujiyikenshosakuseyiraihakouReport(
            SyujiyikenshosakuseyiraihakouHeadItem headItem,
            SyujiyikenshosakuseyiraihakouBodyItem bodyItem,
            List<SyujiyikenshosakuseyiraihakouBodyItem> itemList,
            int count) {

        this.headItem = headItem;
        this.bodyItem = bodyItem;
        this.bodyItemList = itemList;
        this.count = count;
    }

    @Override
    public void writeBy(ReportSourceWriter<IkenshoSakuseiIraiHakkoIchiranhyoReportSource> reportSourceWriter) {
        if (bodyItemList != null) {
            int renban = 0;
            RString breakKey = RString.EMPTY;
            for (SyujiyikenshosakuseyiraihakouBodyItem item : bodyItemList) {
                if (!breakKey.equals(setBreakKey(bodyItem))) {
                    renban = 1;
                } else {
                    renban++;
                }
                SyujiyikenshosakuseyiraihakouHeaderEditor headerEditor = new SyujiyikenshosakuseyiraihakouHeaderEditor(headItem);
                SyujiyikenshosakuseyiraihakouBodyEditor bodyEditor
                        = new SyujiyikenshosakuseyiraihakouBodyEditor(item, new RString(String.valueOf(renban)));
                ISyujiyikenshosakuseyiraihakouBuilder builder = new SyujiyikenshosakuseyiraihakouBuilderImpl(headerEditor, bodyEditor);
                reportSourceWriter.writeLine(builder);
                breakKey = setBreakKey(item);
            }
        } else {
            SyujiyikenshosakuseyiraihakouHeaderEditor headerEditor = new SyujiyikenshosakuseyiraihakouHeaderEditor(headItem);
            SyujiyikenshosakuseyiraihakouBodyEditor bodyEditor
                    = new SyujiyikenshosakuseyiraihakouBodyEditor(bodyItem, new RString(String.valueOf(count)));
            ISyujiyikenshosakuseyiraihakouBuilder builder = new SyujiyikenshosakuseyiraihakouBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }

    private RString setBreakKey(SyujiyikenshosakuseyiraihakouBodyItem item) {
        if (item != null) {
            return new RStringBuilder().append(item.getListHakkoIchiranhyo_1_1()).
                    append(item.getListHakkoIchiranhyo_1_2()).append(item.getListHakkoIchiranhyo_1_3()).toRString();
        } else {
            return RString.EMPTY;
        }
    }
}
