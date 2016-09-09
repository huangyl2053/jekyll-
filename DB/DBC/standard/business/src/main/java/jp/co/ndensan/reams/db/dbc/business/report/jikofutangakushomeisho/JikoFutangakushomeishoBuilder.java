/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.jikofutangakushomeisho;

import jp.co.ndensan.reams.db.dbc.entity.report.jikofutangakushomeisho.JikoFutangakushomeishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 自己負担証明書のBuilderです。
 *
 * @reamsid_L DBC-4810-030 sunhaidi
 */
public class JikoFutangakushomeishoBuilder implements IJikoFutangakushomeishoBuilder {

    private final JikoFutangakushomeishoHeaderEditor headerEditor;
    private final JikoFutangakushomeishoBodyEditor bodyEditor;
    private final CompSofubutsuAtesakiEditor atesakiEditor;
    private final CompNinshoshaEditor compNinshoshaEditor;
    private final CompKaigoToiawasesakiEditor toiawasesakiEditor;

    /**
     * インスタンスを生成するメソッド。
     *
     * @param headerEditor {@link JikoFutangakushomeishoHeaderEditor}
     * @param bodyEditor {@link JikoFutangakushomeishoBodyEditor}
     * @param atesakiEditor {@link CompSofubutsuAtesakiEditor}
     * @param compNinshoshaEditor {@link CompNinshoshaEditor}
     * @param toiawasesakiEditor {@link CompKaigoToiawasesakiEditor}
     */
    public JikoFutangakushomeishoBuilder(JikoFutangakushomeishoHeaderEditor headerEditor,
            JikoFutangakushomeishoBodyEditor bodyEditor,
            CompSofubutsuAtesakiEditor atesakiEditor,
            CompNinshoshaEditor compNinshoshaEditor,
            CompKaigoToiawasesakiEditor toiawasesakiEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
        this.atesakiEditor = atesakiEditor;
        this.compNinshoshaEditor = compNinshoshaEditor;
        this.toiawasesakiEditor = toiawasesakiEditor;
    }

    /**
     * 帳票ソースをビルドするメソッド。
     *
     * @return {@link JikoFutangakushomeishoReportSource}
     */
    @Override
    public JikoFutangakushomeishoReportSource build() {
        return ReportEditorJoiner.from(new JikoFutangakushomeishoReportSource())
                .join(headerEditor)
                .join(bodyEditor)
                .join(atesakiEditor)
                .join(compNinshoshaEditor)
                .join(toiawasesakiEditor)
                .buildSource();
    }
}
