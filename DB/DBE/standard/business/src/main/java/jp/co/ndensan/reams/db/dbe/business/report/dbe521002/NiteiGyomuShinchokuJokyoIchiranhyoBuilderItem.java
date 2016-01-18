/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbe.business.report.dbe521002;

import jp.co.ndensan.reams.db.dbe.entity.report.dbe521002.NiteiGyomuShinchokuJokyoIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 要介護認定業務進捗状況一覧表Builderクラスです。
 */
public class NiteiGyomuShinchokuJokyoIchiranhyoBuilderItem implements INiteiGyomuShinchokuJokyoIchiranhyoBuilder {
    
    private final INiteiGyomuShinchokuJokyoIchiranhyoEditor  headEditor;
    private final INiteiGyomuShinchokuJokyoIchiranhyoEditor bodyEditor;
    
    /**
     * インスタンスを生成します。
     * @param headEditor {@link ItakusakiChosainIchiranEditor}
     * @param bodyEditor {@link ItakusakiChosainIchiranEditor}
     */
    public NiteiGyomuShinchokuJokyoIchiranhyoBuilderItem(INiteiGyomuShinchokuJokyoIchiranhyoEditor  headEditor,
            INiteiGyomuShinchokuJokyoIchiranhyoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
        this.headEditor = headEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public NiteiGyomuShinchokuJokyoIchiranhyoReportSource build() {
        return ReportEditorJoiner.from(new NiteiGyomuShinchokuJokyoIchiranhyoReportSource())
                .join(headEditor).join(bodyEditor).buildSource();
    }
    
}
