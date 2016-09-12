/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehihanteierrorichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuservicehihanteierrorichiran.KogakuServicehiHanteiErrorIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMN41002_高額介護サービス費判定エラーリスト Builder
 *
 * @reamsid_L DBC-2010-110 sunhui
 */
public class KogakuServicehiHanteiErrorIchiranBuilder implements IKogakuServicehiHanteiErrorIchiranBuilder {

    private final IKogakuServicehiHanteiErrorIchiranEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IKogakuServicehiHanteiErrorIchiranEditor}
     */
    KogakuServicehiHanteiErrorIchiranBuilder(IKogakuServicehiHanteiErrorIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KogakuServicehiHanteiErrorIchiranSource}
     */
    @Override
    public KogakuServicehiHanteiErrorIchiranSource build() {
        return ReportEditorJoiner.from(new KogakuServicehiHanteiErrorIchiranSource()).join(editor).buildSource();
    }
}
