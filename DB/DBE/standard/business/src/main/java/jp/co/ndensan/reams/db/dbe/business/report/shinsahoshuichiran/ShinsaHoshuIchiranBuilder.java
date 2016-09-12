/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsahoshuichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.shinsahoshuichiran.ShinsaHoshuIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会委員報酬一覧表Builderクラスです。
 *
 * @reamsid_L DBE-1920-030 zhaoyao
 */
class ShinsaHoshuIchiranBuilder implements IShinsaHoshuIchiranBuilder {

    private final IShinsaHoshuIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsaHoshuIchiranEditor}
     */
    public ShinsaHoshuIchiranBuilder(IShinsaHoshuIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsaHoshuIchiranReportSource}
     */
    @Override
    public ShinsaHoshuIchiranReportSource build() {
        return ReportEditorJoiner.from(new ShinsaHoshuIchiranReportSource()).join(editor).buildSource();
    }
}
