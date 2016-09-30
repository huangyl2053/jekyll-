/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kaigokyufuhikagomoshitateshoout;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaigokyufuhikagomoshitateshoout.KyufuKagoMoshitateshojohoSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 給付過誤申立書情報送付一覧表帳票Builderクラスです
 *
 * @reamsid_L DBC-2530-040 jiangwenkai
 */
public class KaigokyufuhiKagoMoshitateshoOutBuilder implements IKaigokyufuhiKagoMoshitateshoOutBuilder {

    private final IKaigokyufuhiKagoMoshitateshoOutEditor headerEditor;
    private final IKaigokyufuhiKagoMoshitateshoOutEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IKaigokyufuhiKagoMoshitateshoOutEditor
     * @param bodyEditor IKaigokyufuhiKagoMoshitateshoOutEditor
     */
    public KaigokyufuhiKagoMoshitateshoOutBuilder(
            IKaigokyufuhiKagoMoshitateshoOutEditor headerEditor,
            IKaigokyufuhiKagoMoshitateshoOutEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KyufuKagoMoshitateshojohoSofuIchiranSource build() {
        return ReportEditorJoiner.from(new KyufuKagoMoshitateshojohoSofuIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
