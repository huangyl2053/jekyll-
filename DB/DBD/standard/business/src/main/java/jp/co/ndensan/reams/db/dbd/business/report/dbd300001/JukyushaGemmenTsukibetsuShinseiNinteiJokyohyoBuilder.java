/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd300001;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd300001.JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 受給者減免月別申請・認定状況表Builderクラスです。
 *
 * @reamsid_L DBD-3770-040 b_liuyang2
 */
public class JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoBuilder implements IJukyushaGemmenTsukibetsuShinseiNinteiJokyohyoBuilder {

    private final IJukyushaGemmenTsukibetsuShinseiNinteiJokyohyoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IJukyushaGemmenTsukibetsuShinseiNinteiJokyohyoEditor}
     */
    JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoBuilder(IJukyushaGemmenTsukibetsuShinseiNinteiJokyohyoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource}
     */
    @Override
    public JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource build() {
        return ReportEditorJoiner.from(new JukyushaGemmenTsukibetsuShinseiNinteiJokyohyoReportSource()).join(bodyEditor).buildSource();
    }
}
