/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.gassanshikyugakukakuninichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.gassanshikyugakukakuninichiran.GassanShikyugakuKakuninIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 高額合算支給額計算結果連絡票情報確認リストのBuilderクラスです。
 *
 * @reamsid_L DBC-2680-031 qinzhen
 */
public class GassanShikyugakuKakuninIchiranBuilder implements IGassanShikyugakuKakuninIchiranBuilder {

    private final IGassanShikyugakuKakuninIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IGassanShikyugakuKakuninIchiranEditor
     */
    public GassanShikyugakuKakuninIchiranBuilder(IGassanShikyugakuKakuninIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public GassanShikyugakuKakuninIchiranSource build() {
        return ReportEditorJoiner.from(new GassanShikyugakuKakuninIchiranSource())
                .join(editor).buildSource();
    }
}
