/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.itakusakichosainichiran;

import jp.co.ndensan.reams.db.dbe.entity.report.itakusakichosainichiran.ItakusakiChosainIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 認定調査委託先・認定調査員一覧表Builderクラスです。
 *
 * @reamsid_L DBE-0290-020 dongyabin
 */
public class ItakusakiChosainIchiranBuilderItem implements ItakusakiChosainIchiranBuilder {

    private final ItakusakiChosainIchiranEditor headEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link ItakusakiChosainIchiranEditor}
     */
    public ItakusakiChosainIchiranBuilderItem(ItakusakiChosainIchiranEditor headEditor) {
        this.headEditor = headEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public ItakusakiChosainIchiranReportSource build() {
        return ReportEditorJoiner.from(new ItakusakiChosainIchiranReportSource())
                .join(headEditor).buildSource();
    }

}
