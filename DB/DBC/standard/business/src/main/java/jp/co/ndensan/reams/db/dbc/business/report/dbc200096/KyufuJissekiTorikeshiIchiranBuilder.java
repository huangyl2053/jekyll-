/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200096;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200096.KyufuJissekiTorikeshiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200096_給付実績取消一覧表Builder
 *
 * @reamsid_L DBC-4960-050 jiangxiaolong
 */
public class KyufuJissekiTorikeshiIchiranBuilder
        implements IKyufuJissekiTorikeshiIchiranBuilder {

    private final IKyufuJissekiTorikeshiIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public KyufuJissekiTorikeshiIchiranBuilder(
            IKyufuJissekiTorikeshiIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KyufuJissekiTorikeshiIchiranSource build() {
        return ReportEditorJoiner.from(new KyufuJissekiTorikeshiIchiranSource())
                .join(bodyEditor).buildSource();
    }

}
