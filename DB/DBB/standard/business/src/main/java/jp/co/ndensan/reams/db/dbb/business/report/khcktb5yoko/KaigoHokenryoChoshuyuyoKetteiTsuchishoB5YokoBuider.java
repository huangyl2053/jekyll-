/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.khcktb5yoko;

import jp.co.ndensan.reams.db.dbb.entity.report.khcktb5yoko.KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 介護保険料徴収猶予決定通知書B5横タイプ帳票Buider
 *
 * @reamsid_L DBB-0740-040 sunhui
 */
public class KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoBuider
        implements IKaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoBuider {

    private final KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoEditor
     */
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoBuider(
            KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource}
     */
    @Override
    public KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource build() {
        return ReportEditorJoiner.from(new KaigoHokenryoChoshuyuyoKetteiTsuchishoB5YokoSource())
                .join(editor).buildSource();
    }

}
