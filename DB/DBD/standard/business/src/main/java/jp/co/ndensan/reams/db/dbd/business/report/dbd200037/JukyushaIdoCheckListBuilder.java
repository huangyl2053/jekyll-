/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200037;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200037.JukyushaIdoCheckListReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 受給者台帳異動チェックリストBuilderクラスです。
 *
 * @reamsid_L DBD-1770-030 donghj
 */
public class JukyushaIdoCheckListBuilder implements IJukyushaIdoCheckListBuilder {

    private final IJukyushaIdoCheckListEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJukyushaIdoCheckListEditor}
     */
    JukyushaIdoCheckListBuilder(IJukyushaIdoCheckListEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukyushaIdoCheckListReportSource}
     */
    @Override
    public JukyushaIdoCheckListReportSource build() {
        return ReportEditorJoiner.from(new JukyushaIdoCheckListReportSource()).join(editor).buildSource();
    }

}
