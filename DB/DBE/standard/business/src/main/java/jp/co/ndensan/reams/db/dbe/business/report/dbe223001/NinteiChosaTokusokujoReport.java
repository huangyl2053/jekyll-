/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.dbe223001;

import jp.co.ndensan.reams.db.dbe.entity.report.dbe223001.NinteiChosaTokusokujoReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import lombok.NonNull;

/**
 * 認定調査督促状のReportです。
 *
 * @reamsid_L DBE-0030-020 xuyue
 */
public class NinteiChosaTokusokujoReport extends Report<NinteiChosaTokusokujoReportSource> {

    private final NinteiChosaTokusokujoBodyItem bodyItem;

    /**
     * フォームを生成します。
     *
     * @param item 認定調査督促状ボディのITEMリスト
     * @return 認定調査督促状のReport
     */
    public static NinteiChosaTokusokujoReport createFrom(@NonNull NinteiChosaTokusokujoBodyItem item) {

        return new NinteiChosaTokusokujoReport(item);
    }

    /**
     * コンストラクタです。
     *
     * @param item 認定調査督促状のITEM
     */
    protected NinteiChosaTokusokujoReport(NinteiChosaTokusokujoBodyItem item) {

        this.bodyItem = item;
    }

    @Override
    public void writeBy(ReportSourceWriter<NinteiChosaTokusokujoReportSource> reportSourceWriter) {

        INinteiChosaTokusokujoEditor bodyEditor = new NinteiChosaTokusokujoBodyEditor(bodyItem);
        INinteiChosaTokusokujoBuilder builder = new NinteiChosaTokusokujoBuilderImpl(bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
