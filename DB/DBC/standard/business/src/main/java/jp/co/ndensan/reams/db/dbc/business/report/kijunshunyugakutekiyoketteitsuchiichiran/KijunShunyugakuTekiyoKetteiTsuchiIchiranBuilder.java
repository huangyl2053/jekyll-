/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchiichiran.KijunShunyugakuTekiyoKetteiTsuchiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票Builderクラスです。
 *
 * @reamsid_L DBC-4610-050 xuhao
 */
public class KijunShunyugakuTekiyoKetteiTsuchiIchiranBuilder implements IKijunShunyugakuTekiyoKetteiTsuchiIchiranBuilder {

    private final IKijunShunyugakuTekiyoKetteiTsuchiIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKijunShunyugakuTekiyoKetteiTsuchishoEditor
     */
    public KijunShunyugakuTekiyoKetteiTsuchiIchiranBuilder(IKijunShunyugakuTekiyoKetteiTsuchiIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public KijunShunyugakuTekiyoKetteiTsuchiIchiranSource build() {
        return ReportEditorJoiner.from(new KijunShunyugakuTekiyoKetteiTsuchiIchiranSource()).join(editor).buildSource();
    }
}
