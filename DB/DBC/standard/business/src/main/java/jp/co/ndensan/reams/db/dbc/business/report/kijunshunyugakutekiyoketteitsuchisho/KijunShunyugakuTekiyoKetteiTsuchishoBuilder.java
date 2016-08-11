/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoketteitsuchisho.KijunShunyugakuTekiyoKetteiTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票Builderクラスです。
 *
 * @reamsid_L DBC-4610-040 xuhao
 */
public class KijunShunyugakuTekiyoKetteiTsuchishoBuilder implements IKijunShunyugakuTekiyoKetteiTsuchishoBuilder {

    private final IKijunShunyugakuTekiyoKetteiTsuchishoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKijunShunyugakuTekiyoKetteiTsuchishoEditor
     */
    public KijunShunyugakuTekiyoKetteiTsuchishoBuilder(IKijunShunyugakuTekiyoKetteiTsuchishoEditor editor) {
        this.editor = editor;
    }

    @Override
    public KijunShunyugakuTekiyoKetteiTsuchishoSource build() {
        return ReportEditorJoiner.from(new KijunShunyugakuTekiyoKetteiTsuchishoSource()).join(editor).buildSource();
    }

}
