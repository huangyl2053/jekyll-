/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehihanteierrorichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakusogojigyoservicehihanteierrorichiran.KogakuSogoJigyoServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN41002_高額総合事業サービス費判定エラーリスト Builder
 *
 * @reamsid_L DBC-2010-130 sunhui
 */
public class KogakuSogoJigyoServicehiHanteiErrorIchiranBuilder
        implements IKogakuSogoJigyoServicehiHanteiErrorIchiranBuilder {

    private final IKogakuSogoJigyoServicehiHanteiErrorIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKogakuSogoJigyoServicehiHanteiErrorIchiranEditor}
     */
    KogakuSogoJigyoServicehiHanteiErrorIchiranBuilder(IKogakuSogoJigyoServicehiHanteiErrorIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KogakuSogoJigyoServicehiHanteiErrorIchiranSource}
     */
    @Override
    public KogakuSogoJigyoServicehiHanteiErrorIchiranSource build() {
        return ReportEditorJoiner.from(new KogakuSogoJigyoServicehiHanteiErrorIchiranSource()).join(editor).buildSource();
    }
}
