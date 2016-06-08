/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.honsanteikekkaicihiran;

import jp.co.ndensan.reams.db.dbb.entity.report.honsanteikekkaicihiran.HonsanteiKekkaIcihiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 「本算定賦課計算」Builderクラスです。
 *
 * @reamsid_L DBB-0730-030 lijunjun
 */
public class HonsanteiKekkaIcihiranBuilder implements IHonsanteiKekkaIcihiranBuilder {

    private final IHonsanteiKekkaIcihiranEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IHonsanteiKekkaIcihiranEditor
     */
    public HonsanteiKekkaIcihiranBuilder(IHonsanteiKekkaIcihiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public HonsanteiKekkaIcihiranReportSource build() {
        return ReportEditorJoiner.from(new HonsanteiKekkaIcihiranReportSource()).join(editor).buildSource();
    }

}
