/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.kojinshinchokujokyohyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.kojinshinchokujokyohyo.KojinShinchokuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 要介護認定個人進捗状況票のReportです。
 */
public class KojinShinchokuJokyohyoReport extends Report<KojinShinchokuJokyohyoReportSource> {

    private final List<KojinShinchokuJokyohyoBodyItem> bodyItemList;
    private final List<ChousaBodyItem> chousaItemList;
    private final List<ShuiBodyItem> shujiItemList;
    private final KojinShinchokuJokyohyoHeadItem headItem;
    private final int 循環_回数 = 3;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定個人進捗状況票ヘッダのITEM
     * @param chousaItemList 要介護認定個人進捗状況票調査員のITEMリスト
     * @param shujiItemList 要介護認定個人進捗状況票主治医のITEMリスト
     * @param bodyItemList 要介護認定個人進捗状況票ボディのITEMリスト
     * @return 要介護認定個人進捗状況票のReport
     */
    public static KojinShinchokuJokyohyoReport createFrom(
            KojinShinchokuJokyohyoHeadItem headItem,
            @NonNull List<ChousaBodyItem> chousaItemList,
            @NonNull List<ShuiBodyItem> shujiItemList,
            @NonNull List<KojinShinchokuJokyohyoBodyItem> bodyItemList) {

        return new KojinShinchokuJokyohyoReport(
                headItem,
                chousaItemList,
                shujiItemList,
                bodyItemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 要介護認定個人進捗状況票ヘッダのITEM
     * @param chousaItemList 要介護認定個人進捗状況票調査員のITEMリスト
     * @param shujiItemList 要介護認定個人進捗状況票主治医のITEMリスト
     * @param bodyItemList 要介護認定個人進捗状況票ボディのITEMリスト
     */
    protected KojinShinchokuJokyohyoReport(
            KojinShinchokuJokyohyoHeadItem headItem,
            List<ChousaBodyItem> chousaItemList,
            List<ShuiBodyItem> shujiItemList,
            List<KojinShinchokuJokyohyoBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.chousaItemList = chousaItemList;
        this.shujiItemList = shujiItemList;
        this.bodyItemList = bodyItemList;
    }

    @Override
    public void writeBy(ReportSourceWriter<KojinShinchokuJokyohyoReportSource> reportSourceWriter) {

        ChousaBodyEditor chousaEditor = null;
        ShuiBodyEditor shujiEditor = null;
        int index = 0;
        for (KojinShinchokuJokyohyoBodyItem bodyItem : bodyItemList) {
            KojinShinchokuJokyohyoHeadEditor headerEditor = new KojinShinchokuJokyohyoHeadEditor(headItem);
            if (index < 循環_回数) {
                chousaEditor = new ChousaBodyEditor(chousaItemList.get(index));
                shujiEditor = new ShuiBodyEditor(shujiItemList.get(index));
            }

            KojinShinchokuJokyohyoBodyEditor kojinshinEditor = new KojinShinchokuJokyohyoBodyEditor(bodyItem);
            KojinShinchokuJokyohyoBuilder builder = new KojinShinchokuJokyohyoBuilderImpl(headerEditor, chousaEditor, shujiEditor, kojinshinEditor);
            reportSourceWriter.writeLine(builder);
            index++;
        }
    }
}
