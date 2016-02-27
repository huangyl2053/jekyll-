/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_16;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_16.NonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書_連帳 NonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder
 */
public class NonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder implements INonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder {

    private final INonyuTsuchishoBookFuriKaeAriRenchoCoverEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link INonyuTsuchishoBookFuriKaeAriRenchoCoverEditor}
     */
    public NonyuTsuchishoBookFuriKaeAriRenchoCoverBuilder(INonyuTsuchishoBookFuriKaeAriRenchoCoverEditor editor) {
        this.editor = editor;
    }

    @Override
    public NonyuTsuchishoBookFuriKaeAriRenchoCoverSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchishoBookFuriKaeAriRenchoCoverSource()).join(editor).buildSource();
    }

}
