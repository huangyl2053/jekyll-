/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.futsuchoshukarisanteikekkaichiranreport;

import jp.co.ndensan.reams.db.dbb.entity.report.futsuchoshukarisanteikekkaichiranreport.FutsuChoshuKarisanteiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 普徴仮算定計算後賦課Builder
 *
 * @reamsid_L DBB-0870-030 surun
 */
public class FutsuChoshuKarisanteiKekkaIchiranBuilder implements
        IFutsuChoshuKarisanteiKekkaIchiranBuilder {

    private final IFutsuChoshuKarisanteiKekkaIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IFutsuChoshuKarisanteiKekkaIchiranEditor
     */
    public FutsuChoshuKarisanteiKekkaIchiranBuilder(IFutsuChoshuKarisanteiKekkaIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public FutsuChoshuKarisanteiKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new FutsuChoshuKarisanteiKekkaIchiranSource())
                .join(editor).buildSource();
    }

}
