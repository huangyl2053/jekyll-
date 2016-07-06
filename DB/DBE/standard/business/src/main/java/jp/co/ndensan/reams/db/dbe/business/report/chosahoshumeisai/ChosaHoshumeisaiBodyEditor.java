/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.chosahoshumeisai;

import jp.co.ndensan.reams.db.dbe.business.core.chosahoshumeisai.ChosaHoshumeisaiBody;
import jp.co.ndensan.reams.db.dbe.entity.report.source.chosahoshumeisai.ChosaHoshumeisaiReportSource;

/**
 * 認定調査報酬支払明細書のEditorです。
 *
 * @reamsid_L DBE-1980-045 suguangjun
 */
public class ChosaHoshumeisaiBodyEditor implements IChosaHoshumeisaiBodyEditor {

    private final ChosaHoshumeisaiBody item;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link ChosaHoshumeisaiBody}
     */
    protected ChosaHoshumeisaiBodyEditor(ChosaHoshumeisaiBody item) {
        this.item = item;
    }

    @Override
    public ChosaHoshumeisaiReportSource edit(ChosaHoshumeisaiReportSource source) {
        return editSource(source);
    }

    private ChosaHoshumeisaiReportSource editSource(ChosaHoshumeisaiReportSource source) {
        source.listChosaSakusei_1 = item.getListChosaSakusei_1();
        source.listChosaSakusei_2 = item.getListChosaSakusei_2();
        source.listChosaSakusei_3 = item.getListChosaSakusei_3();
        source.listChosaSakusei_4 = item.getListChosaSakusei_4();
        source.listChosaSakusei_5 = item.getListChosaSakusei_5();
        source.listChosaSakusei_6 = item.getListChosaSakusei_6();
        source.listChosaSakusei_7 = item.getListChosaSakusei_7();
        source.listChosaSakusei_8 = item.getListChosaSakusei_8();
        source.listChosaSakusei_9 = item.getListChosaSakusei_9();
        source.listChosaSakusei_10 = item.getListChosaSakusei_10();
        source.listGokeikensu_1 = item.getListGokeikensu_1();
        source.listGokeikensu_2 = item.getListGokeikensu_2();
        source.listGokeikensu_3 = item.getListGokeikensu_3();
        source.listGokeikensu_4 = item.getListGokeikensu_4();
        source.listGokeiKingaku_1 = item.getListGokeiKingaku_1();
        return source;
    }
}
