/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料徴収猶予決定通知書A4縦タイプ帳票Buider。
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider
        implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider {

    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor
     */
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateBuider(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource}
     */
    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource build() {
        return ReportEditorJoiner.from(
                new KaigoHokenryoChoshuyuyoKetteiTsuchishoA4TateSource()).join(editor).buildSource();
    }

}
