/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsuhihokenshasuichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.shotokudankaibetsuhihokenshasuichiran.ShotokuDankaiBetsuHihokenshasuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 段階別被保険者数一覧表帳票クラスです。
 *
 * @reamsid_L DBB-1820-060 zhouchuanlin
 */
public class ShotokuDankaiBetsuHihokenshasuIchiranBuilder implements IShotokuDankaiBetsuHihokenshasuIchiranBuilder {

    private final IShotokuDankaiBetsuHihokenshasuIchiranEditor headerEditor;
    private final IShotokuDankaiBetsuHihokenshasuIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headerEditor headerEditor
     * @param bodyEditor bodyEditor
     */
    public ShotokuDankaiBetsuHihokenshasuIchiranBuilder(IShotokuDankaiBetsuHihokenshasuIchiranEditor headerEditor,
            IShotokuDankaiBetsuHihokenshasuIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShotokuDankaiBetsuHihokenshasuIchiranSource}
     */
    @Override
    public ShotokuDankaiBetsuHihokenshasuIchiranSource build() {
        return ReportEditorJoiner.from(new ShotokuDankaiBetsuHihokenshasuIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
