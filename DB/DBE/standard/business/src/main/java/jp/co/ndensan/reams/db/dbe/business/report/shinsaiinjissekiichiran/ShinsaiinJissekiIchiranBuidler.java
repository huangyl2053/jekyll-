/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.shinsaiinjissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護認定審査会委員報酬実績集計表のBuidlerです。
 *
 * @reamsid_L DBE-1700-020 wanghuafeng
 */
class ShinsaiinJissekiIchiranBuidler implements IShinsaiinJissekiIchiranBuidler {

    private final IShinsaiinJissekiIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IShinsaiinJissekiIchiranEditor}
     */
    public ShinsaiinJissekiIchiranBuidler(IShinsaiinJissekiIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShinsaiinJissekiIchiranReportSource}
     */
    @Override
    public ShinsaiinJissekiIchiranReportSource build() {
        return ReportEditorJoiner.from(new ShinsaiinJissekiIchiranReportSource()).join(editor).buildSource();
    }

}
