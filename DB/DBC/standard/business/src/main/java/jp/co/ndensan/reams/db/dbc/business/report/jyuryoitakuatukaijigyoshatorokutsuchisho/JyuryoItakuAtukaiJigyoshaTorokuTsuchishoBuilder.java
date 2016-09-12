/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jyuryoitakuatukaijigyoshatorokutsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.jyuryoitakuatukaijigyoshatorokutsuchishosource.JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100032_介護保険受領委任払い取扱事業者登録通知書のBuilderクラスです。
 *
 * @reamsid_L DBC-2120-050 sunhui
 */
public class JyuryoItakuAtukaiJigyoshaTorokuTsuchishoBuilder
        implements IJyuryoItakuAtukaiJigyoshaTorokuTsuchishoBuilder {

    private final IJyuryoItakuAtukaiJigyoshaTorokuTsuchishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IJyuryoItakuAtukaiJigyoshaTorokuTsuchishoEditor}
     */
    JyuryoItakuAtukaiJigyoshaTorokuTsuchishoBuilder(IJyuryoItakuAtukaiJigyoshaTorokuTsuchishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource}
     */
    @Override
    public JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource build() {
        return ReportEditorJoiner.from(new JyuryoItakuAtukaiJigyoshaTorokuTsuchishoSource()).join(editor).buildSource();
    }
}
