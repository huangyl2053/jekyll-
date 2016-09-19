/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300002;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd300002.JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 受給者減免月別認定者数状況表Builderクラスです。
 *
 * @reamsid_L DBD-3770-050 jinge
 */
public class JukyushaGemmenTsukibetsuNinteishasuJokyohyoBuilder implements IJukyushaGemmenTsukibetsuNinteishasuJokyohyoBuilder {

    private final IJukyushaGemmenTsukibetsuNinteishasuJokyohyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IJukyushaGemmenTsukibetsuNinteishasuJokyohyoEditor}
     */
    JukyushaGemmenTsukibetsuNinteishasuJokyohyoBuilder(IJukyushaGemmenTsukibetsuNinteishasuJokyohyoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource}
     */
    @Override
    public JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource build() {
        return ReportEditorJoiner.from(new JukyushaGemmenTsukibetsuNinteishasuJokyohyoReportSource()).join(bodyEditor).buildSource();
    }
}
