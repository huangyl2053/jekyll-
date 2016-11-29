/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeishofrom2009;

import jp.co.ndensan.reams.db.dbc.entity.report.source.jikofutangakushomeishofrom2009.JikoFutangakushomeishoFrom2009ReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC100051_自己負担証明書_2009年以降 Builderするクラスです。
 *
 * @reamsid_L DBC-4810-040 kanghongsong
 */
public class JikoFutangakushomeishoFrom2009Builder implements IJikoFutangakushomeishoFrom2009Builder {

    private final JikoFutangakushomeishoFrom2009HeaderEditor headerEditor;
    private final JikoFutangakushomeishoFrom2009BodyEditor bodyEditor;
    private final CompSofubutsuAtesakiEditor atesakiEditor;
    private final CompNinshoshaEditor compNinshoshaEditor;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param headerEditor {@link JikoFutangakushomeishoFrom2009HeaderEditor}
     * @param bodyEditor {@link JikoFutangakushomeishoFrom2009BodyEditor}
     * @param atesakiEditor {@link CompSofubutsuAtesakiEditor}
     * @param compNinshoshaEditor {@link CompNinshoshaEditor}
     */
    public JikoFutangakushomeishoFrom2009Builder(JikoFutangakushomeishoFrom2009HeaderEditor headerEditor,
            JikoFutangakushomeishoFrom2009BodyEditor bodyEditor,
            CompSofubutsuAtesakiEditor atesakiEditor,
            CompNinshoshaEditor compNinshoshaEditor
    ) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
        this.atesakiEditor = atesakiEditor;
        this.compNinshoshaEditor = compNinshoshaEditor;
    }

    /**
     * 帳票ソースをビルドするメソッド。
     *
     * @return {@link JikoFutangakushomeishoFrom2009ReportSource}
     */
    @Override
    public JikoFutangakushomeishoFrom2009ReportSource build() {
        return ReportEditorJoiner.from(new JikoFutangakushomeishoFrom2009ReportSource())
                .join(headerEditor)
                .join(bodyEditor)
                .join(atesakiEditor)
                .join(compNinshoshaEditor)
                .buildSource();
    }

}
