/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.entity.db.report.source.sogojigyohisaishinsaketteihokenshain.SogojigyohiSaishinsaKetteiHokenshaInSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費再審査決定通知書情報取込一覧表（保険者分）帳票Builder
 *
 * @reamsid_L DBC-4680-040 wangxue
 */
public class SogojigyohiSaishinsaKetteiHokenshaInBuilder implements ISogojigyohiSaishinsaKetteiHokenshaInBuilder {

    private final ISogojigyohiSaishinsaKetteiHokenshaInEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor
     */
    public SogojigyohiSaishinsaKetteiHokenshaInBuilder(ISogojigyohiSaishinsaKetteiHokenshaInEditor editor) {
        this.editor = editor;
    }

    @Override
    public SogojigyohiSaishinsaKetteiHokenshaInSource build() {
        return ReportEditorJoiner.from(new SogojigyohiSaishinsaKetteiHokenshaInSource()).
                join(editor).
                buildSource();
    }

}
