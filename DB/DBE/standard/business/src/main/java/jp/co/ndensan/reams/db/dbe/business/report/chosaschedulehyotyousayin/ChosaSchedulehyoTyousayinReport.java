/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosaschedulehyotyousayin;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosaschedulehyotyousayin.ChosaSchedulehyoTyousayinReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 *
 * 認定調査スケジュール表(調査員)のReportです。
 */
public class ChosaSchedulehyoTyousayinReport extends Report<ChosaSchedulehyoTyousayinReportSource> {

    private final List<ChosaSchedulehyoTyousayinBodyItem> bodyItemList;
    private final ChosaSchedulehyoTyousayinHeadItem headItem;

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査スケジュール表(調査員)ヘッダのITEM
     * @param bodyItemList 認定調査スケジュール表(調査員)ボディのITEMリスト
     * @return 認定調査スケジュール表(調査員)のReport
     */
    public static ChosaSchedulehyoTyousayinReport createFrom(
            ChosaSchedulehyoTyousayinHeadItem headItem,
            @NonNull List<ChosaSchedulehyoTyousayinBodyItem> bodyItemList) {

        return new ChosaSchedulehyoTyousayinReport(
                headItem,
                bodyItemList);
    }

    /**
     * インスタンスを生成します。
     *
     * @param headItem 認定調査スケジュール表(調査員)ヘッダのITEM
     * @param bodyItemList 認定調査スケジュール表(調査員)ボディのITEMリスト
     */
    protected ChosaSchedulehyoTyousayinReport(
            ChosaSchedulehyoTyousayinHeadItem headItem,
            List<ChosaSchedulehyoTyousayinBodyItem> bodyItemList) {

        this.headItem = headItem;
        this.bodyItemList = bodyItemList;
    }

    /**
     *
     * @param reportSourceWriter 認定調査スケジュール表(調査員)Sourceクラス
     */
    @Override
    public void writeBy(ReportSourceWriter<ChosaSchedulehyoTyousayinReportSource> reportSourceWriter) {
        for (ChosaSchedulehyoTyousayinBodyItem bodyItem : bodyItemList) {
            IChosaSchedulehyoTyousayinEditor headerEditor = new ChosaSchedulehyoTyousayinHeaderEditor(headItem);
            IChosaSchedulehyoTyousayinEditor bodyEditor = new ChosaSchedulehyoTyousayinBodyEditor(bodyItem);
            IChosaSchedulehyoTyousayinBuilder builder = new ChosaSchedulehyoTyousayinBuilderImpl(headerEditor, bodyEditor);
            reportSourceWriter.writeLine(builder);
        }
    }
}
