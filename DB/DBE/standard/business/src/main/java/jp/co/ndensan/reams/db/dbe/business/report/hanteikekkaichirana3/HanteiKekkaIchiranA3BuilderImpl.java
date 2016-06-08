/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.hanteikekkaichirana3;

import jp.co.ndensan.reams.db.dbe.entity.report.hanteikekkaichirana3.HanteiKekkaIchiranA3ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 要介護認定判定結果一覧表Ａ３版Builderのクラスです。
 *
 * @reamsid_L DBE-0180-050 xuyannan
 */
public class HanteiKekkaIchiranA3BuilderImpl implements IHanteiKekkaIchiranA3Builder {

    private final IHanteiKekkaIchiranA3Editor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link IHanteiKekkaIchiranA3Editor}
     */
    public HanteiKekkaIchiranA3BuilderImpl(IHanteiKekkaIchiranA3Editor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link HanteiKekkaIchiranA3ReportSource}
     */
    @Override
    public HanteiKekkaIchiranA3ReportSource build() {
        return ReportEditorJoiner.from(new HanteiKekkaIchiranA3ReportSource()).join(editor).buildSource();
    }

}
