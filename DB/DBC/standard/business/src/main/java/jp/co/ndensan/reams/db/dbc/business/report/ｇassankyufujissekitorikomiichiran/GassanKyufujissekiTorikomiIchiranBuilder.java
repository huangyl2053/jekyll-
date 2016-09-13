/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.ｇassankyufujissekitorikomiichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.gassankyufujissekitorikomiichiran.GassanKyufujissekiTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額合算給付実績情報取込一覧表Builderクラスです。
 *
 * @reamsid_L DBC-2700-030 wangxingpeng
 */
public class GassanKyufujissekiTorikomiIchiranBuilder implements IGassanKyufujissekiTorikomiIchiranBuilder {

    private final IGassanKyufujissekiTorikomiIchiranEditor headerEditor;
    private final IGassanKyufujissekiTorikomiIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IGassanKyufujissekiTorikomiIchiranEditor
     * @param bodyEditor IGassanKyufujissekiTorikomiIchiranEditor
     */
    public GassanKyufujissekiTorikomiIchiranBuilder(IGassanKyufujissekiTorikomiIchiranEditor headerEditor,
            IGassanKyufujissekiTorikomiIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public GassanKyufujissekiTorikomiIchiranSource build() {
        return ReportEditorJoiner.from(new GassanKyufujissekiTorikomiIchiranSource())
                .join(headerEditor).join(bodyEditor).buildSource();

    }

}
