/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.KogakuGassanJikofutangaku;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.GassanJikofutangakuShomeishoTorikomiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200034_高額合算自己負担額証明書情報取込一覧表のBuilderです。
 *
 * @reamsid_L DBC_2640_010 zhengshenlei
 */
public class KogakuGassanJikofutangakuShomeiBuilder implements IKogakuGassanJikofutangakuShomeiBuilder {

    private final IKogakuGassanJikofutangakuShomeiEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKyufujissekiKoshinkekkaIchiranEditor}
     */
    KogakuGassanJikofutangakuShomeiBuilder(IKogakuGassanJikofutangakuShomeiEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KyufujissekiKoshinkekkaIchiranSource}
     */
    @Override
    public GassanJikofutangakuShomeishoTorikomiIchiranSource build() {
        return ReportEditorJoiner.from(new GassanJikofutangakuShomeishoTorikomiIchiranSource()).join(editor).buildSource();
    }

}
