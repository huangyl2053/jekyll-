/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.shotokudankaibetsushunoritsuichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.dankaibetsushunoritsu.ShotokuDankaiBetsuShunoritsuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票Builderクラスです。
 *
 * @reamsid_L DBB-1630-040 tianshuai
 */
public class ShotokuDankaiBetsuShunoritsuIchiranBuilder implements IShotokuDankaiBetsuShunoritsuIchiranBuilder {

    private final IShotokuDankaiBetsuShunoritsuIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IShotokuDankaiBetsuShunoritsuIchiranEditor
     */
    public ShotokuDankaiBetsuShunoritsuIchiranBuilder(IShotokuDankaiBetsuShunoritsuIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public ShotokuDankaiBetsuShunoritsuIchiranSource build() {
        return ReportEditorJoiner.from(new ShotokuDankaiBetsuShunoritsuIchiranSource()).join(editor).buildSource();
    }
}
